package com.inmobi.rendering.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.concurrent.atomic.AtomicBoolean;

class c$b$1$1
  extends WebViewClient
{
  AtomicBoolean a;
  boolean b;
  
  c$b$1$1(c.b.1 param1) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    this.a.set(true);
    if ((!this.b) && (!this.c.a.g.get())) {
      c.b.a(this.c.c).a(this.c.a);
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    this.a = new AtomicBoolean(false);
    this.b = false;
    new Thread(new c.b.1.1.1(this, paramWebView)).start();
  }
  
  @TargetApi(22)
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    this.b = true;
    c.b.a(this.c.c).a(this.c.a, null);
  }
  
  @TargetApi(23)
  public void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
  {
    this.b = true;
    c.b.a(this.c.c).a(this.c.a, null);
  }
  
  @TargetApi(23)
  public void onReceivedHttpError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    this.b = true;
    c.b.a(this.c.c).a(this.c.a, null);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return (!this.c.a.i) && (!paramString.equals(this.c.a.b));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\a\c$b$1$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */