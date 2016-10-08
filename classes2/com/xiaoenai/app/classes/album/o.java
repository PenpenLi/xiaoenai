package com.xiaoenai.app.classes.album;

import android.content.Intent;
import com.xiaoenai.app.classes.common.b.c;
import com.xiaoenai.app.classes.common.image.ImagePicker.a;
import com.xiaoenai.app.ui.a.g;
import com.xiaoenai.app.widget.imagepicker.BaseImagePickerActivity;

class o
  implements ImagePicker.a
{
  o(n paramn) {}
  
  public void a()
  {
    if (c.a().e())
    {
      localObject = new g(this.a.a);
      ((g)localObject).a(2131100614);
      ((g)localObject).a(2131100898, new p(this));
      ((g)localObject).show();
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this.a.a, BaseImagePickerActivity.class);
    this.a.a.startActivityForResult((Intent)localObject, 21);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\album\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */