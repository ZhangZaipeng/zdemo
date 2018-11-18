/**
 * 
 */
package com.example.zdemo.Im.util.model.vo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 消息表头实体类
 * 
 * @ClassName: MsgTitle
 * @author huangzg 2017年1月13日 上午9:50:21
 */
public class MsgTitle {

	/**
	 * 1：把消息同步到From_Account在线终端和漫游上；
	 * 2：消息不同步至From_Account；若不填写默认情况下会将消息存From_Account漫游
	 * */
	@JSONField(name = "SyncOtherMachine")
	private Integer syncOtherMachine;

	/** 消息发送方账号 */
	@JSONField(name = "From_Account")
	private String fromAccount;

	/** 消息接收方账号 */
	@JSONField(name = "To_Account")
	private String toAccount;

	/** 消息随机数,由随机函数产生（用作消息去重） */
	@JSONField(name = "MsgRandom")
	private Integer msgRandom;

	/** 消息时间戳 */
	@JSONField(name = "MsgTimeStamp")
	private Integer msgTimeStamp;

	/** 消息内容 */
	@JSONField(name = "MsgBody")
	private Object msgBody;

	/** 离线推送信息配置 */
	@JSONField(name = "OfflinePushInfo")
	private Object offlinePushInfo;

	public MsgTitle() {
		super();
	}

	public MsgTitle(Integer syncOtherMachine, String fromAccount,
			String toAccount, Integer msgRandom, Integer msgTimeStamp,
			Object msgBody, Object offlinePushInfo) {
		super();
		this.syncOtherMachine = syncOtherMachine;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.msgRandom = msgRandom;
		this.msgTimeStamp = msgTimeStamp;
		this.msgBody = msgBody;
		this.offlinePushInfo = offlinePushInfo;
	}

	public Integer getSyncOtherMachine() {
		return syncOtherMachine;
	}

	public void setSyncOtherMachine(Integer syncOtherMachine) {
		this.syncOtherMachine = syncOtherMachine;
	}

	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public String getToAccount() {
		return toAccount;
	}

	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	public Integer getMsgRandom() {
		return msgRandom;
	}

	public void setMsgRandom(Integer msgRandom) {
		this.msgRandom = msgRandom;
	}

	public Integer getMsgTimeStamp() {
		return msgTimeStamp;
	}

	public void setMsgTimeStamp(Integer msgTimeStamp) {
		this.msgTimeStamp = msgTimeStamp;
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

	@Override
	public String toString() {
		return "MsgTitle [syncOtherMachine=" + syncOtherMachine
				+ ", fromAccount=" + fromAccount + ", toAccount=" + toAccount
				+ ", msgRandom=" + msgRandom + ", msgTimeStamp=" + msgTimeStamp
				+ ", msgBody=" + msgBody + ", offlinePushInfo="
				+ offlinePushInfo + "]";
	}

}
