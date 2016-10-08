package com.bumptech.glide.d.d.d;

import android.content.Context;
import com.bumptech.glide.d.c.o;
import com.bumptech.glide.d.e;
import com.bumptech.glide.d.f;
import java.io.File;
import java.io.InputStream;

public class c
  implements com.bumptech.glide.f.b<InputStream, b>
{
  private final i a;
  private final j b;
  private final o c;
  private final com.bumptech.glide.d.d.c.c<b> d;
  
  public c(Context paramContext, com.bumptech.glide.d.b.a.c paramc)
  {
    this.a = new i(paramContext, paramc);
    this.d = new com.bumptech.glide.d.d.c.c(this.a);
    this.b = new j(paramc);
    this.c = new o();
  }
  
  public e<File, b> a()
  {
    return this.d;
  }
  
  public e<InputStream, b> b()
  {
    return this.a;
  }
  
  public com.bumptech.glide.d.b<InputStream> c()
  {
    return this.c;
  }
  
  public f<b> d()
  {
    return this.b;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\d\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */