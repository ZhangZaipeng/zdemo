/**
 * 
 */
package com.example.zdemo.Im.util.model.vo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * 群聊消息表头实体类
 * @ClassName: GroupMsgTitle
 * @author liump
 * @date 2017年6月5日 下午2:44:33
 */
public class GroupMsgTitle {

	/**
	 * 向哪个群组发送消息
	 * */
	@JSONField(name = "GroupId")
	private String groupId;

	/** 消息发送方账号 */
	@JSONField(name = "From_Account")
	private String fromAccount;

	/** 消息随机数,由随机函数产生（用作消息去重） */
	@JSONField(name = "Random")
	private Integer random;

	/** 消息内容 */
	@JSONField(name = "MsgBody")
	private Object msgBody;

	/** 离线推送信息配置 */
	@JSONField(name = "OfflinePushInfo")
	private Object offlinePushInfo;

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public Integer getRandom() {
		return random;
	}

	public void setRandom(Integer random) {
		this.random = random;
	}

	public Object getMsgBody() {
		return msgBody;
	}

	public void setMsgBody(Object msgBody) {
		this.msgBody = msgBody;
	}

	public Object getOfflinePushInfo() {
		return offlinePushInfo;
	}

	public void setOfflinePushInfo(Object offlinePushInfo) {
		this.offlinePushInfo = offlinePushInfo;
	}

	public GroupMsgTitle() {
		super();
	}

	public GroupMsgTitle(String groupId, String fromAccount, Integer random, Object msgBody, Object offlinePushInfo) {
		super();
		this.groupId = groupId;
		this.fromAccount = fromAccount;
		this.random = random;
		this.msgBody = msgBody;
		this.offlinePushInfo = offlinePushInfo;
	}

	@Override
	public String toString() {
		return "GroupMsgTitle [groupId=" + groupId + ", fromAccount=" + fromAccount + ", random=" + random
				+ ", msgBody=" + msgBody + ", offlinePushInfo=" + offlinePushInfo + "]";
	}

}
