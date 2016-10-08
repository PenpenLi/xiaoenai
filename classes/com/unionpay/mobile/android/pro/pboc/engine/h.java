package com.unionpay.mobile.android.pro.pboc.engine;

import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.pboctransaction.d;

final class h
  implements Runnable
{
  h(b paramb) {}
  
  public final void run()
  {
    synchronized (this.a)
    {
      com.unionpay.mobile.android.utils.h.c("UPCardEngine", " cmcc_return : 2");
      Object localObject1 = b.c(this.a).b();
      if (b.a(this.a) != null)
      {
        localObject1 = b.a(this.a).obtainMessage(2, localObject1);
        b.a(this.a).sendMessage((Message)localObject1);
      }
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\unionpay\mobile\android\pro\pboc\engine\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */