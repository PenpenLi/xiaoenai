package com.xiaoenai.app.feature.photoalbum.preview;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.widget.TextView;
import com.xiaoenai.app.common.view.widget.TitleBarView;
import com.xiaoenai.app.feature.photopreview.view.e;
import com.xiaoenai.app.utils.d.d;
import com.xiaoenai.app.utils.e.b;
import java.io.File;
import java.util.Calendar;
import java.util.List;

class h
  implements ViewPager.OnPageChangeListener
{
  h(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    Object localObject;
    if (PhotoPreviewActivity.f.equals(PhotoPreviewActivity.e(this.a)))
    {
      PhotoPreviewActivity.a(this.a, paramInt);
      PhotoPreviewActivity.f(this.a).setTimeInMillis(((com.xiaoenai.app.feature.photoalbum.b.a)PhotoPreviewActivity.b(this.a).get(paramInt)).i().longValue());
      localObject = d.a(PhotoPreviewActivity.f(this.a));
      PhotoPreviewActivity.g(this.a).setTitle((String)localObject);
      localObject = ((com.xiaoenai.app.feature.photoalbum.b.a)PhotoPreviewActivity.b(this.a).get(paramInt)).h();
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        PhotoPreviewActivity.h(this.a).setVisibility(8);
        if (!((com.xiaoenai.app.feature.photopreview.b.a)PhotoPreviewActivity.b(this.a).get(PhotoPreviewActivity.c(this.a))).c()) {
          break label284;
        }
        localObject = b.b(((com.xiaoenai.app.feature.photopreview.b.a)PhotoPreviewActivity.b(this.a).get(paramInt)).j());
        if ((localObject == null) || (0L >= ((File)localObject).length())) {
          break label235;
        }
        PhotoPreviewActivity.i(this.a).setVisibility(8);
      }
    }
    for (;;)
    {
      PhotoPreviewActivity.l(this.a).a(paramInt);
      return;
      PhotoPreviewActivity.h(this.a).setVisibility(0);
      PhotoPreviewActivity.h(this.a).setText((CharSequence)localObject);
      break;
      label235:
      PhotoPreviewActivity.b(this.a, ((com.xiaoenai.app.feature.photoalbum.b.a)PhotoPreviewActivity.b(this.a).get(PhotoPreviewActivity.c(this.a))).f().intValue());
      PhotoPreviewActivity.i(this.a).setVisibility(0);
      continue;
      label284:
      PhotoPreviewActivity.i(this.a).setVisibility(8);
      continue;
      if (PhotoPreviewActivity.g.equals(PhotoPreviewActivity.e(this.a))) {
        PhotoPreviewActivity.k(this.a).setTitle(paramInt + 1 + " / " + PhotoPreviewActivity.j(this.a).getCount());
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\preview\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */