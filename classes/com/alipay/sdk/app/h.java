package com.alipay.sdk.app;

import android.webkit.SslErrorHandler;
import com.alipay.sdk.widget.d;

final class h
  implements Runnable
{
  h(H5PayActivity.a parama, SslErrorHandler paramSslErrorHandler) {}
  
  public final void run()
  {
    d.a(this.b.a, "安全警告", "由于您的设备缺少根证书，将无法校验该访问站点的安全性，可能存在风险，请选择是否继续？", "继续", new i(this), "退出", new j(this));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\app\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */