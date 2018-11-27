package com.example.zdemo.Im.util.model.msg.content;

import com.example.zdemo.Im.util.model.SendModel;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.HashSet;

public class BusMsgContent implements SendModel, IMsgContent {

  /** 消息内容 */
  private static final String BUS = "Bus";

  private Bus bus;

  public BusMsgContent(Bus bus) {
    this.bus = bus;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private Bus bus;

    public BusMsgContent.Builder addBus(String busCode,String transNo) {
      this.bus = new Bus(busCode,transNo);
      return this;
    }

    public BusMsgContent build() {
      return new BusMsgContent(bus);
    }
  }

  @Override
  public JsonElement toJSON() {
    JsonObject json = new JsonObject();
    json.add(BUS,bus.toJSON());
    return json;
  }

  public static class Bus implements SendModel{
    private String busCode;
    private String transNo;

    public Bus(String busCode, String transNo) {
      this.busCode = busCode;
      this.transNo = transNo;
    }

    @Override
    public JsonElement toJSON() {
      JsonObject json = new JsonObject();
      json.addProperty("busCode",busCode);
      json.addProperty("transNo",transNo);
      return json;
    }
  }

}
