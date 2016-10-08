package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.unionpay.mobile.android.utils.h;

final class av
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  av(UPWidget paramUPWidget) {}
  
  public final void onGlobalLayout()
  {
    h.a("uppay", "onGlobalLayout() +++");
    int i = UPWidget.a(this.a).getRootView().getHeight() - UPWidget.a(this.a).getHeight();
    if ((i <= UPWidget.l()) && (i <= UPWidget.l())) {
      this.a.k();
    }
    h.a("uppay", "onGlobalLayout() ---");
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\widgets\av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */