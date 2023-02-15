package com.example.untitleddiscordbot.listeners;

import com.example.untitleddiscordbot.data.Settings.ChannelPermissionsModel;
import com.example.untitleddiscordbot.data.Settings.SettingsModel;
import com.example.untitleddiscordbot.repository.SettingsRepository;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.restaction.MessageCreateAction;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;

public class MyEventListener extends ListenerAdapter {

    private SettingsRepository settingsRepository;

    public MyEventListener(SettingsRepository repository) {
        settingsRepository = repository;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message message = event.getMessage();

        Mentions mentions = message.getMentions();

        String prefix = "-";
        SettingsModel model = settingsRepository.findByGuildId(event.getGuild().getId());
        if (model != null && model.getPrefix() != null)
            prefix = model.getPrefix();

        //check if the message is a command

        if (message.getContentRaw().startsWith(prefix) && !message.getAuthor().isBot()) {
            String command = message.getContentRaw().substring(prefix.length());
            MessageCreateAction action;
            if (!isRestricted(event))
                switch (command) {
                    case "ping" -> action = event.getChannel().sendMessage("Pong!");
                    case "help" -> action = event.getChannel().sendMessage("Help command");
                    default -> action = event.getChannel().sendMessage("Unknown command");
                }
            else
                action = event.getChannel().sendMessage("You do not have required permissions to use this command");

            action.queue(message1 -> {
                //check settings for autodelete
                if(model != null && model.isAutoDeleteResponseEnabled()){
                    new Timer().schedule(
                            new TimerTask() {
                                @Override
                                public void run() {
                                    //delete message
                                    message1.delete().queue();
                                }
                            }, (model.getAutoDeleteResponse() * 1000L)
                    );
                }
            });
            //check settings for autodelete
            if(model != null && model.isAutoDeleteTriggerEnabled()){
                new Timer().schedule(
                        new TimerTask() {
                            @Override
                            public void run() {
                                //delete message
                                message.delete().queue();
                            }
                        }, (model.getAutoDeleteTrigger() * 1000L)
                );
            }
        }
    }

    boolean isRestricted(MessageReceivedEvent event) {
        Member member = event.getMember();
        List<Role> roleList = member.getRoles();
        String guildID = event.getGuild().getId();
        String channelID = event.getChannel().getId();

        SettingsModel settings = settingsRepository.findByGuildId(guildID);
        ChannelPermissionsModel channelPermissionModel = null;

        boolean isRestricted = false;
        boolean defaultRestriction = false;

        if (settings == null)
            return false;

        if (settings.getChannelPermissions() != null) {
            channelPermissionModel = settings.getChannelPermissions()
                    .stream()
                    .filter(x -> x.getChannelId().equals(channelID))
                    .findFirst()
                    .orElse(null);
        }

        //check channel permissions
        //if there is not any permissions selected for the channel

        //apply the default settings

        List<String> requiredRoles = settings.getRequiredRoleIds();
        List<String> ignoredRoles = settings.getIgnoredRoleIds();

        //check if user has one of the required roles or if it ie everyone
        defaultRestriction = checkRequired(event, roleList, requiredRoles);

        //check if there are ignored roles and if so check the user if he has one of them
        //if he is already restricted skip

        if (ignoredRoles != null && !ignoredRoles.isEmpty() && !defaultRestriction) {
            for (String id : ignoredRoles) {
                Role role = event.getGuild().getRoleById(id);
                if (role != null && (role.isPublicRole() || roleList.stream().map(Role::getId).anyMatch(x -> x.equals(id)))) {
                    defaultRestriction = true;
                    break;
                }
            }
        }

        isRestricted = defaultRestriction;


        if (channelPermissionModel != null && (channelPermissionModel.isChecked() || channelPermissionModel.isGrouped())) { //channel permissions is overwritten, apply them and ignore the default settings

            List<String> requiredChannelRoles = channelPermissionModel.getRequiredRoleIds();
            List<String> memberIds = channelPermissionModel.getMemberIds();


            //check if user has one of the required roles or if it is everyone only if above lists are empty and channel has not
            //overwritten permissions
            if((requiredChannelRoles == null || requiredChannelRoles.isEmpty()) && (memberIds == null || memberIds.isEmpty())) {
                //check if there are category permissions
                if(channelPermissionModel.isGrouped()){
                    String parentId = channelPermissionModel.getParentId();
                    //override the channel permissions with the category permissions
                    channelPermissionModel = settings.getChannelPermissions()
                            .stream()
                            .filter(x -> x.getChannelId().equals(parentId))
                            .findFirst()
                            .orElse(new ChannelPermissionsModel());
                    //channel can not be null because it is a category, so it has to accessible based on the isGroup flag
                    requiredChannelRoles = channelPermissionModel.getRequiredRoleIds();
                    memberIds = channelPermissionModel.getMemberIds();
                }else
                    return isRestricted;
            }

            isRestricted = checkRequired(event, roleList, requiredChannelRoles);
            if(!isRestricted && !requiredChannelRoles.isEmpty())
                return false;
            //if user has the required role, there is no need to check if he is listed on the member list
            //otherwise check if he is listed on the member list
            if(memberIds != null && !memberIds.isEmpty()){
                isRestricted = memberIds.stream().noneMatch(x -> x.equals(member.getId()));
            }
        }


        return isRestricted;
    }

    private boolean checkRequired(MessageReceivedEvent event, List<Role> roleList, List<String> requiredRoles) {
        boolean isRestricted = true;
        if (requiredRoles != null && !requiredRoles.isEmpty()) {
            for (String id : requiredRoles) {
                Role role = event.getGuild().getRoleById(id);
                if (role != null && (role.isPublicRole() || roleList.stream().map(Role::getId).anyMatch(x -> x.equals(id)))) {
                    isRestricted = false;
                    break;
                }
            }
        }else{
            return false;
        }
        return isRestricted;
    }
}
