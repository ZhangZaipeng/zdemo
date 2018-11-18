package com.example.zdemo;

import cn.jpush.api.JPushClient;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example")
public class ZdemoApplication {

  public static void main(String[] args) throws Exception {
    // 输入 api key 构建 client对象
    JPushClient jPushClient = new JPushClient("82f779d50004c599d6d18130","503302f84d85a7fc2e263e35");

    // 组装  发送内容
    PushPayload pushPayload = PushPayload.newBuilder()
        .setPlatform(Platform.all())
        .setAudience(Audience.all())
        .setNotification(Notification.newBuilder()
            .setAlert("")
            .addPlatformNotification(AndroidNotification.newBuilder()
                .addExtra("id", "1")
                .addExtra("type", "type")
                .setTitle("title").build())
            .addPlatformNotification(IosNotification.newBuilder()
                .incrBadge(1)
                .addExtra("id", "1")
                .addExtra("type", "type")
                .build())
            .build())
        .setOptions(Options.newBuilder()
            .setApnsProduction(true)
            .build())
        .build();

    // jPushClient 中 有发送动作
    // jPushClient.sendPush(pushPayload);

    // 获取返回结果


    SpringApplication.run(ZdemoApplication.class, args);
  }
}
