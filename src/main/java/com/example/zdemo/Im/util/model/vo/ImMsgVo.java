package com.example.zdemo.Im.util.model.vo;


public class ImMsgVo {
	/**
     * 消息ID
     */
	private Long msgId;

	/**
	 * 消息发送者chatId
	 */
    private String sendChatId;

    /**
     * 消息接收者chatId
     */
    private String recevrerChatId;

    /**
     * 消息内容
     */
    private String msgContent;

    /**
     * 消息类型
     */
    private String msgType;
    
    /**
     * 发送时间
     */
    private String sendTime;
    
    /** 
     * 业务代码 
     */
	private String busCode;

	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

	public String getSendChatId() {
		return sendChatId;
	}

	public void setSendChatId(String sendChatId) {
		this.sendChatId = sendChatId;
	}

	public String getRecevrerChatId() {
		return recevrerChatId;
	}

	public void setRecevrerChatId(String recevrerChatId) {
		this.recevrerChatId = recevrerChatId;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getBusCode() {
		return busCode;
	}

	public void setBusCode(String busCode) {
		this.busCode = busCode;
	}
	
}
