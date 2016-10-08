package com.bumptech.glide.f;

import com.bumptech.glide.d.b;
import com.bumptech.glide.d.c.l;
import com.bumptech.glide.d.d.f.c;
import com.bumptech.glide.d.e;
import java.io.File;

public class a<A, T, Z, R>
  implements f<A, T, Z, R>, Cloneable
{
  private final f<A, T, Z, R> a;
  private e<File, Z> b;
  private e<T, Z> c;
  private com.bumptech.glide.d.f<Z> d;
  private c<Z, R> e;
  private b<T> f;
  
  public a(f<A, T, Z, R> paramf)
  {
    this.a = paramf;
  }
  
  public e<File, Z> a()
  {
    if (this.b != null) {
      return this.b;
    }
    return this.a.a();
  }
  
  public void a(b<T> paramb)
  {
    this.f = paramb;
  }
  
  public void a(e<T, Z> parame)
  {
    this.c = parame;
  }
  
  public e<T, Z> b()
  {
    if (this.c != null) {
      return this.c;
    }
    return this.a.b();
  }
  
  public b<T> c()
  {
    if (this.f != null) {
      return this.f;
    }
    return this.a.c();
  }
  
  public com.bumptech.glide.d.f<Z> d()
  {
    if (this.d != null) {
      return this.d;
    }
    return this.a.d();
  }
  
  public l<A, T> e()
  {
    return this.a.e();
  }
  
  public c<Z, R> f()
  {
    if (this.e != null) {
      return this.e;
    }
    return this.a.f();
  }
  
  public a<A, T, Z, R> g()
  {
    try
    {
      a locala = (a)super.clone();
      return locala;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new RuntimeException(localCloneNotSupportedException);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */