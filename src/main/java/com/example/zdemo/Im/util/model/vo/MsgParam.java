/**
 * 
 */
package com.example.zdemo.Im.util.model.vo;

/**
 * 聊天记录参数集
 * 
 * @ClassName: MsgParam
 * @author huangzg 2017年1月8日 下午2:08:57
 */
public class MsgParam {

	/** 业务代码 */
	private String busCode;

	/** 发送者UserId */
	private String fromUserId;

	/** 发送者账户类型 帐号类型 1：医生 2：患者/用户 3：其他 */
	private Integer fromAccountType;

	/** 接收者UserId */
	private String toUserId;

	/** 发送者账户类型 帐号类型 1：医生 2：患者/用户 3：其他 */
	private Integer toAccountType;

	/** 开始时间(年-月-日) */
	private String startTime;

	/** 结束时间(年-月-日) */
	private String endTime;

	/** 页码 */
	private Integer pageNo;

	/** 每页条数 */
	private Integer pageSize;

	/** 消息ID */
	private Long msgId;

	/** 问题ID/服务ID/会话ID */
	private String consultantId;

	public MsgParam() {
		super();
	}

	public MsgParam(String busCode, String fromUserId, Integer fromAccountType,
			String toUserId, Integer toAccountType, String startTime,
			String endTime, Integer pageNo, Integer pageSize, Long msgId,
			String consultantId) {
		super();
		this.busCode = busCode;
		this.fromUserId = fromUserId;
		this.fromAccountType = fromAccountType;
		this.toUserId = toUserId;
		this.toAccountType = toAccountType;
		this.startTime = startTime;
		this.endTime = endTime;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.msgId = msgId;
		this.consultantId = consultantId;
	}

	public String getBusCode() {
		return busCode;
	}

	public void setBusCode(String busCode) {
		this.busCode = busCode;
	}

	public String getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(String fromUserId) {
		this.fromUserId = fromUserId;
	}

	public Integer getFromAccountType() {
		return fromAccountType;
	}

	public void setFromAccountType(Integer fromAccountType) {
		this.fromAccountType = fromAccountType;
	}

	public String getToUserId() {
		return toUserId;
	}

	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}

	public Integer getToAccountType() {
		return toAccountType;
	}

	public void setToAccountType(Integer toAccountType) {
		this.toAccountType = toAccountType;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
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

	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

	public String getConsultantId() {
		return consultantId;
	}

	public void setConsultantId(String consultantId) {
		this.consultantId = consultantId;
	}

}
