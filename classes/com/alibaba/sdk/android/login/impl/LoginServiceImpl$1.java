package com.alibaba.sdk.android.login.impl;

import android.app.Activity;
import com.alibaba.sdk.android.callback.CallbackContext;
import com.alibaba.sdk.android.login.LoginServiceProviderManager;
import com.alibaba.sdk.android.login.callback.LoginCallback;
import com.alibaba.sdk.android.task.AbsRunnable;

class LoginServiceImpl$1
  extends AbsRunnable
{
  LoginServiceImpl$1(LoginServiceImpl paramLoginServiceImpl, LoginCallback paramLoginCallback, Activity paramActivity) {}
  
  public void runWithoutException()
  {
    CallbackContext.loginCallback = this.val$loginCallback;
    CallbackContext.setActivity(this.val$activity);
    LoginServiceProviderManager.INSTANCE.showLogin(this.val$activity, this.val$loginCallback);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\impl\LoginServiceImpl$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */