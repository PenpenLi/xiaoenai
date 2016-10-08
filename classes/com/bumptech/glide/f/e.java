package com.bumptech.glide.f;

import com.bumptech.glide.d.c.l;
import com.bumptech.glide.d.d.f.c;
import java.io.File;

public class e<A, T, Z, R>
  implements f<A, T, Z, R>
{
  private final l<A, T> a;
  private final c<Z, R> b;
  private final b<T, Z> c;
  
  public e(l<A, T> paraml, c<Z, R> paramc, b<T, Z> paramb)
  {
    if (paraml == null) {
      throw new NullPointerException("ModelLoader must not be null");
    }
    this.a = paraml;
    if (paramc == null) {
      throw new NullPointerException("Transcoder must not be null");
    }
    this.b = paramc;
    if (paramb == null) {
      throw new NullPointerException("DataLoadProvider must not be null");
    }
    this.c = paramb;
  }
  
  public com.bumptech.glide.d.e<File, Z> a()
  {
    return this.c.a();
  }
  
  public com.bumptech.glide.d.e<T, Z> b()
  {
    return this.c.b();
  }
  
  public com.bumptech.glide.d.b<T> c()
  {
    return this.c.c();
  }
  
  public com.bumptech.glide.d.f<Z> d()
  {
    return this.c.d();
  }
  
  public l<A, T> e()
  {
    return this.a;
  }
  
  public c<Z, R> f()
  {
    return this.b;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\f\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */