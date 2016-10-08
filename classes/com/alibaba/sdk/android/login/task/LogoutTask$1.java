package com.alibaba.sdk.android.login.task;

import com.alibaba.sdk.android.ResultCode;
import com.alibaba.sdk.android.executor.ExecutorService;
import com.alibaba.sdk.android.login.callback.LogoutCallback;
import com.alibaba.sdk.android.login.impl.LoginContext;
import com.alibaba.sdk.android.session.CredentialService;
import com.alibaba.sdk.android.util.CommonUtils;

class LogoutTask$1
  implements Runnable
{
  LogoutTask$1(LogoutCallback paramLogoutCallback) {}
  
  public void run()
  {
    ResultCode localResultCode = LoginContext.credentialService.logout();
    if (ResultCode.SUCCESS.equals(localResultCode))
    {
      LoginContext.executorService.postUITask(new LogoutTask.1.1(this));
      return;
    }
    CommonUtils.onFailure(this.val$logoutCallback, localResultCode);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\task\LogoutTask$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */