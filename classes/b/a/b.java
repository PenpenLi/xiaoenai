package b.a;

import b.a.c.a;
import c.g;
import c.y;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

public final class b
  implements Closeable, Flushable
{
  static final Pattern a;
  private static final y p;
  private final a c;
  private long d;
  private final int e;
  private long f;
  private g g;
  private final LinkedHashMap<String, b> h;
  private int i;
  private boolean j;
  private boolean k;
  private boolean l;
  private long m;
  private final Executor n;
  private final Runnable o;
  
  static
  {
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      a = Pattern.compile("[a-z0-9_-]{1,120}");
      p = new c();
      return;
    }
  }
  
  private void a(a parama, boolean paramBoolean)
  {
    int i3 = 0;
    b localb;
    try
    {
      localb = a.a(parama);
      if (b.a(localb) != parama) {
        throw new IllegalStateException();
      }
    }
    finally {}
    int i2 = i3;
    if (paramBoolean)
    {
      i2 = i3;
      if (!b.f(localb))
      {
        int i1 = 0;
        for (;;)
        {
          i2 = i3;
          if (i1 >= this.e) {
            break;
          }
          if (a.b(parama)[i1] == 0)
          {
            parama.a();
            throw new IllegalStateException("Newly created entry didn't create value for index " + i1);
          }
          if (!this.c.b(b.d(localb)[i1]))
          {
            parama.a();
            return;
          }
          i1 += 1;
        }
      }
    }
    for (;;)
    {
      long l1;
      if (i2 < this.e)
      {
        parama = b.d(localb)[i2];
        if (paramBoolean)
        {
          if (this.c.b(parama))
          {
            File localFile = b.c(localb)[i2];
            this.c.a(parama, localFile);
            l1 = b.b(localb)[i2];
            long l2 = this.c.c(localFile);
            b.b(localb)[i2] = l2;
            this.f = (this.f - l1 + l2);
          }
        }
        else {
          this.c.a(parama);
        }
      }
      else
      {
        this.i += 1;
        b.a(localb, null);
        if ((b.f(localb) | paramBoolean))
        {
          b.a(localb, true);
          this.g.b("CLEAN").h(32);
          this.g.b(b.e(localb));
          localb.a(this.g);
          this.g.h(10);
          if (paramBoolean)
          {
            l1 = this.m;
            this.m = (1L + l1);
            b.a(localb, l1);
          }
        }
        for (;;)
        {
          this.g.flush();
          if ((this.f <= this.d) && (!b())) {
            break;
          }
          this.n.execute(this.o);
          break;
          this.h.remove(b.e(localb));
          this.g.b("REMOVE").h(32);
          this.g.b(b.e(localb));
          this.g.h(10);
        }
      }
      i2 += 1;
    }
  }
  
  private boolean a(b paramb)
  {
    if (b.a(paramb) != null) {
      a.a(b.a(paramb), true);
    }
    int i1 = 0;
    while (i1 < this.e)
    {
      this.c.a(b.c(paramb)[i1]);
      this.f -= b.b(paramb)[i1];
      b.b(paramb)[i1] = 0L;
      i1 += 1;
    }
    this.i += 1;
    this.g.b("REMOVE").h(32).b(b.e(paramb)).h(10);
    this.h.remove(b.e(paramb));
    if (b()) {
      this.n.execute(this.o);
    }
    return true;
  }
  
  private boolean b()
  {
    return (this.i >= 2000) && (this.i >= this.h.size());
  }
  
  private void c()
  {
    try
    {
      if (a()) {
        throw new IllegalStateException("cache is closed");
      }
    }
    finally {}
  }
  
  private void d()
  {
    while (this.f > this.d) {
      a((b)this.h.values().iterator().next());
    }
    this.l = false;
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.k;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void close()
  {
    for (;;)
    {
      try
      {
        if ((!this.j) || (this.k))
        {
          this.k = true;
          return;
        }
        b[] arrayOfb = (b[])this.h.values().toArray(new b[this.h.size()]);
        int i2 = arrayOfb.length;
        int i1 = 0;
        if (i1 < i2)
        {
          b localb = arrayOfb[i1];
          if (b.a(localb) != null) {
            b.a(localb).a();
          }
        }
        else
        {
          d();
          this.g.close();
          this.g = null;
          this.k = true;
          continue;
        }
        i1 += 1;
      }
      finally {}
    }
  }
  
  /* Error */
  public void flush()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 229	b/a/b:j	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokespecial 241	b/a/b:c	()V
    //   18: aload_0
    //   19: invokespecial 237	b/a/b:d	()V
    //   22: aload_0
    //   23: getfield 142	b/a/b:g	Lc/g;
    //   26: invokeinterface 166 1 0
    //   31: goto -20 -> 11
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	b
    //   34	4	1	localObject	Object
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	34	finally
    //   14	31	34	finally
  }
  
  public final class a
  {
    private final b.b b;
    private final boolean[] c;
    private boolean d;
    
    public void a()
    {
      synchronized (this.a)
      {
        b.a(this.a, this, false);
        return;
      }
    }
  }
  
  private final class b
  {
    private final String a;
    private final long[] b;
    private final File[] c;
    private final File[] d;
    private boolean e;
    private b.a f;
    private long g;
    
    void a(g paramg)
    {
      long[] arrayOfLong = this.b;
      int j = arrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        long l = arrayOfLong[i];
        paramg.h(32).k(l);
        i += 1;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */