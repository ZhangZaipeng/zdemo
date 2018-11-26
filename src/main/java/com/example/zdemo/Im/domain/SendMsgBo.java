package com.example.zdemo.Im.domain;

public class SendMsgBo {

  private Long sendUserId;
  private Long receivUserId;
  private String content;
  private String type;

  public Long getSendUserId() {
    return sendUserId;
  }

  public void setSendUserId(Long sendUserId) {
    this.sendUserId = sendUserId;
  }

  public Long getReceivUserId() {
    return receivUserId;
  }

  public void setReceivUserId(Long receivUserId) {
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
