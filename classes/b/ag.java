package b;

import b.a.d.f;
import b.a.e;
import b.a.h;
import b.a.j;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public class ag
  implements Cloneable
{
  private static final List<o> A;
  private static final List<ai> z = j.a(new ai[] { ai.d, ai.c, ai.b });
  final t a;
  final Proxy b;
  final List<ai> c;
  final List<o> d;
  final List<ad> e;
  final List<ad> f;
  final ProxySelector g;
  final r h;
  final d i;
  final e j;
  final SocketFactory k;
  final SSLSocketFactory l;
  final f m;
  final HostnameVerifier n;
  final i o;
  final b p;
  final b q;
  final m r;
  final u s;
  final boolean t;
  final boolean u;
  final boolean v;
  final int w;
  final int x;
  final int y;
  
  static
  {
    A = j.a(new o[] { o.a, o.b, o.c });
    b.a.d.b = new ah();
  }
  
  public ag()
  {
    this(new a());
  }
  
  private ag(a parama)
  {
    this.a = parama.a;
    this.b = parama.b;
    this.c = parama.c;
    this.d = parama.d;
    this.e = j.a(parama.e);
    this.f = j.a(parama.f);
    this.g = parama.g;
    this.h = parama.h;
    this.i = parama.i;
    this.j = parama.j;
    this.k = parama.k;
    Object localObject = this.d.iterator();
    int i1 = 0;
    if (((Iterator)localObject).hasNext())
    {
      o localo = (o)((Iterator)localObject).next();
      if ((i1 != 0) || (localo.a())) {}
      for (i1 = 1;; i1 = 0) {
        break;
      }
    }
    if ((parama.l != null) || (i1 == 0)) {
      this.l = parama.l;
    }
    for (;;)
    {
      if ((this.l == null) || (parama.m != null)) {
        break label401;
      }
      localObject = h.a().a(this.l);
      if (localObject == null)
      {
        throw new IllegalStateException("Unable to extract the trust manager on " + h.a() + ", sslSocketFactory is " + this.l.getClass());
        try
        {
          localObject = SSLContext.getInstance("TLS");
          ((SSLContext)localObject).init(null, null, null);
          this.l = ((SSLContext)localObject).getSocketFactory();
        }
        catch (GeneralSecurityException parama)
        {
          throw new AssertionError();
        }
      }
    }
    this.m = h.a().a((X509TrustManager)localObject);
    for (this.o = parama.o.a().a(this.m).a();; this.o = parama.o)
    {
      this.n = parama.n;
      this.p = parama.p;
      this.q = parama.q;
      this.r = parama.r;
      this.s = parama.s;
      this.t = parama.t;
      this.u = parama.u;
      this.v = parama.v;
      this.w = parama.w;
      this.x = parama.x;
      this.y = parama.y;
      return;
      label401:
      this.m = parama.m;
    }
  }
  
  public int a()
  {
    return this.w;
  }
  
  public g a(al paramal)
  {
    return new aj(this, paramal);
  }
  
  public int b()
  {
    return this.x;
  }
  
  public int c()
  {
    return this.y;
  }
  
  public Proxy d()
  {
    return this.b;
  }
  
  public ProxySelector e()
  {
    return this.g;
  }
  
  public r f()
  {
    return this.h;
  }
  
  e g()
  {
    if (this.i != null) {
      return this.i.a;
    }
    return this.j;
  }
  
  public u h()
  {
    return this.s;
  }
  
  public SocketFactory i()
  {
    return this.k;
  }
  
  public SSLSocketFactory j()
  {
    return this.l;
  }
  
  public HostnameVerifier k()
  {
    return this.n;
  }
  
  public i l()
  {
    return this.o;
  }
  
  public b m()
  {
    return this.q;
  }
  
  public b n()
  {
    return this.p;
  }
  
  public m o()
  {
    return this.r;
  }
  
  public boolean p()
  {
    return this.t;
  }
  
  public boolean q()
  {
    return this.u;
  }
  
  public boolean r()
  {
    return this.v;
  }
  
  public t s()
  {
    return this.a;
  }
  
  public List<ai> t()
  {
    return this.c;
  }
  
  public List<o> u()
  {
    return this.d;
  }
  
  public List<ad> v()
  {
    return this.e;
  }
  
  public List<ad> w()
  {
    return this.f;
  }
  
  public a x()
  {
    return new a(this);
  }
  
  public static final class a
  {
    t a;
    Proxy b;
    List<ai> c;
    List<o> d;
    final List<ad> e = new ArrayList();
    final List<ad> f = new ArrayList();
    ProxySelector g;
    r h;
    d i;
    e j;
    SocketFactory k;
    SSLSocketFactory l;
    f m;
    HostnameVerifier n;
    i o;
    b p;
    b q;
    m r;
    u s;
    boolean t;
    boolean u;
    boolean v;
    int w;
    int x;
    int y;
    
    public a()
    {
      this.a = new t();
      this.c = ag.y();
      this.d = ag.z();
      this.g = ProxySelector.getDefault();
      this.h = r.a;
      this.k = SocketFactory.getDefault();
      this.n = b.a.d.d.a;
      this.o = i.a;
      this.p = b.a;
      this.q = b.a;
      this.r = new m();
      this.s = u.b;
      this.t = true;
      this.u = true;
      this.v = true;
      this.w = 10000;
      this.x = 10000;
      this.y = 10000;
    }
    
    a(ag paramag)
    {
      this.a = paramag.a;
      this.b = paramag.b;
      this.c = paramag.c;
      this.d = paramag.d;
      this.e.addAll(paramag.e);
      this.f.addAll(paramag.f);
      this.g = paramag.g;
      this.h = paramag.h;
      this.j = paramag.j;
      this.i = paramag.i;
      this.k = paramag.k;
      this.l = paramag.l;
      this.m = paramag.m;
      this.n = paramag.n;
      this.o = paramag.o;
      this.p = paramag.p;
      this.q = paramag.q;
      this.r = paramag.r;
      this.s = paramag.s;
      this.t = paramag.t;
      this.u = paramag.u;
      this.v = paramag.v;
      this.w = paramag.w;
      this.x = paramag.x;
      this.y = paramag.y;
    }
    
    public a a(long paramLong, TimeUnit paramTimeUnit)
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("timeout < 0");
      }
      if (paramTimeUnit == null) {
        throw new IllegalArgumentException("unit == null");
      }
      long l1 = paramTimeUnit.toMillis(paramLong);
      if (l1 > 2147483647L) {
        throw new IllegalArgumentException("Timeout too large.");
      }
      if ((l1 == 0L) && (paramLong > 0L)) {
        throw new IllegalArgumentException("Timeout too small.");
      }
      this.w = ((int)l1);
      return this;
    }
    
    public a a(u paramu)
    {
      if (paramu == null) {
        throw new NullPointerException("dns == null");
      }
      this.s = paramu;
      return this;
    }
    
    public a a(boolean paramBoolean)
    {
      this.v = paramBoolean;
      return this;
    }
    
    public ag a()
    {
      return new ag(this, null);
    }
    
    public a b(long paramLong, TimeUnit paramTimeUnit)
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("timeout < 0");
      }
      if (paramTimeUnit == null) {
        throw new IllegalArgumentException("unit == null");
      }
      long l1 = paramTimeUnit.toMillis(paramLong);
      if (l1 > 2147483647L) {
        throw new IllegalArgumentException("Timeout too large.");
      }
      if ((l1 == 0L) && (paramLong > 0L)) {
        throw new IllegalArgumentException("Timeout too small.");
      }
      this.x = ((int)l1);
      return this;
    }
    
    public a c(long paramLong, TimeUnit paramTimeUnit)
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("timeout < 0");
      }
      if (paramTimeUnit == null) {
        throw new IllegalArgumentException("unit == null");
      }
      long l1 = paramTimeUnit.toMillis(paramLong);
      if (l1 > 2147483647L) {
        throw new IllegalArgumentException("Timeout too large.");
      }
      if ((l1 == 0L) && (paramLong > 0L)) {
        throw new IllegalArgumentException("Timeout too small.");
      }
      this.y = ((int)l1);
      return this;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */