package com.unionpay.mobile.android.pro.views;

import android.os.Bundle;
import android.os.Handler;
import com.unionpay.mobile.android.model.c;
import java.util.HashMap;

final class g
  implements Runnable
{
  g(e parame, com.unionpay.mobile.android.pro.pboc.engine.b paramb, c paramc, String paramString, HashMap paramHashMap) {}
  
  public final void run()
  {
    Bundle localBundle = this.a.a(this.b, this.c, e.h(this.e).k, this.d, e.i(this.e).i);
    Handler localHandler1 = e.j(this.e);
    Handler localHandler2 = e.j(this.e);
    if (localBundle != null) {}
    for (;;)
    {
      localHandler1.sendMessage(localHandler2.obtainMessage(0, localBundle));
      return;
      localBundle = null;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\pro\views\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */