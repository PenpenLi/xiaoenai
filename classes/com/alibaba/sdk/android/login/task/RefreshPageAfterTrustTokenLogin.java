package com.alibaba.sdk.android.login.task;

import android.app.Activity;
import android.webkit.WebView;
import com.alibaba.sdk.android.login.impl.LoginComponent;
import com.alibaba.sdk.android.model.Result;
import com.alibaba.sdk.android.session.model.LoginResultData;
import com.alibaba.sdk.android.util.CommonUtils;

public class RefreshPageAfterTrustTokenLogin
  extends AbsLoginByCodeTask
{
  private WebView view;
  
  public RefreshPageAfterTrustTokenLogin(Activity paramActivity, WebView paramWebView)
  {
    super(paramActivity);
    this.view = paramWebView;
  }
  
  protected void doWhenException(Throwable paramThrowable) {}
  
  protected void doWhenResultFail(int paramInt, String paramString) {}
  
  protected void doWhenResultOk()
  {
    if (this.view != null) {
      this.view.reload();
    }
  }
  
  protected Result<LoginResultData> login(String[] paramArrayOfString)
  {
    return LoginComponent.INSTANCE.loginByTrustToken(paramArrayOfString[0], paramArrayOfString[1]);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\task\RefreshPageAfterTrustTokenLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */