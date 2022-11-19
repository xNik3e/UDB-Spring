package com.example.untitleddiscordbot.controller;

import com.example.untitleddiscordbot.UntitledDiscordBot;
import com.example.untitleddiscordbot.services.AsyncService;
import com.example.untitleddiscordbot.templates.ResponseHandler;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.sharding.ShardManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class ApiController {





    private UntitledDiscordBot bot = UntitledDiscordBot.getInstance();
    private final Dotenv config = Dotenv.configure().load();

    @Autowired
    private AsyncService asyncService;

    @Autowired
    private ConfigurableApplicationContext context;

    @PostMapping("api/getGuildsByIds")
    public ResponseEntity<Object> getGuildsByIds(@RequestBody(required = true) List<String> ids){
        if(ids != null){
            ShardManager shardManager = bot.getShardManager();
            List<String> guilds = new ArrayList<>();
            for(String id : ids){
                Guild guild = shardManager.getGuildById(id);
                if(guild != null){
                    guilds.add(id);
                }
            }
            return ResponseHandler.generateResponse(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK, guilds);
        }
        return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), HttpStatus.BAD_REQUEST, null);

    }

    @Async
    @PostMapping("api/getDetailedGuild")
    public ResponseEntity<Object> getDetailedGuild(@RequestBody(required = true)Map<String, Object> body){
        String authHeader = "Bot " + config.get("TOKEN");
        String guildId = (String) body.get("guildId");
        if(guildId != null){
            try {
                return asyncService.callDiscordForGuild(guildId, authHeader).thenApply(
                        detailedGuild -> {
                            return detailedGuild;
                        }
                ).get(3, java.util.concurrent.TimeUnit.SECONDS);

            } catch (Exception e) {
                return ResponseHandler.generateResponse(HttpStatus.REQUEST_TIMEOUT.getReasonPhrase(), HttpStatus.REQUEST_TIMEOUT, null);
            }
        }else{
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), HttpStatus.BAD_REQUEST, null);
        }
    }

    @GetMapping("/test")
    public String test(){
        return "Connection Up and Running";
    }

}
