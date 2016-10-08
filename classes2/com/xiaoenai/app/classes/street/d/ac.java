package com.xiaoenai.app.classes.street.d;

import android.widget.TextView;
import com.xiaoenai.app.classes.street.model.Order;
import com.xiaoenai.app.classes.street.widget.StreetCountdownView.a;
import com.xiaoenai.app.classes.street.widget.StreetOrderListItemLayout.a;

class ac
  implements StreetCountdownView.a
{
  ac(t paramt) {}
  
  public void a()
  {
    t.b(this.a).setState(4);
    t.a(this.a).c.setText(t.c(this.a, t.b(this.a).getState()));
    t.a(this.a).g.setVisibility(8);
    t.d(this.a, t.b(this.a).getState());
    t.e(this.a, t.b(this.a).getState());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\d\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */