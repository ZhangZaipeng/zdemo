package com.example.zdemo.Im;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    List<Map<String, String>> r = new ArrayList<>();
    Map<String, String> p1 = new HashMap<>();
    p1.put("1", "1");
    p1.put("2", "2");
    p1.put("3", "3");
    Map<String, String> p2 = new HashMap<>();
    p2.put("1", "1");
    p2.put("2", "2");
    p2.put("3", "3");

    r.add(p1);
    r.add(p2);
    Gson gson = new Gson();

  }
}
