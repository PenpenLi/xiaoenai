package com.xiaoenai.app.net.http.base.a;

import com.xiaoenai.app.net.http.base.b;
import com.xiaoenai.app.net.http.base.d;
import com.xiaoenai.app.net.http.base.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class c
{
  protected String a;
  protected Object b;
  protected Map<String, String> c;
  protected Map<String, String> d;
  protected List<a> e;
  protected String f;
  protected String g;
  protected com.xiaoenai.app.net.http.base.b.a h;
  protected com.xiaoenai.app.net.http.base.c i;
  
  protected c(a parama)
  {
    this.a = parama.a;
    this.b = parama.b;
    this.c = parama.d;
    this.d = parama.c;
    this.f = parama.f;
    this.g = parama.g;
    this.h = parama.h;
    this.e = parama.e;
    this.i = parama.i;
  }
  
  private void g()
  {
    if (this.i == null) {
      this.i = new d();
    }
    this.c = this.i.a(this.c);
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(b paramb)
  {
    g();
    f.a().b().a(this, this.h, paramb);
  }
  
  public Object b()
  {
    return this.b;
  }
  
  public Map<String, String> c()
  {
    return this.c;
  }
  
  public Map<String, String> d()
  {
    return this.d;
  }
  
  public List<a> e()
  {
    return this.e;
  }
  
  public String f()
  {
    return this.f;
  }
  
  public static final class a
  {
    String a;
    Object b;
    Map<String, String> c;
    Map<String, String> d;
    List<a> e = new ArrayList();
    String f;
    String g;
    com.xiaoenai.app.net.http.base.b.a h;
    com.xiaoenai.app.net.http.base.c i;
    
    public a a()
    {
      return b("POST").c("application/json; charset=utf-8");
    }
    
    public a a(a parama)
    {
      this.e.add(parama);
      return this;
    }
    
    public a a(com.xiaoenai.app.net.http.base.b.a parama)
    {
      this.h = parama;
      return this;
    }
    
    public a a(com.xiaoenai.app.net.http.base.c paramc)
    {
      this.i = paramc;
      return this;
    }
    
    public a a(String paramString)
    {
      this.a = paramString;
      return this;
    }
    
    public a a(Map<String, String> paramMap)
    {
      this.d = paramMap;
      return this;
    }
    
    public a b()
    {
      return b("POST").c("application/octet-stream");
    }
    
    public a b(String paramString)
    {
      this.f = paramString;
      return this;
    }
    
    public a c(String paramString)
    {
      this.g = paramString;
      return this;
    }
    
    public c c()
    {
      return new c(this);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\net\http\base\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */