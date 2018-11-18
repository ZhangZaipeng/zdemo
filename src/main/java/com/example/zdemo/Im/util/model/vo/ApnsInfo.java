package com.example.zdemo.Im.util.model.vo;

import com.alibaba.fastjson.annotation.JSONField;

public class ApnsInfo {
	
	@JSONField(name = "Sound")
	private String sound;
	
	@JSONField(name = "BadgeMode")
	private Integer badgeMode;

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	public Integer getBadgeMode() {
		return badgeMode;
	}

	public void setBadgeMode(Integer badgeMode) {
		this.badgeMode = badgeMode;
	}
	
}

