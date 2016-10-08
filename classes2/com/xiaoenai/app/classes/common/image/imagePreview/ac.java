package com.xiaoenai.app.classes.common.image.imagePreview;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

class ac
  implements View.OnClickListener
{
  ac(z paramz) {}
  
  public void onClick(View paramView)
  {
    if (z.b(this.a) != null)
    {
      ((ImageViewPager)z.b(this.a)).r();
      return;
    }
    this.a.a().finish();
    this.a.a().overridePendingTransition(2130968586, 2130968587);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\image\imagePreview\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */