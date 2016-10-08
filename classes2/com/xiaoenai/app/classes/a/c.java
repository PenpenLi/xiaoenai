package com.xiaoenai.app.classes.a;

import com.baidu.location.BDLocationListener;

public class c
{
  private long a;
  private long b;
  private a c = null;
  private final a d = new a();
  private final BDLocationListener e = new d(this);
  
  public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    paramDouble2 = 3.141592653589793D * paramDouble2 / 180.0D;
    paramDouble4 = 3.141592653589793D * paramDouble4 / 180.0D;
    paramDouble1 = 3.141592653589793D * paramDouble1 / 180.0D;
    paramDouble3 = 3.141592653589793D * paramDouble3 / 180.0D;
    double d1 = Math.pow(Math.sin((paramDouble2 - paramDouble4) / 2.0D), 2.0D);
    return Math.asin(Math.sqrt(Math.cos(paramDouble2) * Math.cos(paramDouble4) * Math.pow(Math.sin((paramDouble1 - paramDouble3) / 2.0D), 2.0D) + d1)) * 2.0D * 6378137.0D;
  }
  
  private void a()
  {
    this.c = null;
  }
  
  public void a(a parama)
  {
    this.d.a();
    this.c = parama;
    this.c.a();
    this.a = System.currentTimeMillis();
    this.d.a(this.e);
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(double paramDouble1, double paramDouble2, float paramFloat);
    
    public abstract void b();
    
    public abstract void c();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */