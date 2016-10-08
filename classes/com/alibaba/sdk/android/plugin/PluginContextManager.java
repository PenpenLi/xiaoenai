package com.alibaba.sdk.android.plugin;

import com.alibaba.sdk.android.plugin.impl.DefaultPluginContext;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class PluginContextManager
{
  public static final PluginContextManager INSTANCE = new PluginContextManager();
  private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
  private ConcurrentMap<String, DefaultPluginContext> pluginContexts = new ConcurrentHashMap();
  
  public PluginContext createPluginConext(PluginInfo paramPluginInfo)
  {
    this.lock.writeLock().lock();
    try
    {
      DefaultPluginContext localDefaultPluginContext2 = (DefaultPluginContext)this.pluginContexts.get(paramPluginInfo.name);
      DefaultPluginContext localDefaultPluginContext1 = localDefaultPluginContext2;
      if (localDefaultPluginContext2 == null)
      {
        localDefaultPluginContext1 = new DefaultPluginContext(paramPluginInfo);
        this.pluginContexts.put(paramPluginInfo.name, localDefaultPluginContext1);
      }
      return localDefaultPluginContext1;
    }
    finally
    {
      this.lock.writeLock().unlock();
    }
  }
  
  public PluginContext destroyPluginContext(String paramString)
  {
    this.lock.writeLock().lock();
    try
    {
      paramString = (DefaultPluginContext)this.pluginContexts.remove(paramString);
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
  
  public PluginContext getPluginContext(String paramString)
  {
    this.lock.readLock().lock();
    try
    {
      paramString = (PluginContext)this.pluginContexts.get(paramString);
      return paramString;
    }
    finally
    {
      this.lock.readLock().unlock();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\plugin\PluginContextManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */