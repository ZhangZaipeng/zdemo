package com.example.zdemo.Im.util.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;

/**
 * 消息内容实体类 Created by Huangzhigang on 2016/7/9.
 */
public class IMRecordCont implements Serializable {

	/**
	 * 
	 */
	/**
	 * 
	 */
	private static final long serialVersionUID = 1000L;
	/* 外键ID */
	private String msgContId;
	/* 消息类型 */
	private String msgType;
	/* 消息序号 */
	private String msgSerialNo;
	/* 消息文字内容 */
	@JsonProperty("Text")
	private String Text;
	@JsonProperty("ImageFormat")
	private Object ImageFormat;
	@JsonProperty("ImageInfoArray")
	private List<ImgRecord> ImageInfoArray;
	/* 表情消息内容下标 */
	@JsonProperty("Index")
	private String Index;
	/* 表情消息内容 */
	@JsonProperty("Data")
	private String Data;
	/* 语音消息uuid */
	@JsonProperty("UUID")
	private String UUID;
	/* 语音消息大小/?图片消息大小 */
	@JsonProperty("Size")
	private String Size;
	/* 语音消息的时间 */
	@JsonProperty("Second")
	private Integer Second;
	/* 图像消息元素类型（1：原图；2：大图；3：缩量图） */
	@JsonProperty("Type")
	private String Type;
	/* 图像消息元素 宽度 */
	@JsonProperty("Width")
	private Integer Width;
	/* 图像消息元素 高度 */
	@JsonProperty("Height")
	private Integer Height;
	/* 图像消息元素 图片路径 */
	@JsonProperty("URL")
	private String URL;
	/* 文件消息元素 文件大小 */
	@JsonProperty("FileSize")
	private Integer FileSize;
	/* 文件消息元素 文件名称 */
	@JsonProperty("FileName")
	private String FileName;

	@JsonProperty("Desc")
	private String Desc;

	@JsonProperty("Ext")
	private String Ext;

	@JsonProperty("Sound")
	private String Sound;

	/* 创建时间 */
	private String createTime;

	public String getMsgContId() {
		return msgContId;
	}

	public void setMsgContId(String msgContId) {
		this.msgContId = msgContId;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getMsgSerialNo() {
		return msgSerialNo;
	}

	public void setMsgSerialNo(String msgSerialNo) {
		this.msgSerialNo = msgSerialNo;
	}

	public String getText() {
		return Text;
	}

	public void setText(String text) {
		Text = text;
	}

	public Object getImageFormat() {
		return ImageFormat;
	}

	public void setImageFormat(Object imageFormat) {
		ImageFormat = imageFormat;
	}

	public List<ImgRecord> getImageInfoArray() {
		return ImageInfoArray;
	}

	public void setImageInfoArray(List<ImgRecord> imageInfoArray) {
		ImageInfoArray = imageInfoArray;
	}

	public String getIndex() {
		return Index;
	}

	public void setIndex(String index) {
		Index = index;
	}

	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}

	public String getSize() {
		return Size;
	}

	public void setSize(String size) {
		Size = size;
	}

	public Integer getSecond() {
		return Second;
	}

	public void setSecond(Integer second) {
		Second = second;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public Integer getWidth() {
		return Width;
	}

	public void setWidth(Integer width) {
		Width = width;
	}

	public Integer getHeight() {
		return Height;
	}

	public void setHeight(Integer height) {
		Height = height;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public Integer getFileSize() {
		return FileSize;
	}

	public void setFileSize(Integer fileSize) {
		FileSize = fileSize;
	}

	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getDesc() {
		return Desc;
	}

	public void setDesc(String desc) {
		Desc = desc;
	}

	public String getExt() {
		return Ext;
	}

	public void setExt(String ext) {
		Ext = ext;
	}

	public String getSound() {
		return Sound;
	}

	public void setSound(String sound) {
		Sound = sound;
	}
}
