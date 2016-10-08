package com.alibaba.nb.android.trade.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.alibaba.nb.android.trade.utils.d.a;

public final class e
{
  private static volatile e d = null;
  private Handler a = new Handler(Looper.getMainLooper());
  private HandlerThread b = new HandlerThread("SDK Looper Thread");
  private Handler c;
  
  private e()
  {
    this.b.start();
    while (this.b.getLooper() == null) {
      try
      {
        this.b.wait();
      }
      catch (InterruptedException localInterruptedException)
      {
        a.d("AliTradeExecutorServiceUtil", "创建handlerThread错误：" + localInterruptedException.getMessage());
      }
    }
    this.c = new f(this, this.b.getLooper());
  }
  
  public static e a()
  {
    if (d == null) {}
    try
    {
      if (d == null) {
        d = new e();
      }
      return d;
    }
    finally {}
  }
  
  public final void a(Runnable paramRunnable)
  {
    this.c.post(paramRunnable);
  }
  
  public final void b(Runnable paramRunnable)
  {
    this.a.post(paramRunnable);
  }
  
  public final void c(Runnable paramRunnable)
  {
    this.c.postDelayed(paramRunnable, 2000L);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\utils\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */