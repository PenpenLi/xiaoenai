package com.pingplusplus.android;

import android.webkit.JavascriptInterface;

public class h
{
  public h(PaymentActivity paramPaymentActivity) {}
  
  @JavascriptInterface
  public void setResult(String paramString)
  {
    if (paramString == null)
    {
      PaymentActivity.a(this.a, "fail", "unknown_error");
      return;
    }
    if (paramString.equals("success"))
    {
      PaymentActivity.a(this.a, "success");
      return;
    }
    PaymentActivity.a(this.a, "fail", "unknown_error");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\pingplusplus\android\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */