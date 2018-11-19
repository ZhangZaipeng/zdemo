package com.example.zdemo.Im;

import com.example.zdemo.Im.util.common.HClient;
import com.example.zdemo.Im.util.common.ImConstans;
import com.example.zdemo.Im.util.model.msg.CustomMsgContent;
import com.example.zdemo.Im.util.model.msg.MsgBodys;
import com.example.zdemo.Im.util.model.msg.MsgElement;
import com.example.zdemo.Im.util.model.msg.SendMsgPayload;
import com.example.zdemo.Im.util.model.result.C2CResult;

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

    C2CResult b = HClient.sendPost(ImConstans.SEND_MSG,s.toString());

    System.out.println(b.isResultOK());

  }
}
