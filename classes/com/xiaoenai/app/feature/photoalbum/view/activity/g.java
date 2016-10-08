package com.xiaoenai.app.feature.photoalbum.view.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.feature.photoalbum.a.f;
import com.xiaoenai.app.ui.a.b;
import com.xiaoenai.app.ui.a.h;

class g
  implements View.OnClickListener
{
  g(PhotoAlbumActivity paramPhotoAlbumActivity, int paramInt) {}
  
  public void onClick(View paramView)
  {
    PhotoAlbumActivity.l(this.b).dismiss();
    if (5000 == this.a)
    {
      h.c(this.b, a.f.album_image_too_many, 2000L);
      return;
    }
    if (PhotoAlbumActivity.m(this.b))
    {
      h.c(this.b, a.f.album_images_uploading, 2000L);
      return;
    }
    PhotoAlbumActivity.n(this.b);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\view\activity\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */