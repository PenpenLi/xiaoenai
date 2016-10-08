package com.inmobi.signals;

import com.inmobi.commons.core.c.a;
import com.inmobi.commons.core.network.d;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;

public class e
{
  private static final String a = e.class.getSimpleName();
  
  public c a(b paramb)
  {
    paramb = new c(new d(paramb).a());
    if (paramb.a())
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Getting Carb list from server failed.");
      return paramb;
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Getting Carb list from server succeeded.");
    return paramb;
  }
  
  public boolean a(f paramf)
  {
    boolean bool2 = false;
    int i = 0;
    boolean bool1 = bool2;
    if (i <= paramf.b())
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Attempting to send pruned Carb list to server.");
      if (!new d(paramf).a().a()) {
        break label128;
      }
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Sending pruned Carb list to server failed.");
      i += 1;
      if (i <= paramf.b()) {
        break label97;
      }
    }
    for (bool1 = bool2;; bool1 = true)
    {
      if (!bool1) {
        a.a().a(new com.inmobi.commons.core.c.e("signals", "CarbUploadDiscarded"));
      }
      return bool1;
      try
      {
        label97:
        Thread.sleep(paramf.c() * 1000);
      }
      catch (InterruptedException localInterruptedException)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "User data network client interrupted while sleeping.", localInterruptedException);
      }
      break;
      label128:
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Sending pruned Carb list to server succeeded.");
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\signals\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */