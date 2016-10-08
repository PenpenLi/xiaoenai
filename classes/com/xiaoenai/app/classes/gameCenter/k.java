package com.xiaoenai.app.classes.gameCenter;

import android.graphics.Bitmap;
import android.webkit.WebView;
import com.xiaoenai.app.classes.common.webview.w;
import com.xiaoenai.app.utils.f.a;

class k
  extends w
{
  k(WebGameActivity paramWebGameActivity, String paramString)
  {
    super(paramString);
  }
  
  public void onLoadResource(WebView paramWebView, String paramString)
  {
    super.onLoadResource(paramWebView, paramString);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    this.a.b(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    this.a.a(paramWebView, paramString);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    this.a.a(paramWebView, paramInt, paramString1, paramString2);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    boolean bool = false;
    a.c("url = {}", new Object[] { paramString });
    if (paramString.contains("xiaoenaisdk")) {
      if (paramString.contains("login")) {
        WebGameActivity.a(this.a, paramWebView, paramString);
      }
    }
    for (;;)
    {
      bool = true;
      do
      {
        return bool;
        if (!paramString.contains("share")) {
          break;
        }
        return super.shouldOverrideUrlLoading(paramWebView, paramString);
      } while (paramString.contains("http"));
      if (paramString.contains("xiaoenaiapi")) {
        WebGameActivity.b(this.a, paramWebView, paramString);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\gameCenter\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */