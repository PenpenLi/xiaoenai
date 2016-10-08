package com.inmobi.ads;

import android.graphics.Point;
import android.support.annotation.NonNull;
import java.util.Locale;

class t
{
  protected b a;
  protected a b;
  protected float c;
  protected String d;
  protected String e;
  private Point f;
  private Point g;
  
  t()
  {
    this.f = new Point(0, 0);
    this.g = new Point(0, 0);
    this.a = b.a;
    this.b = a.b;
    this.c = 10.0F;
    this.d = "#ff000000";
    this.e = "#00000000";
  }
  
  public t(int paramInt1, int paramInt2, int paramInt3, int paramInt4, @NonNull b paramb, @NonNull a parama, @NonNull String paramString1, @NonNull String paramString2)
  {
    this.f = new Point(paramInt3, paramInt4);
    this.g = new Point(paramInt1, paramInt2);
    this.a = paramb;
    this.b = parama;
    this.c = 10.0F;
    paramb = paramString1;
    if (paramString1.length() == 0) {
      paramb = "#ff000000";
    }
    this.d = paramb;
    paramb = paramString2;
    if (paramString2.length() == 0) {
      paramb = "#00000000";
    }
    this.e = paramb;
  }
  
  public Point a()
  {
    return this.f;
  }
  
  public Point b()
  {
    return this.g;
  }
  
  public b c()
  {
    return this.a;
  }
  
  public a d()
  {
    return this.b;
  }
  
  public float e()
  {
    return this.c;
  }
  
  public String f()
  {
    return this.d.toLowerCase(Locale.US);
  }
  
  public String g()
  {
    return this.e.toLowerCase(Locale.US);
  }
  
  static enum a
  {
    private final String c;
    
    private a(String paramString)
    {
      this.c = paramString;
    }
  }
  
  static enum b
  {
    private final String c;
    
    private b(String paramString)
    {
      this.c = paramString;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */