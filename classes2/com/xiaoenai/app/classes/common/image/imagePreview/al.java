package com.xiaoenai.app.classes.common.image.imagePreview;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.widget.TitleBarView;
import com.xiaoenai.app.widget.imagepicker.s;

class al
  implements View.OnClickListener
{
  al(ak paramak) {}
  
  public void onClick(View paramView)
  {
    if (!ak.a(this.a, ak.a(this.a)[ak.b(this.a).getCurrentItem()])) {
      if (!ak.b(this.a, ak.c(this.a)))
      {
        ak.d(this.a).b(2130837585, 0);
        ak.e(this.a);
        if (ak.f(this.a) != null)
        {
          ak.c(this.a, ak.a(this.a)[ak.b(this.a).getCurrentItem()]);
          ak.a(this.a, ak.a(this.a)[ak.b(this.a).getCurrentItem()], ak.a(this.a, ak.g(this.a)[ak.b(this.a).getCurrentItem()]));
        }
      }
    }
    for (;;)
    {
      ak.e(this.a, ak.c(this.a));
      return;
      h.c(this.a.a(), String.format(this.a.a().getString(2131100606), new Object[] { Integer.valueOf(s.a()) }), 1500L);
      continue;
      ak.d(this.a).b(2130837586, 0);
      ak.d(this.a, ak.a(this.a)[ak.b(this.a).getCurrentItem()]);
      ak.h(this.a);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\image\imagePreview\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */