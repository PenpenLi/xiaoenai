package com.alipay.sdk.app;

import android.webkit.SslErrorHandler;

final class c
  implements Runnable
{
  c(H5AuthActivity.a parama, SslErrorHandler paramSslErrorHandler) {}
  
  public final void run()
  {
    com.alipay.sdk.widget.d.a(this.b.a, "安全警告", "由于您的设备缺少根证书，将无法校验该访问站点的安全性，可能存在风险，请选择是否继续？", "继续", new d(this), "退出", new e(this));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\app\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */