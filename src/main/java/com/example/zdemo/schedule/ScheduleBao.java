package com.example.zdemo.schedule;

import com.example.zdemo.utils.Applies;
import com.example.zdemo.utils.R;
import com.example.zdemo.utils.R.Withdrawals;
import com.example.zdemo.utils.StringUtils;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "singleton")
public class ScheduleBao {
  public static boolean isRunning = false;
  public static Logger logger = LoggerFactory.getLogger(ScheduleBao.class);
  private ExecutorService executorService = Executors.newFixedThreadPool(5);

  private String token;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public static boolean isIsRunning() {
    return isRunning;
  }

  public static void setIsRunning(boolean isRunning) {
    ScheduleBao.isRunning = isRunning;
  }

  @Scheduled(cron = "0/1 * * * * *")
  public void execute() {
    if (!isRunning) {
      return;
    }
    if (StringUtils.isNullOrEmpty(token)) {
      return;
    }

    try {
      logger.info("token ===> " + token );

      for (int i = 0; i < 3; i++) {
        List<Withdrawals> r =  R.shopWithdrawals(token);

        if (r != null && r.size() > 0) {
          for (Withdrawals w : r) {
            if (w.getTotalNotWithdrawn() > 0) {
              executorService.execute(new Applies(w,token));
            }
          }
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
