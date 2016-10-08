package com.adhoc;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ay
{
  private int a = 64;
  private int b = 5;
  private ExecutorService c;
  private final Deque<al.b> d = new ArrayDeque();
  private final Deque<al.b> e = new ArrayDeque();
  private final Deque<al> f = new ArrayDeque();
  
  private void b()
  {
    try
    {
      if (this.e.size() >= this.a) {
        return;
      }
      if (!this.d.isEmpty())
      {
        Iterator localIterator = this.d.iterator();
        while (localIterator.hasNext())
        {
          al.b localb = (al.b)localIterator.next();
          if (c(localb) < this.b)
          {
            localIterator.remove();
            this.e.add(localb);
            a().execute(localb);
          }
          int i = this.e.size();
          int j = this.a;
          if (i >= j) {}
        }
      }
    }
    catch (Throwable localThrowable)
    {
      fl.a(localThrowable);
    }
  }
  
  private int c(al.b paramb)
  {
    Iterator localIterator = this.e.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((al.b)localIterator.next()).a().equals(paramb.a())) {
        break label52;
      }
      i += 1;
    }
    label52:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public ExecutorService a()
  {
    try
    {
      if (this.c == null) {
        this.c = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), cb.a("OkHttp Dispatcher", false));
      }
      ExecutorService localExecutorService = this.c;
      return localExecutorService;
    }
    finally {}
  }
  
  void a(al.b paramb)
  {
    try
    {
      if ((this.e.size() < this.a) && (c(paramb) < this.b))
      {
        this.e.add(paramb);
        a().execute(paramb);
      }
      for (;;)
      {
        return;
        this.d.add(paramb);
      }
    }
    catch (Throwable paramb)
    {
      for (;;)
      {
        fl.a(paramb);
      }
    }
    finally {}
  }
  
  void b(al.b paramb)
  {
    try
    {
      if (!this.e.remove(paramb)) {
        throw new AssertionError("AsyncCall wasn't running!");
      }
    }
    finally {}
    b();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */