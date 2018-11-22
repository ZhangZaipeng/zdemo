package com.example.zdemo.Im.netty.transport.handler;

import com.example.zdemo.Im.netty.transport.queue.TaskQueue;
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

public class WebSocketServerHandler extends SimpleChannelInboundHandler<WebSocketFrame> {

  private static final Logger logger = LoggerFactory.getLogger(HttpReqHandler.class);

  private final BlockingQueue<TextWebSocketFrame> taskQueue;

  public WebSocketServerHandler(){
    super();
    taskQueue = TaskQueue.getQueue();
  }

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, WebSocketFrame msg) throws Exception {
    handleWebSocket(ctx, msg);
  }

  private void handleWebSocket(ChannelHandlerContext ctx, WebSocketFrame frame) {

    // 判断是否关闭链路命令
    if (frame instanceof CloseWebSocketFrame) {
      // 移除 channel 用来响应CloseWebSocketFrame的请求；     ‘
      // handshaker.close(ctx.channel(), (CloseWebSocketFrame) frame.retain());
      return;
    }

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

    // 二进制
    if (!(frame instanceof TextWebSocketFrame)) {
      throw new UnsupportedOperationException(frame.getClass().getName() + " frame type not supported");
    }

    //  认证操作
    logger.info("TaskQueue添加任务: taskQueue=" + taskQueue.size());

    return;
  }


  /**
   * 描述：客户端断开连接
   */
  @Override
  public void channelInactive(ChannelHandlerContext ctx) throws Exception {
    chatService.remove(ctx);
  }

  /**
   * 异常处理：关闭channel
   */
  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    cause.printStackTrace();
    ctx.close();
  }
}
