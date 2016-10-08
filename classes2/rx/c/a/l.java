package rx.c.a;

import rx.h;
import rx.i.a;

class l
  implements h
{
  l(k paramk, h paramh) {}
  
  public void a(long paramLong)
  {
    if (Thread.currentThread() == this.b.a)
    {
      this.a.a(paramLong);
      return;
    }
    this.b.b.b.b.a(new m(this, paramLong));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\c\a\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */