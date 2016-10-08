package com.inmobi.rendering.mraid;

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
      if (i <= j.a(this.a))
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, j.b(), "Attempting to get MRAID Js.");
        c localc = new d(j.b(this.a)).a();
        if (!localc.a()) {
          break;
        }
        Logger.a(Logger.InternalLogLevel.INTERNAL, j.b(), "Getting MRAID Js from server failed.");
        i += 1;
        if (i <= j.a(this.a)) {}
      }
      else
      {
        return;
      }
      try
      {
        Thread.sleep(j.c(this.a) * 1000);
      }
      catch (InterruptedException localInterruptedException)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, j.b(), "MRAID Js client interrupted while sleeping.", localInterruptedException);
      }
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, j.b(), "Getting MRAID Js from server succeeded. Response:" + localInterruptedException.b());
    new i().a(localInterruptedException.b());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\mraid\j$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */