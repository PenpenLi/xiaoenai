package b.a.b;

import b.a.d;
import b.al;
import b.aq;
import b.aq.a;
import b.as;
import b.at;
import b.l;
import b.z.a;
import c.aa;
import c.g;
import c.h;
import c.m;
import c.y;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

public final class e
  implements n
{
  private final w a;
  private final h b;
  private final g c;
  private j d;
  private int e = 0;
  
  public e(w paramw, h paramh, g paramg)
  {
    this.a = paramw;
    this.b = paramh;
    this.c = paramg;
  }
  
  private void a(m paramm)
  {
    aa localaa = paramm.a();
    paramm.a(aa.b);
    localaa.f();
    localaa.q_();
  }
  
  private c.z b(aq paramaq)
  {
    if (!j.a(paramaq)) {
      return b(0L);
    }
    if ("chunked".equalsIgnoreCase(paramaq.a("Transfer-Encoding"))) {
      return b(this.d);
    }
    long l = o.a(paramaq);
    if (l != -1L) {
      return b(l);
    }
    return f();
  }
  
  public aq.a a()
  {
    return c();
  }
  
  public as a(aq paramaq)
  {
    c.z localz = b(paramaq);
    return new p(paramaq.f(), c.p.a(localz));
  }
  
  public y a(long paramLong)
  {
    if (this.e != 1) {
      throw new IllegalStateException("state: " + this.e);
    }
    this.e = 2;
    return new d(paramLong, null);
  }
  
  public y a(al paramal, long paramLong)
  {
    if ("chunked".equalsIgnoreCase(paramal.a("Transfer-Encoding"))) {
      return e();
    }
    if (paramLong != -1L) {
      return a(paramLong);
    }
    throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
  }
  
  public void a(j paramj)
  {
    this.d = paramj;
  }
  
  public void a(s params)
  {
    if (this.e != 1) {
      throw new IllegalStateException("state: " + this.e);
    }
    this.e = 3;
    params.a(this.c);
  }
  
  public void a(al paramal)
  {
    this.d.b();
    String str = r.a(paramal, this.d.d().a().b().type());
    a(paramal.c(), str);
  }
  
  public void a(b.z paramz, String paramString)
  {
    if (this.e != 0) {
      throw new IllegalStateException("state: " + this.e);
    }
    this.c.b(paramString).b("\r\n");
    int i = 0;
    int j = paramz.a();
    while (i < j)
    {
      this.c.b(paramz.a(i)).b(": ").b(paramz.b(i)).b("\r\n");
      i += 1;
    }
    this.c.b("\r\n");
    this.e = 1;
  }
  
  public c.z b(long paramLong)
  {
    if (this.e != 4) {
      throw new IllegalStateException("state: " + this.e);
    }
    this.e = 5;
    return new e(paramLong);
  }
  
  public c.z b(j paramj)
  {
    if (this.e != 4) {
      throw new IllegalStateException("state: " + this.e);
    }
    this.e = 5;
    return new c(paramj);
  }
  
  public void b()
  {
    this.c.flush();
  }
  
  public aq.a c()
  {
    if ((this.e != 1) && (this.e != 3)) {
      throw new IllegalStateException("state: " + this.e);
    }
    try
    {
      v localv;
      do
      {
        localv = v.a(this.b.q());
        localObject = new aq.a().a(localv.a).a(localv.b).a(localv.c).a(d());
      } while (localv.b == 100);
      this.e = 4;
      return (aq.a)localObject;
    }
    catch (EOFException localEOFException)
    {
      Object localObject = new IOException("unexpected end of stream on " + this.a);
      ((IOException)localObject).initCause(localEOFException);
      throw ((Throwable)localObject);
    }
  }
  
  public b.z d()
  {
    z.a locala = new z.a();
    for (;;)
    {
      String str = this.b.q();
      if (str.length() == 0) {
        break;
      }
      d.b.a(locala, str);
    }
    return locala.a();
  }
  
  public y e()
  {
    if (this.e != 1) {
      throw new IllegalStateException("state: " + this.e);
    }
    this.e = 2;
    return new b(null);
  }
  
  public c.z f()
  {
    if (this.e != 4) {
      throw new IllegalStateException("state: " + this.e);
    }
    if (this.a == null) {
      throw new IllegalStateException("streamAllocation == null");
    }
    this.e = 5;
    this.a.c();
    return new f(null);
  }
  
  private abstract class a
    implements c.z
  {
    protected final m a = new m(e.b(e.this).a());
    protected boolean b;
    
    private a() {}
    
    public aa a()
    {
      return this.a;
    }
    
    protected final void a(boolean paramBoolean)
    {
      if (e.c(e.this) == 6) {}
      do
      {
        return;
        if (e.c(e.this) != 5) {
          throw new IllegalStateException("state: " + e.c(e.this));
        }
        e.a(e.this, this.a);
        e.a(e.this, 6);
      } while (e.d(e.this) == null);
      w localw = e.d(e.this);
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        localw.a(paramBoolean, e.this);
        return;
      }
    }
  }
  
  private final class b
    implements y
  {
    private final m b = new m(e.a(e.this).a());
    private boolean c;
    
    private b() {}
    
    public aa a()
    {
      return this.b;
    }
    
    public void a_(c.e parame, long paramLong)
    {
      if (this.c) {
        throw new IllegalStateException("closed");
      }
      if (paramLong == 0L) {
        return;
      }
      e.a(e.this).j(paramLong);
      e.a(e.this).b("\r\n");
      e.a(e.this).a_(parame, paramLong);
      e.a(e.this).b("\r\n");
    }
    
    /* Error */
    public void close()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 44	b/a/b/e$b:c	Z
      //   6: istore_2
      //   7: iload_2
      //   8: ifeq +6 -> 14
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: aload_0
      //   15: iconst_1
      //   16: putfield 44	b/a/b/e$b:c	Z
      //   19: aload_0
      //   20: getfield 18	b/a/b/e$b:a	Lb/a/b/e;
      //   23: invokestatic 26	b/a/b/e:a	(Lb/a/b/e;)Lc/g;
      //   26: ldc 65
      //   28: invokeinterface 60 2 0
      //   33: pop
      //   34: aload_0
      //   35: getfield 18	b/a/b/e$b:a	Lb/a/b/e;
      //   38: aload_0
      //   39: getfield 36	b/a/b/e$b:b	Lc/m;
      //   42: invokestatic 68	b/a/b/e:a	(Lb/a/b/e;Lc/m;)V
      //   45: aload_0
      //   46: getfield 18	b/a/b/e$b:a	Lb/a/b/e;
      //   49: iconst_3
      //   50: invokestatic 71	b/a/b/e:a	(Lb/a/b/e;I)I
      //   53: pop
      //   54: goto -43 -> 11
      //   57: astore_1
      //   58: aload_0
      //   59: monitorexit
      //   60: aload_1
      //   61: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	62	0	this	b
      //   57	4	1	localObject	Object
      //   6	2	2	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   2	7	57	finally
      //   14	54	57	finally
    }
    
    /* Error */
    public void flush()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 44	b/a/b/e$b:c	Z
      //   6: istore_2
      //   7: iload_2
      //   8: ifeq +6 -> 14
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: aload_0
      //   15: getfield 18	b/a/b/e$b:a	Lb/a/b/e;
      //   18: invokestatic 26	b/a/b/e:a	(Lb/a/b/e;)Lc/g;
      //   21: invokeinterface 74 1 0
      //   26: goto -15 -> 11
      //   29: astore_1
      //   30: aload_0
      //   31: monitorexit
      //   32: aload_1
      //   33: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	34	0	this	b
      //   29	4	1	localObject	Object
      //   6	2	2	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   2	7	29	finally
      //   14	26	29	finally
    }
  }
  
  private class c
    extends e.a
  {
    private long e = -1L;
    private boolean f = true;
    private final j g;
    
    c(j paramj)
    {
      super(null);
      this.g = paramj;
    }
    
    private void b()
    {
      if (this.e != -1L) {
        e.b(e.this).q();
      }
      try
      {
        this.e = e.b(e.this).n();
        String str = e.b(e.this).q().trim();
        if ((this.e < 0L) || ((!str.isEmpty()) && (!str.startsWith(";")))) {
          throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.e + str + "\"");
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new ProtocolException(localNumberFormatException.getMessage());
      }
      if (this.e == 0L)
      {
        this.f = false;
        this.g.a(e.this.d());
        a(true);
      }
    }
    
    public long a(c.e parame, long paramLong)
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      }
      if (this.b) {
        throw new IllegalStateException("closed");
      }
      if (!this.f) {}
      do
      {
        return -1L;
        if ((this.e != 0L) && (this.e != -1L)) {
          break;
        }
        b();
      } while (!this.f);
      paramLong = e.b(e.this).a(parame, Math.min(paramLong, this.e));
      if (paramLong == -1L)
      {
        a(false);
        throw new ProtocolException("unexpected end of stream");
      }
      this.e -= paramLong;
      return paramLong;
    }
    
    public void close()
    {
      if (this.b) {
        return;
      }
      if ((this.f) && (!b.a.j.a(this, 100, TimeUnit.MILLISECONDS))) {
        a(false);
      }
      this.b = true;
    }
  }
  
  private final class d
    implements y
  {
    private final m b = new m(e.a(e.this).a());
    private boolean c;
    private long d;
    
    private d(long paramLong)
    {
      this.d = paramLong;
    }
    
    public aa a()
    {
      return this.b;
    }
    
    public void a_(c.e parame, long paramLong)
    {
      if (this.c) {
        throw new IllegalStateException("closed");
      }
      b.a.j.a(parame.b(), 0L, paramLong);
      if (paramLong > this.d) {
        throw new ProtocolException("expected " + this.d + " bytes but received " + paramLong);
      }
      e.a(e.this).a_(parame, paramLong);
      this.d -= paramLong;
    }
    
    public void close()
    {
      if (this.c) {
        return;
      }
      this.c = true;
      if (this.d > 0L) {
        throw new ProtocolException("unexpected end of stream");
      }
      e.a(e.this, this.b);
      e.a(e.this, 3);
    }
    
    public void flush()
    {
      if (this.c) {
        return;
      }
      e.a(e.this).flush();
    }
  }
  
  private class e
    extends e.a
  {
    private long e;
    
    public e(long paramLong)
    {
      super(null);
      this.e = paramLong;
      if (this.e == 0L) {
        a(true);
      }
    }
    
    public long a(c.e parame, long paramLong)
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      }
      if (this.b) {
        throw new IllegalStateException("closed");
      }
      if (this.e == 0L) {
        return -1L;
      }
      paramLong = e.b(e.this).a(parame, Math.min(this.e, paramLong));
      if (paramLong == -1L)
      {
        a(false);
        throw new ProtocolException("unexpected end of stream");
      }
      this.e -= paramLong;
      if (this.e == 0L) {
        a(true);
      }
      return paramLong;
    }
    
    public void close()
    {
      if (this.b) {
        return;
      }
      if ((this.e != 0L) && (!b.a.j.a(this, 100, TimeUnit.MILLISECONDS))) {
        a(false);
      }
      this.b = true;
    }
  }
  
  private class f
    extends e.a
  {
    private boolean e;
    
    private f()
    {
      super(null);
    }
    
    public long a(c.e parame, long paramLong)
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      }
      if (this.b) {
        throw new IllegalStateException("closed");
      }
      if (this.e) {
        return -1L;
      }
      paramLong = e.b(e.this).a(parame, paramLong);
      if (paramLong == -1L)
      {
        this.e = true;
        a(true);
        return -1L;
      }
      return paramLong;
    }
    
    public void close()
    {
      if (this.b) {
        return;
      }
      if (!this.e) {
        a(false);
      }
      this.b = true;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\a\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */