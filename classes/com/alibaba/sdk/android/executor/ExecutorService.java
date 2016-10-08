package com.alibaba.sdk.android.executor;

import android.os.Looper;

public abstract interface ExecutorService
{
  public abstract Looper getDefaultLooper();
  
  public abstract void postHandlerTask(Runnable paramRunnable);
  
  public abstract void postTask(Runnable paramRunnable);
  
  public abstract void postUITask(Runnable paramRunnable);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\executor\ExecutorService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */