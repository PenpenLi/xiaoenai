package com.alibaba.sdk.android.app.impl;

import android.content.Context;
import com.alibaba.sdk.android.AlibabaSDK;
import com.alibaba.sdk.android.ConfigManager;
import com.alibaba.sdk.android.Environment;
import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.device.DeviceInfo;
import com.alibaba.sdk.android.impl.KernelContext;
import com.alibaba.sdk.android.registry.ServiceRegistration;
import com.alibaba.sdk.android.registry.ServiceRegistry;
import com.alibaba.sdk.android.ut.UserTrackerService;
import com.alibaba.sdk.android.util.CommonUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DefaultAppContext
  implements AppContext
{
  private String pluginName;
  private List<ServiceRegistration> serviceRegistrations = Collections.synchronizedList(new ArrayList());
  private ServiceRegistry serviceRegistry = KernelContext.serviceRegistry;
  
  public DefaultAppContext(String paramString)
  {
    this.pluginName = paramString;
  }
  
  public void destroy()
  {
    Iterator localIterator = this.serviceRegistrations.iterator();
    while (localIterator.hasNext()) {
      ((ServiceRegistration)localIterator.next()).unregister();
    }
  }
  
  public Context getAndroidContext()
  {
    return KernelContext.context;
  }
  
  public String getAppKey()
  {
    return AlibabaSDK.getGlobalProperty("com.alibaba.app.appkey");
  }
  
  public Environment getEnvironment()
  {
    return ConfigManager.getInstance().getEnvironment();
  }
  
  public String getPluginName()
  {
    return this.pluginName;
  }
  
  public <T> T getService(Class<T> paramClass)
  {
    return (T)this.serviceRegistry.getService(paramClass, null);
  }
  
  public <T> T getService(Class<T> paramClass, Map<String, String> paramMap)
  {
    return (T)this.serviceRegistry.getService(paramClass, paramMap);
  }
  
  public <T> T[] getServices(Class<T> paramClass)
  {
    return this.serviceRegistry.getServices(paramClass, null);
  }
  
  public <T> T[] getServices(Class<T> paramClass, Map<String, String> paramMap)
  {
    return this.serviceRegistry.getServices(paramClass, paramMap);
  }
  
  public String getUserTrackerId()
  {
    if (DeviceInfo.deviceId != null) {
      return DeviceInfo.deviceId;
    }
    UserTrackerService localUserTrackerService = (UserTrackerService)KernelContext.serviceRegistry.getService(UserTrackerService.class, null);
    if (localUserTrackerService == null) {
      return null;
    }
    return localUserTrackerService.getDefaultUserTrackerId();
  }
  
  public boolean isDebugEnabled()
  {
    return CommonUtils.isDebuggable();
  }
  
  public ServiceRegistration registerService(Class<?>[] paramArrayOfClass, Object paramObject, Map<String, String> paramMap)
  {
    if (paramMap == null) {}
    for (paramMap = new HashMap();; paramMap = new HashMap(paramMap))
    {
      paramMap.put("plugin.vendor", this.pluginName);
      paramArrayOfClass = this.serviceRegistry.registerService(paramArrayOfClass, paramObject, paramMap);
      this.serviceRegistrations.add(paramArrayOfClass);
      return paramArrayOfClass;
    }
  }
  
  public Object unregisterService(ServiceRegistration paramServiceRegistration)
  {
    this.serviceRegistrations.remove(paramServiceRegistration);
    return this.serviceRegistry.unregisterService(paramServiceRegistration);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\app\impl\DefaultAppContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */