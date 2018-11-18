/**
 * 
 */
package com.example.zdemo.Im;

import com.alibaba.fastjson.annotation.JSONField;
import com.example.zdemo.Http.StringUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * 离线推送 OfflinePushInfo 说明
 * 
 * @ClassName: OfflinePushInfo
 * @author huangzg 2016年12月17日 上午9:51:38
 */
public class OfflinePushInfo implements SendModel{

	private static final String PUSH_FLAG = "PushFlag";
	private static final String TITLE = "Title";
	private static final String DESC = "Desc";
	private static final String EXT = "Ext";

	private Integer pushFlag;
	private String title;
	private String desc;
	private String ext;

	public OfflinePushInfo(Integer pushFlag, String title, String desc, String ext) {
		this.pushFlag = pushFlag;
		this.title = title;
		this.desc = desc;
		this.ext = ext;
	}


	@Override
	public JsonElement toJSON() {
		JsonObject json = new JsonObject();
		if (null != pushFlag) {
			json.addProperty(PUSH_FLAG, pushFlag);
		}
		if (!StringUtils.isNullOrEmpty(title)) {
			json.addProperty(TITLE, title);
		}
		if (!StringUtils.isNullOrEmpty(desc)) {
			json.addProperty(DESC, desc);
		}
		if (!StringUtils.isNullOrEmpty(ext)) {
			json.addProperty(EXT, ext);
		}

		return json;
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	public static class Builder {
		private Integer pushFlag;
		private String title;
		private String desc;
		private String ext;

		public Builder setPushFlag(Integer pushFlag) {
			this.pushFlag = pushFlag;
			return this;
		}

		public Builder setTitle(String title) {
			this.title = title;
			return this;
		}

		public Builder setDesc(String desc) {
			this.desc = desc;
			return this;
		}

		public Builder setExt(String ext) {
			this.ext = ext;
			return this;
		}

		public OfflinePushInfo build() {
			return new OfflinePushInfo(pushFlag,title,desc,ext);
		}
	}
}
