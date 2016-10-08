package com.f.a;

import android.content.Context;
import d.a.ax;

public class b
{
  private static final g a = new g();
  
  public static void a(long paramLong)
  {
    a.a(paramLong);
  }
  
  public static void a(Context paramContext)
  {
    a.b(paramContext);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    a.a(paramContext, paramString);
  }
  
  public static void a(b paramb)
  {
    if (paramb != null) {
      a.a(paramb);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    a.c(paramBoolean);
  }
  
  public static void b(Context paramContext)
  {
    if (paramContext == null)
    {
      ax.d("unexpected null context in onResume");
      return;
    }
    a.a(paramContext);
  }
  
  public static void b(Context paramContext, String paramString)
  {
    a.a(paramContext, paramString, null, -1L, 1);
  }
  
  public static void b(boolean paramBoolean)
  {
    a.a(paramBoolean);
  }
  
  public static void c(Context paramContext)
  {
    a.c(paramContext);
  }
  
  public static void c(boolean paramBoolean)
  {
    a.b(paramBoolean);
  }
  
  public static enum a
  {
    private int e;
    
    private a(int paramInt)
    {
      this.e = paramInt;
    }
    
    public int a()
    {
      return this.e;
    }
  }
  
  public static class b
  {
    public String a = null;
    public String b = null;
    public boolean c = true;
    public b.a d = b.a.a;
    public Context e = null;
    
    private b() {}
    
    public b(Context paramContext, String paramString1, String paramString2)
    {
      this(paramContext, paramString1, paramString2, null, true);
    }
    
    public b(Context paramContext, String paramString1, String paramString2, b.a parama, boolean paramBoolean)
    {
      this.e = paramContext;
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramBoolean;
      if (parama != null)
      {
        this.d = parama;
        return;
      }
      switch (a.d(paramContext))
      {
      default: 
        return;
      case 0: 
        this.d = b.a.a;
        return;
      case 1: 
        this.d = b.a.b;
        return;
      case 224: 
        this.d = b.a.c;
        return;
      }
      this.d = b.a.d;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\f\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */