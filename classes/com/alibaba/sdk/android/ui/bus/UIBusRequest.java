package com.alibaba.sdk.android.ui.bus;

import android.app.Activity;
import android.webkit.WebView;
import com.alibaba.sdk.android.webview.proxy.WebViewProxy;
import java.util.Map;

public class UIBusRequest
{
  public Activity activity;
  public Map<String, Object> extraParams;
  public String[] ignoreList;
  public String[] preferredHandlers;
  public int scenario;
  public String scope;
  public String url;
  public WebView webView;
  public WebViewProxy webViewProxy;
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\bus\UIBusRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */