package com.alibaba.sdk.android.web.task;

import android.app.Activity;
import android.content.Intent;
import com.alibaba.sdk.android.system.RequestCode;
import com.alibaba.sdk.android.task.AbsRunnable;
import com.alibaba.sdk.android.webview.BaseWebViewActivity;
import com.alibaba.sdk.android.webview.UiSettings;

public class OpenH5PageTask
  extends AbsRunnable
{
  private Activity activity;
  private UiSettings taeWebViewUiSettings;
  private String url;
  private Class<?> webViewActivityClass;
  
  public OpenH5PageTask(Activity paramActivity, UiSettings paramUiSettings, String paramString)
  {
    this.activity = paramActivity;
    this.taeWebViewUiSettings = paramUiSettings;
    this.url = paramString;
    try
    {
      this.webViewActivityClass = Class.forName("com.alibaba.sdk.android.trade.ui.TradeWebViewActivity");
      return;
    }
    catch (Throwable paramActivity)
    {
      this.webViewActivityClass = BaseWebViewActivity.class;
    }
  }
  
  public OpenH5PageTask(Activity paramActivity, String paramString)
  {
    this(paramActivity, null, paramString);
  }
  
  public void runWithoutException()
  {
    Intent localIntent = new Intent(this.activity, this.webViewActivityClass);
    localIntent.putExtra("url", this.url);
    if ((this.taeWebViewUiSettings != null) && (this.taeWebViewUiSettings.title != null)) {
      localIntent.putExtra("title", this.taeWebViewUiSettings.title);
    }
    this.activity.startActivityForResult(localIntent, RequestCode.OPEN_H5_TRADE);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\web\task\OpenH5PageTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */