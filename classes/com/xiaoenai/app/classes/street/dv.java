package com.xiaoenai.app.classes.street;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.c.a;

class dv
  implements View.OnClickListener
{
  dv(StreetServiceChooseActivity paramStreetServiceChooseActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("street_service_type_key", a.c);
    paramView.putExtra("street_order_id_key", StreetServiceChooseActivity.a(this.a));
    paramView.setClass(this.a, StreetCustomerServiceActivity.class);
    this.a.startActivityForResult(paramView, 836);
    this.a.overridePendingTransition(2130968604, 2130968605);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\dv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */