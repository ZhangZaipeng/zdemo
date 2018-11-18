/**
 * 
 */
package com.example.zdemo.Im.util.model.vo.text;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 文字消息内容实体类
 * 
 * @ClassName: MsgTextConts
 * @author huangzg 2017年1月13日 上午10:05:14
 */
public class MsgTextConts {
	/** 消息内容 */
	@JSONField(name = "Text")
	private String text;

	public MsgTextConts() {
		super();
	}

	public MsgTextConts(String text) {
		super();
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "MsgTextConts [text=" + text + "]";
	}
}
