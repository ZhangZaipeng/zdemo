package com.example.zdemo.Im.netty.transport.handler;

import com.example.zdemo.Im.netty.transport.queue.TaskQueue;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshakerFactory;
import io.netty.util.CharsetUtil;
import java.util.concurrent.BlockingQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpReqHandler extends SimpleChannelInboundHandler<Object> {

  private static final Logger logger = LoggerFactory.getLogger(HttpReqHandler.class);

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, Object msg) {
    if (msg instanceof FullHttpRequest) {
      handleHttpRequest(ctx, (FullHttpRequest) msg);
    } else if (msg instanceof WebSocketFrame) {
      ctx.fireChannelRead(((WebSocketFrame) msg).retain());
    }
    /*else if (msg instanceof WebSocketFrame) {
      handleWebSocket(ctx, (WebSocketFrame) msg);
    }*/
  }

  private void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest request) {
    if (!request.decoderResult().isSuccess() || !"websocket".equals(request.headers().get("Upgrade"))) {
      sendHttpResponse(ctx, request,
          new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
      return;
    }

    WebSocketServerHandshakerFactory handshakerFactory = new WebSocketServerHandshakerFactory(
        "ws://localhost:8099/websocket", null, true);
    /*WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory(
        "ws:/" + ctx.channel() + "/websocket", null, false);*/
    handshaker = handshakerFactory.newHandshaker(request);
    if (handshaker == null) {
      WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
    } else {
      // 动态加入websocket的编解码处理
      handshaker.handshake(ctx.channel(), request);
      // 记录 channel 用来响应CloseWebSocketFrame的请求；
    }
  }

  private void sendHttpResponse(ChannelHandlerContext ctx, FullHttpRequest req, DefaultFullHttpResponse res) {
    // 返回应答给客户端
    if (res.status().code() != 200) {
      ByteBuf buf = Unpooled.copiedBuffer(res.status().toString(), CharsetUtil.UTF_8);
      res.content().writeBytes(buf);
      buf.release();
    }
    // 如果是非Keep-Alive，关闭连接
    boolean keepAlive = HttpUtil.isKeepAlive(req);
    ChannelFuture f = ctx.channel().writeAndFlush(res);
    if (!keepAlive) {
      f.addListener(ChannelFutureListener.CLOSE);
    }
  }

  /**
   * 描述：异常处理，关闭channel
   */
  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    cause.printStackTrace();
    ctx.close();
  }
}