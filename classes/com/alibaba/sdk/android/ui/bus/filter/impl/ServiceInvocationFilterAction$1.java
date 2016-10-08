package com.alibaba.sdk.android.ui.bus.filter.impl;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

class ServiceInvocationFilterAction$1
  implements Callable<Object>
{
  ServiceInvocationFilterAction$1(ServiceInvocationFilterAction paramServiceInvocationFilterAction, Method paramMethod, Object paramObject) {}
  
  public Object call()
  {
    return this.val$targetMethod.invoke(this.val$finalInstance, new Object[0]);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\bus\filter\impl\ServiceInvocationFilterAction$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */