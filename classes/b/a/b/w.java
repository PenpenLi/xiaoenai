package b.a.b;

import b.a;
import b.a.c.c;
import b.a.d;
import b.a.i;
import b.a.j;
import b.at;
import b.m;
import c.y;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class w
{
  public final a a;
  private at b;
  private final m c;
  private u d;
  private c e;
  private boolean f;
  private boolean g;
  private n h;
  
  public w(m paramm, a parama)
  {
    this.c = paramm;
    this.a = parama;
    this.d = new u(parama, d());
  }
  
  private c a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    synchronized (this.c)
    {
      if (this.f) {
        throw new IllegalStateException("released");
      }
    }
    if (this.h != null) {
      throw new IllegalStateException("stream != null");
    }
    if (this.g) {
      throw new IOException("Canceled");
    }
    ??? = this.e;
    if ((??? != null) && (!((c)???).i)) {
      return (c)???;
    }
    ??? = d.b.a(this.c, this.a, this);
    if (??? != null)
    {
      this.e = ((c)???);
      return (c)???;
    }
    ??? = this.b;
    if (??? == null) {
      ??? = this.d.b();
    }
    for (;;)
    {
      synchronized (this.c)
      {
        this.b = ((at)???);
        ??? = new c((at)???);
        a((c)???);
        synchronized (this.c)
        {
          d.b.b(this.c, (c)???);
          this.e = ((c)???);
          if (this.g) {
            throw new IOException("Canceled");
          }
        }
      }
      localc.a(paramInt1, paramInt2, paramInt3, this.a.f(), paramBoolean);
      d().b(localc.a());
      return localc;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    m localm = this.c;
    if (paramBoolean3) {}
    try
    {
      this.h = null;
      if (paramBoolean2) {
        this.f = true;
      }
      Object localObject1 = localObject4;
      if (this.e != null)
      {
        if (paramBoolean1) {
          this.e.i = true;
        }
        localObject1 = localObject4;
        if (this.h == null) {
          if (!this.f)
          {
            localObject1 = localObject4;
            if (!this.e.i) {}
          }
          else
          {
            b(this.e);
            localObject1 = localObject3;
            if (this.e.h.isEmpty())
            {
              this.e.j = System.nanoTime();
              localObject1 = localObject3;
              if (d.b.a(this.c, this.e)) {
                localObject1 = this.e;
              }
            }
            this.e = null;
          }
        }
      }
      if (localObject1 != null) {
        j.a(((c)localObject1).b());
      }
      return;
    }
    finally {}
  }
  
  private c b(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      c localc1 = a(paramInt1, paramInt2, paramInt3, paramBoolean1);
      synchronized (this.c)
      {
        if (localc1.d == 0) {
          return localc1;
        }
        if (!localc1.a(paramBoolean2)) {
          a(new IOException());
        }
      }
    }
    return localc2;
  }
  
  private void b(c paramc)
  {
    int j = paramc.h.size();
    int i = 0;
    while (i < j)
    {
      if (((Reference)paramc.h.get(i)).get() == this)
      {
        paramc.h.remove(i);
        return;
      }
      i += 1;
    }
    throw new IllegalStateException();
  }
  
  private boolean b(IOException paramIOException)
  {
    if ((paramIOException instanceof ProtocolException)) {}
    do
    {
      return false;
      if ((paramIOException instanceof InterruptedIOException)) {
        return paramIOException instanceof SocketTimeoutException;
      }
    } while ((((paramIOException instanceof SSLHandshakeException)) && ((paramIOException.getCause() instanceof CertificateException))) || ((paramIOException instanceof SSLPeerUnverifiedException)));
    return true;
  }
  
  private i d()
  {
    return d.b.a(this.c);
  }
  
  /* Error */
  public n a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: iload_2
    //   3: iload_3
    //   4: iload 4
    //   6: iload 5
    //   8: invokespecial 189	b/a/b/w:b	(IIIZZ)Lb/a/c/c;
    //   11: astore 6
    //   13: aload 6
    //   15: getfield 192	b/a/c/c:c	Lb/a/a/d;
    //   18: ifnull +39 -> 57
    //   21: new 194	b/a/b/g
    //   24: dup
    //   25: aload_0
    //   26: aload 6
    //   28: getfield 192	b/a/c/c:c	Lb/a/a/d;
    //   31: invokespecial 197	b/a/b/g:<init>	(Lb/a/b/w;Lb/a/a/d;)V
    //   34: astore 6
    //   36: aload_0
    //   37: getfield 26	b/a/b/w:c	Lb/m;
    //   40: astore 7
    //   42: aload 7
    //   44: monitorenter
    //   45: aload_0
    //   46: aload 6
    //   48: putfield 51	b/a/b/w:h	Lb/a/b/n;
    //   51: aload 7
    //   53: monitorexit
    //   54: aload 6
    //   56: areturn
    //   57: aload 6
    //   59: invokevirtual 131	b/a/c/c:b	()Ljava/net/Socket;
    //   62: iload_2
    //   63: invokevirtual 203	java/net/Socket:setSoTimeout	(I)V
    //   66: aload 6
    //   68: getfield 206	b/a/c/c:e	Lc/h;
    //   71: invokeinterface 211 1 0
    //   76: iload_2
    //   77: i2l
    //   78: getstatic 217	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   81: invokevirtual 222	c/aa:a	(JLjava/util/concurrent/TimeUnit;)Lc/aa;
    //   84: pop
    //   85: aload 6
    //   87: getfield 225	b/a/c/c:f	Lc/g;
    //   90: invokeinterface 228 1 0
    //   95: iload_3
    //   96: i2l
    //   97: getstatic 217	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   100: invokevirtual 222	c/aa:a	(JLjava/util/concurrent/TimeUnit;)Lc/aa;
    //   103: pop
    //   104: new 230	b/a/b/e
    //   107: dup
    //   108: aload_0
    //   109: aload 6
    //   111: getfield 206	b/a/c/c:e	Lc/h;
    //   114: aload 6
    //   116: getfield 225	b/a/c/c:f	Lc/g;
    //   119: invokespecial 233	b/a/b/e:<init>	(Lb/a/b/w;Lc/h;Lc/g;)V
    //   122: astore 6
    //   124: goto -88 -> 36
    //   127: astore 6
    //   129: new 235	b/a/b/t
    //   132: dup
    //   133: aload 6
    //   135: invokespecial 237	b/a/b/t:<init>	(Ljava/io/IOException;)V
    //   138: athrow
    //   139: astore 6
    //   141: aload 7
    //   143: monitorexit
    //   144: aload 6
    //   146: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	w
    //   0	147	1	paramInt1	int
    //   0	147	2	paramInt2	int
    //   0	147	3	paramInt3	int
    //   0	147	4	paramBoolean1	boolean
    //   0	147	5	paramBoolean2	boolean
    //   11	112	6	localObject1	Object
    //   127	7	6	localIOException	IOException
    //   139	6	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	36	127	java/io/IOException
    //   36	45	127	java/io/IOException
    //   57	124	127	java/io/IOException
    //   144	147	127	java/io/IOException
    //   45	54	139	finally
    //   141	144	139	finally
  }
  
  public c a()
  {
    try
    {
      c localc = this.e;
      return localc;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(c paramc)
  {
    paramc.h.add(new WeakReference(this));
  }
  
  public void a(IOException paramIOException)
  {
    synchronized (this.c)
    {
      if ((this.e != null) && (this.e.d == 0))
      {
        if ((this.b != null) && (paramIOException != null)) {
          this.d.a(this.b, paramIOException);
        }
        this.b = null;
      }
      a(true, false, true);
      return;
    }
  }
  
  public void a(boolean paramBoolean, n paramn)
  {
    m localm = this.c;
    if (paramn != null) {}
    try
    {
      if (paramn != this.h) {
        throw new IllegalStateException("expected " + this.h + " but was " + paramn);
      }
    }
    finally
    {
      throw paramn;
      if (!paramBoolean)
      {
        paramn = this.e;
        paramn.d += 1;
      }
    }
  }
  
  public boolean a(IOException paramIOException, y paramy)
  {
    boolean bool = true;
    if (this.e != null) {
      a(paramIOException);
    }
    if ((paramy == null) || ((paramy instanceof s))) {}
    for (int i = 1;; i = 0)
    {
      if (((this.d != null) && (!this.d.a())) || (!b(paramIOException)) || (i == 0)) {
        bool = false;
      }
      return bool;
    }
  }
  
  public void b()
  {
    a(false, true, false);
  }
  
  public void c()
  {
    a(true, false, false);
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\a\b\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */