package com.alibaba.sdk.android.rpc;

public abstract interface RpcServiceClient
{
  public static final byte BINARY = 1;
  public static final byte CUSTOM = 2;
  public static final byte JSON = 0;
  public static final byte PURE_HTTP = 1;
  public static final byte WITHOUT_META = 2;
  public static final byte WITH_META = 0;
  
  public abstract ServiceResponse call(ServiceRequest paramServiceRequest);
  
  public abstract void call(ServiceRequest paramServiceRequest, ServiceRequestCallback paramServiceRequestCallback);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\rpc\RpcServiceClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */