package com.bumptech.glide;

import android.content.Context;
import android.os.Build.VERSION;
import com.bumptech.glide.d.b.a.d;
import com.bumptech.glide.d.b.b.a.a;
import com.bumptech.glide.d.b.b.h;
import com.bumptech.glide.d.b.b.i;
import com.bumptech.glide.d.b.b.j;
import java.util.concurrent.ExecutorService;

public class c
{
  private final Context a;
  private com.bumptech.glide.d.b.c b;
  private com.bumptech.glide.d.b.a.c c;
  private i d;
  private ExecutorService e;
  private ExecutorService f;
  private com.bumptech.glide.d.a g;
  private a.a h;
  
  public c(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }
  
  Glide a()
  {
    if (this.e == null) {
      this.e = new com.bumptech.glide.d.b.c.a(Math.max(1, Runtime.getRuntime().availableProcessors()));
    }
    if (this.f == null) {
      this.f = new com.bumptech.glide.d.b.c.a(1);
    }
    j localj = new j(this.a);
    if (this.c == null) {
      if (Build.VERSION.SDK_INT < 11) {
        break label209;
      }
    }
    label209:
    for (this.c = new com.bumptech.glide.d.b.a.f(localj.b());; this.c = new d())
    {
      if (this.d == null) {
        this.d = new h(localj.a());
      }
      if (this.h == null) {
        this.h = new com.bumptech.glide.d.b.b.f(this.a);
      }
      if (this.b == null) {
        this.b = new com.bumptech.glide.d.b.c(this.d, this.h, this.f, this.e);
      }
      if (this.g == null) {
        this.g = com.bumptech.glide.d.a.d;
      }
      return new Glide(this.b, this.d, this.c, this.a, this.g);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */