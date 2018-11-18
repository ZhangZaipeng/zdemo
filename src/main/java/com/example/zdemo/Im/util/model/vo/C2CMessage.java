package com.example.zdemo.Im.util.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class C2CMessage {

	@JsonProperty("MsgType")
	private String msgType;
	
	@JsonProperty("MsgContent")
	private IMRecordCont msgContent;

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public IMRecordCont getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(IMRecordCont msgContent) {
		this.msgContent = msgContent;
	}


}
