package b.a.a;

import c.aa;
import c.e;
import c.h;
import c.y;
import c.z;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

public final class p
{
  long a = 0L;
  long b;
  final a c;
  private final int e;
  private final d f;
  private final List<r> g;
  private List<r> h;
  private final b i;
  private final c j = new c();
  private final c k = new c();
  private a l = null;
  
  static
  {
    if (!p.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      d = bool;
      return;
    }
  }
  
  p(int paramInt, d paramd, boolean paramBoolean1, boolean paramBoolean2, List<r> paramList)
  {
    if (paramd == null) {
      throw new NullPointerException("connection == null");
    }
    if (paramList == null) {
      throw new NullPointerException("requestHeaders == null");
    }
    this.e = paramInt;
    this.f = paramd;
    this.b = paramd.f.f(65536);
    this.i = new b(paramd.e.f(65536), null);
    this.c = new a();
    b.a(this.i, paramBoolean2);
    a.a(this.c, paramBoolean1);
    this.g = paramList;
  }
  
  private boolean d(a parama)
  {
    if ((!d) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    try
    {
      if (this.l != null) {
        return false;
      }
      if ((b.a(this.i)) && (a.a(this.c))) {
        return false;
      }
    }
    finally {}
    this.l = parama;
    notifyAll();
    this.f.b(this.e);
    return true;
  }
  
  private void j()
  {
    if ((!d) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    for (;;)
    {
      try
      {
        boolean bool;
        if ((!b.a(this.i)) && (b.b(this.i)))
        {
          if (a.a(this.c)) {
            break label112;
          }
          if (a.b(this.c))
          {
            break label112;
            bool = b();
            if (m == 0) {
              break label95;
            }
            a(a.l);
            return;
          }
        }
        m = 0;
        continue;
        if (bool) {
          continue;
        }
      }
      finally {}
      label95:
      this.f.b(this.e);
      return;
      label112:
      int m = 1;
    }
  }
  
  private void k()
  {
    if (a.b(this.c)) {
      throw new IOException("stream closed");
    }
    if (a.a(this.c)) {
      throw new IOException("stream finished");
    }
    if (this.l != null) {
      throw new IOException("stream was reset: " + this.l);
    }
  }
  
  private void l()
  {
    try
    {
      wait();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new InterruptedIOException();
    }
  }
  
  public int a()
  {
    return this.e;
  }
  
  void a(long paramLong)
  {
    this.b += paramLong;
    if (paramLong > 0L) {
      notifyAll();
    }
  }
  
  public void a(a parama)
  {
    if (!d(parama)) {
      return;
    }
    this.f.b(this.e, parama);
  }
  
  void a(h paramh, int paramInt)
  {
    if ((!d) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    this.i.a(paramh, paramInt);
  }
  
  void a(List<r> paramList, s params)
  {
    if ((!d) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    Object localObject = null;
    boolean bool = true;
    label97:
    do
    {
      for (;;)
      {
        try
        {
          if (this.h == null)
          {
            if (params.c())
            {
              paramList = a.b;
              if (paramList == null) {
                break;
              }
              b(paramList);
              return;
            }
            this.h = paramList;
            bool = b();
            notifyAll();
            paramList = (List<r>)localObject;
            continue;
          }
          if (!params.d()) {
            break label97;
          }
        }
        finally {}
        paramList = a.e;
        continue;
        params = new ArrayList();
        params.addAll(this.h);
        params.addAll(paramList);
        this.h = params;
        paramList = (List<r>)localObject;
      }
    } while (bool);
    this.f.b(this.e);
  }
  
  public void b(a parama)
  {
    if (!d(parama)) {
      return;
    }
    this.f.a(this.e, parama);
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 58	b/a/a/p:l	Lb/a/a/a;
    //   8: astore_1
    //   9: aload_1
    //   10: ifnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 91	b/a/a/p:i	Lb/a/a/p$b;
    //   21: invokestatic 121	b/a/a/p$b:a	(Lb/a/a/p$b;)Z
    //   24: ifne +13 -> 37
    //   27: aload_0
    //   28: getfield 91	b/a/a/p:i	Lb/a/a/p$b;
    //   31: invokestatic 138	b/a/a/p$b:b	(Lb/a/a/p$b;)Z
    //   34: ifeq +32 -> 66
    //   37: aload_0
    //   38: getfield 94	b/a/a/p:c	Lb/a/a/p$a;
    //   41: invokestatic 124	b/a/a/p$a:a	(Lb/a/a/p$a;)Z
    //   44: ifne +13 -> 57
    //   47: aload_0
    //   48: getfield 94	b/a/a/p:c	Lb/a/a/p$a;
    //   51: invokestatic 140	b/a/a/p$a:b	(Lb/a/a/p$a;)Z
    //   54: ifeq +12 -> 66
    //   57: aload_0
    //   58: getfield 193	b/a/a/p:h	Ljava/util/List;
    //   61: astore_1
    //   62: aload_1
    //   63: ifnonnull -50 -> 13
    //   66: iconst_1
    //   67: istore_2
    //   68: goto -55 -> 13
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	p
    //   8	55	1	localObject1	Object
    //   71	4	1	localObject2	Object
    //   1	67	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	9	71	finally
    //   17	37	71	finally
    //   37	57	71	finally
    //   57	62	71	finally
  }
  
  void c(a parama)
  {
    try
    {
      if (this.l == null)
      {
        this.l = parama;
        notifyAll();
      }
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public boolean c()
  {
    if ((this.e & 0x1) == 1) {}
    for (int m = 1; this.f.b == m; m = 0) {
      return true;
    }
    return false;
  }
  
  /* Error */
  public List<r> d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 54	b/a/a/p:j	Lb/a/a/p$c;
    //   6: invokevirtual 222	b/a/a/p$c:c	()V
    //   9: aload_0
    //   10: getfield 193	b/a/a/p:h	Ljava/util/List;
    //   13: ifnonnull +32 -> 45
    //   16: aload_0
    //   17: getfield 58	b/a/a/p:l	Lb/a/a/a;
    //   20: ifnonnull +25 -> 45
    //   23: aload_0
    //   24: invokespecial 132	b/a/a/p:l	()V
    //   27: goto -18 -> 9
    //   30: astore_1
    //   31: aload_0
    //   32: getfield 54	b/a/a/p:j	Lb/a/a/p$c;
    //   35: invokevirtual 224	b/a/a/p$c:b	()V
    //   38: aload_1
    //   39: athrow
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    //   45: aload_0
    //   46: getfield 54	b/a/a/p:j	Lb/a/a/p$c;
    //   49: invokevirtual 224	b/a/a/p$c:b	()V
    //   52: aload_0
    //   53: getfield 193	b/a/a/p:h	Ljava/util/List;
    //   56: ifnull +12 -> 68
    //   59: aload_0
    //   60: getfield 193	b/a/a/p:h	Ljava/util/List;
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: areturn
    //   68: new 150	java/io/IOException
    //   71: dup
    //   72: new 157	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   79: ldc -96
    //   81: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload_0
    //   85: getfield 58	b/a/a/p:l	Lb/a/a/a;
    //   88: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokespecial 153	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	p
    //   30	9	1	localObject1	Object
    //   40	4	1	localObject2	Object
    //   63	4	1	localList	List
    // Exception table:
    //   from	to	target	type
    //   9	27	30	finally
    //   2	9	40	finally
    //   31	40	40	finally
    //   45	64	40	finally
    //   68	98	40	finally
  }
  
  public aa e()
  {
    return this.j;
  }
  
  public aa f()
  {
    return this.k;
  }
  
  public z g()
  {
    return this.i;
  }
  
  public y h()
  {
    try
    {
      if ((this.h == null) && (!c())) {
        throw new IllegalStateException("reply before requesting the sink");
      }
    }
    finally {}
    return this.c;
  }
  
  void i()
  {
    if ((!d) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    try
    {
      b.a(this.i, true);
      boolean bool = b();
      notifyAll();
      if (!bool) {
        this.f.b(this.e);
      }
      return;
    }
    finally {}
  }
  
  final class a
    implements y
  {
    private final e c = new e();
    private boolean d;
    private boolean e;
    
    static
    {
      if (!p.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        a = bool;
        return;
      }
    }
    
    a() {}
    
    /* Error */
    private void a(boolean paramBoolean)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 31	b/a/a/p$a:b	Lb/a/a/p;
      //   4: astore_2
      //   5: aload_2
      //   6: monitorenter
      //   7: aload_0
      //   8: getfield 31	b/a/a/p$a:b	Lb/a/a/p;
      //   11: invokestatic 43	b/a/a/p:g	(Lb/a/a/p;)Lb/a/a/p$c;
      //   14: invokevirtual 47	b/a/a/p$c:c	()V
      //   17: aload_0
      //   18: getfield 31	b/a/a/p$a:b	Lb/a/a/p;
      //   21: getfield 50	b/a/a/p:b	J
      //   24: lconst_0
      //   25: lcmp
      //   26: ifgt +55 -> 81
      //   29: aload_0
      //   30: getfield 52	b/a/a/p$a:e	Z
      //   33: ifne +48 -> 81
      //   36: aload_0
      //   37: getfield 54	b/a/a/p$a:d	Z
      //   40: ifne +41 -> 81
      //   43: aload_0
      //   44: getfield 31	b/a/a/p$a:b	Lb/a/a/p;
      //   47: invokestatic 57	b/a/a/p:d	(Lb/a/a/p;)Lb/a/a/a;
      //   50: ifnonnull +31 -> 81
      //   53: aload_0
      //   54: getfield 31	b/a/a/p$a:b	Lb/a/a/p;
      //   57: invokestatic 59	b/a/a/p:e	(Lb/a/a/p;)V
      //   60: goto -43 -> 17
      //   63: astore_3
      //   64: aload_0
      //   65: getfield 31	b/a/a/p$a:b	Lb/a/a/p;
      //   68: invokestatic 43	b/a/a/p:g	(Lb/a/a/p;)Lb/a/a/p$c;
      //   71: invokevirtual 61	b/a/a/p$c:b	()V
      //   74: aload_3
      //   75: athrow
      //   76: astore_3
      //   77: aload_2
      //   78: monitorexit
      //   79: aload_3
      //   80: athrow
      //   81: aload_0
      //   82: getfield 31	b/a/a/p$a:b	Lb/a/a/p;
      //   85: invokestatic 43	b/a/a/p:g	(Lb/a/a/p;)Lb/a/a/p$c;
      //   88: invokevirtual 61	b/a/a/p$c:b	()V
      //   91: aload_0
      //   92: getfield 31	b/a/a/p$a:b	Lb/a/a/p;
      //   95: invokestatic 64	b/a/a/p:h	(Lb/a/a/p;)V
      //   98: aload_0
      //   99: getfield 31	b/a/a/p$a:b	Lb/a/a/p;
      //   102: getfield 50	b/a/a/p:b	J
      //   105: aload_0
      //   106: getfield 38	b/a/a/p$a:c	Lc/e;
      //   109: invokevirtual 67	c/e:b	()J
      //   112: invokestatic 73	java/lang/Math:min	(JJ)J
      //   115: lstore 5
      //   117: aload_0
      //   118: getfield 31	b/a/a/p$a:b	Lb/a/a/p;
      //   121: astore_3
      //   122: aload_3
      //   123: aload_3
      //   124: getfield 50	b/a/a/p:b	J
      //   127: lload 5
      //   129: lsub
      //   130: putfield 50	b/a/a/p:b	J
      //   133: aload_2
      //   134: monitorexit
      //   135: aload_0
      //   136: getfield 31	b/a/a/p$a:b	Lb/a/a/p;
      //   139: invokestatic 43	b/a/a/p:g	(Lb/a/a/p;)Lb/a/a/p$c;
      //   142: invokevirtual 47	b/a/a/p$c:c	()V
      //   145: aload_0
      //   146: getfield 31	b/a/a/p$a:b	Lb/a/a/p;
      //   149: invokestatic 76	b/a/a/p:a	(Lb/a/a/p;)Lb/a/a/d;
      //   152: astore_2
      //   153: aload_0
      //   154: getfield 31	b/a/a/p$a:b	Lb/a/a/p;
      //   157: invokestatic 79	b/a/a/p:b	(Lb/a/a/p;)I
      //   160: istore 4
      //   162: iload_1
      //   163: ifeq +42 -> 205
      //   166: lload 5
      //   168: aload_0
      //   169: getfield 38	b/a/a/p$a:c	Lc/e;
      //   172: invokevirtual 67	c/e:b	()J
      //   175: lcmp
      //   176: ifne +29 -> 205
      //   179: iconst_1
      //   180: istore_1
      //   181: aload_2
      //   182: iload 4
      //   184: iload_1
      //   185: aload_0
      //   186: getfield 38	b/a/a/p$a:c	Lc/e;
      //   189: lload 5
      //   191: invokevirtual 84	b/a/a/d:a	(IZLc/e;J)V
      //   194: aload_0
      //   195: getfield 31	b/a/a/p$a:b	Lb/a/a/p;
      //   198: invokestatic 43	b/a/a/p:g	(Lb/a/a/p;)Lb/a/a/p$c;
      //   201: invokevirtual 61	b/a/a/p$c:b	()V
      //   204: return
      //   205: iconst_0
      //   206: istore_1
      //   207: goto -26 -> 181
      //   210: astore_2
      //   211: aload_0
      //   212: getfield 31	b/a/a/p$a:b	Lb/a/a/p;
      //   215: invokestatic 43	b/a/a/p:g	(Lb/a/a/p;)Lb/a/a/p$c;
      //   218: invokevirtual 61	b/a/a/p$c:b	()V
      //   221: aload_2
      //   222: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	223	0	this	a
      //   0	223	1	paramBoolean	boolean
      //   4	178	2	localObject1	Object
      //   210	12	2	localObject2	Object
      //   63	12	3	localObject3	Object
      //   76	4	3	localObject4	Object
      //   121	3	3	localp	p
      //   160	23	4	i	int
      //   115	75	5	l	long
      // Exception table:
      //   from	to	target	type
      //   17	60	63	finally
      //   7	17	76	finally
      //   64	76	76	finally
      //   77	79	76	finally
      //   81	135	76	finally
      //   145	162	210	finally
      //   166	179	210	finally
      //   181	194	210	finally
    }
    
    public aa a()
    {
      return p.g(p.this);
    }
    
    public void a_(e parame, long paramLong)
    {
      if ((!a) && (Thread.holdsLock(p.this))) {
        throw new AssertionError();
      }
      this.c.a_(parame, paramLong);
      while (this.c.b() >= 16384L) {
        a(false);
      }
    }
    
    public void close()
    {
      if ((!a) && (Thread.holdsLock(p.this))) {
        throw new AssertionError();
      }
      synchronized (p.this)
      {
        if (this.d) {
          return;
        }
        if (p.this.c.e) {
          break label113;
        }
        if (this.c.b() > 0L)
        {
          if (this.c.b() <= 0L) {
            break label113;
          }
          a(true);
        }
      }
      p.a(p.this).a(p.b(p.this), true, null, 0L);
      label113:
      synchronized (p.this)
      {
        this.d = true;
        p.a(p.this).c();
        p.f(p.this);
        return;
      }
    }
    
    public void flush()
    {
      if ((!a) && (Thread.holdsLock(p.this))) {
        throw new AssertionError();
      }
      synchronized (p.this)
      {
        p.h(p.this);
        if (this.c.b() > 0L)
        {
          a(false);
          p.a(p.this).c();
        }
      }
    }
  }
  
  private final class b
    implements z
  {
    private final e c = new e();
    private final e d = new e();
    private final long e;
    private boolean f;
    private boolean g;
    
    static
    {
      if (!p.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        a = bool;
        return;
      }
    }
    
    private b(long paramLong)
    {
      this.e = paramLong;
    }
    
    /* Error */
    private void b()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 34	b/a/a/p$b:b	Lb/a/a/p;
      //   4: invokestatic 55	b/a/a/p:c	(Lb/a/a/p;)Lb/a/a/p$c;
      //   7: invokevirtual 59	b/a/a/p$c:c	()V
      //   10: aload_0
      //   11: getfield 43	b/a/a/p$b:d	Lc/e;
      //   14: invokevirtual 62	c/e:b	()J
      //   17: lconst_0
      //   18: lcmp
      //   19: ifne +50 -> 69
      //   22: aload_0
      //   23: getfield 51	b/a/a/p$b:g	Z
      //   26: ifne +43 -> 69
      //   29: aload_0
      //   30: getfield 64	b/a/a/p$b:f	Z
      //   33: ifne +36 -> 69
      //   36: aload_0
      //   37: getfield 34	b/a/a/p$b:b	Lb/a/a/p;
      //   40: invokestatic 67	b/a/a/p:d	(Lb/a/a/p;)Lb/a/a/a;
      //   43: ifnonnull +26 -> 69
      //   46: aload_0
      //   47: getfield 34	b/a/a/p$b:b	Lb/a/a/p;
      //   50: invokestatic 70	b/a/a/p:e	(Lb/a/a/p;)V
      //   53: goto -43 -> 10
      //   56: astore_1
      //   57: aload_0
      //   58: getfield 34	b/a/a/p$b:b	Lb/a/a/p;
      //   61: invokestatic 55	b/a/a/p:c	(Lb/a/a/p;)Lb/a/a/p$c;
      //   64: invokevirtual 72	b/a/a/p$c:b	()V
      //   67: aload_1
      //   68: athrow
      //   69: aload_0
      //   70: getfield 34	b/a/a/p$b:b	Lb/a/a/p;
      //   73: invokestatic 55	b/a/a/p:c	(Lb/a/a/p;)Lb/a/a/p$c;
      //   76: invokevirtual 72	b/a/a/p$c:b	()V
      //   79: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	80	0	this	b
      //   56	12	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   10	53	56	finally
    }
    
    private void c()
    {
      if (this.f) {
        throw new IOException("stream closed");
      }
      if (p.d(p.this) != null) {
        throw new IOException("stream was reset: " + p.d(p.this));
      }
    }
    
    public long a(e arg1, long paramLong)
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      }
      synchronized (p.this)
      {
        b();
        c();
        if (this.d.b() == 0L) {
          return -1L;
        }
        paramLong = this.d.a(???, Math.min(paramLong, this.d.b()));
        ??? = p.this;
        ???.a += paramLong;
        if (p.this.a >= p.a(p.this).e.f(65536) / 2)
        {
          p.a(p.this).a(p.b(p.this), p.this.a);
          p.this.a = 0L;
        }
        synchronized (p.a(p.this))
        {
          ??? = p.a(p.this);
          ((d)???).c += paramLong;
          if (p.a(p.this).c >= p.a(p.this).e.f(65536) / 2)
          {
            p.a(p.this).a(0, p.a(p.this).c);
            p.a(p.this).c = 0L;
          }
          return paramLong;
        }
      }
    }
    
    public aa a()
    {
      return p.c(p.this);
    }
    
    void a(h paramh, long paramLong)
    {
      long l = paramLong;
      if (!a)
      {
        l = paramLong;
        if (Thread.holdsLock(p.this)) {
          throw new AssertionError();
        }
      }
      for (;;)
      {
        l -= paramLong;
        synchronized (p.this)
        {
          if (this.d.b() == 0L)
          {
            i = 1;
            this.d.a(this.c);
            if (i != 0) {
              p.this.notifyAll();
            }
            if (l > 0L) {}
            boolean bool;
            synchronized (p.this)
            {
              bool = this.g;
              if (this.d.b() + l > this.e)
              {
                i = 1;
                if (i != 0)
                {
                  paramh.g(l);
                  p.this.b(a.h);
                }
              }
              else
              {
                i = 0;
              }
            }
            if (bool)
            {
              paramh.g(l);
              return;
            }
            paramLong = paramh.a(this.c, l);
            if (paramLong != -1L) {
              continue;
            }
            throw new EOFException();
          }
          int i = 0;
        }
      }
    }
    
    public void close()
    {
      synchronized (p.this)
      {
        this.f = true;
        this.d.s();
        p.this.notifyAll();
        p.f(p.this);
        return;
      }
    }
  }
  
  class c
    extends c.a
  {
    c() {}
    
    protected IOException a(IOException paramIOException)
    {
      SocketTimeoutException localSocketTimeoutException = new SocketTimeoutException("timeout");
      if (paramIOException != null) {
        localSocketTimeoutException.initCause(paramIOException);
      }
      return localSocketTimeoutException;
    }
    
    protected void a()
    {
      p.this.b(a.l);
    }
    
    public void b()
    {
      if (n_()) {
        throw a(null);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\a\a\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */