package com.example.untitleddiscordbot.data.DetailedGuild;

import com.google.gson.annotations.SerializedName;

public class RolesItem{

	@SerializedName("color")
	private int color;

	@SerializedName("unicode_emoji")
	private Object unicodeEmoji;

	@SerializedName("icon")
	private Object icon;

	@SerializedName("flags")
	private int flags;

	@SerializedName("description")
	private Object description;

	@SerializedName("permissions_new")
	private String permissionsNew;

	@SerializedName("hoist")
	private boolean hoist;

	@SerializedName("tags")
	private Tags tags;

	@SerializedName("permissions")
	private int permissions;

	@SerializedName("managed")
	private boolean managed;

	@SerializedName("name")
	private String name;

	@SerializedName("mentionable")
	private boolean mentionable;

	@SerializedName("id")
	private String id;

	@SerializedName("position")
	private int position;

	public void setColor(int color){
		this.color = color;
	}

	public int getColor(){
		return color;
	}

	public void setUnicodeEmoji(Object unicodeEmoji){
		this.unicodeEmoji = unicodeEmoji;
	}

	public Object getUnicodeEmoji(){
		return unicodeEmoji;
	}

	public void setIcon(Object icon){
		this.icon = icon;
	}

	public Object getIcon(){
		return icon;
	}

	public void setFlags(int flags){
		this.flags = flags;
	}

	public int getFlags(){
		return flags;
	}

	public void setDescription(Object description){
		this.description = description;
	}

	public Object getDescription(){
		return description;
	}

	public void setPermissionsNew(String permissionsNew){
		this.permissionsNew = permissionsNew;
	}

	public String getPermissionsNew(){
		return permissionsNew;
	}

	public void setHoist(boolean hoist){
		this.hoist = hoist;
	}

	public boolean isHoist(){
		return hoist;
	}

	public void setTags(Tags tags){
		this.tags = tags;
	}

	public Tags getTags(){
		return tags;
	}

	public void setPermissions(int permissions){
		this.permissions = permissions;
	}

	public int getPermissions(){
		return permissions;
	}

	public void setManaged(boolean managed){
		this.managed = managed;
	}

	public boolean isManaged(){
		return managed;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setMentionable(boolean mentionable){
		this.mentionable = mentionable;
	}

	public boolean isMentionable(){
		return mentionable;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setPosition(int position){
		this.position = position;
	}

	public int getPosition(){
		return position;
	}
}