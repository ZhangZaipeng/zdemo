package com.example.zdemo.Im;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

public interface SendModel {
  public static Gson gson = new Gson();
  public JsonElement toJSON();
}
