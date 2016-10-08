package com.alibaba.sdk.android.login.task;

import android.app.Activity;
import android.webkit.WebView;
import com.alibaba.sdk.android.ResultCode;
import com.alibaba.sdk.android.login.impl.LoginComponent;
import com.alibaba.sdk.android.login.impl.LoginContext;
import com.alibaba.sdk.android.login.ui.LoginWebViewActivity;
import com.alibaba.sdk.android.model.Result;
import com.alibaba.sdk.android.session.CredentialService;
import com.alibaba.sdk.android.session.model.LoginResultData;
import com.alibaba.sdk.android.task.TaskWithDialog;
import com.alibaba.sdk.android.util.CommonUtils;
import com.alibaba.sdk.android.util.DialogHelper;
import com.alibaba.sdk.android.util.ResourceUtils;

public class DoubleCheckTask
  extends TaskWithDialog<Void, Void, Void>
{
  public DoubleCheckTask(WebView paramWebView)
  {
    super((Activity)paramWebView.getContext());
  }
  
  protected Void asyncExecute(Void... paramVarArgs)
  {
    paramVarArgs = LoginComponent.INSTANCE.loginAfterDoubleCheck(((LoginWebViewActivity)this.activity).token);
    if (paramVarArgs.code == 1)
    {
      LoginContext.credentialService.refreshWhenLogin((LoginResultData)paramVarArgs.data);
      this.activity.setResult(ResultCode.SUCCESS.code);
      this.activity.finish();
    }
    for (;;)
    {
      return null;
      CommonUtils.toastSystemException();
    }
  }
  
  protected void doWhenException(Throwable paramThrowable) {}
  
  protected void onPreExecute()
  {
    this.dialogHelper.showProgressDialog(ResourceUtils.getString("com_taobao_tae_sdk_login_progress_message"));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\task\DoubleCheckTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */