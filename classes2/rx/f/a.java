package rx.f;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.c.c.h;
import rx.i;
import rx.i.a;
import rx.l;

final class a
  extends i
{
  private static final h a = new h("RxCachedThreadScheduler-");
  private static final h b = new h("RxCachedWorkerPoolEvictor-");
  
  public i.a a()
  {
    return new b(a.d().a());
  }
  
  private static final class a
  {
    private static a d = new a(60L, TimeUnit.SECONDS);
    private final long a;
    private final ConcurrentLinkedQueue<a.c> b;
    private final ScheduledExecutorService c;
    
    a(long paramLong, TimeUnit paramTimeUnit)
    {
      this.a = paramTimeUnit.toNanos(paramLong);
      this.b = new ConcurrentLinkedQueue();
      this.c = Executors.newScheduledThreadPool(1, a.b());
      this.c.scheduleWithFixedDelay(new b(this), this.a, this.a, TimeUnit.NANOSECONDS);
    }
    
    a.c a()
    {
      while (!this.b.isEmpty())
      {
        a.c localc = (a.c)this.b.poll();
        if (localc != null) {
          return localc;
        }
      }
      return new a.c(a.c());
    }
    
    void a(a.c paramc)
    {
      paramc.a(c() + this.a);
      this.b.offer(paramc);
    }
    
    void b()
    {
      if (!this.b.isEmpty())
      {
        long l = c();
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          a.c localc = (a.c)localIterator.next();
          if (localc.e() > l) {
            break;
          }
          if (this.b.remove(localc)) {
            localc.c();
          }
        }
      }
    }
    
    long c()
    {
      return System.nanoTime();
    }
  }
  
  private static final class b
    extends i.a
  {
    static final AtomicIntegerFieldUpdater<b> b = AtomicIntegerFieldUpdater.newUpdater(b.class, "a");
    volatile int a;
    private final rx.h.b c = new rx.h.b();
    private final a.c d;
    
    b(a.c paramc)
    {
      this.d = paramc;
    }
    
    public l a(rx.b.a parama)
    {
      return a(parama, 0L, null);
    }
    
    public l a(rx.b.a parama, long paramLong, TimeUnit paramTimeUnit)
    {
      if (this.c.d()) {
        return rx.h.d.b();
      }
      parama = this.d.b(parama, paramLong, paramTimeUnit);
      this.c.a(parama);
      parama.a(this.c);
      return parama;
    }
    
    public void c()
    {
      if (b.compareAndSet(this, 0, 1)) {
        a.a.d().a(this.d);
      }
      this.c.c();
    }
    
    public boolean d()
    {
      return this.c.d();
    }
  }
  
  private static final class c
    extends rx.c.b.b
  {
    private long c = 0L;
    
    c(ThreadFactory paramThreadFactory)
    {
      super();
    }
    
    public void a(long paramLong)
    {
      this.c = paramLong;
    }
    
    public long e()
    {
      return this.c;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */