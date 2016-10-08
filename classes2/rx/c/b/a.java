package rx.c.b;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import rx.c.c.h;
import rx.c.c.m;
import rx.h.d;
import rx.i;
import rx.i.a;
import rx.l;

public class a
  extends i
{
  static final int a;
  private static final h c = new h("RxComputationThreadPool-");
  final b b = new b();
  
  static
  {
    int j = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
    int k = Runtime.getRuntime().availableProcessors();
    int i;
    if (j > 0)
    {
      i = j;
      if (j <= k) {}
    }
    else
    {
      i = k;
    }
    a = i;
  }
  
  public i.a a()
  {
    return new a(this.b.a());
  }
  
  public l a(rx.b.a parama)
  {
    return this.b.a().b(parama, -1L, TimeUnit.NANOSECONDS);
  }
  
  private static class a
    extends i.a
  {
    private final m a = new m();
    private final rx.h.b b = new rx.h.b();
    private final m c = new m(new l[] { this.a, this.b });
    private final a.c d;
    
    a(a.c paramc)
    {
      this.d = paramc;
    }
    
    public l a(rx.b.a parama)
    {
      if (d()) {
        return d.b();
      }
      return this.d.a(parama, 0L, null, this.a);
    }
    
    public l a(rx.b.a parama, long paramLong, TimeUnit paramTimeUnit)
    {
      if (d()) {
        return d.b();
      }
      return this.d.a(parama, paramLong, paramTimeUnit, this.b);
    }
    
    public void c()
    {
      this.c.c();
    }
    
    public boolean d()
    {
      return this.c.d();
    }
  }
  
  static final class b
  {
    final int a = a.a;
    final a.c[] b = new a.c[this.a];
    long c;
    
    b()
    {
      int i = 0;
      while (i < this.a)
      {
        this.b[i] = new a.c(a.b());
        i += 1;
      }
    }
    
    public a.c a()
    {
      a.c[] arrayOfc = this.b;
      long l = this.c;
      this.c = (1L + l);
      return arrayOfc[((int)(l % this.a))];
    }
  }
  
  private static final class c
    extends b
  {
    c(ThreadFactory paramThreadFactory)
    {
      super();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\c\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */