/**
 * 
 */
package com.example.zdemo.Im.util.model.vo.img;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 图片消息内容实体类
 * 
 * @ClassName: MsgImgConts
 * @author huangzg 2017年1月13日 上午9:49:08
 */
public class MsgImgConts {

	@JSONField(name = "UUID")
	private String uuid;

	@JSONField(name = "ImageFormat")
	private Integer imageFormat;

	@JSONField(name = "ImageInfoArray")
	private Object imageInfoArray;

	public MsgImgConts() {
		super();
	}

	public MsgImgConts(String uuid, Integer imageFormat, Object imageInfoArray) {
		super();
		this.uuid = uuid;
		this.imageFormat = imageFormat;
		this.imageInfoArray = imageInfoArray;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Integer getImageFormat() {
		return imageFormat;
	}

	public void setImageFormat(Integer imageFormat) {
		this.imageFormat = imageFormat;
	}

	public Object getImageInfoArray() {
		return imageInfoArray;
	}

	public void setImageInfoArray(Object imageInfoArray) {
		this.imageInfoArray = imageInfoArray;
	}

	@Override
	public String toString() {
		return "MsgImgConts [uuid=" + uuid + ", imageFormat=" + imageFormat
				+ ", imageInfoArray=" + imageInfoArray + "]";
	}

}
