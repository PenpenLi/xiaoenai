package com.adhoc;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;

public final class as
{
  private final at a;
  private final bq b;
  private Socket c;
  private boolean d = false;
  private dp e;
  private ch f;
  private bi g = bi.b;
  private long h;
  private az i;
  private int j;
  private Object k;
  
  public as(at paramat, bq parambq)
  {
    this.a = paramat;
    this.b = parambq;
  }
  
  private bj a(bj parambj)
  {
    Object localObject = new bc.a().a("https").b(parambj.a().g()).a(parambj.a().h()).b();
    localObject = new bj.a().a((bc)localObject).a("Host", cb.a((bc)localObject)).a("Proxy-Connection", "Keep-Alive");
    String str = parambj.a("User-Agent");
    if (str != null) {
      ((bj.a)localObject).a("User-Agent", str);
    }
    parambj = parambj.a("Proxy-Authorization");
    if (parambj != null) {
      ((bj.a)localObject).a("Proxy-Authorization", parambj);
    }
    return ((bj.a)localObject).a();
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, bj parambj, bs parambs)
  {
    this.c.setSoTimeout(paramInt2);
    bz.a().a(this.c, this.b.c(), paramInt1);
    if (this.b.a.d() != null) {
      a(paramInt2, paramInt3, parambj, parambs);
    }
    if ((this.g == bi.c) || (this.g == bi.d))
    {
      this.c.setSoTimeout(0);
      this.f = new ch.a(this.b.a.b, true, this.c).a(this.g).a();
      this.f.e();
      return;
    }
    this.e = new dp(this.a, this, this.c);
  }
  
  private void a(int paramInt1, int paramInt2, bj parambj)
  {
    for (;;)
    {
      dp localdp;
      Object localObject;
      try
      {
        parambj = a(parambj);
        localdp = new dp(this.a, this, this.c);
        localdp.a(paramInt1, paramInt2);
        localObject = parambj.a();
        String str = "CONNECT " + ((bc)localObject).g() + ":" + ((bc)localObject).h() + " HTTP/1.1";
        localdp.a(parambj.e(), str);
        localdp.d();
        parambj = localdp.g().a(parambj).a();
        long l2 = dy.a(parambj);
        long l1 = l2;
        if (l2 == -1L) {
          l1 = 0L;
        }
        localObject = localdp.b(l1);
        cb.b((fg)localObject, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        ((fg)localObject).close();
        switch (parambj.c())
        {
        case 200: 
          throw new IOException("Unexpected response code for CONNECT: " + parambj.c());
        }
      }
      catch (Throwable parambj)
      {
        fl.a(parambj);
        return;
      }
      if (localdp.e() > 0L)
      {
        throw new IOException("TLS tunnel buffered too many bytes!");
        localObject = dy.a(this.b.a().f(), parambj, this.b.b());
        parambj = (bj)localObject;
        if (localObject == null) {
          throw new IOException("Failed to authenticate with proxy");
        }
      }
    }
  }
  
  /* Error */
  private void a(int paramInt1, int paramInt2, bj parambj, bs parambs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_0
    //   7: getfield 43	com/adhoc/as:b	Lcom/adhoc/bq;
    //   10: invokevirtual 276	com/adhoc/bq:d	()Z
    //   13: ifeq +10 -> 23
    //   16: aload_0
    //   17: iload_1
    //   18: iload_2
    //   19: aload_3
    //   20: invokespecial 278	com/adhoc/as:a	(IILcom/adhoc/bj;)V
    //   23: aload_0
    //   24: getfield 43	com/adhoc/as:b	Lcom/adhoc/bq;
    //   27: invokevirtual 262	com/adhoc/bq:a	()Lcom/adhoc/ag;
    //   30: astore 7
    //   32: aload 7
    //   34: invokevirtual 133	com/adhoc/ag:d	()Ljavax/net/ssl/SSLSocketFactory;
    //   37: aload_0
    //   38: getfield 106	com/adhoc/as:c	Ljava/net/Socket;
    //   41: aload 7
    //   43: invokevirtual 280	com/adhoc/ag:a	()Ljava/lang/String;
    //   46: aload 7
    //   48: invokevirtual 282	com/adhoc/ag:b	()I
    //   51: iconst_1
    //   52: invokevirtual 288	javax/net/ssl/SSLSocketFactory:createSocket	(Ljava/net/Socket;Ljava/lang/String;IZ)Ljava/net/Socket;
    //   55: checkcast 290	javax/net/ssl/SSLSocket
    //   58: astore_3
    //   59: aload 4
    //   61: aload_3
    //   62: invokevirtual 295	com/adhoc/bs:a	(Ljavax/net/ssl/SSLSocket;)Lcom/adhoc/av;
    //   65: astore 8
    //   67: aload 8
    //   69: invokevirtual 299	com/adhoc/av:c	()Z
    //   72: istore 9
    //   74: iload 9
    //   76: ifeq +20 -> 96
    //   79: invokestatic 117	com/adhoc/bz:a	()Lcom/adhoc/bz;
    //   82: aload_3
    //   83: aload 7
    //   85: invokevirtual 280	com/adhoc/ag:a	()Ljava/lang/String;
    //   88: aload 7
    //   90: invokevirtual 302	com/adhoc/ag:g	()Ljava/util/List;
    //   93: invokevirtual 305	com/adhoc/bz:a	(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V
    //   96: aload_3
    //   97: invokevirtual 308	javax/net/ssl/SSLSocket:startHandshake	()V
    //   100: aload_3
    //   101: invokevirtual 312	javax/net/ssl/SSLSocket:getSession	()Ljavax/net/ssl/SSLSession;
    //   104: invokestatic 317	com/adhoc/az:a	(Ljavax/net/ssl/SSLSession;)Lcom/adhoc/az;
    //   107: astore 6
    //   109: aload 7
    //   111: invokevirtual 320	com/adhoc/ag:e	()Ljavax/net/ssl/HostnameVerifier;
    //   114: aload 7
    //   116: invokevirtual 280	com/adhoc/ag:a	()Ljava/lang/String;
    //   119: aload_3
    //   120: invokevirtual 312	javax/net/ssl/SSLSocket:getSession	()Ljavax/net/ssl/SSLSession;
    //   123: invokeinterface 326 3 0
    //   128: ifne +165 -> 293
    //   131: aload 6
    //   133: invokevirtual 328	com/adhoc/az:b	()Ljava/util/List;
    //   136: iconst_0
    //   137: invokeinterface 334 2 0
    //   142: checkcast 336	java/security/cert/X509Certificate
    //   145: astore 4
    //   147: new 338	javax/net/ssl/SSLPeerUnverifiedException
    //   150: dup
    //   151: new 177	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   158: ldc_w 340
    //   161: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload 7
    //   166: invokevirtual 280	com/adhoc/ag:a	()Ljava/lang/String;
    //   169: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: ldc_w 342
    //   175: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: ldc_w 344
    //   181: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload 4
    //   186: invokestatic 349	com/adhoc/ao:a	(Ljava/security/cert/Certificate;)Ljava/lang/String;
    //   189: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: ldc_w 351
    //   195: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload 4
    //   200: invokevirtual 355	java/security/cert/X509Certificate:getSubjectDN	()Ljava/security/Principal;
    //   203: invokeinterface 360 1 0
    //   208: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: ldc_w 362
    //   214: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload 4
    //   219: invokestatic 367	com/adhoc/ej:a	(Ljava/security/cert/X509Certificate;)Ljava/util/List;
    //   222: invokevirtual 370	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokespecial 371	javax/net/ssl/SSLPeerUnverifiedException:<init>	(Ljava/lang/String;)V
    //   231: athrow
    //   232: astore 4
    //   234: aload 4
    //   236: invokestatic 254	com/adhoc/fl:a	(Ljava/lang/Throwable;)V
    //   239: aload_3
    //   240: ifnull +10 -> 250
    //   243: invokestatic 117	com/adhoc/bz:a	()Lcom/adhoc/bz;
    //   246: aload_3
    //   247: invokevirtual 374	com/adhoc/bz:a	(Ljavax/net/ssl/SSLSocket;)V
    //   250: aload_3
    //   251: invokestatic 377	com/adhoc/cb:a	(Ljava/net/Socket;)V
    //   254: return
    //   255: astore 4
    //   257: aload 4
    //   259: invokestatic 254	com/adhoc/fl:a	(Ljava/lang/Throwable;)V
    //   262: goto -166 -> 96
    //   265: astore 5
    //   267: aload_3
    //   268: astore 4
    //   270: aload 5
    //   272: astore_3
    //   273: aload 4
    //   275: ifnull +11 -> 286
    //   278: invokestatic 117	com/adhoc/bz:a	()Lcom/adhoc/bz;
    //   281: aload 4
    //   283: invokevirtual 374	com/adhoc/bz:a	(Ljavax/net/ssl/SSLSocket;)V
    //   286: aload 4
    //   288: invokestatic 377	com/adhoc/cb:a	(Ljava/net/Socket;)V
    //   291: aload_3
    //   292: athrow
    //   293: aload 7
    //   295: invokevirtual 380	com/adhoc/ag:k	()Lcom/adhoc/ao;
    //   298: aload 7
    //   300: invokevirtual 280	com/adhoc/ag:a	()Ljava/lang/String;
    //   303: aload 6
    //   305: invokevirtual 328	com/adhoc/az:b	()Ljava/util/List;
    //   308: invokevirtual 383	com/adhoc/ao:a	(Ljava/lang/String;Ljava/util/List;)V
    //   311: aload 5
    //   313: astore 4
    //   315: aload 8
    //   317: invokevirtual 299	com/adhoc/av:c	()Z
    //   320: ifeq +12 -> 332
    //   323: invokestatic 117	com/adhoc/bz:a	()Lcom/adhoc/bz;
    //   326: aload_3
    //   327: invokevirtual 386	com/adhoc/bz:b	(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;
    //   330: astore 4
    //   332: aload 4
    //   334: ifnull +45 -> 379
    //   337: aload 4
    //   339: invokestatic 389	com/adhoc/bi:a	(Ljava/lang/String;)Lcom/adhoc/bi;
    //   342: astore 4
    //   344: aload_0
    //   345: aload 4
    //   347: putfield 39	com/adhoc/as:g	Lcom/adhoc/bi;
    //   350: aload_0
    //   351: aload 6
    //   353: putfield 391	com/adhoc/as:i	Lcom/adhoc/az;
    //   356: aload_0
    //   357: aload_3
    //   358: putfield 106	com/adhoc/as:c	Ljava/net/Socket;
    //   361: aload_3
    //   362: ifnull -108 -> 254
    //   365: invokestatic 117	com/adhoc/bz:a	()Lcom/adhoc/bz;
    //   368: aload_3
    //   369: invokevirtual 374	com/adhoc/bz:a	(Ljavax/net/ssl/SSLSocket;)V
    //   372: return
    //   373: astore_3
    //   374: aload_3
    //   375: invokestatic 254	com/adhoc/fl:a	(Ljava/lang/Throwable;)V
    //   378: return
    //   379: getstatic 37	com/adhoc/bi:b	Lcom/adhoc/bi;
    //   382: astore 4
    //   384: goto -40 -> 344
    //   387: astore 4
    //   389: aload 4
    //   391: invokestatic 254	com/adhoc/fl:a	(Ljava/lang/Throwable;)V
    //   394: goto -144 -> 250
    //   397: astore 5
    //   399: aload 5
    //   401: invokestatic 254	com/adhoc/fl:a	(Ljava/lang/Throwable;)V
    //   404: goto -118 -> 286
    //   407: astore_3
    //   408: aload 6
    //   410: astore 4
    //   412: goto -139 -> 273
    //   415: astore 5
    //   417: aload_3
    //   418: astore 4
    //   420: aload 5
    //   422: astore_3
    //   423: goto -150 -> 273
    //   426: astore 4
    //   428: aconst_null
    //   429: astore_3
    //   430: goto -196 -> 234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	433	0	this	as
    //   0	433	1	paramInt1	int
    //   0	433	2	paramInt2	int
    //   0	433	3	parambj	bj
    //   0	433	4	parambs	bs
    //   1	1	5	localObject1	Object
    //   265	47	5	localObject2	Object
    //   397	3	5	localThrowable	Throwable
    //   415	6	5	localObject3	Object
    //   4	405	6	localaz	az
    //   30	269	7	localag	ag
    //   65	251	8	localav	av
    //   72	3	9	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   59	74	232	java/lang/Throwable
    //   96	232	232	java/lang/Throwable
    //   257	262	232	java/lang/Throwable
    //   293	311	232	java/lang/Throwable
    //   315	332	232	java/lang/Throwable
    //   337	344	232	java/lang/Throwable
    //   344	361	232	java/lang/Throwable
    //   379	384	232	java/lang/Throwable
    //   79	96	255	java/lang/Throwable
    //   59	74	265	finally
    //   79	96	265	finally
    //   96	232	265	finally
    //   257	262	265	finally
    //   293	311	265	finally
    //   315	332	265	finally
    //   337	344	265	finally
    //   344	361	265	finally
    //   379	384	265	finally
    //   365	372	373	java/lang/Throwable
    //   243	250	387	java/lang/Throwable
    //   278	286	397	java/lang/Throwable
    //   6	23	407	finally
    //   23	59	407	finally
    //   234	239	415	finally
    //   6	23	426	java/lang/Throwable
    //   23	59	426	java/lang/Throwable
  }
  
  eh a(dt paramdt)
  {
    if (this.f != null) {
      return new dn(paramdt, this.f);
    }
    return new dx(paramdt, this.e);
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if (!this.d) {
      throw new IllegalStateException("setTimeouts - not connected");
    }
    if (this.e != null) {}
    try
    {
      this.c.setSoTimeout(paramInt1);
      this.e.a(paramInt1, paramInt2);
      return;
    }
    catch (IOException localIOException)
    {
      throw new ee(localIOException);
    }
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, bj parambj, List<av> paramList, boolean paramBoolean)
  {
    if (this.d) {
      throw new IllegalStateException("already connected");
    }
    bs localbs = new bs(paramList);
    Proxy localProxy = this.b.b();
    ag localag = this.b.a();
    if ((this.b.a.d() == null) && (!paramList.contains(av.c))) {
      throw new ee(new UnknownServiceException("CLEARTEXT communication not supported: " + paramList));
    }
    for (;;)
    {
      try
      {
        localSocket = new Socket(localProxy);
        this.c = localSocket;
        a(paramInt1, paramInt2, paramInt3, parambj, localbs);
        this.d = true;
      }
      catch (IOException localIOException)
      {
        Socket localSocket;
        cb.a(this.c);
        this.c = null;
        if (paramList != null) {
          continue;
        }
        paramList = new ee(localIOException);
        if ((paramBoolean) && (localbs.a(localIOException))) {
          continue;
        }
        throw paramList;
        paramList.a(localIOException);
        continue;
        continue;
      }
      catch (Throwable localThrowable)
      {
        fl.a(localThrowable);
        continue;
      }
      if (!this.d)
      {
        if ((localProxy.type() == Proxy.Type.DIRECT) || (localProxy.type() == Proxy.Type.HTTP)) {
          localSocket = localag.c().createSocket();
        }
      }
      else
      {
        return;
        paramList = null;
      }
    }
  }
  
  void a(bg parambg, Object paramObject, bj parambj)
  {
    try
    {
      a(paramObject);
      if (!b())
      {
        paramObject = this.b.a.h();
        a(parambg.a(), parambg.b(), parambg.c(), parambj, (List)paramObject, parambg.p());
        if (k()) {
          parambg.m().b(this);
        }
        parambg.q().b(c());
      }
      a(parambg.b(), parambg.c());
      return;
    }
    catch (Throwable parambg)
    {
      fl.a(parambg);
    }
  }
  
  void a(bi parambi)
  {
    if (parambi == null) {
      throw new IllegalArgumentException("protocol == null");
    }
    this.g = parambi;
  }
  
  void a(Object paramObject)
  {
    try
    {
      if (k()) {
        return;
      }
      synchronized (this.a)
      {
        if (this.k != null) {
          throw new IllegalStateException("Connection already has an owner!");
        }
      }
      this.k = paramObject;
    }
    catch (Throwable paramObject)
    {
      fl.a((Throwable)paramObject);
      return;
    }
  }
  
  boolean a()
  {
    synchronized (this.a)
    {
      if (this.k == null) {
        return false;
      }
      this.k = null;
      return true;
    }
  }
  
  boolean b()
  {
    return this.d;
  }
  
  public bq c()
  {
    return this.b;
  }
  
  public Socket d()
  {
    return this.c;
  }
  
  boolean e()
  {
    return (!this.c.isClosed()) && (!this.c.isInputShutdown()) && (!this.c.isOutputShutdown());
  }
  
  boolean f()
  {
    if (this.e != null) {
      return this.e.f();
    }
    return true;
  }
  
  void g()
  {
    if (this.f != null) {
      throw new IllegalStateException("framedConnection != null");
    }
    this.h = System.nanoTime();
  }
  
  boolean h()
  {
    return (this.f == null) || (this.f.b());
  }
  
  long i()
  {
    if (this.f == null) {
      return this.h;
    }
    return this.f.c();
  }
  
  public az j()
  {
    return this.i;
  }
  
  boolean k()
  {
    return this.f != null;
  }
  
  public bi l()
  {
    return this.g;
  }
  
  void m()
  {
    this.j += 1;
  }
  
  int n()
  {
    return this.j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Connection{").append(this.b.a.b).append(":").append(this.b.a.c).append(", proxy=").append(this.b.b).append(" hostAddress=").append(this.b.c.getAddress().getHostAddress()).append(" cipherSuite=");
    if (this.i != null) {}
    for (String str = this.i.a();; str = "none") {
      return str + " protocol=" + this.g + '}';
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */