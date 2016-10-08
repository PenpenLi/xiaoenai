package rx.c.a;

import rx.a.b;
import rx.k;

public final class e<T, R>
  implements a.b<R, T>
{
  private final rx.b.f<? super T, ? extends R> a;
  
  public e(rx.b.f<? super T, ? extends R> paramf)
  {
    this.a = paramf;
  }
  
  public k<? super T> a(k<? super R> paramk)
  {
    return new f(this, paramk, paramk);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\c\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */