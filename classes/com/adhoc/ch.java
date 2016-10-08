package com.adhoc;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ch
  implements Closeable
{
  private static final ExecutorService l;
  final bi a;
  final boolean b;
  long c = 0L;
  long d;
  final dg e = new dg();
  final dg f = new dg();
  final di g;
  final Socket h;
  final cg i;
  final b j;
  private final cy m;
  private final Map<Integer, cr> n = new HashMap();
  private final String o;
  private int p;
  private int q;
  private boolean r;
  private long s = System.nanoTime();
  private final ExecutorService t;
  private Map<Integer, dd> u;
  private final de v;
  private int w;
  private boolean x = false;
  private final Set<Integer> y = new LinkedHashSet();
  
  static
  {
    if (!ch.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      k = bool;
      l = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), cb.a("OkHttp FramedConnection", true));
      return;
    }
  }
  
  private ch(a parama)
  {
    this.a = a.a(parama);
    this.v = a.b(parama);
    this.b = a.c(parama);
    this.m = a.d(parama);
    int i1;
    if (a.c(parama))
    {
      i1 = 1;
      this.q = i1;
      if ((a.c(parama)) && (this.a == bi.d)) {
        this.q += 2;
      }
      i1 = i2;
      if (a.c(parama)) {
        i1 = 1;
      }
      this.w = i1;
      if (a.c(parama)) {
        this.e.a(7, 0, 16777216);
      }
      this.o = a.e(parama);
      if (this.a != bi.d) {
        break label359;
      }
      this.g = new cw();
      this.t = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), cb.a(String.format("OkHttp %s Push Observer", new Object[] { this.o }), true));
      this.f.a(7, 0, 65535);
      this.f.a(5, 0, 16384);
    }
    for (;;)
    {
      this.d = this.f.e(65536);
      this.h = a.f(parama);
      this.i = this.g.a(ex.a(ex.a(a.f(parama))), this.b);
      this.j = new b(null);
      new Thread(this.j).start();
      return;
      i1 = 2;
      break;
      label359:
      if (this.a != bi.c) {
        break label388;
      }
      this.g = new dh();
      this.t = null;
    }
    label388:
    throw new AssertionError(this.a);
  }
  
  private cr a(int paramInt, List<ct> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!paramBoolean1)
    {
      bool1 = true;
      if (paramBoolean2) {
        break label64;
      }
    }
    label64:
    for (paramBoolean2 = bool2;; paramBoolean2 = false)
    {
      synchronized (this.i)
      {
        try
        {
          if (!this.r) {
            break label70;
          }
          throw new IOException("shutdown");
        }
        finally {}
      }
      bool1 = false;
      break;
    }
    label70:
    int i1 = this.q;
    this.q += 2;
    cr localcr = new cr(i1, this, bool1, paramBoolean2, paramList);
    if (localcr.b())
    {
      this.n.put(Integer.valueOf(i1), localcr);
      a(false);
    }
    if (paramInt == 0) {
      this.i.a(bool1, paramBoolean2, i1, paramInt, paramList);
    }
    for (;;)
    {
      if (!paramBoolean1) {
        this.i.b();
      }
      return localcr;
      if (this.b) {
        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
      }
      this.i.a(paramInt, i1, paramList);
    }
  }
  
  private void a(int paramInt1, eq parameq, int paramInt2, boolean paramBoolean)
  {
    eo localeo = new eo();
    parameq.a(paramInt2);
    parameq.a(localeo, paramInt2);
    if (localeo.b() != paramInt2) {
      throw new IOException(localeo.b() + " != " + paramInt2);
    }
    this.t.execute(new cn(this, "OkHttp %s Push Data[%s]", new Object[] { this.o, Integer.valueOf(paramInt1) }, paramInt1, localeo, paramInt2, paramBoolean));
  }
  
  private void a(int paramInt, List<ct> paramList)
  {
    try
    {
      if (this.y.contains(Integer.valueOf(paramInt)))
      {
        a(paramInt, ce.b);
        return;
      }
      this.y.add(Integer.valueOf(paramInt));
      this.t.execute(new cl(this, "OkHttp %s Push Request[%s]", new Object[] { this.o, Integer.valueOf(paramInt) }, paramInt, paramList));
      return;
    }
    finally {}
  }
  
  private void a(int paramInt, List<ct> paramList, boolean paramBoolean)
  {
    this.t.execute(new cm(this, "OkHttp %s Push Headers[%s]", new Object[] { this.o, Integer.valueOf(paramInt) }, paramInt, paramList, paramBoolean));
  }
  
  /* Error */
  private void a(ce paramce1, ce paramce2)
  {
    // Byte code:
    //   0: getstatic 63	com/adhoc/ch:k	Z
    //   3: ifne +18 -> 21
    //   6: aload_0
    //   7: invokestatic 365	java/lang/Thread:holdsLock	(Ljava/lang/Object;)Z
    //   10: ifeq +11 -> 21
    //   13: new 225	java/lang/AssertionError
    //   16: dup
    //   17: invokespecial 366	java/lang/AssertionError:<init>	()V
    //   20: athrow
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 369	com/adhoc/ch:a	(Lcom/adhoc/ce;)V
    //   26: aconst_null
    //   27: astore_1
    //   28: aload_0
    //   29: monitorenter
    //   30: aload_0
    //   31: getfield 99	com/adhoc/ch:n	Ljava/util/Map;
    //   34: invokeinterface 372 1 0
    //   39: ifne +246 -> 285
    //   42: aload_0
    //   43: getfield 99	com/adhoc/ch:n	Ljava/util/Map;
    //   46: invokeinterface 376 1 0
    //   51: aload_0
    //   52: getfield 99	com/adhoc/ch:n	Ljava/util/Map;
    //   55: invokeinterface 380 1 0
    //   60: anewarray 243	com/adhoc/cr
    //   63: invokeinterface 386 2 0
    //   68: checkcast 388	[Lcom/adhoc/cr;
    //   71: astore 4
    //   73: aload_0
    //   74: getfield 99	com/adhoc/ch:n	Ljava/util/Map;
    //   77: invokeinterface 391 1 0
    //   82: aload_0
    //   83: iconst_0
    //   84: invokespecial 263	com/adhoc/ch:a	(Z)V
    //   87: aload_0
    //   88: getfield 393	com/adhoc/ch:u	Ljava/util/Map;
    //   91: ifnull +188 -> 279
    //   94: aload_0
    //   95: getfield 393	com/adhoc/ch:u	Ljava/util/Map;
    //   98: invokeinterface 376 1 0
    //   103: aload_0
    //   104: getfield 393	com/adhoc/ch:u	Ljava/util/Map;
    //   107: invokeinterface 380 1 0
    //   112: anewarray 395	com/adhoc/dd
    //   115: invokeinterface 386 2 0
    //   120: checkcast 397	[Lcom/adhoc/dd;
    //   123: astore 5
    //   125: aload_0
    //   126: aconst_null
    //   127: putfield 393	com/adhoc/ch:u	Ljava/util/Map;
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_1
    //   133: astore_3
    //   134: aload 4
    //   136: ifnull +67 -> 203
    //   139: aload 4
    //   141: arraylength
    //   142: istore 8
    //   144: iconst_0
    //   145: istore 7
    //   147: iload 7
    //   149: iload 8
    //   151: if_icmpge +50 -> 201
    //   154: aload 4
    //   156: iload 7
    //   158: aaload
    //   159: astore_3
    //   160: aload_3
    //   161: aload_2
    //   162: invokevirtual 398	com/adhoc/cr:a	(Lcom/adhoc/ce;)V
    //   165: aload_1
    //   166: astore_3
    //   167: iload 7
    //   169: iconst_1
    //   170: iadd
    //   171: istore 7
    //   173: aload_3
    //   174: astore_1
    //   175: goto -28 -> 147
    //   178: astore_1
    //   179: goto -151 -> 28
    //   182: astore_1
    //   183: aload_0
    //   184: monitorexit
    //   185: aload_1
    //   186: athrow
    //   187: astore 6
    //   189: aload_1
    //   190: astore_3
    //   191: aload_1
    //   192: ifnull -25 -> 167
    //   195: aload 6
    //   197: astore_3
    //   198: goto -31 -> 167
    //   201: aload_1
    //   202: astore_3
    //   203: aload 5
    //   205: ifnull +35 -> 240
    //   208: aload 5
    //   210: arraylength
    //   211: istore 8
    //   213: iconst_0
    //   214: istore 7
    //   216: iload 7
    //   218: iload 8
    //   220: if_icmpge +20 -> 240
    //   223: aload 5
    //   225: iload 7
    //   227: aaload
    //   228: invokevirtual 400	com/adhoc/dd:c	()V
    //   231: iload 7
    //   233: iconst_1
    //   234: iadd
    //   235: istore 7
    //   237: goto -21 -> 216
    //   240: aload_0
    //   241: getfield 205	com/adhoc/ch:i	Lcom/adhoc/cg;
    //   244: invokeinterface 403 1 0
    //   249: aload_3
    //   250: astore_1
    //   251: aload_0
    //   252: getfield 190	com/adhoc/ch:h	Ljava/net/Socket;
    //   255: invokevirtual 406	java/net/Socket:close	()V
    //   258: aload_1
    //   259: ifnull +15 -> 274
    //   262: aload_1
    //   263: athrow
    //   264: astore_1
    //   265: aload_3
    //   266: ifnull -15 -> 251
    //   269: aload_3
    //   270: astore_1
    //   271: goto -20 -> 251
    //   274: return
    //   275: astore_1
    //   276: goto -18 -> 258
    //   279: aconst_null
    //   280: astore 5
    //   282: goto -152 -> 130
    //   285: aconst_null
    //   286: astore 4
    //   288: goto -201 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	291	0	this	ch
    //   0	291	1	paramce1	ce
    //   0	291	2	paramce2	ce
    //   133	137	3	localObject	Object
    //   71	216	4	arrayOfcr	cr[]
    //   123	158	5	arrayOfdd	dd[]
    //   187	9	6	localIOException	IOException
    //   145	91	7	i1	int
    //   142	79	8	i2	int
    // Exception table:
    //   from	to	target	type
    //   21	26	178	java/io/IOException
    //   30	87	182	finally
    //   87	130	182	finally
    //   130	132	182	finally
    //   183	185	182	finally
    //   160	165	187	java/io/IOException
    //   240	249	264	java/io/IOException
    //   251	258	275	java/io/IOException
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        l1 = System.nanoTime();
        this.s = l1;
        return;
      }
      finally {}
      long l1 = Long.MAX_VALUE;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2, dd paramdd)
  {
    l.execute(new ck(this, "OkHttp %s ping %08x%08x", new Object[] { this.o, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }, paramBoolean, paramInt1, paramInt2, paramdd));
  }
  
  private void b(boolean paramBoolean, int paramInt1, int paramInt2, dd paramdd)
  {
    cg localcg = this.i;
    if (paramdd != null) {}
    try
    {
      paramdd.a();
      this.i.a(paramBoolean, paramInt1, paramInt2);
      return;
    }
    finally {}
  }
  
  /* Error */
  private dd c(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 393	com/adhoc/ch:u	Ljava/util/Map;
    //   6: ifnull +24 -> 30
    //   9: aload_0
    //   10: getfield 393	com/adhoc/ch:u	Ljava/util/Map;
    //   13: iload_1
    //   14: invokestatic 254	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   17: invokeinterface 456 2 0
    //   22: checkcast 395	com/adhoc/dd
    //   25: astore_2
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: areturn
    //   30: aconst_null
    //   31: astore_2
    //   32: goto -6 -> 26
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	ch
    //   0	40	1	paramInt	int
    //   25	7	2	localdd	dd
    //   35	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	35	finally
  }
  
  private void c(int paramInt, ce paramce)
  {
    this.t.execute(new co(this, "OkHttp %s Push Reset[%s]", new Object[] { this.o, Integer.valueOf(paramInt) }, paramInt, paramce));
  }
  
  private boolean d(int paramInt)
  {
    return (this.a == bi.d) && (paramInt != 0) && ((paramInt & 0x1) == 0);
  }
  
  public bi a()
  {
    return this.a;
  }
  
  cr a(int paramInt)
  {
    try
    {
      cr localcr = (cr)this.n.get(Integer.valueOf(paramInt));
      return localcr;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public cr a(List<ct> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(0, paramList, paramBoolean1, paramBoolean2);
  }
  
  void a(int paramInt, long paramLong)
  {
    l.execute(new cj(this, "OkHttp Window Update %s stream %d", new Object[] { this.o, Integer.valueOf(paramInt) }, paramInt, paramLong));
  }
  
  void a(int paramInt, ce paramce)
  {
    l.submit(new ci(this, "OkHttp %s stream %d", new Object[] { this.o, Integer.valueOf(paramInt) }, paramInt, paramce));
  }
  
  public void a(int paramInt, boolean paramBoolean, eo parameo, long paramLong)
  {
    long l1 = paramLong;
    if (paramLong == 0L)
    {
      this.i.a(paramBoolean, paramInt, parameo, 0);
      return;
    }
    for (;;)
    {
      try
      {
        int i1 = Math.min((int)Math.min(l1, this.d), this.i.c());
        this.d -= i1;
        l1 -= i1;
        cg localcg = this.i;
        if ((!paramBoolean) || (l1 != 0L)) {
          break label170;
        }
        bool = true;
        localcg.a(bool, paramInt, parameo, i1);
        if (l1 <= 0L) {
          break;
        }
        try
        {
          if (this.d > 0L) {
            continue;
          }
          if (!this.n.containsKey(Integer.valueOf(paramInt))) {
            throw new IOException("stream closed");
          }
        }
        catch (InterruptedException parameo)
        {
          throw new InterruptedIOException();
        }
        wait();
      }
      finally {}
      continue;
      label170:
      boolean bool = false;
    }
  }
  
  void a(long paramLong)
  {
    this.d += paramLong;
    if (paramLong > 0L) {
      notifyAll();
    }
  }
  
  public void a(ce paramce)
  {
    int i1;
    synchronized (this.i) {}
  }
  
  cr b(int paramInt)
  {
    try
    {
      cr localcr = (cr)this.n.remove(Integer.valueOf(paramInt));
      if ((localcr != null) && (this.n.isEmpty())) {
        a(true);
      }
      notifyAll();
      return localcr;
    }
    finally {}
  }
  
  void b(int paramInt, ce paramce)
  {
    this.i.a(paramInt, paramce);
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 107	com/adhoc/ch:s	J
    //   6: lstore_2
    //   7: lload_2
    //   8: ldc2_w 426
    //   11: lcmp
    //   12: ifeq +11 -> 23
    //   15: iconst_1
    //   16: istore 4
    //   18: aload_0
    //   19: monitorexit
    //   20: iload 4
    //   22: ireturn
    //   23: iconst_0
    //   24: istore 4
    //   26: goto -8 -> 18
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	ch
    //   29	4	1	localObject	Object
    //   6	2	2	l1	long
    //   16	9	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	29	finally
  }
  
  public long c()
  {
    try
    {
      long l1 = this.s;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void close()
  {
    a(ce.a, ce.l);
  }
  
  public void d()
  {
    this.i.b();
  }
  
  public void e()
  {
    this.i.a();
    this.i.b(this.e);
    int i1 = this.e.e(65536);
    if (i1 != 65536) {
      this.i.a(0, i1 - 65536);
    }
  }
  
  public static class a
  {
    private String a;
    private Socket b;
    private cy c = cy.a;
    private bi d = bi.c;
    private de e = de.a;
    private boolean f;
    
    public a(String paramString, boolean paramBoolean, Socket paramSocket)
    {
      this.a = paramString;
      this.f = paramBoolean;
      this.b = paramSocket;
    }
    
    public a a(bi parambi)
    {
      this.d = parambi;
      return this;
    }
    
    public ch a()
    {
      return new ch(this, null);
    }
  }
  
  class b
    extends bv
    implements cf.a
  {
    cf a;
    
    private b()
    {
      super(new Object[] { ch.a(ch.this) });
    }
    
    private void a(dg paramdg)
    {
      ch.f().execute(new cq(this, "OkHttp %s ACK Settings", new Object[] { ch.a(ch.this) }, paramdg));
    }
    
    public void a() {}
    
    public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
    
    public void a(int paramInt1, int paramInt2, List<ct> paramList)
    {
      ch.a(ch.this, paramInt2, paramList);
    }
    
    public void a(int paramInt, long paramLong)
    {
      if (paramInt == 0) {
        synchronized (ch.this)
        {
          ch localch = ch.this;
          localch.d += paramLong;
          ch.this.notifyAll();
          return;
        }
      }
      ??? = ch.this.a(paramInt);
      if (??? != null) {
        try
        {
          ((cr)???).a(paramLong);
          return;
        }
        finally {}
      }
    }
    
    public void a(int paramInt, ce paramce)
    {
      if (ch.a(ch.this, paramInt)) {
        ch.a(ch.this, paramInt, paramce);
      }
      cr localcr;
      do
      {
        return;
        localcr = ch.this.b(paramInt);
      } while (localcr == null);
      localcr.c(paramce);
    }
    
    public void a(int paramInt, ce arg2, er paramer)
    {
      if (paramer.f() > 0) {}
      synchronized (ch.this)
      {
        paramer = (cr[])ch.e(ch.this).values().toArray(new cr[ch.e(ch.this).size()]);
        ch.b(ch.this, true);
        int j = paramer.length;
        int i = 0;
        if (i < j)
        {
          ??? = paramer[i];
          if ((???.a() > paramInt) && (???.c()))
          {
            ???.c(ce.k);
            ch.this.b(???.a());
          }
          i += 1;
        }
      }
    }
    
    public void a(boolean paramBoolean, int paramInt1, int paramInt2)
    {
      if (paramBoolean)
      {
        dd localdd = ch.c(ch.this, paramInt1);
        if (localdd != null) {
          localdd.b();
        }
        return;
      }
      ch.b(ch.this, true, paramInt1, paramInt2, null);
    }
    
    public void a(boolean paramBoolean, int paramInt1, eq parameq, int paramInt2)
    {
      if (ch.a(ch.this, paramInt1)) {
        ch.a(ch.this, paramInt1, parameq, paramInt2, paramBoolean);
      }
      cr localcr;
      do
      {
        return;
        localcr = ch.this.a(paramInt1);
        if (localcr == null)
        {
          ch.this.a(paramInt1, ce.c);
          parameq.g(paramInt2);
          return;
        }
        localcr.a(parameq, paramInt2);
      } while (!paramBoolean);
      localcr.h();
    }
    
    public void a(boolean paramBoolean, dg paramdg)
    {
      for (;;)
      {
        int i;
        synchronized (ch.this)
        {
          i = ch.this.f.e(65536);
          if (paramBoolean) {
            ch.this.f.a();
          }
          ch.this.f.a(paramdg);
          if (ch.this.a() == bi.d) {
            a(paramdg);
          }
          int j = ch.this.f.e(65536);
          if ((j == -1) || (j == i)) {
            break label245;
          }
          l = j - i;
          if (!ch.g(ch.this))
          {
            ch.this.a(l);
            ch.a(ch.this, true);
          }
          if (ch.e(ch.this).isEmpty()) {
            break label240;
          }
          paramdg = (cr[])ch.e(ch.this).values().toArray(new cr[ch.e(ch.this).size()]);
          if ((paramdg == null) || (l == 0L)) {
            break label239;
          }
          j = paramdg.length;
          i = 0;
          if (i >= j) {
            break label239;
          }
        }
        synchronized (paramdg[i])
        {
          ???.a(l);
          i += 1;
          continue;
          paramdg = finally;
          throw paramdg;
        }
        label239:
        return;
        label240:
        paramdg = null;
        continue;
        label245:
        paramdg = null;
        long l = 0L;
      }
    }
    
    public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, List<ct> paramList, cu paramcu)
    {
      if (ch.a(ch.this, paramInt1)) {
        ch.a(ch.this, paramInt1, paramList, paramBoolean2);
      }
      cr localcr;
      do
      {
        return;
        synchronized (ch.this)
        {
          if (ch.b(ch.this)) {
            return;
          }
        }
        localcr = ch.this.a(paramInt1);
        if (localcr == null)
        {
          if (paramcu.a())
          {
            ch.this.a(paramInt1, ce.c);
            return;
          }
          if (paramInt1 <= ch.c(ch.this)) {
            return;
          }
          if (paramInt1 % 2 == ch.d(ch.this) % 2) {
            return;
          }
          paramList = new cr(paramInt1, ch.this, paramBoolean1, paramBoolean2, paramList);
          ch.b(ch.this, paramInt1);
          ch.e(ch.this).put(Integer.valueOf(paramInt1), paramList);
          ch.f().execute(new cp(this, "OkHttp %s stream %d", new Object[] { ch.a(ch.this), Integer.valueOf(paramInt1) }, paramList));
          return;
        }
        if (paramcu.b())
        {
          localcr.b(ce.b);
          ch.this.b(paramInt1);
          return;
        }
        localcr.a(paramList, paramcu);
      } while (!paramBoolean2);
      localcr.h();
    }
    
    /* Error */
    protected void b()
    {
      // Byte code:
      //   0: getstatic 240	com/adhoc/ce:g	Lcom/adhoc/ce;
      //   3: astore_3
      //   4: getstatic 240	com/adhoc/ce:g	Lcom/adhoc/ce;
      //   7: astore 4
      //   9: aload_3
      //   10: astore_2
      //   11: aload_3
      //   12: astore_1
      //   13: aload_0
      //   14: aload_0
      //   15: getfield 17	com/adhoc/ch$b:c	Lcom/adhoc/ch;
      //   18: getfield 243	com/adhoc/ch:g	Lcom/adhoc/di;
      //   21: aload_0
      //   22: getfield 17	com/adhoc/ch$b:c	Lcom/adhoc/ch;
      //   25: getfield 246	com/adhoc/ch:h	Ljava/net/Socket;
      //   28: invokestatic 251	com/adhoc/ex:b	(Ljava/net/Socket;)Lcom/adhoc/fg;
      //   31: invokestatic 254	com/adhoc/ex:a	(Lcom/adhoc/fg;)Lcom/adhoc/eq;
      //   34: aload_0
      //   35: getfield 17	com/adhoc/ch$b:c	Lcom/adhoc/ch;
      //   38: getfield 257	com/adhoc/ch:b	Z
      //   41: invokeinterface 262 3 0
      //   46: putfield 264	com/adhoc/ch$b:a	Lcom/adhoc/cf;
      //   49: aload_3
      //   50: astore_2
      //   51: aload_3
      //   52: astore_1
      //   53: aload_0
      //   54: getfield 17	com/adhoc/ch$b:c	Lcom/adhoc/ch;
      //   57: getfield 257	com/adhoc/ch:b	Z
      //   60: ifne +16 -> 76
      //   63: aload_3
      //   64: astore_2
      //   65: aload_3
      //   66: astore_1
      //   67: aload_0
      //   68: getfield 264	com/adhoc/ch$b:a	Lcom/adhoc/cf;
      //   71: invokeinterface 267 1 0
      //   76: aload_3
      //   77: astore_2
      //   78: aload_3
      //   79: astore_1
      //   80: aload_0
      //   81: getfield 264	com/adhoc/ch$b:a	Lcom/adhoc/cf;
      //   84: aload_0
      //   85: invokeinterface 270 2 0
      //   90: ifne -14 -> 76
      //   93: aload_3
      //   94: astore_2
      //   95: aload_3
      //   96: astore_1
      //   97: getstatic 272	com/adhoc/ce:a	Lcom/adhoc/ce;
      //   100: astore_3
      //   101: aload_3
      //   102: astore_2
      //   103: aload_3
      //   104: astore_1
      //   105: getstatic 275	com/adhoc/ce:l	Lcom/adhoc/ce;
      //   108: astore 5
      //   110: aload_0
      //   111: getfield 17	com/adhoc/ch$b:c	Lcom/adhoc/ch;
      //   114: aload_3
      //   115: aload 5
      //   117: invokestatic 278	com/adhoc/ch:a	(Lcom/adhoc/ch;Lcom/adhoc/ce;Lcom/adhoc/ce;)V
      //   120: aload_0
      //   121: getfield 264	com/adhoc/ch$b:a	Lcom/adhoc/cf;
      //   124: invokestatic 283	com/adhoc/cb:a	(Ljava/io/Closeable;)V
      //   127: return
      //   128: astore_1
      //   129: aload_2
      //   130: astore_1
      //   131: getstatic 230	com/adhoc/ce:b	Lcom/adhoc/ce;
      //   134: astore_3
      //   135: getstatic 230	com/adhoc/ce:b	Lcom/adhoc/ce;
      //   138: astore_1
      //   139: aload_0
      //   140: getfield 17	com/adhoc/ch$b:c	Lcom/adhoc/ch;
      //   143: aload_3
      //   144: aload_1
      //   145: invokestatic 278	com/adhoc/ch:a	(Lcom/adhoc/ch;Lcom/adhoc/ce;Lcom/adhoc/ce;)V
      //   148: aload_0
      //   149: getfield 264	com/adhoc/ch$b:a	Lcom/adhoc/cf;
      //   152: invokestatic 283	com/adhoc/cb:a	(Ljava/io/Closeable;)V
      //   155: return
      //   156: astore_2
      //   157: aload_1
      //   158: astore_3
      //   159: aload_2
      //   160: astore_1
      //   161: aload_0
      //   162: getfield 17	com/adhoc/ch$b:c	Lcom/adhoc/ch;
      //   165: aload_3
      //   166: aload 4
      //   168: invokestatic 278	com/adhoc/ch:a	(Lcom/adhoc/ch;Lcom/adhoc/ce;Lcom/adhoc/ce;)V
      //   171: aload_0
      //   172: getfield 264	com/adhoc/ch$b:a	Lcom/adhoc/cf;
      //   175: invokestatic 283	com/adhoc/cb:a	(Ljava/io/Closeable;)V
      //   178: aload_1
      //   179: athrow
      //   180: astore_2
      //   181: goto -10 -> 171
      //   184: astore_1
      //   185: goto -24 -> 161
      //   188: astore_1
      //   189: goto -41 -> 148
      //   192: astore_1
      //   193: goto -73 -> 120
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	196	0	this	b
      //   12	93	1	localObject1	Object
      //   128	1	1	localIOException1	IOException
      //   130	49	1	localObject2	Object
      //   184	1	1	localObject3	Object
      //   188	1	1	localIOException2	IOException
      //   192	1	1	localIOException3	IOException
      //   10	120	2	localObject4	Object
      //   156	4	2	localObject5	Object
      //   180	1	2	localIOException4	IOException
      //   3	163	3	localObject6	Object
      //   7	160	4	localce1	ce
      //   108	8	5	localce2	ce
      // Exception table:
      //   from	to	target	type
      //   13	49	128	java/io/IOException
      //   53	63	128	java/io/IOException
      //   67	76	128	java/io/IOException
      //   80	93	128	java/io/IOException
      //   97	101	128	java/io/IOException
      //   105	110	128	java/io/IOException
      //   13	49	156	finally
      //   53	63	156	finally
      //   67	76	156	finally
      //   80	93	156	finally
      //   97	101	156	finally
      //   105	110	156	finally
      //   131	135	156	finally
      //   161	171	180	java/io/IOException
      //   135	139	184	finally
      //   139	148	188	java/io/IOException
      //   110	120	192	java/io/IOException
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */