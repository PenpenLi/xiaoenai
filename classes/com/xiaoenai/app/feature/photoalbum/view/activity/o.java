package com.xiaoenai.app.feature.photoalbum.view.activity;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.xiaoenai.app.feature.photoalbum.view.widget.ToggleButton;

class o
  implements ViewPager.OnPageChangeListener
{
  o(PhotoAlbumActivity paramPhotoAlbumActivity) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    ToggleButton localToggleButton = PhotoAlbumActivity.b(this.a);
    if (paramInt == 0) {}
    for (String str = "left";; str = "right")
    {
      localToggleButton.setStatus(str);
      PhotoAlbumActivity.a(this.a, paramInt);
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\view\activity\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */