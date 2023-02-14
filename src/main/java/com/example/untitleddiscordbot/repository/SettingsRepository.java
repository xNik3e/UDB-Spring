package com.example.untitleddiscordbot.repository;

import com.example.untitleddiscordbot.data.Settings.ChannelPermissionsModel;
import com.example.untitleddiscordbot.data.Settings.SettingsModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SettingsRepository extends MongoRepository<SettingsModel, String> {
    SettingsModel findByGuildId(String guildId);
}
