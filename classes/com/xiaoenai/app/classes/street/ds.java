package com.xiaoenai.app.classes.street;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.xiaoenai.app.classes.street.model.Contact;
import com.xiaoenai.app.classes.street.pay.a.a;
import com.xiaoenai.app.classes.street.pay.a.m;
import com.xiaoenai.app.classes.street.widget.StreetBuyProductView;
import com.xiaoenai.app.utils.as;

class ds
  implements View.OnClickListener
{
  ds(StreetProductOrderActivity paramStreetProductOrderActivity) {}
  
  public void onClick(View paramView)
  {
    if (StreetProductOrderActivity.b(this.a).getVisibility() != 0) {
      as.b(2131101400);
    }
    do
    {
      do
      {
        return;
        StreetProductOrderActivity.a(this.a, StreetProductOrderActivity.c(this.a).getBuyInfos());
      } while (StreetProductOrderActivity.d(this.a) == null);
      if (StreetProductOrderActivity.e(this.a).b() == null)
      {
        paramView = StreetProductOrderActivity.i(this.a);
        int j = StreetProductOrderActivity.f(this.a).getId();
        if (StreetProductOrderActivity.g(this.a)) {}
        for (int i = 1;; i = 0)
        {
          paramView.a(j, i, StreetProductOrderActivity.d(this.a), StreetProductOrderActivity.h(this.a));
          StreetProductOrderActivity.j(this.a).a();
          return;
        }
      }
    } while ((StreetProductOrderActivity.k(this.a).b() instanceof m));
    StreetProductOrderActivity.l(this.a).a();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\ds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */