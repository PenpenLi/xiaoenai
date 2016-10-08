package com.adhoc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class cv
{
  private static final ct[] a = { new ct(ct.e, ""), new ct(ct.b, "GET"), new ct(ct.b, "POST"), new ct(ct.c, "/"), new ct(ct.c, "/index.html"), new ct(ct.d, "http"), new ct(ct.d, "https"), new ct(ct.a, "200"), new ct(ct.a, "204"), new ct(ct.a, "206"), new ct(ct.a, "304"), new ct(ct.a, "400"), new ct(ct.a, "404"), new ct(ct.a, "500"), new ct("accept-charset", ""), new ct("accept-encoding", "gzip, deflate"), new ct("accept-language", ""), new ct("accept-ranges", ""), new ct("accept", ""), new ct("access-control-allow-origin", ""), new ct("age", ""), new ct("allow", ""), new ct("authorization", ""), new ct("cache-control", ""), new ct("content-disposition", ""), new ct("content-encoding", ""), new ct("content-language", ""), new ct("content-length", ""), new ct("content-location", ""), new ct("content-range", ""), new ct("content-type", ""), new ct("cookie", ""), new ct("date", ""), new ct("etag", ""), new ct("expect", ""), new ct("expires", ""), new ct("from", ""), new ct("host", ""), new ct("if-match", ""), new ct("if-modified-since", ""), new ct("if-none-match", ""), new ct("if-range", ""), new ct("if-unmodified-since", ""), new ct("last-modified", ""), new ct("link", ""), new ct("location", ""), new ct("max-forwards", ""), new ct("proxy-authenticate", ""), new ct("proxy-authorization", ""), new ct("range", ""), new ct("referer", ""), new ct("refresh", ""), new ct("retry-after", ""), new ct("server", ""), new ct("set-cookie", ""), new ct("strict-transport-security", ""), new ct("transfer-encoding", ""), new ct("user-agent", ""), new ct("vary", ""), new ct("via", ""), new ct("www-authenticate", "") };
  private static final Map<er, Integer> b = c();
  
  private static er b(er paramer)
  {
    int i = 0;
    int j = paramer.f();
    while (i < j)
    {
      int k = paramer.a(i);
      if ((k >= 65) && (k <= 90)) {
        throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + paramer.a());
      }
      i += 1;
    }
    return paramer;
  }
  
  private static Map<er, Integer> c()
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
    ct[] a = new ct[8];
    int b = this.a.length - 1;
    int c = 0;
    int d = 0;
    private final List<ct> e = new ArrayList();
    private final eq f;
    private int g;
    private int h;
    
    a(int paramInt, fg paramfg)
    {
      this.g = paramInt;
      this.h = paramInt;
      this.f = ex.a(paramfg);
    }
    
    private void a(int paramInt, ct paramct)
    {
      this.e.add(paramct);
      int j = paramct.j;
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
          ct[] arrayOfct = new ct[this.a.length * 2];
          System.arraycopy(this.a, 0, arrayOfct, this.a.length, this.a.length);
          this.b = (this.a.length - 1);
          this.a = arrayOfct;
        }
        paramInt = this.b;
        this.b = (paramInt - 1);
        this.a[paramInt] = paramct;
        this.c += 1;
      }
      for (;;)
      {
        this.d = (i + this.d);
        return;
        int k = d(paramInt);
        this.a[(j + k + paramInt)] = paramct;
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
        ct localct = cv.a()[paramInt];
        this.e.add(localct);
        return;
      }
      int i = d(paramInt - cv.a().length);
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
      er localer1 = g(paramInt);
      er localer2 = c();
      this.e.add(new ct(localer1, localer2));
    }
    
    private void f()
    {
      er localer1 = cv.a(c());
      er localer2 = c();
      this.e.add(new ct(localer1, localer2));
    }
    
    private void f(int paramInt)
    {
      a(-1, new ct(g(paramInt), c()));
    }
    
    private er g(int paramInt)
    {
      if (h(paramInt)) {
        return cv.a()[paramInt].h;
      }
      return this.a[d(paramInt - cv.a().length)].h;
    }
    
    private void g()
    {
      a(-1, new ct(cv.a(c()), c()));
    }
    
    private int h()
    {
      return this.f.h() & 0xFF;
    }
    
    private boolean h(int paramInt)
    {
      return (paramInt >= 0) && (paramInt <= cv.a().length - 1);
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
        int i = this.f.h() & 0xFF;
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
    
    public List<ct> b()
    {
      ArrayList localArrayList = new ArrayList(this.e);
      this.e.clear();
      return localArrayList;
    }
    
    er c()
    {
      int j = h();
      if ((j & 0x80) == 128) {}
      for (int i = 1;; i = 0)
      {
        j = a(j, 127);
        if (i == 0) {
          break;
        }
        return er.a(cx.a().a(this.f.f(j)));
      }
      return this.f.c(j);
    }
  }
  
  static final class b
  {
    private final eo a;
    
    b(eo parameo)
    {
      this.a = parameo;
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
    
    void a(er paramer)
    {
      a(paramer.f(), 127, 0);
      this.a.a(paramer);
    }
    
    void a(List<ct> paramList)
    {
      int j = paramList.size();
      int i = 0;
      if (i < j)
      {
        er localer = ((ct)paramList.get(i)).h.e();
        Integer localInteger = (Integer)cv.b().get(localer);
        if (localInteger != null)
        {
          a(localInteger.intValue() + 1, 15, 0);
          a(((ct)paramList.get(i)).i);
        }
        for (;;)
        {
          i += 1;
          break;
          this.a.b(0);
          a(localer);
          a(((ct)paramList.get(i)).i);
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\cv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */