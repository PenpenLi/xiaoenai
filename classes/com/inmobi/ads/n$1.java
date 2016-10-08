package com.inmobi.ads;

import android.support.annotation.NonNull;
import android.view.View;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class n$1
  implements ap.c
{
  n$1(n paramn) {}
  
  public void a(@NonNull List<View> paramList1, @NonNull List<View> paramList2)
  {
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      View localView = (View)paramList1.next();
      n.b localb1 = (n.b)n.a(this.a).get(localView);
      if (localb1 == null)
      {
        this.a.a(localView);
      }
      else
      {
        n.b localb2 = (n.b)n.b(this.a).get(localView);
        if ((localb2 == null) || (!localb1.a.equals(localb2.a)))
        {
          localb1.a();
          n.b(this.a).put(localView, localb1);
        }
      }
    }
    paramList1 = paramList2.iterator();
    while (paramList1.hasNext())
    {
      paramList2 = (View)paramList1.next();
      n.b(this.a).remove(paramList2);
    }
    this.a.f();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\n$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */