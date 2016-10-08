package com.adhoc;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.CookieHandler;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

public final class dt
{
  private static final bp d = new du();
  final bg a;
  long b = -1L;
  public final boolean c;
  private as e;
  private ag f;
  private ef g;
  private bq h;
  private final bn i;
  private eh j;
  private boolean k;
  private final bj l;
  private bj m;
  private bn n;
  private bn o;
  private ff p;
  private ep q;
  private final boolean r;
  private final boolean s;
  private dk t;
  private dl u;
  
  public dt(bg parambg, bj parambj, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, as paramas, ef paramef, ed paramed, bn parambn)
  {
    this.a = parambg;
    this.l = parambj;
    this.c = paramBoolean1;
    this.r = paramBoolean2;
    this.s = paramBoolean3;
    this.e = paramas;
    this.g = paramef;
    this.p = paramed;
    this.i = parambn;
    if (paramas != null)
    {
      bt.b.b(paramas, this);
      this.h = paramas.c();
      return;
    }
    this.h = null;
  }
  
  private static ag a(bg parambg, bj parambj)
  {
    ao localao = null;
    SSLSocketFactory localSSLSocketFactory;
    HostnameVerifier localHostnameVerifier;
    if (parambj.i())
    {
      localSSLSocketFactory = parambg.i();
      localHostnameVerifier = parambg.j();
      localao = parambg.k();
    }
    for (;;)
    {
      return new ag(parambj.a().g(), parambj.a().h(), parambg.h(), localSSLSocketFactory, localHostnameVerifier, localao, parambg.l(), parambg.d(), parambg.s(), parambg.t(), parambg.e());
      localHostnameVerifier = null;
      localSSLSocketFactory = null;
    }
  }
  
  private static ba a(ba paramba1, ba paramba2)
  {
    int i2 = 0;
    ba.a locala = new ba.a();
    int i3 = paramba1.a();
    int i1 = 0;
    if (i1 < i3)
    {
      String str1 = paramba1.a(i1);
      String str2 = paramba1.b(i1);
      if (("Warning".equalsIgnoreCase(str1)) && (str2.startsWith("1"))) {}
      for (;;)
      {
        i1 += 1;
        break;
        if ((!dy.a(str1)) || (paramba2.a(str1) == null)) {
          locala.a(str1, str2);
        }
      }
    }
    i3 = paramba2.a();
    i1 = i2;
    if (i1 < i3)
    {
      paramba1 = paramba2.a(i1);
      if ("Content-Length".equalsIgnoreCase(paramba1)) {}
      for (;;)
      {
        i1 += 1;
        break;
        if (dy.a(paramba1)) {
          locala.a(paramba1, paramba2.b(i1));
        }
      }
    }
    return locala.a();
  }
  
  private bj a(bj parambj)
  {
    bj.a locala = parambj.g();
    try
    {
      if (parambj.a("Host") == null) {
        locala.a("Host", cb.a(parambj.a()));
      }
      if (((this.e == null) || (this.e.l() != bi.a)) && (parambj.a("Connection") == null)) {
        locala.a("Connection", "Keep-Alive");
      }
      if (parambj.a("Accept-Encoding") == null)
      {
        this.k = true;
        locala.a("Accept-Encoding", "gzip");
      }
      CookieHandler localCookieHandler = this.a.f();
      if (localCookieHandler != null)
      {
        Map localMap = dy.a(locala.a().e(), null);
        dy.a(locala, localCookieHandler.get(parambj.b(), localMap));
      }
      if (parambj.a("User-Agent") == null) {
        locala.a("User-Agent", cd.a());
      }
      return locala.a();
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        fl.a(localThrowable);
      }
    }
  }
  
  private bn a(dk paramdk, bn parambn)
  {
    if (paramdk == null) {}
    ff localff;
    do
    {
      return parambn;
      localff = paramdk.a();
    } while (localff == null);
    paramdk = new dv(this, parambn.h().c(), paramdk, ex.a(localff));
    return parambn.i().a(new ea(parambn.g(), ex.a(paramdk))).a();
  }
  
  private void a(ef paramef, IOException paramIOException)
  {
    if (bt.b.b(this.e) > 0) {
      return;
    }
    paramef.a(this.e.c(), paramIOException);
  }
  
  public static boolean a(bn parambn)
  {
    if (parambn.a().d().equals("HEAD")) {}
    do
    {
      return false;
      int i1 = parambn.c();
      if (((i1 < 100) || (i1 >= 200)) && (i1 != 204) && (i1 != 304)) {
        return true;
      }
    } while ((dy.a(parambn) == -1L) && (!"chunked".equalsIgnoreCase(parambn.a("Transfer-Encoding"))));
    return true;
  }
  
  private static boolean a(bn parambn1, bn parambn2)
  {
    if (parambn2.c() == 304) {}
    do
    {
      return true;
      parambn1 = parambn1.g().b("Last-Modified");
      if (parambn1 == null) {
        break;
      }
      parambn2 = parambn2.g().b("Last-Modified");
    } while ((parambn2 != null) && (parambn2.getTime() < parambn1.getTime()));
    return false;
  }
  
  private boolean a(IOException paramIOException)
  {
    if (!this.a.p()) {}
    while (((paramIOException instanceof ProtocolException)) || ((paramIOException instanceof InterruptedIOException))) {
      return false;
    }
    return true;
  }
  
  private static bn b(bn parambn)
  {
    bn localbn = parambn;
    if (parambn != null)
    {
      localbn = parambn;
      if (parambn.h() != null) {
        localbn = parambn.i().a(null).a();
      }
    }
    return localbn;
  }
  
  private boolean b(ee paramee)
  {
    if (!this.a.p()) {}
    do
    {
      return false;
      paramee = paramee.a();
    } while (((paramee instanceof ProtocolException)) || ((paramee instanceof InterruptedIOException)) || (((paramee instanceof SSLHandshakeException)) && ((paramee.getCause() instanceof CertificateException))) || ((paramee instanceof SSLPeerUnverifiedException)));
    return true;
  }
  
  private bn c(bn parambn)
  {
    if ((!this.k) || (!"gzip".equalsIgnoreCase(this.o.a("Content-Encoding")))) {}
    while (parambn.h() == null) {
      return parambn;
    }
    ev localev = new ev(parambn.h().c());
    ba localba = parambn.g().b().b("Content-Encoding").b("Content-Length").a();
    return parambn.i().a(localba).a(new ea(localba, ex.a(localev))).a();
  }
  
  /* Error */
  private void l()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 70	com/adhoc/dt:e	Lcom/adhoc/as;
    //   4: ifnull +17 -> 21
    //   7: new 397	java/lang/IllegalStateException
    //   10: dup
    //   11: invokespecial 398	java/lang/IllegalStateException:<init>	()V
    //   14: athrow
    //   15: astore_1
    //   16: aload_1
    //   17: invokestatic 254	com/adhoc/fl:a	(Ljava/lang/Throwable;)V
    //   20: return
    //   21: aload_0
    //   22: getfield 72	com/adhoc/dt:g	Lcom/adhoc/ef;
    //   25: ifnonnull +37 -> 62
    //   28: aload_0
    //   29: aload_0
    //   30: getfield 60	com/adhoc/dt:a	Lcom/adhoc/bg;
    //   33: aload_0
    //   34: getfield 257	com/adhoc/dt:m	Lcom/adhoc/bj;
    //   37: invokestatic 400	com/adhoc/dt:a	(Lcom/adhoc/bg;Lcom/adhoc/bj;)Lcom/adhoc/ag;
    //   40: putfield 402	com/adhoc/dt:f	Lcom/adhoc/ag;
    //   43: aload_0
    //   44: aload_0
    //   45: getfield 402	com/adhoc/dt:f	Lcom/adhoc/ag;
    //   48: aload_0
    //   49: getfield 257	com/adhoc/dt:m	Lcom/adhoc/bj;
    //   52: aload_0
    //   53: getfield 60	com/adhoc/dt:a	Lcom/adhoc/bg;
    //   56: invokestatic 405	com/adhoc/ef:a	(Lcom/adhoc/ag;Lcom/adhoc/bj;Lcom/adhoc/bg;)Lcom/adhoc/ef;
    //   59: putfield 72	com/adhoc/dt:g	Lcom/adhoc/ef;
    //   62: aload_0
    //   63: aload_0
    //   64: invokespecial 408	com/adhoc/dt:m	()Lcom/adhoc/as;
    //   67: putfield 70	com/adhoc/dt:e	Lcom/adhoc/as;
    //   70: getstatic 81	com/adhoc/bt:b	Lcom/adhoc/bt;
    //   73: aload_0
    //   74: getfield 60	com/adhoc/dt:a	Lcom/adhoc/bg;
    //   77: aload_0
    //   78: getfield 70	com/adhoc/dt:e	Lcom/adhoc/as;
    //   81: aload_0
    //   82: aload_0
    //   83: getfield 257	com/adhoc/dt:m	Lcom/adhoc/bj;
    //   86: invokevirtual 411	com/adhoc/bt:a	(Lcom/adhoc/bg;Lcom/adhoc/as;Lcom/adhoc/dt;Lcom/adhoc/bj;)V
    //   89: aload_0
    //   90: aload_0
    //   91: getfield 70	com/adhoc/dt:e	Lcom/adhoc/as;
    //   94: invokevirtual 89	com/adhoc/as:c	()Lcom/adhoc/bq;
    //   97: putfield 91	com/adhoc/dt:h	Lcom/adhoc/bq;
    //   100: return
    //   101: astore_1
    //   102: aload_1
    //   103: invokestatic 254	com/adhoc/fl:a	(Ljava/lang/Throwable;)V
    //   106: return
    //   107: astore_1
    //   108: new 413	com/adhoc/eb
    //   111: dup
    //   112: aload_1
    //   113: invokespecial 416	com/adhoc/eb:<init>	(Ljava/io/IOException;)V
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	dt
    //   15	2	1	localThrowable1	Throwable
    //   101	2	1	localThrowable2	Throwable
    //   107	6	1	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   0	15	15	java/lang/Throwable
    //   21	43	15	java/lang/Throwable
    //   43	62	15	java/lang/Throwable
    //   102	106	15	java/lang/Throwable
    //   108	117	15	java/lang/Throwable
    //   62	100	101	java/lang/Throwable
    //   43	62	107	java/io/IOException
  }
  
  private as m()
  {
    Object localObject = this.a.m();
    for (;;)
    {
      as localas = ((at)localObject).a(this.f);
      if (localas == null) {
        break;
      }
      if ((this.m.d().equals("GET")) || (bt.b.c(localas))) {
        return localas;
      }
      cb.a(localas.d());
    }
    try
    {
      localObject = new as((at)localObject, this.g.b());
      return (as)localObject;
    }
    catch (IOException localIOException)
    {
      fl.a(localIOException);
      return null;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        fl.a(localThrowable);
      }
    }
  }
  
  private void n()
  {
    try
    {
      bu localbu = bt.b.a(this.a);
      if (localbu == null) {
        return;
      }
      if (!dl.a(this.o, this.m))
      {
        boolean bool = dw.a(this.m.d());
        if (!bool) {
          return;
        }
        try
        {
          localbu.b(this.m);
          return;
        }
        catch (IOException localIOException)
        {
          return;
        }
      }
      this.t = localIOException.a(b(this.o));
      return;
    }
    catch (Throwable localThrowable)
    {
      fl.a(localThrowable);
    }
  }
  
  private bn o()
  {
    this.j.a();
    bn localbn2 = this.j.b().a(this.m).a(this.e.j()).a(dy.b, Long.toString(this.b)).a(dy.c, Long.toString(System.currentTimeMillis())).a();
    bn localbn1 = localbn2;
    if (!this.s) {
      localbn1 = localbn2.i().a(this.j.a(localbn2)).a();
    }
    bt.b.a(this.e, localbn1.b());
    return localbn1;
  }
  
  public dt a(ee paramee)
  {
    if ((this.g != null) && (this.e != null)) {
      a(this.g, paramee.a());
    }
    try
    {
      if (((this.g != null) || (this.e != null)) && ((this.g == null) || (this.g.a())))
      {
        boolean bool = b(paramee);
        if (bool) {}
      }
      else
      {
        return null;
      }
    }
    catch (Throwable paramee)
    {
      fl.a(paramee);
      paramee = i();
    }
    return new dt(this.a, this.l, this.c, this.r, this.s, paramee, this.g, (ed)this.p, this.i);
  }
  
  public dt a(IOException paramIOException, ff paramff)
  {
    if ((this.g != null) && (this.e != null)) {
      a(this.g, paramIOException);
    }
    if ((paramff == null) || ((paramff instanceof ed))) {}
    for (int i1 = 1;; i1 = 0) {
      try
      {
        if (((this.g != null) || (this.e != null)) && ((this.g == null) || (this.g.a())))
        {
          boolean bool = a(paramIOException);
          if ((bool) && (i1 != 0)) {
            break;
          }
        }
        return null;
      }
      catch (Throwable paramIOException)
      {
        fl.a(paramIOException);
        paramIOException = i();
      }
    }
    return new dt(this.a, this.l, this.c, this.r, this.s, paramIOException, this.g, (ed)paramff, this.i);
  }
  
  public void a()
  {
    Object localObject = null;
    try
    {
      if (this.u != null) {
        return;
      }
      if (this.j != null) {
        throw new IllegalStateException();
      }
    }
    catch (Throwable localThrowable)
    {
      fl.a(localThrowable);
      return;
    }
    bj localbj = a(this.l);
    bu localbu = bt.b.a(this.a);
    bn localbn;
    if (localbu != null) {
      localbn = localbu.a(localbj);
    }
    this.u = new dl.a(System.currentTimeMillis(), localbj, localbn).a();
    this.m = this.u.a;
    this.n = this.u.b;
    if (localbu != null) {
      localbu.a(this.u);
    }
    if ((localbn != null) && (this.n == null)) {
      cb.a(localbn.h());
    }
    if (this.m != null)
    {
      if (this.e == null) {
        l();
      }
      this.j = bt.b.a(this.e, this);
      if ((this.r) && (c()) && (this.p == null))
      {
        long l1 = dy.a(localbj);
        if (this.c)
        {
          if (l1 > 2147483647L) {
            throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
          }
          if (l1 != -1L)
          {
            this.j.a(this.m);
            this.p = new ed((int)l1);
            return;
          }
          this.p = new ed();
          return;
        }
        this.j.a(this.m);
        this.p = this.j.a(this.m, l1);
      }
    }
    else
    {
      if (this.e != null)
      {
        bt.b.a(this.a.m(), this.e);
        this.e = null;
      }
      if (this.n != null) {}
      for (this.o = this.n.i().a(this.l).c(b(this.i)).b(b(this.n)).a();; this.o = new bn.a().a(this.l).c(b(this.i)).a(bi.b).a(504).a("Unsatisfiable Request (only-if-cached)").a(d).a())
      {
        this.o = c(this.o);
        return;
      }
    }
  }
  
  public void a(ba paramba)
  {
    CookieHandler localCookieHandler = this.a.f();
    if (localCookieHandler != null) {
      localCookieHandler.put(this.l.b(), dy.a(paramba, null));
    }
  }
  
  public boolean a(bc parambc)
  {
    bc localbc = this.l.a();
    return (localbc.g().equals(parambc.g())) && (localbc.h() == parambc.h()) && (localbc.c().equals(parambc.c()));
  }
  
  public void b()
  {
    if (this.b != -1L) {
      throw new IllegalStateException();
    }
    this.b = System.currentTimeMillis();
  }
  
  boolean c()
  {
    return dw.c(this.l.d());
  }
  
  public bj d()
  {
    return this.l;
  }
  
  public bn e()
  {
    if (this.o == null) {
      throw new IllegalStateException();
    }
    return this.o;
  }
  
  public as f()
  {
    return this.e;
  }
  
  public bq g()
  {
    return this.h;
  }
  
  public void h()
  {
    if ((this.j != null) && (this.e != null)) {
      this.j.c();
    }
    this.e = null;
  }
  
  public as i()
  {
    if (this.q != null) {
      cb.a(this.q);
    }
    while (this.o == null)
    {
      if (this.e != null) {
        cb.a(this.e.d());
      }
      this.e = null;
      return null;
      if (this.p != null) {
        cb.a(this.p);
      }
    }
    cb.a(this.o.h());
    if ((this.j != null) && (this.e != null) && (!this.j.d()))
    {
      cb.a(this.e.d());
      this.e = null;
      return null;
    }
    if ((this.e != null) && (!bt.b.a(this.e))) {
      this.e = null;
    }
    as localas = this.e;
    this.e = null;
    return localas;
  }
  
  public void j()
  {
    try
    {
      if (this.o != null) {
        return;
      }
      if ((this.m == null) && (this.n == null)) {
        throw new IllegalStateException("call sendRequest() first!");
      }
    }
    catch (Throwable localThrowable)
    {
      fl.a(localThrowable);
      return;
    }
    if (this.m != null)
    {
      if (this.s) {
        this.j.a(this.m);
      }
      for (Object localObject = o();; localObject = new a(0, this.m).a(this.m))
      {
        a(((bn)localObject).g());
        if (this.n == null) {
          break label446;
        }
        if (!a(this.n, (bn)localObject)) {
          break label436;
        }
        this.o = this.n.i().a(this.l).c(b(this.i)).a(a(this.n.g(), ((bn)localObject).g())).b(b(this.n)).a(b((bn)localObject)).a();
        ((bn)localObject).h().close();
        h();
        localObject = bt.b.a(this.a);
        ((bu)localObject).a();
        ((bu)localObject).a(this.n, b(this.o));
        this.o = c(this.o);
        return;
        if (this.r) {
          break;
        }
      }
      if ((this.q != null) && (this.q.c().b() > 0L)) {
        this.q.e();
      }
      if (this.b == -1L)
      {
        if ((dy.a(this.m) == -1L) && ((this.p instanceof ed)))
        {
          long l1 = ((ed)this.p).b();
          this.m = this.m.g().a("Content-Length", Long.toString(l1)).a();
        }
        this.j.a(this.m);
      }
      if (this.p != null)
      {
        if (this.q == null) {
          break label424;
        }
        this.q.close();
      }
      for (;;)
      {
        if ((this.p instanceof ed)) {
          this.j.a((ed)this.p);
        }
        localObject = o();
        break;
        label424:
        this.p.close();
      }
      label436:
      cb.a(this.n.h());
      label446:
      this.o = ((bn)localObject).i().a(this.l).c(b(this.i)).b(b(this.n)).a(b((bn)localObject)).a();
      if (a(this.o))
      {
        n();
        this.o = c(a(this.t, this.o));
      }
    }
  }
  
  public bj k()
  {
    if (this.o == null) {
      throw new IllegalStateException();
    }
    if (g() != null) {}
    for (Object localObject = g().b();; localObject = this.a.d()) {
      switch (this.o.c())
      {
      default: 
        return null;
      }
    }
    if (((Proxy)localObject).type() != Proxy.Type.HTTP) {
      throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
    }
    return dy.a(this.a.l(), this.o, (Proxy)localObject);
    if ((!this.l.d().equals("GET")) && (!this.l.d().equals("HEAD"))) {
      return null;
    }
    if (!this.a.o()) {
      return null;
    }
    localObject = this.o.a("Location");
    if (localObject == null) {
      return null;
    }
    localObject = this.l.a().c((String)localObject);
    if (localObject == null) {
      return null;
    }
    if ((!((bc)localObject).c().equals(this.l.a().c())) && (!this.a.n())) {
      return null;
    }
    bj.a locala = this.l.g();
    if (dw.c(this.l.d()))
    {
      locala.a("GET", null);
      locala.b("Transfer-Encoding");
      locala.b("Content-Length");
      locala.b("Content-Type");
    }
    if (!a((bc)localObject)) {
      locala.b("Authorization");
    }
    return locala.a((bc)localObject).a();
  }
  
  class a
    implements be.a
  {
    private final int b;
    private final bj c;
    private int d;
    
    a(int paramInt, bj parambj)
    {
      this.b = paramInt;
      this.c = parambj;
    }
    
    public as a()
    {
      return dt.a(dt.this);
    }
    
    public bn a(bj parambj)
    {
      this.d += 1;
      Object localObject1;
      Object localObject2;
      if (this.b > 0)
      {
        localObject1 = (be)dt.this.a.v().get(this.b - 1);
        localObject2 = a().c().a();
        if ((!parambj.a().g().equals(((ag)localObject2).a())) || (parambj.a().h() != ((ag)localObject2).b())) {
          throw new IllegalStateException("network interceptor " + localObject1 + " must retain the same host and port");
        }
        if (this.d > 1) {
          throw new IllegalStateException("network interceptor " + localObject1 + " must call proceed() exactly once");
        }
      }
      if (this.b < dt.this.a.v().size())
      {
        localObject1 = new a(dt.this, this.b + 1, parambj);
        localObject2 = (be)dt.this.a.v().get(this.b);
        parambj = ((be)localObject2).a((be.a)localObject1);
        if (((a)localObject1).d != 1) {
          throw new IllegalStateException("network interceptor " + localObject2 + " must call proceed() exactly once");
        }
      }
      for (;;)
      {
        return parambj;
        dt.b(dt.this).a(parambj);
        dt.a(dt.this, parambj);
        if ((dt.this.c()) && (parambj.f() != null)) {}
        try
        {
          localObject1 = ex.a(dt.b(dt.this).a(parambj, parambj.f().b()));
          parambj.f().a((ep)localObject1);
          ((ep)localObject1).close();
          localObject1 = dt.c(dt.this);
          int i = ((bn)localObject1).c();
          if (i != 204)
          {
            parambj = (bj)localObject1;
            if (i != 205) {
              continue;
            }
          }
          parambj = (bj)localObject1;
          if (((bn)localObject1).h().b() <= 0L) {
            continue;
          }
          throw new ProtocolException("HTTP " + i + " had non-zero Content-Length: " + ((bn)localObject1).h().b());
        }
        catch (Throwable parambj)
        {
          for (;;)
          {
            fl.a(parambj);
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\dt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */