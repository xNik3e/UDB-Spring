package com.example.untitleddiscordbot.controller;

import com.example.untitleddiscordbot.UntitledDiscordBot;
import com.example.untitleddiscordbot.templates.ResponseHandler;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.sharding.ShardManager;
import net.dv8tion.jda.internal.utils.config.sharding.ShardingMetaConfig;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class ApiController {


    private UntitledDiscordBot bot = UntitledDiscordBot.getInstance();

    @PostMapping("/getGuildsByIds")
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

    @GetMapping("/test")
    public String test(){
        return "Connection Up and Running";
    }

}
