package com.pingplusplus.android;

import android.app.ProgressDialog;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class d
  extends WebViewClient
{
  d(PaymentActivity paramPaymentActivity) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if ((PaymentActivity.b(this.a) != null) && (PaymentActivity.b(this.a).isShowing())) {
      PaymentActivity.b(this.a).dismiss();
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    PingppLog.d("YEEPay open  url:" + paramString);
    if (paramString.indexOf("https://ok.yeepay.com/paymobile/query/pay/success?") >= 0)
    {
      PingppLog.d("YEEPay YEEPAY_WAP_SUCCESS_URL:https://ok.yeepay.com/paymobile/query/pay/success?");
      PaymentActivity.b(this.a, "success");
    }
    for (;;)
    {
      return super.shouldOverrideUrlLoading(paramWebView, paramString);
      if (paramString.indexOf("http://mobiletest.yeepay.com/paymobile/query/pay/success?") >= 0)
      {
        PingppLog.d("YEEPay YEEPAY_WAP_TEST_SUCCESS_URL:http://mobiletest.yeepay.com/paymobile/query/pay/success?");
        PaymentActivity.b(this.a, "success");
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\pingplusplus\android\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */