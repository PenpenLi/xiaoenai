package com.taobao.applink.auth;

import com.taobao.applink.auth.userinfo.TBAppLinkUserInfo;

public abstract interface TBAppLinkAuthListener
{
  public abstract void onFailure();
  
  public abstract void onSuccess(TBAppLinkUserInfo paramTBAppLinkUserInfo);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\applink\auth\TBAppLinkAuthListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */