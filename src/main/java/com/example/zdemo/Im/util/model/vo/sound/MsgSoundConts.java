/**
 * 
 */
package com.example.zdemo.Im.util.model.vo.sound;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 语音消息内容
 * 
 * @ClassName: MsgSoundConts
 * @author huangzg 2017年2月27日 下午5:59:41
 */
public class MsgSoundConts {
	
	@JSONField(name = "Data")
	private String data;

	public MsgSoundConts() {
		super();
	}

	public MsgSoundConts(String data) {
		super();
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	

}
