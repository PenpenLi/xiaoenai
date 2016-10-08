package com.xiaoenai.app.classes.street.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.street.StreetProductDetailActivity;
import com.xiaoenai.app.classes.street.model.Order;
import com.xiaoenai.app.classes.street.model.Product;

class q
  implements View.OnClickListener
{
  q(i parami, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.setClass(this.a, StreetProductDetailActivity.class);
    paramView.putExtra("product_id", i.c(this.b).getProduct().getId());
    paramView.putExtra("rush_id", i.c(this.b).getProduct().getRushId());
    this.a.startActivity(paramView);
    ((Activity)this.a).overridePendingTransition(2130968604, 2130968605);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\d\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */