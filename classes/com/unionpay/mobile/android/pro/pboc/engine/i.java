package com.unionpay.mobile.android.pro.pboc.engine;

import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.pboctransaction.d;
import com.unionpay.mobile.android.utils.h;

final class i
  implements Runnable
{
  i(b paramb) {}
  
  public final void run()
  {
    synchronized (this.a)
    {
      h.c("UPCardEngine", " ic_return : 4");
      Object localObject1 = b.d(this.a).b();
      if (b.a(this.a) != null)
      {
        localObject1 = b.a(this.a).obtainMessage(4, localObject1);
        b.a(this.a).sendMessage((Message)localObject1);
      }
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\unionpay\mobile\android\pro\pboc\engine\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */