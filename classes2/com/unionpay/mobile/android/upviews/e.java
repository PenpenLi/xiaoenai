package com.unionpay.mobile.android.upviews;

import android.os.Handler;
import java.util.Timer;
import java.util.TimerTask;

final class e
  extends TimerTask
{
  e(d.d paramd) {}
  
  public final void run()
  {
    if (!d.b(this.a.a)) {
      d.a(this.a.a).sendEmptyMessage(3);
    }
    d.c(this.a.a).cancel();
    d.c(this.a.a).purge();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\upviews\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */