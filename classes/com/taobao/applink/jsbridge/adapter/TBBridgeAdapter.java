package com.taobao.applink.jsbridge.adapter;

import android.webkit.WebView;

public abstract interface TBBridgeAdapter
{
  public abstract void callHandler(WebView paramWebView, String paramString1, String paramString2, TBBridgeCallBackFunction paramTBBridgeCallBackFunction);
  
  public abstract void flushMessageQueue(WebView paramWebView);
  
  public abstract void handlerReturnData(WebView paramWebView, String paramString);
  
  public abstract void initMessageQueue(WebView paramWebView);
  
  public abstract void registerHandler(WebView paramWebView, String paramString, TBBridgeHandler paramTBBridgeHandler);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\applink\jsbridge\adapter\TBBridgeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */