package com.xiaoenai.app.classes.street;

import android.content.res.Resources;
import android.widget.TextView;
import com.xiaoenai.app.classes.street.widget.AddressPicker.ProvincePicker.a;

class j
  implements ProvincePicker.a
{
  j(StreetAddOrEditAddressActivity paramStreetAddOrEditAddressActivity) {}
  
  public void a(String paramString)
  {
    StreetAddOrEditAddressActivity.b(this.a).setTextColor(this.a.getResources().getColor(2131493002));
    StreetAddOrEditAddressActivity.b(this.a).setText(paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */