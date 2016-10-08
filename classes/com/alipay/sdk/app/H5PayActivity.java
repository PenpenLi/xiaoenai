package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebSettings.TextSize;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.alipay.sdk.widget.a;
import java.lang.reflect.Method;
import java.net.URLDecoder;

public class H5PayActivity
  extends Activity
{
  private WebView a;
  private a b;
  private Handler c;
  private boolean d;
  private boolean e;
  private Runnable f = new g(this);
  
  private static void a()
  {
    try
    {
      synchronized (PayTask.a)
      {
        ???.notify();
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  private void b()
  {
    if (this.b == null) {
      this.b = new a(this);
    }
    this.b.b();
  }
  
  private void c()
  {
    if ((this.b != null) && (this.b.a())) {
      this.b.c();
    }
    this.b = null;
  }
  
  public void finish()
  {
    try
    {
      synchronized (PayTask.a)
      {
        ???.notify();
        super.finish();
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void onBackPressed()
  {
    if (this.a.canGoBack())
    {
      if (this.d)
      {
        m localm = m.a(m.d.a());
        l.a = l.a(localm.a(), localm.b(), "");
        finish();
      }
      return;
    }
    l.a = l.a();
    finish();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    for (;;)
    {
      try
      {
        localObject = getIntent().getExtras();
        if (localObject == null)
        {
          finish();
          return;
        }
      }
      catch (Exception paramBundle)
      {
        finish();
        return;
      }
      try
      {
        paramBundle = ((Bundle)localObject).getString("url");
        if (!com.alipay.sdk.util.k.a(paramBundle))
        {
          finish();
          return;
        }
      }
      catch (Exception paramBundle)
      {
        finish();
        return;
      }
      super.requestWindowFeature(1);
      this.c = new Handler(getMainLooper());
      Object localObject = ((Bundle)localObject).getString("cookie");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        CookieSyncManager.createInstance(getApplicationContext()).sync();
        CookieManager.getInstance().setCookie(paramBundle, (String)localObject);
        CookieSyncManager.getInstance().sync();
      }
      localObject = new LinearLayout(getApplicationContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
      ((LinearLayout)localObject).setOrientation(1);
      setContentView((View)localObject, localLayoutParams);
      this.a = new WebView(getApplicationContext());
      localLayoutParams.weight = 1.0F;
      this.a.setVisibility(0);
      ((LinearLayout)localObject).addView(this.a, localLayoutParams);
      localObject = this.a.getSettings();
      ((WebSettings)localObject).setUserAgentString(((WebSettings)localObject).getUserAgentString() + com.alipay.sdk.util.k.c(getApplicationContext()));
      ((WebSettings)localObject).setRenderPriority(WebSettings.RenderPriority.HIGH);
      ((WebSettings)localObject).setSupportMultipleWindows(true);
      ((WebSettings)localObject).setJavaScriptEnabled(true);
      ((WebSettings)localObject).setSavePassword(false);
      ((WebSettings)localObject).setJavaScriptCanOpenWindowsAutomatically(true);
      ((WebSettings)localObject).setMinimumFontSize(((WebSettings)localObject).getMinimumFontSize() + 8);
      ((WebSettings)localObject).setAllowFileAccess(false);
      ((WebSettings)localObject).setTextSize(WebSettings.TextSize.NORMAL);
      this.a.setVerticalScrollbarOverlay(true);
      this.a.setWebViewClient(new a((byte)0));
      this.a.loadUrl(paramBundle);
      if (Build.VERSION.SDK_INT >= 7) {}
      for (;;)
      {
        try
        {
          paramBundle = this.a.getSettings().getClass().getMethod("setDomStorageEnabled", new Class[] { Boolean.TYPE });
          if (paramBundle != null) {
            paramBundle.invoke(this.a.getSettings(), new Object[] { Boolean.valueOf(true) });
          }
        }
        catch (Exception paramBundle)
        {
          continue;
        }
        try
        {
          paramBundle = this.a.getClass().getMethod("removeJavascriptInterface", new Class[0]);
          if (paramBundle == null) {
            break;
          }
          paramBundle.invoke(this.a, new Object[] { "searchBoxJavaBridge_" });
          return;
        }
        catch (Exception paramBundle) {}
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.a != null)
    {
      this.a.removeAllViews();
      this.a.destroy();
      this.a = null;
    }
  }
  
  private final class a
    extends WebViewClient
  {
    private a() {}
    
    public final void onLoadResource(WebView paramWebView, String paramString) {}
    
    public final void onPageFinished(WebView paramWebView, String paramString)
    {
      H5PayActivity.f(H5PayActivity.this);
      H5PayActivity.e(H5PayActivity.this).removeCallbacks(H5PayActivity.d(H5PayActivity.this));
    }
    
    public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      H5PayActivity.c(H5PayActivity.this);
      H5PayActivity.e(H5PayActivity.this).postDelayed(H5PayActivity.d(H5PayActivity.this), 30000L);
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }
    
    public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      H5PayActivity.a(H5PayActivity.this);
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    }
    
    public final void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
    {
      if (H5PayActivity.b(H5PayActivity.this))
      {
        paramSslErrorHandler.proceed();
        H5PayActivity.a(H5PayActivity.this, false);
        return;
      }
      H5PayActivity.this.runOnUiThread(new h(this, paramSslErrorHandler));
    }
    
    public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      if (paramString.startsWith("alipays://platformapi/startApp?")) {
        return false;
      }
      if ((TextUtils.equals(paramString, "sdklite://h5quit")) || (TextUtils.equals(paramString, "http://m.alipay.com/?action=h5quit")))
      {
        l.a = l.a();
        H5PayActivity.this.finish();
        return true;
      }
      if (paramString.startsWith("sdklite://h5quit?result=")) {
        for (;;)
        {
          try
          {
            paramWebView = paramString.substring(paramString.indexOf("sdklite://h5quit?result=") + 24);
            int i = Integer.parseInt(paramWebView.substring(paramWebView.lastIndexOf("&end_code=") + 10));
            if ((i != m.a.a()) && (i != m.f.a())) {
              continue;
            }
            StringBuilder localStringBuilder = new StringBuilder();
            paramWebView = URLDecoder.decode(paramString);
            paramString = paramWebView.substring(paramWebView.indexOf("sdklite://h5quit?result=") + 24, paramWebView.lastIndexOf("&end_code="));
            paramWebView = paramString;
            if (paramString.contains("&return_url=\""))
            {
              paramWebView = paramString.split("&return_url=\"")[0];
              int j = paramString.indexOf("&return_url=\"") + 13;
              localStringBuilder.append(paramWebView).append("&return_url=\"").append(paramString.substring(j, paramString.indexOf("\"&", j))).append(paramString.substring(paramString.indexOf("\"&", j)));
              paramWebView = localStringBuilder.toString();
            }
            paramString = m.a(i);
            l.a = l.a(paramString.a(), paramString.b(), paramWebView);
          }
          catch (Exception paramWebView)
          {
            l.a = l.b();
            continue;
          }
          paramWebView = new k(this);
          H5PayActivity.this.runOnUiThread(paramWebView);
          return true;
          paramWebView = m.a(m.b.a());
          l.a = l.a(paramWebView.a(), paramWebView.b(), "");
        }
      }
      paramWebView.loadUrl(paramString);
      return true;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\app\H5PayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */