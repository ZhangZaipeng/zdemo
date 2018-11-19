/**
 * 
 */
package com.example.zdemo.Im.util.model.msg;

import com.example.zdemo.Im.util.model.SendModel;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.util.HashSet;
import java.util.Set;

/**
 * 消息表体实体类
 *
 * @ClassName: MsgBody
 * @author zhangzp
 */
public class MsgBodys implements SendModel {

	private Set<MsgElement> msgElements;

	public MsgBodys(Set<MsgElement> msgElements) {
		this.msgElements = msgElements;
	}

	public Set<MsgElement> getMsgElements() {
		return msgElements;
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	@Override
	public JsonElement toJSON() {
		JsonArray json = new JsonArray();

		if (null != msgElements) {
			for (MsgElement e : msgElements) {
				json.add(e.toJSON());
			}
		}
		return json;
	}

	public static class Builder {
		private Set<MsgElement> msgElements;

		public Builder addElement(MsgElement e){
			if (msgElements == null) {
				msgElements = new HashSet<>();
			}
			msgElements.add(e);
			return this;
		}
		public MsgBodys build() {
			return new MsgBodys(msgElements);
		}
	}
}
