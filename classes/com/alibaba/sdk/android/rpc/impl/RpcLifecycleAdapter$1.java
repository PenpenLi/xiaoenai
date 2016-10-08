package com.alibaba.sdk.android.rpc.impl;

import com.alibaba.sdk.android.config.PropertyChangeListener;

class RpcLifecycleAdapter$1
  implements PropertyChangeListener
{
  RpcLifecycleAdapter$1(RpcLifecycleAdapter paramRpcLifecycleAdapter) {}
  
  public void propertyChanged(String paramString1, String paramString2, String paramString3)
  {
    if ("httpDNSEnabled".equals(paramString1)) {
      RpcContext.httpDNSEnabled = "true".equalsIgnoreCase(paramString3);
    }
    while (!"includeResourceInHttpHeader".equals(paramString1)) {
      return;
    }
    RpcContext.includeResourceInHttpHeader = "true".equalsIgnoreCase(paramString3);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\rpc\impl\RpcLifecycleAdapter$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */