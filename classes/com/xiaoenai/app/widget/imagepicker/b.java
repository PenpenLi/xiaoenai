package com.xiaoenai.app.widget.imagepicker;

import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.ui.a.h;
import java.util.List;

class b
  implements ImageDataManager.a
{
  h a = h.a(this.b);
  
  b(BaseImagePickerActivity paramBaseImagePickerActivity) {}
  
  public void a()
  {
    Xiaoenai.j().a(new c(this));
  }
  
  public void a(List<String> paramList, List<ImageEntry> paramList1)
  {
    Xiaoenai.j().a(new d(this, paramList1));
  }
  
  public void b()
  {
    Xiaoenai.j().a(new e(this));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\widget\imagepicker\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */