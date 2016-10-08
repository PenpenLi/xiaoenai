package com.alibaba.sdk.android.registry.impl;

import com.alibaba.sdk.android.message.Message;
import com.alibaba.sdk.android.registry.ServiceRegistry;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

class ProxyEnabledServiceRegistryDelegator$1
  implements InvocationHandler
{
  ProxyEnabledServiceRegistryDelegator$1(ProxyEnabledServiceRegistryDelegator paramProxyEnabledServiceRegistryDelegator, Class paramClass, Map paramMap) {}
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    paramObject = ProxyEnabledServiceRegistryDelegator.access$000(this.this$0).getService(this.val$type, this.val$filterProperties);
    if (paramObject == null)
    {
      paramMethod = this.val$type.getName();
      if (this.val$filterProperties != null) {}
      for (paramObject = this.val$filterProperties.toString();; paramObject = "")
      {
        AliSDKLogger.log("kernel", Message.create(17, new Object[] { paramMethod, paramObject }));
        return null;
      }
    }
    return paramMethod.invoke(paramObject, paramArrayOfObject);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\registry\impl\ProxyEnabledServiceRegistryDelegator$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */