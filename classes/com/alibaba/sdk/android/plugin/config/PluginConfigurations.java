package com.alibaba.sdk.android.plugin.config;

import com.alibaba.sdk.android.config.PropertyChangeListener;
import com.alibaba.sdk.android.registry.ServiceRegistration;

public abstract interface PluginConfigurations
{
  public abstract boolean getBooleanValue(String paramString, boolean paramBoolean);
  
  public abstract double getDoubleValue(String paramString, double paramDouble);
  
  public abstract float getFloatValue(String paramString, float paramFloat);
  
  public abstract int getIntValue(String paramString, int paramInt);
  
  public abstract long getLongValue(String paramString, long paramLong);
  
  public abstract String getStringValue(String paramString);
  
  public abstract String getStringValue(String paramString1, String paramString2);
  
  public abstract ServiceRegistration registerGlobalPropertyChangeListener(PropertyChangeListener paramPropertyChangeListener);
  
  public abstract ServiceRegistration registerPropertyChangeListener(PropertyChangeListener paramPropertyChangeListener);
  
  public abstract void unregisterPropertyChangeListener(ServiceRegistration paramServiceRegistration);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\plugin\config\PluginConfigurations.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */