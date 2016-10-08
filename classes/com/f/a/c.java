package com.f.a;

import android.content.Context;
import d.a.ab;
import d.a.av;
import d.a.x;

public class c
{
  public static boolean a(int paramInt)
  {
    switch (paramInt)
    {
    case 7: 
    default: 
      return false;
    }
    return true;
  }
  
  public static class a
    extends c.h
  {
    private final long a = 15000L;
    private x b;
    
    public a(x paramx)
    {
      this.b = paramx;
    }
    
    public boolean a(boolean paramBoolean)
    {
      return System.currentTimeMillis() - this.b.c >= 15000L;
    }
  }
  
  public static class b
    extends c.h
  {
    private ab a;
    private x b;
    
    public b(x paramx, ab paramab)
    {
      this.b = paramx;
      this.a = paramab;
    }
    
    public boolean a()
    {
      return this.a.b();
    }
    
    public boolean a(boolean paramBoolean)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.a.a();
      return l1 - this.b.c >= l2;
    }
  }
  
  public static class c
    extends c.h
  {
    private long a;
    private long b = 0L;
    
    public c(int paramInt)
    {
      this.a = paramInt;
      this.b = System.currentTimeMillis();
    }
    
    public boolean a()
    {
      return System.currentTimeMillis() - this.b < this.a;
    }
    
    public boolean a(boolean paramBoolean)
    {
      return System.currentTimeMillis() - this.b >= this.a;
    }
  }
  
  public static class d
    extends c.h
  {
    public boolean a(boolean paramBoolean)
    {
      return paramBoolean;
    }
  }
  
  public static class e
    extends c.h
  {
    private static long a = 90000L;
    private static long b = 86400000L;
    private long c;
    private x d;
    
    public e(x paramx, long paramLong)
    {
      this.d = paramx;
      a(paramLong);
    }
    
    public void a(long paramLong)
    {
      if ((paramLong >= a) && (paramLong <= b))
      {
        this.c = paramLong;
        return;
      }
      this.c = a;
    }
    
    public boolean a(boolean paramBoolean)
    {
      return System.currentTimeMillis() - this.d.c >= this.c;
    }
  }
  
  public static class f
    extends c.h
  {
    private long a = 86400000L;
    private x b;
    
    public f(x paramx)
    {
      this.b = paramx;
    }
    
    public boolean a(boolean paramBoolean)
    {
      return System.currentTimeMillis() - this.b.c >= this.a;
    }
  }
  
  public static class g
    extends c.h
  {
    public boolean a(boolean paramBoolean)
    {
      return true;
    }
  }
  
  public static class h
  {
    public boolean a()
    {
      return true;
    }
    
    public boolean a(boolean paramBoolean)
    {
      return true;
    }
  }
  
  public static class i
    extends c.h
  {
    private Context a = null;
    
    public i(Context paramContext)
    {
      this.a = paramContext;
    }
    
    public boolean a(boolean paramBoolean)
    {
      return av.i(this.a);
    }
  }
  
  public static class j
    extends c.h
  {
    private final long a = 10800000L;
    private x b;
    
    public j(x paramx)
    {
      this.b = paramx;
    }
    
    public boolean a(boolean paramBoolean)
    {
      return System.currentTimeMillis() - this.b.c >= 10800000L;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\f\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */