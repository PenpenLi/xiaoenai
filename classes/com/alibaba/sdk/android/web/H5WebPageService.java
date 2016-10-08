package com.alibaba.sdk.android.web;

import android.app.Activity;
import com.alibaba.sdk.android.callback.FailureCallback;
import com.alibaba.sdk.android.webview.UiSettings;

public abstract interface H5WebPageService
{
  public abstract void showPage(Activity paramActivity, FailureCallback paramFailureCallback, UiSettings paramUiSettings, String paramString);
  
  public abstract void showPage(Activity paramActivity, FailureCallback paramFailureCallback, String paramString);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\web\H5WebPageService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */