package com.alibaba.sdk.android.rpc.http;

import com.alibaba.sdk.android.rpc.ServiceInvokeException;
import com.alibaba.sdk.android.rpc.ServiceRequestCallback;

class HttpRpcServiceClient$4
  implements Runnable
{
  HttpRpcServiceClient$4(HttpRpcServiceClient paramHttpRpcServiceClient, HttpRpcServiceClient.InvocationContext paramInvocationContext, ServiceInvokeException paramServiceInvokeException) {}
  
  public void run()
  {
    this.val$context.callback.onFailed(this.val$e);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\rpc\http\HttpRpcServiceClient$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */