package com.xiaoenai.app.classes.common.image.imagePreview;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.common.dialog.e;

class n
  implements View.OnClickListener
{
  n(m paramm, e parame, String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    if (this.b != null)
    {
      paramView = this.f.a(this.c, this.d, this.e);
      if ((m.a(this.f) instanceof ImageViewPager)) {
        ((ImageViewPager)m.a(this.f)).a(this.b, paramView.a(), paramView.b(), paramView.c());
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\image\imagePreview\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */