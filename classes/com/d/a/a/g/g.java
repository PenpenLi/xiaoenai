package com.d.a.a.g;

import com.d.a.a.j;
import java.util.Collection;
import java.util.Comparator;

public class g
  implements j
{
  public final Comparator<com.d.a.a.e> a = new h(this);
  private long b = -2147483648L;
  private e c;
  private final String d;
  private final long e;
  
  public g(long paramLong, String paramString)
  {
    this.d = paramString;
    this.e = paramLong;
    this.c = new e(5, this.a);
  }
  
  private static int b(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return -1;
    }
    if (paramInt2 > paramInt1) {
      return 1;
    }
    return 0;
  }
  
  private static int b(long paramLong1, long paramLong2)
  {
    if (paramLong1 > paramLong2) {
      return -1;
    }
    if (paramLong2 > paramLong1) {
      return 1;
    }
    return 0;
  }
  
  public int a()
  {
    return this.c.a();
  }
  
  public int a(boolean paramBoolean, Collection<String> paramCollection)
  {
    return this.c.b(paramBoolean, paramCollection).a();
  }
  
  public long a(com.d.a.a.e parame)
  {
    try
    {
      this.b += 1L;
      parame.a(Long.valueOf(this.b));
      this.c.a(parame);
      long l = parame.a().longValue();
      return l;
    }
    finally
    {
      parame = finally;
      throw parame;
    }
  }
  
  public Long a(boolean paramBoolean)
  {
    com.d.a.a.e locale = this.c.a(paramBoolean, null);
    if (locale == null) {
      return null;
    }
    return Long.valueOf(locale.g());
  }
  
  public long b(com.d.a.a.e parame)
  {
    c(parame);
    parame.a(Long.MIN_VALUE);
    this.c.a(parame);
    return parame.a().longValue();
  }
  
  public com.d.a.a.e b(boolean paramBoolean, Collection<String> paramCollection)
  {
    com.d.a.a.e locale = this.c.a(paramBoolean, paramCollection);
    paramCollection = locale;
    if (locale != null)
    {
      if (locale.g() > System.nanoTime()) {
        paramCollection = null;
      }
    }
    else {
      return paramCollection;
    }
    locale.a(this.e);
    locale.b(locale.d() + 1);
    this.c.b(locale);
    return locale;
  }
  
  public void c(com.d.a.a.e parame)
  {
    this.c.b(parame);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\d\a\a\g\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */