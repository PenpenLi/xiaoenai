package com.alibaba.sdk.android.impl;

import android.content.Context;
import com.alibaba.sdk.android.AlibabaSDK;
import com.alibaba.sdk.android.executor.ExecutorService;
import com.alibaba.sdk.android.executor.impl.ExecutorServiceImpl;
import com.alibaba.sdk.android.registry.ServiceRegistry;
import com.alibaba.sdk.android.registry.impl.DefaultServiceRegistry;
import com.alibaba.sdk.android.registry.impl.ProxyEnabledServiceRegistryDelegator;
import java.util.concurrent.locks.ReentrantLock;

public class KernelContext
{
  public static final String TAG = "kernel";
  public static volatile Context context;
  public static ExecutorService executorService = new ExecutorServiceImpl();
  public static final ReentrantLock initLock = new ReentrantLock();
  public static volatile Boolean isInitOk;
  public static volatile ServiceRegistry serviceRegistry = new DefaultServiceRegistry();
  public static volatile boolean syncInitialized;
  
  public static Boolean checkInitStatus()
  {
    try
    {
      initLock.lock();
      Boolean localBoolean = isInitOk;
      return localBoolean;
    }
    finally
    {
      initLock.unlock();
    }
  }
  
  public static void wrapServiceRegistry()
  {
    if ((serviceRegistry instanceof ProxyEnabledServiceRegistryDelegator)) {}
    while (Boolean.valueOf(AlibabaSDK.getProperty("kernel", "disableServiceProxy")).booleanValue()) {
      return;
    }
    serviceRegistry = new ProxyEnabledServiceRegistryDelegator(serviceRegistry);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\impl\KernelContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */