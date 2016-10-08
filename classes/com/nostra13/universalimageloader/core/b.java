package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.core.a.f;

final class b
  implements Runnable
{
  private final Bitmap a;
  private final String b;
  private final com.nostra13.universalimageloader.core.e.a c;
  private final String d;
  private final com.nostra13.universalimageloader.core.c.a e;
  private final com.nostra13.universalimageloader.core.f.a f;
  private final e g;
  private final f h;
  
  public b(Bitmap paramBitmap, g paramg, e parame, f paramf)
  {
    this.a = paramBitmap;
    this.b = paramg.a;
    this.c = paramg.c;
    this.d = paramg.b;
    this.e = paramg.e.q();
    this.f = paramg.f;
    this.g = parame;
    this.h = paramf;
  }
  
  private boolean a()
  {
    String str = this.g.a(this.c);
    return !this.d.equals(str);
  }
  
  public void run()
  {
    if (this.c.e())
    {
      com.nostra13.universalimageloader.b.c.a("ImageAware was collected by GC. Task is cancelled. [%s]", new Object[] { this.d });
      this.f.b(this.b, this.c.d());
      return;
    }
    if (a())
    {
      com.nostra13.universalimageloader.b.c.a("ImageAware is reused for another image. Task is cancelled. [%s]", new Object[] { this.d });
      this.f.b(this.b, this.c.d());
      return;
    }
    com.nostra13.universalimageloader.b.c.a("Display image in ImageAware (loaded from %1$s) [%2$s]", new Object[] { this.h, this.d });
    this.e.a(this.a, this.c, this.h);
    this.g.b(this.c);
    this.f.a(this.b, this.c.d(), this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\nostra13\universalimageloader\core\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */