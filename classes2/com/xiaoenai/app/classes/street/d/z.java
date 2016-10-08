package com.xiaoenai.app.classes.street.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.street.StreetDeliveryActivity;

class z
  implements View.OnClickListener
{
  z(t paramt, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("street_progress_key", 2);
    paramView.putExtra("street_order_key", t.b(this.b));
    paramView.setClass(this.a, StreetDeliveryActivity.class);
    this.a.startActivity(paramView);
    ((Activity)this.a).overridePendingTransition(2130968604, 2130968605);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\d\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */