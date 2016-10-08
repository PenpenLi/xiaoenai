package com.xiaoenai.app.classes.common.image.imagePreview;

import android.view.View;
import android.view.View.OnClickListener;

class ap
  implements View.OnClickListener
{
  ap(ak paramak) {}
  
  public void onClick(View paramView)
  {
    paramView = (ImageViewPager)this.a.a();
    if ((paramView != null) && (!paramView.isFinishing()))
    {
      if (ak.l(this.a))
      {
        paramView.d();
        ak.a(this.a, false);
      }
    }
    else {
      return;
    }
    paramView.c();
    ak.a(this.a, true);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\image\imagePreview\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */