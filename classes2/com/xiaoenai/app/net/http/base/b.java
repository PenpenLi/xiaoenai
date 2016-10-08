package com.xiaoenai.app.net.http.base;

public class b
{
  private long a;
  private long b;
  private long c;
  private boolean d;
  private boolean e;
  private boolean f;
  private CacheType g;
  private long h;
  
  public b(a parama)
  {
    this.a = a.a(parama);
    this.b = a.b(parama);
    this.c = a.c(parama);
    this.d = a.d(parama);
    this.e = a.e(parama);
    this.f = a.f(parama);
    this.g = a.g(parama);
    this.h = a.h(parama);
  }
  
  public long a()
  {
    return this.a;
  }
  
  public long b()
  {
    return this.b;
  }
  
  public long c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    return this.e;
  }
  
  public static final class a
  {
    private long a;
    private long b;
    private long c;
    private boolean d = true;
    private boolean e = true;
    private boolean f = true;
    private CacheType g;
    private long h;
    
    public a a(boolean paramBoolean)
    {
      this.e = paramBoolean;
      return this;
    }
    
    public b a()
    {
      return new b(this);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\net\http\base\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */