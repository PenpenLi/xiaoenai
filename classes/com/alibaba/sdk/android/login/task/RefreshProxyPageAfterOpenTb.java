package com.alibaba.sdk.android.login.task;

import android.app.Activity;
import com.alibaba.sdk.android.login.impl.LoginComponent;
import com.alibaba.sdk.android.model.Result;
import com.alibaba.sdk.android.session.model.LoginResultData;
import com.alibaba.sdk.android.ui.support.WebViewActivitySupport;
import com.alibaba.sdk.android.util.CommonUtils;
import com.alibaba.sdk.android.webview.proxy.WebViewProxy;

public class RefreshProxyPageAfterOpenTb
  extends AbsLoginByCodeTask
{
  private WebViewProxy view;
  
  public RefreshProxyPageAfterOpenTb(Activity paramActivity, WebViewProxy paramWebViewProxy)
  {
    super(paramActivity);
    this.view = paramWebViewProxy;
  }
  
  protected void doWhenException(Throwable paramThrowable) {}
  
  protected void doWhenResultFail(int paramInt, String paramString) {}
  
  protected void doWhenResultOk()
  {
    WebViewActivitySupport.getInstance().safeReload(this.view);
  }
  
  protected Result<LoginResultData> login(String[] paramArrayOfString)
  {
    return LoginComponent.INSTANCE.loginByCode(paramArrayOfString[0]);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\task\RefreshProxyPageAfterOpenTb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */