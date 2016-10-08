package b.a.c;

import b.a.a.d;
import b.a.a.d.a;
import b.a.a.d.b;
import b.a.b.t;
import b.a.b.w;
import b.a.j;
import b.ab;
import b.ai;
import b.al;
import b.al.a;
import b.aq;
import b.aq.a;
import b.at;
import b.b;
import b.y;
import c.aa;
import c.g;
import c.z;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;

public final class c
  extends d.b
  implements b.l
{
  public Socket b;
  public volatile d c;
  public int d;
  public c.h e;
  public g f;
  public int g;
  public final List<Reference<w>> h = new ArrayList();
  public boolean i;
  public long j = Long.MAX_VALUE;
  private final at k;
  private Socket l;
  private y m;
  private ai n;
  
  public c(at paramat)
  {
    this.k = paramat;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = d();
    Object localObject2 = ((al)localObject1).a();
    String str = "CONNECT " + j.a((ab)localObject2, true) + " HTTP/1.1";
    do
    {
      localObject2 = new b.a.b.e(null, this.e, this.f);
      this.e.a().a(paramInt1, TimeUnit.MILLISECONDS);
      this.f.a().a(paramInt2, TimeUnit.MILLISECONDS);
      ((b.a.b.e)localObject2).a(((al)localObject1).c(), str);
      ((b.a.b.e)localObject2).b();
      localObject1 = ((b.a.b.e)localObject2).c().a((al)localObject1).a();
      long l2 = b.a.b.o.a((aq)localObject1);
      long l1 = l2;
      if (l2 == -1L) {
        l1 = 0L;
      }
      localObject2 = ((b.a.b.e)localObject2).b(l1);
      j.b((z)localObject2, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
      ((z)localObject2).close();
      switch (((aq)localObject1).b())
      {
      default: 
        throw new IOException("Unexpected response code for CONNECT: " + ((aq)localObject1).b());
      case 200: 
        if ((this.e.c().f()) && (this.f.c().f())) {
          break;
        }
        throw new IOException("TLS tunnel buffered too many bytes!");
      case 407: 
        localObject2 = this.k.a().d().a(this.k, (aq)localObject1);
        localObject1 = localObject2;
      }
    } while (localObject2 != null);
    throw new IOException("Failed to authenticate with proxy");
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, b.a.a parama)
  {
    this.l.setSoTimeout(paramInt2);
    for (;;)
    {
      try
      {
        b.a.h.a().a(this.l, this.k.c(), paramInt1);
        this.e = c.p.a(c.p.b(this.l));
        this.f = c.p.a(c.p.a(this.l));
        if (this.k.a().i() != null)
        {
          a(paramInt2, paramInt3, parama);
          if ((this.n != ai.c) && (this.n != ai.d)) {
            break;
          }
          this.b.setSoTimeout(0);
          parama = new d.a(true).a(this.b, this.k.a().a().f(), this.e, this.f).a(this.n).a(this).a();
          parama.d();
          this.g = parama.b();
          this.c = parama;
          return;
        }
      }
      catch (ConnectException parama)
      {
        throw new ConnectException("Failed to connect to " + this.k.c());
      }
      this.n = ai.b;
      this.b = this.l;
    }
    this.g = 1;
  }
  
  /* Error */
  private void a(int paramInt1, int paramInt2, b.a.a parama)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 6
    //   9: aload_0
    //   10: getfield 47	b/a/c/c:k	Lb/at;
    //   13: invokevirtual 282	b/at:d	()Z
    //   16: ifeq +9 -> 25
    //   19: aload_0
    //   20: iload_1
    //   21: iload_2
    //   22: invokespecial 284	b/a/c/c:a	(II)V
    //   25: aload_0
    //   26: getfield 47	b/a/c/c:k	Lb/at;
    //   29: invokevirtual 175	b/at:a	()Lb/a;
    //   32: astore 8
    //   34: aload 8
    //   36: invokevirtual 226	b/a:i	()Ljavax/net/ssl/SSLSocketFactory;
    //   39: astore 5
    //   41: aload 5
    //   43: aload_0
    //   44: getfield 192	b/a/c/c:l	Ljava/net/Socket;
    //   47: aload 8
    //   49: invokevirtual 245	b/a:a	()Lb/ab;
    //   52: invokevirtual 249	b/ab:f	()Ljava/lang/String;
    //   55: aload 8
    //   57: invokevirtual 245	b/a:a	()Lb/ab;
    //   60: invokevirtual 286	b/ab:g	()I
    //   63: iconst_1
    //   64: invokevirtual 292	javax/net/ssl/SSLSocketFactory:createSocket	(Ljava/net/Socket;Ljava/lang/String;IZ)Ljava/net/Socket;
    //   67: checkcast 294	javax/net/ssl/SSLSocket
    //   70: astore 5
    //   72: aload_3
    //   73: aload 5
    //   75: invokevirtual 299	b/a/a:a	(Ljavax/net/ssl/SSLSocket;)Lb/o;
    //   78: astore 6
    //   80: aload 6
    //   82: invokevirtual 302	b/o:d	()Z
    //   85: ifeq +24 -> 109
    //   88: invokestatic 203	b/a/h:a	()Lb/a/h;
    //   91: aload 5
    //   93: aload 8
    //   95: invokevirtual 245	b/a:a	()Lb/ab;
    //   98: invokevirtual 249	b/ab:f	()Ljava/lang/String;
    //   101: aload 8
    //   103: invokevirtual 305	b/a:e	()Ljava/util/List;
    //   106: invokevirtual 308	b/a/h:a	(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V
    //   109: aload 5
    //   111: invokevirtual 311	javax/net/ssl/SSLSocket:startHandshake	()V
    //   114: aload 5
    //   116: invokevirtual 315	javax/net/ssl/SSLSocket:getSession	()Ljavax/net/ssl/SSLSession;
    //   119: invokestatic 320	b/y:a	(Ljavax/net/ssl/SSLSession;)Lb/y;
    //   122: astore 4
    //   124: aload 8
    //   126: invokevirtual 323	b/a:j	()Ljavax/net/ssl/HostnameVerifier;
    //   129: aload 8
    //   131: invokevirtual 245	b/a:a	()Lb/ab;
    //   134: invokevirtual 249	b/ab:f	()Ljava/lang/String;
    //   137: aload 5
    //   139: invokevirtual 315	javax/net/ssl/SSLSocket:getSession	()Ljavax/net/ssl/SSLSession;
    //   142: invokeinterface 329 3 0
    //   147: ifne +157 -> 304
    //   150: aload 4
    //   152: invokevirtual 331	b/y:b	()Ljava/util/List;
    //   155: iconst_0
    //   156: invokeinterface 337 2 0
    //   161: checkcast 339	java/security/cert/X509Certificate
    //   164: astore_3
    //   165: new 341	javax/net/ssl/SSLPeerUnverifiedException
    //   168: dup
    //   169: new 60	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 343
    //   179: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload 8
    //   184: invokevirtual 245	b/a:a	()Lb/ab;
    //   187: invokevirtual 249	b/ab:f	()Ljava/lang/String;
    //   190: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: ldc_w 345
    //   196: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: ldc_w 347
    //   202: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_3
    //   206: invokestatic 352	b/i:a	(Ljava/security/cert/Certificate;)Ljava/lang/String;
    //   209: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: ldc_w 354
    //   215: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload_3
    //   219: invokevirtual 358	java/security/cert/X509Certificate:getSubjectDN	()Ljava/security/Principal;
    //   222: invokeinterface 363 1 0
    //   227: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: ldc_w 365
    //   233: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload_3
    //   237: invokestatic 370	b/a/d/d:a	(Ljava/security/cert/X509Certificate;)Ljava/util/List;
    //   240: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   243: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokespecial 371	javax/net/ssl/SSLPeerUnverifiedException:<init>	(Ljava/lang/String;)V
    //   249: athrow
    //   250: astore 4
    //   252: aload 5
    //   254: astore_3
    //   255: aload 4
    //   257: astore 5
    //   259: aload_3
    //   260: astore 4
    //   262: aload 5
    //   264: invokestatic 374	b/a/j:a	(Ljava/lang/AssertionError;)Z
    //   267: ifeq +153 -> 420
    //   270: aload_3
    //   271: astore 4
    //   273: new 151	java/io/IOException
    //   276: dup
    //   277: aload 5
    //   279: invokespecial 377	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   282: athrow
    //   283: astore_3
    //   284: aload 4
    //   286: ifnull +11 -> 297
    //   289: invokestatic 203	b/a/h:a	()Lb/a/h;
    //   292: aload 4
    //   294: invokevirtual 380	b/a/h:a	(Ljavax/net/ssl/SSLSocket;)V
    //   297: aload 4
    //   299: invokestatic 383	b/a/j:a	(Ljava/net/Socket;)V
    //   302: aload_3
    //   303: athrow
    //   304: aload 8
    //   306: invokevirtual 386	b/a:k	()Lb/i;
    //   309: aload 8
    //   311: invokevirtual 245	b/a:a	()Lb/ab;
    //   314: invokevirtual 249	b/ab:f	()Ljava/lang/String;
    //   317: aload 4
    //   319: invokevirtual 331	b/y:b	()Ljava/util/List;
    //   322: invokevirtual 389	b/i:a	(Ljava/lang/String;Ljava/util/List;)V
    //   325: aload 7
    //   327: astore_3
    //   328: aload 6
    //   330: invokevirtual 302	b/o:d	()Z
    //   333: ifeq +12 -> 345
    //   336: invokestatic 203	b/a/h:a	()Lb/a/h;
    //   339: aload 5
    //   341: invokevirtual 392	b/a/h:b	(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;
    //   344: astore_3
    //   345: aload_0
    //   346: aload 5
    //   348: putfield 239	b/a/c/c:b	Ljava/net/Socket;
    //   351: aload_0
    //   352: aload_0
    //   353: getfield 239	b/a/c/c:b	Ljava/net/Socket;
    //   356: invokestatic 214	c/p:b	(Ljava/net/Socket;)Lc/z;
    //   359: invokestatic 217	c/p:a	(Lc/z;)Lc/h;
    //   362: putfield 82	b/a/c/c:e	Lc/h;
    //   365: aload_0
    //   366: aload_0
    //   367: getfield 239	b/a/c/c:b	Ljava/net/Socket;
    //   370: invokestatic 220	c/p:a	(Ljava/net/Socket;)Lc/y;
    //   373: invokestatic 223	c/p:a	(Lc/y;)Lc/g;
    //   376: putfield 84	b/a/c/c:f	Lc/g;
    //   379: aload_0
    //   380: aload 4
    //   382: putfield 394	b/a/c/c:m	Lb/y;
    //   385: aload_3
    //   386: ifnull +27 -> 413
    //   389: aload_3
    //   390: invokestatic 397	b/ai:a	(Ljava/lang/String;)Lb/ai;
    //   393: astore_3
    //   394: aload_0
    //   395: aload_3
    //   396: putfield 231	b/a/c/c:n	Lb/ai;
    //   399: aload 5
    //   401: ifnull +11 -> 412
    //   404: invokestatic 203	b/a/h:a	()Lb/a/h;
    //   407: aload 5
    //   409: invokevirtual 380	b/a/h:a	(Ljavax/net/ssl/SSLSocket;)V
    //   412: return
    //   413: getstatic 278	b/ai:b	Lb/ai;
    //   416: astore_3
    //   417: goto -23 -> 394
    //   420: aload_3
    //   421: astore 4
    //   423: aload 5
    //   425: athrow
    //   426: astore_3
    //   427: aload 5
    //   429: astore 4
    //   431: goto -147 -> 284
    //   434: astore 5
    //   436: aload 6
    //   438: astore_3
    //   439: goto -180 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	442	0	this	c
    //   0	442	1	paramInt1	int
    //   0	442	2	paramInt2	int
    //   0	442	3	parama	b.a.a
    //   1	150	4	localy	y
    //   250	6	4	localAssertionError1	AssertionError
    //   260	170	4	localObject1	Object
    //   39	389	5	localObject2	Object
    //   434	1	5	localAssertionError2	AssertionError
    //   7	430	6	localo	b.o
    //   4	322	7	localObject3	Object
    //   32	278	8	locala	b.a
    // Exception table:
    //   from	to	target	type
    //   72	109	250	java/lang/AssertionError
    //   109	250	250	java/lang/AssertionError
    //   304	325	250	java/lang/AssertionError
    //   328	345	250	java/lang/AssertionError
    //   345	385	250	java/lang/AssertionError
    //   389	394	250	java/lang/AssertionError
    //   394	399	250	java/lang/AssertionError
    //   413	417	250	java/lang/AssertionError
    //   41	72	283	finally
    //   262	270	283	finally
    //   273	283	283	finally
    //   423	426	283	finally
    //   72	109	426	finally
    //   109	250	426	finally
    //   304	325	426	finally
    //   328	345	426	finally
    //   345	385	426	finally
    //   389	394	426	finally
    //   394	399	426	finally
    //   413	417	426	finally
    //   41	72	434	java/lang/AssertionError
  }
  
  private al d()
  {
    return new al.a().a(this.k.a().a()).a("Host", j.a(this.k.a().a(), true)).a("Proxy-Connection", "Keep-Alive").a("User-Agent", b.a.l.a()).b();
  }
  
  public at a()
  {
    return this.k;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, List<b.o> paramList, boolean paramBoolean)
  {
    if (this.n != null) {
      throw new IllegalStateException("already connected");
    }
    b.a.a locala = new b.a.a(paramList);
    Proxy localProxy = this.k.b();
    b.a locala1 = this.k.a();
    if ((this.k.a().i() == null) && (!paramList.contains(b.o.c))) {
      throw new t(new UnknownServiceException("CLEARTEXT communication not supported: " + paramList));
    }
    for (;;)
    {
      try
      {
        localObject = new Socket(localProxy);
        this.l = ((Socket)localObject);
        a(paramInt1, paramInt2, paramInt3, locala);
      }
      catch (IOException localIOException)
      {
        j.a(this.b);
        j.a(this.l);
        this.b = null;
        this.l = null;
        this.e = null;
        this.f = null;
        this.m = null;
        this.n = null;
        if (paramList != null) {
          continue;
        }
        Object localObject = new t(localIOException);
        if (!paramBoolean) {
          continue;
        }
        paramList = (List<b.o>)localObject;
        if (locala.a(localIOException)) {
          continue;
        }
        throw ((Throwable)localObject);
        paramList.a(localIOException);
        localObject = paramList;
        continue;
      }
      if (this.n == null)
      {
        if ((localProxy.type() == Proxy.Type.DIRECT) || (localProxy.type() == Proxy.Type.HTTP)) {
          localObject = locala1.c().createSocket();
        }
      }
      else
      {
        return;
        paramList = null;
      }
    }
  }
  
  public void a(d paramd)
  {
    this.g = paramd.b();
  }
  
  public void a(b.a.a.p paramp)
  {
    paramp.a(b.a.a.a.k);
  }
  
  public boolean a(boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((this.b.isClosed()) || (this.b.isInputShutdown()) || (this.b.isOutputShutdown())) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.c != null);
      bool1 = bool2;
    } while (!paramBoolean);
    try
    {
      int i1 = this.b.getSoTimeout();
      try
      {
        this.b.setSoTimeout(1);
        paramBoolean = this.e.f();
        return !paramBoolean;
      }
      finally
      {
        this.b.setSoTimeout(i1);
      }
      return true;
    }
    catch (IOException localIOException)
    {
      return false;
    }
    catch (SocketTimeoutException localSocketTimeoutException) {}
  }
  
  public Socket b()
  {
    return this.b;
  }
  
  public y c()
  {
    return this.m;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Connection{").append(this.k.a().a().f()).append(":").append(this.k.a().a().g()).append(", proxy=").append(this.k.b()).append(" hostAddress=").append(this.k.c()).append(" cipherSuite=");
    if (this.m != null) {}
    for (Object localObject = this.m.a();; localObject = "none") {
      return localObject + " protocol=" + this.n + '}';
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\a\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */