package com.example.zdemo.Im.util.model.msg;

import com.example.zdemo.Im.util.model.SendModel;
import com.example.zdemo.Im.util.model.msg.MsgContent.M_TYPE;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class MsgElement implements SendModel {
  /** 消息类型 */
  private static final String MSG_TYPE = "MsgType";
  private static final String MSG_CONTENT = "MsgContent";

  private MsgContent msgContent;

  public MsgElement(MsgContent msgContent) {
    this.msgContent = msgContent;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @Override
  public JsonElement toJSON() {
    JsonObject json = new JsonObject();

    if (null != msgContent) {
      if(msgContent instanceof CustomMsgContent) {
        json.addProperty(MSG_TYPE, M_TYPE.CustomType.getMsyType());
        json.add(MSG_CONTENT, ((CustomMsgContent) msgContent).toJSON());
      }
    }

    return json;
  }

  public static class Builder {
    private MsgContent msgContent;

    public Builder setMsgContent(MsgContent msgContent) {
      this.msgContent = msgContent;
      return this;
    }

    public MsgElement build() {
      return new MsgElement(msgContent);
    }
  }
}
