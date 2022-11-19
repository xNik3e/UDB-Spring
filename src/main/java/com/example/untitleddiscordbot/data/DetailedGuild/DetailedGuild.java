package com.example.untitleddiscordbot.data.DetailedGuild;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DetailedGuild{

	@SerializedName("max_stage_video_channel_users")
	private int maxStageVideoChannelUsers;

	@SerializedName("preferred_locale")
	private String preferredLocale;

	@SerializedName("embed_channel_id")
	private String embedChannelId;

	@SerializedName("default_message_notifications")
	private int defaultMessageNotifications;

	@SerializedName("owner_id")
	private String ownerId;

	@SerializedName("widget_channel_id")
	private String widgetChannelId;

	@SerializedName("roles")
	private List<RolesItem> roles;

	@SerializedName("icon")
	private String icon;

	@SerializedName("description")
	private Object description;

	@SerializedName("system_channel_id")
	private String systemChannelId;

	@SerializedName("rules_channel_id")
	private Object rulesChannelId;

	@SerializedName("afk_timeout")
	private int afkTimeout;

	@SerializedName("features")
	private List<String> features;

	@SerializedName("afk_channel_id")
	private Object afkChannelId;

	@SerializedName("max_members")
	private int maxMembers;

	@SerializedName("stickers")
	private List<Object> stickers;

	@SerializedName("id")
	private String id;

	@SerializedName("hub_type")
	private Object hubType;

	@SerializedName("widget_enabled")
	private boolean widgetEnabled;

	@SerializedName("max_video_channel_users")
	private int maxVideoChannelUsers;

	@SerializedName("nsfw_level")
	private int nsfwLevel;

	@SerializedName("safety_alerts_channel_id")
	private Object safetyAlertsChannelId;

	@SerializedName("emojis")
	private List<EmojisItem> emojis;

	@SerializedName("nsfw")
	private boolean nsfw;

	@SerializedName("vanity_url_code")
	private Object vanityUrlCode;

	@SerializedName("max_presences")
	private Object maxPresences;

	@SerializedName("system_channel_flags")
	private int systemChannelFlags;

	@SerializedName("premium_progress_bar_enabled")
	private boolean premiumProgressBarEnabled;

	@SerializedName("banner")
	private String banner;

	@SerializedName("premium_subscription_count")
	private int premiumSubscriptionCount;

	@SerializedName("public_updates_channel_id")
	private Object publicUpdatesChannelId;

	@SerializedName("application_id")
	private Object applicationId;

	@SerializedName("embed_enabled")
	private boolean embedEnabled;

	@SerializedName("verification_level")
	private int verificationLevel;

	@SerializedName("discovery_splash")
	private Object discoverySplash;

	@SerializedName("explicit_content_filter")
	private int explicitContentFilter;

	@SerializedName("name")
	private String name;

	@SerializedName("mfa_level")
	private int mfaLevel;

	@SerializedName("premium_tier")
	private int premiumTier;

	@SerializedName("region")
	private String region;

	@SerializedName("splash")
	private String splash;

	public void setMaxStageVideoChannelUsers(int maxStageVideoChannelUsers){
		this.maxStageVideoChannelUsers = maxStageVideoChannelUsers;
	}

	public int getMaxStageVideoChannelUsers(){
		return maxStageVideoChannelUsers;
	}

	public void setPreferredLocale(String preferredLocale){
		this.preferredLocale = preferredLocale;
	}

	public String getPreferredLocale(){
		return preferredLocale;
	}

	public void setEmbedChannelId(String embedChannelId){
		this.embedChannelId = embedChannelId;
	}

	public String getEmbedChannelId(){
		return embedChannelId;
	}

	public void setDefaultMessageNotifications(int defaultMessageNotifications){
		this.defaultMessageNotifications = defaultMessageNotifications;
	}

	public int getDefaultMessageNotifications(){
		return defaultMessageNotifications;
	}

	public void setOwnerId(String ownerId){
		this.ownerId = ownerId;
	}

	public String getOwnerId(){
		return ownerId;
	}

	public void setWidgetChannelId(String widgetChannelId){
		this.widgetChannelId = widgetChannelId;
	}

	public String getWidgetChannelId(){
		return widgetChannelId;
	}

	public void setRoles(List<RolesItem> roles){
		this.roles = roles;
	}

	public List<RolesItem> getRoles(){
		return roles;
	}

	public void setIcon(String icon){
		this.icon = icon;
	}

	public String getIcon(){
		return icon;
	}

	public void setDescription(Object description){
		this.description = description;
	}

	public Object getDescription(){
		return description;
	}

	public void setSystemChannelId(String systemChannelId){
		this.systemChannelId = systemChannelId;
	}

	public String getSystemChannelId(){
		return systemChannelId;
	}

	public void setRulesChannelId(Object rulesChannelId){
		this.rulesChannelId = rulesChannelId;
	}

	public Object getRulesChannelId(){
		return rulesChannelId;
	}

	public void setAfkTimeout(int afkTimeout){
		this.afkTimeout = afkTimeout;
	}

	public int getAfkTimeout(){
		return afkTimeout;
	}

	public void setFeatures(List<String> features){
		this.features = features;
	}

	public List<String> getFeatures(){
		return features;
	}

	public void setAfkChannelId(Object afkChannelId){
		this.afkChannelId = afkChannelId;
	}

	public Object getAfkChannelId(){
		return afkChannelId;
	}

	public void setMaxMembers(int maxMembers){
		this.maxMembers = maxMembers;
	}

	public int getMaxMembers(){
		return maxMembers;
	}

	public void setStickers(List<Object> stickers){
		this.stickers = stickers;
	}

	public List<Object> getStickers(){
		return stickers;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setHubType(Object hubType){
		this.hubType = hubType;
	}

	public Object getHubType(){
		return hubType;
	}

	public void setWidgetEnabled(boolean widgetEnabled){
		this.widgetEnabled = widgetEnabled;
	}

	public boolean isWidgetEnabled(){
		return widgetEnabled;
	}

	public void setMaxVideoChannelUsers(int maxVideoChannelUsers){
		this.maxVideoChannelUsers = maxVideoChannelUsers;
	}

	public int getMaxVideoChannelUsers(){
		return maxVideoChannelUsers;
	}

	public void setNsfwLevel(int nsfwLevel){
		this.nsfwLevel = nsfwLevel;
	}

	public int getNsfwLevel(){
		return nsfwLevel;
	}

	public void setSafetyAlertsChannelId(Object safetyAlertsChannelId){
		this.safetyAlertsChannelId = safetyAlertsChannelId;
	}

	public Object getSafetyAlertsChannelId(){
		return safetyAlertsChannelId;
	}

	public void setEmojis(List<EmojisItem> emojis){
		this.emojis = emojis;
	}

	public List<EmojisItem> getEmojis(){
		return emojis;
	}

	public void setNsfw(boolean nsfw){
		this.nsfw = nsfw;
	}

	public boolean isNsfw(){
		return nsfw;
	}

	public void setVanityUrlCode(Object vanityUrlCode){
		this.vanityUrlCode = vanityUrlCode;
	}

	public Object getVanityUrlCode(){
		return vanityUrlCode;
	}

	public void setMaxPresences(Object maxPresences){
		this.maxPresences = maxPresences;
	}

	public Object getMaxPresences(){
		return maxPresences;
	}

	public void setSystemChannelFlags(int systemChannelFlags){
		this.systemChannelFlags = systemChannelFlags;
	}

	public int getSystemChannelFlags(){
		return systemChannelFlags;
	}

	public void setPremiumProgressBarEnabled(boolean premiumProgressBarEnabled){
		this.premiumProgressBarEnabled = premiumProgressBarEnabled;
	}

	public boolean isPremiumProgressBarEnabled(){
		return premiumProgressBarEnabled;
	}

	public void setBanner(String banner){
		this.banner = banner;
	}

	public String getBanner(){
		return banner;
	}

	public void setPremiumSubscriptionCount(int premiumSubscriptionCount){
		this.premiumSubscriptionCount = premiumSubscriptionCount;
	}

	public int getPremiumSubscriptionCount(){
		return premiumSubscriptionCount;
	}

	public void setPublicUpdatesChannelId(Object publicUpdatesChannelId){
		this.publicUpdatesChannelId = publicUpdatesChannelId;
	}

	public Object getPublicUpdatesChannelId(){
		return publicUpdatesChannelId;
	}

	public void setApplicationId(Object applicationId){
		this.applicationId = applicationId;
	}

	public Object getApplicationId(){
		return applicationId;
	}

	public void setEmbedEnabled(boolean embedEnabled){
		this.embedEnabled = embedEnabled;
	}

	public boolean isEmbedEnabled(){
		return embedEnabled;
	}

	public void setVerificationLevel(int verificationLevel){
		this.verificationLevel = verificationLevel;
	}

	public int getVerificationLevel(){
		return verificationLevel;
	}

	public void setDiscoverySplash(Object discoverySplash){
		this.discoverySplash = discoverySplash;
	}

	public Object getDiscoverySplash(){
		return discoverySplash;
	}

	public void setExplicitContentFilter(int explicitContentFilter){
		this.explicitContentFilter = explicitContentFilter;
	}

	public int getExplicitContentFilter(){
		return explicitContentFilter;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setMfaLevel(int mfaLevel){
		this.mfaLevel = mfaLevel;
	}

	public int getMfaLevel(){
		return mfaLevel;
	}

	public void setPremiumTier(int premiumTier){
		this.premiumTier = premiumTier;
	}

	public int getPremiumTier(){
		return premiumTier;
	}

	public void setRegion(String region){
		this.region = region;
	}

	public String getRegion(){
		return region;
	}

	public void setSplash(String splash){
		this.splash = splash;
	}

	public String getSplash(){
		return splash;
	}
}