package com.unionpay.mobile.android.upwidget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.Iterator;

final class i
  implements AdapterView.OnItemClickListener
{
  i(h paramh) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView.setTag(Integer.valueOf(h.a(this.a)));
    if (h.b(this.a) != h.c(this.a))
    {
      localObject = h.d(this.a).get(h.b(this.a));
      if ((localObject instanceof c)) {
        ((c)localObject).a(-1);
      }
    }
    Object localObject = h.d(this.a).get(h.a(this.a));
    if ((localObject instanceof c)) {
      ((c)localObject).a(paramInt);
    }
    h.a(this.a, h.a(this.a));
    h.b(this.a, paramInt);
    localObject = h.e(this.a).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((AdapterView.OnItemClickListener)((Iterator)localObject).next()).onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\upwidget\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */