package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.ImageView;

final class w
  implements View.OnFocusChangeListener
{
  w(t paramt) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      if ((t.b(this.a)) && (t.a(this.a) != null)) {
        t.a(this.a).setVisibility(0);
      }
    }
    for (;;)
    {
      if (t.d(this.a) != null) {
        t.d(this.a).a(paramBoolean);
      }
      if (t.e(this.a) != null) {
        t.e(this.a).a(paramBoolean);
      }
      paramView = this.a;
      t.g();
      this.a.invalidate();
      return;
      if ((t.b(this.a)) && (t.a(this.a) != null)) {
        t.a(this.a).setVisibility(8);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\widgets\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */