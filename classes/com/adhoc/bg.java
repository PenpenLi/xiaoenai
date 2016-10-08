package com.adhoc;

import java.net.CookieHandler;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public class bg
  implements Cloneable
{
  private static final List<bi> a = cb.a(new bi[] { bi.d, bi.c, bi.b });
  private static final List<av> b = cb.a(new av[] { av.a, av.b, av.c });
  private static SSLSocketFactory c;
  private int A = 10000;
  private final ca d;
  private ay e;
  private Proxy f;
  private List<bi> g;
  private List<av> h;
  private final List<be> i = new ArrayList();
  private final List<be> j = new ArrayList();
  private ProxySelector k;
  private CookieHandler l;
  private bu m;
  private ai n;
  private SocketFactory o;
  private SSLSocketFactory p;
  private HostnameVerifier q;
  private ao r;
  private ah s;
  private at t;
  private bw u;
  private boolean v = true;
  private boolean w = true;
  private boolean x = true;
  private int y = 10000;
  private int z = 10000;
  
  static
  {
    bt.b = new bh();
  }
  
  public bg()
  {
    this.d = new ca();
    this.e = new ay();
  }
  
  private bg(bg parambg)
  {
    this.d = parambg.d;
    this.e = parambg.e;
    this.f = parambg.f;
    this.g = parambg.g;
    this.h = parambg.h;
    this.i.addAll(parambg.i);
    this.j.addAll(parambg.j);
    this.k = parambg.k;
    this.l = parambg.l;
    this.n = parambg.n;
    if (this.n != null) {}
    for (bu localbu = this.n.a;; localbu = parambg.m)
    {
      this.m = localbu;
      this.o = parambg.o;
      this.p = parambg.p;
      this.q = parambg.q;
      this.r = parambg.r;
      this.s = parambg.s;
      this.t = parambg.t;
      this.u = parambg.u;
      this.v = parambg.v;
      this.w = parambg.w;
      this.x = parambg.x;
      this.y = parambg.y;
      this.z = parambg.z;
      this.A = parambg.A;
      return;
    }
  }
  
  private SSLSocketFactory y()
  {
    for (;;)
    {
      try
      {
        localObject1 = c;
        if (localObject1 != null) {}
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        fl.a(localThrowable);
        continue;
      }
      finally {}
      try
      {
        localObject1 = SSLContext.getInstance("TLS");
        ((SSLContext)localObject1).init(null, null, null);
        c = ((SSLContext)localObject1).getSocketFactory();
        localObject1 = c;
        return (SSLSocketFactory)localObject1;
      }
      catch (GeneralSecurityException localGeneralSecurityException)
      {
        throw new AssertionError();
      }
    }
  }
  
  public int a()
  {
    return this.y;
  }
  
  public al a(bj parambj)
  {
    return new al(this, parambj);
  }
  
  public void a(long paramLong, TimeUnit paramTimeUnit)
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
  }
  
  public int b()
  {
    return this.z;
  }
  
  public void b(long paramLong, TimeUnit paramTimeUnit)
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
    this.z = ((int)l1);
  }
  
  public int c()
  {
    return this.A;
  }
  
  public void c(long paramLong, TimeUnit paramTimeUnit)
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
    this.A = ((int)l1);
  }
  
  public Proxy d()
  {
    return this.f;
  }
  
  public ProxySelector e()
  {
    return this.k;
  }
  
  public CookieHandler f()
  {
    return this.l;
  }
  
  bu g()
  {
    return this.m;
  }
  
  public SocketFactory h()
  {
    return this.o;
  }
  
  public SSLSocketFactory i()
  {
    return this.p;
  }
  
  public HostnameVerifier j()
  {
    return this.q;
  }
  
  public ao k()
  {
    return this.r;
  }
  
  public ah l()
  {
    return this.s;
  }
  
  public at m()
  {
    return this.t;
  }
  
  public boolean n()
  {
    return this.v;
  }
  
  public boolean o()
  {
    return this.w;
  }
  
  public boolean p()
  {
    return this.x;
  }
  
  ca q()
  {
    return this.d;
  }
  
  public ay r()
  {
    return this.e;
  }
  
  public List<bi> s()
  {
    return this.g;
  }
  
  public List<av> t()
  {
    return this.h;
  }
  
  public List<be> u()
  {
    return this.i;
  }
  
  public List<be> v()
  {
    return this.j;
  }
  
  bg w()
  {
    bg localbg = new bg(this);
    if (localbg.k == null) {
      localbg.k = ProxySelector.getDefault();
    }
    if (localbg.l == null) {
      localbg.l = CookieHandler.getDefault();
    }
    if (localbg.o == null) {
      localbg.o = SocketFactory.getDefault();
    }
    if (localbg.p == null) {
      localbg.p = y();
    }
    if (localbg.q == null) {
      localbg.q = ej.a;
    }
    if (localbg.r == null) {
      localbg.r = ao.a;
    }
    if (localbg.s == null) {
      localbg.s = dj.a;
    }
    if (localbg.t == null) {
      localbg.t = at.a();
    }
    if (localbg.g == null) {
      localbg.g = a;
    }
    if (localbg.h == null) {
      localbg.h = b;
    }
    if (localbg.u == null) {
      localbg.u = bw.a;
    }
    return localbg;
  }
  
  public bg x()
  {
    return new bg(this);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */