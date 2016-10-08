package com.xiaoenai.app.classes.street.widget;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

class az
  implements View.OnClickListener
{
  az(StreetProductTypeItemView paramStreetProductTypeItemView) {}
  
  public void onClick(View paramView)
  {
    boolean bool;
    if ((StreetProductTypeItemView.a(this.a) != null) && (StreetProductTypeItemView.b(this.a)))
    {
      paramView = this.a;
      if (StreetProductTypeItemView.c(this.a)) {
        break label107;
      }
      bool = true;
      StreetProductTypeItemView.a(paramView, bool);
      if (!StreetProductTypeItemView.c(this.a)) {
        break label112;
      }
      StreetProductTypeItemView.d(this.a).setBackgroundResource(2131493038);
      StreetProductTypeItemView.e(this.a).setTextColor(this.a.getResources().getColor(2131493206));
    }
    for (;;)
    {
      StreetProductTypeItemView.a(this.a).a(StreetProductTypeItemView.f(this.a));
      return;
      label107:
      bool = false;
      break;
      label112:
      StreetProductTypeItemView.d(this.a).setBackgroundResource(2130838715);
      StreetProductTypeItemView.e(this.a).setTextColor(this.a.getResources().getColor(2131493028));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */