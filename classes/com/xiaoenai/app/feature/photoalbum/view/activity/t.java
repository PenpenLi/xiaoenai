package com.xiaoenai.app.feature.photoalbum.view.activity;

import android.content.res.Resources;
import android.widget.TextView;
import com.xiaoenai.app.feature.photoalbum.a.b;
import com.xiaoenai.app.feature.photoalbum.a.c;
import com.xiaoenai.app.feature.photoalbum.a.f;
import com.xiaoenai.app.feature.photoalbum.e.c.c;
import java.util.Map;

class t
  implements c.c
{
  t(PhotoAlbumActivity paramPhotoAlbumActivity) {}
  
  public void a(Map<Integer, Integer> paramMap)
  {
    if (paramMap.size() > 0)
    {
      paramMap = String.format(this.a.getString(a.f.album_delete_count), new Object[] { Integer.valueOf(paramMap.size()) });
      PhotoAlbumActivity.d(this.a).setBackgroundDrawable(this.a.getResources().getDrawable(a.c.album_send_btn_able));
      PhotoAlbumActivity.d(this.a).setText(paramMap);
      PhotoAlbumActivity.d(this.a).setTextColor(-1);
      PhotoAlbumActivity.d(this.a).setClickable(true);
      return;
    }
    PhotoAlbumActivity.d(this.a).setBackgroundDrawable(this.a.getResources().getDrawable(a.c.album_send_btn_unable));
    PhotoAlbumActivity.d(this.a).setTextColor(this.a.getResources().getColor(a.b.album_delete_btn_text));
    PhotoAlbumActivity.d(this.a).setText(this.a.getString(a.f.delete));
    PhotoAlbumActivity.d(this.a).setClickable(false);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\view\activity\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */