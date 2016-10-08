package com.adhoc;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public final class ef
{
  private final ag a;
  private final bc b;
  private final bw c;
  private final bg d;
  private final ca e;
  private Proxy f;
  private InetSocketAddress g;
  private List<Proxy> h = Collections.emptyList();
  private int i;
  private List<InetSocketAddress> j = Collections.emptyList();
  private int k;
  private final List<bq> l = new ArrayList();
  
  private ef(ag paramag, bc parambc, bg parambg)
  {
    this.a = paramag;
    this.b = parambc;
    this.d = parambg;
    this.e = bt.b.b(parambg);
    this.c = bt.b.c(parambg);
    a(parambc, paramag.i());
  }
  
  public static ef a(ag paramag, bj parambj, bg parambg)
  {
    return new ef(paramag, parambj.a(), parambg);
  }
  
  static String a(InetSocketAddress paramInetSocketAddress)
  {
    InetAddress localInetAddress = paramInetSocketAddress.getAddress();
    if (localInetAddress == null) {
      return paramInetSocketAddress.getHostName();
    }
    return localInetAddress.getHostAddress();
  }
  
  private void a(bc parambc, Proxy paramProxy)
  {
    if (paramProxy != null) {
      this.h = Collections.singletonList(paramProxy);
    }
    for (;;)
    {
      this.i = 0;
      return;
      this.h = new ArrayList();
      parambc = this.d.e().select(parambc.b());
      if (parambc != null) {
        this.h.addAll(parambc);
      }
      this.h.removeAll(Collections.singleton(Proxy.NO_PROXY));
      this.h.add(Proxy.NO_PROXY);
    }
  }
  
  private void a(Proxy paramProxy)
  {
    this.j = new ArrayList();
    if ((paramProxy.type() == Proxy.Type.DIRECT) || (paramProxy.type() == Proxy.Type.SOCKS)) {
      paramProxy = this.a.a();
    }
    InetSocketAddress localInetSocketAddress;
    for (int m = this.a.b(); (m < 1) || (m > 65535); m = localInetSocketAddress.getPort())
    {
      throw new SocketException("No route to " + paramProxy + ":" + m + "; port is out of range");
      paramProxy = paramProxy.address();
      if (!(paramProxy instanceof InetSocketAddress)) {
        throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + paramProxy.getClass());
      }
      localInetSocketAddress = (InetSocketAddress)paramProxy;
      paramProxy = a(localInetSocketAddress);
    }
    try
    {
      paramProxy = this.c.a(paramProxy);
      int i1 = paramProxy.length;
      int n = 0;
      while (n < i1)
      {
        localInetSocketAddress = paramProxy[n];
        this.j.add(new InetSocketAddress(localInetSocketAddress, m));
        n += 1;
      }
      return;
    }
    catch (Throwable paramProxy)
    {
      fl.b("something wrong");
      this.k = 0;
    }
  }
  
  private boolean c()
  {
    return this.i < this.h.size();
  }
  
  private Proxy d()
  {
    if (!c()) {
      throw new SocketException("No route to " + this.a.a() + "; exhausted proxy configurations: " + this.h);
    }
    Object localObject = this.h;
    int m = this.i;
    this.i = (m + 1);
    localObject = (Proxy)((List)localObject).get(m);
    a((Proxy)localObject);
    return (Proxy)localObject;
  }
  
  private boolean e()
  {
    return this.k < this.j.size();
  }
  
  private InetSocketAddress f()
  {
    if (!e()) {
      throw new SocketException("No route to " + this.a.a() + "; exhausted inet socket addresses: " + this.j);
    }
    List localList = this.j;
    int m = this.k;
    this.k = (m + 1);
    return (InetSocketAddress)localList.get(m);
  }
  
  private boolean g()
  {
    return !this.l.isEmpty();
  }
  
  private bq h()
  {
    return (bq)this.l.remove(0);
  }
  
  public void a(bq parambq, IOException paramIOException)
  {
    if ((parambq.b().type() != Proxy.Type.DIRECT) && (this.a.j() != null)) {
      this.a.j().connectFailed(this.b.b(), parambq.b().address(), paramIOException);
    }
    this.e.a(parambq);
  }
  
  public boolean a()
  {
    return (e()) || (c()) || (g());
  }
  
  public bq b()
  {
    Object localObject;
    if (!e()) {
      if (!c())
      {
        if (!g()) {
          throw new NoSuchElementException();
        }
        localObject = h();
      }
    }
    bq localbq;
    do
    {
      return (bq)localObject;
      this.f = d();
      this.g = f();
      localbq = new bq(this.a, this.f, this.g);
      localObject = localbq;
    } while (!this.e.c(localbq));
    this.l.add(localbq);
    return b();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\ef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */