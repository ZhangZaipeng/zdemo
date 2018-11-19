/**
 * 
 */
package com.example.zdemo.Im.util.model.vo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @ClassName: MsgAccounts
 * @author zhangzp
 */
public class MsgAccounts {

	@JSONField(name = "Identifier")
	private String identifier;
	
	@JSONField(name = "Nick")
	private String nick;
	
	@JSONField(name = "FaceUrl")
	private String faceUrl;

	public MsgAccounts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MsgAccounts(String identifier, String nick, String faceUrl) {
		super();
		this.identifier = identifier;
		this.nick = nick;
		this.faceUrl = faceUrl;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getFaceUrl() {
		return faceUrl;
	}

	public void setFaceUrl(String faceUrl) {
		this.faceUrl = faceUrl;
	}

}
