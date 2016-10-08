package com.pingplusplus.android;

import android.content.Context;
import android.webkit.JavascriptInterface;

public class g
{
  Context a;
  
  g(PaymentActivity paramPaymentActivity, Context paramContext)
  {
    this.a = paramContext;
  }
  
  @JavascriptInterface
  public void testmodeResult(String paramString)
  {
    if (paramString == null)
    {
      PaymentActivity.a(this.b, "fail", "unknown_error");
      return;
    }
    if (paramString.equals("success"))
    {
      PaymentActivity.a(this.b, "success");
      return;
    }
    if (paramString.equals("cancel"))
    {
      PaymentActivity.a(this.b, "cancel", "user_cancelled");
      return;
    }
    if (paramString.equals("fail"))
    {
      PaymentActivity.a(this.b, "fail", "channel_returns_fail");
      return;
    }
    if (paramString.equals("error"))
    {
      PaymentActivity.a(this.b, "fail", "testmode_notify_failed");
      return;
    }
    PaymentActivity.a(this.b, "fail", "unknown_error");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\pingplusplus\android\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */