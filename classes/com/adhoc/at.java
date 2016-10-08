package com.adhoc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class at
{
  private static final at a;
  private final int b;
  private final long c;
  private final LinkedList<as> d = new LinkedList();
  private Executor e = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), cb.a("OkHttp ConnectionPool", true));
  private final Runnable f = new au(this);
  
  static
  {
    String str1 = System.getProperty("http.keepAlive");
    String str2 = System.getProperty("http.keepAliveDuration");
    String str3 = System.getProperty("http.maxConnections");
    if (str2 != null) {}
    for (long l = Long.parseLong(str2); (str1 != null) && (!Boolean.parseBoolean(str1)); l = 300000L)
    {
      a = new at(0, l);
      return;
    }
    if (str3 != null)
    {
      a = new at(Integer.parseInt(str3), l);
      return;
    }
    a = new at(5, l);
  }
  
  public at(int paramInt, long paramLong)
  {
    this.b = paramInt;
    this.c = (paramLong * 1000L * 1000L);
  }
  
  public static at a()
  {
    return a;
  }
  
  private void c()
  {
    while (b()) {}
  }
  
  private void c(as paramas)
  {
    boolean bool = this.d.isEmpty();
    this.d.addFirst(paramas);
    if (bool)
    {
      this.e.execute(this.f);
      return;
    }
    notifyAll();
  }
  
  public as a(ag paramag)
  {
    for (;;)
    {
      try
      {
        ListIterator localListIterator = this.d.listIterator(this.d.size());
        if (localListIterator.hasPrevious())
        {
          as localas2 = (as)localListIterator.previous();
          if ((localas2.c().a().equals(paramag)) && (localas2.e()) && (System.nanoTime() - localas2.i() < this.c))
          {
            localListIterator.remove();
            boolean bool = localas2.k();
            as localas1 = localas2;
            if (!bool) {}
            try
            {
              bz.a().a(localas2.d());
              localas1 = localas2;
              if ((localas1 != null) && (localas1.k())) {
                this.d.addFirst(localas1);
              }
              return localas1;
            }
            catch (Throwable localThrowable)
            {
              cb.a(localas2.d());
              bz.a().a("Unable to tagSocket(): " + localThrowable);
            }
          }
        }
        else
        {
          Object localObject = null;
        }
      }
      finally {}
    }
  }
  
  void a(as paramas)
  {
    if (paramas.k()) {}
    while (!paramas.a()) {
      return;
    }
    if (!paramas.e())
    {
      cb.a(paramas.d());
      return;
    }
    try
    {
      bz.a().b(paramas.d());
      try
      {
        c(paramas);
        paramas.m();
        paramas.g();
        return;
      }
      finally {}
      return;
    }
    catch (Throwable localThrowable)
    {
      bz.a().a("Unable to untagSocket(): " + localThrowable);
      cb.a(paramas.d());
    }
  }
  
  void b(as paramas)
  {
    if (!paramas.k()) {
      throw new IllegalArgumentException();
    }
    if (!paramas.e()) {
      return;
    }
    try
    {
      c(paramas);
      return;
    }
    finally {}
  }
  
  boolean b()
  {
    label310:
    label313:
    label316:
    label319:
    for (;;)
    {
      try
      {
        if (this.d.isEmpty()) {
          return false;
        }
        ArrayList localArrayList = new ArrayList();
        i = 0;
        l2 = System.nanoTime();
        l1 = this.c;
        ListIterator localListIterator = this.d.listIterator(this.d.size());
        as localas;
        if (localListIterator.hasPrevious())
        {
          localas = (as)localListIterator.previous();
          long l3 = localas.i() + this.c - l2;
          if ((l3 <= 0L) || (!localas.e()))
          {
            localListIterator.remove();
            localArrayList.add(localas);
            break label316;
          }
          if (!localas.h()) {
            break label313;
          }
          l1 = Math.min(l1, l3);
          i += 1;
          break label316;
        }
        localListIterator = this.d.listIterator(this.d.size());
        if ((localListIterator.hasPrevious()) && (i > this.b))
        {
          localas = (as)localListIterator.previous();
          if (!localas.h()) {
            break label310;
          }
          localArrayList.add(localas);
          localListIterator.remove();
          i -= 1;
          break label319;
        }
        boolean bool = localArrayList.isEmpty();
        if (!bool) {}
      }
      finally
      {
        try
        {
          long l1;
          long l2 = l1 / 1000000L;
          wait(l2, (int)(l1 - 1000000L * l2));
          return true;
        }
        catch (Throwable localThrowable) {}
        localObject = finally;
      }
      int j = ((List)localObject).size();
      int i = 0;
      while (i < j)
      {
        cb.a(((as)((List)localObject).get(i)).d());
        i += 1;
      }
      return true;
      break label319;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */