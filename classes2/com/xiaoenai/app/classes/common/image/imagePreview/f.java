package com.xiaoenai.app.classes.common.image.imagePreview;

import android.view.View;
import android.view.View.OnClickListener;

class f
  implements View.OnClickListener
{
  f(a parama) {}
  
  public void onClick(View paramView)
  {
    paramView = (ImageViewPager)this.a.a();
    if ((paramView != null) && (!paramView.isFinishing()))
    {
      if (a.f(this.a))
      {
        paramView.d();
        a.a(this.a, false);
      }
    }
    else {
      return;
    }
    paramView.c();
    a.a(this.a, true);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\image\imagePreview\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */