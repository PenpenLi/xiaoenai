package com.adhoc;

import java.io.IOException;
import java.io.InterruptedIOException;

public class ek
  extends fh
{
  private static ek a;
  private boolean c;
  private ek d;
  private long e;
  
  private static void a(ek paramek, long paramLong, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (a == null)
        {
          a = new ek();
          new a().start();
        }
        long l = System.nanoTime();
        if ((paramLong != 0L) && (paramBoolean))
        {
          paramek.e = (Math.min(paramLong, paramek.d() - l) + l);
          paramLong = paramek.b(l);
          localek = a;
          if ((localek.d != null) && (paramLong >= localek.d.b(l))) {
            break label175;
          }
          paramek.d = localek.d;
          localek.d = paramek;
          if (localek == a) {
            ek.class.notify();
          }
          return;
        }
        if (paramLong != 0L)
        {
          paramek.e = (l + paramLong);
          continue;
        }
        if (!paramBoolean) {
          break label167;
        }
      }
      finally {}
      paramek.e = paramek.d();
      continue;
      label167:
      throw new AssertionError();
      label175:
      ek localek = localek.d;
    }
  }
  
  /* Error */
  private static boolean a(ek paramek)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 21	com/adhoc/ek:a	Lcom/adhoc/ek;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +39 -> 47
    //   11: aload_1
    //   12: getfield 48	com/adhoc/ek:d	Lcom/adhoc/ek;
    //   15: aload_0
    //   16: if_acmpne +23 -> 39
    //   19: aload_1
    //   20: aload_0
    //   21: getfield 48	com/adhoc/ek:d	Lcom/adhoc/ek;
    //   24: putfield 48	com/adhoc/ek:d	Lcom/adhoc/ek;
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 48	com/adhoc/ek:d	Lcom/adhoc/ek;
    //   32: iconst_0
    //   33: istore_2
    //   34: ldc 2
    //   36: monitorexit
    //   37: iload_2
    //   38: ireturn
    //   39: aload_1
    //   40: getfield 48	com/adhoc/ek:d	Lcom/adhoc/ek;
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
    //   0	58	0	paramek	ek
    //   6	38	1	localek	ek
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
  
  private static ek h()
  {
    ek localek1 = null;
    for (;;)
    {
      ek localek2;
      try
      {
        localek2 = a.d;
        if (localek2 == null)
        {
          ek.class.wait();
          return localek1;
        }
        long l1 = localek2.b(System.nanoTime());
        if (l1 > 0L)
        {
          long l2 = l1 / 1000000L;
          ek.class.wait(l2, (int)(l1 - 1000000L * l2));
          continue;
        }
        a.d = localek2.d;
      }
      finally {}
      localek2.d = null;
      Object localObject2 = localek2;
    }
  }
  
  public final ff a(ff paramff)
  {
    return new el(this, paramff);
  }
  
  public final fg a(fg paramfg)
  {
    return new em(this, paramfg);
  }
  
  protected void a() {}
  
  final void a(boolean paramBoolean)
  {
    if ((a_()) && (paramBoolean)) {
      throw new InterruptedIOException("timeout");
    }
  }
  
  public final boolean a_()
  {
    if (!this.c) {
      return false;
    }
    this.c = false;
    return a(this);
  }
  
  final IOException b(IOException paramIOException)
  {
    if (!a_()) {
      return paramIOException;
    }
    InterruptedIOException localInterruptedIOException = new InterruptedIOException("timeout");
    localInterruptedIOException.initCause(paramIOException);
    return localInterruptedIOException;
  }
  
  public final void c()
  {
    if (this.c) {
      throw new IllegalStateException("Unbalanced enter/exit");
    }
    long l = b_();
    boolean bool = c_();
    if ((l == 0L) && (!bool)) {
      return;
    }
    this.c = true;
    a(this, l, bool);
  }
  
  static final class a
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
          ek localek = ek.e();
          if (localek != null) {
            localek.a();
          }
        }
      }
      catch (Throwable localThrowable) {}
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\ek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */