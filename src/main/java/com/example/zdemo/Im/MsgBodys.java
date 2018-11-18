/**
 * 
 */
package com.example.zdemo.Im;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.HashSet;
import java.util.Set;

/**
 * 消息表体实体类
 *
 * @ClassName: MsgBody
 * @author zhangzp
 */
public class MsgBodys {

	private Set<MsgElement> msgElements;

	public MsgBodys(Set<MsgElement> msgElements) {
		this.msgElements = msgElements;
	}

	public static Builder newBuilder() {
		return new Builder();
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
		public Set<MsgElement> build() {
			return msgElements;
		}
	}
}
