package com.adhoc;

import java.util.Collections;
import java.util.List;

public final class bn
{
  private final bj a;
  private final bi b;
  private final int c;
  private final String d;
  private final az e;
  private final ba f;
  private final bp g;
  private bn h;
  private bn i;
  private final bn j;
  private volatile aj k;
  
  private bn(a parama)
  {
    this.a = a.a(parama);
    this.b = a.b(parama);
    this.c = a.c(parama);
    this.d = a.d(parama);
    this.e = a.e(parama);
    this.f = a.f(parama).a();
    this.g = a.g(parama);
    this.h = a.h(parama);
    this.i = a.i(parama);
    this.j = a.j(parama);
  }
  
  public bj a()
  {
    return this.a;
  }
  
  public String a(String paramString)
  {
    return a(paramString, null);
  }
  
  public String a(String paramString1, String paramString2)
  {
    paramString1 = this.f.a(paramString1);
    if (paramString1 != null) {
      paramString2 = paramString1;
    }
    return paramString2;
  }
  
  public bi b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    return (this.c >= 200) && (this.c < 300);
  }
  
  public String e()
  {
    return this.d;
  }
  
  public az f()
  {
    return this.e;
  }
  
  public ba g()
  {
    return this.f;
  }
  
  public bp h()
  {
    return this.g;
  }
  
  public a i()
  {
    return new a(this, null);
  }
  
  public List<aq> j()
  {
    if (this.c == 401) {}
    for (String str = "WWW-Authenticate";; str = "Proxy-Authenticate")
    {
      return dy.b(g(), str);
      if (this.c != 407) {
        break;
      }
    }
    return Collections.emptyList();
  }
  
  public aj k()
  {
    aj localaj = this.k;
    if (localaj != null) {
      return localaj;
    }
    localaj = aj.a(this.f);
    this.k = localaj;
    return localaj;
  }
  
  public String toString()
  {
    return "Response{protocol=" + this.b + ", code=" + this.c + ", message=" + this.d + ", url=" + this.a.c() + '}';
  }
  
  public static class a
  {
    private bj a;
    private bi b;
    private int c = -1;
    private String d;
    private az e;
    private ba.a f;
    private bp g;
    private bn h;
    private bn i;
    private bn j;
    
    public a()
    {
      this.f = new ba.a();
    }
    
    private a(bn parambn)
    {
      this.a = bn.a(parambn);
      this.b = bn.b(parambn);
      this.c = bn.c(parambn);
      this.d = bn.d(parambn);
      this.e = bn.e(parambn);
      this.f = bn.f(parambn).b();
      this.g = bn.g(parambn);
      this.h = bn.h(parambn);
      this.i = bn.i(parambn);
      this.j = bn.j(parambn);
    }
    
    private void a(String paramString, bn parambn)
    {
      if (bn.g(parambn) != null) {
        throw new IllegalArgumentException(paramString + ".body != null");
      }
      if (bn.h(parambn) != null) {
        throw new IllegalArgumentException(paramString + ".networkResponse != null");
      }
      if (bn.i(parambn) != null) {
        throw new IllegalArgumentException(paramString + ".cacheResponse != null");
      }
      if (bn.j(parambn) != null) {
        throw new IllegalArgumentException(paramString + ".priorResponse != null");
      }
    }
    
    private void d(bn parambn)
    {
      if (bn.g(parambn) != null) {
        throw new IllegalArgumentException("priorResponse.body != null");
      }
    }
    
    public a a(int paramInt)
    {
      this.c = paramInt;
      return this;
    }
    
    public a a(az paramaz)
    {
      this.e = paramaz;
      return this;
    }
    
    public a a(ba paramba)
    {
      this.f = paramba.b();
      return this;
    }
    
    public a a(bi parambi)
    {
      this.b = parambi;
      return this;
    }
    
    public a a(bj parambj)
    {
      this.a = parambj;
      return this;
    }
    
    public a a(bn parambn)
    {
      if (parambn != null) {
        a("networkResponse", parambn);
      }
      this.h = parambn;
      return this;
    }
    
    public a a(bp parambp)
    {
      this.g = parambp;
      return this;
    }
    
    public a a(String paramString)
    {
      this.d = paramString;
      return this;
    }
    
    public a a(String paramString1, String paramString2)
    {
      this.f.c(paramString1, paramString2);
      return this;
    }
    
    public bn a()
    {
      if (this.a == null) {
        throw new IllegalStateException("request == null");
      }
      if (this.b == null) {
        throw new IllegalStateException("protocol == null");
      }
      if (this.c < 0) {
        throw new IllegalStateException("code < 0: " + this.c);
      }
      return new bn(this, null);
    }
    
    public a b(bn parambn)
    {
      if (parambn != null) {
        a("cacheResponse", parambn);
      }
      this.i = parambn;
      return this;
    }
    
    public a b(String paramString1, String paramString2)
    {
      this.f.a(paramString1, paramString2);
      return this;
    }
    
    public a c(bn parambn)
    {
      if (parambn != null) {
        d(parambn);
      }
      this.j = parambn;
      return this;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */