package com.example.zdemo.Im.param;

/**
 * 查询聊天记录参数集
 * 
 * @ClassName: MsgLogParam
 * @author huangzg 2017年2月27日 下午6:11:52
 */
public class MsgLogParam {

	/** 消息ID */
	private String msgId;

	/** 业务代码 */
	private String busCode;

	/** 问题ID/服务ID */
	private String consultantId;

	/** 发送者ChatId */
	private String sender;

	/** 接收者ChatId */
	private String recevrer;

	/** 页码 */
	private Integer pageNo;

	/** 每页条数 */
	private Integer pageSize;

	/** 群号 */
	private String groupId;

	public MsgLogParam() {
		super();
	}

	public MsgLogParam(String msgId, String busCode, String consultantId,
			String sender, String recevrer, Integer pageNo, Integer pageSize,
			String groupId) {
		super();
		this.msgId = msgId;
		this.busCode = busCode;
		this.consultantId = consultantId;
		this.sender = sender;
		this.recevrer = recevrer;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.groupId = groupId;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

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

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getRecevrer() {
		return recevrer;
	}

	public void setRecevrer(String recevrer) {
		this.recevrer = recevrer;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

}
