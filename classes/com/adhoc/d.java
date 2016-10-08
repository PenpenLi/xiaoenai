package com.adhoc;

import android.content.Context;

public final class d
  implements Runnable
{
  public d(Context paramContext, String paramString, long paramLong) {}
  
  public void run()
  {
    try
    {
      w.a().a(this.a.getApplicationContext(), this.b, Long.valueOf(this.c), 0L, q.a().d());
      return;
    }
    catch (Throwable localThrowable)
    {
      fl.a(localThrowable);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */