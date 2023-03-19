package com.example.untitleddiscordbot;

import com.example.untitleddiscordbot.configuration.BeanConfig;
import com.example.untitleddiscordbot.controller.ApiController;

import com.example.untitleddiscordbot.listeners.MyEventListener;
import com.example.untitleddiscordbot.repository.SettingsRepository;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UntitledDiscordBot {

    private final ShardManager shardManager;
    private final Dotenv config;
    private SettingsRepository settingsRepository;

    public ShardManager getShardManager() {
        return shardManager;
    }

    @Autowired
    public UntitledDiscordBot(SettingsRepository repository) {
        config = Dotenv.configure().load();
        settingsRepository = repository;
        try {
            DefaultShardManagerBuilder builder = DefaultShardManagerBuilder
                    .createDefault(config.get("TOKEN"))
                    .enableIntents(GatewayIntent.GUILD_MEMBERS)
                    .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                    .enableIntents(GatewayIntent.GUILD_MESSAGES);
            ;
            shardManager = builder.build();
            //Register listeners
            shardManager.addEventListener(new MyEventListener(settingsRepository));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to login to discord");
        }
    }
}
