package com.example.zdemo.Im.netty.transport.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

public class HadlerInitializer extends ChannelInitializer<Channel> {

  @Override
  protected void initChannel(Channel channel) throws Exception {
    ChannelPipeline pipeline = channel.pipeline();
    // pipeline Http消息编码解码
    pipeline.addLast(new HttpServerCodec());
    pipeline.addLast(new ChunkedWriteHandler());
    pipeline.addLast(new HttpObjectAggregator(64 * 1024));


    pipeline.addLast("http-handler", httpRequestHandler);
    pipeline.addLast("websocket-handler", webSocketServerHandler);
  }
}
