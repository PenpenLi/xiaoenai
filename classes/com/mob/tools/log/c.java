package com.mob.tools.log;

import android.util.Log;
import com.mob.tools.e;

public class c
  implements Thread.UncaughtExceptionHandler
{
  private static boolean a;
  private static boolean b = true;
  private static Thread.UncaughtExceptionHandler c;
  
  public static void a()
  {
    if (!a)
    {
      c = Thread.getDefaultUncaughtExceptionHandler();
      Thread.setDefaultUncaughtExceptionHandler(new c());
    }
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if (b) {
      Log.wtf("MobUncaughtExceptionHandler", paramThrowable);
    }
    e.a().crash(paramThrowable);
    if (c != null) {
      c.uncaughtException(paramThread, paramThrowable);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\log\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */