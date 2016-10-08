package com.bumptech.glide.d.d.e;

import android.graphics.Bitmap;
import com.bumptech.glide.d.b.k;
import com.bumptech.glide.d.d.d.b;
import com.bumptech.glide.d.f;
import java.io.OutputStream;

public class d
  implements f<a>
{
  private final f<Bitmap> a;
  private final f<b> b;
  private String c;
  
  public d(f<Bitmap> paramf, f<b> paramf1)
  {
    this.a = paramf;
    this.b = paramf1;
  }
  
  public String a()
  {
    if (this.c == null) {
      this.c = (this.a.a() + this.b.a());
    }
    return this.c;
  }
  
  public boolean a(k<a> paramk, OutputStream paramOutputStream)
  {
    paramk = (a)paramk.b();
    k localk = paramk.b();
    if (localk != null) {
      return this.a.a(localk, paramOutputStream);
    }
    return this.b.a(paramk.c(), paramOutputStream);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\d\e\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */