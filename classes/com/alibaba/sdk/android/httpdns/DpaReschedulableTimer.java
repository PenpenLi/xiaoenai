package com.alibaba.sdk.android.httpdns;

import java.util.Timer;
import java.util.TimerTask;

public class DpaReschedulableTimer
  extends Timer
{
  private Runnable task;
  private Timer timer = new Timer();
  private TimerTask timerTask;
  
  public void reschedule(long paramLong)
  {
    this.timerTask.cancel();
    this.timerTask = new DpaReschedulableTimer.2(this);
    this.timer.schedule(this.timerTask, paramLong);
  }
  
  public void schedule(Runnable paramRunnable, long paramLong)
  {
    if (this.task != null)
    {
      reschedule(paramLong);
      return;
    }
    this.task = paramRunnable;
    this.timerTask = new DpaReschedulableTimer.1(this);
    this.timer.schedule(this.timerTask, paramLong);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\httpdns\DpaReschedulableTimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */