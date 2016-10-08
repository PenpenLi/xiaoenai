package com.alibaba.sdk.android.rpc;

public abstract interface ServiceRequestCallback
{
  public abstract void onFailed(ServiceInvokeException paramServiceInvokeException);
  
  public abstract void onSuccess(ServiceResponse paramServiceResponse);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\rpc\ServiceRequestCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */