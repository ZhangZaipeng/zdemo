package com.example.zdemo.Im.util.model.vo;

/**
 * IM好友 实体类
 * @ClassName: IMFriendVo
 * @author huangzg 2016年11月24日 下午3:14:58
 */
public class IMFriendVo {

	/** IM好友帐号 */
	private String friendImAccount;

	/** IM好友昵称 */
	private String nickName;

	/** IM好友头像URL */
	private String headUrl;

	public IMFriendVo(String friendImAccount, String nickName, String headUrl) {
		super();
		this.friendImAccount = friendImAccount;
		this.nickName = nickName;
		this.headUrl = headUrl;
	}

	public IMFriendVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFriendImAccount() {
		return friendImAccount;
	}

	public void setFriendImAccount(String friendImAccount) {
		this.friendImAccount = friendImAccount;
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
