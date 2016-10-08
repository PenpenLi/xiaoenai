package com.bumptech.glide.d.b.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

class a
  implements g
{
  private final b a = new b();
  private final e<a, Bitmap> b = new e();
  
  private static String d(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return "[" + paramInt1 + "x" + paramInt2 + "], " + paramConfig;
  }
  
  private static String d(Bitmap paramBitmap)
  {
    return d(paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getConfig());
  }
  
  public Bitmap a()
  {
    return (Bitmap)this.b.a();
  }
  
  public Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    paramConfig = this.a.a(paramInt1, paramInt2, paramConfig);
    return (Bitmap)this.b.a(paramConfig);
  }
  
  public void a(Bitmap paramBitmap)
  {
    a locala = this.a.a(paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getConfig());
    this.b.a(locala, paramBitmap);
  }
  
  public String b(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return d(paramInt1, paramInt2, paramConfig);
  }
  
  public String b(Bitmap paramBitmap)
  {
    return d(paramBitmap);
  }
  
  public int c(Bitmap paramBitmap)
  {
    return com.bumptech.glide.i.h.a(paramBitmap);
  }
  
  public String toString()
  {
    return "AttributeStrategy:\n  " + this.b;
  }
  
  static class a
    implements h
  {
    private final a.b a;
    private int b;
    private int c;
    private Bitmap.Config d;
    
    public a(a.b paramb)
    {
      this.a = paramb;
    }
    
    public void a()
    {
      this.a.a(this);
    }
    
    public void a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
    {
      this.b = paramInt1;
      this.c = paramInt2;
      this.d = paramConfig;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        bool1 = bool2;
        if (this.b == ((a)paramObject).b)
        {
          bool1 = bool2;
          if (this.c == ((a)paramObject).c)
          {
            bool1 = bool2;
            if (this.d == ((a)paramObject).d) {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
    
    public int hashCode()
    {
      int j = this.b;
      int k = this.c;
      if (this.d != null) {}
      for (int i = this.d.hashCode();; i = 0) {
        return i + (j * 31 + k) * 31;
      }
    }
    
    public String toString()
    {
      return a.c(this.b, this.c, this.d);
    }
  }
  
  static class b
    extends b<a.a>
  {
    protected a.a a()
    {
      return new a.a(this);
    }
    
    public a.a a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
    {
      a.a locala = (a.a)c();
      locala.a(paramInt1, paramInt2, paramConfig);
      return locala;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\b\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */