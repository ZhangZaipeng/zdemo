package com.example.zdemo.Im.netty.transport.handler;

import com.alibaba.fastjson.JSONObject;
import com.example.zdemo.Im.dao.UserInfoDao;
import com.example.zdemo.Im.domain.UserInfo;
import com.example.zdemo.Im.netty.transport.connection.ConnPool;
import com.example.zdemo.Im.util.common.StringUtils;
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
import org.bouncycastle.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class WebSocketServerHandler extends SimpleChannelInboundHandler<WebSocketFrame> {

  private final Logger logger = LoggerFactory.getLogger(WebSocketServerHandler.class);

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
    if (!authLogin(t, ctx)){
      ctx.close();
    }
  }

  private Boolean authLogin(TextWebSocketFrame t, ChannelHandlerContext ctx) {

    // 解析数据
    String data = t.text();
    logger.info("authLogin =====> " + data);
    String[] s = StringUtils.splitFirst(data,"&");

    if (s.length == 2) {
      String userId = s[0];
      String sig = s[1];
      // 判断 sig redis 中
      if (sig.equals("")) { // 认证正确
        ConnPool.add(userId,ctx.channel());

        // 添加心跳检测
        ctx.channel().pipeline().addAfter("IdleStateHandler",
            "HeartbeatHandler", new HeartbeatHandler(ctx.channel()));

        // 并返回 成功消息
        ctx.writeAndFlush("atuh_ok");
        return true;
      }
      logger.error("authLogin =====> sig 校验错误 ");
      return false;
    }
    logger.error("authLogin =====> 错误 认证数据结构 ");
    return false;
  }

}
