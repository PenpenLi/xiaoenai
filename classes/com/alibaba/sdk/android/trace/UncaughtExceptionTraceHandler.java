package com.alibaba.sdk.android.trace;

public class UncaughtExceptionTraceHandler
  implements Thread.UncaughtExceptionHandler
{
  private boolean inited;
  private Thread.UncaughtExceptionHandler mDefaultHandler;
  
  private void traceException(Thread paramThread, Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return;
    }
    AliSDKLogger.e(3, "kernel", "UncaughtException", paramThread.getName(), paramThrowable);
  }
  
  /* Error */
  public void init(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 37	com/alibaba/sdk/android/trace/UncaughtExceptionTraceHandler:inited	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 37	com/alibaba/sdk/android/trace/UncaughtExceptionTraceHandler:inited	Z
    //   19: invokestatic 41	java/lang/Thread:getDefaultUncaughtExceptionHandler	()Ljava/lang/Thread$UncaughtExceptionHandler;
    //   22: astore_1
    //   23: aload_0
    //   24: getfield 43	com/alibaba/sdk/android/trace/UncaughtExceptionTraceHandler:mDefaultHandler	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   27: ifnull +29 -> 56
    //   30: aload_0
    //   31: getfield 43	com/alibaba/sdk/android/trace/UncaughtExceptionTraceHandler:mDefaultHandler	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   34: aload_0
    //   35: invokevirtual 47	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   38: ifne -27 -> 11
    //   41: aload_0
    //   42: getfield 43	com/alibaba/sdk/android/trace/UncaughtExceptionTraceHandler:mDefaultHandler	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   45: invokevirtual 51	java/lang/Object:getClass	()Ljava/lang/Class;
    //   48: ldc 2
    //   50: invokevirtual 47	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   53: ifne -42 -> 11
    //   56: aload_0
    //   57: aload_1
    //   58: putfield 43	com/alibaba/sdk/android/trace/UncaughtExceptionTraceHandler:mDefaultHandler	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   61: aload_0
    //   62: invokestatic 55	java/lang/Thread:setDefaultUncaughtExceptionHandler	(Ljava/lang/Thread$UncaughtExceptionHandler;)V
    //   65: goto -54 -> 11
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	UncaughtExceptionTraceHandler
    //   0	73	1	paramContext	android.content.Context
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	68	finally
    //   14	56	68	finally
    //   56	65	68	finally
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    traceException(paramThread, paramThrowable);
    if ((this.mDefaultHandler != null) && (this.mDefaultHandler != this) && (!this.mDefaultHandler.getClass().equals(UncaughtExceptionTraceHandler.class))) {
      this.mDefaultHandler.uncaughtException(paramThread, paramThrowable);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\trace\UncaughtExceptionTraceHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */