package com.xiaoenai.app.classes.album;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.model.album.Photo;
import com.xiaoenai.app.model.album.PhotoImageList;

class r
  implements Runnable
{
  r(PhotoAlbumActivity.a parama, int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void run()
  {
    Photo localPhoto = new Photo(this.a, this.b, this.c, this.d, 0, 0);
    PhotoImageList.getInstance().addPhoto(localPhoto, 0);
    PhotoAlbumActivity.l(this.g.a);
    UserConfig.setInt("photoalbum_cur", PhotoAlbumActivity.i(this.g.a));
    PhotoAlbumActivity.n(this.g.a).setProgress(this.e - this.f);
    PhotoAlbumActivity.o(this.g.a).setText(this.e - this.f + "/" + this.e);
    Xiaoenai.j().a(new s(this), 50L);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\album\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */