package com.example.zdemo.Im.util.model.msg;

import com.example.zdemo.Im.util.common.StringUtils;
import com.example.zdemo.Im.util.model.SendModel;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * 发送消费对象
 */
public class SendMsgPayload implements SendModel {

  private static final String SYNC_OTHER_MACHINE = "SyncOtherMachine";
  private static final String FROM_ACCOUNT = "From_Account";
  private static final String TO_ACCOUNT = "To_Account";
  private static final String MSG_LIFE_TIME = "MsgLifeTime";
  private static final String MSG_RANDOM = "MsgRandom";
  private static final String MSG_TIME_STAMP = "MsgTimeStamp";
  private static final String MSG_BODY = "MsgBody";
  private static final String OFFLINE_PUSH_INFO = "OfflinePushInfo";

  private Integer syncOtherMachine;
  private String fromAccount;
  private String toAccount;
  private Integer msgLifeTime;
  private Integer msgRandom;
  private Integer msgTimeStamp;
  private MsgBodys msgBodys;
  private OfflinePushInfo offlinePushInfo;

  public SendMsgPayload(Integer syncOtherMachine, String fromAccount, String toAccount,
      Integer msgLifeTime, Integer msgRandom, Integer msgTimeStamp,
      MsgBodys msgBodys, OfflinePushInfo offlinePushInfo) {
    this.syncOtherMachine = syncOtherMachine;
    this.fromAccount = fromAccount;
    this.toAccount = toAccount;
    this.msgLifeTime = msgLifeTime;
    this.msgRandom = msgRandom;
    this.msgTimeStamp = msgTimeStamp;
    this.msgBodys = msgBodys;
    this.offlinePushInfo = offlinePushInfo;
  }

  @Override
  public JsonElement toJSON() {
    JsonObject json = new JsonObject();
    if (null != syncOtherMachine) {
      json.addProperty(SYNC_OTHER_MACHINE, syncOtherMachine);
    }
    if (!StringUtils.isNullOrEmpty(fromAccount)) {
      json.addProperty(FROM_ACCOUNT, fromAccount);
    }
    if (!StringUtils.isNullOrEmpty(toAccount)) {
      json.addProperty(TO_ACCOUNT, toAccount);
    }
    if (!StringUtils.isNullOrEmpty(msgLifeTime)) {
      json.addProperty(MSG_LIFE_TIME, msgLifeTime);
    }
    if (null != msgRandom) {
      json.addProperty(MSG_RANDOM, msgRandom);
    }
    if (null != msgTimeStamp) {
      json.addProperty(MSG_TIME_STAMP,msgTimeStamp);
    }
    if (null != msgBodys) {
      json.add(MSG_BODY, msgBodys.toJSON());
    }
    if (null != offlinePushInfo) {
      json.add(OFFLINE_PUSH_INFO, offlinePushInfo.toJSON());
    }

    return json;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private Integer syncOtherMachine;
    private String fromAccount;
    private String toAccount;
    private Integer msgLifeTime;
    private Integer msgRandom;
    private Integer msgTimeStamp;
    private MsgBodys msgBodys;
    private OfflinePushInfo offlinePushInfo;

    public Builder setSyncOtherMachine(Integer syncOtherMachine) {
      this.syncOtherMachine = syncOtherMachine;
      return this;
    }

    public Builder setFromAccount(String fromAccount) {
      this.fromAccount = fromAccount;
      return this;
    }

    public Builder setToAccount(String toAccount) {
      this.toAccount = toAccount;
      return this;
    }

    public Builder setMsgLifeTime(Integer msgLifeTime) {
      this.msgLifeTime = msgLifeTime;
      return this;
    }

    public Builder setMsgRandom(Integer msgRandom) {
      this.msgRandom = msgRandom;
      return this;
    }

    public Builder setMsgTimeStamp(Integer msgTimeStamp) {
      this.msgTimeStamp = msgTimeStamp;
      return this;
    }

    public Builder setMsgBodys(MsgBodys msgBodys) {
      this.msgBodys = msgBodys;
      return this;
    }

    public Builder setOfflinePushInfo(OfflinePushInfo offlinePushInfo) {
      this.offlinePushInfo = offlinePushInfo;
      return this;
    }

    public SendMsgPayload build() {
      return new SendMsgPayload(syncOtherMachine, fromAccount, toAccount,
          msgLifeTime, msgRandom, msgTimeStamp,
          msgBodys, offlinePushInfo);
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
        .setMsgRandom(123123)
        .setMsgTimeStamp(179876666)
        .setMsgBodys(
            MsgBodys.newBuilder().setElement(
                MsgElement.newBuilder()
                    .setMsgContent(CustomMsgContent.newBuilder()
                        .setData("data")
                        .setDesc("desc")
                        .setExt("ext")
                        .setSound("sound")
                        .build()).build()
            ).build()
        ).build()
    ;

    System.out.println(s.toString());
  }
}
