package com.example.zdemo.Im.netty.transport.data;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class OnlineUserChannelMap {

  public static Map<Long, Channel> onlineUserChannelMap =
      new ConcurrentHashMap<Long, Channel>();

  public Channel getChannel(Long userId) {
    return onlineUserChannelMap.get(userId);
  };

  public boolean setChannel(Long userId, Channel channel) {
    return onlineUserChannelMap.put(userId,channel) !=null;
  };

  public boolean remove(Long userId){
    return onlineUserChannelMap.remove(userId) != null;
  }


}
