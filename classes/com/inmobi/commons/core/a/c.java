package com.inmobi.commons.core.a;

import com.inmobi.commons.core.configs.b.b;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;

public class c
  implements Thread.UncaughtExceptionHandler
{
  private static final String b = c.class.getSimpleName();
  private static boolean c = false;
  private static a d;
  private Thread.UncaughtExceptionHandler a;
  
  private c(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    this.a = paramUncaughtExceptionHandler;
  }
  
  public static void a()
  {
    try
    {
      if (!c)
      {
        a locala = new a();
        d = new a();
        com.inmobi.commons.core.configs.b.a().a(locala, d);
        com.inmobi.commons.core.c.a.a().a(locala.a(), locala.e());
        Thread.setDefaultUncaughtExceptionHandler(new c(Thread.getDefaultUncaughtExceptionHandler()));
        c = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private boolean a(Throwable paramThrowable)
  {
    boolean bool2 = false;
    paramThrowable = paramThrowable.getStackTrace();
    int j = paramThrowable.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramThrowable[i].getClassName().contains("com.inmobi.")) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if (a(paramThrowable))
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Crash due to inmobi, will report it");
      b localb = new b(paramThread, paramThrowable);
      com.inmobi.commons.core.c.a.a().a(localb);
    }
    this.a.uncaughtException(paramThread, paramThrowable);
  }
  
  static class a
    implements b.b
  {
    public void a(com.inmobi.commons.core.configs.a parama)
    {
      com.inmobi.commons.core.c.a.a().a(parama.a(), ((a)parama).e());
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */