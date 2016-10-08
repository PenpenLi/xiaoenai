package com.alibaba.sdk.android.initialization;

public abstract interface InitializationServiceClient
{
  public abstract <T> T request(InitializationHandler<T> paramInitializationHandler, Class<T> paramClass);
  
  public abstract void request();
  
  public abstract void request(InitializationHandler... paramVarArgs);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\initialization\InitializationServiceClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */