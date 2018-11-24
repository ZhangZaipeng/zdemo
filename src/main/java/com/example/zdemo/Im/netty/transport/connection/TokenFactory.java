package com.example.zdemo.Im.netty.transport.connection;

import java.util.Random;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * token 操作池
 *  从 redis 中获取 登录token
 * <p>
 */
@Component
@Scope("singleton")
public class TokenFactory {

    private static final Logger logger = Logger.getLogger(TokenFactory.class);

    public TokenFactory() {
    }

    private boolean isExist(Long token) {

        return false;
    }
}
