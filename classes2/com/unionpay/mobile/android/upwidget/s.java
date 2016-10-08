package com.unionpay.mobile.android.upwidget;

import android.os.Handler;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

final class s
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  s(UPScrollView paramUPScrollView) {}
  
  public final void onGlobalLayout()
  {
    UPScrollView.a(this.a).sendMessageDelayed(UPScrollView.a(this.a).obtainMessage(), 5L);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\upwidget\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */