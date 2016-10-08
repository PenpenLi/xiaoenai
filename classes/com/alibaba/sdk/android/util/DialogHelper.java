package com.alibaba.sdk.android.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface.OnCancelListener;

public class DialogHelper
{
  private static final String TAG = "kernel";
  public Activity activity;
  private ProgressDialog progressDialog;
  
  public DialogHelper(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public static void showAlertDialog(Activity paramActivity, Runnable paramRunnable)
  {
    paramActivity = new AlertDialog.Builder(paramActivity);
    paramActivity.setTitle(17039380);
    paramActivity.setMessage(ResourceUtils.getString("com_taobao_tae_sdk_alert_message"));
    paramActivity.setPositiveButton(17039370, new DialogHelper.1(paramRunnable));
    paramActivity.create().show();
  }
  
  public void dismissProgressDialog()
  {
    this.activity.runOnUiThread(new DialogHelper.3(this));
  }
  
  public void showLoadingProgressDialog()
  {
    showProgressDialog(ResourceUtils.getString("com_taobao_tae_sdk_loading_progress_message"));
  }
  
  public void showProgressDialog(String paramString)
  {
    showProgressDialog(paramString, false, null, true);
  }
  
  public void showProgressDialog(String paramString, boolean paramBoolean1, DialogInterface.OnCancelListener paramOnCancelListener, boolean paramBoolean2)
  {
    dismissProgressDialog();
    this.activity.runOnUiThread(new DialogHelper.2(this, paramString, paramBoolean2, paramBoolean1, paramOnCancelListener));
  }
  
  public void showProgressDialog(boolean paramBoolean, String paramString)
  {
    showProgressDialog(paramString, true, null, paramBoolean);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\util\DialogHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */