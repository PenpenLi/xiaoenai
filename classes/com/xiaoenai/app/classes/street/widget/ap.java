package com.xiaoenai.app.classes.street.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.xiaoenai.app.classes.street.model.ProductInfo;
import com.xiaoenai.app.classes.street.model.Sku;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.f.a;

class ap
  implements View.OnClickListener
{
  ap(am paramam) {}
  
  public void onClick(View paramView)
  {
    if (am.d(this.a) == null)
    {
      h.c(am.e(this.a), am.f(this.a), 1500L);
      return;
    }
    if (am.g(this.a).getOrderLimit() > 0)
    {
      if (am.g(this.a).getOrderLimit() < am.d(this.a).getQuantity())
      {
        if (am.a(this.a) + 1 <= am.g(this.a).getOrderLimit())
        {
          am.c(this.a).setText(String.valueOf(am.h(this.a)));
          a.c("================mProduct.getOrderLimit() {} {}", new Object[] { Integer.valueOf(am.g(this.a).getOrderLimit()), Integer.valueOf(am.a(this.a)) });
          return;
        }
        h.c(am.e(this.a), String.format(this.a.getContext().getResources().getString(2131101466), new Object[] { Integer.valueOf(am.g(this.a).getOrderLimit()) }), 1500L);
        return;
      }
      if (am.a(this.a) + 1 <= am.d(this.a).getQuantity())
      {
        am.c(this.a).setText(String.valueOf(am.h(this.a)));
        a.c("================mSelectSku.getQuantity() {} {}", new Object[] { Integer.valueOf(am.d(this.a).getQuantity()), Integer.valueOf(am.a(this.a)) });
        return;
      }
      h.c(am.e(this.a), this.a.getContext().getResources().getString(2131101469), 1500L);
      return;
    }
    if (am.a(this.a) + 1 <= am.d(this.a).getQuantity())
    {
      am.c(this.a).setText(String.valueOf(am.h(this.a)));
      a.c("================mSelectSku.getQuantity() {} {}", new Object[] { Integer.valueOf(am.d(this.a).getQuantity()), Integer.valueOf(am.a(this.a)) });
      return;
    }
    h.c(am.e(this.a), this.a.getContext().getResources().getString(2131101469), 1500L);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */