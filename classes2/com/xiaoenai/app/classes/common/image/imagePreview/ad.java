package com.xiaoenai.app.classes.common.image.imagePreview;

import android.view.View;
import android.view.View.OnClickListener;

class ad
  implements View.OnClickListener
{
  ad(z paramz) {}
  
  public void onClick(View paramView)
  {
    paramView = (ImageViewPager)this.a.a();
    if ((paramView != null) && (!paramView.isFinishing()))
    {
      if (z.c(this.a))
      {
        paramView.d();
        z.a(this.a, false);
      }
    }
    else {
      return;
    }
    paramView.c();
    z.a(this.a, true);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\image\imagePreview\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */