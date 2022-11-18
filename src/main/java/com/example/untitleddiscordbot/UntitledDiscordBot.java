package com.example.untitleddiscordbot;

import com.example.untitleddiscordbot.listeners.EventListener;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.security.auth.login.LoginException;

public class UntitledDiscordBot {

    private final Dotenv config;
    private static UntitledDiscordBot instance;

    public static UntitledDiscordBot getInstance() {
        if(instance == null){
            try {
                instance = new UntitledDiscordBot();
            } catch (LoginException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }


    public ShardManager getShardManager() {
        return shardManager;
    }

    private final ShardManager shardManager;

    private UntitledDiscordBot() throws LoginException {
        config = Dotenv.configure().load();
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(config.get("TOKEN"));
        shardManager = builder.build();

        //Register listeners

        shardManager.addEventListener(new EventListener());
    }




}
