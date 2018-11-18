/**
 * 
 */
package com.example.zdemo.Im.util.model.vo.img;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 图片消息内容数据实体类
 * 
 * @ClassName: MsgImgData
 * @author huangzg 2017年1月13日 上午9:49:47
 */
public class MsgImgData {

	@JSONField(name = "Type")
	private Integer type;

	@JSONField(name = "Size")
	private Integer size;

	@JSONField(name = "Width")
	private Integer width;

	@JSONField(name = "Height")
	private Integer height;

	@JSONField(name = "URL")
	private String url;

	public MsgImgData() {
		super();
	}

	public MsgImgData(Integer type, Integer size, Integer width,
			Integer height, String url) {
		super();
		this.type = type;
		this.size = size;
		this.width = width;
		this.height = height;
		this.url = url;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "MsgImgData [type=" + type + ", size=" + size + ", width="
				+ width + ", height=" + height + ", url=" + url + "]";
	}

}
