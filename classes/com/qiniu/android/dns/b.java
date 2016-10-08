package com.qiniu.android.dns;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
{
  private final d[] a;
  private final com.qiniu.android.dns.c.b<String, h[]> b;
  private final com.qiniu.android.dns.b.f c = new com.qiniu.android.dns.b.f();
  private final e d;
  private volatile g e = null;
  private volatile int f = 0;
  
  public b(g paramg, d[] paramArrayOfd)
  {
    this(paramg, paramArrayOfd, null);
  }
  
  public b(g paramg, d[] paramArrayOfd, e parame)
  {
    g localg = paramg;
    if (paramg == null) {
      localg = g.b;
    }
    this.e = localg;
    this.a = ((d[])paramArrayOfd.clone());
    this.b = new com.qiniu.android.dns.c.b();
    paramg = parame;
    if (parame == null) {
      paramg = new a(null);
    }
    this.d = paramg;
  }
  
  private void a()
  {
    synchronized (this.b)
    {
      this.b.a();
      return;
    }
  }
  
  private static h[] a(h[] paramArrayOfh)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfh.length);
    int j = paramArrayOfh.length;
    int i = 0;
    while (i < j)
    {
      h localh = paramArrayOfh[i];
      if ((localh != null) && (localh.b == 1)) {
        localArrayList.add(localh);
      }
      i += 1;
    }
    return (h[])localArrayList.toArray(new h[localArrayList.size()]);
  }
  
  private String[] b(c paramc)
  {
    if (paramc.d)
    {
      ??? = this.c.a(paramc, this.e);
      if ((??? == null) || (???.length == 0)) {}
    }
    for (;;)
    {
      return (String[])???;
      label82:
      int j;
      h[] arrayOfh;
      int i;
      label96:
      Object localObject4;
      int k;
      g localg;
      String str1;
      synchronized (this.b)
      {
        if ((this.e.equals(g.b)) && (f.b()))
        {
          this.b.a();
          synchronized (this.a)
          {
            this.f = 0;
            ??? = null;
            j = this.f;
            arrayOfh = null;
            i = 0;
            ??? = arrayOfh;
            localObject4 = ???;
            if (i < this.a.length)
            {
              k = this.a.length;
              localg = this.e;
              str1 = f.a();
            }
          }
        }
      }
      try
      {
        ??? = this.a[((j + i) % k)].a(paramc, this.e);
        ??? = ???;
        String str2 = f.a();
        ??? = arrayOfh;
        localObject4 = ???;
        if (this.e == localg) {
          if (??? != null)
          {
            ??? = arrayOfh;
            localObject4 = ???;
            if (???.length != 0) {}
          }
          else
          {
            ??? = arrayOfh;
            localObject4 = ???;
            if (!str1.equals(str2)) {}
          }
        }
      }
      catch (IOException localIOException)
      {
        synchronized (this.a)
        {
          if (this.f == j)
          {
            this.f += 1;
            if (this.f == this.a.length) {
              this.f = 0;
            }
          }
          i += 1;
          break label96;
          paramc = finally;
          throw paramc;
          paramc = finally;
          throw paramc;
          arrayOfh = (h[])this.b.a(paramc.a);
          ??? = arrayOfh;
          if (arrayOfh == null) {
            break label82;
          }
          ??? = arrayOfh;
          if (arrayOfh.length == 0) {
            break label82;
          }
          ??? = arrayOfh;
          if (arrayOfh[0].b()) {
            break label82;
          }
          paramc = b(arrayOfh);
          return paramc;
          localIOException = localIOException;
          localIOException.printStackTrace();
        }
        if ((localObject4 == null) || (localObject4.length == 0))
        {
          if (!paramc.d)
          {
            localObject2 = this.c.a(paramc, this.e);
            if (localObject2 != null)
            {
              ??? = localObject2;
              if (localObject2.length != 0) {
                continue;
              }
            }
          }
          if (??? != null) {
            throw ((Throwable)???);
          }
          throw new UnknownHostException(paramc.a);
        }
        Object localObject2 = a((h[])localObject4);
        if (localObject2.length == 0) {
          throw new UnknownHostException("no A records");
        }
        synchronized (this.b)
        {
          this.b.a(paramc.a, localObject2);
          return b((h[])localObject2);
        }
      }
      catch (com.qiniu.android.dns.a.b localb)
      {
        for (;;) {}
      }
    }
  }
  
  private static String[] b(h[] paramArrayOfh)
  {
    if ((paramArrayOfh == null) || (paramArrayOfh.length == 0)) {}
    ArrayList localArrayList;
    do
    {
      return null;
      localArrayList = new ArrayList(paramArrayOfh.length);
      int j = paramArrayOfh.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(paramArrayOfh[i].a);
        i += 1;
      }
    } while (localArrayList.size() == 0);
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public void a(g arg1)
  {
    a();
    g localg = ???;
    if (??? == null) {
      localg = g.b;
    }
    this.e = localg;
    synchronized (this.a)
    {
      this.f = 0;
      return;
    }
  }
  
  public String[] a(c paramc)
  {
    paramc = b(paramc);
    if ((paramc == null) || (paramc.length <= 1)) {
      return paramc;
    }
    return this.d.a(paramc);
  }
  
  public String[] a(String paramString)
  {
    return a(new c(paramString));
  }
  
  private static class a
    implements e
  {
    private AtomicInteger a = new AtomicInteger();
    
    public String[] a(String[] paramArrayOfString)
    {
      if ((paramArrayOfString == null) || (paramArrayOfString.length <= 1)) {
        return paramArrayOfString;
      }
      int j = this.a.getAndIncrement();
      String[] arrayOfString = new String[paramArrayOfString.length];
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        arrayOfString[i] = paramArrayOfString[((i + (j & 0xFF)) % paramArrayOfString.length)];
        i += 1;
      }
      return arrayOfString;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\qiniu\android\dns\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */