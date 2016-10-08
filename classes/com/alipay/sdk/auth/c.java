package com.alipay.sdk.auth;

import android.webkit.WebView;

final class c
  implements Runnable
{
  c(AuthActivity paramAuthActivity, String paramString) {}
  
  public final void run()
  {
    try
    {
      AuthActivity.h(this.b).loadUrl("javascript:" + this.a);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\auth\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */