package com.xiaoenai.app.classes.street;

import android.os.Bundle;
import android.widget.LinearLayout;
import com.xiaoenai.app.classes.common.a.b;
import com.xiaoenai.app.classes.common.a.c;

class cm
  implements c
{
  cm(StreetOrderAfterSaleActivity paramStreetOrderAfterSaleActivity) {}
  
  public void a(b paramb)
  {
    paramb = paramb.a();
    if (paramb != null)
    {
      if (paramb.getInt("order_size_keys") > 0) {
        StreetOrderAfterSaleActivity.a(this.a).setVisibility(8);
      }
    }
    else {
      return;
    }
    StreetOrderAfterSaleActivity.a(this.a).setVisibility(0);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\cm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */