package com.baidu.location;

import android.text.TextUtils;

public class aq
  implements BDGeofence
{
  private static final String jdField_byte = "Administrative";
  private static final int jdField_case = 2;
  private static final int d = 100;
  private static final int e = 2;
  private static final int jdField_else = 1;
  private static final String jdField_for = "Circle";
  private static final int i = 3;
  public static final int jdField_int = 1;
  private static final long jdField_void = 2592000L;
  private final int a;
  private float b;
  private final int c;
  private boolean jdField_char;
  private final String jdField_do;
  private boolean f;
  protected int g;
  private final double jdField_goto;
  private long h;
  private boolean jdField_if;
  private final long jdField_long;
  private final String jdField_new;
  private final double jdField_try;
  
  public aq(int paramInt1, String paramString1, double paramDouble1, double paramDouble2, int paramInt2, long paramLong, String paramString2)
  {
    jdMethod_do(paramInt2);
    jdMethod_if(paramString1);
    a(paramDouble1, paramDouble2);
    a(paramString2);
    jdMethod_if(paramLong);
    this.c = paramInt1;
    this.jdField_do = paramString1;
    this.jdField_goto = paramDouble1;
    this.jdField_try = paramDouble2;
    this.a = paramInt2;
    this.jdField_long = paramLong;
    this.jdField_new = paramString2;
  }
  
  public aq(String paramString1, double paramDouble1, double paramDouble2, int paramInt, long paramLong, String paramString2)
  {
    this(1, paramString1, paramDouble2, paramDouble1, paramInt, paramLong, paramString2);
  }
  
  private static void a(double paramDouble1, double paramDouble2) {}
  
  private static void a(String paramString)
  {
    if ((!paramString.equals("bd09")) && (!paramString.equals("bd09ll")) && (!paramString.equals("gcj02"))) {
      throw new IllegalArgumentException("invalid coord type: " + paramString);
    }
  }
  
  private static void jdMethod_do(int paramInt)
  {
    if (paramInt != 1) {
      throw new IllegalArgumentException("invalid radius type: " + paramInt);
    }
  }
  
  private static String jdMethod_if(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return "Circle";
    }
    return "Administrative";
  }
  
  private static void jdMethod_if(long paramLong)
  {
    if (paramLong / 1000.0D > 2592000.0D) {
      throw new IllegalArgumentException("invalid druationMillis :" + paramLong);
    }
  }
  
  private static void jdMethod_if(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.length() > 100)) {
      throw new IllegalArgumentException("Geofence name is null or too long: " + paramString);
    }
  }
  
  public double a()
  {
    return this.jdField_try;
  }
  
  public void a(float paramFloat)
  {
    this.b = paramFloat;
  }
  
  protected void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.h = paramLong;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_if = paramBoolean;
  }
  
  public boolean jdMethod_byte()
  {
    return this.f;
  }
  
  public double jdMethod_case()
  {
    return this.jdField_goto;
  }
  
  public int jdMethod_char()
  {
    if (this.jdField_char) {
      return 1;
    }
    if (this.jdField_if) {
      return 2;
    }
    return 3;
  }
  
  public float jdMethod_do()
  {
    return this.b;
  }
  
  public void jdMethod_do(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public long jdMethod_else()
  {
    return this.h;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (!(paramObject instanceof aq)) {
        return false;
      }
      paramObject = (aq)paramObject;
      if (this.a != ((aq)paramObject).a) {
        return false;
      }
      if (this.jdField_goto != ((aq)paramObject).jdField_goto) {
        return false;
      }
      if (this.jdField_try != ((aq)paramObject).jdField_try) {
        return false;
      }
      if (this.c != ((aq)paramObject).c) {
        return false;
      }
    } while (this.jdField_new == ((aq)paramObject).jdField_new);
    return false;
  }
  
  public boolean jdMethod_for()
  {
    return this.jdField_char;
  }
  
  public String getGeofenceId()
  {
    return this.jdField_do;
  }
  
  public long jdMethod_goto()
  {
    return this.jdField_long;
  }
  
  public void jdMethod_if(boolean paramBoolean)
  {
    this.jdField_char = paramBoolean;
  }
  
  public boolean jdMethod_if()
  {
    return this.jdField_if;
  }
  
  public String jdMethod_int()
  {
    return this.jdField_new;
  }
  
  public int jdMethod_new()
  {
    return this.a;
  }
  
  public String toString()
  {
    return String.format("Geofence[Type:%s, Name:%s, latitude:%.6f, longitude:%.6f, radius:%.0f, expriation:%d, coordType:%s, fenceType:%d]", new Object[] { jdMethod_if(this.c), this.jdField_do, Double.valueOf(this.jdField_goto), Double.valueOf(this.jdField_try), Float.valueOf(this.b), Long.valueOf(this.jdField_long), this.jdField_new, Integer.valueOf(jdMethod_char()) });
  }
  
  protected int jdMethod_try()
  {
    return this.g;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */