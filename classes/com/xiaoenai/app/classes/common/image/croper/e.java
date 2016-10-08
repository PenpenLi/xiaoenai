package com.xiaoenai.app.classes.common.image.croper;

import android.view.View;
import android.view.View.OnClickListener;

class e
  implements View.OnClickListener
{
  e(CropImage paramCropImage) {}
  
  public void onClick(View paramView)
  {
    CropImage.a(this.a, q.a(CropImage.b(this.a), -90.0F));
    paramView = new p(CropImage.b(this.a));
    CropImage.c(this.a).a(paramView, true);
    this.a.d.run();
    CropImage.a(this.a, true);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\image\croper\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */