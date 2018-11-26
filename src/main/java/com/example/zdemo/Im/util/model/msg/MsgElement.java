package com.example.zdemo.Im.util.model.msg;

import com.example.zdemo.Im.util.model.SendModel;
import com.example.zdemo.Im.util.model.msg.content.IMsgContent;
import com.example.zdemo.Im.util.model.msg.content.IMsgContent.M_TYPE;
import com.example.zdemo.Im.util.model.msg.content.CustomMsgContent;
import com.example.zdemo.Im.util.model.msg.content.TextMsgContent;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class MsgElement implements SendModel {
  /** 消息类型 */
  private static final String MSG_TYPE = "MsgType";
  private static final String MSG_CONTENT = "MsgContent";

  private IMsgContent msgContent;

  public MsgElement(IMsgContent msgContent) {
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
      } else if (msgContent instanceof TextMsgContent) {
        json.addProperty(MSG_TYPE, M_TYPE.TextType.getMsyType());
        json.add(MSG_CONTENT, ((TextMsgContent) msgContent).toJSON());
      }
    }

    return json;
  }

  public static class Builder {
    private IMsgContent msgContent;

    public Builder setMsgContent(IMsgContent msgContent) {
      this.msgContent = msgContent;
      return this;
    }

    public MsgElement build() {
      return new MsgElement(msgContent);
    }
  }
}
