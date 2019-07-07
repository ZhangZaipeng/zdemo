package com.example.zdemo.Priority.pool;

import java.util.concurrent.PriorityBlockingQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * 初始化数据
 * InitializingBean
 * ServletContextListener
 * ApplicationListener
 */
@Component
public class HumanPool implements InitializingBean {
  private Logger logger =  LoggerFactory.getLogger(this.getClass());

  // 线程安全队列 take()  会阻塞
  public static final PriorityBlockingQueue<Human> queue =
      new PriorityBlockingQueue<>(200, new HumanComparator());

  public static boolean add(Human h) {
    return queue.add(h);
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    logger.info("HumanPool --》 postProcessBeforeInitialization");
    Human human1 = new Human(0,1000,"张三");
    Human human2 = new Human(1,1000,"李四");
    Human human3 = new Human(2,1000,"王五");
    Human human4 = new Human(3,1000,"赵六");
    queue.add(human1);
    queue.add(human2);
    queue.add(human3);
    queue.add(human4);
  }
}
