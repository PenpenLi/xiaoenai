package com.inmobi.rendering;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebView;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;

class RenderView$7
  extends WebChromeClient
{
  RenderView$7(RenderView paramRenderView) {}
  
  private void a()
  {
    if (RenderView.m(this.a) == null) {}
    do
    {
      return;
      if (RenderView.n(this.a) != null)
      {
        RenderView.n(this.a).onCustomViewHidden();
        RenderView.a(this.a, null);
      }
    } while ((RenderView.m(this.a) == null) || (RenderView.m(this.a).getParent() == null));
    ((ViewGroup)RenderView.m(this.a).getParent()).removeView(RenderView.m(this.a));
    RenderView.a(this.a, null);
  }
  
  private void a(View paramView, View.OnKeyListener paramOnKeyListener)
  {
    paramView.setOnKeyListener(paramOnKeyListener);
    paramView.setFocusable(true);
    paramView.setFocusableInTouchMode(true);
    paramView.requestFocus();
  }
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    paramConsoleMessage = paramConsoleMessage.message() + " -- From line " + paramConsoleMessage.lineNumber() + " of " + paramConsoleMessage.sourceId();
    Logger.a(Logger.InternalLogLevel.INTERNAL, RenderView.p(), "Console message:" + paramConsoleMessage);
    return true;
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
  {
    if (RenderView.l(this.a) != null) {
      new AlertDialog.Builder(RenderView.l(this.a)).setTitle("Location Permission").setMessage("Allow location access").setPositiveButton(17039370, new RenderView.7.7(this, paramCallback, paramString)).setNegativeButton(17039360, new RenderView.7.6(this, paramCallback, paramString)).create().show();
    }
    super.onGeolocationPermissionsShowPrompt(paramString, paramCallback);
  }
  
  public void onHideCustomView()
  {
    a();
    super.onHideCustomView();
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, RenderView.p(), "jsAlert called with: " + paramString2 + paramString1);
    if (RenderView.l(this.a) != null) {
      new AlertDialog.Builder(RenderView.l(this.a)).setMessage(paramString2).setTitle(paramString1).setPositiveButton(17039370, new RenderView.7.1(this, paramJsResult)).setCancelable(false).create().show();
    }
    for (;;)
    {
      return true;
      paramJsResult.confirm();
    }
  }
  
  public boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    if (RenderView.l(this.a) != null) {
      new AlertDialog.Builder(RenderView.l(this.a)).setMessage(paramString2).setPositiveButton(17039370, new RenderView.7.3(this, paramJsResult)).setNegativeButton(17039360, new RenderView.7.2(this, paramJsResult)).create().show();
    }
    for (;;)
    {
      return true;
      paramJsResult.confirm();
    }
  }
  
  public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    if (RenderView.l(this.a) != null)
    {
      RenderView.a(this.a, paramView);
      RenderView.a(this.a, paramCustomViewCallback);
      RenderView.m(this.a).setOnTouchListener(new RenderView.7.4(this));
      paramView = (FrameLayout)RenderView.l(this.a).findViewById(16908290);
      RenderView.m(this.a).setBackgroundColor(-16777216);
      paramView.addView(RenderView.m(this.a), new AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
      RenderView.m(this.a).requestFocus();
      a(RenderView.m(this.a), new RenderView.7.5(this));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\RenderView$7.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */