package com.example.zdemo.Im.netty.transport.handler.ws;

import static io.netty.handler.codec.http.HttpMethod.GET;
import static io.netty.handler.codec.http.HttpResponseStatus.FORBIDDEN;
import static io.netty.handler.codec.http.HttpUtil.isKeepAlive;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshakerFactory;
import io.netty.handler.ssl.SslHandler;

public class WebSocketServerProtocolHandshakeHandler extends ChannelInboundHandlerAdapter {

  private final String websocketPath;
  private final String subprotocols;
  private final boolean allowExtensions;
  private final int maxFramePayloadSize;
  private final boolean allowMaskMismatch;

  WebSocketServerProtocolHandshakeHandler(String websocketPath, String subprotocols,
      boolean allowExtensions, int maxFrameSize, boolean allowMaskMismatch) {
    this.websocketPath = websocketPath;
    this.subprotocols = subprotocols;
    this.allowExtensions = allowExtensions;
    maxFramePayloadSize = maxFrameSize;
    this.allowMaskMismatch = allowMaskMismatch;
  }

  @Override
  public void channelRead(final ChannelHandlerContext ctx, Object msg) throws Exception {
    final FullHttpRequest req = (FullHttpRequest) msg;
    if (!websocketPath.equals(req.uri())) {
      ctx.fireChannelRead(msg);
      return;
    }

    try {
      if (req.method() != GET) {
        sendHttpResponse(ctx, req, new DefaultFullHttpResponse(HTTP_1_1, FORBIDDEN));
        return;
      }

      final WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory(
          getWebSocketLocation(ctx.pipeline(), req, websocketPath), subprotocols,
          allowExtensions, maxFramePayloadSize, allowMaskMismatch);
      final WebSocketServerHandshaker handshaker = wsFactory.newHandshaker(req);
      if (handshaker == null) {
        WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
      } else {
        final ChannelFuture handshakeFuture = handshaker.handshake(ctx.channel(), req);
        handshakeFuture.addListener(new ChannelFutureListener() {
          @Override
          public void operationComplete(ChannelFuture future) throws Exception {
            if (!future.isSuccess()) {
              ctx.fireExceptionCaught(future.cause());
            } else {
              // Kept for compatibility
              ctx.fireUserEventTriggered(
                  io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler.ServerHandshakeStateEvent.HANDSHAKE_COMPLETE);
              ctx.fireUserEventTriggered(
                  new WebSocketServerProtocolHandler.HandshakeComplete(
                      req.uri(), req.headers(), handshaker.selectedSubprotocol()));
            }
          }
        });
        WebSocketServerProtocolHandler
            .setHandshaker(ctx.channel(), handshaker);
        ctx.pipeline().replace(this, "WS403Responder",
            WebSocketServerProtocolHandler.forbiddenHttpRequestResponder());
      }
    } finally {
      req.release();
    }
  }

  private static void sendHttpResponse(ChannelHandlerContext ctx, HttpRequest req, HttpResponse res) {
    ChannelFuture f = ctx.channel().writeAndFlush(res);
    if (!isKeepAlive(req) || res.status().code() != 200) {
      f.addListener(ChannelFutureListener.CLOSE);
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

}
