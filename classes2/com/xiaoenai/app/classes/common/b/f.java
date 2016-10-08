package com.xiaoenai.app.classes.common.b;

import java.util.Queue;

class f
  extends Thread
{
  f(c paramc) {}
  
  public void run()
  {
    super.run();
    for (;;)
    {
      if (this.a.f())
      {
        c.a(this.a, null);
        this.a.a(false);
        this.a.b(false);
        this.a.b(0);
        return;
      }
      if (c.b(this.a) > 5)
      {
        c.a(this.a, 0);
        c.a(this.a, null);
        this.a.b(0);
        this.a.b(false);
        this.a.a(false);
        c.a(1, 3, null, null, 0, 0, 0);
        return;
      }
      this.a.a(true);
      if ((c.h() == null) || (c.h().size() == 0))
      {
        try
        {
          Thread.sleep(200L);
          c.c(this.a);
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
      else
      {
        Runnable localRunnable = (Runnable)c.h().poll();
        if (localRunnable != null)
        {
          localRunnable.run();
          c.d(this.a);
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */