package com.example.zdemo.Im.netty;

import com.example.zdemo.Im.netty.service.ImAppContext;
import com.example.zdemo.Im.netty.transport.netty.NettyServer;
import com.example.zdemo.Im.netty.transport.netty.NettyServerImpl;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 启动类
 *
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        start();
    }

    public static void start() throws InterruptedException {

        // 启动服务
        new ImAppContext().initAndStart();

        NettyServer config = new NettyServerImpl();
        config.setParentGroup(1);
        config.setChildGroup();
        config.setChannel(NioServerSocketChannel.class);
        config.setHandler();
        config.bind(20000);
    }
}
