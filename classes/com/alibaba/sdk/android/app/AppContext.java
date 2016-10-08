package com.alibaba.sdk.android.app;

import android.content.Context;
import com.alibaba.sdk.android.Environment;
import com.alibaba.sdk.android.registry.ServiceRegistration;
import java.util.Map;

public abstract interface AppContext
{
  public abstract Context getAndroidContext();
  
  public abstract String getAppKey();
  
  public abstract Environment getEnvironment();
  
  public abstract <T> T getService(Class<T> paramClass);
  
  public abstract <T> T getService(Class<T> paramClass, Map<String, String> paramMap);
  
  public abstract <T> T[] getServices(Class<T> paramClass);
  
  public abstract <T> T[] getServices(Class<T> paramClass, Map<String, String> paramMap);
  
  public abstract String getUserTrackerId();
  
  public abstract boolean isDebugEnabled();
  
  public abstract ServiceRegistration registerService(Class<?>[] paramArrayOfClass, Object paramObject, Map<String, String> paramMap);
  
  public abstract Object unregisterService(ServiceRegistration paramServiceRegistration);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\app\AppContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */