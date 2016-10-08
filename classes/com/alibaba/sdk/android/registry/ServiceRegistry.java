package com.alibaba.sdk.android.registry;

import java.util.Map;

public abstract interface ServiceRegistry
{
  public abstract <T> T getService(Class<T> paramClass, Map<String, String> paramMap);
  
  public abstract <T> T[] getServices(Class<T> paramClass, Map<String, String> paramMap);
  
  public abstract ServiceRegistration registerService(Class<?>[] paramArrayOfClass, Object paramObject, Map<String, String> paramMap);
  
  public abstract Object unregisterService(ServiceRegistration paramServiceRegistration);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\registry\ServiceRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */