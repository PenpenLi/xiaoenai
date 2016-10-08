package com.alimama.mobile.sdk.config.system;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MMLog
{
  public static boolean DEBUG = false;
  public static String PROCESS_TAG;
  public static String TAG = "Munion";
  
  static
  {
    PROCESS_TAG = "Munion_Process : ";
  }
  
  private static String buildMessage(String paramString, Object... paramVarArgs)
  {
    String str = paramString;
    int i;
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length == 0) {
        str = paramString;
      }
    }
    else
    {
      paramString = new Throwable().fillInStackTrace().getStackTrace();
      i = 2;
      label29:
      if (i >= paramString.length) {
        break label157;
      }
      if (paramString[i].getClass().equals(MMLog.class)) {
        break label150;
      }
      paramVarArgs = paramString[i].getClassName();
      paramVarArgs = paramVarArgs.substring(paramVarArgs.lastIndexOf('.') + 1);
      paramVarArgs = paramVarArgs.substring(paramVarArgs.lastIndexOf('$') + 1);
    }
    label150:
    label157:
    for (paramString = paramVarArgs + "." + paramString[i].getMethodName();; paramString = "<unknown>")
    {
      return String.format("[%d] %s: %s", new Object[] { Long.valueOf(Thread.currentThread().getId()), paramString, str });
      str = String.format(paramString, paramVarArgs);
      break;
      i += 1;
      break label29;
    }
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    if (DEBUG) {
      Log.d(TAG, buildMessage(paramString, paramVarArgs));
    }
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    Log.e(TAG, buildMessage(paramString, paramVarArgs));
  }
  
  public static void e(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    Log.e(TAG, buildMessage(paramString, paramVarArgs), paramThrowable);
  }
  
  public static void i(String paramString, Object... paramVarArgs)
  {
    if (DEBUG) {
      Log.i(TAG, buildMessage(paramString, paramVarArgs));
    }
  }
  
  public static void setTag(String paramString)
  {
    d("Changing log tag to %s", new Object[] { paramString });
    TAG = paramString;
  }
  
  public static void v(String paramString, Object... paramVarArgs)
  {
    if (DEBUG) {
      Log.v(TAG, buildMessage(paramString, paramVarArgs));
    }
  }
  
  public static void w(String paramString, Object... paramVarArgs)
  {
    Log.w(TAG, buildMessage(paramString, paramVarArgs));
  }
  
  public static void w(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    Log.w(TAG, buildMessage(paramString, paramVarArgs), paramThrowable);
  }
  
  public static void wtf(String paramString, Object... paramVarArgs)
  {
    Log.wtf(TAG, buildMessage(paramString, paramVarArgs));
  }
  
  public static void wtf(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    Log.wtf(TAG, buildMessage(paramString, paramVarArgs), paramThrowable);
  }
  
  public static class MarkerLog
  {
    public static final boolean ENABLED = MMLog.DEBUG;
    private static final long MIN_DURATION_FOR_LOGGING_MS = 0L;
    private boolean mFinished = false;
    private final List<Marker> mMarkers = new ArrayList();
    
    private long getTotalDuration()
    {
      if (this.mMarkers.size() == 0) {
        return 0L;
      }
      long l = ((Marker)this.mMarkers.get(0)).time;
      return ((Marker)this.mMarkers.get(this.mMarkers.size() - 1)).time - l;
    }
    
    /* Error */
    public void add(String paramString, long paramLong)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 38	com/alimama/mobile/sdk/config/system/MMLog$MarkerLog:mFinished	Z
      //   6: istore 4
      //   8: iload 4
      //   10: ifeq +6 -> 16
      //   13: aload_0
      //   14: monitorexit
      //   15: return
      //   16: aload_0
      //   17: getfield 36	com/alimama/mobile/sdk/config/system/MMLog$MarkerLog:mMarkers	Ljava/util/List;
      //   20: new 9	com/alimama/mobile/sdk/config/system/MMLog$MarkerLog$Marker
      //   23: dup
      //   24: aload_1
      //   25: lload_2
      //   26: invokestatic 60	android/os/SystemClock:elapsedRealtime	()J
      //   29: invokespecial 63	com/alimama/mobile/sdk/config/system/MMLog$MarkerLog$Marker:<init>	(Ljava/lang/String;JJ)V
      //   32: invokeinterface 66 2 0
      //   37: pop
      //   38: goto -25 -> 13
      //   41: astore_1
      //   42: aload_0
      //   43: monitorexit
      //   44: aload_1
      //   45: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	46	0	this	MarkerLog
      //   0	46	1	paramString	String
      //   0	46	2	paramLong	long
      //   6	3	4	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   2	8	41	finally
      //   16	38	41	finally
    }
    
    protected void finalize()
    {
      if (!this.mFinished)
      {
        finish("Request on the loose");
        MMLog.e("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
      }
    }
    
    public void finish(String paramString)
    {
      try
      {
        this.mFinished = true;
        long l2 = getTotalDuration();
        if (this.mMarkers.size() > 0)
        {
          long l1 = ((Marker)this.mMarkers.get(0)).time;
          MMLog.d("<%s>(%-4d ms) %s", new Object[] { paramString, Long.valueOf(l2), "BEGIN." });
          Iterator localIterator = this.mMarkers.iterator();
          while (localIterator.hasNext())
          {
            Marker localMarker = (Marker)localIterator.next();
            l2 = localMarker.time;
            MMLog.d("<%s>(+%-4d) [%2d] %s", new Object[] { paramString, Long.valueOf(l2 - l1), Long.valueOf(localMarker.thread), localMarker.name });
            l1 = l2;
          }
        }
        MMLog.d("<%s>(end.   ) %s", new Object[] { paramString, "END." });
        return;
      }
      finally {}
    }
    
    private static class Marker
    {
      public final String name;
      public final long thread;
      public final long time;
      
      public Marker(String paramString, long paramLong1, long paramLong2)
      {
        this.name = paramString;
        this.thread = paramLong1;
        this.time = paramLong2;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\system\MMLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */