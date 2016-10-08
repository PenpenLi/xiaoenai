package com.adhoc;

import java.net.Proxy;

public final class dx
  implements eh
{
  private final dt a;
  private final dp b;
  
  public dx(dt paramdt, dp paramdp)
  {
    this.a = paramdt;
    this.b = paramdp;
  }
  
  private fg b(bn parambn)
  {
    if (!dt.a(parambn)) {
      return this.b.b(0L);
    }
    if ("chunked".equalsIgnoreCase(parambn.a("Transfer-Encoding"))) {
      return this.b.a(this.a);
    }
    long l = dy.a(parambn);
    if (l != -1L) {
      return this.b.b(l);
    }
    return this.b.i();
  }
  
  public bp a(bn parambn)
  {
    fg localfg = b(parambn);
    return new ea(parambn.g(), ex.a(localfg));
  }
  
  public ff a(bj parambj, long paramLong)
  {
    if ("chunked".equalsIgnoreCase(parambj.a("Transfer-Encoding"))) {
      return this.b.h();
    }
    if (paramLong != -1L) {
      return this.b.a(paramLong);
    }
    throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
  }
  
  public void a()
  {
    this.b.d();
  }
  
  public void a(bj parambj)
  {
    this.a.b();
    String str = ec.a(parambj, this.a.f().c().b().type(), this.a.f().l());
    this.b.a(parambj.e(), str);
  }
  
  public void a(ed paramed)
  {
    this.b.a(paramed);
  }
  
  public bn.a b()
  {
    return this.b.g();
  }
  
  public void c()
  {
    if (d())
    {
      this.b.a();
      return;
    }
    this.b.b();
  }
  
  public boolean d()
  {
    if ("close".equalsIgnoreCase(this.a.d().a("Connection"))) {}
    while (("close".equalsIgnoreCase(this.a.e().a("Connection"))) || (this.b.c())) {
      return false;
    }
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\dx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */