package com.unionpay.mobile.android.nocard.views;

import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.views.order.l;

final class ap
  implements Handler.Callback
{
  ap(ao paramao) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    if ((this.a.a.aF == l.a.intValue()) && (!this.a.a.E))
    {
      if (TextUtils.isEmpty(this.a.a.p)) {
        break label66;
      }
      this.a.a(13, this.a.o);
    }
    for (;;)
    {
      return true;
      label66:
      if (this.a.a.au) {
        ao.a(this.a);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\nocard\views\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */