package com.alibaba.sdk.android.login.callback;

import com.alibaba.sdk.android.callback.FailureCallback;
import com.alibaba.sdk.android.session.model.Session;

public abstract interface LoginCallback
  extends FailureCallback
{
  public abstract void onSuccess(Session paramSession);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\callback\LoginCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */