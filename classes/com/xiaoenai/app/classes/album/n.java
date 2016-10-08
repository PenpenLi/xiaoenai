package com.xiaoenai.app.classes.album;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.common.dialog.e;
import com.xiaoenai.app.classes.common.image.ImagePicker;

class n
  implements View.OnClickListener
{
  n(PhotoAlbumActivity paramPhotoAlbumActivity) {}
  
  public void onClick(View paramView)
  {
    PhotoAlbumActivity.f(this.a).dismiss();
    new ImagePicker(this.a).a(this.a.getString(2131099749), new o(this));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\album\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */