package com.alibaba.sdk.android.ui.bus.handler;

import android.app.Activity;
import android.net.Uri;
import android.webkit.WebView;
import com.alibaba.sdk.android.ui.bus.UIBusContext;
import com.alibaba.sdk.android.webview.proxy.WebViewProxy;
import java.util.Map;

public class HandlerContext
  extends UIBusContext
{
  public Activity activity;
  public WebView webView;
  public WebViewProxy webViewProxy;
  
  public HandlerContext(int paramInt, Uri paramUri, Map<String, Object> paramMap)
  {
    super(paramInt, paramUri, paramMap);
  }
  
  public HandlerContext(int paramInt, String paramString, Map<String, Object> paramMap)
  {
    super(paramInt, paramString, paramMap);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\bus\handler\HandlerContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */