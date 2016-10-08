package com.alipay.sdk.protocol;

import android.text.TextUtils;
import org.json.JSONObject;

public enum a
{
  private String h;
  private String i;
  private String j;
  private JSONObject k;
  private String l;
  private String m;
  private String n;
  private boolean o;
  private boolean p;
  private boolean q;
  private String r;
  private String s;
  private String t;
  private JSONObject u;
  
  private a(String paramString)
  {
    this.h = paramString;
  }
  
  public static a[] a(b paramb)
  {
    if (paramb != null)
    {
      localObject1 = paramb.a;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label278;
      }
    }
    label85:
    label275:
    label278:
    for (Object localObject1 = ((String)localObject1).split(";");; localObject1 = null)
    {
      if (localObject1 == null) {
        return new a[] { c };
      }
      a[] arrayOfa1 = new a[localObject1.length];
      int i4 = localObject1.length;
      int i2 = 0;
      int i1 = 0;
      String str;
      Object localObject2;
      int i3;
      if (i2 < i4)
      {
        str = localObject1[i2];
        localObject2 = c;
        a[] arrayOfa2 = values();
        int i5 = arrayOfa2.length;
        i3 = 0;
        if (i3 >= i5) {
          break label275;
        }
        a locala = arrayOfa2[i3];
        if (str.startsWith(locala.h)) {
          localObject2 = locala;
        }
      }
      for (;;)
      {
        ((a)localObject2).i = str;
        if (TextUtils.isEmpty(paramb.b)) {
          paramb.b = com.alipay.sdk.cons.a.b;
        }
        ((a)localObject2).j = paramb.b;
        ((a)localObject2).k = paramb.a();
        ((a)localObject2).l = paramb.c;
        ((a)localObject2).m = paramb.d;
        ((a)localObject2).n = paramb.e;
        ((a)localObject2).o = paramb.f;
        ((a)localObject2).p = paramb.g;
        ((a)localObject2).q = paramb.h;
        ((a)localObject2).r = paramb.i;
        ((a)localObject2).s = paramb.j;
        ((a)localObject2).t = paramb.k;
        ((a)localObject2).u = paramb.l;
        arrayOfa1[i1] = localObject2;
        i2 += 1;
        i1 += 1;
        break;
        i3 += 1;
        break label85;
        return arrayOfa1;
        return new a[] { c };
      }
    }
  }
  
  private static String[] a(String paramString)
  {
    String[] arrayOfString = null;
    if (!TextUtils.isEmpty(paramString)) {
      arrayOfString = paramString.split(";");
    }
    return arrayOfString;
  }
  
  private JSONObject m()
  {
    return this.k;
  }
  
  public final JSONObject a()
  {
    return this.u;
  }
  
  public final String b()
  {
    return this.t;
  }
  
  public final String c()
  {
    return this.r;
  }
  
  public final String d()
  {
    return this.s;
  }
  
  public final String e()
  {
    return this.i;
  }
  
  public final String f()
  {
    return this.j;
  }
  
  public final String g()
  {
    return this.m;
  }
  
  public final String h()
  {
    return this.n;
  }
  
  public final boolean i()
  {
    return this.o;
  }
  
  public final boolean j()
  {
    return this.p;
  }
  
  public final boolean k()
  {
    return this.q;
  }
  
  public final String l()
  {
    return this.l;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\protocol\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */