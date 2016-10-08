package com.unionpay.mobile.android.pro.pboc.engine;

import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.pboctransaction.d;
import com.unionpay.mobile.android.utils.h;

final class g
  implements Runnable
{
  g(b paramb) {}
  
  public final void run()
  {
    h.c("UPCardEngine", " sd_return : 1");
    Object localObject = b.b(this.a).b();
    if (b.a(this.a) != null)
    {
      localObject = b.a(this.a).obtainMessage(1, localObject);
      b.a(this.a).sendMessage((Message)localObject);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\unionpay\mobile\android\pro\pboc\engine\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */