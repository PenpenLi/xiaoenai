package com.xiaoenai.app.classes.street;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class ca
  implements View.OnClickListener
{
  ca(StreetOrderActivity paramStreetOrderActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("street_address_is_selector_mode_key", false);
    paramView.setClass(this.a, StreetAddressManagerActivity.class);
    this.a.startActivity(paramView);
    this.a.overridePendingTransition(2130968604, 2130968605);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */