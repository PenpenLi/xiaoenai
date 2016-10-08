package com.alibaba.sdk.android.task;

import com.alibaba.sdk.android.trace.AliSDKLogger;

public abstract class AbsRunnable
  implements Runnable
{
  private static final String TAG = AbsRunnable.class.getSimpleName();
  
  public void run()
  {
    try
    {
      runWithoutException();
      return;
    }
    catch (Throwable localThrowable)
    {
      AliSDKLogger.e(TAG, localThrowable.getMessage(), localThrowable);
    }
  }
  
  public abstract void runWithoutException();
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\task\AbsRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */