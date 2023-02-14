package com.example.untitleddiscordbot;

import com.example.untitleddiscordbot.repository.SettingsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.security.auth.login.LoginException;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = SettingsRepository.class)
public class Application {
    public static void main(String[] args) throws LoginException {
        SpringApplication.run(Application.class, args);
    }
}
