package com.alibaba.sdk.android.callback;

public abstract interface ResultCallback<T>
  extends FailureCallback
{
  public abstract void onSuccess(T paramT);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\callback\ResultCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */