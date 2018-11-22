package com.example.zdemo.Im.netty.transport.data;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OnlineUserMap {
  public static Map<Long, ChannelHandlerContext> onlineUserMap =
      new ConcurrentHashMap<Long, ChannelHandlerContext>();

  public Channel getChannel(Long userId) {
    return onlineUserMap.get(userId).channel();
  };

  public boolean remove(Long userId){
    return onlineUserMap.remove(userId) != null;
  }
}
