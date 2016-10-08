package com.xiaoenai.app.classes.street.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.street.StreetAfterSaleLogisticsActivity;
import com.xiaoenai.app.classes.street.model.Order;

class s
  implements View.OnClickListener
{
  s(i parami, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("street_order_id_key", i.c(this.b).getId());
    paramView.setClass(this.a, StreetAfterSaleLogisticsActivity.class);
    ((Activity)this.a).startActivityForResult(paramView, 836);
    ((Activity)this.a).overridePendingTransition(2130968606, 2130968607);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\d\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */