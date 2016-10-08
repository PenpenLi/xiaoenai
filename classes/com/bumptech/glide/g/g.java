package com.bumptech.glide.g;

public class g
  implements c, d
{
  private c a;
  private c b;
  private d c;
  
  public g()
  {
    this(null);
  }
  
  public g(d paramd)
  {
    this.c = paramd;
  }
  
  private boolean j()
  {
    return (this.c == null) || (this.c.a(this));
  }
  
  private boolean k()
  {
    return (this.c == null) || (this.c.b(this));
  }
  
  private boolean l()
  {
    return (this.c != null) && (this.c.c());
  }
  
  public void a()
  {
    this.a.a();
    this.b.a();
  }
  
  public void a(c paramc1, c paramc2)
  {
    this.a = paramc1;
    this.b = paramc2;
  }
  
  public boolean a(c paramc)
  {
    return (j()) && ((paramc.equals(this.a)) || (!this.a.h()));
  }
  
  public void b()
  {
    if (!this.b.f()) {
      this.b.b();
    }
    if (!this.a.f()) {
      this.a.b();
    }
  }
  
  public boolean b(c paramc)
  {
    return (k()) && (paramc.equals(this.a)) && (!c());
  }
  
  public void c(c paramc)
  {
    if (paramc.equals(this.b)) {}
    do
    {
      return;
      if (this.c != null) {
        this.c.c(this);
      }
    } while (this.b.g());
    this.b.d();
  }
  
  public boolean c()
  {
    return (l()) || (h());
  }
  
  public void d()
  {
    this.b.d();
    this.a.d();
  }
  
  public void e()
  {
    this.a.e();
    this.b.e();
  }
  
  public boolean f()
  {
    return this.a.f();
  }
  
  public boolean g()
  {
    return (this.a.g()) || (this.b.g());
  }
  
  public boolean h()
  {
    return (this.a.h()) || (this.b.h());
  }
  
  public boolean i()
  {
    return this.a.i();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\g\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */