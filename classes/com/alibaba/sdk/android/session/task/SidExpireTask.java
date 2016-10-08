package com.alibaba.sdk.android.session.task;

import android.app.Activity;
import android.webkit.WebView;
import com.alibaba.sdk.android.ResultCode;
import com.alibaba.sdk.android.executor.ExecutorService;
import com.alibaba.sdk.android.session.impl.CredentialManager;
import com.alibaba.sdk.android.system.SystemContext;
import com.alibaba.sdk.android.task.TaskWithDialog;
import com.alibaba.sdk.android.util.CommonUtils;

public class SidExpireTask
  extends TaskWithDialog<Void, Void, Void>
{
  private WebView view;
  
  public SidExpireTask(WebView paramWebView)
  {
    super((Activity)paramWebView.getContext());
    this.view = paramWebView;
  }
  
  protected Void asyncExecute(Void... paramVarArgs)
  {
    paramVarArgs = CredentialManager.INSTANCE.refreshSession();
    if ((ResultCode.REFRESH_SID_EXCEPTION.equals(paramVarArgs)) || (ResultCode.SUCCESS.equals(paramVarArgs))) {
      SystemContext.executorService.postUITask(new SidExpireTask.1(this));
    }
    for (;;)
    {
      return null;
      CommonUtils.toastSystemException();
    }
  }
  
  protected void doWhenException(Throwable paramThrowable) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\session\task\SidExpireTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */