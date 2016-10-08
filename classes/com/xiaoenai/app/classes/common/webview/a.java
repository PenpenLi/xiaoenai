package com.xiaoenai.app.classes.common.webview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import com.xiaoenai.app.classes.common.c.c;
import com.xiaoenai.app.classes.common.c.j;
import com.xiaoenai.app.utils.al;

class a
  extends w
{
  a(WebViewActivity paramWebViewActivity) {}
  
  public void onLoadResource(WebView paramWebView, String paramString)
  {
    super.onLoadResource(paramWebView, paramString);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    this.a.a(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    this.a.b(paramString);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    this.a.a(paramInt, paramString1, paramString2);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    WebViewActivity.a(this.a, paramWebView.getTitle());
    com.xiaoenai.app.utils.f.a.c("protocol:{}", new Object[] { paramString });
    if (paramString.startsWith("weixin://"))
    {
      paramWebView = new Intent();
      paramWebView.setAction("android.intent.action.VIEW");
      paramWebView.setData(Uri.parse(paramString));
      this.a.startActivity(paramWebView);
      return true;
    }
    if (paramString.startsWith("xiaoenaisdk"))
    {
      if (paramString.contains("share"))
      {
        WebViewActivity.b(this.a, paramString);
        return true;
      }
      if (paramString.contains("street_topic"))
      {
        WebViewActivity.c(this.a, paramString.substring(paramString.indexOf("?", 0) + 1, paramString.length()));
        return true;
      }
      if (paramString.contains("pay"))
      {
        WebViewActivity.a(this.a);
        WebViewActivity.a(this.a, new com.xiaoenai.app.classes.street.pay.a.a(this.a, WebViewActivity.b(this.a)));
        WebViewActivity.d(this.a, paramString);
        return true;
      }
      if (paramString.contains("signature"))
      {
        WebViewActivity.e(this.a, paramString);
        return true;
      }
      if (paramString.contains("uploadImage"))
      {
        WebViewActivity.f(this.a, paramString);
        return true;
      }
      if (paramString.contains("reply"))
      {
        WebViewActivity.g(this.a, paramString);
        return true;
      }
      if (paramString.contains("report"))
      {
        WebViewActivity.h(this.a, paramString);
        return true;
      }
      if (paramString.contains("bindPhone"))
      {
        WebViewActivity.i(this.a, paramString);
        return true;
      }
      if (paramString.contains("close"))
      {
        this.a.a_(WebViewActivity.c(this.a));
        return true;
      }
      if (paramString.contains("changeTitle"))
      {
        WebViewActivity.j(this.a, paramString);
        return true;
      }
    }
    else
    {
      if (!paramString.contains("open_in_broswer")) {
        break label374;
      }
      if (al.a(paramString.substring(paramString.indexOf("?", 0) + 1, paramString.length())).getString("open_in_broswer").equals("true")) {
        WebViewActivity.k(this.a, paramString);
      }
    }
    for (;;)
    {
      return false;
      label374:
      if (paramString.startsWith("xiaoenai://"))
      {
        new c().a(this.a, paramString, new j(), WebViewActivity.d(this.a));
        return true;
      }
      if ((paramString.contains("open_in_browser")) && (al.a(paramString.substring(paramString.indexOf("?", 0) + 1, paramString.length())).getString("open_in_browser").equals("true"))) {
        WebViewActivity.k(this.a, paramString);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\webview\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */