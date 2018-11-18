/**
 * 
 */
package com.example.zdemo.Im.util.model.vo.sound;

/**
 * 语音消息内容
 * 
 * @ClassName: SoundText
 * @author huangzg 2017年2月27日 下午6:00:29
 */
public class SoundText {

	private SoundTextConts data;

	private Integer type;

	public SoundText() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SoundText(SoundTextConts data, Integer type) {
		super();
		this.data = data;
		this.type = type;
	}

	public SoundTextConts getData() {
		return data;
	}

	public void setData(SoundTextConts data) {
		this.data = data;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
