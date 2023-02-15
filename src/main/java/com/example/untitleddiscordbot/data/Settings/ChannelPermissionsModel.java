package com.example.untitleddiscordbot.data.Settings;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
public class ChannelPermissionsModel {


    @SerializedName("defaultChannel")
    private boolean defaultChannel;

    @SerializedName("checked")
    private boolean checked;

    @SerializedName("channelName")
    private String channelName;

    @SerializedName("grouped")
    private boolean grouped;

    @SerializedName("type")
    private int type;

    @SerializedName("channelId")
    private String channelId;

    @SerializedName("memberIds")
    private List<String> memberIds;

    @SerializedName("parentId")
    private String parentId;

    @SerializedName("requiredRoleIds")
    private List<String> requiredRoleIds;

    public ChannelPermissionsModel() {
    }


}
