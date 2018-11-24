package com.example.zdemo.Im.netty.transport.handler;

import com.example.zdemo.Im.netty.transport.connection.ConnPool;
import com.example.zdemo.Im.netty.transport.protocol.MessageHolder;
import com.example.zdemo.Im.netty.transport.protocol.ProtocolHeader;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.ReferenceCountUtil;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 心跳检测Handler
 * <p>
 */

@Component
@Scope("singleton")
public class HeartbeatHandler extends ChannelInboundHandlerAdapter {
    /*private final Logger logger = Logger.getLogger(HeartbeatHandler.class);

    public AtomicBoolean isLogout = new AtomicBoolean(false);

    @Autowired
    private ConnPool connPool;

    private Channel channel;
    private Long userId;

    // 丢失的心跳数
    private int counter = 0;

    public HeartbeatHandler(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {

            if (userId == null) {
                userId = ConnPool.query(channel);
            }
            // 心跳丢失
            counter++;
            logger.info(userId + " 丢失" + counter + "个心跳包");
            if (counter > 4) {
                // 心跳丢失数达到5个，主动断开连接
                ctx.channel().close();
            }
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
        if (msg instanceof MessageHolder) {
            MessageHolder messageHolder = (MessageHolder) msg;
            if (messageHolder.getType() == ProtocolHeader.HEARTBEAT) {
                if (username == null) {
                    username = ConnPool.query(channel);
                }
                // 心跳丢失清零
                counter = 0;
//                logger.info(username + " 收到心跳包");
                ReferenceCountUtil.release(msg);
            } else {
                ctx.fireChannelRead(msg);
            }
        }
    }*/
}
