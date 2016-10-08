package com.xiaoenai.app.classes.common.image;

import android.view.View;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.ui.a.k.a;
import com.xiaoenai.app.utils.as;

class l
  implements k.a
{
  l(ImagePicker.ImagePickerActivity paramImagePickerActivity, String paramString) {}
  
  public void a(k paramk, View paramView)
  {
    paramk.dismiss();
    as.a(paramk.getContext(), this.a, "takePic");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\image\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */