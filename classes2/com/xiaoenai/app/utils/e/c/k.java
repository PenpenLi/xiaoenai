package com.xiaoenai.app.utils.e.c;

import android.graphics.Bitmap;
import android.view.View;
import com.nostra13.universalimageloader.core.f.a;
import com.xiaoenai.app.utils.e.d.c;

class k
  implements a
{
  k(h paramh, c paramc) {}
  
  public void a(String paramString, View paramView)
  {
    if (this.a != null) {
      this.a.a(paramString);
    }
  }
  
  public void a(String paramString, View paramView, Bitmap paramBitmap)
  {
    if (this.a != null) {
      this.a.a(paramString, paramBitmap);
    }
  }
  
  public void a(String paramString, View paramView, com.nostra13.universalimageloader.core.a.b paramb)
  {
    if (this.a != null)
    {
      if (paramb.a() != com.nostra13.universalimageloader.core.a.b.a.a) {
        break label46;
      }
      paramView = com.xiaoenai.app.utils.e.a.b.a.a;
    }
    for (;;)
    {
      paramView = new com.xiaoenai.app.utils.e.a.b(paramView, paramb.b());
      this.a.a(paramString, paramView);
      return;
      label46:
      if (paramb.a() == com.nostra13.universalimageloader.core.a.b.a.b) {
        paramView = com.xiaoenai.app.utils.e.a.b.a.b;
      } else if (paramb.a() == com.nostra13.universalimageloader.core.a.b.a.c) {
        paramView = com.xiaoenai.app.utils.e.a.b.a.c;
      } else if (paramb.a() == com.nostra13.universalimageloader.core.a.b.a.d) {
        paramView = com.xiaoenai.app.utils.e.a.b.a.d;
      } else {
        paramView = com.xiaoenai.app.utils.e.a.b.a.e;
      }
    }
  }
  
  public void b(String paramString, View paramView)
  {
    if (this.a != null) {
      this.a.b(paramString);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\e\c\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */