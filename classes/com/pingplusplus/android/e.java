package com.pingplusplus.android;

import android.app.ProgressDialog;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import org.json.JSONException;
import org.json.JSONObject;

class e
  extends WebViewClient
{
  e(PaymentActivity paramPaymentActivity) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if ((PaymentActivity.b(this.a) != null) && (PaymentActivity.b(this.a).isShowing())) {
      PaymentActivity.b(this.a).dismiss();
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    try
    {
      String str1 = PaymentActivity.c(this.a).getString("channel");
      Object localObject = PaymentActivity.c(this.a).getJSONObject("extra");
      String str2 = ((JSONObject)localObject).getString("success_url");
      localObject = ((JSONObject)localObject).getString("fail_url");
      PingppLog.d("jdPay url: " + paramString);
      PingppLog.d("jdPay successUrl: " + str2);
      PingppLog.d("jdPay fail_url : " + (String)localObject);
      if ("jdpay_wap".equals(str1))
      {
        if (paramString.indexOf(str2) < 0) {
          break label153;
        }
        PaymentActivity.b(this.a, "success");
        PingppLog.d("jdPay success");
      }
      for (;;)
      {
        return super.shouldOverrideUrlLoading(paramWebView, paramString);
        label153:
        if (paramString.indexOf((String)localObject) >= 0)
        {
          PaymentActivity.b(this.a, "fail");
          PingppLog.d("jdPay fail");
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        PaymentActivity.b(this.a, "fail");
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\pingplusplus\android\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */