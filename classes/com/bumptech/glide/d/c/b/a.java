package com.bumptech.glide.d.c.b;

import android.content.Context;
import com.bumptech.glide.d.a.f;
import com.bumptech.glide.d.c.e;
import com.bumptech.glide.d.c.j;
import com.bumptech.glide.d.c.l;
import com.bumptech.glide.d.c.m;
import java.io.InputStream;

public class a
  implements l<e, InputStream>
{
  private final j<e, e> a;
  
  public a()
  {
    this(null);
  }
  
  public a(j<e, e> paramj)
  {
    this.a = paramj;
  }
  
  public com.bumptech.glide.d.a.c<InputStream> a(e parame, int paramInt1, int paramInt2)
  {
    e locale = parame;
    if (this.a != null)
    {
      locale = (e)this.a.a(parame, 0, 0);
      if (locale != null) {
        break label54;
      }
      this.a.a(parame, 0, 0, parame);
      locale = parame;
    }
    label54:
    for (;;)
    {
      return new f(locale);
    }
  }
  
  public static class a
    implements m<e, InputStream>
  {
    private final j<e, e> a = new j(500);
    
    public l<e, InputStream> a(Context paramContext, com.bumptech.glide.d.c.c paramc)
    {
      return new a(this.a);
    }
    
    public void a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\c\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */