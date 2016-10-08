package com.xiaoenai.app.feature.photoalbum.view.activity;

import com.xiaoenai.app.feature.photoalbum.view.widget.CanotSlidingViewpager;
import com.xiaoenai.app.feature.photoalbum.view.widget.ToggleButton.a;

class n
  implements ToggleButton.a
{
  n(PhotoAlbumActivity paramPhotoAlbumActivity) {}
  
  public void a()
  {
    PhotoAlbumActivity.a(this.a).setCurrentItem(0);
    PhotoAlbumActivity.a(this.a, 0);
  }
  
  public void b()
  {
    PhotoAlbumActivity.a(this.a).setCurrentItem(1);
    PhotoAlbumActivity.a(this.a, 1);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\view\activity\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */