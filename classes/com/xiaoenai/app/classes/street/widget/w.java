package com.xiaoenai.app.classes.street.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.utils.f.a;

class w
  implements View.OnClickListener
{
  w(StreetPayBottomView paramStreetPayBottomView) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    a.c("=======click======={}", new Object[] { Boolean.valueOf(StreetPayBottomView.a(this.a)) });
    paramView = this.a;
    if (!StreetPayBottomView.a(this.a)) {}
    for (;;)
    {
      StreetPayBottomView.a(paramView, bool);
      StreetPayBottomView.b(this.a, StreetPayBottomView.a(this.a));
      if (StreetPayBottomView.b(this.a) != null) {
        StreetPayBottomView.b(this.a).a(StreetPayBottomView.a(this.a));
      }
      return;
      bool = false;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */