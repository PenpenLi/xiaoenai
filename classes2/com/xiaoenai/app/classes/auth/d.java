package com.xiaoenai.app.classes.auth;

import android.graphics.Bitmap;
import android.webkit.HttpAuthHandler;
import android.webkit.WebView;
import com.xiaoenai.app.classes.common.webview.w;

class d
  extends w
{
  d(b paramb) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    b.a(this.a).a(paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    b.a(this.a).b(paramString);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    b.a(this.a).a(paramInt, paramString1);
  }
  
  public void onReceivedHttpAuthRequest(WebView paramWebView, HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
  {
    super.onReceivedHttpAuthRequest(paramWebView, paramHttpAuthHandler, paramString1, paramString2);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    com.xiaoenai.app.utils.f.a.c("shouldOverrideUrlLoading url={}", new Object[] { paramString });
    if (paramString.startsWith("xiaoenaiapi://"))
    {
      if (b.b(this.a) != null)
      {
        if (!paramString.startsWith("xiaoenaiapi://authorizesuccess")) {
          break label87;
        }
        b.e(this.a).a(paramString, b.c(this.a), b.d(this.a), b.a(this.a));
        b.b(this.a).setVisibility(8);
      }
      label87:
      do
      {
        return true;
        if (paramString.startsWith("xiaoenaiapi://authorizecancel"))
        {
          b.e(this.a).a(paramString, b.a(this.a));
          b.b(this.a).setVisibility(8);
          return true;
        }
      } while (!paramString.startsWith("xiaoenaiapi://authorizefailed"));
      b.e(this.a).a(paramString, b.c(this.a), b.d(this.a), b.a(this.a));
      b.b(this.a).setVisibility(8);
      return true;
    }
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\auth\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */