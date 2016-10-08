package com.xiaoenai.app.classes.auth;

import android.app.Activity;
import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.net.m;
import java.io.File;

public class b
{
  WebChromeClient a = new c(this);
  private WebView b;
  private a c;
  private Activity d;
  private e e;
  private m f;
  private String g;
  private WebViewClient h = new d(this);
  
  public b(WebView paramWebView, Activity paramActivity, e parame, m paramm, String paramString)
  {
    this.b = paramWebView;
    this.c = new a();
    this.d = paramActivity;
    this.e = parame;
    this.f = paramm;
    this.g = paramString;
  }
  
  public void a()
  {
    if (this.b != null)
    {
      this.b.setWebChromeClient(this.a);
      this.b.setWebViewClient(this.h);
      this.b.setScrollBarStyle(0);
      WebSettings localWebSettings = this.b.getSettings();
      localWebSettings.setJavaScriptEnabled(true);
      localWebSettings.setDomStorageEnabled(true);
      localWebSettings.setAppCacheMaxSize(8388608L);
      localWebSettings.setAppCachePath(Xiaoenai.j().getApplicationContext().getDir("cache", 0).getPath());
      localWebSettings.setAllowFileAccess(true);
      localWebSettings.setAppCacheEnabled(false);
      localWebSettings.setCacheMode(-1);
    }
  }
  
  public void a(String paramString)
  {
    this.b.loadUrl(paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\auth\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */