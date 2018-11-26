package com.example.zdemo.Im.netty.transport.handler;

import com.alibaba.fastjson.JSONObject;
import com.example.zdemo.Im.dao.UserInfoDao;
import com.example.zdemo.Im.domain.UserInfo;
import com.example.zdemo.Im.netty.transport.connection.ConnPool;
import com.google.gson.Gson;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PingWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PongWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class WebSocketServerHandler extends SimpleChannelInboundHandler<WebSocketFrame> {

  private final Logger logger = LoggerFactory.getLogger(WebSocketServerHandler.class);

  @Autowired
  private UserInfoDao userInfoDao;

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, WebSocketFrame msg) throws Exception {
    handleWebSocket(ctx, msg);
  }

  private void handleWebSocket(ChannelHandlerContext ctx, WebSocketFrame frame) {

    // 判断是否Ping消息
    if (frame instanceof PingWebSocketFrame) {
      logger.info("ping message:{}", frame.content().retain());
      ctx.writeAndFlush(new PongWebSocketFrame(frame.content().retain()));
      return;
    }
    // 判断是否Pong消息
    if (frame instanceof PongWebSocketFrame) {
      logger.info("pong message:{}", frame.content().retain());
      ctx.writeAndFlush(new PongWebSocketFrame(frame.content().retain()));
      return;
    }

    // 本程序目前只支持文本消息
    if (!(frame instanceof TextWebSocketFrame)) {
      throw new UnsupportedOperationException(frame.getClass().getName() + " frame type not supported");
    }

    TextWebSocketFrame t = (TextWebSocketFrame) frame;
    // 是否已经 完成 认证
    // yes return


    Gson g = new Gson();
    Map<String,Object> r = g.fromJson(t.text(), Map.class);
    Long userId = Long.parseLong(r.get("userId").toString());

    //  认证操作 （登录 sig + userId ） UserInfo u = userInfoDao.getByUserId(userId);

    // 成功后  添加到在线 OnlineUserMap
    ConnPool.add(userId,ctx.channel());

    // 并返回 成功消息
    ctx.write("atuh success");
    // test
    ctx.writeAndFlush(frame.retain());

  }

}
