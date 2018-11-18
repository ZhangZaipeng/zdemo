package com.example.zdemo.Im;

public class TMain {

  public static void main(String[] args) {
    SendMsgPayload s = SendMsgPayload.newBuilder()
        .setFromAccount("from")
        .setToAccount("234324")
        .setMsgBodys(
            MsgBodys.newBuilder().addElement(
                MsgElement.newBuilder().setMsgContent(
                    CustomMsgContent.newBuilder()
                        .setData("data")
                        .setDesc("desc")
                        .setExt("ext").build()
                ).build()
            ).addElement(
                MsgElement.newBuilder().setMsgContent(
                    CustomMsgContent.newBuilder()
                        .setData("data")
                        .setDesc("desc")
                        .setExt("ext").build()
                ).build()
            ).build()
        ).build();
    System.out.println(s.toString());
  }
}
