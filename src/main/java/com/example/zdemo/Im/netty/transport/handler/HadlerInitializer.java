package com.example.zdemo.Im.netty.transport.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;
import java.util.concurrent.TimeUnit;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class HadlerInitializer extends ChannelInitializer<Channel> {

  @Override
  protected void initChannel(Channel channel) throws Exception {
    ChannelPipeline pipeline = channel.pipeline();
    // pipeline Http消息编码解码
    pipeline.addLast(new HttpServerCodec());
    pipeline.addLast(new ChunkedWriteHandler());
    pipeline.addLast(new HttpObjectAggregator(64 * 1024));
    pipeline.addLast("http-handler", new HttpRequestHandler());
    pipeline.addLast("IdleStateHandler", new IdleStateHandler(0, 0, 10, TimeUnit.SECONDS));
    pipeline.addLast("websocket-handler", new WebSocketServerHandler());
  }
}
