package com.example.zdemo.Im.util.model.msg;

import com.example.zdemo.Im.util.common.StringUtils;
import com.example.zdemo.Im.util.model.SendModel;
import com.example.zdemo.Im.util.model.msg.content.BusMsgContent;
import com.example.zdemo.Im.util.model.msg.content.CustomMsgContent;
import com.example.zdemo.Im.util.model.msg.content.ImgMsgContent;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * 发送消费对象
 */
public class SendMsgPayload implements SendModel {

  private static final String FROM_ACCOUNT = "From_Account";
  private static final String TO_ACCOUNT = "To_Account";
  private static final String MSG_TIME_STAMP = "MsgTimeStamp";
  private static final String MSG_BODY = "MsgBody";

  private String fromAccount;
  private String toAccount;
  private Long msgTimeStamp;
  private MsgBodys msgBodys;

  public SendMsgPayload(String fromAccount, String toAccount,
      Long msgTimeStamp, MsgBodys msgBodys) {
    this.fromAccount = fromAccount;
    this.toAccount = toAccount;
    this.msgTimeStamp = msgTimeStamp;
    this.msgBodys = msgBodys;
  }

  @Override
  public JsonElement toJSON() {
    JsonObject json = new JsonObject();
    if (!StringUtils.isNullOrEmpty(fromAccount)) {
      json.addProperty(FROM_ACCOUNT, fromAccount);
    }
    if (!StringUtils.isNullOrEmpty(toAccount)) {
      json.addProperty(TO_ACCOUNT, toAccount);
    }
    if (null != msgTimeStamp) {
      json.addProperty(MSG_TIME_STAMP,msgTimeStamp);
    }
    if (null != msgBodys) {
      json.add(MSG_BODY, msgBodys.toJSON());
    }

    return json;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String fromAccount;
    private String toAccount;
    private Long msgTimeStamp;
    private MsgBodys msgBodys;

    public Builder setFromAccount(String fromAccount) {
      this.fromAccount = fromAccount;
      return this;
    }

    public Builder setToAccount(String toAccount) {
      this.toAccount = toAccount;
      return this;
    }

    public Builder setMsgTimeStamp(Long msgTimeStamp) {
      this.msgTimeStamp = msgTimeStamp;
      return this;
    }

    public Builder setMsgBodys(MsgBodys msgBodys) {
      this.msgBodys = msgBodys;
      return this;
    }

    public SendMsgPayload build() {
      return new SendMsgPayload(fromAccount, toAccount, msgTimeStamp, msgBodys);
    }

  }

  @Override
  public String toString(){
    return gson.toJson(toJSON());
  }

  public static void main(String[] args) {

    SendMsgPayload s = SendMsgPayload.newBuilder()
        .setFromAccount("from")
        .setToAccount("to")
        .setMsgTimeStamp(179876666L)
        .setMsgBodys(
            MsgBodys.newBuilder().setElement(
                MsgElement.newBuilder()
                    .setMsgContent(
                        BusMsgContent.newBuilder().addBus("10910",null).build()
                    ).build()
            ).build()
        ).build()
    ;

    System.out.println(s.toString());
  }
}
