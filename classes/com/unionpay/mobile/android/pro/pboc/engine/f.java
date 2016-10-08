package com.unionpay.mobile.android.pro.pboc.engine;

import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.utils.h;

final class f
  implements com.unionpay.mobile.android.pboctransaction.b
{
  f(b paramb) {}
  
  public final void a()
  {
    b.a(this.a, 8);
  }
  
  public final void b()
  {
    h.c("UPCardEngine", "mSE init failed");
    Message localMessage = b.a(this.a).obtainMessage(8, null);
    b.a(this.a).sendMessage(localMessage);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\unionpay\mobile\android\pro\pboc\engine\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */