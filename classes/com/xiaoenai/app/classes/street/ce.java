package com.xiaoenai.app.classes.street;

import android.os.Bundle;
import android.widget.Button;
import com.xiaoenai.app.classes.common.a.b;
import com.xiaoenai.app.classes.common.a.c;
import com.xiaoenai.app.classes.street.model.Order;
import com.xiaoenai.app.classes.street.model.Product;
import com.xiaoenai.app.classes.street.model.Sku;
import com.xiaoenai.app.utils.f.a;
import java.util.HashMap;

class ce
  implements c
{
  ce(StreetOrderActivity paramStreetOrderActivity) {}
  
  public void a(b paramb)
  {
    Object localObject = paramb.a();
    if (localObject != null)
    {
      paramb = ((Bundle)localObject).getString("street_order_op_key");
      if (paramb.equalsIgnoreCase("street_order_unselect_all_action"))
      {
        StreetOrderActivity.a(this.a, 0);
        StreetOrderActivity.d(this.a).setSelected(false);
        StreetOrderActivity.d(this.a).setClickable(false);
        StreetOrderActivity.b(this.a, StreetOrderActivity.e(this.a));
      }
    }
    else
    {
      return;
    }
    localObject = (Order)((Bundle)localObject).getParcelable(paramb);
    a.c("===========op: {}", new Object[] { paramb });
    int i;
    if ((((Order)localObject).getProduct().getIsRush().booleanValue()) || (((Order)localObject).getSku().getRushId() > 0))
    {
      i = ((Order)localObject).getSku().getRushPrice() * ((Order)localObject).getCount();
      if (!paramb.equalsIgnoreCase("street_order_select_action")) {
        break label240;
      }
      StreetOrderActivity.a(this.a, i + StreetOrderActivity.e(this.a));
      StreetOrderActivity.f(this.a).put(Long.valueOf(((Order)localObject).getId()), localObject);
    }
    for (;;)
    {
      StreetOrderActivity.b(this.a, StreetOrderActivity.e(this.a));
      if (StreetOrderActivity.f(this.a).size() <= 0) {
        break label278;
      }
      StreetOrderActivity.d(this.a).setSelected(true);
      StreetOrderActivity.d(this.a).setClickable(true);
      return;
      i = ((Order)localObject).getSku().getPrice() * ((Order)localObject).getCount();
      break;
      label240:
      StreetOrderActivity.a(this.a, StreetOrderActivity.e(this.a) - i);
      StreetOrderActivity.f(this.a).remove(Long.valueOf(((Order)localObject).getId()));
    }
    label278:
    StreetOrderActivity.d(this.a).setSelected(false);
    StreetOrderActivity.d(this.a).setClickable(false);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */