package com.example.untitleddiscordbot.listeners;

import com.example.untitleddiscordbot.data.Settings.SettingsModel;
import com.example.untitleddiscordbot.repository.SettingsRepository;
import net.dv8tion.jda.api.entities.Mentions;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MyEventListener extends ListenerAdapter {

    private SettingsRepository settingsRepository;
    public MyEventListener(SettingsRepository repository) {
        settingsRepository = repository;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message message = event.getMessage();
        User user = message.getAuthor();
        Mentions mentions = message.getMentions();
        String guildID = event.getGuild().getId();
        boolean isRestricted = settingsRepository == null;
        SettingsModel settings = settingsRepository.findByGuildId(guildID);
        System.out.println(isRestricted ? "apiController is null" : "apiController is not null");
        if (message.getContentRaw().equals("-ping")) {
            if (!isRestricted)
                event.getChannel().sendMessage("Pong!").queue();
        }
    }
}
