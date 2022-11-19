package com.example.untitleddiscordbot.data.DetailedGuild;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class EmojisItem{

	@SerializedName("managed")
	private boolean managed;

	@SerializedName("roles")
	private List<Object> roles;

	@SerializedName("name")
	private String name;

	@SerializedName("available")
	private boolean available;

	@SerializedName("animated")
	private boolean animated;

	@SerializedName("id")
	private String id;

	@SerializedName("require_colons")
	private boolean requireColons;

	public void setManaged(boolean managed){
		this.managed = managed;
	}

	public boolean isManaged(){
		return managed;
	}

	public void setRoles(List<Object> roles){
		this.roles = roles;
	}

	public List<Object> getRoles(){
		return roles;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setAvailable(boolean available){
		this.available = available;
	}

	public boolean isAvailable(){
		return available;
	}

	public void setAnimated(boolean animated){
		this.animated = animated;
	}

	public boolean isAnimated(){
		return animated;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setRequireColons(boolean requireColons){
		this.requireColons = requireColons;
	}

	public boolean isRequireColons(){
		return requireColons;
	}
}