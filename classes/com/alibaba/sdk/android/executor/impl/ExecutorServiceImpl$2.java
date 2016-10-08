package com.alibaba.sdk.android.executor.impl;

import android.util.Log;

class ExecutorServiceImpl$2
  implements Runnable
{
  ExecutorServiceImpl$2(ExecutorServiceImpl paramExecutorServiceImpl, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      this.val$r.run();
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("ExecutorServiceImpl", localThrowable.getMessage(), localThrowable);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\executor\impl\ExecutorServiceImpl$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */