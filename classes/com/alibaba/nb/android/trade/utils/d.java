package com.alibaba.nb.android.trade.utils;

import com.alibaba.nb.android.trade.callback.AliTradeFailureCallback;

final class d
  implements Runnable
{
  d(AliTradeFailureCallback paramAliTradeFailureCallback, int paramInt, String paramString) {}
  
  public final void run()
  {
    this.a.onFailure(this.b, this.c);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\utils\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */