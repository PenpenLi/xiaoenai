package com.xiaoenai.app.classes.street;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

class dz
  extends WebChromeClient
{
  dz(StreetWebPageActivity paramStreetWebPageActivity) {}
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    super.onProgressChanged(paramWebView, paramInt);
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    super.onReceivedTitle(paramWebView, paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\dz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */