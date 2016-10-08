package com.alibaba.sdk.android.plugin.config.impl;

import com.alibaba.sdk.android.config.PropertyChangeListener;
import com.alibaba.sdk.android.impl.KernelContext;
import com.alibaba.sdk.android.plugin.PluginInfo;
import com.alibaba.sdk.android.plugin.config.PluginConfigurations;
import com.alibaba.sdk.android.plugin.config.PluginSystemConfigurations;
import com.alibaba.sdk.android.registry.ServiceRegistration;
import com.alibaba.sdk.android.registry.ServiceRegistry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DefaultPluginConfigurations
  implements PluginConfigurations
{
  private String pluginName;
  private List<ServiceRegistration> serviceRegistrations = Collections.synchronizedList(new ArrayList());
  private PluginSystemConfigurations systemConfigurations;
  
  public DefaultPluginConfigurations(PluginInfo paramPluginInfo, PluginSystemConfigurations paramPluginSystemConfigurations)
  {
    this.pluginName = paramPluginInfo.name;
    this.systemConfigurations = paramPluginSystemConfigurations;
  }
  
  private String getProperty(String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      paramString1 = null;
    }
    String str;
    do
    {
      return paramString1;
      str = this.systemConfigurations.getPluginProperty(paramString1, paramString2);
      paramString1 = str;
    } while (str != null);
    return this.systemConfigurations.getGlobalProperty(paramString2);
  }
  
  public void destroy()
  {
    Iterator localIterator = this.serviceRegistrations.iterator();
    while (localIterator.hasNext()) {
      ((ServiceRegistration)localIterator.next()).unregister();
    }
    this.serviceRegistrations.clear();
  }
  
  public boolean getBooleanValue(String paramString, boolean paramBoolean)
  {
    paramString = getProperty(this.pluginName, paramString);
    if (paramString == null) {
      return paramBoolean;
    }
    return Boolean.parseBoolean(paramString);
  }
  
  public double getDoubleValue(String paramString, double paramDouble)
  {
    paramString = getProperty(this.pluginName, paramString);
    if (paramString == null) {
      return paramDouble;
    }
    return Double.parseDouble(paramString);
  }
  
  public float getFloatValue(String paramString, float paramFloat)
  {
    paramString = getProperty(this.pluginName, paramString);
    if (paramString == null) {
      return paramFloat;
    }
    return Float.parseFloat(paramString);
  }
  
  public int getIntValue(String paramString, int paramInt)
  {
    paramString = getProperty(this.pluginName, paramString);
    if (paramString == null) {
      return paramInt;
    }
    return Integer.parseInt(paramString);
  }
  
  public long getLongValue(String paramString, long paramLong)
  {
    paramString = getProperty(this.pluginName, paramString);
    if (paramString == null) {
      return paramLong;
    }
    return Long.parseLong(paramString);
  }
  
  public String getStringValue(String paramString)
  {
    return getProperty(this.pluginName, paramString);
  }
  
  public String getStringValue(String paramString1, String paramString2)
  {
    paramString1 = getProperty(this.pluginName, paramString1);
    if (paramString1 == null) {
      return paramString2;
    }
    return paramString1;
  }
  
  public ServiceRegistration registerGlobalPropertyChangeListener(PropertyChangeListener paramPropertyChangeListener)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("plugin.vendor", this.pluginName);
    localHashMap.put("property.scope", "global");
    paramPropertyChangeListener = KernelContext.serviceRegistry.registerService(new Class[] { PropertyChangeListener.class }, paramPropertyChangeListener, localHashMap);
    this.serviceRegistrations.add(paramPropertyChangeListener);
    return paramPropertyChangeListener;
  }
  
  public ServiceRegistration registerPropertyChangeListener(PropertyChangeListener paramPropertyChangeListener)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("plugin.vendor", this.pluginName);
    localHashMap.put("property.scope", "plugin");
    paramPropertyChangeListener = KernelContext.serviceRegistry.registerService(new Class[] { PropertyChangeListener.class }, paramPropertyChangeListener, localHashMap);
    this.serviceRegistrations.add(paramPropertyChangeListener);
    return paramPropertyChangeListener;
  }
  
  public void unregisterPropertyChangeListener(ServiceRegistration paramServiceRegistration)
  {
    paramServiceRegistration.unregister();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\plugin\config\impl\DefaultPluginConfigurations.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */