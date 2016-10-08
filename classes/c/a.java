package c;

import java.io.IOException;
import java.io.InterruptedIOException;

public class a
  extends aa
{
  private static a a;
  private boolean c;
  private a d;
  private long e;
  
  private static void a(a parama, long paramLong, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (a == null)
        {
          a = new a();
          new a().start();
        }
        long l = System.nanoTime();
        if ((paramLong != 0L) && (paramBoolean))
        {
          parama.e = (Math.min(paramLong, parama.d() - l) + l);
          paramLong = parama.b(l);
          locala = a;
          if ((locala.d != null) && (paramLong >= locala.d.b(l))) {
            break label175;
          }
          parama.d = locala.d;
          locala.d = parama;
          if (locala == a) {
            a.class.notify();
          }
          return;
        }
        if (paramLong != 0L)
        {
          parama.e = (l + paramLong);
          continue;
        }
        if (!paramBoolean) {
          break label167;
        }
      }
      finally {}
      parama.e = parama.d();
      continue;
      label167:
      throw new AssertionError();
      label175:
      a locala = locala.d;
    }
  }
  
  /* Error */
  private static boolean a(a parama)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 21	c/a:a	Lc/a;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +39 -> 47
    //   11: aload_1
    //   12: getfield 48	c/a:d	Lc/a;
    //   15: aload_0
    //   16: if_acmpne +23 -> 39
    //   19: aload_1
    //   20: aload_0
    //   21: getfield 48	c/a:d	Lc/a;
    //   24: putfield 48	c/a:d	Lc/a;
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 48	c/a:d	Lc/a;
    //   32: iconst_0
    //   33: istore_2
    //   34: ldc 2
    //   36: monitorexit
    //   37: iload_2
    //   38: ireturn
    //   39: aload_1
    //   40: getfield 48	c/a:d	Lc/a;
    //   43: astore_1
    //   44: goto -37 -> 7
    //   47: iconst_1
    //   48: istore_2
    //   49: goto -15 -> 34
    //   52: astore_0
    //   53: ldc 2
    //   55: monitorexit
    //   56: aload_0
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	parama	a
    //   6	38	1	locala	a
    //   33	16	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	7	52	finally
    //   11	32	52	finally
    //   39	44	52	finally
  }
  
  private long b(long paramLong)
  {
    return this.e - paramLong;
  }
  
  private static a h()
  {
    a locala1 = null;
    for (;;)
    {
      a locala2;
      try
      {
        locala2 = a.d;
        if (locala2 == null)
        {
          a.class.wait();
          return locala1;
        }
        long l1 = locala2.b(System.nanoTime());
        if (l1 > 0L)
        {
          long l2 = l1 / 1000000L;
          a.class.wait(l2, (int)(l1 - 1000000L * l2));
          continue;
        }
        a.d = locala2.d;
      }
      finally {}
      locala2.d = null;
      Object localObject2 = locala2;
    }
  }
  
  public final y a(y paramy)
  {
    return new b(this, paramy);
  }
  
  public final z a(z paramz)
  {
    return new c(this, paramz);
  }
  
  protected IOException a(IOException paramIOException)
  {
    InterruptedIOException localInterruptedIOException = new InterruptedIOException("timeout");
    if (paramIOException != null) {
      localInterruptedIOException.initCause(paramIOException);
    }
    return localInterruptedIOException;
  }
  
  protected void a() {}
  
  final void a(boolean paramBoolean)
  {
    if ((n_()) && (paramBoolean)) {
      throw a(null);
    }
  }
  
  final IOException b(IOException paramIOException)
  {
    if (!n_()) {
      return paramIOException;
    }
    return a(paramIOException);
  }
  
  public final void c()
  {
    if (this.c) {
      throw new IllegalStateException("Unbalanced enter/exit");
    }
    long l = o_();
    boolean bool = p_();
    if ((l == 0L) && (!bool)) {
      return;
    }
    this.c = true;
    a(this, l, bool);
  }
  
  public final boolean n_()
  {
    if (!this.c) {
      return false;
    }
    this.c = false;
    return a(this);
  }
  
  private static final class a
    extends Thread
  {
    public a()
    {
      super();
      setDaemon(true);
    }
    
    public void run()
    {
      try
      {
        for (;;)
        {
          a locala = a.e();
          if (locala != null) {
            locala.a();
          }
        }
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */