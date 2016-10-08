package com.alibaba.sdk.android.login.ui;

import android.os.Bundle;
import android.webkit.WebViewClient;
import com.alibaba.sdk.android.login.bridge.LoginBridge;
import com.alibaba.sdk.android.webview.BaseWebViewActivity;
import com.alibaba.sdk.android.webview.TaeWebView;

public class LoginWebViewActivity
  extends BaseWebViewActivity
{
  public String token;
  
  protected WebViewClient createWebViewClient()
  {
    return new LoginWebViewActivity.1(this);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.taeWebView.addBridgeObject("loginBridge", new LoginBridge());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\ui\LoginWebViewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */