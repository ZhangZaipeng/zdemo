package com.example.zdemo.Im.netty.transport.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshakerFactory;
import io.netty.handler.ssl.SslHandler;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpRequestHandler extends SimpleChannelInboundHandler<Object> {

  private static final Logger logger = LoggerFactory.getLogger(HttpRequestHandler.class);

  private WebSocketServerHandshaker handshaker;

  private String websocketPath;

  public HttpRequestHandler(String websocketPath) {
    this.websocketPath = websocketPath;
  }

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, Object msg) {

    if (msg instanceof FullHttpRequest) {
      FullHttpRequest request = (FullHttpRequest) msg;
      if (request.decoderResult().isSuccess() && "websocket".equals(request.headers().get("Upgrade"))) {
        // websocket 协议升级
        handleHttpRequest(ctx, request);
      } else{
        // 响应
        sendHttpResponse(ctx, request,
            new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
      }

    } else if (msg instanceof CloseWebSocketFrame) { // 判断是否关闭链路命令
      handshaker.close(ctx.channel(), ((CloseWebSocketFrame) msg).retain());

    } else if (msg instanceof WebSocketFrame) {
      ctx.fireChannelRead(((WebSocketFrame) msg).retain());
    }

  }

  /**
   * 描述：处理Http请求，主要是完成HTTP协议到Websocket协议的升级
   */
  private void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest req) {

    final WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory(
        getWebSocketLocation(ctx.pipeline(), req, websocketPath), null,
        false, 65536, false);

    handshaker = wsFactory.newHandshaker(req);

    if (handshaker == null) {
      WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
    } else {
      // 动态加入websocket的编解码处理
      handshaker.handshake(ctx.channel(), req);
      // 存储 handshaker  (******)
    }
  }

  private static String getWebSocketLocation(ChannelPipeline cp, HttpRequest req, String path) {
    String protocol = "ws";
    if (cp.get(SslHandler.class) != null) {
      // SSL in use so use Secure WebSockets
      protocol = "wss";
    }
    return protocol + "://" + req.headers().get(HttpHeaderNames.HOST) + path;
  }

  /**
   * 返回http 响应
   */
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
