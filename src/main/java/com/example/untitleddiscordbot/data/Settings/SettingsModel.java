package com.example.untitleddiscordbot.data.Settings;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
public class SettingsModel {

    @Id
    private String id;

    @SerializedName("ignoredRoleIds")
    private List<String> ignoredRoleIds;

    @SerializedName("autoDeleteTrigger")
    private int autoDeleteTrigger;

    @SerializedName("isDefaultChannelEnabled")
    private boolean isDefaultChannelEnabled;

    @SerializedName("channelPermissions")
    private List<ChannelPermissionsModel> channelPermissions;

    @SerializedName("autoDeleteTriggerEnabled")
    private boolean autoDeleteTriggerEnabled;

    @SerializedName("prefix")
    private String prefix;

    @SerializedName("defaultChannelId")
    private String defaultChannelId;

    @SerializedName("guildId")
    private String guildId;

    @SerializedName("requiredRoleIds")
    private List<String> requiredRoleIds;

    @SerializedName("autoDeleteResponse")
    private int autoDeleteResponse;

    @SerializedName("autoDeleteResponseEnabled")
    private boolean autoDeleteResponseEnabled;


    public SettingsModel() {
    }
}
