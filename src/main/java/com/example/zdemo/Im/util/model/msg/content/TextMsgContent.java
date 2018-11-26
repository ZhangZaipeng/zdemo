package com.example.zdemo.Im.util.model.msg.content;

import com.example.zdemo.Im.util.model.SendModel;
import com.google.gson.JsonElement;

public class TextMsgContent implements SendModel, IMsgContent {

  /** 消息内容 */
  private static final String TEXT = "Text";

  private String text;

  public TextMsgContent(String text) {
    this.text = text;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String text;

    public TextMsgContent.Builder setText(String text) {
      this.text = text;
      return this;
    }

    public TextMsgContent build() {
      return new TextMsgContent(text);
    }
  }

  @Override
  public JsonElement toJSON() {
    return null;
  }
}
