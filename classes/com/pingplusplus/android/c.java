package com.pingplusplus.android;

import android.app.ProgressDialog;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class c
  extends WebViewClient
{
  c(PaymentActivity paramPaymentActivity) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if ((PaymentActivity.b(this.a) != null) && (PaymentActivity.b(this.a).isShowing())) {
      PaymentActivity.b(this.a).dismiss();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\pingplusplus\android\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */