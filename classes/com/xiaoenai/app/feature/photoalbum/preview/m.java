package com.xiaoenai.app.feature.photoalbum.preview;

import android.view.View;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.ui.a.k.a;
import java.util.List;

class m
  implements k.a
{
  m(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void a(k paramk, View paramView)
  {
    paramk.dismiss();
    PhotoPreviewActivity.p(this.a).add(Integer.valueOf(PhotoPreviewActivity.c(this.a)));
    this.a.g();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\preview\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */