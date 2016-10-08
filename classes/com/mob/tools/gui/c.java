package com.mob.tools.gui;

import android.graphics.Bitmap;
import com.mob.tools.a.q;
import java.io.File;
import java.io.InputStream;

class c
  implements q
{
  c(a.e parame, File paramFile, boolean paramBoolean, a.b paramb) {}
  
  public void a(InputStream paramInputStream)
  {
    paramInputStream = com.mob.tools.b.a.a(new a.d(paramInputStream), 1);
    if ((paramInputStream == null) || (paramInputStream.isRecycled()))
    {
      a.e.a(this.d, null);
      return;
    }
    a.e.a(this.d, paramInputStream, this.a, this.b);
    if (paramInputStream != null)
    {
      a.c(a.e.c(this.d)).a(a.b.a(this.c), paramInputStream);
      a.b.a(this.c, paramInputStream);
    }
    a.e.a(this.d, null);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\gui\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */