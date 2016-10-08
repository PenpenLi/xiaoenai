package com.xiaoenai.app.classes.street.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.utils.f.a;

class q
  implements View.OnClickListener
{
  q(o paramo) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    a.c("BUTTON_ZHIFUBAO {}", new Object[] { o.a(this.a) });
    if (o.a(this.a) != null) {
      o.a(this.a).a("alipay");
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */