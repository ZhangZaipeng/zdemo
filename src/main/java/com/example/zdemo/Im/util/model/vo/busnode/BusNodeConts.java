/**
 * 
 */
package com.example.zdemo.Im.util.model.vo.busnode;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 业务节点数据
 * 
 * @ClassName: BusNodeConts
 * @author huangzg 2017年1月13日 上午10:37:57
 */
public class BusNodeConts {

	/** 业务代码 */
	@JsonProperty("busCode")
	private String busCode;

	/** 服务ID/问题ID */
	@JsonProperty("consultantId")
	private String consultantId;
	
	/** 消息ID */
	@JsonProperty("sendMsgId")
	private Long sendMsgId;

	public BusNodeConts() {
		super();
	}

	public BusNodeConts(String busCode, String consultantId) {
		super();
		this.busCode = busCode;
		this.consultantId = consultantId;
	}

	public BusNodeConts(String busCode, String consultantId,Long sendMsgId) {
		super();
		this.busCode = busCode;
		this.consultantId = consultantId;
		this.sendMsgId = sendMsgId;
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

	public Long getSendMsgId() {
		return sendMsgId;
	}

	public void setSendMsgId(Long sendMsgId) {
		this.sendMsgId = sendMsgId;
	}
	

}
