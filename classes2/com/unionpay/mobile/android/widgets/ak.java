package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;

final class ak
  implements View.OnClickListener
{
  ak(ai paramai) {}
  
  public final void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    ai.a(this.a, i, 0);
    if (ai.a(this.a) != null) {
      ai.a(this.a).dismiss();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\widgets\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */