package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.core.a.f;
import com.nostra13.universalimageloader.core.g.a;

final class l
  implements Runnable
{
  private final e a;
  private final Bitmap b;
  private final g c;
  private final Handler d;
  
  public l(e parame, Bitmap paramBitmap, g paramg, Handler paramHandler)
  {
    this.a = parame;
    this.b = paramBitmap;
    this.c = paramg;
    this.d = paramHandler;
  }
  
  public void run()
  {
    com.nostra13.universalimageloader.b.c.a("PostProcess image before displaying [%s]", new Object[] { this.c.b });
    h.a(new b(this.c.e.p().a(this.b), this.c, this.a, f.c), this.c.e.s(), this.d, this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\nostra13\universalimageloader\core\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */