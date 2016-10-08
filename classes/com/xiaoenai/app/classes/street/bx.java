package com.xiaoenai.app.classes.street;

import com.xiaoenai.app.classes.street.model.Order;
import com.xiaoenai.app.classes.street.model.Product;
import com.xiaoenai.app.classes.street.model.Sku;
import com.xiaoenai.app.classes.street.pay.a.a;
import com.xiaoenai.app.classes.street.pay.a.g;
import com.xiaoenai.app.classes.street.widget.o.a;

class bx
  implements o.a
{
  bx(bw parambw) {}
  
  public void a(String paramString)
  {
    if (StreetOrderActivity.a(this.a.a) == null) {
      return;
    }
    if ((StreetOrderActivity.a(this.a.a).getProduct().getIsRush().booleanValue()) || (StreetOrderActivity.a(this.a.a).getSku().getRushId() > 0)) {}
    for (int i = StreetOrderActivity.a(this.a.a).getSku().getRushPrice() * StreetOrderActivity.a(this.a.a).getCount();; i = StreetOrderActivity.a(this.a.a).getSku().getPrice() * StreetOrderActivity.a(this.a.a).getCount())
    {
      StreetOrderActivity.b(this.a.a).a(new g(this.a.a, StreetOrderActivity.a(this.a.a).getId(), paramString, i));
      StreetOrderActivity.c(this.a.a).a();
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */