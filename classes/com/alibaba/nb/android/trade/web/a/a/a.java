package com.alibaba.nb.android.trade.web.a.a;

import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.alibaba.nb.a.a.a.a.a;
import com.alibaba.nb.android.trade.AliTradeContext;
import com.alibaba.sdk.android.trace.ActionTraceLogger;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.trace.TraceLoggerManager;
import com.alibaba.sdk.android.util.CommonUtils;
import com.alibaba.sdk.android.util.ResourceUtils;
import java.lang.ref.WeakReference;
import java.util.Map;

public class a
  extends WebViewClient
{
  public static boolean b = false;
  private volatile long a;
  Map<String, String> c;
  private WeakReference<WebViewClient> d;
  
  public a(WebViewClient paramWebViewClient, Map<String, String> paramMap)
  {
    this.d = new WeakReference(paramWebViewClient);
    this.c = paramMap;
  }
  
  public void doUpdateVisitedHistory(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    if ((this.d != null) && (this.d.get() != null)) {
      ((WebViewClient)this.d.get()).doUpdateVisitedHistory(paramWebView, paramString, paramBoolean);
    }
  }
  
  public void onFormResubmission(WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    if ((this.d != null) && (this.d.get() != null)) {
      ((WebViewClient)this.d.get()).onFormResubmission(paramWebView, paramMessage1, paramMessage2);
    }
  }
  
  public void onLoadResource(WebView paramWebView, String paramString)
  {
    if ((this.d != null) && (this.d.get() != null)) {
      ((WebViewClient)this.d.get()).onLoadResource(paramWebView, paramString);
    }
  }
  
  public void onPageCommitVisible(WebView paramWebView, String paramString)
  {
    if ((Build.VERSION.SDK_INT >= 23) && (this.d != null) && (this.d.get() != null)) {
      ((WebViewClient)this.d.get()).onPageCommitVisible(paramWebView, paramString);
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    int i = paramString.indexOf('?');
    if (i > 0) {}
    for (String str = paramString.substring(0, i);; str = paramString)
    {
      AliSDKLogger.d(3, "webview", paramString, "success");
      long l1 = System.currentTimeMillis();
      long l2 = this.a;
      TraceLoggerManager.INSTANCE.action("webview", str).info("caseTime", Long.valueOf(l1 - l2)).success();
      if ((this.d != null) && (this.d.get() != null)) {
        ((WebViewClient)this.d.get()).onPageFinished(paramWebView, paramString);
      }
      return;
    }
  }
  
  public void onReceivedClientCertRequest(WebView paramWebView, ClientCertRequest paramClientCertRequest)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (this.d != null) && (this.d.get() != null)) {
      ((WebViewClient)this.d.get()).onReceivedClientCertRequest(paramWebView, paramClientCertRequest);
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if (!CommonUtils.isNetworkAvailable()) {
      Toast.makeText(AliTradeContext.context, ResourceUtils.getString("com_taobao_tae_sdk_network_not_available_message"), 0).show();
    }
    int i;
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      i = paramString2.indexOf('?');
      if (i <= 0) {
        break label148;
      }
    }
    label148:
    for (String str = paramString2.substring(0, i);; str = paramString2)
    {
      AliSDKLogger.d(1, "webview", paramString2, "failed");
      TraceLoggerManager.INSTANCE.action("webview", str).info("caseTime", Long.valueOf(System.currentTimeMillis() - this.a)).info("code", Integer.valueOf(paramInt)).info("desc", paramString1).failed();
      if ((this.d != null) && (this.d.get() != null)) {
        ((WebViewClient)this.d.get()).onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      }
      return;
    }
  }
  
  public void onReceivedHttpAuthRequest(WebView paramWebView, HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
  {
    if ((this.d != null) && (this.d.get() != null)) {
      ((WebViewClient)this.d.get()).onReceivedHttpAuthRequest(paramWebView, paramHttpAuthHandler, paramString1, paramString2);
    }
  }
  
  public void onReceivedHttpError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    if ((Build.VERSION.SDK_INT >= 23) && (this.d != null) && (this.d.get() != null)) {
      ((WebViewClient)this.d.get()).onReceivedHttpError(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
    }
  }
  
  public void onReceivedLoginRequest(WebView paramWebView, String paramString1, String paramString2, String paramString3)
  {
    if ((Build.VERSION.SDK_INT >= 23) && (this.d != null) && (this.d.get() != null)) {
      ((WebViewClient)this.d.get()).onReceivedLoginRequest(paramWebView, paramString1, paramString2, paramString3);
    }
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    if ((this.d != null) && (this.d.get() != null)) {
      ((WebViewClient)this.d.get()).onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
    }
  }
  
  public void onScaleChanged(WebView paramWebView, float paramFloat1, float paramFloat2)
  {
    if ((this.d != null) && (this.d.get() != null)) {
      ((WebViewClient)this.d.get()).onScaleChanged(paramWebView, paramFloat1, paramFloat2);
    }
  }
  
  @Deprecated
  public void onTooManyRedirects(WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    if ((this.d != null) && (this.d.get() != null)) {
      ((WebViewClient)this.d.get()).onTooManyRedirects(paramWebView, paramMessage1, paramMessage2);
    }
  }
  
  public void onUnhandledInputEvent(WebView paramWebView, InputEvent paramInputEvent)
  {
    if ((Build.VERSION.SDK_INT >= 23) && (this.d != null) && (this.d.get() != null)) {
      ((WebViewClient)this.d.get()).onUnhandledInputEvent(paramWebView, paramInputEvent);
    }
  }
  
  public void onUnhandledKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent)
  {
    if ((this.d != null) && (this.d.get() != null)) {
      ((WebViewClient)this.d.get()).onUnhandledKeyEvent(paramWebView, paramKeyEvent);
    }
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (this.d != null) && (this.d.get() != null)) {
      return ((WebViewClient)this.d.get()).shouldInterceptRequest(paramWebView, paramWebResourceRequest);
    }
    return super.shouldInterceptRequest(paramWebView, paramWebResourceRequest);
  }
  
  @Deprecated
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    if ((Build.VERSION.SDK_INT > 23) && (this.d != null) && (this.d.get() != null)) {
      return ((WebViewClient)this.d.get()).shouldInterceptRequest(paramWebView, paramString);
    }
    return super.shouldInterceptRequest(paramWebView, paramString);
  }
  
  public boolean shouldOverrideKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent)
  {
    if ((this.d != null) && (this.d.get() != null)) {
      return ((WebViewClient)this.d.get()).shouldOverrideKeyEvent(paramWebView, paramKeyEvent);
    }
    return super.shouldOverrideKeyEvent(paramWebView, paramKeyEvent);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    boolean bool2 = false;
    paramWebView.setTag(a.a.e, Boolean.valueOf(false));
    boolean bool1 = bool2;
    if (this.d != null)
    {
      bool1 = bool2;
      if (this.d.get() != null) {
        bool1 = ((WebViewClient)this.d.get()).shouldOverrideUrlLoading(paramWebView, paramString);
      }
    }
    return bool1;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\web\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */