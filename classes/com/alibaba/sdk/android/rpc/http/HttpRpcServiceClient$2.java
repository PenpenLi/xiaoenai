package com.alibaba.sdk.android.rpc.http;

import com.alibaba.sdk.android.rpc.ServiceRequestCallback;
import com.alibaba.sdk.android.rpc.ServiceResponse;

class HttpRpcServiceClient$2
  implements Runnable
{
  HttpRpcServiceClient$2(HttpRpcServiceClient paramHttpRpcServiceClient, HttpRpcServiceClient.InvocationContext paramInvocationContext, ServiceResponse paramServiceResponse) {}
  
  public void run()
  {
    this.val$context.callback.onSuccess(this.val$response);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\rpc\http\HttpRpcServiceClient$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */