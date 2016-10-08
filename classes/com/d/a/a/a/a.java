package com.d.a.a.a;

import com.d.a.a.e;
import com.d.a.a.j;
import java.util.Collection;

public class a
  implements j
{
  j a;
  private a b;
  
  public a(j paramj)
  {
    this.a = paramj;
    this.b = new a(null);
  }
  
  public int a()
  {
    if (this.b.a == null) {
      this.b.a = Integer.valueOf(this.a.a());
    }
    return this.b.a.intValue();
  }
  
  public int a(boolean paramBoolean, Collection<String> paramCollection)
  {
    int i;
    if ((this.b.a != null) && (this.b.a.intValue() < 1)) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      j = this.a.a(paramBoolean, paramCollection);
      i = j;
    } while (j != 0);
    a();
    return j;
  }
  
  public long a(e parame)
  {
    this.b.a();
    return this.a.a(parame);
  }
  
  public Long a(boolean paramBoolean)
  {
    if (this.b.b == null) {
      this.b.b = new a.a.a(paramBoolean, this.a.a(paramBoolean), null);
    }
    for (;;)
    {
      return this.b.b.a;
      if (!a.a.a.a(this.b.b, paramBoolean)) {
        this.b.b.a(paramBoolean, this.a.a(paramBoolean));
      }
    }
  }
  
  public long b(e parame)
  {
    this.b.a();
    return this.a.b(parame);
  }
  
  public e b(boolean paramBoolean, Collection<String> paramCollection)
  {
    if ((this.b.a != null) && (this.b.a.intValue() < 1)) {
      paramCollection = null;
    }
    e locale;
    do
    {
      return paramCollection;
      locale = this.a.b(paramBoolean, paramCollection);
      if (locale == null)
      {
        a();
        return locale;
      }
      paramCollection = locale;
    } while (this.b.a == null);
    paramCollection = this.b;
    Integer localInteger = paramCollection.a;
    paramCollection.a = Integer.valueOf(paramCollection.a.intValue() - 1);
    return locale;
  }
  
  public void c(e parame)
  {
    this.b.a();
    this.a.c(parame);
  }
  
  private static class a
  {
    Integer a;
    a b;
    
    public void a()
    {
      this.a = null;
      this.b = null;
    }
    
    private static class a
    {
      Long a;
      boolean b;
      
      private a(boolean paramBoolean, Long paramLong)
      {
        this.a = paramLong;
        this.b = paramBoolean;
      }
      
      private boolean a(boolean paramBoolean)
      {
        return this.b == paramBoolean;
      }
      
      public void a(boolean paramBoolean, Long paramLong)
      {
        this.a = paramLong;
        this.b = paramBoolean;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\d\a\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */