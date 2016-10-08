package b;

public final class aq
{
  private final al a;
  private final ai b;
  private final int c;
  private final String d;
  private final y e;
  private final z f;
  private final as g;
  private aq h;
  private aq i;
  private final aq j;
  private volatile e k;
  
  private aq(a parama)
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
  
  public al a()
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
  
  public int b()
  {
    return this.c;
  }
  
  public boolean c()
  {
    return (this.c >= 200) && (this.c < 300);
  }
  
  public String d()
  {
    return this.d;
  }
  
  public y e()
  {
    return this.e;
  }
  
  public z f()
  {
    return this.f;
  }
  
  public as g()
  {
    return this.g;
  }
  
  public a h()
  {
    return new a(this, null);
  }
  
  public e i()
  {
    e locale = this.k;
    if (locale != null) {
      return locale;
    }
    locale = e.a(this.f);
    this.k = locale;
    return locale;
  }
  
  public String toString()
  {
    return "Response{protocol=" + this.b + ", code=" + this.c + ", message=" + this.d + ", url=" + this.a.a() + '}';
  }
  
  public static class a
  {
    private al a;
    private ai b;
    private int c = -1;
    private String d;
    private y e;
    private z.a f;
    private as g;
    private aq h;
    private aq i;
    private aq j;
    
    public a()
    {
      this.f = new z.a();
    }
    
    private a(aq paramaq)
    {
      this.a = aq.a(paramaq);
      this.b = aq.b(paramaq);
      this.c = aq.c(paramaq);
      this.d = aq.d(paramaq);
      this.e = aq.e(paramaq);
      this.f = aq.f(paramaq).b();
      this.g = aq.g(paramaq);
      this.h = aq.h(paramaq);
      this.i = aq.i(paramaq);
      this.j = aq.j(paramaq);
    }
    
    private void a(String paramString, aq paramaq)
    {
      if (aq.g(paramaq) != null) {
        throw new IllegalArgumentException(paramString + ".body != null");
      }
      if (aq.h(paramaq) != null) {
        throw new IllegalArgumentException(paramString + ".networkResponse != null");
      }
      if (aq.i(paramaq) != null) {
        throw new IllegalArgumentException(paramString + ".cacheResponse != null");
      }
      if (aq.j(paramaq) != null) {
        throw new IllegalArgumentException(paramString + ".priorResponse != null");
      }
    }
    
    private void d(aq paramaq)
    {
      if (aq.g(paramaq) != null) {
        throw new IllegalArgumentException("priorResponse.body != null");
      }
    }
    
    public a a(int paramInt)
    {
      this.c = paramInt;
      return this;
    }
    
    public a a(ai paramai)
    {
      this.b = paramai;
      return this;
    }
    
    public a a(al paramal)
    {
      this.a = paramal;
      return this;
    }
    
    public a a(aq paramaq)
    {
      if (paramaq != null) {
        a("networkResponse", paramaq);
      }
      this.h = paramaq;
      return this;
    }
    
    public a a(as paramas)
    {
      this.g = paramas;
      return this;
    }
    
    public a a(y paramy)
    {
      this.e = paramy;
      return this;
    }
    
    public a a(z paramz)
    {
      this.f = paramz.b();
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
    
    public aq a()
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
      return new aq(this, null);
    }
    
    public a b(aq paramaq)
    {
      if (paramaq != null) {
        a("cacheResponse", paramaq);
      }
      this.i = paramaq;
      return this;
    }
    
    public a b(String paramString1, String paramString2)
    {
      this.f.a(paramString1, paramString2);
      return this;
    }
    
    public a c(aq paramaq)
    {
      if (paramaq != null) {
        d(paramaq);
      }
      this.j = paramaq;
      return this;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */