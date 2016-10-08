package com.xiaoenai.app.h.c;

import android.content.Context;
import android.text.TextUtils;
import com.meiqia.core.c.d.e;
import java.util.Map;

public class a
{
  private static a a;
  private com.meiqia.core.a b;
  private String c = "fdc9bc26c265c74cba9cb0f91238396f";
  
  public static a a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new a();
      }
      return a;
    }
    finally {}
  }
  
  public void a(long paramLong)
  {
    this.b.a(paramLong);
  }
  
  public void a(long paramLong, com.xiaoenai.app.h.c.a.c paramc)
  {
    this.b.b(paramLong, 20, new e(this, paramc));
  }
  
  public void a(Context paramContext, com.xiaoenai.app.h.c.a.d paramd)
  {
    com.meiqia.core.a.a(paramContext, this.c, new b(this, paramd));
    this.b = com.meiqia.core.a.a(paramContext);
  }
  
  public void a(com.meiqia.core.d.e parame)
  {
    this.b.a(new i(this, parame));
  }
  
  public void a(com.xiaoenai.app.h.c.b.b paramb, com.xiaoenai.app.h.c.a.e parame)
  {
    parame = new g(this, paramb, parame);
    if (paramb.c().equals("text")) {
      this.b.a(paramb.h(), parame);
    }
    while (!paramb.c().equals("photo")) {
      return;
    }
    this.b.b(paramb.h(), parame);
  }
  
  public void a(String paramString1, String paramString2, com.xiaoenai.app.h.c.a.a parama)
  {
    parama = new d(this, parama);
    if (!TextUtils.isEmpty(paramString1))
    {
      this.b.b(paramString1, parama);
      return;
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      this.b.a(paramString2, parama);
      return;
    }
    this.b.a(parama);
  }
  
  public void a(Map<String, String> paramMap)
  {
    this.b.a(paramMap, new c(this));
  }
  
  public com.xiaoenai.app.h.c.b.a b()
  {
    return com.xiaoenai.app.h.c.b.a.a.a(this.b.b());
  }
  
  public void b(long paramLong)
  {
    this.b.b(paramLong);
  }
  
  public void b(long paramLong, com.xiaoenai.app.h.c.a.c paramc)
  {
    this.b.a(paramLong, 20, new f(this, paramc));
  }
  
  public void b(com.xiaoenai.app.h.c.b.b paramb, com.xiaoenai.app.h.c.a.e parame)
  {
    a(paramb, new h(this, parame, paramb, paramb.a()));
  }
  
  public boolean c()
  {
    return this.b.i();
  }
  
  public String d()
  {
    return this.b.j().c.a();
  }
  
  public String e()
  {
    return this.b.c();
  }
  
  public void f()
  {
    this.b.h();
  }
  
  public void g()
  {
    this.b.g();
  }
  
  public void h()
  {
    this.b.e();
  }
  
  public void i()
  {
    this.b.f();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\h\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */