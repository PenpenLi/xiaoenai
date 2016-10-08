package com.alibaba.sdk.android.web.impl;

import android.app.Activity;
import com.alibaba.sdk.android.callback.FailureCallback;
import com.alibaba.sdk.android.util.CommonUtils;
import com.alibaba.sdk.android.web.H5WebPageService;
import com.alibaba.sdk.android.web.task.OpenH5PageTask;
import com.alibaba.sdk.android.webview.UiSettings;

public class H5WebPageServiceImpl
  implements H5WebPageService
{
  public void showPage(Activity paramActivity, FailureCallback paramFailureCallback, UiSettings paramUiSettings, String paramString)
  {
    CommonUtils.startInitWaitTask(paramActivity, paramFailureCallback, new OpenH5PageTask(paramActivity, paramString), null);
  }
  
  public void showPage(Activity paramActivity, FailureCallback paramFailureCallback, String paramString)
  {
    CommonUtils.startInitWaitTask(paramActivity, paramFailureCallback, new OpenH5PageTask(paramActivity, paramString), null);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\web\impl\H5WebPageServiceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */