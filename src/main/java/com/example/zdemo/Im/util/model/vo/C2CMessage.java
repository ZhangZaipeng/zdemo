package com.example.zdemo.Im.util.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class C2CMessage {

  @JsonProperty("MsgType")
  private String msgType;

  public String getMsgType() {
    return msgType;
  }

  public void setMsgType(String msgType) {
    this.msgType = msgType;
  }

}
