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
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebSettings.TextSize;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.alipay.sdk.util.k;
import java.lang.reflect.Method;
import java.net.URLDecoder;

public class H5AuthActivity
  extends Activity
{
  private WebView a;
  private com.alipay.sdk.widget.a b;
  private Handler c;
  private boolean d;
  private boolean e;
  private Runnable f = new b(this);
  
  private static void a()
  {
    try
    {
      synchronized (AuthTask.a)
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
      this.b = new com.alipay.sdk.widget.a(this);
    }
    try
    {
      this.b.b();
      return;
    }
    catch (Exception localException)
    {
      this.b = null;
    }
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
      synchronized (AuthTask.a)
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
      if (this.e)
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
        paramBundle = getIntent().getExtras();
        if (paramBundle == null)
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
        paramBundle = paramBundle.getString("url");
        if (!k.a(paramBundle))
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
      Object localObject = new LinearLayout(getApplicationContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
      ((LinearLayout)localObject).setOrientation(1);
      setContentView((View)localObject, localLayoutParams);
      this.a = new WebView(getApplicationContext());
      localLayoutParams.weight = 1.0F;
      this.a.setVisibility(0);
      ((LinearLayout)localObject).addView(this.a, localLayoutParams);
      localObject = this.a.getSettings();
      ((WebSettings)localObject).setUserAgentString(((WebSettings)localObject).getUserAgentString() + k.c(getApplicationContext()));
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
      this.a.setDownloadListener(new a(this));
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
    
    public final void onPageFinished(WebView paramWebView, String paramString)
    {
      H5AuthActivity.f(H5AuthActivity.this);
      H5AuthActivity.e(H5AuthActivity.this).removeCallbacks(H5AuthActivity.d(H5AuthActivity.this));
    }
    
    public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      H5AuthActivity.c(H5AuthActivity.this);
      H5AuthActivity.e(H5AuthActivity.this).postDelayed(H5AuthActivity.d(H5AuthActivity.this), 30000L);
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }
    
    public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      H5AuthActivity.a(H5AuthActivity.this);
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    }
    
    public final void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
    {
      if (H5AuthActivity.b(H5AuthActivity.this))
      {
        paramSslErrorHandler.proceed();
        H5AuthActivity.a(H5AuthActivity.this, false);
        return;
      }
      H5AuthActivity.this.runOnUiThread(new c(this, paramSslErrorHandler));
    }
    
    public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      if ((TextUtils.equals(paramString, "sdklite://h5quit")) || (TextUtils.equals(paramString, "http://m.alipay.com/?action=h5quit")))
      {
        l.a = l.a();
        H5AuthActivity.this.finish();
        return true;
      }
      if (paramString.startsWith("sdklite://h5quit?result=")) {
        try
        {
          paramWebView = paramString.substring(paramString.indexOf("sdklite://h5quit?result=") + 24);
          int i = Integer.parseInt(paramWebView.substring(paramWebView.lastIndexOf("&end_code=") + 10));
          if (i == m.a.a())
          {
            paramWebView = URLDecoder.decode(paramString);
            paramWebView = paramWebView.substring(paramWebView.indexOf("sdklite://h5quit?result=") + 24, paramWebView.lastIndexOf("&end_code="));
            paramString = m.a(i);
          }
          for (l.a = l.a(paramString.a(), paramString.b(), paramWebView);; l.a = l.a(paramWebView.a(), paramWebView.b(), ""))
          {
            paramWebView = new f(this);
            H5AuthActivity.this.runOnUiThread(paramWebView);
            return true;
            paramWebView = m.a(m.b.a());
          }
        }
        catch (Exception paramWebView)
        {
          for (;;)
          {
            l.a = l.b();
          }
        }
      }
      paramWebView.loadUrl(paramString);
      return true;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\app\H5AuthActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */