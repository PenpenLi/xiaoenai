package com.xiaoenai.app.classes.street;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.xiaoenai.app.classes.common.dialog.q;
import com.xiaoenai.app.classes.street.model.DeliveryCompany;

class ad
  implements View.OnClickListener
{
  ad(StreetAfterSaleLogisticsActivity paramStreetAfterSaleLogisticsActivity) {}
  
  public void onClick(View paramView)
  {
    if (StreetAfterSaleLogisticsActivity.d(this.a) == -1) {
      StreetAfterSaleLogisticsActivity.a(this.a, StreetAfterSaleLogisticsActivity.c(this.a).a());
    }
    StreetAfterSaleLogisticsActivity.f(this.a).a.setText(StreetAfterSaleLogisticsActivity.e(this.a)[StreetAfterSaleLogisticsActivity.d(this.a)].getName());
    if (StreetAfterSaleLogisticsActivity.d(this.a) == StreetAfterSaleLogisticsActivity.e(this.a).length - 1)
    {
      StreetAfterSaleLogisticsActivity.f(this.a).c.setVisibility(8);
      StreetAfterSaleLogisticsActivity.f(this.a).b.setVisibility(8);
    }
    for (;;)
    {
      StreetAfterSaleLogisticsActivity.c(this.a).dismiss();
      return;
      StreetAfterSaleLogisticsActivity.f(this.a).c.setVisibility(0);
      StreetAfterSaleLogisticsActivity.f(this.a).b.setVisibility(0);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */