package com.xiaoenai.app.classes.street.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.street.model.Sku;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.f.a;

class aq
  implements View.OnClickListener
{
  aq(am paramam) {}
  
  public void onClick(View paramView)
  {
    if (am.d(this.a) == null) {
      h.c(am.e(this.a), am.f(this.a), 1500L);
    }
    while (am.a(this.a) <= 0) {
      return;
    }
    a.c(" sku = {}", new Object[] { am.d(this.a).getKey() });
    this.a.dismiss();
    am.a(this.a, false);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */