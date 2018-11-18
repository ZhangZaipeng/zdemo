/**
 * 
 */
package com.example.zdemo.Im.param;

/**
 * @ClassName: GroupSoundParam
 * @author huangzg 2017年3月1日 下午1:17:31
 */
public class GroupSoundParam {

	private String busCode;

	private String groupId;

	private String sender;

	private String url;

	private Long size;

	private String consultantId;

	public GroupSoundParam() {
		super();
	}

	public GroupSoundParam(String busCode, String groupId, String sender,
			String url, Long size, String consultantId) {
		super();
		this.busCode = busCode;
		this.groupId = groupId;
		this.sender = sender;
		this.url = url;
		this.size = size;
		this.consultantId = consultantId;
	}

	public String getBusCode() {
		return busCode;
	}

	public void setBusCode(String busCode) {
		this.busCode = busCode;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getConsultantId() {
		return consultantId;
	}

	public void setConsultantId(String consultantId) {
		this.consultantId = consultantId;
	}

}
