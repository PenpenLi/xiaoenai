package com.alibaba.nb.android.trade.web.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.alibaba.nb.a.a.a.a.a;
import com.alibaba.nb.android.trade.AliTradeContext;
import com.alibaba.nb.android.trade.service.config.impl.AliTradeConfigServiceImpl;
import com.alibaba.nb.android.trade.ui.activity.AliTradeBaseWebViewActivity;
import com.alibaba.sdk.android.util.CommonUtils;
import com.alibaba.sdk.android.web.impl.CookieManagerWrapper;
import com.alibaba.sdk.android.webview.utils.WebViewUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private static final String c = " AliApp(BC/" + AliTradeContext.sdkVersion + ")";
  private static final String d = " tae_sdk_" + AliTradeContext.sdkVersion;
  private WebView a;
  private WebViewClient b;
  private String e;
  private String f;
  private boolean g;
  private HashMap<String, Object> h = new HashMap();
  
  public c(WebView paramWebView, Map<String, Object> paramMap)
  {
    this(paramWebView, paramMap, null, false);
  }
  
  public c(WebView paramWebView, Map<String, Object> paramMap, WebViewClient paramWebViewClient, boolean paramBoolean)
  {
    this.a = paramWebView;
    this.b = paramWebViewClient;
    this.h = ((HashMap)paramMap);
    this.g = paramBoolean;
    paramWebView = this.a;
    paramMap = paramWebView.getSettings();
    try
    {
      paramMap.setJavaScriptEnabled(true);
      paramMap.setSavePassword(false);
      paramMap.setUseWideViewPort(true);
      paramMap.setLoadWithOverviewMode(true);
      paramMap.setJavaScriptCanOpenWindowsAutomatically(false);
      paramMap.setDomStorageEnabled(true);
      this.f = paramWebView.getContext().getApplicationContext().getDir("cache", 0).getPath();
      paramMap.setAppCachePath(this.f);
      paramMap.setAllowFileAccess(true);
      paramMap.setAppCacheEnabled(true);
      paramMap.setDefaultTextEncodingName("UTF-8");
      if (CommonUtils.isNetworkAvailable(paramWebView.getContext()))
      {
        paramMap.setCacheMode(-1);
        paramMap.setBuiltInZoomControls(false);
        paramWebViewClient = new StringBuilder();
        this.e = paramMap.getUserAgentString();
        if (this.e != null) {
          paramWebViewClient.append(this.e);
        }
        if (!WebViewUtils.isLoginDowngraded()) {
          paramWebViewClient.append(d);
        }
        paramWebViewClient.append(c);
        paramWebViewClient.append(String.format(" AliBaichuan(%s/%s)", new Object[] { AliTradeConfigServiceImpl.getInstance().getWebTTID(), AliTradeConfigServiceImpl.getInstance().getIsvVersion() }));
        paramMap.setUserAgentString(paramWebViewClient.toString());
        if (Build.VERSION.SDK_INT >= 21) {
          CookieManager.getInstance().setAcceptThirdPartyCookies(paramWebView, true);
        }
        if (!this.g) {
          paramWebView.setWebChromeClient(new a((byte)0));
        }
        if (this.b != null) {
          break label333;
        }
        this.a.setWebViewClient(new d(this));
      }
      for (;;)
      {
        this.a.setTag(a.a.e, Boolean.valueOf(false));
        this.a.setOnClickListener(new f(this));
        return;
        paramMap.setCacheMode(1);
        break;
        label333:
        paramWebView = new e(this, this.b, c());
        this.a.setWebViewClient(paramWebView);
      }
    }
    catch (Exception paramWebViewClient)
    {
      for (;;) {}
    }
  }
  
  protected static void a(String paramString)
  {
    try
    {
      CookieManagerWrapper.INSTANCE.refreshCookie(paramString);
      return;
    }
    catch (Exception paramString)
    {
      com.alibaba.nb.android.trade.utils.d.a.a("ui", "fail to refresh cookie", paramString);
    }
  }
  
  public final WebView a()
  {
    return this.a;
  }
  
  public final void b(String paramString)
  {
    a(paramString);
    this.a.loadUrl(paramString);
  }
  
  public final boolean b()
  {
    return com.alibaba.nb.android.trade.utils.g.a.a(this.a);
  }
  
  public final Map<String, String> c()
  {
    return (Map)this.h.get("ui_contextParams");
  }
  
  public final boolean d()
  {
    return "true".equals(this.h.get("show_by_h5"));
  }
  
  public final boolean e()
  {
    return "true".equals(this.h.get("backLoginFail"));
  }
  
  public final void f()
  {
    a(this.a.getUrl());
    this.a.reload();
  }
  
  public final void g()
  {
    com.alibaba.nb.android.trade.utils.g.a.b(this.a);
  }
  
  private final class a
    extends WebChromeClient
  {
    private a() {}
    
    public final void onReceivedTitle(WebView paramWebView, String paramString)
    {
      super.onReceivedTitle(paramWebView, paramString);
      if ((paramWebView != null) && ((paramWebView.getContext() instanceof AliTradeBaseWebViewActivity)))
      {
        paramWebView = (AliTradeBaseWebViewActivity)paramWebView.getContext();
        if (paramWebView.d) {
          paramWebView.c.setText(paramString);
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\web\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */