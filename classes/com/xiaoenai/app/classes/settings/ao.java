package com.xiaoenai.app.classes.settings;

import android.graphics.Bitmap;
import android.webkit.WebView;
import com.xiaoenai.app.classes.common.webview.w;
import com.xiaoenai.app.ui.component.view.ProgressView;

class ao
  extends w
{
  ao(SettingWebPage paramSettingWebPage) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    SettingWebPage.a(this.a).setVisibility(8);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    SettingWebPage.a(this.a).setVisibility(0);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    SettingWebPage.a(this.a).setVisibility(8);
    paramWebView.setVisibility(4);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */