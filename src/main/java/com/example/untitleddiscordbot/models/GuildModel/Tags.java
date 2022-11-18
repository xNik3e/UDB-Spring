package com.example.untitleddiscordbot.models.GuildModel;

import com.google.gson.annotations.SerializedName;

public class Tags{

	@SerializedName("bot_id")
	private String botId;

	@SerializedName("premium_subscriber")
	private Object premiumSubscriber;

	public void setBotId(String botId){
		this.botId = botId;
	}

	public String getBotId(){
		return botId;
	}

	public void setPremiumSubscriber(Object premiumSubscriber){
		this.premiumSubscriber = premiumSubscriber;
	}

	public Object getPremiumSubscriber(){
		return premiumSubscriber;
	}
}