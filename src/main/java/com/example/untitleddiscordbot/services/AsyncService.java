package com.example.untitleddiscordbot.services;

import com.example.untitleddiscordbot.data.DetailedGuild.DetailedGuild;
import com.example.untitleddiscordbot.models.GuildModel.GuildModel;
import com.example.untitleddiscordbot.templates.ResponseHandler;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


import reactor.netty.http.client.HttpClient;


import java.net.URI;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Service
public class AsyncService {

    @Autowired
    private RestTemplate restTemplate;

    @Async
    public CompletableFuture<ResponseEntity<Object>> callDiscordForGuild(String guildId, String authHeader){
        final String url = "https://discord.com/api/guilds/" + guildId;

        WebClient client = WebClient.create();


        return CompletableFuture.completedFuture(
                 ResponseHandler.generateResponse("OK", HttpStatus.OK,
                         client.get()
                                 .uri(URI.create(url))
                                 .header("Authorization", authHeader)
                                 .accept(MediaType.APPLICATION_JSON)
                                 .retrieve().toEntity(DetailedGuild.class).block()));
    }
}
