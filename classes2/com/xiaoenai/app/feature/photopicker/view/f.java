package com.xiaoenai.app.feature.photopicker.view;

import com.xiaoenai.app.feature.photopicker.b.c;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.f.a;
import java.util.ArrayList;
import java.util.List;

class f
  implements Runnable
{
  f(d paramd, List paramList) {}
  
  public void run()
  {
    a.c("onSuccess", new Object[0]);
    this.b.a.dismiss();
    PhotoPickerActivity.b(this.b.b).a((ArrayList)this.a);
    PhotoPickerActivity.a(this.b.b, PhotoPickerActivity.b(this.b.b).a());
    PhotoPickerActivity.d(this.b.b).a(PhotoPickerActivity.c(this.b.b));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\photopicker\view\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */