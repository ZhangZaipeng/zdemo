package com.example.zdemo.Im.util.model.vo.sound;

public class SoundTextConts {

	/** 语音消息URL */
	private String content;

	private Long size;

	public SoundTextConts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SoundTextConts(String content, Long size) {
		super();
		this.content = content;
		this.size = size;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

}
