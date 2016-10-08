package com.xiaoenai.app.classes.street;

import com.xiaoenai.app.classes.street.model.Order;
import com.xiaoenai.app.classes.street.model.Product;
import com.xiaoenai.app.classes.street.model.Sku;
import com.xiaoenai.app.classes.street.pay.a.a;
import com.xiaoenai.app.classes.street.pay.a.g;
import com.xiaoenai.app.classes.street.widget.o.a;

class cq
  implements o.a
{
  cq(cp paramcp) {}
  
  public void a(String paramString)
  {
    if (StreetOrderDetailActivity.a(this.a.a) == null) {
      return;
    }
    if ((StreetOrderDetailActivity.a(this.a.a).getProduct().getIsRush().booleanValue()) || (StreetOrderDetailActivity.a(this.a.a).getSku().getRushId() > 0)) {}
    for (int i = StreetOrderDetailActivity.a(this.a.a).getSku().getRushPrice() * StreetOrderDetailActivity.a(this.a.a).getCount();; i = StreetOrderDetailActivity.a(this.a.a).getSku().getPrice() * StreetOrderDetailActivity.a(this.a.a).getCount())
    {
      StreetOrderDetailActivity.b(this.a.a).a(new g(this.a.a, StreetOrderDetailActivity.a(this.a.a).getId(), paramString, i));
      StreetOrderDetailActivity.c(this.a.a).a();
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */