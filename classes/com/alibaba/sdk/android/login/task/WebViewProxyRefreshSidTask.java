package com.alibaba.sdk.android.login.task;

import android.app.Activity;
import android.view.View;
import com.alibaba.sdk.android.ResultCode;
import com.alibaba.sdk.android.callback.CallbackContext;
import com.alibaba.sdk.android.executor.ExecutorService;
import com.alibaba.sdk.android.login.LoginServiceProviderManager;
import com.alibaba.sdk.android.login.impl.LoginContext;
import com.alibaba.sdk.android.session.CredentialService;
import com.alibaba.sdk.android.task.TaskWithDialog;
import com.alibaba.sdk.android.util.CommonUtils;
import com.alibaba.sdk.android.webview.proxy.WebViewProxy;

public class WebViewProxyRefreshSidTask
  extends TaskWithDialog<String, Void, Void>
{
  private WebViewProxy view;
  
  public WebViewProxyRefreshSidTask(WebViewProxy paramWebViewProxy)
  {
    super((Activity)((View)paramWebViewProxy).getContext());
    this.view = paramWebViewProxy;
  }
  
  protected Void asyncExecute(String... paramVarArgs)
  {
    paramVarArgs = LoginContext.credentialService;
    if (paramVarArgs.isRefreshTokenExpired())
    {
      CallbackContext.setActivity(this.activity);
      LoginServiceProviderManager.INSTANCE.showLogin(this.activity, null);
      return null;
    }
    paramVarArgs = paramVarArgs.refreshSession();
    if (ResultCode.REFRESH_SID_EXCEPTION.equals(paramVarArgs))
    {
      CallbackContext.setActivity(this.activity);
      LoginServiceProviderManager.INSTANCE.showLogin(this.activity, null);
      return null;
    }
    if (ResultCode.SUCCESS.equals(paramVarArgs))
    {
      LoginContext.executorService.postUITask(new WebViewProxyRefreshSidTask.1(this));
      return null;
    }
    CommonUtils.toastSystemException();
    return null;
  }
  
  protected void doWhenException(Throwable paramThrowable) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\task\WebViewProxyRefreshSidTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */