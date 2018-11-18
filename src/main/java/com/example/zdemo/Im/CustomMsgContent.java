package com.example.zdemo.Im;

import com.example.zdemo.Http.StringUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class CustomMsgContent implements SendModel, MsgContent {

  /** 消息内容 */
  private static final String DATA = "Data";
  private static final String DESC = "Desc";
  private static final String EXT = "Ext";
  private static final String SOUND = "Sound";

  private String data;
  private String desc;
  private String ext;
  private String sound;

  public CustomMsgContent(String data, String desc, String ext, String sound) {
    this.data = data;
    this.desc = desc;
    this.ext = ext;
    this.sound = sound;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @Override
  public JsonElement toJSON() {
    JsonObject json = new JsonObject();
    if (!StringUtils.isNullOrEmpty(data)) {
      json.addProperty(DATA, data);
    }
    if (!StringUtils.isNullOrEmpty(desc)) {
      json.addProperty(DESC, desc);
    }
    if (!StringUtils.isNullOrEmpty(ext)) {
      json.addProperty(EXT, ext);
    }
    if (!StringUtils.isNullOrEmpty(sound)) {
      json.addProperty(SOUND, sound);
    }

    return json;
  }

  public static class Builder {
    private String data;
    private String desc;
    private String ext;
    private String sound;

    public Builder setData(String data) {
      this.data = data;
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

    public Builder setSound(String sound) {
      this.sound = sound;
      return this;
    }

    public CustomMsgContent build() {
      return new CustomMsgContent(data, desc, ext, sound);
    }
  }

}
