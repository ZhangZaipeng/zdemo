/**
 * 
 */
package com.example.zdemo.Im.util.model.vo;

/**
 * @ClassName: ImFriendParam
 * @author huangzg 2017年2月18日 下午1:55:56
 */
public class ImFriendParam {

	private String busCode;

	private String imAccount;

	private String senderNickName;

	private String senderHeadUrl;

	private String friendAccount;

	private String nickName;

	private String headUrl;

	public ImFriendParam() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ImFriendParam(String busCode, String imAccount,
			String senderNickName, String senderHeadUrl, String friendAccount,
			String nickName, String headUrl) {
		super();
		this.busCode = busCode;
		this.imAccount = imAccount;
		this.senderNickName = senderNickName;
		this.senderHeadUrl = senderHeadUrl;
		this.friendAccount = friendAccount;
		this.nickName = nickName;
		this.headUrl = headUrl;
	}

	public String getBusCode() {
		return busCode;
	}

	public void setBusCode(String busCode) {
		this.busCode = busCode;
	}

	public String getImAccount() {
		return imAccount;
	}

	public void setImAccount(String imAccount) {
		this.imAccount = imAccount;
	}

	public String getSenderNickName() {
		return senderNickName;
	}

	public void setSenderNickName(String senderNickName) {
		this.senderNickName = senderNickName;
	}

	public String getSenderHeadUrl() {
		return senderHeadUrl;
	}

	public void setSenderHeadUrl(String senderHeadUrl) {
		this.senderHeadUrl = senderHeadUrl;
	}

	public String getFriendAccount() {
		return friendAccount;
	}

	public void setFriendAccount(String friendAccount) {
		this.friendAccount = friendAccount;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

}
