package com.xiaoenai.app.classes.street.widget;

import android.view.View;
import android.view.View.OnClickListener;

class n
  implements View.OnClickListener
{
  n(StreetOrderMenu paramStreetOrderMenu) {}
  
  public void onClick(View paramView)
  {
    if (StreetOrderMenu.a(this.a) != null)
    {
      if (paramView != StreetOrderMenu.b(this.a)) {
        break label36;
      }
      StreetOrderMenu.a(this.a).a(paramView, 0);
    }
    label36:
    while (paramView != StreetOrderMenu.c(this.a)) {
      return;
    }
    StreetOrderMenu.a(this.a).a(paramView, 1);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */