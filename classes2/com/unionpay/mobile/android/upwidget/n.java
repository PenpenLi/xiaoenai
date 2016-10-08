package com.unionpay.mobile.android.upwidget;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Iterator;

final class n
  implements View.OnClickListener
{
  n(h paramh) {}
  
  public final void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    if (i == h.a(this.a)) {
      return;
    }
    h.c(this.a, i);
    if ((h.l(this.a)) && (!TextUtils.isEmpty(h.m(this.a)[i].d)))
    {
      paramView.setTag(h.m(this.a)[i].d);
      Iterator localIterator = h.n(this.a).iterator();
      while (localIterator.hasNext()) {
        ((View.OnClickListener)localIterator.next()).onClick(paramView);
      }
      h.a(this.a, (LinearLayout)h.m(this.a)[i].c, "正在查询。。。");
      h.o(this.a);
    }
    paramView.setTag(Integer.valueOf(i));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\upwidget\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */