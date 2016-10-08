package rx.c.b;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.c.c.h;
import rx.c.c.m;
import rx.e.f;
import rx.i.a;
import rx.l;

public class b
  extends i.a
  implements l
{
  public static final int b = Integer.getInteger("rx.scheduler.jdk6.purge-frequency-millis", 1000).intValue();
  private static final boolean e;
  private static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> f = new ConcurrentHashMap();
  private static final AtomicReference<ScheduledExecutorService> g = new AtomicReference();
  volatile boolean a;
  private final ScheduledExecutorService c;
  private final f d;
  
  static
  {
    e = Boolean.getBoolean("rx.scheduler.jdk6.purge-force");
  }
  
  public b(ThreadFactory paramThreadFactory)
  {
    paramThreadFactory = Executors.newScheduledThreadPool(1, paramThreadFactory);
    if ((!b(paramThreadFactory)) && ((paramThreadFactory instanceof ScheduledThreadPoolExecutor))) {
      a((ScheduledThreadPoolExecutor)paramThreadFactory);
    }
    this.d = rx.e.d.a().d();
    this.c = paramThreadFactory;
  }
  
  public static void a(ScheduledExecutorService paramScheduledExecutorService)
  {
    f.remove(paramScheduledExecutorService);
  }
  
  public static void a(ScheduledThreadPoolExecutor paramScheduledThreadPoolExecutor)
  {
    if ((ScheduledExecutorService)g.get() != null) {}
    for (;;)
    {
      f.putIfAbsent(paramScheduledThreadPoolExecutor, paramScheduledThreadPoolExecutor);
      return;
      ScheduledExecutorService localScheduledExecutorService = Executors.newScheduledThreadPool(1, new h("RxSchedulerPurge-"));
      if (!g.compareAndSet(null, localScheduledExecutorService)) {
        break;
      }
      localScheduledExecutorService.scheduleAtFixedRate(new c(), b, b, TimeUnit.MILLISECONDS);
    }
  }
  
  static void b()
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = f.keySet().iterator();
        if (localIterator.hasNext())
        {
          ScheduledThreadPoolExecutor localScheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor)localIterator.next();
          if (!localScheduledThreadPoolExecutor.isShutdown()) {
            localScheduledThreadPoolExecutor.purge();
          }
        }
        else
        {
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        rx.a.b.a(localThrowable);
        rx.e.d.a().b().a(localThrowable);
      }
      localThrowable.remove();
    }
  }
  
  public static boolean b(ScheduledExecutorService paramScheduledExecutorService)
  {
    if (!e)
    {
      Method[] arrayOfMethod = paramScheduledExecutorService.getClass().getMethods();
      int j = arrayOfMethod.length;
      int i = 0;
      while (i < j)
      {
        Method localMethod = arrayOfMethod[i];
        if ((localMethod.getName().equals("setRemoveOnCancelPolicy")) && (localMethod.getParameterTypes().length == 1) && (localMethod.getParameterTypes()[0] == Boolean.TYPE)) {
          try
          {
            localMethod.invoke(paramScheduledExecutorService, new Object[] { Boolean.valueOf(true) });
            return true;
          }
          catch (Exception localException)
          {
            rx.e.d.a().b().a(localException);
          }
        }
        i += 1;
      }
    }
    return false;
  }
  
  public d a(rx.b.a parama, long paramLong, TimeUnit paramTimeUnit, m paramm)
  {
    d locald = new d(this.d.a(parama), paramm);
    paramm.a(locald);
    if (paramLong <= 0L) {}
    for (parama = this.c.submit(locald);; parama = this.c.schedule(locald, paramLong, paramTimeUnit))
    {
      locald.a(parama);
      return locald;
    }
  }
  
  public d a(rx.b.a parama, long paramLong, TimeUnit paramTimeUnit, rx.h.b paramb)
  {
    d locald = new d(this.d.a(parama), paramb);
    paramb.a(locald);
    if (paramLong <= 0L) {}
    for (parama = this.c.submit(locald);; parama = this.c.schedule(locald, paramLong, paramTimeUnit))
    {
      locald.a(parama);
      return locald;
    }
  }
  
  public l a(rx.b.a parama)
  {
    return a(parama, 0L, null);
  }
  
  public l a(rx.b.a parama, long paramLong, TimeUnit paramTimeUnit)
  {
    if (this.a) {
      return rx.h.d.b();
    }
    return b(parama, paramLong, paramTimeUnit);
  }
  
  public d b(rx.b.a parama, long paramLong, TimeUnit paramTimeUnit)
  {
    d locald = new d(this.d.a(parama));
    if (paramLong <= 0L) {}
    for (parama = this.c.submit(locald);; parama = this.c.schedule(locald, paramLong, paramTimeUnit))
    {
      locald.a(parama);
      return locald;
    }
  }
  
  public void c()
  {
    this.a = true;
    this.c.shutdownNow();
    a(this.c);
  }
  
  public boolean d()
  {
    return this.a;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\c\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */