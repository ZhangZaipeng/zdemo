package com.example.zdemo.Im.netty.transport.handler;

import com.example.zdemo.Im.netty.transport.connection.ConnPool;
import com.example.zdemo.Im.netty.transport.connection.HeartbeatPool;
import com.example.zdemo.Im.netty.transport.protocol.MessageHolder;
import com.example.zdemo.Im.netty.transport.protocol.ProtocolHeader;
import com.example.zdemo.Im.util.common.StringUtils;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.ReferenceCountUtil;
import java.util.concurrent.atomic.AtomicBoolean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 心跳检测Handler
 * <p>
 */
public class HeartbeatHandler extends ChannelInboundHandlerAdapter {

  private final Logger logger = LoggerFactory.getLogger(HeartbeatHandler.class);

  public AtomicBoolean isLogout = new AtomicBoolean(false);

  private Channel channel;
  private String userId;

  // 丢失的心跳数
  private int counter = 0;

  public HeartbeatHandler(Channel channel) {
    this.channel = channel;
  }

  @Override
  public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
    if (evt instanceof IdleStateEvent) {
      if (StringUtils.isNullOrEmpty(userId)) {
        userId = ConnPool.query(channel);
      }
      logger.info("userEventTriggered : 触发心跳操作 userId" + userId);
      // 并写出 心跳消息
      ctx.writeAndFlush(new TextWebSocketFrame(""));
      // 添加 记录
      Integer r = HeartbeatPool.addHeartbeat(userId);
      if (r > 0) {
        logger.info(userId + " 丢失" + counter + "个心跳包");
      }

      if (r > 4) {
        // 心跳丢失数达到5个，主动断开连接
        ctx.channel().close();
      }
    } else {
      super.userEventTriggered(ctx, evt);
    }
  }

  @Override
  public void channelInactive(ChannelHandlerContext ctx) throws Exception {
    ConnPool.remove(username);
    if (isLogout.get()) {
      isLogout.set(false);
      logger.info(username + " 退出登录");
    } else {
      logger.info(username + " 与服务器断开连接");
    }
  }

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    if (msg instanceof TextWebSocketFrame) {
      // TextWebSocketFrame 转码判断   --> 客户端发送的 心跳信息
      if (messageHolder.getType() == ProtocolHeader.HEARTBEAT) {
        if (StringUtils.isNullOrEmpty(userId)) {
          userId = ConnPool.query(channel);
        }
        // 心跳丢失清零
        HeartbeatPool.remove(userId);
        logger.info(userId + " 收到心跳包");

        // 释放消息
        ReferenceCountUtil.release(msg);
      } else {
        ctx.fireChannelRead(msg);
      }
    }
  }
}
