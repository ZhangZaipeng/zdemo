package com.example.zdemo.Im.netty.transport.handler;

import com.alibaba.fastjson.JSONObject;
import com.example.zdemo.Im.netty.transport.connection.ConnPool;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PingWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PongWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebSocketServerHandler extends SimpleChannelInboundHandler<WebSocketFrame> {

  private final Logger logger = LoggerFactory.getLogger(WebSocketServerHandler.class);

  private WebSocketServerHandshaker webSocketServerHandshaker;

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

    //  认证操作 （登录 sig + userId ）

    // 成功后  添加到在线 OnlineUserMap

    // 并返回 成功消息

    // test
    ctx.writeAndFlush(frame.retain());

    // ConnPool.add()

  }

}
