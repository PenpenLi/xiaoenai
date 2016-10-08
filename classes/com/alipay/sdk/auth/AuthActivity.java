package com.alipay.sdk.auth;

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
import android.webkit.ConsoleMessage;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebSettings.TextSize;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.alipay.sdk.authjs.a.a;
import com.alipay.sdk.util.k;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthActivity
  extends Activity
{
  static final String a = "params";
  static final String b = "redirectUri";
  private WebView c;
  private String d;
  private com.alipay.sdk.widget.a e;
  private Handler f;
  private boolean g;
  private boolean h;
  private Runnable i = new d(this);
  
  private void a()
  {
    try
    {
      if (this.e == null) {
        this.e = new com.alipay.sdk.widget.a(this);
      }
      this.e.b();
      return;
    }
    catch (Exception localException)
    {
      this.e = null;
    }
  }
  
  private void a(com.alipay.sdk.authjs.a parama)
  {
    if ((this.c == null) || (parama == null)) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("clientId", parama.i);
      localJSONObject.put("func", parama.k);
      localJSONObject.put("param", parama.m);
      localJSONObject.put("msgType", parama.l);
      runOnUiThread(new c(this, String.format("AlipayJSBridge._invokeJS(%s)", new Object[] { localJSONObject.toString() })));
      return;
    }
    catch (JSONException parama) {}
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) {
      return false;
    }
    if (!"SDKLite://h5quit".equalsIgnoreCase(paramString))
    {
      String str = paramString;
      if (TextUtils.equals(paramString, this.d)) {
        str = paramString + "?resultCode=150";
      }
      h.a(this, str);
    }
    finish();
    return true;
  }
  
  private void b()
  {
    if ((this.e != null) && (this.e.a())) {
      this.e.c();
    }
    this.e = null;
  }
  
  private void b(String paramString)
  {
    com.alipay.sdk.authjs.c localc = new com.alipay.sdk.authjs.c(getApplicationContext(), new b(this));
    for (;;)
    {
      try
      {
        localObject = new JSONObject(paramString);
        str1 = ((JSONObject)localObject).getString("clientId");
      }
      catch (Exception paramString)
      {
        Object localObject;
        String str1;
        String str2;
        com.alipay.sdk.authjs.a locala;
        paramString = null;
        continue;
        paramString = null;
        continue;
      }
      try
      {
        if (TextUtils.isEmpty(str1)) {
          return;
        }
        paramString = ((JSONObject)localObject).getJSONObject("param");
        if (!(paramString instanceof JSONObject)) {
          continue;
        }
        paramString = (JSONObject)paramString;
        str2 = ((JSONObject)localObject).getString("func");
        localObject = ((JSONObject)localObject).getString("bundleName");
        locala = new com.alipay.sdk.authjs.a("call");
        locala.j = ((String)localObject);
        locala.k = str2;
        locala.m = paramString;
        locala.i = str1;
        localc.a(locala);
        return;
      }
      catch (Exception paramString)
      {
        paramString = str1;
        if (TextUtils.isEmpty(paramString)) {
          return;
        }
      }
    }
    try
    {
      localc.a(paramString, a.a.d);
      return;
    }
    catch (JSONException paramString) {}
  }
  
  public void onBackPressed()
  {
    if (this.c.canGoBack())
    {
      if (this.h)
      {
        h.a(this, this.d + "?resultCode=150");
        finish();
      }
      return;
    }
    h.a(this, this.d + "?resultCode=150");
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
        this.d = paramBundle.getString("redirectUri");
        paramBundle = paramBundle.getString("params");
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
      this.f = new Handler(getMainLooper());
      Object localObject = new LinearLayout(getApplicationContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
      ((LinearLayout)localObject).setOrientation(1);
      setContentView((View)localObject, localLayoutParams);
      this.c = new WebView(getApplicationContext());
      localLayoutParams.weight = 1.0F;
      this.c.setVisibility(0);
      ((LinearLayout)localObject).addView(this.c, localLayoutParams);
      localObject = this.c.getSettings();
      ((WebSettings)localObject).setUserAgentString(((WebSettings)localObject).getUserAgentString() + k.c(getApplicationContext()));
      ((WebSettings)localObject).setRenderPriority(WebSettings.RenderPriority.HIGH);
      ((WebSettings)localObject).setSupportMultipleWindows(true);
      ((WebSettings)localObject).setJavaScriptEnabled(true);
      ((WebSettings)localObject).setSavePassword(false);
      ((WebSettings)localObject).setJavaScriptCanOpenWindowsAutomatically(true);
      ((WebSettings)localObject).setMinimumFontSize(((WebSettings)localObject).getMinimumFontSize() + 8);
      ((WebSettings)localObject).setAllowFileAccess(false);
      ((WebSettings)localObject).setTextSize(WebSettings.TextSize.NORMAL);
      this.c.setVerticalScrollbarOverlay(true);
      this.c.setWebViewClient(new b((byte)0));
      this.c.setWebChromeClient(new a((byte)0));
      this.c.setDownloadListener(new a(this));
      this.c.loadUrl(paramBundle);
      if (Build.VERSION.SDK_INT >= 7) {}
      for (;;)
      {
        try
        {
          paramBundle = this.c.getSettings().getClass().getMethod("setDomStorageEnabled", new Class[] { Boolean.TYPE });
          if (paramBundle != null) {
            paramBundle.invoke(this.c.getSettings(), new Object[] { Boolean.valueOf(true) });
          }
        }
        catch (Exception paramBundle)
        {
          continue;
        }
        try
        {
          paramBundle = this.c.getClass().getMethod("removeJavascriptInterface", new Class[0]);
          if (paramBundle == null) {
            break;
          }
          paramBundle.invoke(this.c, new Object[] { "searchBoxJavaBridge_" });
          return;
        }
        catch (Exception paramBundle) {}
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.c != null)
    {
      this.c.removeAllViews();
      this.c.destroy();
      this.c = null;
    }
  }
  
  private final class a
    extends WebChromeClient
  {
    private a() {}
    
    public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      String str2 = paramConsoleMessage.message();
      if (TextUtils.isEmpty(str2)) {
        return super.onConsoleMessage(paramConsoleMessage);
      }
      String str1 = null;
      if (str2.startsWith("h5container.message: ")) {
        str1 = str2.replaceFirst("h5container.message: ", "");
      }
      if (TextUtils.isEmpty(str1)) {
        return super.onConsoleMessage(paramConsoleMessage);
      }
      AuthActivity.b(AuthActivity.this, str1);
      return super.onConsoleMessage(paramConsoleMessage);
    }
  }
  
  private final class b
    extends WebViewClient
  {
    private b() {}
    
    public final void onPageFinished(WebView paramWebView, String paramString)
    {
      AuthActivity.g(AuthActivity.this);
      AuthActivity.f(AuthActivity.this).removeCallbacks(AuthActivity.e(AuthActivity.this));
    }
    
    public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AuthActivity.d(AuthActivity.this);
      AuthActivity.f(AuthActivity.this).postDelayed(AuthActivity.e(AuthActivity.this), 30000L);
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }
    
    public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      AuthActivity.a(AuthActivity.this);
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    }
    
    public final void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
    {
      if (AuthActivity.b(AuthActivity.this))
      {
        paramSslErrorHandler.proceed();
        AuthActivity.a(AuthActivity.this, false);
        return;
      }
      AuthActivity.this.runOnUiThread(new e(this, paramSslErrorHandler));
    }
    
    public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      if (AuthActivity.a(AuthActivity.this, paramString))
      {
        paramWebView.stopLoading();
        return true;
      }
      return super.shouldOverrideUrlLoading(paramWebView, paramString);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\auth\AuthActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */