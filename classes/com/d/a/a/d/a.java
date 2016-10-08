package com.d.a.a.d;

import com.d.a.a.e;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class a
{
  private int a;
  private int b;
  private int c;
  private final ThreadGroup d;
  private final a e;
  private final int f;
  private final AtomicInteger g = new AtomicInteger(0);
  private final ConcurrentHashMap<String, e> h;
  
  public a(com.d.a.a.b.a parama, a parama1)
  {
    this.c = parama.i();
    this.a = parama.f();
    this.b = parama.g();
    this.f = parama.d();
    this.e = parama1;
    this.d = new ThreadGroup("JobConsumers");
    this.h = new ConcurrentHashMap();
  }
  
  private String a(long paramLong, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(paramLong).append("_");
    if (paramBoolean) {}
    for (String str = "t";; str = "f") {
      return str;
    }
  }
  
  private void a(e parame)
  {
    this.h.put(c(parame), parame);
  }
  
  private boolean a(boolean paramBoolean)
  {
    boolean bool = false;
    for (;;)
    {
      synchronized (this.d)
      {
        int j = this.g.intValue();
        if (!paramBoolean) {
          break label195;
        }
        i = 1;
        i = j - i;
        if ((i >= this.b) && (this.c * i >= this.e.b() + this.h.size()))
        {
          if (com.d.a.a.e.b.a()) {
            com.d.a.a.e.b.a("%s: load factor check. %s = (%d < %d)|| (%d * %d < %d + %d). consumer thread: %s", new Object[] { Thread.currentThread().getName(), Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(this.b), Integer.valueOf(i), Integer.valueOf(this.c), Integer.valueOf(this.e.b()), Integer.valueOf(this.h.size()), Boolean.valueOf(paramBoolean) });
          }
          return bool;
        }
      }
      bool = true;
      continue;
      label195:
      int i = 0;
    }
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.e.a()) {
      if (paramBoolean1) {
        this.g.decrementAndGet();
      }
    }
    do
    {
      return false;
      synchronized (this.d)
      {
        if ((a(paramBoolean1)) && (d()))
        {
          if (paramBoolean2) {
            c();
          }
          return true;
        }
      }
    } while (!paramBoolean1);
    this.g.decrementAndGet();
    return false;
  }
  
  private void b(e parame)
  {
    this.h.remove(c(parame));
  }
  
  private boolean b()
  {
    return !a(true, false);
  }
  
  private String c(e parame)
  {
    return a(parame.a().longValue(), parame.h().a());
  }
  
  private void c()
  {
    com.d.a.a.e.b.a("adding another consumer", new Object[0]);
    synchronized (this.d)
    {
      Thread localThread = new Thread(this.d, new b(this.e, this));
      this.g.incrementAndGet();
      localThread.start();
      return;
    }
  }
  
  private boolean d()
  {
    for (;;)
    {
      synchronized (this.d)
      {
        if (this.g.intValue() < this.a)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void a()
  {
    a(false, true);
  }
  
  public static abstract interface a
  {
    public abstract e a(int paramInt, TimeUnit paramTimeUnit);
    
    public abstract void a(e parame);
    
    public abstract boolean a();
    
    public abstract int b();
    
    public abstract void b(e parame);
  }
  
  private static class b
    implements Runnable
  {
    private final a.a a;
    private final a b;
    private boolean c = false;
    
    public b(a.a parama, a parama1)
    {
      this.b = parama1;
      this.a = parama;
    }
    
    public void run()
    {
      try
      {
        if (com.d.a.a.e.b.a())
        {
          if (this.c) {
            break label154;
          }
          com.d.a.a.e.b.a("starting consumer %s", new Object[] { Thread.currentThread().getName() });
          this.c = true;
        }
        for (;;)
        {
          if (this.a.a())
          {
            e locale1 = this.a.a(a.a(this.b), TimeUnit.SECONDS);
            if (locale1 != null)
            {
              a.a(this.b, locale1);
              if (!locale1.a(locale1.d())) {
                break label219;
              }
              this.a.b(locale1);
              label101:
              a.b(this.b, locale1);
            }
            if (locale1 == null)
            {
              boolean bool = a.b(this.b);
              if (com.d.a.a.e.b.a())
              {
                if (!bool) {
                  break label232;
                }
                com.d.a.a.e.b.a("finishing consumer %s", new Object[] { Thread.currentThread().getName() });
              }
              label149:
              if (!bool) {
                break;
              }
              return;
              label154:
              com.d.a.a.e.b.a("re-running consumer %s", new Object[] { Thread.currentThread().getName() });
              continue;
              throw ((Throwable)localObject);
            }
          }
        }
      }
      finally
      {
        bool = a.b(this.b);
        if (com.d.a.a.e.b.a())
        {
          if (!bool) {
            break label253;
          }
          com.d.a.a.e.b.a("finishing consumer %s", new Object[] { Thread.currentThread().getName() });
        }
      }
      for (;;)
      {
        e locale2 = null;
        break;
        label219:
        this.a.a(locale2);
        break label101;
        label232:
        com.d.a.a.e.b.a("didn't allow me to die, re-running %s", new Object[] { Thread.currentThread().getName() });
        break label149;
        label253:
        com.d.a.a.e.b.a("didn't allow me to die, re-running %s", new Object[] { Thread.currentThread().getName() });
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\d\a\a\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */