package com.alibaba.sdk.android.session;

import com.alibaba.sdk.android.ResultCode;
import com.alibaba.sdk.android.session.model.LoginResultData;
import com.alibaba.sdk.android.session.model.Session;

public abstract interface CredentialService
{
  public abstract String getReToken();
  
  public abstract Session getSession();
  
  public abstract Object getSessionExtraInfos(String paramString);
  
  public abstract SessionListener getSessionListener();
  
  public abstract ResultCode init();
  
  public abstract boolean isRefreshTokenExpired();
  
  public abstract ResultCode logout();
  
  public abstract ResultCode refreshSession();
  
  public abstract void refreshWhenLogin(LoginResultData paramLoginResultData);
  
  public abstract void setSessionListener(SessionListener paramSessionListener);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\session\CredentialService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */