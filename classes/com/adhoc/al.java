package com.adhoc;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.List;

public class al
{
  volatile boolean a;
  bj b;
  dt c;
  private final bg d;
  private boolean e;
  
  protected al(bg parambg, bj parambj)
  {
    this.d = parambg.w();
    this.b = parambj;
  }
  
  private bn a(boolean paramBoolean)
  {
    return new a(0, this.b, paramBoolean).a(this.b);
  }
  
  private String a()
  {
    if (this.a) {}
    for (String str = "canceled call";; str = "call")
    {
      bc localbc = this.b.a().c("/...");
      return str + " to " + localbc;
    }
  }
  
  bn a(bj parambj, boolean paramBoolean)
  {
    label154:
    label376:
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      int i;
      try
      {
        localObject1 = parambj.f();
        if (localObject1 == null) {
          break label376;
        }
        parambj = parambj.g();
        localObject2 = ((bl)localObject1).a();
        if (localObject2 != null) {
          parambj.a("Content-Type", ((bf)localObject2).toString());
        }
        long l = ((bl)localObject1).b();
        if (l != -1L)
        {
          parambj.a("Content-Length", Long.toString(l));
          parambj.b("Transfer-Encoding");
          parambj = parambj.a();
          this.c = new dt(this.d, parambj, false, false, paramBoolean, null, null, null, null);
          i = 0;
          if (!this.a) {
            break label154;
          }
          this.c.h();
          throw new IOException("Canceled");
        }
      }
      catch (Throwable parambj)
      {
        fl.a(parambj);
        parambj = null;
        return parambj;
      }
      parambj.a("Transfer-Encoding", "chunked");
      parambj.b("Content-Length");
      continue;
      try
      {
        this.c.a();
        this.c.j();
        localObject1 = this.c.e();
        parambj = this.c.k();
        if (parambj == null)
        {
          parambj = (bj)localObject1;
          if (paramBoolean) {
            continue;
          }
          this.c.h();
          return (bn)localObject1;
        }
      }
      catch (eb parambj)
      {
        for (;;)
        {
          fl.a(parambj);
        }
      }
      catch (ee parambj)
      {
        for (;;)
        {
          localObject1 = this.c.a(parambj);
          if (localObject1 != null)
          {
            this.c = ((dt)localObject1);
            break;
          }
          fl.a(parambj);
        }
      }
      catch (IOException parambj)
      {
        for (;;)
        {
          localObject1 = this.c.a(parambj, null);
          if (localObject1 != null)
          {
            this.c = ((dt)localObject1);
            break;
          }
          fl.a(parambj);
        }
      }
      catch (Throwable parambj)
      {
        for (;;)
        {
          fl.a(parambj);
        }
        i += 1;
        if (i > 20) {
          throw new ProtocolException("Too many follow-up requests: " + i);
        }
        if (!this.c.a(parambj.a())) {
          this.c.h();
        }
        localObject2 = this.c.i();
        this.c = new dt(this.d, parambj, false, false, paramBoolean, (as)localObject2, null, null, (bn)localObject1);
      }
    }
  }
  
  public void a(an paraman)
  {
    a(paraman, false);
  }
  
  void a(an paraman, boolean paramBoolean)
  {
    try
    {
      if (this.e) {
        throw new IllegalStateException("Already Executed");
      }
    }
    finally {}
    this.e = true;
    this.d.r().a(new b(paraman, paramBoolean, null));
  }
  
  class a
    implements be.a
  {
    private final int b;
    private final bj c;
    private final boolean d;
    
    a(int paramInt, bj parambj, boolean paramBoolean)
    {
      this.b = paramInt;
      this.c = parambj;
      this.d = paramBoolean;
    }
    
    public bn a(bj parambj)
    {
      if (this.b < al.b(al.this).u().size())
      {
        parambj = new a(al.this, this.b + 1, parambj, this.d);
        return ((be)al.b(al.this).u().get(this.b)).a(parambj);
      }
      return al.this.a(parambj, this.d);
    }
  }
  
  final class b
    extends bv
  {
    private final an c;
    private final boolean d;
    
    private b(an paraman, boolean paramBoolean)
    {
      super(new Object[] { al.this.b.c() });
      this.c = paraman;
      this.d = paramBoolean;
    }
    
    String a()
    {
      return al.this.b.a().g();
    }
    
    /* Error */
    protected void b()
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_2
      //   2: aload_0
      //   3: getfield 17	com/adhoc/al$b:a	Lcom/adhoc/al;
      //   6: aload_0
      //   7: getfield 36	com/adhoc/al$b:d	Z
      //   10: invokestatic 56	com/adhoc/al:a	(Lcom/adhoc/al;Z)Lcom/adhoc/bn;
      //   13: astore_1
      //   14: aload_0
      //   15: getfield 17	com/adhoc/al$b:a	Lcom/adhoc/al;
      //   18: getfield 58	com/adhoc/al:a	Z
      //   21: istore_3
      //   22: iload_3
      //   23: ifeq +43 -> 66
      //   26: aload_0
      //   27: getfield 34	com/adhoc/al$b:c	Lcom/adhoc/an;
      //   30: aload_0
      //   31: getfield 17	com/adhoc/al$b:a	Lcom/adhoc/al;
      //   34: getfield 24	com/adhoc/al:b	Lcom/adhoc/bj;
      //   37: new 51	java/io/IOException
      //   40: dup
      //   41: ldc 60
      //   43: invokespecial 63	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   46: invokeinterface 68 3 0
      //   51: aload_0
      //   52: getfield 17	com/adhoc/al$b:a	Lcom/adhoc/al;
      //   55: invokestatic 71	com/adhoc/al:b	(Lcom/adhoc/al;)Lcom/adhoc/bg;
      //   58: invokevirtual 77	com/adhoc/bg:r	()Lcom/adhoc/ay;
      //   61: aload_0
      //   62: invokevirtual 82	com/adhoc/ay:b	(Lcom/adhoc/al$b;)V
      //   65: return
      //   66: aload_0
      //   67: getfield 34	com/adhoc/al$b:c	Lcom/adhoc/an;
      //   70: aload_1
      //   71: invokeinterface 85 2 0
      //   76: goto -25 -> 51
      //   79: astore_1
      //   80: iload_2
      //   81: ifeq +53 -> 134
      //   84: getstatic 90	com/adhoc/bt:a	Ljava/util/logging/Logger;
      //   87: getstatic 96	java/util/logging/Level:INFO	Ljava/util/logging/Level;
      //   90: new 98	java/lang/StringBuilder
      //   93: dup
      //   94: invokespecial 100	java/lang/StringBuilder:<init>	()V
      //   97: ldc 102
      //   99: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   102: aload_0
      //   103: getfield 17	com/adhoc/al$b:a	Lcom/adhoc/al;
      //   106: invokestatic 109	com/adhoc/al:a	(Lcom/adhoc/al;)Ljava/lang/String;
      //   109: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   112: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   115: aload_1
      //   116: invokevirtual 118	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   119: aload_0
      //   120: getfield 17	com/adhoc/al$b:a	Lcom/adhoc/al;
      //   123: invokestatic 71	com/adhoc/al:b	(Lcom/adhoc/al;)Lcom/adhoc/bg;
      //   126: invokevirtual 77	com/adhoc/bg:r	()Lcom/adhoc/ay;
      //   129: aload_0
      //   130: invokevirtual 82	com/adhoc/ay:b	(Lcom/adhoc/al$b;)V
      //   133: return
      //   134: aload_0
      //   135: getfield 34	com/adhoc/al$b:c	Lcom/adhoc/an;
      //   138: aload_0
      //   139: getfield 17	com/adhoc/al$b:a	Lcom/adhoc/al;
      //   142: getfield 121	com/adhoc/al:c	Lcom/adhoc/dt;
      //   145: invokevirtual 126	com/adhoc/dt:d	()Lcom/adhoc/bj;
      //   148: aload_1
      //   149: invokeinterface 68 3 0
      //   154: goto -35 -> 119
      //   157: astore_1
      //   158: aload_0
      //   159: getfield 17	com/adhoc/al$b:a	Lcom/adhoc/al;
      //   162: invokestatic 71	com/adhoc/al:b	(Lcom/adhoc/al;)Lcom/adhoc/bg;
      //   165: invokevirtual 77	com/adhoc/bg:r	()Lcom/adhoc/ay;
      //   168: aload_0
      //   169: invokevirtual 82	com/adhoc/ay:b	(Lcom/adhoc/al$b;)V
      //   172: aload_1
      //   173: athrow
      //   174: astore_1
      //   175: aload_1
      //   176: invokestatic 131	com/adhoc/fl:a	(Ljava/lang/Throwable;)V
      //   179: aload_0
      //   180: getfield 17	com/adhoc/al$b:a	Lcom/adhoc/al;
      //   183: invokestatic 71	com/adhoc/al:b	(Lcom/adhoc/al;)Lcom/adhoc/bg;
      //   186: invokevirtual 77	com/adhoc/bg:r	()Lcom/adhoc/ay;
      //   189: aload_0
      //   190: invokevirtual 82	com/adhoc/ay:b	(Lcom/adhoc/al$b;)V
      //   193: return
      //   194: astore_1
      //   195: iconst_0
      //   196: istore_2
      //   197: goto -117 -> 80
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	200	0	this	b
      //   13	58	1	localbn	bn
      //   79	70	1	localIOException1	IOException
      //   157	16	1	localObject	Object
      //   174	2	1	localThrowable	Throwable
      //   194	1	1	localIOException2	IOException
      //   1	196	2	i	int
      //   21	2	3	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   26	51	79	java/io/IOException
      //   66	76	79	java/io/IOException
      //   2	22	157	finally
      //   26	51	157	finally
      //   66	76	157	finally
      //   84	119	157	finally
      //   134	154	157	finally
      //   175	179	157	finally
      //   2	22	174	java/lang/Throwable
      //   26	51	174	java/lang/Throwable
      //   66	76	174	java/lang/Throwable
      //   2	22	194	java/io/IOException
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */