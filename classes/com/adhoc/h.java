package com.adhoc;

import android.app.Activity;

public final class h
  implements Runnable
{
  public h(Activity paramActivity) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(100L);
      if (this.a == null) {
        return;
      }
      bool = fm.d(this.a.getApplicationContext());
      if (bool) {
        break label84;
      }
      ae.a().a(this.a.getApplicationContext());
      fl.a("back 2 menu");
      ae.a().a = true;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        boolean bool;
        fl.a(localInterruptedException);
        return;
        ae.a().a = false;
      }
    }
    catch (Throwable localThrowable)
    {
      label84:
      fl.a(localThrowable);
    }
    if ((ab.a) && (!bool))
    {
      ab.a().d(this.a.getApplicationContext());
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */