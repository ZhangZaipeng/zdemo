package com.example.zdemo.Im.util.model.result;

import com.example.zdemo.Im.util.common.StringUtils;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class C2CResult {

  private String ActionStatus;
  private String ErrorInfo;
  private String ErrorCode;

  private static final Logger logger = LoggerFactory.getLogger(C2CResult.class);

  private static final Gson gson = new Gson();

  public C2CResult fromResponse(String json) {
    if (StringUtils.isNullOrEmpty(json)) {return null;}

    try {
      new JsonParser().parse(json);
    } catch (JsonParseException e) {
      logger.error("bad content: " + json + "not json");
    }

    return gson.fromJson(json, C2CResult.class);
  }

  public boolean isResultOK() { if ("OK".equals(this.ActionStatus)) {return true;} return false;}
}
