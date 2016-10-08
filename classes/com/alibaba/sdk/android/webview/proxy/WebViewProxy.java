package com.alibaba.sdk.android.webview.proxy;

public abstract interface WebViewProxy
{
  public abstract String execJS(String paramString);
  
  public abstract String getCookie(String paramString);
  
  public abstract String getUrl();
  
  public abstract String getUserAgent();
  
  public abstract void loadUrl(String paramString);
  
  public abstract void reload();
  
  public abstract void setCookie(String paramString1, String paramString2);
  
  public abstract void setUserAgent(String paramString);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\webview\proxy\WebViewProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */