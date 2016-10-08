package com.xiaoenai.app.classes.forum.presenter;

import android.app.Activity;
import android.content.Intent;
import com.xiaoenai.app.classes.common.image.ImagePicker.a;
import com.xiaoenai.app.widget.imagepicker.BaseImagePickerActivity;
import java.util.ArrayList;

class i
  implements ImagePicker.a
{
  i(h paramh) {}
  
  public void a()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(h.a(this.a), BaseImagePickerActivity.class);
    localIntent.putExtra("pick_from", 3);
    localIntent.putExtra("max_selected_size", 9 - h.b(this.a).size());
    localIntent.putExtra("image_picker_mode", 0);
    localIntent.putExtra("original_flag", false);
    h.a(this.a).startActivityForResult(localIntent, 21);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\presenter\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */