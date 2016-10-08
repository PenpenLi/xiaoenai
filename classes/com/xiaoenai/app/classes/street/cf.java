package com.xiaoenai.app.classes.street;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaoenai.app.classes.common.a.b;
import com.xiaoenai.app.classes.common.a.c;
import com.xiaoenai.app.classes.street.a.j;
import com.xiaoenai.app.utils.f.a;

class cf
  implements c
{
  cf(StreetOrderActivity paramStreetOrderActivity) {}
  
  public void a(b paramb)
  {
    paramb = paramb.a();
    int k;
    if (paramb != null)
    {
      int j = paramb.getInt("order_size_keys");
      k = StreetOrderActivity.g(this.a).getCurrentItem();
      a.c("orderList type= {} count = {}", new Object[] { Integer.valueOf(k), Integer.valueOf(j) });
      int i = j;
      if (j == 0) {
        i = StreetOrderActivity.h(this.a).c(k);
      }
      a.c("orderList type= {} orderDataCount= {}", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
      if (i <= 0) {
        break label142;
      }
      StreetOrderActivity.i(this.a).setVisibility(8);
      if (k == 1) {
        StreetOrderActivity.j(this.a).setVisibility(0);
      }
    }
    else
    {
      return;
    }
    StreetOrderActivity.j(this.a).setVisibility(8);
    return;
    label142:
    if (k == 5)
    {
      StreetOrderActivity.k(this.a).setImageResource(2130838971);
      StreetOrderActivity.l(this.a).setText(2131101339);
    }
    for (;;)
    {
      StreetOrderActivity.i(this.a).setVisibility(0);
      if (k != 1) {
        break;
      }
      StreetOrderActivity.j(this.a).setVisibility(8);
      return;
      StreetOrderActivity.k(this.a).setImageResource(2130838951);
      StreetOrderActivity.l(this.a).setText(2131101411);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */