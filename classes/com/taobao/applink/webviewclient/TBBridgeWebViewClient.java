package com.taobao.applink.webviewclient;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.taobao.applink.jsbridge.adapter.TBBridgeAdapter;
import com.taobao.applink.util.TBAppLinkJsBridgeUtil;
import java.net.URLDecoder;

public class TBBridgeWebViewClient
  extends WebViewClient
{
  private TBBridgeAdapter mTBBridgeAdapter = null;
  private WebViewClient mWebViewClient;
  
  public TBBridgeWebViewClient(WebViewClient paramWebViewClient)
  {
    this.mWebViewClient = paramWebViewClient;
  }
  
  public void doUpdateVisitedHistory(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    this.mWebViewClient.doUpdateVisitedHistory(paramWebView, paramString, paramBoolean);
  }
  
  public TBBridgeAdapter getTBBridgeAdapter()
  {
    return this.mTBBridgeAdapter;
  }
  
  public void onFormResubmission(WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    this.mWebViewClient.onFormResubmission(paramWebView, paramMessage1, paramMessage2);
  }
  
  public void onLoadResource(WebView paramWebView, String paramString)
  {
    this.mWebViewClient.onLoadResource(paramWebView, paramString);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    this.mWebViewClient.onPageFinished(paramWebView, paramString);
    TBAppLinkJsBridgeUtil.webViewLoadAppInfo(paramWebView);
    TBAppLinkJsBridgeUtil.webViewLoadLocalJs(paramWebView);
    if (this.mTBBridgeAdapter != null) {
      this.mTBBridgeAdapter.initMessageQueue(paramWebView);
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    this.mWebViewClient.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    this.mWebViewClient.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
  }
  
  public void onReceivedHttpAuthRequest(WebView paramWebView, HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
  {
    this.mWebViewClient.onReceivedHttpAuthRequest(paramWebView, paramHttpAuthHandler, paramString1, paramString2);
  }
  
  @TargetApi(12)
  public void onReceivedLoginRequest(WebView paramWebView, String paramString1, String paramString2, String paramString3)
  {
    this.mWebViewClient.onReceivedLoginRequest(paramWebView, paramString1, paramString2, paramString3);
  }
  
  @TargetApi(8)
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    this.mWebViewClient.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
  }
  
  public void onScaleChanged(WebView paramWebView, float paramFloat1, float paramFloat2)
  {
    this.mWebViewClient.onScaleChanged(paramWebView, paramFloat1, paramFloat2);
  }
  
  public void onTooManyRedirects(WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    this.mWebViewClient.onTooManyRedirects(paramWebView, paramMessage1, paramMessage2);
  }
  
  public void onUnhandledKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent)
  {
    this.mWebViewClient.onUnhandledKeyEvent(paramWebView, paramKeyEvent);
  }
  
  public void setTBBridgeAdapter(TBBridgeAdapter paramTBBridgeAdapter)
  {
    if (paramTBBridgeAdapter == null) {
      return;
    }
    this.mTBBridgeAdapter = paramTBBridgeAdapter;
  }
  
  @TargetApi(11)
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    return this.mWebViewClient.shouldInterceptRequest(paramWebView, paramString);
  }
  
  public boolean shouldOverrideKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent)
  {
    return this.mWebViewClient.shouldOverrideKeyEvent(paramWebView, paramKeyEvent);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (this.mTBBridgeAdapter == null) {
      return this.mWebViewClient.shouldOverrideUrlLoading(paramWebView, paramString);
    }
    do
    {
      try
      {
        String str = URLDecoder.decode(paramString, "UTF-8");
        if (str.startsWith("tblink://return/"))
        {
          this.mTBBridgeAdapter.handlerReturnData(paramWebView, str);
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        Log.d("AppLink", localThrowable.toString());
        return this.mWebViewClient.shouldOverrideUrlLoading(paramWebView, paramString);
      }
    } while (!localThrowable.startsWith("tblink://"));
    this.mTBBridgeAdapter.flushMessageQueue(paramWebView);
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\applink\webviewclient\TBBridgeWebViewClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */