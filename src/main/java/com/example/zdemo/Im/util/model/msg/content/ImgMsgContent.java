package com.example.zdemo.Im.util.model.msg.content;

import com.example.zdemo.Im.util.model.SendModel;
import com.example.zdemo.Im.util.model.msg.MsgElement;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.HashSet;
import java.util.Set;

public class ImgMsgContent implements SendModel, IMsgContent {

  /** 消息内容 */
  private static final String IMGS = "Imgs";

  private Set<Img> imgs;

  public ImgMsgContent(Set<Img> imgs) {
    this.imgs = imgs;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private Set<Img> imgs = new HashSet<>();

    public ImgMsgContent.Builder addImg(Integer width, Integer height,String url) {
      this.imgs.add(new Img(width,height,url));
      return this;
    }

    public ImgMsgContent build() {
      return new ImgMsgContent(imgs);
    }
  }

  @Override
  public JsonElement toJSON() {
    JsonObject json = new JsonObject();

    if (imgs != null && imgs.size() > 0) {
      JsonArray jsonA = new JsonArray();
      for (Img e : imgs) {
        jsonA.add(e.toJSON());
      }

      json.add(IMGS,jsonA);
    }

    return json;
  }

  public static class Img implements SendModel{
    private Integer width;
    private Integer height;
    private String url;

    public Img(Integer width, Integer height, String url) {
      this.width = width;
      this.height = height;
      this.url = url;
    }

    @Override
    public JsonElement toJSON() {
      JsonObject json = new JsonObject();
      json.addProperty("width",width);
      json.addProperty("height",height);
      json.addProperty("url",url);
      return json;
    }
  }
}
