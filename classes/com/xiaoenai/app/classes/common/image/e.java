package com.xiaoenai.app.classes.common.image;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class e
  implements DialogInterface.OnDismissListener
{
  e(ImagePicker paramImagePicker) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    ImagePicker.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\image\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */