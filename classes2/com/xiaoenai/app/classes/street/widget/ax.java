package com.xiaoenai.app.classes.street.widget;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

class ax
  implements View.OnClickListener
{
  ax(StreetProductSkuView.b paramb) {}
  
  public void onClick(View paramView)
  {
    boolean bool;
    if ((StreetProductSkuView.b.a(this.a) != null) && (StreetProductSkuView.b.b(this.a)))
    {
      paramView = this.a;
      if (StreetProductSkuView.b.c(this.a)) {
        break label121;
      }
      bool = true;
      StreetProductSkuView.b.a(paramView, bool);
      if (!StreetProductSkuView.b.c(this.a)) {
        break label126;
      }
      StreetProductSkuView.b.d(this.a).setBackgroundResource(2131493038);
      StreetProductSkuView.b.e(this.a).setTextColor(this.a.getResources().getColor(2131493206));
    }
    for (;;)
    {
      StreetProductSkuView.b.a(this.a).a(StreetProductSkuView.b.c(this.a), StreetProductSkuView.b.f(this.a), StreetProductSkuView.b.g(this.a));
      return;
      label121:
      bool = false;
      break;
      label126:
      StreetProductSkuView.b.d(this.a).setBackgroundResource(2130838715);
      StreetProductSkuView.b.e(this.a).setTextColor(this.a.getResources().getColor(2131493028));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */