package com.example.zdemo.Im.netty.transport.handler;

import com.example.zdemo.Im.netty.transport.data.ReceiveQueue;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PingWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PongWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import java.util.concurrent.BlockingQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextWebSocketHandler extends SimpleChannelInboundHandler<WebSocketFrame> {

  private static final Logger logger = LoggerFactory.getLogger(HttpReqHandler.class);


  public TextWebSocketHandler(){
    super();
  }

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, WebSocketFrame msg) throws Exception {
    handleWebSocket(ctx, msg);
  }

  private void handleWebSocket(ChannelHandlerContext ctx, WebSocketFrame frame) {

    //  认证操作 （登录 sig + userId ）

    // 成功后  添加到在线 OnlineUserMap

    // 并返回 消息

    return;
  }


  /**
   * 描述：
   */
  @Override
  public void channelInactive(ChannelHandlerContext ctx) throws Exception {
    // chatService.remove(ctx);
  }

  /**
   * 异常处理：关闭channel
   */
  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
    cause.printStackTrace();
    ctx.close();
  }
}
