package com.unionpay.mobile.android.pro.views;

import com.unionpay.mobile.android.model.c;
import com.unionpay.mobile.android.utils.h;
import java.util.ArrayList;
import java.util.List;

final class b
  implements com.unionpay.mobile.android.pro.pboc.engine.a
{
  b(a parama) {}
  
  public final void a(ArrayList<c> paramArrayList)
  {
    h.a("uppay", "deviceReady +++");
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if (this.a.q == null) {
        this.a.q = new ArrayList(paramArrayList.size());
      }
      this.a.q.addAll(paramArrayList);
    }
    a.a(this.a);
    h.a("uppay", "deviceReady ---");
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\pro\views\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */