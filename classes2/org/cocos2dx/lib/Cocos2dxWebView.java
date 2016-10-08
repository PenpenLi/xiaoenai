package org.cocos2dx.lib;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout.LayoutParams;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.concurrent.CountDownLatch;

public class Cocos2dxWebView
  extends WebView
{
  private static final String TAG = Cocos2dxWebViewHelper.class.getSimpleName();
  private String mJSScheme;
  private int mViewTag;
  
  public Cocos2dxWebView(Context paramContext)
  {
    this(paramContext, -1);
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  public Cocos2dxWebView(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.mViewTag = paramInt;
    this.mJSScheme = "";
    setFocusable(true);
    setFocusableInTouchMode(true);
    getSettings().setSupportZoom(false);
    getSettings().setJavaScriptEnabled(true);
    try
    {
      getClass().getMethod("removeJavascriptInterface", new Class[] { String.class }).invoke(this, new Object[] { "searchBoxJavaBridge_" });
      setWebViewClient(new Cocos2dxWebViewClient());
      setWebChromeClient(new WebChromeClient());
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.d(TAG, "This API level do not support `removeJavascriptInterface`");
      }
    }
  }
  
  public void setJavascriptInterfaceScheme(String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      this.mJSScheme = paramString;
      return;
      paramString = "";
    }
  }
  
  public void setScalesPageToFit(boolean paramBoolean)
  {
    getSettings().setSupportZoom(paramBoolean);
  }
  
  public void setWebViewRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = paramInt1;
    localLayoutParams.topMargin = paramInt2;
    localLayoutParams.width = paramInt3;
    localLayoutParams.height = paramInt4;
    localLayoutParams.gravity = 51;
    setLayoutParams(localLayoutParams);
  }
  
  class Cocos2dxWebViewClient
    extends WebViewClient
  {
    Cocos2dxWebViewClient() {}
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      ((Cocos2dxActivity)Cocos2dxWebView.this.getContext()).runOnGLThread(new Cocos2dxWebView.Cocos2dxWebViewClient.2(this, paramString));
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      ((Cocos2dxActivity)Cocos2dxWebView.this.getContext()).runOnGLThread(new Cocos2dxWebView.Cocos2dxWebViewClient.3(this, paramString2));
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      paramWebView = (Cocos2dxActivity)Cocos2dxWebView.this.getContext();
      boolean[] arrayOfBoolean;
      CountDownLatch localCountDownLatch;
      try
      {
        URI localURI = URI.create(paramString);
        if ((localURI != null) && (localURI.getScheme().equals(Cocos2dxWebView.this.mJSScheme)))
        {
          paramWebView.runOnGLThread(new Cocos2dxWebView.Cocos2dxWebViewClient.1(this, paramString));
          return true;
        }
      }
      catch (Exception localException)
      {
        Log.d(Cocos2dxWebView.TAG, "Failed to create URI from url");
        arrayOfBoolean = new boolean[1];
        arrayOfBoolean[0] = true;
        localCountDownLatch = new CountDownLatch(1);
        paramWebView.runOnGLThread(new ShouldStartLoadingWorker(localCountDownLatch, arrayOfBoolean, Cocos2dxWebView.this.mViewTag, paramString));
      }
      try
      {
        localCountDownLatch.await();
        return arrayOfBoolean[0];
      }
      catch (InterruptedException paramWebView)
      {
        for (;;)
        {
          Log.d(Cocos2dxWebView.TAG, "'shouldOverrideUrlLoading' failed");
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */