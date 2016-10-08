package com.xiaoenai.app.classes.street.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.street.StreetFeedbackActivity;
import com.xiaoenai.app.classes.street.model.Order;

class bb
  implements View.OnClickListener
{
  bb(ba paramba, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("street_order_id_key", ba.a(this.b).getId());
    paramView.setClass(this.a, StreetFeedbackActivity.class);
    this.a.startActivity(paramView);
    ((Activity)this.a).overridePendingTransition(2130968604, 2130968605);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\d\bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */