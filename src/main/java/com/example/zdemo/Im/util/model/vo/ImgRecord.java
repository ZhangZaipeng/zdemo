package com.example.zdemo.Im.util.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImgRecord {

	/* 图像消息元素类型（1：原图；2：大图；3：缩量图） */
	@JsonProperty("Type")
	private String Type;
	@JsonProperty("Size")
	private String Size;
	/* 图像消息元素 宽度 */
	@JsonProperty("Width")
	private Integer Width;
	/* 图像消息元素 高度 */
	@JsonProperty("Height")
	private Integer Height;
	/* 图像消息元素 图片路径 */
	@JsonProperty("URL")
	private String URL;
	@JsonProperty("UUID")
	private String UUID;

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getSize() {
		return Size;
	}

	public void setSize(String size) {
		Size = size;
	}

	public Integer getWidth() {
		return Width;
	}

	public void setWidth(Integer width) {
		Width = width;
	}

	public Integer getHeight() {
		return Height;
	}

	public void setHeight(Integer height) {
		Height = height;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}

}
