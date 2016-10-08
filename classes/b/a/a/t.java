package b.a.a;

import c.e;
import c.h;
import c.i;
import c.p;
import c.z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class t
{
  private static final r[] a = { new r(r.e, ""), new r(r.b, "GET"), new r(r.b, "POST"), new r(r.c, "/"), new r(r.c, "/index.html"), new r(r.d, "http"), new r(r.d, "https"), new r(r.a, "200"), new r(r.a, "204"), new r(r.a, "206"), new r(r.a, "304"), new r(r.a, "400"), new r(r.a, "404"), new r(r.a, "500"), new r("accept-charset", ""), new r("accept-encoding", "gzip, deflate"), new r("accept-language", ""), new r("accept-ranges", ""), new r("accept", ""), new r("access-control-allow-origin", ""), new r("age", ""), new r("allow", ""), new r("authorization", ""), new r("cache-control", ""), new r("content-disposition", ""), new r("content-encoding", ""), new r("content-language", ""), new r("content-length", ""), new r("content-location", ""), new r("content-range", ""), new r("content-type", ""), new r("cookie", ""), new r("date", ""), new r("etag", ""), new r("expect", ""), new r("expires", ""), new r("from", ""), new r("host", ""), new r("if-match", ""), new r("if-modified-since", ""), new r("if-none-match", ""), new r("if-range", ""), new r("if-unmodified-since", ""), new r("last-modified", ""), new r("link", ""), new r("location", ""), new r("max-forwards", ""), new r("proxy-authenticate", ""), new r("proxy-authorization", ""), new r("range", ""), new r("referer", ""), new r("refresh", ""), new r("retry-after", ""), new r("server", ""), new r("set-cookie", ""), new r("strict-transport-security", ""), new r("transfer-encoding", ""), new r("user-agent", ""), new r("vary", ""), new r("via", ""), new r("www-authenticate", "") };
  private static final Map<i, Integer> b = c();
  
  private static i b(i parami)
  {
    int i = 0;
    int j = parami.f();
    while (i < j)
    {
      int k = parami.a(i);
      if ((k >= 65) && (k <= 90)) {
        throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + parami.a());
      }
      i += 1;
    }
    return parami;
  }
  
  private static Map<i, Integer> c()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(a.length);
    int i = 0;
    while (i < a.length)
    {
      if (!localLinkedHashMap.containsKey(a[i].h)) {
        localLinkedHashMap.put(a[i].h, Integer.valueOf(i));
      }
      i += 1;
    }
    return Collections.unmodifiableMap(localLinkedHashMap);
  }
  
  static final class a
  {
    r[] a = new r[8];
    int b = this.a.length - 1;
    int c = 0;
    int d = 0;
    private final List<r> e = new ArrayList();
    private final h f;
    private int g;
    private int h;
    
    a(int paramInt, z paramz)
    {
      this.g = paramInt;
      this.h = paramInt;
      this.f = p.a(paramz);
    }
    
    private void a(int paramInt, r paramr)
    {
      this.e.add(paramr);
      int j = paramr.j;
      int i = j;
      if (paramInt != -1) {
        i = j - this.a[d(paramInt)].j;
      }
      if (i > this.h)
      {
        e();
        return;
      }
      j = b(this.d + i - this.h);
      if (paramInt == -1)
      {
        if (this.c + 1 > this.a.length)
        {
          r[] arrayOfr = new r[this.a.length * 2];
          System.arraycopy(this.a, 0, arrayOfr, this.a.length, this.a.length);
          this.b = (this.a.length - 1);
          this.a = arrayOfr;
        }
        paramInt = this.b;
        this.b = (paramInt - 1);
        this.a[paramInt] = paramr;
        this.c += 1;
      }
      for (;;)
      {
        this.d = (i + this.d);
        return;
        int k = d(paramInt);
        this.a[(j + k + paramInt)] = paramr;
      }
    }
    
    private int b(int paramInt)
    {
      int i = 0;
      int k = 0;
      if (paramInt > 0)
      {
        i = this.a.length - 1;
        int j = paramInt;
        paramInt = k;
        while ((i >= this.b) && (j > 0))
        {
          j -= this.a[i].j;
          this.d -= this.a[i].j;
          this.c -= 1;
          paramInt += 1;
          i -= 1;
        }
        System.arraycopy(this.a, this.b + 1, this.a, this.b + 1 + paramInt, this.c);
        this.b += paramInt;
        i = paramInt;
      }
      return i;
    }
    
    private void c(int paramInt)
    {
      if (h(paramInt))
      {
        r localr = t.a()[paramInt];
        this.e.add(localr);
        return;
      }
      int i = d(paramInt - t.a().length);
      if ((i < 0) || (i > this.a.length - 1)) {
        throw new IOException("Header index too large " + (paramInt + 1));
      }
      this.e.add(this.a[i]);
    }
    
    private int d(int paramInt)
    {
      return this.b + 1 + paramInt;
    }
    
    private void d()
    {
      if (this.h < this.d)
      {
        if (this.h == 0) {
          e();
        }
      }
      else {
        return;
      }
      b(this.d - this.h);
    }
    
    private void e()
    {
      this.e.clear();
      Arrays.fill(this.a, null);
      this.b = (this.a.length - 1);
      this.c = 0;
      this.d = 0;
    }
    
    private void e(int paramInt)
    {
      i locali1 = g(paramInt);
      i locali2 = c();
      this.e.add(new r(locali1, locali2));
    }
    
    private void f()
    {
      i locali1 = t.a(c());
      i locali2 = c();
      this.e.add(new r(locali1, locali2));
    }
    
    private void f(int paramInt)
    {
      a(-1, new r(g(paramInt), c()));
    }
    
    private i g(int paramInt)
    {
      if (h(paramInt)) {
        return t.a()[paramInt].h;
      }
      return this.a[d(paramInt - t.a().length)].h;
    }
    
    private void g()
    {
      a(-1, new r(t.a(c()), c()));
    }
    
    private int h()
    {
      return this.f.i() & 0xFF;
    }
    
    private boolean h(int paramInt)
    {
      return (paramInt >= 0) && (paramInt <= t.a().length - 1);
    }
    
    int a(int paramInt1, int paramInt2)
    {
      paramInt1 &= paramInt2;
      if (paramInt1 < paramInt2) {
        return paramInt1;
      }
      paramInt1 = 0;
      int i;
      for (;;)
      {
        i = h();
        if ((i & 0x80) == 0) {
          break;
        }
        paramInt2 += ((i & 0x7F) << paramInt1);
        paramInt1 += 7;
      }
      return (i << paramInt1) + paramInt2;
    }
    
    void a()
    {
      while (!this.f.f())
      {
        int i = this.f.i() & 0xFF;
        if (i == 128) {
          throw new IOException("index == 0");
        }
        if ((i & 0x80) == 128)
        {
          c(a(i, 127) - 1);
        }
        else if (i == 64)
        {
          g();
        }
        else if ((i & 0x40) == 64)
        {
          f(a(i, 63) - 1);
        }
        else if ((i & 0x20) == 32)
        {
          this.h = a(i, 31);
          if ((this.h < 0) || (this.h > this.g)) {
            throw new IOException("Invalid dynamic table size update " + this.h);
          }
          d();
        }
        else if ((i == 16) || (i == 0))
        {
          f();
        }
        else
        {
          e(a(i, 15) - 1);
        }
      }
    }
    
    void a(int paramInt)
    {
      this.g = paramInt;
      this.h = paramInt;
      d();
    }
    
    public List<r> b()
    {
      ArrayList localArrayList = new ArrayList(this.e);
      this.e.clear();
      return localArrayList;
    }
    
    i c()
    {
      int j = h();
      if ((j & 0x80) == 128) {}
      for (int i = 1;; i = 0)
      {
        j = a(j, 127);
        if (i == 0) {
          break;
        }
        return i.a(v.a().a(this.f.f(j)));
      }
      return this.f.c(j);
    }
  }
  
  static final class b
  {
    private final e a;
    
    b(e parame)
    {
      this.a = parame;
    }
    
    void a(int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramInt1 < paramInt2)
      {
        this.a.b(paramInt3 | paramInt1);
        return;
      }
      this.a.b(paramInt3 | paramInt2);
      paramInt1 -= paramInt2;
      while (paramInt1 >= 128)
      {
        this.a.b(paramInt1 & 0x7F | 0x80);
        paramInt1 >>>= 7;
      }
      this.a.b(paramInt1);
    }
    
    void a(i parami)
    {
      a(parami.f(), 127, 0);
      this.a.a(parami);
    }
    
    void a(List<r> paramList)
    {
      int j = paramList.size();
      int i = 0;
      if (i < j)
      {
        i locali = ((r)paramList.get(i)).h.e();
        Integer localInteger = (Integer)t.b().get(locali);
        if (localInteger != null)
        {
          a(localInteger.intValue() + 1, 15, 0);
          a(((r)paramList.get(i)).i);
        }
        for (;;)
        {
          i += 1;
          break;
          this.a.b(0);
          a(locali);
          a(((r)paramList.get(i)).i);
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\a\a\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */