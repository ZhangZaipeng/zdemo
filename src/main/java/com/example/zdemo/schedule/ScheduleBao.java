package com.example.zdemo.schedule;

import com.example.zdemo.utils.R;
import com.example.zdemo.utils.R.Withdrawals;
import com.example.zdemo.utils.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class ScheduleBao {
  public static boolean isRunning = false;

  private String token;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  @Scheduled(cron = "0/1 * * * * *")
  public void execute() {
    if (isRunning) {
      return;
    }
    if (StringUtils.isNullOrEmpty(token)) {
      return;
    }

    try {

      List<Withdrawals> r =  R.shopWithdrawals(token);

      if (r != null && r.size() > 0) {
        for (Withdrawals w : r) {
          if (w.getTotalNotWithdrawn() > 0) {
            R.applies(w,token);
          }
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
