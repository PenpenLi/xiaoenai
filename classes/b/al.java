package b;

import b.a.b.m;

public final class al
{
  private final ab a;
  private final String b;
  private final z c;
  private final an d;
  private final Object e;
  private volatile e f;
  
  private al(a parama)
  {
    this.a = a.a(parama);
    this.b = a.b(parama);
    this.c = a.c(parama).a();
    this.d = a.d(parama);
    if (a.e(parama) != null) {}
    for (parama = a.e(parama);; parama = this)
    {
      this.e = parama;
      return;
    }
  }
  
  public ab a()
  {
    return this.a;
  }
  
  public String a(String paramString)
  {
    return this.c.a(paramString);
  }
  
  public String b()
  {
    return this.b;
  }
  
  public z c()
  {
    return this.c;
  }
  
  public an d()
  {
    return this.d;
  }
  
  public a e()
  {
    return new a(this, null);
  }
  
  public e f()
  {
    e locale = this.f;
    if (locale != null) {
      return locale;
    }
    locale = e.a(this.c);
    this.f = locale;
    return locale;
  }
  
  public boolean g()
  {
    return this.a.c();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Request{method=").append(this.b).append(", url=").append(this.a).append(", tag=");
    if (this.e != this) {}
    for (Object localObject = this.e;; localObject = null) {
      return localObject + '}';
    }
  }
  
  public static class a
  {
    private ab a;
    private String b;
    private z.a c;
    private an d;
    private Object e;
    
    public a()
    {
      this.b = "GET";
      this.c = new z.a();
    }
    
    private a(al paramal)
    {
      this.a = al.a(paramal);
      this.b = al.b(paramal);
      this.d = al.c(paramal);
      this.e = al.d(paramal);
      this.c = al.e(paramal).b();
    }
    
    public a a()
    {
      return a("GET", null);
    }
    
    public a a(ab paramab)
    {
      if (paramab == null) {
        throw new IllegalArgumentException("url == null");
      }
      this.a = paramab;
      return this;
    }
    
    public a a(an paraman)
    {
      return a("POST", paraman);
    }
    
    public a a(z paramz)
    {
      this.c = paramz.b();
      return this;
    }
    
    public a a(Object paramObject)
    {
      this.e = paramObject;
      return this;
    }
    
    public a a(String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("url == null");
      }
      String str;
      if (paramString.regionMatches(true, 0, "ws:", 0, 3)) {
        str = "http:" + paramString.substring(3);
      }
      for (;;)
      {
        paramString = ab.e(str);
        if (paramString != null) {
          break;
        }
        throw new IllegalArgumentException("unexpected url: " + str);
        str = paramString;
        if (paramString.regionMatches(true, 0, "wss:", 0, 4)) {
          str = "https:" + paramString.substring(4);
        }
      }
      return a(paramString);
    }
    
    public a a(String paramString, an paraman)
    {
      if ((paramString == null) || (paramString.length() == 0)) {
        throw new IllegalArgumentException("method == null || method.length() == 0");
      }
      if ((paraman != null) && (!m.c(paramString))) {
        throw new IllegalArgumentException("method " + paramString + " must not have a request body.");
      }
      if ((paraman == null) && (m.b(paramString))) {
        throw new IllegalArgumentException("method " + paramString + " must have a request body.");
      }
      this.b = paramString;
      this.d = paraman;
      return this;
    }
    
    public a a(String paramString1, String paramString2)
    {
      this.c.c(paramString1, paramString2);
      return this;
    }
    
    public a b(an paraman)
    {
      return a("PUT", paraman);
    }
    
    public a b(String paramString)
    {
      this.c.b(paramString);
      return this;
    }
    
    public a b(String paramString1, String paramString2)
    {
      this.c.a(paramString1, paramString2);
      return this;
    }
    
    public al b()
    {
      if (this.a == null) {
        throw new IllegalStateException("url == null");
      }
      return new al(this, null);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */