package com.xiaoenai.app.classes.common.image.imagePreview;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

class aq
  implements View.OnClickListener
{
  aq(ak paramak) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a;
    if (!ak.i(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      ak.b(paramView, bool);
      ak.m(this.a).setSelected(ak.i(this.a));
      if ((!ak.a(this.a, ak.a(this.a)[ak.b(this.a).getCurrentItem()])) && (ak.c(this.a) < 9))
      {
        ak.c(this.a, ak.a(this.a)[ak.b(this.a).getCurrentItem()]);
        ak.e(this.a);
        ak.e(this.a, ak.c(this.a));
        this.a.a(ak.b(this.a).getCurrentItem());
      }
      ak.a(this.a, ak.a(this.a)[ak.b(this.a).getCurrentItem()], ak.a(this.a, ak.g(this.a)[ak.b(this.a).getCurrentItem()]));
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\image\imagePreview\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */