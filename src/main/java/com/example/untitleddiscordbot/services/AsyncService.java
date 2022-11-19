package com.example.untitleddiscordbot.services;

import com.example.untitleddiscordbot.data.DetailedGuild.DetailedGuild;
import com.example.untitleddiscordbot.templates.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {

    @Autowired
    private RestTemplate restTemplate;

    @Async
    public CompletableFuture<ResponseEntity<Object>> callDiscordForGuild(String guildId, String authHeader){


        String guildJSON = WebClient.create().get()
                .uri("https://discord.com/api/guilds/" + guildId + "?with_counts=true")
                .header(HttpHeaders.AUTHORIZATION, authHeader)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        String channelsJSON = WebClient.create().get()
                .uri("https://discord.com/api/guilds/" + guildId + "/channels")
                .header(HttpHeaders.AUTHORIZATION, authHeader)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        String membersJSON = WebClient.create().get()
                .uri("https://discord.com/api/guilds/" + guildId + "/members?limit=1000")
                .header(HttpHeaders.AUTHORIZATION, authHeader)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        List<String> JSONs = new ArrayList<>();
        JSONs.add(guildJSON);
        JSONs.add(channelsJSON);
        JSONs.add(membersJSON);

        return CompletableFuture.completedFuture(
                 ResponseHandler.generateResponse("OK", HttpStatus.OK,
                         JSONs));
    }
}
