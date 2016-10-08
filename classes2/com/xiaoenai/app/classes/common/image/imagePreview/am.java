package com.xiaoenai.app.classes.common.image.imagePreview;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

class am
  implements View.OnClickListener
{
  am(ak paramak) {}
  
  public void onClick(View paramView)
  {
    if (ak.c(this.a) == 0)
    {
      ak.c(this.a, ak.a(this.a)[ak.b(this.a).getCurrentItem()]);
      this.a.a("preview_send_action", 3, ak.f(this.a), ak.i(this.a), ak.g(this.a)[ak.b(this.a).getCurrentItem()]);
    }
    for (;;)
    {
      this.a.a().finish();
      return;
      this.a.a("preview_send_action", 3, ak.f(this.a), ak.i(this.a), ak.g(this.a)[ak.b(this.a).getCurrentItem()]);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\image\imagePreview\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */