package com.meiqia.core.c;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.List;

public class e
{
  public static final List<String> a = Arrays.asList(new String[] { "message", "evaluate", "redirect", "reply", "menu", "queueing", "manual_redirect" });
  private String b;
  private String c;
  private String d;
  private long e;
  private long f;
  private long g;
  private String h;
  private long i = System.currentTimeMillis();
  private String j;
  private String k;
  private String l;
  private String m = "arrived";
  private String n;
  private String o;
  private boolean p;
  private String q;
  private String r;
  private String s;
  private long t;
  private boolean u;
  
  public e()
  {
    this("text");
  }
  
  public e(String paramString)
  {
    this.d = paramString;
    this.f = System.currentTimeMillis();
    this.p = true;
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a(long paramLong)
  {
    this.e = paramLong;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public void b(long paramLong)
  {
    this.f = paramLong;
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public void c(long paramLong)
  {
    this.g = paramLong;
  }
  
  public void c(String paramString)
  {
    this.d = paramString;
  }
  
  public long d()
  {
    return this.e;
  }
  
  public void d(long paramLong)
  {
    this.i = paramLong;
  }
  
  public void d(String paramString)
  {
    this.h = paramString;
  }
  
  public long e()
  {
    return this.f;
  }
  
  public void e(long paramLong)
  {
    this.t = paramLong;
  }
  
  public void e(String paramString)
  {
    this.j = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof e)) {}
    do
    {
      return false;
      paramObject = (e)paramObject;
    } while (this.i != ((e)paramObject).h());
    return true;
  }
  
  public long f()
  {
    return this.g;
  }
  
  public void f(String paramString)
  {
    this.k = paramString;
  }
  
  public String g()
  {
    return this.h;
  }
  
  public void g(String paramString)
  {
    this.m = paramString;
  }
  
  public long h()
  {
    return this.i;
  }
  
  public void h(String paramString)
  {
    this.l = paramString;
  }
  
  public String i()
  {
    return this.j;
  }
  
  public void i(String paramString)
  {
    this.n = paramString;
  }
  
  public String j()
  {
    return this.k;
  }
  
  public void j(String paramString)
  {
    this.o = paramString;
  }
  
  public String k()
  {
    return this.m;
  }
  
  public void k(String paramString)
  {
    this.q = paramString;
  }
  
  public String l()
  {
    return this.l;
  }
  
  public void l(String paramString)
  {
    this.r = paramString;
  }
  
  public String m()
  {
    return this.n;
  }
  
  public void m(String paramString)
  {
    this.s = paramString;
  }
  
  public boolean n()
  {
    return this.p;
  }
  
  public String o()
  {
    return this.o;
  }
  
  public String p()
  {
    return this.q;
  }
  
  public String q()
  {
    return this.r;
  }
  
  public boolean r()
  {
    return this.u;
  }
  
  public boolean s()
  {
    return TextUtils.equals("bot", g());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */