package com.example.zdemo.Im.util.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class C2CImcallBack {

	@JsonProperty("CallbackCommand")
	private String callbackCommand;

	@JsonProperty("From_Account")
	private String fromAccount;

	@JsonProperty("GroupId")
	private String groupId;

	@JsonProperty("To_Account")
	private String toAccount;

	@JsonProperty("MsgBody")
	private List<C2CMessage> msgBody;

	public C2CImcallBack() {
		super();
		// TODO Auto-generated constructor stub
	}

	public C2CImcallBack(String callbackCommand, String fromAccount,
			String groupId, String toAccount, List<C2CMessage> msgBody) {
		super();
		this.callbackCommand = callbackCommand;
		this.fromAccount = fromAccount;
		this.groupId = groupId;
		this.toAccount = toAccount;
		this.msgBody = msgBody;
	}

	public String getCallbackCommand() {
		return callbackCommand;
	}

	public void setCallbackCommand(String callbackCommand) {
		this.callbackCommand = callbackCommand;
	}

	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getToAccount() {
		return toAccount;
	}

	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	public List<C2CMessage> getMsgBody() {
		return msgBody;
	}

	public void setMsgBody(List<C2CMessage> msgBody) {
		this.msgBody = msgBody;
	}

}
