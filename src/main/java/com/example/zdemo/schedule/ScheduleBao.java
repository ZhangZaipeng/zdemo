package com.example.zdemo.schedule;

import com.example.zdemo.utils.R;
import com.example.zdemo.utils.R.Withdrawals;
import java.util.List;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleBao {

  @Scheduled(cron = "0/1 * * * * *")
  public void run() {
    System.out.println("kkkkkkkkkkkkkkkkkkkkk");
    List<Withdrawals> r =  R.shopWithdrawals();

    if (r != null && r.size() > 0) {
      for (Withdrawals w : r) {
        if (w.getTotalNotWithdrawn() > 0) {
          R.applies(w);
        }
      }
    }
  }
}
