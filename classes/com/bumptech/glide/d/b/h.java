package com.bumptech.glide.d.b;

import android.os.Looper;
import com.bumptech.glide.d.c;

class h<Z>
  implements k<Z>
{
  private final k<Z> a;
  private final boolean b;
  private a c;
  private c d;
  private int e;
  private boolean f;
  
  h(k<Z> paramk, boolean paramBoolean)
  {
    if (paramk == null) {
      throw new NullPointerException("Wrapped resource must not be null");
    }
    this.a = paramk;
    this.b = paramBoolean;
  }
  
  void a(c paramc, a parama)
  {
    this.d = paramc;
    this.c = parama;
  }
  
  boolean a()
  {
    return this.b;
  }
  
  public Z b()
  {
    return (Z)this.a.b();
  }
  
  public int c()
  {
    return this.a.c();
  }
  
  public void d()
  {
    if (this.e > 0) {
      throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
    }
    if (this.f) {
      throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
    }
    this.f = true;
    this.a.d();
  }
  
  void e()
  {
    if (this.f) {
      throw new IllegalStateException("Cannot acquire a recycled resource");
    }
    if (!Looper.getMainLooper().equals(Looper.myLooper())) {
      throw new IllegalThreadStateException("Must call acquire on the main thread");
    }
    this.e += 1;
  }
  
  void f()
  {
    if (this.e <= 0) {
      throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
    }
    if (!Looper.getMainLooper().equals(Looper.myLooper())) {
      throw new IllegalThreadStateException("Must call release on the main thread");
    }
    int i = this.e - 1;
    this.e = i;
    if (i == 0) {
      this.c.b(this.d, this);
    }
  }
  
  static abstract interface a
  {
    public abstract void b(c paramc, h<?> paramh);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\b\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */