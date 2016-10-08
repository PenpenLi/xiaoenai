package b.a.b;

import b.ab;
import b.al;
import b.al.a;
import b.aq;
import b.aq.a;
import b.e;
import b.z;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public final class b
{
  public final al a;
  public final aq b;
  
  private b(al paramal, aq paramaq)
  {
    this.a = paramal;
    this.b = paramaq;
  }
  
  public static boolean a(aq paramaq, al paramal)
  {
    switch (paramaq.b())
    {
    }
    do
    {
      return false;
    } while (((paramaq.a("Expires") == null) && (paramaq.i().c() == -1) && (!paramaq.i().e()) && (!paramaq.i().d())) || (paramaq.i().b()) || (paramal.f().b()));
    return true;
  }
  
  public static class a
  {
    final long a;
    final al b;
    final aq c;
    private Date d;
    private String e;
    private Date f;
    private String g;
    private Date h;
    private long i;
    private long j;
    private String k;
    private int l = -1;
    
    public a(long paramLong, al paramal, aq paramaq)
    {
      this.a = paramLong;
      this.b = paramal;
      this.c = paramaq;
      if (paramaq != null)
      {
        paramal = paramaq.f();
        int m = 0;
        int n = paramal.a();
        if (m < n)
        {
          paramaq = paramal.a(m);
          String str = paramal.b(m);
          if ("Date".equalsIgnoreCase(paramaq))
          {
            this.d = h.a(str);
            this.e = str;
          }
          for (;;)
          {
            m += 1;
            break;
            if ("Expires".equalsIgnoreCase(paramaq))
            {
              this.h = h.a(str);
            }
            else if ("Last-Modified".equalsIgnoreCase(paramaq))
            {
              this.f = h.a(str);
              this.g = str;
            }
            else if ("ETag".equalsIgnoreCase(paramaq))
            {
              this.k = str;
            }
            else if ("Age".equalsIgnoreCase(paramaq))
            {
              this.l = d.b(str, -1);
            }
            else if (o.b.equalsIgnoreCase(paramaq))
            {
              this.i = Long.parseLong(str);
            }
            else if (o.c.equalsIgnoreCase(paramaq))
            {
              this.j = Long.parseLong(str);
            }
          }
        }
      }
    }
    
    private static boolean a(al paramal)
    {
      return (paramal.a("If-Modified-Since") != null) || (paramal.a("If-None-Match") != null);
    }
    
    private b b()
    {
      long l4 = 0L;
      if (this.c == null) {
        return new b(this.b, null, null);
      }
      if ((this.b.g()) && (this.c.e() == null)) {
        return new b(this.b, null, null);
      }
      if (!b.a(this.c, this.b)) {
        return new b(this.b, null, null);
      }
      Object localObject = this.b.f();
      if ((((e)localObject).a()) || (a(this.b))) {
        return new b(this.b, null, null);
      }
      long l5 = d();
      long l2 = c();
      long l1 = l2;
      if (((e)localObject).c() != -1) {
        l1 = Math.min(l2, TimeUnit.SECONDS.toMillis(((e)localObject).c()));
      }
      if (((e)localObject).h() != -1) {}
      for (l2 = TimeUnit.SECONDS.toMillis(((e)localObject).h());; l2 = 0L)
      {
        e locale = this.c.i();
        long l3 = l4;
        if (!locale.f())
        {
          l3 = l4;
          if (((e)localObject).g() != -1) {
            l3 = TimeUnit.SECONDS.toMillis(((e)localObject).g());
          }
        }
        if ((!locale.a()) && (l5 + l2 < l3 + l1))
        {
          localObject = this.c.h();
          if (l2 + l5 >= l1) {
            ((aq.a)localObject).b("Warning", "110 HttpURLConnection \"Response is stale\"");
          }
          if ((l5 > 86400000L) && (e())) {
            ((aq.a)localObject).b("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
          }
          return new b(null, ((aq.a)localObject).a(), null);
        }
        localObject = this.b.e();
        if (this.k != null) {
          ((al.a)localObject).a("If-None-Match", this.k);
        }
        for (;;)
        {
          localObject = ((al.a)localObject).b();
          if (!a((al)localObject)) {
            break;
          }
          return new b((al)localObject, this.c, null);
          if (this.f != null) {
            ((al.a)localObject).a("If-Modified-Since", this.g);
          } else if (this.d != null) {
            ((al.a)localObject).a("If-Modified-Since", this.e);
          }
        }
        return new b((al)localObject, null, null);
      }
    }
    
    private long c()
    {
      long l2 = 0L;
      e locale = this.c.i();
      if (locale.c() != -1) {
        l1 = TimeUnit.SECONDS.toMillis(locale.c());
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
      } while (this.c.a().a().k() != null);
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
      return (this.c.i().c() == -1) && (this.h == null);
    }
    
    public b a()
    {
      b localb2 = b();
      b localb1 = localb2;
      if (localb2.a != null)
      {
        localb1 = localb2;
        if (this.b.f().i()) {
          localb1 = new b(null, null, null);
        }
      }
      return localb1;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\a\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */