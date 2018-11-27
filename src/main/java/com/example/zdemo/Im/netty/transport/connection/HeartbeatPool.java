package com.example.zdemo.Im.netty.transport.connection;

import io.netty.channel.Channel;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HeartbeatPool {
  private static final Logger logger = LoggerFactory.getLogger(HeartbeatPool.class);

  private HeartbeatPool(){}

  // 用于存放在线用户的 userId 和 失去的心跳次数
  private static Map<String, Integer> heartbeatsMap =
      new ConcurrentHashMap<>();

  // 添加心跳次数
  public synchronized static Integer addHeartbeat(String userId) {
    Integer r = heartbeatsMap.get(userId);
    if (r == null) {
      return heartbeatsMap.put(userId, 0) ;
    }

    return heartbeatsMap.put(userId, r+1) ;
  }

  // 删除心跳次数
  public synchronized static Integer remove(String userId){
    return heartbeatsMap.remove(userId) ;
  }
}
