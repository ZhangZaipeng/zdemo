package com.example.zdemo.Im.util.model.vo;

public class IMSendMsg {

	public IMSendMsg(int id, String mobile, String nickName) {
		super();
		this.id = id;
		this.mobile = mobile;
		this.nickName = nickName;
	}

	private int id;

	private String mobile;

	private String nickName;

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
