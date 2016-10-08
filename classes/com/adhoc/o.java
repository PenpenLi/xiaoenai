package com.adhoc;

import android.content.Context;
import com.adhoc.adhocsdk.AdhocTracker;

public class o
  implements Thread.UncaughtExceptionHandler
{
  private static o b;
  private Thread.UncaughtExceptionHandler a;
  private Context c;
  private boolean d = false;
  
  public static o a()
  {
    if (b == null) {
      b = new o();
    }
    return b;
  }
  
  public void a(Context paramContext)
  {
    this.c = paramContext;
    this.a = Thread.getDefaultUncaughtExceptionHandler();
    Thread.setDefaultUncaughtExceptionHandler(this);
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    try
    {
      if (this.d) {
        AdhocTracker.incrementStat(this.c.getApplicationContext(), "Event-crash", 1);
      }
      if (this.a != null) {
        this.a.uncaughtException(paramThread, paramThrowable);
      }
      return;
    }
    catch (Throwable paramThread)
    {
      fl.b("crash handler unknow error!");
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */