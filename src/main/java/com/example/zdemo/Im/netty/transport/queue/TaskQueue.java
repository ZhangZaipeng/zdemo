package com.example.zdemo.Im.netty.transport.queue;


import com.example.zdemo.Im.netty.transport.protocol.MessageHolder;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 接收阻塞队列，缓存刚入站的任务.
 *
 * Transport Module ---> InboundQueue ---> Service Module.
 *
 */
public class TaskQueue {
    private volatile static BlockingQueue<TextWebSocketFrame> queue;

    public static BlockingQueue<TextWebSocketFrame> getQueue() {
        if (queue == null) {
            synchronized (TaskQueue.class) {
                if (queue == null) {
                    queue = new LinkedBlockingDeque<>(1024);
                }
            }
        }
        return queue;
    }
}
