package com.xiaoenai.app.feature.photoalbum.preview;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.feature.photopreview.b.a;
import com.xiaoenai.app.feature.photopreview.view.e;
import java.util.List;

class f
  implements View.OnClickListener
{
  f(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    if ((PhotoPreviewActivity.b(this.a) != null) && (PhotoPreviewActivity.b(this.a).size() > PhotoPreviewActivity.c(this.a))) {
      this.a.a(((a)PhotoPreviewActivity.b(this.a).get(PhotoPreviewActivity.c(this.a))).j(), PhotoPreviewActivity.d(this.a).b(PhotoPreviewActivity.c(this.a)), paramView);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\preview\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */