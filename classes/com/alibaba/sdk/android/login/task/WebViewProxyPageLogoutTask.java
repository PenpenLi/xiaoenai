package com.alibaba.sdk.android.login.task;

import android.app.Activity;
import android.view.View;
import com.alibaba.sdk.android.ResultCode;
import com.alibaba.sdk.android.executor.ExecutorService;
import com.alibaba.sdk.android.login.impl.LoginContext;
import com.alibaba.sdk.android.session.CredentialService;
import com.alibaba.sdk.android.task.TaskWithDialog;
import com.alibaba.sdk.android.util.CommonUtils;
import com.alibaba.sdk.android.webview.BaseWebViewActivity;
import com.alibaba.sdk.android.webview.proxy.WebViewProxy;

public class WebViewProxyPageLogoutTask
  extends TaskWithDialog<Void, Void, Void>
{
  private WebViewProxy webViewProxy;
  
  public WebViewProxyPageLogoutTask(WebViewProxy paramWebViewProxy)
  {
    super((Activity)((View)paramWebViewProxy).getContext());
    this.webViewProxy = paramWebViewProxy;
  }
  
  protected Void asyncExecute(Void... paramVarArgs)
  {
    paramVarArgs = LoginContext.credentialService.logout();
    if (ResultCode.SUCCESS.equals(paramVarArgs)) {
      if ((this.activity instanceof BaseWebViewActivity)) {
        ((BaseWebViewActivity)this.activity).setResult(ResultCode.create(10015, new Object[0]));
      }
    }
    for (;;)
    {
      return null;
      if (this.webViewProxy != null)
      {
        LoginContext.executorService.postUITask(new WebViewProxyPageLogoutTask.1(this));
        continue;
        if (!ResultCode.ALREADY_LOGOUT.equals(paramVarArgs)) {
          CommonUtils.toast("com_taobao_tae_sdk_logout_fail_message");
        }
      }
    }
  }
  
  protected void doWhenException(Throwable paramThrowable)
  {
    CommonUtils.toast("com_taobao_tae_sdk_logout_fail_message");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\task\WebViewProxyPageLogoutTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */