package com.xiaoenai.app.classes.chat;

import android.graphics.Bitmap;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.e;
import com.xiaoenai.app.utils.e.d.c;
import com.xiaoenai.app.utils.f.a;
import java.io.File;

class x
  implements c
{
  x(w paramw) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    paramBitmap.recycle();
    this.a.a.a.l_();
    a.c("selected:{}", new Object[] { paramString });
    paramString = com.xiaoenai.app.utils.e.b.b(paramString);
    if (paramString != null)
    {
      paramBitmap = e.b + paramString.getName();
      if (e.a(paramString.getAbsolutePath(), paramBitmap) == 0) {
        ak.a("chat_bg_photo_path", paramBitmap);
      }
    }
    for (;;)
    {
      this.a.a.a.r();
      return;
      ak.a("chat_bg_photo_path", paramString.getAbsolutePath());
      continue;
      ak.a("chat_bg_photo_path", paramString.getAbsolutePath());
    }
  }
  
  public void a(String paramString, com.xiaoenai.app.utils.e.a.b paramb)
  {
    this.a.a.a.l_();
    if (!this.a.a.a.isFinishing()) {
      h.c(this.a.a.a, 2131100139, 1500L);
    }
  }
  
  public void b(String paramString)
  {
    this.a.a.a.l_();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */