package com.xiaoenai.app.classes.settings;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.widget.Toast;
import com.xiaoenai.app.classes.common.webview.w;
import com.xiaoenai.app.ui.component.view.ProgressView;

class af
  extends w
{
  af(SettingNewsActivity paramSettingNewsActivity) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    SettingNewsActivity.a(this.a).setVisibility(8);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    SettingNewsActivity.a(this.a).setVisibility(0);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    Toast.makeText(this.a, paramString1, 0).show();
    SettingNewsActivity.a(this.a).setVisibility(8);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */