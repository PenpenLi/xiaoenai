package b;

import b.a.j;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class t
{
  private int a = 64;
  private int b = 5;
  private ExecutorService c;
  private final Deque<aj.b> d = new ArrayDeque();
  private final Deque<aj.b> e = new ArrayDeque();
  private final Deque<aj> f = new ArrayDeque();
  
  private void b()
  {
    if (this.e.size() >= this.a) {}
    do
    {
      Iterator localIterator;
      do
      {
        return;
        while (this.d.isEmpty()) {}
        localIterator = this.d.iterator();
      } while (!localIterator.hasNext());
      aj.b localb = (aj.b)localIterator.next();
      if (c(localb) < this.b)
      {
        localIterator.remove();
        this.e.add(localb);
        a().execute(localb);
      }
    } while (this.e.size() < this.a);
  }
  
  private int c(aj.b paramb)
  {
    Iterator localIterator = this.e.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((aj.b)localIterator.next()).a().equals(paramb.a())) {
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
        this.c = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), j.a("OkHttp Dispatcher", false));
      }
      ExecutorService localExecutorService = this.c;
      return localExecutorService;
    }
    finally {}
  }
  
  /* Error */
  void a(aj.b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 30	b/t:e	Ljava/util/Deque;
    //   6: invokeinterface 39 1 0
    //   11: aload_0
    //   12: getfield 21	b/t:a	I
    //   15: if_icmpge +39 -> 54
    //   18: aload_0
    //   19: aload_1
    //   20: invokespecial 61	b/t:c	(Lb/aj$b;)I
    //   23: aload_0
    //   24: getfield 23	b/t:b	I
    //   27: if_icmpge +27 -> 54
    //   30: aload_0
    //   31: getfield 30	b/t:e	Ljava/util/Deque;
    //   34: aload_1
    //   35: invokeinterface 68 2 0
    //   40: pop
    //   41: aload_0
    //   42: invokevirtual 71	b/t:a	()Ljava/util/concurrent/ExecutorService;
    //   45: aload_1
    //   46: invokeinterface 77 2 0
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: aload_0
    //   55: getfield 28	b/t:d	Ljava/util/Deque;
    //   58: aload_1
    //   59: invokeinterface 68 2 0
    //   64: pop
    //   65: goto -14 -> 51
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	t
    //   0	73	1	paramb	aj.b
    // Exception table:
    //   from	to	target	type
    //   2	51	68	finally
    //   54	65	68	finally
  }
  
  void b(aj.b paramb)
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */