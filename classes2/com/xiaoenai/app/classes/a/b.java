package com.xiaoenai.app.classes.a;

public class b
{
  public static boolean a(double paramDouble)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (-180.0D < paramDouble)
    {
      bool1 = bool2;
      if (paramDouble < 180.0D)
      {
        bool1 = bool2;
        if (paramDouble != Double.MIN_VALUE) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(double paramDouble1, double paramDouble2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramDouble1 == 1.0D)
    {
      bool1 = bool2;
      if (paramDouble2 == 1.0D) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */