package com.alibaba.sdk.android.task;

import android.app.Activity;
import com.alibaba.sdk.android.util.DialogHelper;

public abstract class TaskWithDialog<Params, Progress, Result>
  extends AbsAsyncTask<Params, Progress, Result>
{
  protected Activity activity;
  protected DialogHelper dialogHelper;
  
  public TaskWithDialog(Activity paramActivity)
  {
    this.dialogHelper = new DialogHelper(paramActivity);
    this.activity = paramActivity;
  }
  
  protected void doFinally()
  {
    if (this.activity != null) {
      this.dialogHelper.dismissProgressDialog();
    }
  }
  
  protected void onPreExecute()
  {
    if (this.activity != null) {
      this.dialogHelper.showLoadingProgressDialog();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\task\TaskWithDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */