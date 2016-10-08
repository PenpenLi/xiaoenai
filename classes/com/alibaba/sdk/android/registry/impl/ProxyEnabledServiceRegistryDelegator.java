package com.alibaba.sdk.android.registry.impl;

import com.alibaba.sdk.android.registry.ServiceRegistration;
import com.alibaba.sdk.android.registry.ServiceRegistry;
import java.lang.reflect.Proxy;
import java.util.Map;

public class ProxyEnabledServiceRegistryDelegator
  implements ServiceRegistry
{
  private ServiceRegistry delegator;
  
  public ProxyEnabledServiceRegistryDelegator(ServiceRegistry paramServiceRegistry)
  {
    this.delegator = paramServiceRegistry;
  }
  
  public <T> T getService(Class<T> paramClass, Map<String, String> paramMap)
  {
    Object localObject = this.delegator.getService(paramClass, paramMap);
    if ((localObject == null) && (paramMap != null) && ("true".equals((String)paramMap.get("$isv_scope$"))) && (paramClass.isInterface()))
    {
      localObject = getClass().getClassLoader();
      paramMap = new ProxyEnabledServiceRegistryDelegator.1(this, paramClass, paramMap);
      return (T)paramClass.cast(Proxy.newProxyInstance((ClassLoader)localObject, new Class[] { paramClass }, paramMap));
    }
    return (T)localObject;
  }
  
  public <T> T[] getServices(Class<T> paramClass, Map<String, String> paramMap)
  {
    return this.delegator.getServices(paramClass, paramMap);
  }
  
  public ServiceRegistration registerService(Class<?>[] paramArrayOfClass, Object paramObject, Map<String, String> paramMap)
  {
    return this.delegator.registerService(paramArrayOfClass, paramObject, paramMap);
  }
  
  public Object unregisterService(ServiceRegistration paramServiceRegistration)
  {
    return this.delegator.unregisterService(paramServiceRegistration);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\registry\impl\ProxyEnabledServiceRegistryDelegator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */