package com.alibaba.nb.android.trade.utils;

import com.alibaba.nb.android.trade.callback.AliTradeFailureCallback;
import com.alibaba.nb.android.trade.utils.a.a;

final class c
  implements Runnable
{
  c(AliTradeFailureCallback paramAliTradeFailureCallback, a parama) {}
  
  public final void run()
  {
    this.a.onFailure(this.b.a, this.b.c);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\utils\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */