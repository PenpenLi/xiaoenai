package com.adhoc;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

public final class dp
{
  private final at a;
  private final as b;
  private final Socket c;
  private final eq d;
  private final ep e;
  private int f = 0;
  private int g = 0;
  
  public dp(at paramat, as paramas, Socket paramSocket)
  {
    this.a = paramat;
    this.b = paramas;
    this.c = paramSocket;
    this.d = ex.a(ex.b(paramSocket));
    this.e = ex.a(ex.a(paramSocket));
  }
  
  private void a(eu parameu)
  {
    fh localfh = parameu.a();
    parameu.a(fh.b);
    localfh.f();
    localfh.d_();
  }
  
  public ff a(long paramLong)
  {
    if (this.f != 1) {
      throw new IllegalStateException("state: " + this.f);
    }
    this.f = 2;
    return new d(paramLong, null);
  }
  
  public fg a(dt paramdt)
  {
    if (this.f != 4) {
      throw new IllegalStateException("state: " + this.f);
    }
    this.f = 5;
    return new c(paramdt);
  }
  
  public void a()
  {
    this.g = 1;
    if (this.f == 0)
    {
      this.g = 0;
      bt.b.a(this.a, this.b);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0) {
      this.d.a().a(paramInt1, TimeUnit.MILLISECONDS);
    }
    if (paramInt2 != 0) {
      this.e.a().a(paramInt2, TimeUnit.MILLISECONDS);
    }
  }
  
  public void a(ba.a parama)
  {
    for (;;)
    {
      String str = this.d.p();
      if (str.length() == 0) {
        break;
      }
      bt.b.a(parama, str);
    }
  }
  
  public void a(ba paramba, String paramString)
  {
    if (this.f != 0) {
      throw new IllegalStateException("state: " + this.f);
    }
    this.e.b(paramString).b("\r\n");
    int i = 0;
    int j = paramba.a();
    while (i < j)
    {
      this.e.b(paramba.a(i)).b(": ").b(paramba.b(i)).b("\r\n");
      i += 1;
    }
    this.e.b("\r\n");
    this.f = 1;
  }
  
  public void a(ed paramed)
  {
    if (this.f != 1) {
      throw new IllegalStateException("state: " + this.f);
    }
    this.f = 3;
    paramed.a(this.e);
  }
  
  public fg b(long paramLong)
  {
    if (this.f != 4) {
      throw new IllegalStateException("state: " + this.f);
    }
    this.f = 5;
    return new e(paramLong);
  }
  
  public void b()
  {
    this.g = 2;
    if (this.f == 0)
    {
      this.f = 6;
      this.b.d().close();
    }
  }
  
  public boolean c()
  {
    return this.f == 6;
  }
  
  public void d()
  {
    this.e.flush();
  }
  
  public long e()
  {
    return this.d.c().b();
  }
  
  public boolean f()
  {
    try
    {
      int i = this.c.getSoTimeout();
      try
      {
        this.c.setSoTimeout(1);
        boolean bool = this.d.f();
        return !bool;
      }
      finally
      {
        this.c.setSoTimeout(i);
      }
      return false;
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      return true;
    }
    catch (IOException localIOException) {}
  }
  
  public bn.a g()
  {
    if ((this.f != 1) && (this.f != 3)) {
      throw new IllegalStateException("state: " + this.f);
    }
    try
    {
      eg localeg;
      do
      {
        localeg = eg.a(this.d.p());
        localObject = new bn.a().a(localeg.a).a(localeg.b).a(localeg.c);
        ba.a locala = new ba.a();
        a(locala);
        locala.a(dy.d, localeg.a.toString());
        ((bn.a)localObject).a(locala.a());
      } while (localeg.b == 100);
      this.f = 4;
      return (bn.a)localObject;
    }
    catch (EOFException localEOFException)
    {
      Object localObject = new IOException("unexpected end of stream on " + this.b + " (recycle count=" + bt.b.b(this.b) + ")");
      ((IOException)localObject).initCause(localEOFException);
      throw ((Throwable)localObject);
    }
  }
  
  public ff h()
  {
    if (this.f != 1) {
      throw new IllegalStateException("state: " + this.f);
    }
    this.f = 2;
    return new b(null);
  }
  
  public fg i()
  {
    if (this.f != 4) {
      throw new IllegalStateException("state: " + this.f);
    }
    this.f = 5;
    return new f(null);
  }
  
  abstract class a
    implements fg
  {
    protected final eu a = new eu(dp.b(dp.this).a());
    protected boolean b;
    
    private a() {}
    
    public fh a()
    {
      return this.a;
    }
    
    protected final void a(boolean paramBoolean)
    {
      if (dp.c(dp.this) != 5) {
        throw new IllegalStateException("state: " + dp.c(dp.this));
      }
      dp.a(dp.this, this.a);
      dp.a(dp.this, 0);
      if ((paramBoolean) && (dp.d(dp.this) == 1))
      {
        dp.b(dp.this, 0);
        bt.b.a(dp.e(dp.this), dp.f(dp.this));
      }
      while (dp.d(dp.this) != 2) {
        return;
      }
      dp.a(dp.this, 6);
      dp.f(dp.this).d().close();
    }
    
    protected final void b()
    {
      cb.a(dp.f(dp.this).d());
      dp.a(dp.this, 6);
    }
  }
  
  final class b
    implements ff
  {
    private final eu b = new eu(dp.a(dp.this).a());
    private boolean c;
    
    private b() {}
    
    public fh a()
    {
      return this.b;
    }
    
    public void a_(eo parameo, long paramLong)
    {
      if (this.c) {
        throw new IllegalStateException("closed");
      }
      if (paramLong == 0L) {
        return;
      }
      dp.a(dp.this).i(paramLong);
      dp.a(dp.this).b("\r\n");
      dp.a(dp.this).a_(parameo, paramLong);
      dp.a(dp.this).b("\r\n");
    }
    
    /* Error */
    public void close()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 44	com/adhoc/dp$b:c	Z
      //   6: istore_2
      //   7: iload_2
      //   8: ifeq +6 -> 14
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: aload_0
      //   15: iconst_1
      //   16: putfield 44	com/adhoc/dp$b:c	Z
      //   19: aload_0
      //   20: getfield 18	com/adhoc/dp$b:a	Lcom/adhoc/dp;
      //   23: invokestatic 26	com/adhoc/dp:a	(Lcom/adhoc/dp;)Lcom/adhoc/ep;
      //   26: ldc 65
      //   28: invokeinterface 60 2 0
      //   33: pop
      //   34: aload_0
      //   35: getfield 18	com/adhoc/dp$b:a	Lcom/adhoc/dp;
      //   38: aload_0
      //   39: getfield 36	com/adhoc/dp$b:b	Lcom/adhoc/eu;
      //   42: invokestatic 68	com/adhoc/dp:a	(Lcom/adhoc/dp;Lcom/adhoc/eu;)V
      //   45: aload_0
      //   46: getfield 18	com/adhoc/dp$b:a	Lcom/adhoc/dp;
      //   49: iconst_3
      //   50: invokestatic 71	com/adhoc/dp:a	(Lcom/adhoc/dp;I)I
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
      //   3: getfield 44	com/adhoc/dp$b:c	Z
      //   6: istore_2
      //   7: iload_2
      //   8: ifeq +6 -> 14
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: aload_0
      //   15: getfield 18	com/adhoc/dp$b:a	Lcom/adhoc/dp;
      //   18: invokestatic 26	com/adhoc/dp:a	(Lcom/adhoc/dp;)Lcom/adhoc/ep;
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
  
  class c
    extends dp.a
  {
    private long e = -1L;
    private boolean f = true;
    private final dt g;
    
    c(dt paramdt)
    {
      super(null);
      this.g = paramdt;
    }
    
    private void c()
    {
      if (this.e != -1L) {
        dp.b(dp.this).p();
      }
      try
      {
        this.e = dp.b(dp.this).m();
        String str = dp.b(dp.this).p().trim();
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
        ba.a locala = new ba.a();
        dp.this.a(locala);
        this.g.a(locala.a());
        a(true);
      }
    }
    
    public long a(eo parameo, long paramLong)
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
        c();
      } while (!this.f);
      paramLong = dp.b(dp.this).a(parameo, Math.min(paramLong, this.e));
      if (paramLong == -1L)
      {
        b();
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
      if ((this.f) && (!cb.a(this, 100, TimeUnit.MILLISECONDS))) {
        b();
      }
      this.b = true;
    }
  }
  
  final class d
    implements ff
  {
    private final eu b = new eu(dp.a(dp.this).a());
    private boolean c;
    private long d;
    
    private d(long paramLong)
    {
      this.d = paramLong;
    }
    
    public fh a()
    {
      return this.b;
    }
    
    public void a_(eo parameo, long paramLong)
    {
      if (this.c) {
        throw new IllegalStateException("closed");
      }
      cb.a(parameo.b(), 0L, paramLong);
      if (paramLong > this.d) {
        throw new ProtocolException("expected " + this.d + " bytes but received " + paramLong);
      }
      dp.a(dp.this).a_(parameo, paramLong);
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
      dp.a(dp.this, this.b);
      dp.a(dp.this, 3);
    }
    
    public void flush()
    {
      if (this.c) {
        return;
      }
      dp.a(dp.this).flush();
    }
  }
  
  class e
    extends dp.a
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
    
    public long a(eo parameo, long paramLong)
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
      paramLong = dp.b(dp.this).a(parameo, Math.min(this.e, paramLong));
      if (paramLong == -1L)
      {
        b();
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
      if ((this.e != 0L) && (!cb.a(this, 100, TimeUnit.MILLISECONDS))) {
        b();
      }
      this.b = true;
    }
  }
  
  class f
    extends dp.a
  {
    private boolean e;
    
    private f()
    {
      super(null);
    }
    
    public long a(eo parameo, long paramLong)
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
      paramLong = dp.b(dp.this).a(parameo, paramLong);
      if (paramLong == -1L)
      {
        this.e = true;
        a(false);
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
        b();
      }
      this.b = true;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\dp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */