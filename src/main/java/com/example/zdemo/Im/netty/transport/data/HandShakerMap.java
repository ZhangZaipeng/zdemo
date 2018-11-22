package com.example.zdemo.Im.netty.transport.data;

import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class HandShakerMap {

  public Map<Long, WebSocketServerHandshaker> webSocketHandshakerMap
      = new ConcurrentHashMap<Long, WebSocketServerHandshaker>();

  public boolean remove(Long userId){
    return webSocketHandshakerMap.remove(userId) != null;
  }


}
