package com.xiaoenai.app.feature.photopicker.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.feature.photopicker.b.c;
import com.xiaoenai.app.utils.f.a;

class n
  implements View.OnClickListener
{
  n(m paramm, int paramInt, m.b paramb) {}
  
  public void onClick(View paramView)
  {
    a.c("isSinglePickerMode {}", new Object[] { Boolean.valueOf(m.a(this.c)) });
    if (m.a(this.c))
    {
      m.b(this.c).a(this.c.a(this.a));
      m.a(this.c, this.a);
      return;
    }
    m.a(this.c, this.b, this.c.a(this.a));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\photopicker\view\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */