package com.alibaba.sdk.android.rpc;

import com.alibaba.sdk.android.rpc.model.RpcRequest;

public abstract interface RpcService
{
  public abstract <T> T getProxy(Class<T> paramClass);
  
  public abstract <T> T invoke(RpcRequest paramRpcRequest, Class<T> paramClass);
  
  public abstract String invoke(RpcRequest paramRpcRequest);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\rpc\RpcService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */