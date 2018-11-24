package com.example.zdemo.Im.netty.transport.netty;

import com.example.zdemo.Im.netty.transport.handler.HadlerInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.Future;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * The implementation of NettyConfig.
 *
 */
@Component
public class NettyServerImpl implements NettyServer {
    private static final Logger logger = Logger.getLogger(NettyServerImpl.class);


    private ChannelFuture future;
    private ServerBootstrap bootstrap;
    private EventLoopGroup parentGroup;
    private EventLoopGroup childGroup;
    private Class channelClass;

    public NettyServerImpl() {
        bootstrap = new ServerBootstrap();
    }

    @Override
    public void setParentGroup() {
        parentGroup = new NioEventLoopGroup();
    }

    @Override
    public void setParentGroup(int nThreads) {
        parentGroup = new NioEventLoopGroup(nThreads);
    }

    @Override
    public void setChildGroup() {
        childGroup = new NioEventLoopGroup();
    }

    @Override
    public void setChildGroup(int nThreads) {
        childGroup = new NioEventLoopGroup(nThreads);
    }

    @Override
    public void setChannel(Class channelClass) {
        this.channelClass = channelClass;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void setHandler() {
        validate();
        bootstrap.group(parentGroup, childGroup);
        //配置客户端的channel类型
        bootstrap.channel(channelClass);
        //配置TCP参数，握手字符串长度设置
        bootstrap.option(ChannelOption.SO_BACKLOG, 1024);
        //TCP_NODELAY算法，尽可能发送大块数据，减少充斥的小块数据
        bootstrap.option(ChannelOption.TCP_NODELAY, true);
        //开启心跳包活机制，就是客户端、服务端建立连接处于ESTABLISHED状态，超过2小时没有交流，机制会被启动
        bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
        //配置固定长度接收缓存区分配器
        bootstrap.childOption(ChannelOption.RCVBUF_ALLOCATOR, new FixedRecvByteBufAllocator(592048));
        //绑定I/O事件的处理类,WebSocketChildChannelHandler中定义
        bootstrap.childHandler(new HadlerInitializer());
    }

    @Override
    public void bind(int port) {
        bind(port, true);
    }

    @Override
    public void bind(int port, boolean sync) {
        try {
            future = bootstrap.bind(port).sync();
            logger.info("服务器启动成功 监听端口(" + port + ")");

            if (sync) {
                future.channel().closeFuture().sync();
            } else {
                future.channel().closeFuture();
            }
            logger.info("服务器关闭");

        } catch (InterruptedException e) {
            logger.warn("Netty绑定异常", e);
        } finally {
            parentGroup.shutdownGracefully();
            childGroup.shutdownGracefully();
        }
    }

    private void validate() {
        if (parentGroup == null
                || childGroup == null
                || channelClass == null) {
            throw new RuntimeException("parentGroup == null " +
                    "|| childGroup == null " +
                    "|| channelClass == null");
        }
    }

    @Override
    public void run() {
        this.setParentGroup(1);
        this.setChildGroup();
        this.setChannel(NioServerSocketChannel.class);
        this.setHandler();
        this.bind(18999);
    }
}
