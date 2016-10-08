package com.alibaba.sdk.android.app;

import com.alibaba.sdk.android.app.impl.DefaultAppContext;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class AppContextManager
{
  public static final AppContextManager INSTANCE = new AppContextManager();
  private Map<String, DefaultAppContext> appContexts = new HashMap();
  private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
  
  public AppContext createAppContext(String paramString)
  {
    this.lock.writeLock().lock();
    try
    {
      DefaultAppContext localDefaultAppContext2 = (DefaultAppContext)this.appContexts.get(paramString);
      DefaultAppContext localDefaultAppContext1 = localDefaultAppContext2;
      if (localDefaultAppContext2 == null)
      {
        localDefaultAppContext1 = new DefaultAppContext(paramString);
        this.appContexts.put(paramString, localDefaultAppContext1);
      }
      return localDefaultAppContext1;
    }
    finally
    {
      this.lock.writeLock().unlock();
    }
  }
  
  public AppContext destroyAppContext(String paramString)
  {
    this.lock.writeLock().lock();
    try
    {
      paramString = (DefaultAppContext)this.appContexts.remove(paramString);
      this.lock.writeLock().unlock();
      if (paramString != null) {
        paramString.destroy();
      }
      return paramString;
    }
    finally
    {
      this.lock.writeLock().unlock();
    }
  }
  
  public AppContext getAppContext(String paramString)
  {
    this.lock.readLock().lock();
    try
    {
      paramString = (AppContext)this.appContexts.get(paramString);
      return paramString;
    }
    finally
    {
      this.lock.readLock().unlock();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\app\AppContextManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */