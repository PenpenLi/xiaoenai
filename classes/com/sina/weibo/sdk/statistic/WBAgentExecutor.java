package com.sina.weibo.sdk.statistic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WBAgentExecutor
{
  private static long TIMEOUT = 5L;
  private static ExecutorService mExecutor = ;
  
  public static void execute(Runnable paramRunnable)
  {
    try
    {
      if (mExecutor.isShutdown()) {
        mExecutor = Executors.newSingleThreadExecutor();
      }
      mExecutor.execute(paramRunnable);
      return;
    }
    finally {}
  }
  
  /* Error */
  public static void shutDownExecutor()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 18	com/sina/weibo/sdk/statistic/WBAgentExecutor:mExecutor	Ljava/util/concurrent/ExecutorService;
    //   6: invokeinterface 34 1 0
    //   11: ifne +11 -> 22
    //   14: getstatic 18	com/sina/weibo/sdk/statistic/WBAgentExecutor:mExecutor	Ljava/util/concurrent/ExecutorService;
    //   17: invokeinterface 42 1 0
    //   22: getstatic 18	com/sina/weibo/sdk/statistic/WBAgentExecutor:mExecutor	Ljava/util/concurrent/ExecutorService;
    //   25: getstatic 22	com/sina/weibo/sdk/statistic/WBAgentExecutor:TIMEOUT	J
    //   28: getstatic 48	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   31: invokeinterface 52 4 0
    //   36: pop
    //   37: ldc 2
    //   39: monitorexit
    //   40: return
    //   41: astore_0
    //   42: ldc 2
    //   44: monitorexit
    //   45: aload_0
    //   46: athrow
    //   47: astore_0
    //   48: goto -11 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   41	5	0	localObject	Object
    //   47	1	0	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   3	22	41	finally
    //   22	37	41	finally
    //   3	22	47	java/lang/Exception
    //   22	37	47	java/lang/Exception
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\statistic\WBAgentExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */