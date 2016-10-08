package com.xiaoenai.app.classes.street.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.xiaoenai.app.utils.f.a;

class ao
  implements View.OnClickListener
{
  ao(am paramam) {}
  
  public void onClick(View paramView)
  {
    if (am.a(this.a) - 1 > 0)
    {
      am.c(this.a).setText(String.valueOf(am.b(this.a)));
      a.c("================ctl {}", new Object[] { Integer.valueOf(am.a(this.a)) });
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */