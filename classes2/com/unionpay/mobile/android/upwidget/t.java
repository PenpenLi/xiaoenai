package com.unionpay.mobile.android.upwidget;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

final class t
  extends Handler
{
  t(UPScrollView paramUPScrollView) {}
  
  public final void handleMessage(Message paramMessage)
  {
    int i = this.a.getScrollY();
    if (UPScrollView.b(this.a) != i)
    {
      UPScrollView.a(this.a, i);
      UPScrollView.a(this.a).sendMessageDelayed(UPScrollView.a(this.a).obtainMessage(), 5L);
    }
    if ((UPScrollView.c(this.a) != null) && (UPScrollView.c(this.a).get() != null)) {
      ((UPScrollView.a)UPScrollView.c(this.a).get()).e(i);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\upwidget\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */