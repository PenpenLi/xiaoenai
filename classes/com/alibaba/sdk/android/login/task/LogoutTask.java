package com.alibaba.sdk.android.login.task;

import android.app.Activity;
import com.alibaba.sdk.android.ResultCode;
import com.alibaba.sdk.android.login.callback.LogoutCallback;
import com.alibaba.sdk.android.task.InitWaitTask;
import com.alibaba.sdk.android.util.CommonUtils;

public class LogoutTask
  extends InitWaitTask
{
  public LogoutTask(Activity paramActivity, LogoutCallback paramLogoutCallback)
  {
    super(paramActivity, paramLogoutCallback, new LogoutTask.1(paramLogoutCallback), "api_logout");
  }
  
  protected void doWhenException(Throwable paramThrowable)
  {
    CommonUtils.onFailure(this.failureCallback, ResultCode.create(10010, new Object[] { paramThrowable.getMessage() }));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\task\LogoutTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */