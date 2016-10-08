package com.xiaoenai.app.feature.photoalbum.preview;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.Toast;
import com.xiaoenai.app.feature.photoalbum.a.f;
import com.xiaoenai.app.feature.photoalbum.b.a;
import java.util.List;

class e
  implements com.xiaoenai.app.utils.e.d.b
{
  e(PhotoPreviewActivity paramPhotoPreviewActivity, View paramView) {}
  
  public void a(String paramString, View paramView)
  {
    paramView.setClickable(false);
  }
  
  public void a(String paramString, View paramView, Bitmap paramBitmap)
  {
    paramView.setClickable(true);
    this.a.setVisibility(8);
    Toast.makeText(this.b, a.f.album_download_origin_done, 0).show();
    ((a)PhotoPreviewActivity.b(this.b).get(PhotoPreviewActivity.c(this.b))).a(true);
  }
  
  public void a(String paramString, View paramView, com.xiaoenai.app.utils.e.a.b paramb)
  {
    paramView.setClickable(true);
  }
  
  public void b(String paramString, View paramView)
  {
    paramView.setClickable(true);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\preview\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */