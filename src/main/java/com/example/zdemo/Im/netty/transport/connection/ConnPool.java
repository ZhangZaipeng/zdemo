package com.example.zdemo.Im.netty.transport.connection;

import io.netty.channel.Channel;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.log4j.Logger;

/**
 * 连接池，用户维护已与服务器建立连接的Client
 *
 */
public class ConnPool {
    private static final Logger logger = Logger.getLogger(ConnPool.class);

    private ConnPool() {
    }

    // 用于存放在线用户的userId和channel
    private static Map<Long, Channel> connsMap =
            new ConcurrentHashMap<>();

    /**
     * 添加连接
     *
     * @param userId
     * @param channel
     * @return
     */
    public synchronized static boolean add(Long userId, Channel channel) {
        Channel result = connsMap.put(userId, channel);
        if (result == null) {
            logger.info("Conn池 添加成功(userId=" + userId + " channel=" + channel + ")");
            return true;
        } else {
            logger.warn("Conn池 添加失败(userId=" + userId + " channel=" + channel + ")");
            return false;
        }
    }

    /**
     * 删除连接
     *
     * @param userId
     * @return
     */
    public synchronized static boolean remove(Long userId) {
        Channel result = connsMap.remove(userId);
        if (result != null) {
            logger.info("Conn池 移除成功(userId=" + userId + ")");
            return true;
        } else {
            logger.warn("Conn池 移除失败(userId=" + userId + ")");
            return false;
        }
    }

    /**
     * 查找连接
     *
     * @param userId
     * @return
     */
    public synchronized static Channel query(Long userId) {
        return connsMap.get(userId);
    }

    /**
     * 查找用户
     *
     * @param channel
     * @return
     */
    public synchronized static Long query(Channel channel) {
        Set<Map.Entry<Long, Channel>> entries = connsMap.entrySet();
        Iterator<Map.Entry<Long, Channel>> ite = entries.iterator();
        while (ite.hasNext()) {
            Map.Entry<Long, Channel> entry = ite.next();
            if (channel.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
