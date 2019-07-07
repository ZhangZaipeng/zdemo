package com.example.zdemo.utils;

import com.example.zdemo.asyncRequest.AsyncRequestClient;
import com.example.zdemo.utils.R.Content;
import com.google.gson.Gson;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

public class TMain {
  private static Gson gson = new Gson();

  public static void main(String[] args) throws Exception{

      /*HttpGet requestPost = new HttpGet("http://ms.shanxianpay.com/kaptcha");

      // 配置
      RequestConfig requestConfig = RequestConfig.custom()
          .setSocketTimeout(1000)
          .setConnectTimeout(1000)
          .setConnectionRequestTimeout(1000)
          .setExpectContinueEnabled(false).build();
      requestPost.setConfig(requestConfig);


      CloseableHttpClient httpClient = HttpClientBuilder.create().build();
      // send request
      CloseableHttpResponse response = httpClient.execute(requestPost);
      InputStream in = response.getEntity().getContent();*/

    AsyncRequestClient asyncRequestClient= AsyncRequestClient.getInstance();
    asyncRequestClient.setConcurrency(60);
    asyncRequestClient.start();

    for (int i = 0; i < 100; i++) {
      asyncRequestClient.submitTask(1000L, "action", "parameters", "method");
    }


  }
}
