package com.xiaoenai.app.feature.photoalbum.view.activity;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.xiaoenai.app.feature.photoalbum.a.b;
import com.xiaoenai.app.feature.photoalbum.a.c;
import com.xiaoenai.app.feature.photoalbum.e.c;
import com.xiaoenai.app.feature.photoalbum.view.widget.CanotSlidingViewpager;

class s
  implements View.OnClickListener
{
  s(PhotoAlbumActivity paramPhotoAlbumActivity) {}
  
  public void onClick(View paramView)
  {
    PhotoAlbumActivity.a(this.a, false);
    PhotoAlbumActivity.a(this.a).setScrollble(true);
    this.a.e.i();
    PhotoAlbumActivity.d(this.a).setBackgroundDrawable(this.a.getResources().getDrawable(a.c.album_send_btn_unable));
    PhotoAlbumActivity.d(this.a).setTextColor(this.a.getResources().getColor(a.b.album_delete_btn_text));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\view\activity\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */