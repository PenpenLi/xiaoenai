package com.alibaba.sdk.android.registry;

import java.util.Map;

public abstract interface ServiceRegistration
{
  public abstract void setProperties(Map<String, String> paramMap);
  
  public abstract void unregister();
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\registry\ServiceRegistration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */