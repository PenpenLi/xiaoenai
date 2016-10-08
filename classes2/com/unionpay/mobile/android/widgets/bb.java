package com.unionpay.mobile.android.widgets;

import android.view.ViewGroup.MarginLayoutParams;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.ScrollView;
import com.unionpay.mobile.android.global.a;

final class bb
  implements PopupWindow.OnDismissListener
{
  bb(ba paramba) {}
  
  public final void onDismiss()
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)ba.a(this.a).getLayoutParams();
    localMarginLayoutParams.bottomMargin = a.b;
    localMarginLayoutParams.height = ba.b(this.a);
    ba.a(this.a).setLayoutParams(localMarginLayoutParams);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\widgets\bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */