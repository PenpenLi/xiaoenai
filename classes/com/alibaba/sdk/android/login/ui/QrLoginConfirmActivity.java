package com.alibaba.sdk.android.login.ui;

import android.os.Bundle;
import android.webkit.WebViewClient;
import com.alibaba.sdk.android.login.bridge.LoginBridge;
import com.alibaba.sdk.android.webview.BaseWebViewActivity;
import com.alibaba.sdk.android.webview.TaeWebView;

public class QrLoginConfirmActivity
  extends BaseWebViewActivity
{
  protected WebViewClient createWebViewClient()
  {
    return new QrLoginConfirmActivity.1(this);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.taeWebView.addBridgeObject("loginBridge", new LoginBridge());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\ui\QrLoginConfirmActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */