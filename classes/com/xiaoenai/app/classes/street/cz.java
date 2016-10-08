package com.xiaoenai.app.classes.street;

import com.xiaoenai.app.classes.street.model.Order;
import com.xiaoenai.app.classes.street.model.Product;
import com.xiaoenai.app.classes.street.model.Sku;
import com.xiaoenai.app.classes.street.pay.a.g;
import com.xiaoenai.app.classes.street.widget.o.a;

class cz
  implements o.a
{
  cz(StreetOrderRemindActivity paramStreetOrderRemindActivity) {}
  
  public void a(String paramString)
  {
    if (StreetOrderRemindActivity.e(this.a) == 0)
    {
      com.xiaoenai.app.utils.f.a.c("name = {} {}", new Object[] { paramString, StreetOrderRemindActivity.f(this.a) });
      if (StreetOrderRemindActivity.f(this.a) != null) {}
    }
    while (StreetOrderRemindActivity.e(this.a) != 1)
    {
      return;
      if ((StreetOrderRemindActivity.f(this.a).getProduct().getIsRush().booleanValue()) || (StreetOrderRemindActivity.f(this.a).getSku().getRushId() > 0)) {}
      for (i = StreetOrderRemindActivity.f(this.a).getSku().getRushPrice() * StreetOrderRemindActivity.f(this.a).getCount();; i = StreetOrderRemindActivity.f(this.a).getSku().getPrice() * StreetOrderRemindActivity.f(this.a).getCount())
      {
        StreetOrderRemindActivity.g(this.a).a(new g(this.a, StreetOrderRemindActivity.f(this.a).getId(), paramString, i));
        StreetOrderRemindActivity.h(this.a).a();
        return;
      }
    }
    int i = (int)StreetOrderRemindActivity.i(this.a);
    StreetOrderRemindActivity.k(this.a).a(new g(this.a, StreetOrderRemindActivity.j(this.a), paramString, i));
    StreetOrderRemindActivity.l(this.a).a();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\cz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */