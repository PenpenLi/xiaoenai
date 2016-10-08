package com.baidu.location;

class Jni
  implements ax, n
{
  private static int e7 = 14;
  private static int e8;
  private static int e9 = 1024;
  private static int fa;
  private static int fb;
  private static boolean fc = false;
  private static int fd;
  private static int fe;
  private static int ff = 0;
  
  static
  {
    fd = 1;
    fe = 2;
    fa = 11;
    fb = 12;
    e8 = 13;
    try
    {
      System.loadLibrary("locSDK4d");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
      fc = true;
      throw new IllegalStateException("no found the liblocSDK4d.so file, please correct settings");
    }
  }
  
  private static native String a(byte[] paramArrayOfByte, int paramInt);
  
  private static native String b(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2);
  
  private static native String c(byte[] paramArrayOfByte, int paramInt);
  
  private static native void f(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  private static native String g(byte[] paramArrayOfByte);
  
  public static String i(String paramString)
  {
    if (fc) {
      return "err!";
    }
    return l(paramString) + "|tp=3";
  }
  
  public static double[] jdMethod_if(double paramDouble1, double paramDouble2, String paramString)
  {
    double[] arrayOfDouble = new double[2];
    double[] tmp7_5 = arrayOfDouble;
    tmp7_5[0] = 0.0D;
    double[] tmp11_7 = tmp7_5;
    tmp11_7[1] = 0.0D;
    tmp11_7;
    if (fc) {
      return tmp7_5;
    }
    int i = -1;
    if (paramString.equals("bd09")) {
      i = ff;
    }
    try
    {
      for (;;)
      {
        paramString = b(paramDouble1, paramDouble2, i, 132456).split(":");
        tmp7_5[0] = Double.parseDouble(paramString[0]);
        tmp7_5[1] = Double.parseDouble(paramString[1]);
        return tmp7_5;
        if (paramString.equals("bd09ll")) {
          i = fd;
        } else if (paramString.equals("gcj02")) {
          i = fe;
        } else if (paramString.equals("gps2gcj")) {
          i = fa;
        } else if (paramString.equals("bd092gcj")) {
          i = fb;
        } else if (paramString.equals("bd09ll2gcj")) {
          i = e8;
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
  }
  
  public static void jdMethod_int(String paramString1, String paramString2)
  {
    try
    {
      f(paramString1.getBytes(), paramString2.getBytes());
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public static String j(String paramString)
  {
    if (fc) {
      return "err!";
    }
    return c(paramString.getBytes(), 132456);
  }
  
  public static String k(String paramString)
  {
    try
    {
      paramString = g(paramString.getBytes());
      if (paramString == null) {}
      while ((paramString.length() < 2) || ("no".equals(paramString))) {
        return null;
      }
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static String l(String paramString)
  {
    int i = 740;
    int j = 0;
    if (fc) {
      return "err!";
    }
    paramString = paramString.getBytes();
    byte[] arrayOfByte = new byte[e9];
    int k = paramString.length;
    if (k > 740) {}
    for (;;)
    {
      int m;
      for (k = 0; j < i; k = m)
      {
        m = k;
        if (paramString[j] != 0)
        {
          arrayOfByte[k] = paramString[j];
          m = k + 1;
        }
        j += 1;
      }
      return a(arrayOfByte, 132456);
      i = k;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\Jni.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */