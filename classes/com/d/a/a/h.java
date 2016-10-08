package com.d.a.a;

import com.d.a.a.d.a.a;
import com.d.a.a.e.b;
import com.d.a.a.f.a;
import java.util.concurrent.TimeUnit;

class h
  implements a.a
{
  h(f paramf) {}
  
  public e a(int paramInt, TimeUnit paramTimeUnit)
  {
    ??? = f.c(this.a);
    if (??? != null) {
      return (e)???;
    }
    long l1 = System.nanoTime() + paramTimeUnit.toNanos(paramInt);
    long l2 = f.a(this.a, null);
    paramTimeUnit = (TimeUnit)???;
    label240:
    for (;;)
    {
      ??? = paramTimeUnit;
      if (paramTimeUnit != null) {
        break;
      }
      ??? = paramTimeUnit;
      if (l1 <= System.nanoTime()) {
        break;
      }
      if (f.b(this.a)) {
        paramTimeUnit = f.c(this.a);
      }
      for (;;)
      {
        if (paramTimeUnit == null)
        {
          long l3 = l1 - System.nanoTime();
          if (l3 <= 0L) {
            break label240;
          }
          l3 = Math.min(l2, TimeUnit.NANOSECONDS.toMillis(l3));
          if (l3 < 1L)
          {
            break;
            paramTimeUnit = null;
            continue;
          }
          if ((f.d(this.a) instanceof a)) {
            synchronized (f.e(this.a))
            {
              try
              {
                f.e(this.a).wait(l3);
              }
              catch (InterruptedException localInterruptedException1)
              {
                for (;;)
                {
                  b.a(localInterruptedException1, "exception while waiting for a new job.", new Object[0]);
                }
              }
            }
          }
          try
          {
            synchronized (f.e(this.a))
            {
              f.e(this.a).wait(Math.min(500L, l3));
            }
          }
          catch (InterruptedException localInterruptedException2)
          {
            for (;;)
            {
              b.a(localInterruptedException2, "exception while waiting for a new job.", new Object[0]);
            }
          }
        }
      }
    }
  }
  
  public void a(e parame)
  {
    f.a(this.a, parame);
  }
  
  public boolean a()
  {
    return f.b(this.a);
  }
  
  public int b()
  {
    f localf = this.a;
    if ((f.d(this.a) instanceof a)) {}
    for (boolean bool = f.f(this.a);; bool = true) {
      return f.a(localf, bool);
    }
  }
  
  public void b(e parame)
  {
    f.b(this.a, parame);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\d\a\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */