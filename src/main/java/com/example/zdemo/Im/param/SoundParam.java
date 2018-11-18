package com.example.zdemo.Im.param;

/**
 * 语音消息参数集
 * 
 * @ClassName: SoundParam
 * @author huangzg 2017年2月27日 下午6:06:13
 */
public class SoundParam {

	/** 业务代码 */
	private String busCode;

	/** 发送者ChatId */
	private String sender;

	/** 接收者ChatId */
	private String recevrer;

	/** 语音消息 */
	private String url;

	/** 问题ID/服务ID */
	private String consultantId;

	/** 语音大小 */
	private Long size;

	public SoundParam() {
		super();
	}

	public SoundParam(String busCode, String sender, String recevrer,
			String url, String consultantId, Long size) {
		super();
		this.busCode = busCode;
		this.sender = sender;
		this.recevrer = recevrer;
		this.url = url;
		this.consultantId = consultantId;
		this.size = size;
	}

	public String getBusCode() {
		return busCode;
	}

	public void setBusCode(String busCode) {
		this.busCode = busCode;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getConsultantId() {
		return consultantId;
	}

	public void setConsultantId(String consultantId) {
		this.consultantId = consultantId;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

}
