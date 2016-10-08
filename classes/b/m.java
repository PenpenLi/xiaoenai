package b;

import b.a.b.w;
import b.a.c.c;
import b.a.d;
import b.a.i;
import b.a.j;
import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public final class m
{
  private static final Executor d;
  final i a = new i();
  boolean b;
  private final int e;
  private final long f;
  private final Runnable g = new n(this);
  private final Deque<c> h = new ArrayDeque();
  
  static
  {
    if (!m.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      c = bool;
      d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), j.a("OkHttp ConnectionPool", true));
      return;
    }
  }
  
  public m()
  {
    this(5, 5L, TimeUnit.MINUTES);
  }
  
  public m(int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    this.e = paramInt;
    this.f = paramTimeUnit.toNanos(paramLong);
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("keepAliveDuration <= 0: " + paramLong);
    }
  }
  
  private int a(c paramc, long paramLong)
  {
    List localList = paramc.h;
    int i = 0;
    while (i < localList.size()) {
      if (((Reference)localList.get(i)).get() != null)
      {
        i += 1;
      }
      else
      {
        d.a.warning("A connection to " + paramc.a().a().a() + " was leaked. Did you forget to close a response body?");
        localList.remove(i);
        paramc.i = true;
        if (localList.isEmpty())
        {
          paramc.j = (paramLong - this.f);
          return 0;
        }
      }
    }
    return localList.size();
  }
  
  long a(long paramLong)
  {
    Object localObject1 = null;
    long l1 = Long.MIN_VALUE;
    for (;;)
    {
      int j;
      int i;
      try
      {
        Iterator localIterator = this.h.iterator();
        j = 0;
        i = 0;
        if (localIterator.hasNext())
        {
          c localc = (c)localIterator.next();
          if (a(localc, paramLong) > 0)
          {
            i += 1;
            continue;
          }
          long l2 = paramLong - localc.j;
          if (l2 <= l1) {
            break label182;
          }
          localObject1 = localc;
          l1 = l2;
          break label182;
        }
        if ((l1 >= this.f) || (j > this.e))
        {
          this.h.remove(localObject1);
          j.a(((c)localObject1).b());
          return 0L;
        }
        if (j > 0)
        {
          paramLong = this.f;
          return paramLong - l1;
        }
      }
      finally {}
      if (i > 0)
      {
        paramLong = this.f;
        return paramLong;
      }
      this.b = false;
      return -1L;
      label182:
      j += 1;
    }
  }
  
  c a(a parama, w paramw)
  {
    if ((!c) && (!Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if ((localc.h.size() < localc.g) && (parama.equals(localc.a().a)) && (!localc.i))
      {
        paramw.a(localc);
        return localc;
      }
    }
    return null;
  }
  
  void a(c paramc)
  {
    if ((!c) && (!Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    if (!this.b)
    {
      this.b = true;
      d.execute(this.g);
    }
    this.h.add(paramc);
  }
  
  boolean b(c paramc)
  {
    if ((!c) && (!Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    if ((paramc.i) || (this.e == 0))
    {
      this.h.remove(paramc);
      return true;
    }
    notifyAll();
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */