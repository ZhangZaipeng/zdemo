package com.example.zdemo.Im.netty.transport.data;


import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 接收处理阻塞队列， 缓存刚入站的任务.
 *
 * Transport Module ---> InboundQueue ---> Service Module.
 *
 */
@Component
@Scope("singleton")
public class ReceiveQueue {

    private volatile BlockingQueue<TextWebSocketFrame> queue;

    public BlockingQueue<TextWebSocketFrame> getQueue() {
        if (queue == null) {
            synchronized (ReceiveQueue.class) {
                if (queue == null) {
                    queue = new LinkedBlockingDeque<>(1024);
                }
            }
        }
        return queue;
    }
}
