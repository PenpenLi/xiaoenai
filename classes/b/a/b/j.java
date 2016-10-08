package b.a.b;

import b.a.c.c;
import b.a.d;
import b.ab;
import b.ad;
import b.ad.a;
import b.ag;
import b.ai;
import b.al;
import b.al.a;
import b.an;
import b.aq;
import b.aq.a;
import b.as;
import b.at;
import b.i;
import b.q;
import b.r;
import b.z;
import b.z.a;
import c.g;
import c.y;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.Date;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class j
{
  private static final as e = new k();
  final ag a;
  public final w b;
  long c = -1L;
  public final boolean d;
  private final aq f;
  private n g;
  private boolean h;
  private final al i;
  private al j;
  private aq k;
  private aq l;
  private y m;
  private g n;
  private final boolean o;
  private final boolean p;
  private a q;
  private b r;
  
  public j(ag paramag, al paramal, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, w paramw, s params, aq paramaq)
  {
    this.a = paramag;
    this.i = paramal;
    this.d = paramBoolean1;
    this.o = paramBoolean2;
    this.p = paramBoolean3;
    if (paramw != null) {}
    for (;;)
    {
      this.b = paramw;
      this.m = params;
      this.f = paramaq;
      return;
      paramw = new w(paramag.o(), a(paramag, paramal));
    }
  }
  
  private static b.a a(ag paramag, al paramal)
  {
    i locali = null;
    SSLSocketFactory localSSLSocketFactory;
    HostnameVerifier localHostnameVerifier;
    if (paramal.g())
    {
      localSSLSocketFactory = paramag.j();
      localHostnameVerifier = paramag.k();
      locali = paramag.l();
    }
    for (;;)
    {
      return new b.a(paramal.a().f(), paramal.a().g(), paramag.h(), paramag.i(), localSSLSocketFactory, localHostnameVerifier, locali, paramag.n(), paramag.d(), paramag.t(), paramag.u(), paramag.e());
      localHostnameVerifier = null;
      localSSLSocketFactory = null;
    }
  }
  
  private aq a(a parama, aq paramaq)
  {
    if (parama == null) {}
    y localy;
    do
    {
      return paramaq;
      localy = parama.a();
    } while (localy == null);
    parama = new l(this, paramaq.g().c(), parama, c.p.a(localy));
    return paramaq.h().a(new p(paramaq.f(), c.p.a(parama))).a();
  }
  
  private static z a(z paramz1, z paramz2)
  {
    int i2 = 0;
    z.a locala = new z.a();
    int i3 = paramz1.a();
    int i1 = 0;
    if (i1 < i3)
    {
      String str1 = paramz1.a(i1);
      String str2 = paramz1.b(i1);
      if (("Warning".equalsIgnoreCase(str1)) && (str2.startsWith("1"))) {}
      for (;;)
      {
        i1 += 1;
        break;
        if ((!o.a(str1)) || (paramz2.a(str1) == null)) {
          locala.a(str1, str2);
        }
      }
    }
    i3 = paramz2.a();
    i1 = i2;
    if (i1 < i3)
    {
      paramz1 = paramz2.a(i1);
      if ("Content-Length".equalsIgnoreCase(paramz1)) {}
      for (;;)
      {
        i1 += 1;
        break;
        if (o.a(paramz1)) {
          locala.a(paramz1, paramz2.b(i1));
        }
      }
    }
    return locala.a();
  }
  
  private String a(List<q> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i2 = paramList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (i1 > 0) {
        localStringBuilder.append("; ");
      }
      q localq = (q)paramList.get(i1);
      localStringBuilder.append(localq.a()).append('=').append(localq.b());
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static boolean a(aq paramaq)
  {
    if (paramaq.a().b().equals("HEAD")) {}
    do
    {
      return false;
      int i1 = paramaq.b();
      if (((i1 < 100) || (i1 >= 200)) && (i1 != 204) && (i1 != 304)) {
        return true;
      }
    } while ((o.a(paramaq) == -1L) && (!"chunked".equalsIgnoreCase(paramaq.a("Transfer-Encoding"))));
    return true;
  }
  
  private static boolean a(aq paramaq1, aq paramaq2)
  {
    if (paramaq2.b() == 304) {}
    do
    {
      return true;
      paramaq1 = paramaq1.f().b("Last-Modified");
      if (paramaq1 == null) {
        break;
      }
      paramaq2 = paramaq2.f().b("Last-Modified");
    } while ((paramaq2 != null) && (paramaq2.getTime() < paramaq1.getTime()));
    return false;
  }
  
  private al b(al paramal)
  {
    al.a locala = paramal.e();
    if (paramal.a("Host") == null) {
      locala.a("Host", b.a.j.a(paramal.a(), false));
    }
    if (paramal.a("Connection") == null) {
      locala.a("Connection", "Keep-Alive");
    }
    if (paramal.a("Accept-Encoding") == null)
    {
      this.h = true;
      locala.a("Accept-Encoding", "gzip");
    }
    List localList = this.a.f().a(paramal.a());
    if (!localList.isEmpty()) {
      locala.a("Cookie", a(localList));
    }
    if (paramal.a("User-Agent") == null) {
      locala.a("User-Agent", b.a.l.a());
    }
    return locala.b();
  }
  
  private static aq b(aq paramaq)
  {
    aq localaq = paramaq;
    if (paramaq != null)
    {
      localaq = paramaq;
      if (paramaq.g() != null) {
        localaq = paramaq.h().a(null).a();
      }
    }
    return localaq;
  }
  
  private aq c(aq paramaq)
  {
    if ((!this.h) || (!"gzip".equalsIgnoreCase(this.l.a("Content-Encoding")))) {}
    while (paramaq.g() == null) {
      return paramaq;
    }
    c.n localn = new c.n(paramaq.g().c());
    z localz = paramaq.f().b().b("Content-Encoding").b("Content-Length").a();
    return paramaq.h().a(localz).a(new p(localz, c.p.a(localn))).a();
  }
  
  private boolean i()
  {
    return (this.o) && (a(this.j)) && (this.m == null);
  }
  
  private n j()
  {
    if (!this.j.b().equals("GET")) {}
    for (boolean bool = true;; bool = false) {
      return this.b.a(this.a.a(), this.a.b(), this.a.c(), this.a.r(), bool);
    }
  }
  
  private void k()
  {
    b.a.e locale = d.b.a(this.a);
    if (locale == null) {}
    do
    {
      return;
      if (b.a(this.l, this.j)) {
        break;
      }
    } while (!m.a(this.j.b()));
    try
    {
      locale.b(this.j);
      return;
    }
    catch (IOException localIOException)
    {
      return;
    }
    this.q = localIOException.a(b(this.l));
  }
  
  private aq l()
  {
    this.g.b();
    aq localaq2 = this.g.a().a(this.j).a(this.b.a().c()).a(o.b, Long.toString(this.c)).a(o.c, Long.toString(System.currentTimeMillis())).a();
    aq localaq1 = localaq2;
    if (!this.p) {
      localaq1 = localaq2.h().a(this.g.a(localaq2)).a();
    }
    if (("close".equalsIgnoreCase(localaq1.a().a("Connection"))) || ("close".equalsIgnoreCase(localaq1.a("Connection")))) {
      this.b.c();
    }
    return localaq1;
  }
  
  public j a(IOException paramIOException, y paramy)
  {
    if (!this.b.a(paramIOException, paramy)) {}
    while (!this.a.r()) {
      return null;
    }
    paramIOException = f();
    return new j(this.a, this.i, this.d, this.o, this.p, paramIOException, (s)paramy, this.f);
  }
  
  public void a()
  {
    if (this.r != null) {}
    long l1;
    for (;;)
    {
      return;
      if (this.g != null) {
        throw new IllegalStateException();
      }
      al localal = b(this.i);
      b.a.e locale = d.b.a(this.a);
      if (locale != null) {}
      for (aq localaq = locale.a(localal);; localaq = null)
      {
        this.r = new b.a(System.currentTimeMillis(), localal, localaq).a();
        this.j = this.r.a;
        this.k = this.r.b;
        if (locale != null) {
          locale.a(this.r);
        }
        if ((localaq != null) && (this.k == null)) {
          b.a.j.a(localaq.g());
        }
        if ((this.j != null) || (this.k != null)) {
          break;
        }
        this.l = new aq.a().a(this.i).c(b(this.f)).a(ai.b).a(504).a("Unsatisfiable Request (only-if-cached)").a(e).a();
        return;
      }
      if (this.j == null)
      {
        this.l = this.k.h().a(this.i).c(b(this.f)).b(b(this.k)).a();
        this.l = c(this.l);
        return;
      }
      try
      {
        this.g = j();
        this.g.a(this);
        if (i())
        {
          l1 = o.a(localal);
          if (!this.d) {
            break label385;
          }
          if (l1 > 2147483647L) {
            throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
          }
        }
      }
      finally
      {
        if (localaq != null) {
          b.a.j.a(localaq.g());
        }
      }
    }
    if (l1 != -1L)
    {
      this.g.a(this.j);
      this.m = new s((int)l1);
      return;
    }
    this.m = new s();
    return;
    label385:
    this.g.a(this.j);
    this.m = this.g.a(this.j, l1);
  }
  
  public void a(z paramz)
  {
    if (this.a.f() == r.a) {}
    do
    {
      return;
      paramz = q.a(this.i.a(), paramz);
    } while (paramz.isEmpty());
    this.a.f().a(this.i.a(), paramz);
  }
  
  public boolean a(ab paramab)
  {
    ab localab = this.i.a();
    return (localab.f().equals(paramab.f())) && (localab.g() == paramab.g()) && (localab.b().equals(paramab.b()));
  }
  
  boolean a(al paramal)
  {
    return m.c(paramal.b());
  }
  
  public void b()
  {
    if (this.c != -1L) {
      throw new IllegalStateException();
    }
    this.c = System.currentTimeMillis();
  }
  
  public aq c()
  {
    if (this.l == null) {
      throw new IllegalStateException();
    }
    return this.l;
  }
  
  public b.l d()
  {
    return this.b.a();
  }
  
  public void e()
  {
    this.b.b();
  }
  
  public w f()
  {
    if (this.n != null)
    {
      b.a.j.a(this.n);
      if (this.l == null) {
        break label53;
      }
      b.a.j.a(this.l.g());
    }
    for (;;)
    {
      return this.b;
      if (this.m == null) {
        break;
      }
      b.a.j.a(this.m);
      break;
      label53:
      this.b.a(null);
    }
  }
  
  public void g()
  {
    if (this.l != null) {}
    label418:
    label430:
    label440:
    do
    {
      do
      {
        return;
        if ((this.j == null) && (this.k == null)) {
          throw new IllegalStateException("call sendRequest() first!");
        }
      } while (this.j == null);
      if (this.p) {
        this.g.a(this.j);
      }
      for (Object localObject = l();; localObject = new a(0, this.j).a(this.j))
      {
        a(((aq)localObject).f());
        if (this.k == null) {
          break label440;
        }
        if (!a(this.k, (aq)localObject)) {
          break label430;
        }
        this.l = this.k.h().a(this.i).c(b(this.f)).a(a(this.k.f(), ((aq)localObject).f())).b(b(this.k)).a(b((aq)localObject)).a();
        ((aq)localObject).g().close();
        e();
        localObject = d.b.a(this.a);
        ((b.a.e)localObject).a();
        ((b.a.e)localObject).a(this.k, b(this.l));
        this.l = c(this.l);
        return;
        if (this.o) {
          break;
        }
      }
      if ((this.n != null) && (this.n.c().b() > 0L)) {
        this.n.e();
      }
      if (this.c == -1L)
      {
        if ((o.a(this.j) == -1L) && ((this.m instanceof s)))
        {
          long l1 = ((s)this.m).b();
          this.j = this.j.e().a("Content-Length", Long.toString(l1)).b();
        }
        this.g.a(this.j);
      }
      if (this.m != null)
      {
        if (this.n == null) {
          break label418;
        }
        this.n.close();
      }
      for (;;)
      {
        if ((this.m instanceof s)) {
          this.g.a((s)this.m);
        }
        localObject = l();
        break;
        this.m.close();
      }
      b.a.j.a(this.k.g());
      this.l = ((aq)localObject).h().a(this.i).c(b(this.f)).b(b(this.k)).a(b((aq)localObject)).a();
    } while (!a(this.l));
    k();
    this.l = c(a(this.q, this.l));
  }
  
  public al h()
  {
    if (this.l == null) {
      throw new IllegalStateException();
    }
    Object localObject1 = this.b.a();
    int i1;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((b.l)localObject1).a();
      i1 = this.l.b();
      localObject2 = this.i.b();
      switch (i1)
      {
      }
    }
    for (;;)
    {
      return null;
      localObject1 = null;
      break;
      if (localObject1 != null) {}
      for (localObject2 = ((at)localObject1).b(); ((Proxy)localObject2).type() != Proxy.Type.HTTP; localObject2 = this.a.d()) {
        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
      }
      return this.a.m().a((at)localObject1, this.l);
      if (((((String)localObject2).equals("GET")) || (((String)localObject2).equals("HEAD"))) && (this.a.q()))
      {
        localObject1 = this.l.a("Location");
        if (localObject1 != null)
        {
          localObject1 = this.i.a().c((String)localObject1);
          if ((localObject1 != null) && ((((ab)localObject1).b().equals(this.i.a().b())) || (this.a.p())))
          {
            al.a locala = this.i.e();
            if (m.c((String)localObject2))
            {
              if (!m.d((String)localObject2)) {
                break label372;
              }
              locala.a("GET", null);
            }
            for (;;)
            {
              locala.b("Transfer-Encoding");
              locala.b("Content-Length");
              locala.b("Content-Type");
              if (!a((ab)localObject1)) {
                locala.b("Authorization");
              }
              return locala.a((ab)localObject1).b();
              label372:
              locala.a((String)localObject2, null);
            }
            if ((this.m == null) || ((this.m instanceof s))) {}
            for (i1 = 1; (!this.o) || (i1 != 0); i1 = 0) {
              return this.i;
            }
          }
        }
      }
    }
  }
  
  class a
    implements ad.a
  {
    private final int b;
    private final al c;
    private int d;
    
    a(int paramInt, al paramal)
    {
      this.b = paramInt;
      this.c = paramal;
    }
    
    public aq a(al paramal)
    {
      this.d += 1;
      Object localObject1;
      Object localObject2;
      if (this.b > 0)
      {
        localObject1 = (ad)j.this.a.w().get(this.b - 1);
        localObject2 = a().a().a();
        if ((!paramal.a().f().equals(((b.a)localObject2).a().f())) || (paramal.a().g() != ((b.a)localObject2).a().g())) {
          throw new IllegalStateException("network interceptor " + localObject1 + " must retain the same host and port");
        }
        if (this.d > 1) {
          throw new IllegalStateException("network interceptor " + localObject1 + " must call proceed() exactly once");
        }
      }
      if (this.b < j.this.a.w().size())
      {
        localObject1 = new a(j.this, this.b + 1, paramal);
        localObject2 = (ad)j.this.a.w().get(this.b);
        paramal = ((ad)localObject2).a((ad.a)localObject1);
        if (((a)localObject1).d != 1) {
          throw new IllegalStateException("network interceptor " + localObject2 + " must call proceed() exactly once");
        }
        if (paramal == null) {
          throw new NullPointerException("network interceptor " + localObject2 + " returned null");
        }
      }
      int i;
      do
      {
        do
        {
          return paramal;
          j.a(j.this).a(paramal);
          j.a(j.this, paramal);
          if ((j.this.a(paramal)) && (paramal.d() != null))
          {
            localObject1 = c.p.a(j.a(j.this).a(paramal, paramal.d().b()));
            paramal.d().a((g)localObject1);
            ((g)localObject1).close();
          }
          localObject1 = j.b(j.this);
          i = ((aq)localObject1).b();
          if (i == 204) {
            break;
          }
          paramal = (al)localObject1;
        } while (i != 205);
        paramal = (al)localObject1;
      } while (((aq)localObject1).g().a() <= 0L);
      throw new ProtocolException("HTTP " + i + " had non-zero Content-Length: " + ((aq)localObject1).g().a());
    }
    
    public b.l a()
    {
      return j.this.b.a();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\a\b\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */