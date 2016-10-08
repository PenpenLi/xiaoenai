package com.d.a.a;

import android.content.Context;
import com.d.a.a.h.a.d.b;
import com.d.a.a.h.a.d.c;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class f
  implements com.d.a.a.f.a.a
{
  private final long a;
  private boolean b;
  private final Context c;
  private final com.d.a.a.f.b d;
  private final com.d.a.a.c.a e;
  private final j f;
  private final j g;
  private final c h;
  private final com.d.a.a.d.a i;
  private final Object j = new Object();
  private final ConcurrentHashMap<Long, CountDownLatch> k;
  private final ConcurrentHashMap<Long, CountDownLatch> l;
  private final ScheduledExecutorService m;
  private final Object n = new Object();
  private final Runnable o = new g(this);
  private final com.d.a.a.d.a.a p = new h(this);
  
  public f(Context paramContext, com.d.a.a.b.a parama)
  {
    if (parama.h() != null) {
      com.d.a.a.e.b.a(parama.h());
    }
    this.c = paramContext.getApplicationContext();
    this.b = true;
    this.h = new c();
    this.a = System.nanoTime();
    this.f = parama.b().a(paramContext, Long.valueOf(this.a), parama.a());
    this.g = parama.b().b(paramContext, Long.valueOf(this.a), parama.a());
    this.k = new ConcurrentHashMap();
    this.l = new ConcurrentHashMap();
    this.d = parama.e();
    this.e = parama.c();
    if ((this.d instanceof com.d.a.a.f.a)) {
      ((com.d.a.a.f.a)this.d).a(this);
    }
    this.i = new com.d.a.a.d.a(parama, this.p);
    this.m = Executors.newSingleThreadScheduledExecutor();
    a();
  }
  
  private long a(Boolean arg1)
  {
    Boolean localBoolean = ???;
    boolean bool;
    if (??? == null)
    {
      if (!(this.d instanceof com.d.a.a.f.a)) {
        break label72;
      }
      bool = c();
    }
    Long localLong2;
    for (;;)
    {
      localBoolean = Boolean.valueOf(bool);
      synchronized (this.g)
      {
        localLong2 = this.g.a(localBoolean.booleanValue());
        if ((localLong2 != null) && (localLong2.longValue() <= System.nanoTime()))
        {
          b();
          return 0L;
          label72:
          bool = true;
        }
      }
    }
    for (;;)
    {
      synchronized (this.f)
      {
        Long localLong1 = this.f.a(((Boolean)localObject1).booleanValue());
        if (localLong1 == null) {
          break label156;
        }
        if (localLong2 == null)
        {
          ??? = localLong1;
          if (??? == null) {
            break label189;
          }
          if (???.longValue() >= System.nanoTime()) {
            break;
          }
          b();
          return 0L;
        }
      }
      ??? = (Boolean)localObject2;
      if (((Long)localObject2).longValue() >= localLong2.longValue()) {
        label156:
        ??? = localLong2;
      }
    }
    long l1 = Math.ceil((???.longValue() - System.nanoTime()) / 1000000.0D);
    a(l1);
    return l1;
    label189:
    return Long.MAX_VALUE;
  }
  
  private void a(long paramLong)
  {
    this.m.schedule(this.o, paramLong, TimeUnit.MILLISECONDS);
  }
  
  private void a(e parame)
  {
    com.d.a.a.e.b.a("re-adding job %s", new Object[] { parame.a() });
    if (parame.h().a()) {}
    for (;;)
    {
      synchronized (this.f)
      {
        this.f.b(parame);
        if (parame.i() != null) {
          this.h.b(parame.i());
        }
        return;
      }
      synchronized (this.g)
      {
        this.g.b(parame);
      }
    }
  }
  
  private void a(ConcurrentHashMap<Long, CountDownLatch> paramConcurrentHashMap, long paramLong)
  {
    paramConcurrentHashMap.put(Long.valueOf(paramLong), new CountDownLatch(1));
  }
  
  private int b(boolean paramBoolean)
  {
    int i1;
    synchronized (this.g)
    {
      i1 = this.g.a(paramBoolean, this.h.a());
    }
    synchronized (this.f)
    {
      int i2 = this.f.a(paramBoolean, this.h.a());
      return 0 + i1 + i2;
      localObject1 = finally;
      throw ((Throwable)localObject1);
    }
  }
  
  private void b()
  {
    synchronized (this.j)
    {
      this.j.notifyAll();
      this.i.a();
      return;
    }
  }
  
  private void b(e parame)
  {
    if (parame.h().a()) {}
    for (;;)
    {
      synchronized (this.f)
      {
        this.f.c(parame);
        if (parame.i() != null) {
          this.h.b(parame.i());
        }
        return;
      }
      synchronized (this.g)
      {
        this.g.c(parame);
      }
    }
  }
  
  private void b(ConcurrentHashMap<Long, CountDownLatch> paramConcurrentHashMap, long paramLong)
  {
    paramConcurrentHashMap = (CountDownLatch)paramConcurrentHashMap.get(Long.valueOf(paramLong));
    if (paramConcurrentHashMap == null) {
      return;
    }
    try
    {
      paramConcurrentHashMap.await();
      return;
    }
    catch (InterruptedException paramConcurrentHashMap)
    {
      com.d.a.a.e.b.a(paramConcurrentHashMap, "could not wait for onAdded lock", new Object[0]);
    }
  }
  
  private void c(ConcurrentHashMap<Long, CountDownLatch> paramConcurrentHashMap, long paramLong)
  {
    CountDownLatch localCountDownLatch = (CountDownLatch)paramConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localCountDownLatch != null) {
      localCountDownLatch.countDown();
    }
    paramConcurrentHashMap.remove(Long.valueOf(paramLong));
  }
  
  private boolean c()
  {
    return (this.d == null) || (this.d.a(this.c));
  }
  
  private e d()
  {
    boolean bool = c();
    Collection localCollection;
    e locale1;
    synchronized (this.n)
    {
      localCollection = this.h.a();
      synchronized (this.g)
      {
        locale1 = this.g.b(bool, localCollection);
        if (locale1 != null) {}
      }
    }
    for (;;)
    {
      synchronized (this.f)
      {
        locale1 = this.f.b(bool, localCollection);
        i1 = 1;
        if (locale1 == null)
        {
          return null;
          localObject1 = finally;
          throw ((Throwable)localObject1);
          localObject2 = finally;
          throw ((Throwable)localObject2);
        }
      }
      if ((i1 != 0) && (this.e != null)) {
        this.e.a(locale2.h());
      }
      if (locale2.i() != null) {
        this.h.a(locale2.i());
      }
      if (i1 != 0)
      {
        b(this.k, locale2.a().longValue());
        return locale2;
      }
      b(this.l, locale2.a().longValue());
      return locale2;
      int i1 = 0;
    }
  }
  
  @Deprecated
  public long a(int paramInt, long paramLong, b arg4)
  {
    long l1;
    e locale;
    if (paramLong > 0L)
    {
      l1 = 1000000L * paramLong + System.nanoTime();
      locale = new e(paramInt, ???, l1, Long.MIN_VALUE);
      if (!???.a()) {
        break label237;
      }
      synchronized (this.f)
      {
        l1 = this.f.a(locale);
        a(this.k, l1);
        if (com.d.a.a.e.b.a()) {
          com.d.a.a.e.b.a("added job id: %d class: %s priority: %d delay: %d group : %s persistent: %s requires network: %s", new Object[] { Long.valueOf(l1), ???.getClass().getSimpleName(), Integer.valueOf(paramInt), Long.valueOf(paramLong), ???.f(), Boolean.valueOf(???.a()), Boolean.valueOf(???.e()) });
        }
        if (this.e != null) {
          this.e.a(???);
        }
        locale.h().b();
        if (!???.a()) {}
      }
    }
    for (;;)
    {
      synchronized (this.f)
      {
        c(this.k, l1);
        b();
        return l1;
        l1 = Long.MIN_VALUE;
        break;
        ??? = finally;
        throw ???;
        label237:
        synchronized (this.g)
        {
          l1 = this.g.a(locale);
          a(this.l, l1);
        }
      }
      synchronized (this.g)
      {
        c(this.l, l1);
      }
    }
  }
  
  public long a(d paramd)
  {
    return a(paramd.h(), paramd.i(), paramd);
  }
  
  public void a()
  {
    if (this.b) {
      return;
    }
    this.b = true;
    b();
  }
  
  protected void a(int paramInt, long paramLong, b paramb, a parama)
  {
    long l1 = System.nanoTime();
    this.m.execute(new i(this, l1, paramInt, paramLong, paramb, parama));
  }
  
  public void a(boolean paramBoolean)
  {
    a(Boolean.valueOf(paramBoolean));
  }
  
  @Deprecated
  public void b(int paramInt, long paramLong, b paramb)
  {
    a(paramInt, paramLong, paramb, null);
  }
  
  public void b(d paramd)
  {
    b(paramd.h(), paramd.i(), paramd);
  }
  
  public static class a
    implements l
  {
    d.c a = new d.b();
    
    public j a(Context paramContext, Long paramLong, String paramString)
    {
      return new com.d.a.a.a.a(new com.d.a.a.h.a.d(paramContext, paramLong.longValue(), paramString, this.a));
    }
    
    public j b(Context paramContext, Long paramLong, String paramString)
    {
      return new com.d.a.a.a.a(new com.d.a.a.g.g(paramLong.longValue(), paramString));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\d\a\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */