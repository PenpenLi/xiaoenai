package com.alibaba.sdk.android.login.task;

import android.app.Activity;
import com.alibaba.sdk.android.ResultCode;
import com.alibaba.sdk.android.login.callback.LoginCallback;
import com.alibaba.sdk.android.login.impl.LoginComponent;
import com.alibaba.sdk.android.login.impl.LoginContext;
import com.alibaba.sdk.android.model.Result;
import com.alibaba.sdk.android.session.CredentialService;
import com.alibaba.sdk.android.session.model.LoginResultData;
import com.alibaba.sdk.android.util.CommonUtils;

public class LoginByTrustTokenTask
  extends AbsLoginByCodeTask
{
  private LoginCallback loginCallback;
  
  public LoginByTrustTokenTask(Activity paramActivity, LoginCallback paramLoginCallback)
  {
    super(paramActivity);
    this.loginCallback = paramLoginCallback;
  }
  
  protected void doWhenException(Throwable paramThrowable)
  {
    CommonUtils.onFailure(this.loginCallback, ResultCode.create(10010, new Object[] { paramThrowable.getMessage() }));
  }
  
  protected void doWhenResultFail(int paramInt, String paramString)
  {
    if (this.loginCallback != null) {
      this.loginCallback.onFailure(paramInt, paramString);
    }
  }
  
  protected void doWhenResultOk()
  {
    if (this.loginCallback != null) {
      this.loginCallback.onSuccess(LoginContext.credentialService.getSession());
    }
  }
  
  protected Result<LoginResultData> login(String[] paramArrayOfString)
  {
    return LoginComponent.INSTANCE.loginByTrustToken(paramArrayOfString[0], paramArrayOfString[1]);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\task\LoginByTrustTokenTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */