package com.example.zdemo.Im.util.model.msg.content;

import com.example.zdemo.Im.util.common.StringUtils;
import com.example.zdemo.Im.util.model.SendModel;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class CustomMsgContent implements SendModel, IMsgContent {

  /**  */
  private static final String DATA = "Data";

  private String data;

  public CustomMsgContent(String data) {
    this.data = data;
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
    return json;
  }

  public static class Builder {
    private String data;

    public Builder setData(String data) {
      this.data = data;
      return this;
    }

    public CustomMsgContent build() {
      return new CustomMsgContent(data);
    }
  }

}
