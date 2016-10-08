package com.unionpay.mobile.android.pboctransaction.remoteapdu;

import com.unionpay.mobile.android.pboctransaction.b;
import com.unionpay.mobile.android.utils.h;
import com.unionpay.mobile.tsm.connect.IInitCallback.Stub;

final class c
  extends IInitCallback.Stub
{
  c(a parama) {}
  
  public final void initFailed()
  {
    h.a("plugin-tsm", "mInitCallback.initFailed()");
    if (this.a.a != null) {
      this.a.a.b();
    }
  }
  
  public final void initSucceed()
  {
    h.a("plugin-tsm", "mInitCallback.initSucceed()");
    if (this.a.a != null) {
      this.a.a.a();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\pboctransaction\remoteapdu\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */