package com.alibaba.sdk.android.login.task;

import android.app.Activity;
import com.alibaba.sdk.android.executor.ExecutorService;
import com.alibaba.sdk.android.login.impl.LoginContext;
import com.alibaba.sdk.android.model.Result;
import com.alibaba.sdk.android.session.CredentialService;
import com.alibaba.sdk.android.session.model.LoginResultData;
import com.alibaba.sdk.android.task.TaskWithDialog;

public abstract class AbsLoginByCodeTask
  extends TaskWithDialog<String, Void, Void>
{
  private static final String TAG = "login";
  
  public AbsLoginByCodeTask(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  protected Void asyncExecute(String... paramVarArgs)
  {
    paramVarArgs = login(paramVarArgs);
    int i = paramVarArgs.code;
    if (i == 1)
    {
      if (paramVarArgs.data != null) {
        LoginContext.credentialService.refreshWhenLogin((LoginResultData)paramVarArgs.data);
      }
      LoginContext.executorService.postUITask(new AbsLoginByCodeTask.1(this));
    }
    for (;;)
    {
      return null;
      LoginContext.executorService.postUITask(new AbsLoginByCodeTask.2(this, i, paramVarArgs));
    }
  }
  
  protected abstract void doWhenResultFail(int paramInt, String paramString);
  
  protected abstract void doWhenResultOk();
  
  protected abstract Result<LoginResultData> login(String[] paramArrayOfString);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\task\AbsLoginByCodeTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */