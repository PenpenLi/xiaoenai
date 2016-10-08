package com.xiaoenai.app.utils.e.c;

import android.graphics.Bitmap;
import android.view.View;
import com.nostra13.universalimageloader.core.f.a;

class j
  implements a
{
  j(h paramh, com.xiaoenai.app.utils.e.d.b paramb) {}
  
  public void a(String paramString, View paramView)
  {
    if (this.a != null) {
      this.a.a(paramString, paramView);
    }
  }
  
  public void a(String paramString, View paramView, Bitmap paramBitmap)
  {
    if (this.a != null) {
      this.a.a(paramString, paramView, paramBitmap);
    }
  }
  
  public void a(String paramString, View paramView, com.nostra13.universalimageloader.core.a.b paramb)
  {
    com.xiaoenai.app.utils.e.a.b.a locala;
    if (this.a != null)
    {
      if (paramb.a() != com.nostra13.universalimageloader.core.a.b.a.a) {
        break label49;
      }
      locala = com.xiaoenai.app.utils.e.a.b.a.a;
    }
    for (;;)
    {
      paramb = new com.xiaoenai.app.utils.e.a.b(locala, paramb.b());
      this.a.a(paramString, paramView, paramb);
      return;
      label49:
      if (paramb.a() == com.nostra13.universalimageloader.core.a.b.a.b) {
        locala = com.xiaoenai.app.utils.e.a.b.a.b;
      } else if (paramb.a() == com.nostra13.universalimageloader.core.a.b.a.c) {
        locala = com.xiaoenai.app.utils.e.a.b.a.c;
      } else if (paramb.a() == com.nostra13.universalimageloader.core.a.b.a.d) {
        locala = com.xiaoenai.app.utils.e.a.b.a.d;
      } else {
        locala = com.xiaoenai.app.utils.e.a.b.a.e;
      }
    }
  }
  
  public void b(String paramString, View paramView)
  {
    if (this.a != null) {
      this.a.b(paramString, paramView);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\e\c\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */