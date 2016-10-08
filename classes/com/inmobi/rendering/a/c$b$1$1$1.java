package com.inmobi.rendering.a;

import android.os.Handler;
import android.webkit.WebView;
import com.inmobi.ads.b.b;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.util.concurrent.atomic.AtomicBoolean;

class c$b$1$1$1
  implements Runnable
{
  c$b$1$1$1(c.b.1.1 param1, WebView paramWebView) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(c.a.c() * 1000);
      if (!this.b.a.get())
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, c.e(), "Pinging click (" + this.b.c.a.a + ") via WebView timed out!");
        this.b.c.a.g.set(true);
        this.b.c.b.post(new c.b.1.1.1.1(this));
        c.b.a(this.b.c.c).a(this.b.c.a, null);
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\a\c$b$1$1$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */