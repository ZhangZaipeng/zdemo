/**
 * 
 */
package com.example.zdemo.Im.util.model.vo.custom;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 自定义消息内容主体
 * 
 * @ClassName: MsgCustomConts
 * @author huangzg 2016年12月3日 下午4:57:21
 */
public class MsgCustomConts {

	/** 自定义消息数据 */
	@JSONField(name = "Data")
	private Object data;

	public MsgCustomConts() {
		super();
	}

	public MsgCustomConts(String data) {
		super();
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
