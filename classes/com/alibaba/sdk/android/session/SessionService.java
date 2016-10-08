package com.alibaba.sdk.android.session;

import com.alibaba.sdk.android.model.Result;
import com.alibaba.sdk.android.session.model.Session;

public abstract interface SessionService
{
  public abstract Result<String> getSId();
  
  public abstract Result<Session> getSession();
  
  public abstract Result<String> refreshSId();
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\session\SessionService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */