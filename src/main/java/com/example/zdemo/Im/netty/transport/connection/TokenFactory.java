package com.example.zdemo.Im.netty.transport.connection;

import java.util.Random;
import org.apache.log4j.Logger;

/**
 * 用户创建token
 * <p>
 */
public class TokenFactory {
    private static final Logger logger = Logger.getLogger(TokenFactory.class);

    public TokenFactory() {
    }

    /**
     * 调用此方法生成一个token
     *
     * @return
     */
    public Long generate() {
        Long token;

        Random random = new Random();

        while (isExist(token = random.nextLong())) {
            token = random.nextLong();
        }
        logger.info("创建Token(" + token + ")");

        return token;
    }

    private boolean isExist(Long token) {
        return TokenPool.query(token);
    }
}
