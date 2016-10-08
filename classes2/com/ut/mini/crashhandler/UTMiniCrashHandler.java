package com.ut.mini.crashhandler;

import android.content.Context;
import android.os.Process;
import com.alibaba.mtl.log.c.c;
import com.alibaba.mtl.log.e.i;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTTracker;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import java.util.HashMap;
import java.util.Map;

public class UTMiniCrashHandler
  implements Thread.UncaughtExceptionHandler
{
  private static volatile boolean R = false;
  private static UTMiniCrashHandler jdField_a_of_type_ComUtMiniCrashhandlerUTMiniCrashHandler = new UTMiniCrashHandler();
  private boolean K = false;
  private IUTCrashCaughtListner jdField_a_of_type_ComUtMiniCrashhandlerIUTCrashCaughtListner = null;
  private Thread.UncaughtExceptionHandler jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler = null;
  private Context mContext = null;
  
  private void M()
  {
    if (this.mContext != null)
    {
      this.jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
      Thread.setDefaultUncaughtExceptionHandler(this);
      this.K = false;
    }
  }
  
  public static UTMiniCrashHandler getInstance()
  {
    return jdField_a_of_type_ComUtMiniCrashhandlerUTMiniCrashHandler;
  }
  
  public boolean isTurnOff()
  {
    return this.K;
  }
  
  public void setCrashCaughtListener(IUTCrashCaughtListner paramIUTCrashCaughtListner)
  {
    this.jdField_a_of_type_ComUtMiniCrashhandlerIUTCrashCaughtListner = paramIUTCrashCaughtListner;
  }
  
  public void turnOff()
  {
    if (this.jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler != null)
    {
      Thread.setDefaultUncaughtExceptionHandler(this.jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler);
      this.jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler = null;
    }
    this.K = true;
  }
  
  public void turnOn(Context paramContext)
  {
    this.mContext = paramContext;
    M();
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    Object localObject4 = null;
    for (;;)
    {
      try
      {
        boolean bool = R;
        if (bool)
        {
          if (this.jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler != null)
          {
            this.jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler.uncaughtException(paramThread, paramThrowable);
            return;
          }
          Process.killProcess(Process.myPid());
          System.exit(10);
          return;
        }
        R = true;
        if (paramThrowable != null)
        {
          i.a("UTCrashHandler", "Caught Exception By UTCrashHandler.Please see log as follows!");
          paramThrowable.printStackTrace();
        }
        localUTExceptionItem = UTExceptionParser.parse(paramThrowable);
        if ((localUTExceptionItem != null) && (localUTExceptionItem.ar != null) && (localUTExceptionItem.getExpName() != null) && (localUTExceptionItem.getMd5() != null))
        {
          IUTCrashCaughtListner localIUTCrashCaughtListner = this.jdField_a_of_type_ComUtMiniCrashhandlerIUTCrashCaughtListner;
          localObject1 = localObject4;
          if (localIUTCrashCaughtListner == null) {}
        }
      }
      catch (Throwable localThrowable2)
      {
        UTExceptionParser.UTExceptionItem localUTExceptionItem;
        Object localObject1;
        Object localObject2;
        localThrowable2.printStackTrace();
        if (this.jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler == null) {
          break label304;
        }
        this.jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler.uncaughtException(paramThread, paramThrowable);
        return;
        i.a("Record crash stacktrace error", "Fatal Error,must call setRequestAuthentication method first.");
        continue;
      }
      finally
      {
        if (this.jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler == null) {
          break label316;
        }
      }
      try
      {
        localObject1 = this.jdField_a_of_type_ComUtMiniCrashhandlerIUTCrashCaughtListner.onCrashCaught(paramThread, paramThrowable);
        localObject4 = localObject1;
        if (localObject1 == null) {
          localObject4 = new HashMap();
        }
        ((Map)localObject4).put("StackTrace", localUTExceptionItem.getCrashDetail());
        localObject1 = new UTOriginalCustomHitBuilder("UT", 1, localUTExceptionItem.getMd5(), localUTExceptionItem.getExpName(), null, (Map)localObject4);
        localObject4 = UTAnalytics.getInstance().getDefaultTracker();
        if (localObject4 != null)
        {
          ((UTTracker)localObject4).send(((UTOriginalCustomHitBuilder)localObject1).build());
          c.a().E();
          if (this.jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler == null) {
            break label292;
          }
          this.jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler.uncaughtException(paramThread, paramThrowable);
          return;
        }
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
        localObject2 = localObject4;
      }
    }
    this.jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler.uncaughtException(paramThread, paramThrowable);
    for (;;)
    {
      throw ((Throwable)localObject3);
      label292:
      Process.killProcess(Process.myPid());
      System.exit(10);
      return;
      label304:
      Process.killProcess(Process.myPid());
      System.exit(10);
      return;
      label316:
      Process.killProcess(Process.myPid());
      System.exit(10);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\ut\mini\crashhandler\UTMiniCrashHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */