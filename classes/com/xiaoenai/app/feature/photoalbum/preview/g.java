package com.xiaoenai.app.feature.photoalbum.preview;

import android.graphics.Bitmap;
import android.widget.Toast;
import com.xiaoenai.app.feature.photoalbum.a.f;
import com.xiaoenai.app.utils.d.i;
import com.xiaoenai.app.utils.d.j;
import com.xiaoenai.app.utils.d.m;
import com.xiaoenai.app.utils.e.b;
import com.xiaoenai.app.utils.e.d.h;
import java.io.File;
import java.util.List;

class g
  extends h
{
  g(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    paramBitmap = b.b(((com.xiaoenai.app.feature.photopreview.b.a)PhotoPreviewActivity.b(this.a).get(PhotoPreviewActivity.c(this.a))).j());
    paramString = m.a(paramString);
    paramString = paramString + ".jpg";
    if ((paramBitmap == null) || (!paramBitmap.exists()) || (!paramBitmap.isFile())) {
      return;
    }
    File localFile = new File(com.xiaoenai.app.feature.photoalbum.a.a.a);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    if (i.a(paramBitmap.getAbsolutePath(), com.xiaoenai.app.feature.photoalbum.a.a.a + paramString) == 0)
    {
      j.a(this.a, new File(com.xiaoenai.app.feature.photoalbum.a.a.a, paramString));
      Toast.makeText(this.a, a.f.album_download_done, 0).show();
      return;
    }
    Toast.makeText(this.a, a.f.album_download_failed, 0).show();
  }
  
  public void b(String paramString) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\preview\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */