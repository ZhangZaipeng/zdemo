package com.example.zdemo.Im.util.common;

import com.example.zdemo.Im.util.model.result.C2CResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HClient {

  private static final Logger logger = LoggerFactory.getLogger(HClient.class);

  private static final int _maxRetryTimes = 3;

  public static C2CResult sendPost(String url, String content) {
    C2CResult baseResult = new C2CResult();
    for (int retryTimes = 0; ; retryTimes++) {
      try {
        String res = HttpStreamUtil.invokePost(url, content);

        baseResult = baseResult.fromResponse(res);

        break;
      } catch (Exception e) {
        if (retryTimes >= _maxRetryTimes) {
          logger.error("connect erorr - retry again - " , e);
        } else {
          logger.debug("connect timed out - retry again - " + (retryTimes + 1));
        }
      }
    }

    return baseResult;
  }
}
