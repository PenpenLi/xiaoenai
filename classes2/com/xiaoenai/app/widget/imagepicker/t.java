package com.xiaoenai.app.widget.imagepicker;

import android.view.View;
import android.view.View.OnClickListener;

class t
  implements View.OnClickListener
{
  t(s params, int paramInt, s.b paramb) {}
  
  public void onClick(View paramView)
  {
    if (s.a(this.c))
    {
      s.b(this.c).a((ImageEntry)this.c.getItem(this.a));
      s.a(this.c, this.a);
      return;
    }
    s.a(this.c, this.b, (ImageEntry)this.c.getItem(this.a));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\imagepicker\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */