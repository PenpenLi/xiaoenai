package com.xiaoenai.app.classes.street.guide;

import android.view.View;
import android.widget.PopupWindow;
import com.xiaoenai.app.classes.street.widget.StreetOrderMenu.a;

class c
  implements StreetOrderMenu.a
{
  c(StreetLifeServiceActivity paramStreetLifeServiceActivity) {}
  
  public void a(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      StreetLifeServiceActivity.a(this.a);
    }
    for (;;)
    {
      StreetLifeServiceActivity.c(this.a).dismiss();
      return;
      if (1 == paramInt) {
        StreetLifeServiceActivity.b(this.a);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\guide\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */