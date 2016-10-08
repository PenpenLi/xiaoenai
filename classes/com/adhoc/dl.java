package com.adhoc;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public final class dl
{
  public final bj a;
  public final bn b;
  
  private dl(bj parambj, bn parambn)
  {
    this.a = parambj;
    this.b = parambn;
  }
  
  public static boolean a(bn parambn, bj parambj)
  {
    switch (parambn.c())
    {
    }
    do
    {
      return false;
    } while (((parambn.a("Expires") == null) && (parambn.k().c() == -1) && (!parambn.k().e()) && (!parambn.k().d())) || (parambn.k().b()) || (parambj.h().b()));
    return true;
  }
  
  public static class a
  {
    final long a;
    final bj b;
    final bn c;
    private Date d;
    private String e;
    private Date f;
    private String g;
    private Date h;
    private long i;
    private long j;
    private String k;
    private int l = -1;
    
    public a(long paramLong, bj parambj, bn parambn)
    {
      this.a = paramLong;
      this.b = parambj;
      this.c = parambn;
      if (parambn != null)
      {
        parambj = parambn.g();
        int m = 0;
        int n = parambj.a();
        if (m < n)
        {
          parambn = parambj.a(m);
          String str = parambj.b(m);
          if ("Date".equalsIgnoreCase(parambn))
          {
            this.d = dr.a(str);
            this.e = str;
          }
          for (;;)
          {
            m += 1;
            break;
            if ("Expires".equalsIgnoreCase(parambn))
            {
              this.h = dr.a(str);
            }
            else if ("Last-Modified".equalsIgnoreCase(parambn))
            {
              this.f = dr.a(str);
              this.g = str;
            }
            else if ("ETag".equalsIgnoreCase(parambn))
            {
              this.k = str;
            }
            else if ("Age".equalsIgnoreCase(parambn))
            {
              this.l = do.b(str, -1);
            }
            else if (dy.b.equalsIgnoreCase(parambn))
            {
              this.i = Long.parseLong(str);
            }
            else if (dy.c.equalsIgnoreCase(parambn))
            {
              this.j = Long.parseLong(str);
            }
          }
        }
      }
    }
    
    private static boolean a(bj parambj)
    {
      return (parambj.a("If-Modified-Since") != null) || (parambj.a("If-None-Match") != null);
    }
    
    private dl b()
    {
      long l4 = 0L;
      if (this.c == null) {
        return new dl(this.b, null, null);
      }
      if ((this.b.i()) && (this.c.f() == null)) {
        return new dl(this.b, null, null);
      }
      if (!dl.a(this.c, this.b)) {
        return new dl(this.b, null, null);
      }
      Object localObject = this.b.h();
      if ((((aj)localObject).a()) || (a(this.b))) {
        return new dl(this.b, null, null);
      }
      long l5 = d();
      long l2 = c();
      long l1 = l2;
      if (((aj)localObject).c() != -1) {
        l1 = Math.min(l2, TimeUnit.SECONDS.toMillis(((aj)localObject).c()));
      }
      if (((aj)localObject).h() != -1) {}
      for (l2 = TimeUnit.SECONDS.toMillis(((aj)localObject).h());; l2 = 0L)
      {
        aj localaj = this.c.k();
        long l3 = l4;
        if (!localaj.f())
        {
          l3 = l4;
          if (((aj)localObject).g() != -1) {
            l3 = TimeUnit.SECONDS.toMillis(((aj)localObject).g());
          }
        }
        if ((!localaj.a()) && (l5 + l2 < l3 + l1))
        {
          localObject = this.c.i();
          if (l2 + l5 >= l1) {
            ((bn.a)localObject).b("Warning", "110 HttpURLConnection \"Response is stale\"");
          }
          if ((l5 > 86400000L) && (e())) {
            ((bn.a)localObject).b("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
          }
          return new dl(null, ((bn.a)localObject).a(), null);
        }
        localObject = this.b.g();
        if (this.k != null) {
          ((bj.a)localObject).a("If-None-Match", this.k);
        }
        for (;;)
        {
          localObject = ((bj.a)localObject).a();
          if (!a((bj)localObject)) {
            break;
          }
          return new dl((bj)localObject, this.c, null);
          if (this.f != null) {
            ((bj.a)localObject).a("If-Modified-Since", this.g);
          } else if (this.d != null) {
            ((bj.a)localObject).a("If-Modified-Since", this.e);
          }
        }
        return new dl((bj)localObject, null, null);
      }
    }
    
    private long c()
    {
      long l2 = 0L;
      aj localaj = this.c.k();
      if (localaj.c() != -1) {
        l1 = TimeUnit.SECONDS.toMillis(localaj.c());
      }
      label81:
      do
      {
        do
        {
          return l1;
          if (this.h != null)
          {
            if (this.d != null)
            {
              l1 = this.d.getTime();
              l1 = this.h.getTime() - l1;
              if (l1 <= 0L) {
                break label81;
              }
            }
            for (;;)
            {
              return l1;
              l1 = this.j;
              break;
              l1 = 0L;
            }
          }
          l1 = l2;
        } while (this.f == null);
        l1 = l2;
      } while (this.c.a().a().l() != null);
      if (this.d != null) {}
      for (long l1 = this.d.getTime();; l1 = this.i)
      {
        long l3 = l1 - this.f.getTime();
        l1 = l2;
        if (l3 <= 0L) {
          break;
        }
        return l3 / 10L;
      }
    }
    
    private long d()
    {
      long l1 = 0L;
      if (this.d != null) {
        l1 = Math.max(0L, this.j - this.d.getTime());
      }
      long l2 = l1;
      if (this.l != -1) {
        l2 = Math.max(l1, TimeUnit.SECONDS.toMillis(this.l));
      }
      return l2 + (this.j - this.i) + (this.a - this.j);
    }
    
    private boolean e()
    {
      return (this.c.k().c() == -1) && (this.h == null);
    }
    
    public dl a()
    {
      dl localdl2 = b();
      dl localdl1 = localdl2;
      if (localdl2.a != null)
      {
        localdl1 = localdl2;
        if (this.b.h().i()) {
          localdl1 = new dl(null, null, null);
        }
      }
      return localdl1;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\dl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */