package com.example.zdemo.Im.netty.transport.handler;

import com.example.zdemo.Im.netty.transport.handler.ws.WebSocketServerProtocolHandler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;

public class HadlerInitializer extends ChannelInitializer<Channel> {

  @Override
  protected void initChannel(Channel channel) throws Exception {
    ChannelPipeline pipeline = channel.pipeline();
    // pipeline Http消息编码解码
    pipeline.addLast(new HttpServerCodec());
    pipeline.addLast(new ChunkedWriteHandler());
    pipeline.addLast(new HttpObjectAggregator(64 * 1024));
    pipeline.addLast("http-handler", new HttpReqHandler());
    pipeline.addLast("handshake", new WebSocketServerProtocolHandler("/ws"));
    pipeline.addLast("IdleStateHandler", new IdleStateHandler(30, 0, 0));
    pipeline.addLast("text-websocket-handler", new TextWebSocketHandler());
  }
}
