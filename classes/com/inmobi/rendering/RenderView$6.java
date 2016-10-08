package com.inmobi.rendering;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.inmobi.commons.a.a;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.rendering.mraid.MraidMediaProcessor;
import java.net.URISyntaxException;
import java.util.List;

class RenderView$6
  extends WebViewClient
{
  RenderView$6(RenderView paramRenderView) {}
  
  public void onLoadResource(WebView paramWebView, String paramString)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, RenderView.p(), "Resource loading:" + paramString);
    if (paramString != null)
    {
      paramWebView = this.a.getUrl();
      if ((paramString.contains("/mraid.js")) && (!paramWebView.equals("about:blank")) && (!paramWebView.startsWith("file:")))
      {
        if (!RenderView.i(this.a).contains(paramWebView)) {
          RenderView.i(this.a).add(paramWebView);
        }
        if (!RenderView.j(this.a))
        {
          RenderView.b(this.a, true);
          Logger.a(Logger.InternalLogLevel.INTERNAL, RenderView.p(), "Injecting MRAID javascript for two piece creatives.");
          this.a.b(this.a.getMraidJsString());
        }
      }
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, RenderView.p(), "Page load finished:" + paramString);
    if ((RenderView.i(this.a).contains(paramString)) && (!RenderView.j(this.a)))
    {
      RenderView.b(this.a, true);
      Logger.a(Logger.InternalLogLevel.INTERNAL, RenderView.p(), "Injecting MRAID javascript for two piece creatives.");
      this.a.b(this.a.getMraidJsString());
    }
    if (RenderView.RenderViewState.LOADING == RenderView.e(this.a))
    {
      RenderView.d(this.a).c(this.a);
      RenderView.k(this.a);
      if (RenderView.c(this.a) != null) {
        this.a.setAndUpdateViewState(RenderView.RenderViewState.EXPANDED);
      }
    }
    else
    {
      return;
    }
    this.a.setAndUpdateViewState(RenderView.RenderViewState.DEFAULT);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, RenderView.p(), "Page load started:" + paramString);
    RenderView.b(this.a, false);
    this.a.setAndUpdateViewState(RenderView.RenderViewState.LOADING);
  }
  
  @TargetApi(22)
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, RenderView.p(), "Loading error. Error code:" + paramInt + " Error msg:" + paramString1 + " Failing url:" + paramString2);
  }
  
  @TargetApi(23)
  public void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, RenderView.p(), "Loading error. Error code:" + paramWebResourceError.getErrorCode() + " Error msg:" + paramWebResourceError.getDescription() + " Failing url:" + paramWebResourceRequest.getUrl());
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, RenderView.p(), "SSL error received. Error code:" + paramSslError.getPrimaryError());
    paramSslErrorHandler.cancel();
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, RenderView.p(), "Placement type: " + RenderView.b(this.a).a() + " url:" + paramString);
    if ((!RenderView.f(this.a)) && (!"about:blank".equals(paramString))) {
      RenderView.g(this.a);
    }
    if (RenderingProperties.PlacementType.FULL_SCREEN == RenderView.b(this.a).a())
    {
      if ((RenderView.f(this.a)) && (paramString.startsWith("http")) && (!paramString.contains("play.google.com")) && (!paramString.contains("market.android.com")) && (!paramString.contains("market%3A%2F%2F")))
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, RenderView.p(), "Override URL loading (returned false): " + paramString);
        if (RenderView.h(this.a) != null) {
          RenderView.h(this.a).c();
        }
        return false;
      }
      Logger.a(Logger.InternalLogLevel.INTERNAL, RenderView.p(), "Override URL loading (returned true): " + paramString);
      try
      {
        paramWebView = Intent.parseUri(paramString, 0);
        a.a(this.a.getRenderViewContext(), paramWebView);
        this.a.getListener().g(this.a);
        return true;
      }
      catch (URISyntaxException paramWebView)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, RenderView.p(), paramWebView.getMessage());
        return true;
      }
      catch (ActivityNotFoundException paramWebView)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, RenderView.p(), "No app can handle the URI (" + paramString + ")");
        return true;
      }
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, RenderView.p(), "Override URL loading (returned true): " + paramString);
    try
    {
      paramWebView = Intent.parseUri(paramString, 0);
      a.a(this.a.getRenderViewContext(), paramWebView);
      this.a.getListener().g(this.a);
      return true;
    }
    catch (URISyntaxException paramWebView)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, RenderView.p(), paramWebView.getMessage());
      return true;
    }
    catch (ActivityNotFoundException paramWebView)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, RenderView.p(), "No app can handle the URI (" + paramString + ")");
    }
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\RenderView$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */