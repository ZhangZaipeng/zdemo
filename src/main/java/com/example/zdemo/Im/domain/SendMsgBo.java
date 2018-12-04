package com.example.zdemo.Im.domain;

public class SendMsgBo {

  private String sendUserId;
  private String receivUserId;
  private String content;
  private String type;
  private String sig;

  public String getSig() {
    return sig;
  }

  public void setSig(String sig) {
    this.sig = sig;
  }

  public String getSendUserId() {
    return sendUserId;
  }

  public void setSendUserId(String sendUserId) {
    this.sendUserId = sendUserId;
  }

  public String getReceivUserId() {
    return receivUserId;
  }

  public void setReceivUserId(String receivUserId) {
    this.receivUserId = receivUserId;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
