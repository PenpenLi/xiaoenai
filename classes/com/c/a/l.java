package com.c.a;

import android.view.View;
import com.c.b.c;
import com.c.c.a.a;
import java.util.HashMap;
import java.util.Map;

public final class l
  extends ad
{
  private static final Map<String, c> h = new HashMap();
  private Object i;
  private String j;
  private c k;
  
  static
  {
    h.put("alpha", m.a);
    h.put("pivotX", m.b);
    h.put("pivotY", m.c);
    h.put("translationX", m.d);
    h.put("translationY", m.e);
    h.put("rotation", m.f);
    h.put("rotationX", m.g);
    h.put("rotationY", m.h);
    h.put("scaleX", m.i);
    h.put("scaleY", m.j);
    h.put("scrollX", m.k);
    h.put("scrollY", m.l);
    h.put("x", m.m);
    h.put("y", m.n);
  }
  
  public l() {}
  
  private l(Object paramObject, String paramString)
  {
    this.i = paramObject;
    a(paramString);
  }
  
  public static l a(Object paramObject, String paramString, float... paramVarArgs)
  {
    paramObject = new l(paramObject, paramString);
    ((l)paramObject).a(paramVarArgs);
    return (l)paramObject;
  }
  
  public void a()
  {
    super.a();
  }
  
  void a(float paramFloat)
  {
    super.a(paramFloat);
    int n = this.f.length;
    int m = 0;
    while (m < n)
    {
      this.f[m].b(this.i);
      m += 1;
    }
  }
  
  public void a(c paramc)
  {
    if (this.f != null)
    {
      ab localab = this.f[0];
      String str = localab.c();
      localab.a(paramc);
      this.g.remove(str);
      this.g.put(this.j, localab);
    }
    if (this.k != null) {
      this.j = paramc.a();
    }
    this.k = paramc;
    this.e = false;
  }
  
  public void a(String paramString)
  {
    if (this.f != null)
    {
      ab localab = this.f[0];
      String str = localab.c();
      localab.a(paramString);
      this.g.remove(str);
      this.g.put(paramString, localab);
    }
    this.j = paramString;
    this.e = false;
  }
  
  public void a(float... paramVarArgs)
  {
    if ((this.f == null) || (this.f.length == 0))
    {
      if (this.k != null)
      {
        a(new ab[] { ab.a(this.k, paramVarArgs) });
        return;
      }
      a(new ab[] { ab.a(this.j, paramVarArgs) });
      return;
    }
    super.a(paramVarArgs);
  }
  
  public void a(int... paramVarArgs)
  {
    if ((this.f == null) || (this.f.length == 0))
    {
      if (this.k != null)
      {
        a(new ab[] { ab.a(this.k, paramVarArgs) });
        return;
      }
      a(new ab[] { ab.a(this.j, paramVarArgs) });
      return;
    }
    super.a(paramVarArgs);
  }
  
  public void a(Object... paramVarArgs)
  {
    if ((this.f == null) || (this.f.length == 0))
    {
      if (this.k != null)
      {
        a(new ab[] { ab.a(this.k, (ac)null, paramVarArgs) });
        return;
      }
      a(new ab[] { ab.a(this.j, (ac)null, paramVarArgs) });
      return;
    }
    super.a(paramVarArgs);
  }
  
  public l b(long paramLong)
  {
    super.c(paramLong);
    return this;
  }
  
  void h()
  {
    if (!this.e)
    {
      if ((this.k == null) && (a.a) && ((this.i instanceof View)) && (h.containsKey(this.j))) {
        a((c)h.get(this.j));
      }
      int n = this.f.length;
      int m = 0;
      while (m < n)
      {
        this.f[m].a(this.i);
        m += 1;
      }
      super.h();
    }
  }
  
  public l i()
  {
    return (l)super.j();
  }
  
  public String toString()
  {
    String str1 = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.i;
    String str2 = str1;
    if (this.f != null)
    {
      int m = 0;
      for (;;)
      {
        str2 = str1;
        if (m >= this.f.length) {
          break;
        }
        str1 = str1 + "\n    " + this.f[m].toString();
        m += 1;
      }
    }
    return str2;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\c\a\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */