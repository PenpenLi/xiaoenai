package com.xiaoenai.app.feature.photopicker.view;

import android.os.Handler;
import com.xiaoenai.app.feature.photopicker.b.a.a;
import com.xiaoenai.app.ui.a.h;
import java.util.List;

class d
  implements a.a
{
  h a = h.a(this.b);
  
  d(PhotoPickerActivity paramPhotoPickerActivity) {}
  
  public void a()
  {
    PhotoPickerActivity.a(this.b).post(new e(this));
  }
  
  public void a(List<String> paramList, List<com.xiaoenai.app.feature.photopicker.a.d> paramList1)
  {
    PhotoPickerActivity.a(this.b).post(new f(this, paramList1));
  }
  
  public void b()
  {
    PhotoPickerActivity.a(this.b).post(new g(this));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photopicker\view\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */