package com.example.zdemo.Im.netty.transport.handler.ws;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.handler.codec.http.websocketx.PingWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PongWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import java.util.List;

public class WebSocketProtocolHandler  extends MessageToMessageDecoder<WebSocketFrame> {

  @Override
  protected void decode(ChannelHandlerContext ctx, WebSocketFrame frame, List<Object> out) throws Exception {
    if (frame instanceof PingWebSocketFrame) {
      frame.content().retain();
      ctx.channel().writeAndFlush(new PongWebSocketFrame(frame.content()));
      return;
    }

    if (frame instanceof PongWebSocketFrame) {
      // Pong frames need to get ignored
      return;
    }

    out.add(frame.retain());
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    cause.printStackTrace();
    ctx.close();
  }

}
