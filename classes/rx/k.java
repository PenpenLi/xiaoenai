package rx;

import rx.c.c.m;

public abstract class k<T>
  implements g<T>, l
{
  private static final Long a = Long.valueOf(Long.MIN_VALUE);
  private final m b;
  private final k<?> c;
  private h d;
  private long e = a.longValue();
  
  protected k()
  {
    this(null, false);
  }
  
  protected k(k<?> paramk)
  {
    this(paramk, true);
  }
  
  protected k(k<?> paramk, boolean paramBoolean)
  {
    this.c = paramk;
    if ((paramBoolean) && (paramk != null)) {}
    for (paramk = paramk.b;; paramk = new m())
    {
      this.b = paramk;
      return;
    }
  }
  
  private void b(long paramLong)
  {
    if (this.e == a.longValue())
    {
      this.e = paramLong;
      return;
    }
    paramLong = this.e + paramLong;
    if (paramLong < 0L)
    {
      this.e = Long.MAX_VALUE;
      return;
    }
    this.e = paramLong;
  }
  
  protected final void a(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("number requested cannot be negative: " + paramLong);
    }
    try
    {
      if (this.d != null)
      {
        h localh = this.d;
        localh.a(paramLong);
        return;
      }
      b(paramLong);
      return;
    }
    finally {}
  }
  
  public void a(h paramh)
  {
    int j = 0;
    long l;
    try
    {
      l = this.e;
      this.d = paramh;
      int i = j;
      if (this.c != null)
      {
        i = j;
        if (l == a.longValue()) {
          i = 1;
        }
      }
      if (i != 0)
      {
        this.c.a(this.d);
        return;
      }
    }
    finally {}
    if (l == a.longValue())
    {
      this.d.a(Long.MAX_VALUE);
      return;
    }
    this.d.a(l);
  }
  
  public final void a(l paraml)
  {
    this.b.a(paraml);
  }
  
  public void b() {}
  
  public final void c()
  {
    this.b.c();
  }
  
  public final boolean d()
  {
    return this.b.d();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\rx\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */