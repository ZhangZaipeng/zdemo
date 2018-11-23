package com.example.zdemo.Im.netty.transport.data;

import io.netty.channel.Channel;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class OnlineChannelUserMap {
  public static Map<Channel, Long> onlineChannelUserMap =
      new ConcurrentHashMap<Channel, Long>();

  public Long getUserId(Channel channel) {
    return onlineChannelUserMap.get(channel);
  };

  public boolean setChannel(Channel channel, Long userId) {
    return onlineChannelUserMap.put(channel,userId) !=null;
  };

  public boolean remove(Channel channel){
    return onlineChannelUserMap.remove(channel) != null;
  }
}
