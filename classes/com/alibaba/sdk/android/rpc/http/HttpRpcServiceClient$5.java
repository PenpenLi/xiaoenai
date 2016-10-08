package com.alibaba.sdk.android.rpc.http;

import com.alibaba.sdk.android.rpc.ServiceInvokeException;
import com.alibaba.sdk.android.rpc.ServiceRequestCallback;

class HttpRpcServiceClient$5
  implements Runnable
{
  HttpRpcServiceClient$5(HttpRpcServiceClient paramHttpRpcServiceClient, HttpRpcServiceClient.InvocationContext paramInvocationContext, Exception paramException) {}
  
  public void run()
  {
    this.val$context.callback.onFailed(new ServiceInvokeException(this.val$e));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\rpc\http\HttpRpcServiceClient$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */