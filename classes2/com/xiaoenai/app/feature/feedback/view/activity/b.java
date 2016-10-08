package com.xiaoenai.app.feature.feedback.view.activity;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.xiaoenai.app.feature.feedback.a.f;
import com.xiaoenai.app.utils.d.m;
import com.xiaoenai.app.utils.e.d.h;

class b
  extends h
{
  b(a parama) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    paramBitmap = com.xiaoenai.app.utils.e.b.a(paramString);
    paramString = m.a(paramString) + ".jpg";
    if (!TextUtils.isEmpty(paramBitmap)) {
      ChatImageViewPager.a(this.a.c, paramBitmap, paramString);
    }
  }
  
  public void a(String paramString, com.xiaoenai.app.utils.e.a.b paramb)
  {
    com.xiaoenai.app.utils.d.a.a(this.a.c, a.f.pv_save_local_failed);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\feedback\view\activity\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */