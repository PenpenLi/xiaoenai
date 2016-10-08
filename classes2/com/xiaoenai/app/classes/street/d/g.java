package com.xiaoenai.app.classes.street.d;

import android.content.Intent;
import com.xiaoenai.app.classes.common.BaseActivity;
import com.xiaoenai.app.classes.common.image.ImagePicker.a;
import com.xiaoenai.app.widget.imagepicker.BaseImagePickerActivity;
import java.util.ArrayList;

class g
  implements ImagePicker.a
{
  g(e parame) {}
  
  public void a()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(e.a(this.a), BaseImagePickerActivity.class);
    localIntent.putExtra("pick_from", 3);
    localIntent.putExtra("max_selected_size", 3 - e.b(this.a).size());
    localIntent.putExtra("original_flag", false);
    e.a(this.a).startActivityForResult(localIntent, 21);
    e.a(this.a).overridePendingTransition(2130968606, 2130968607);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\d\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */