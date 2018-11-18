package com.example.zdemo.Im.util.model.vo;

public class IMConverContsVo {

	/**
	 * 消息ID
	 */
	private String msgId;

	/**
	 * 业务ID
	 */
	private String busCode;
	/**
	 * 会话ID
	 */
	private String consultantId;

	/**
	 * 发送者
	 */
	private String fromAccount;
	/**
	 * 接收者
	 */
	private String toAccount;

	/**
	 * 消息发送时间
	 */
	private String msgTime;
	/**
	 * 消息类型
	 */
	private String msgType;

	/*** 消息状态 1：已读 2：未读 */
	public Integer msgDatastatus;
	
	
	private String groupId;
	
	/**
	 * @return the msgType
	 */
	public String getMsgType() {
		return msgType;
	}

	/**
	 * @param msgType
	 *            the msgType to set
	 */
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	/**
	 * 消息主体接收 (json)
	 */
	private String messageBody;

	public String getBusCode() {
		return busCode;
	}

	public void setBusCode(String busCode) {
		this.busCode = busCode;
	}

	public String getConsultantId() {
		return consultantId;
	}

	public void setConsultantId(String consultantId) {
		this.consultantId = consultantId;
	}

	/**
	 * @return the msgId
	 */
	public String getMsgId() {
		return msgId;
	}

	/**
	 * @param msgId
	 *            the msgId to set
	 */
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	/**
	 * @return the fromAccount
	 */
	public String getFromAccount() {
		return fromAccount;
	}

	/**
	 * @param fromAccount
	 *            the fromAccount to set
	 */
	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	/**
	 * @return the toAccount
	 */
	public String getToAccount() {
		return toAccount;
	}

	/**
	 * @param toAccount
	 *            the toAccount to set
	 */
	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	/**
	 * @return the msgTime
	 */
	public String getMsgTime() {
		return msgTime;
	}

	/**
	 * @param msgTime
	 *            the msgTime to set
	 */
	public void setMsgTime(String msgTime) {
		this.msgTime = msgTime;
	}

	/**
	 * @return the messageBody
	 */
	public String getMessageBody() {
		return messageBody;
	}

	/**
	 * @param messageBody
	 *            the messageBody to set
	 */
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public Integer getMsgDatastatus() {
		return msgDatastatus;
	}

	public void setMsgDatastatus(Integer msgDatastatus) {
		this.msgDatastatus = msgDatastatus;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
	
}
