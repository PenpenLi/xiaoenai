package com.bumptech.glide.d.b.d;

import android.graphics.Bitmap.Config;

public final class d
{
  static final Bitmap.Config a = Bitmap.Config.RGB_565;
  private final int b;
  private final int c;
  private final Bitmap.Config d;
  private final int e;
  
  d(int paramInt1, int paramInt2, Bitmap.Config paramConfig, int paramInt3)
  {
    if (paramConfig == null) {
      throw new NullPointerException("Config must not be null");
    }
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramConfig;
    this.e = paramInt3;
  }
  
  int a()
  {
    return this.b;
  }
  
  int b()
  {
    return this.c;
  }
  
  Bitmap.Config c()
  {
    return this.d;
  }
  
  int d()
  {
    return this.e;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof d))
    {
      paramObject = (d)paramObject;
      bool1 = bool2;
      if (this.c == ((d)paramObject).c)
      {
        bool1 = bool2;
        if (this.b == ((d)paramObject).b)
        {
          bool1 = bool2;
          if (this.e == ((d)paramObject).e)
          {
            bool1 = bool2;
            if (this.d == ((d)paramObject).d) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return ((this.b * 31 + this.c) * 31 + this.d.hashCode()) * 31 + this.e;
  }
  
  public String toString()
  {
    return "PreFillSize{width=" + this.b + ", height=" + this.c + ", config=" + this.d + ", weight=" + this.e + '}';
  }
  
  public static class a
  {
    private final int a;
    private final int b;
    private Bitmap.Config c;
    private int d;
    
    Bitmap.Config a()
    {
      return this.c;
    }
    
    public a a(Bitmap.Config paramConfig)
    {
      this.c = paramConfig;
      return this;
    }
    
    d b()
    {
      return new d(this.a, this.b, this.c, this.d);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\b\d\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */