package com.alibaba.sdk.android.session.model;

import java.util.Map;

public abstract interface Session
{
  public abstract String getAuthorizationCode();
  
  public abstract Long getLoginTime();
  
  public abstract Map<String, Object> getOtherInfo();
  
  public abstract User getUser();
  
  public abstract String getUserId();
  
  public abstract Boolean isLogin();
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\session\model\Session.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */