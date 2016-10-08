package com.alibaba.sdk.android.login;

import android.app.Activity;
import com.alibaba.sdk.android.login.callback.LoginCallback;

public abstract interface LoginServiceProvider
{
  public static final String LOGIN_SERVICE_PROVIDER_NAME = "loginServiceProviderName";
  
  public abstract boolean showLogin(Activity paramActivity, LoginCallback paramLoginCallback);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\LoginServiceProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */