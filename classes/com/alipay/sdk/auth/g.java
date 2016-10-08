package com.alipay.sdk.auth;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.SslErrorHandler;

final class g
  implements DialogInterface.OnClickListener
{
  g(e parame) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.cancel();
    AuthActivity.a(this.a.b.a, false);
    paramDialogInterface = AuthActivity.c(this.a.b.a) + "?resultCode=150";
    h.a(this.a.b.a, paramDialogInterface);
    this.a.b.a.finish();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\auth\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */