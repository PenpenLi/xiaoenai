package com.alibaba.sdk.android.webview;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.plugin.config.PluginConfigurations;
import com.alibaba.sdk.android.trace.ActionTraceLogger;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.trace.TraceLoggerManager;
import com.alibaba.sdk.android.ui.UIContext;
import com.alibaba.sdk.android.util.CommonUtils;
import com.alibaba.sdk.android.util.ResourceUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseWebViewClient
  extends WebViewClient
{
  private volatile long pageStartedTime;
  
  private boolean matchSslErrorIngoreUrl(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Pattern[] arrayOfPattern;
    int j;
    int i;
    if (UIContext.SSL_ERROR_IGNORE_URLS != null)
    {
      bool1 = bool2;
      if (UIContext.SSL_ERROR_IGNORE_URLS.length > 0)
      {
        arrayOfPattern = UIContext.SSL_ERROR_IGNORE_URLS;
        j = arrayOfPattern.length;
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (arrayOfPattern[i].matcher(paramString).matches()) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    int i = paramString.indexOf('?');
    if (i > 0) {}
    for (paramWebView = paramString.substring(0, i);; paramWebView = paramString)
    {
      AliSDKLogger.d(3, "webview", paramString, "success");
      long l1 = System.currentTimeMillis();
      long l2 = this.pageStartedTime;
      TraceLoggerManager.INSTANCE.action("webview", paramWebView).info("caseTime", Long.valueOf(l1 - l2)).success();
      return;
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    this.pageStartedTime = System.currentTimeMillis();
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if (!CommonUtils.isNetworkAvailable()) {
      Toast.makeText(UIContext.appContext.getAndroidContext(), ResourceUtils.getString("com_taobao_tae_sdk_network_not_available_message"), 0).show();
    }
    int i;
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      i = paramString2.indexOf('?');
      if (i <= 0) {
        break label116;
      }
    }
    label116:
    for (paramWebView = paramString2.substring(0, i);; paramWebView = paramString2)
    {
      AliSDKLogger.d(1, "webview", paramString2, "failed");
      TraceLoggerManager.INSTANCE.action("webview", paramWebView).info("caseTime", Long.valueOf(System.currentTimeMillis() - this.pageStartedTime)).info("code", Integer.valueOf(paramInt)).info("desc", paramString1).failed();
      return;
    }
  }
  
  @TargetApi(14)
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    boolean bool = false;
    if (UIContext.pluginConfigurations != null) {
      bool = UIContext.pluginConfigurations.getBooleanValue("ignoreWebViewSSLError", false);
    }
    if ((bool) && (paramSslErrorHandler != null)) {
      paramSslErrorHandler.proceed();
    }
    do
    {
      return;
      if ((Build.VERSION.SDK_INT >= 14) && (paramSslErrorHandler != null) && (paramSslError != null) && (paramSslError.getPrimaryError() <= 4) && (matchSslErrorIngoreUrl(paramSslError.getUrl())))
      {
        paramSslErrorHandler.proceed();
        return;
      }
    } while (paramSslErrorHandler == null);
    paramSslErrorHandler.cancel();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\webview\BaseWebViewClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */