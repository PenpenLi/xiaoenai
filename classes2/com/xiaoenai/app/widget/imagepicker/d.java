package com.xiaoenai.app.widget.imagepicker;

import com.xiaoenai.app.ui.a.h;
import java.util.ArrayList;
import java.util.List;

class d
  implements Runnable
{
  d(b paramb, List paramList) {}
  
  public void run()
  {
    this.b.a.dismiss();
    BaseImagePickerActivity.a(this.b.b).a((ArrayList)this.a);
    BaseImagePickerActivity.b(this.b.b).a(BaseImagePickerActivity.a(this.b.b).a());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\imagepicker\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */