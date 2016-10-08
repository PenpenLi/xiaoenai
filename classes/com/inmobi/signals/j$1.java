package com.inmobi.signals;

import com.inmobi.commons.core.c.a;
import com.inmobi.commons.core.c.e;
import com.inmobi.commons.core.network.c;
import com.inmobi.commons.core.network.d;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;

class j$1
  implements Runnable
{
  j$1(j paramj) {}
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      if (i <= j.a(this.a).b())
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, j.b(), "Attempting to send samples to server.");
        if (!new d(j.a(this.a)).a().a()) {
          break;
        }
        Logger.a(Logger.InternalLogLevel.INTERNAL, j.b(), "Sending samples to server failed.");
        i += 1;
        if (i > j.a(this.a).b()) {
          a.a().a(new e("signals", "RetryCountExceeded"));
        }
      }
      else
      {
        return;
      }
      try
      {
        Thread.sleep(j.a(this.a).c() * 1000);
      }
      catch (InterruptedException localInterruptedException)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, j.b(), "User data network client interrupted while sleeping.", localInterruptedException);
      }
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, j.b(), "Sending samples to server succeeded.");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\signals\j$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */