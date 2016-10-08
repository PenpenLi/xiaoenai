package com.alipay.sdk.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.SslErrorHandler;

final class e
  implements DialogInterface.OnClickListener
{
  e(c paramc) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.cancel();
    H5AuthActivity.a(this.a.b.a, false);
    l.a = l.a();
    this.a.b.a.finish();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\app\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */