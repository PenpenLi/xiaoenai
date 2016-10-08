package com.adhoc;

import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class dn
  implements eh
{
  private static final List<er> a = cb.a(new er[] { er.a("connection"), er.a("host"), er.a("keep-alive"), er.a("proxy-connection"), er.a("transfer-encoding") });
  private static final List<er> b = cb.a(new er[] { er.a("connection"), er.a("host"), er.a("keep-alive"), er.a("proxy-connection"), er.a("te"), er.a("transfer-encoding"), er.a("encoding"), er.a("upgrade") });
  private final dt c;
  private final ch d;
  private cr e;
  
  public dn(dt paramdt, ch paramch)
  {
    this.c = paramdt;
    this.d = paramch;
  }
  
  public static bn.a a(List<ct> paramList, bi parambi)
  {
    Object localObject1 = null;
    Object localObject2 = "HTTP/1.1";
    ba.a locala = new ba.a();
    locala.c(dy.d, parambi.toString());
    int n = paramList.size();
    int i = 0;
    while (i < n)
    {
      er localer = ((ct)paramList.get(i)).h;
      String str2 = ((ct)paramList.get(i)).i.a();
      int j = 0;
      if (j < str2.length())
      {
        int m = str2.indexOf(0, j);
        int k = m;
        if (m == -1) {
          k = str2.length();
        }
        String str1 = str2.substring(j, k);
        if (localer.equals(ct.a)) {
          localObject1 = str1;
        }
        for (;;)
        {
          j = k + 1;
          break;
          if (localer.equals(ct.g)) {
            localObject2 = str1;
          } else if (!a(parambi, localer)) {
            locala.a(localer.a(), str1);
          }
        }
      }
      i += 1;
    }
    if (localObject1 == null) {
      throw new ProtocolException("Expected ':status' header not present");
    }
    paramList = eg.a((String)localObject2 + " " + (String)localObject1);
    return new bn.a().a(parambi).a(paramList.b).a(paramList.c).a(locala.a());
  }
  
  private static String a(String paramString1, String paramString2)
  {
    return paramString1 + '\000' + paramString2;
  }
  
  public static List<ct> a(bj parambj, bi parambi, String paramString)
  {
    ba localba = parambj.e();
    ArrayList localArrayList = new ArrayList(localba.a() + 10);
    localArrayList.add(new ct(ct.b, parambj.d()));
    localArrayList.add(new ct(ct.c, ec.a(parambj.a())));
    String str = cb.a(parambj.a());
    int i;
    if (bi.c == parambi)
    {
      localArrayList.add(new ct(ct.g, paramString));
      localArrayList.add(new ct(ct.f, str));
      localArrayList.add(new ct(ct.d, parambj.a().c()));
      parambj = new LinkedHashSet();
      int k = localba.a();
      i = 0;
      label165:
      if (i >= k) {
        break label432;
      }
      paramString = er.a(localba.a(i).toLowerCase(Locale.US));
      str = localba.b(i);
      if (!a(parambi, paramString)) {
        break label251;
      }
    }
    label251:
    label430:
    for (;;)
    {
      i += 1;
      break label165;
      if (bi.d == parambi)
      {
        localArrayList.add(new ct(ct.e, str));
        break;
      }
      throw new AssertionError();
      if ((!paramString.equals(ct.b)) && (!paramString.equals(ct.c)) && (!paramString.equals(ct.d)) && (!paramString.equals(ct.e)) && (!paramString.equals(ct.f)) && (!paramString.equals(ct.g))) {
        if (parambj.add(paramString))
        {
          localArrayList.add(new ct(paramString, str));
        }
        else
        {
          int j = 0;
          for (;;)
          {
            if (j >= localArrayList.size()) {
              break label430;
            }
            if (((ct)localArrayList.get(j)).h.equals(paramString))
            {
              localArrayList.set(j, new ct(paramString, a(((ct)localArrayList.get(j)).i.a(), str)));
              break;
            }
            j += 1;
          }
        }
      }
    }
    label432:
    return localArrayList;
  }
  
  private static boolean a(bi parambi, er paramer)
  {
    if (parambi == bi.c) {
      return a.contains(paramer);
    }
    if (parambi == bi.d) {
      return b.contains(paramer);
    }
    throw new AssertionError(parambi);
  }
  
  public bp a(bn parambn)
  {
    return new ea(parambn.g(), ex.a(this.e.f()));
  }
  
  public ff a(bj parambj, long paramLong)
  {
    return this.e.g();
  }
  
  public void a()
  {
    this.e.g().close();
  }
  
  public void a(bj parambj)
  {
    try
    {
      if (this.e != null) {
        return;
      }
      this.c.b();
      boolean bool = this.c.c();
      String str = ec.a(this.c.f().l());
      this.e = this.d.a(a(parambj, this.d.a(), str), bool, true);
      this.e.e().a(this.c.a.b(), TimeUnit.MILLISECONDS);
      return;
    }
    catch (Throwable parambj)
    {
      fl.a(parambj);
    }
  }
  
  public void a(ed paramed)
  {
    paramed.a(this.e.g());
  }
  
  public bn.a b()
  {
    return a(this.e.d(), this.d.a());
  }
  
  public void c() {}
  
  public boolean d()
  {
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\dn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */