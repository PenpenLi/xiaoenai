package com.alibaba.sdk.android.task;

import android.os.AsyncTask;
import com.alibaba.sdk.android.trace.AliSDKLogger;

public abstract class AbsAsyncTask<Params, Progress, Result>
  extends AsyncTask<Params, Progress, Result>
{
  private static final String TAG = "kernel";
  
  protected abstract Result asyncExecute(Params... paramVarArgs);
  
  protected abstract void doFinally();
  
  protected Result doInBackground(Params... paramVarArgs)
  {
    try
    {
      paramVarArgs = asyncExecute(paramVarArgs);
      return paramVarArgs;
    }
    catch (Throwable paramVarArgs)
    {
      AliSDKLogger.e("kernel", paramVarArgs.getMessage(), paramVarArgs);
      doWhenException(paramVarArgs);
      return null;
    }
    finally
    {
      doFinally();
    }
  }
  
  protected abstract void doWhenException(Throwable paramThrowable);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\task\AbsAsyncTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */