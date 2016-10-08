package com.xiaoenai.app.classes.street;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.street.widget.o;

class cx
  implements View.OnClickListener
{
  cx(StreetOrderRemindActivity paramStreetOrderRemindActivity) {}
  
  public void onClick(View paramView)
  {
    if (StreetOrderRemindActivity.b(this.a) == 0) {
      StreetOrderRemindActivity.c(this.a).show();
    }
    while (1 != StreetOrderRemindActivity.b(this.a)) {
      return;
    }
    StreetOrderRemindActivity.d(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\cx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */