package com.xiaoenai.app.classes.street;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.street.model.Order;
import com.xiaoenai.app.classes.street.model.Product;

class bg
  implements View.OnClickListener
{
  bg(StreetDeliveryActivity paramStreetDeliveryActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.setClass(this.a, StreetProductDetailActivity.class);
    paramView.putExtra("product_id", StreetDeliveryActivity.a(this.a).getProduct().getId());
    paramView.putExtra("rush_id", StreetDeliveryActivity.a(this.a).getProduct().getRushId());
    this.a.startActivity(paramView);
    this.a.overridePendingTransition(2130968604, 2130968605);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */