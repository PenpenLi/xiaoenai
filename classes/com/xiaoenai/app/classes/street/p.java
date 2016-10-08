package com.xiaoenai.app.classes.street;

import android.widget.TextView;
import com.xiaoenai.app.classes.street.widget.AddressPicker.ProvincePicker;
import com.xiaoenai.app.utils.f.a;

class p
  implements Runnable
{
  p(StreetAddOrEditAddressActivity paramStreetAddOrEditAddressActivity) {}
  
  public void run()
  {
    a.c(StreetAddOrEditAddressActivity.b(this.a).getText().toString(), new Object[0]);
    StreetAddOrEditAddressActivity.g(this.a).a();
    StreetAddOrEditAddressActivity.g(this.a).setVisibility(0);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */