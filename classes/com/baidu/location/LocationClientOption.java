package com.baidu.location;

public final class LocationClientOption
{
  public static final int MIN_SCAN_SPAN = 1000;
  public static final int MIN_SCAN_SPAN_NETWORK = 3000;
  protected static final int jdField_byte = 1;
  protected static final int jdField_try = 3;
  protected static final int jdField_void = 2;
  protected boolean a = true;
  protected boolean b = false;
  protected float c = 500.0F;
  protected String jdField_case = "com.baidu.location.service_v2.9";
  protected boolean jdField_char = false;
  protected int d = 12000;
  protected String jdField_do = "gcj02";
  protected boolean e = false;
  protected String jdField_else = "detail";
  protected LocationMode f;
  protected boolean jdField_for = false;
  protected boolean g = false;
  protected boolean jdField_goto = false;
  protected int h = 1;
  protected String jdField_if = "SDK2.0";
  protected int jdField_int = 0;
  protected int jdField_long = 3;
  protected boolean jdField_new = false;
  
  public LocationClientOption() {}
  
  public LocationClientOption(LocationClientOption paramLocationClientOption)
  {
    this.jdField_do = paramLocationClientOption.jdField_do;
    this.jdField_else = paramLocationClientOption.jdField_else;
    this.jdField_for = paramLocationClientOption.jdField_for;
    this.jdField_int = paramLocationClientOption.jdField_int;
    this.d = paramLocationClientOption.d;
    this.jdField_if = paramLocationClientOption.jdField_if;
    this.h = paramLocationClientOption.h;
    this.jdField_goto = paramLocationClientOption.jdField_goto;
    this.e = paramLocationClientOption.e;
    this.c = paramLocationClientOption.c;
    this.jdField_long = paramLocationClientOption.jdField_long;
    this.jdField_case = paramLocationClientOption.jdField_case;
    this.a = paramLocationClientOption.a;
    this.b = paramLocationClientOption.b;
    this.jdField_char = paramLocationClientOption.jdField_char;
    this.g = paramLocationClientOption.g;
    this.f = paramLocationClientOption.f;
  }
  
  public void SetIgnoreCacheException(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  protected boolean a()
  {
    return this.a;
  }
  
  public boolean equals(LocationClientOption paramLocationClientOption)
  {
    return (this.jdField_do.equals(paramLocationClientOption.jdField_do)) && (this.jdField_else.equals(paramLocationClientOption.jdField_else)) && (this.jdField_for == paramLocationClientOption.jdField_for) && (this.jdField_int == paramLocationClientOption.jdField_int) && (this.d == paramLocationClientOption.d) && (this.jdField_if.equals(paramLocationClientOption.jdField_if)) && (this.jdField_goto == paramLocationClientOption.jdField_goto) && (this.h == paramLocationClientOption.h) && (this.jdField_long == paramLocationClientOption.jdField_long) && (this.e == paramLocationClientOption.e) && (this.c == paramLocationClientOption.c) && (this.a == paramLocationClientOption.a) && (this.b == paramLocationClientOption.b) && (this.jdField_char == paramLocationClientOption.jdField_char) && (this.g == paramLocationClientOption.g) && (this.f == paramLocationClientOption.f);
  }
  
  public String getAddrType()
  {
    return this.jdField_else;
  }
  
  public String getCoorType()
  {
    return this.jdField_do;
  }
  
  public LocationMode getLocationMode()
  {
    return this.f;
  }
  
  public String getProdName()
  {
    return this.jdField_if;
  }
  
  public int getScanSpan()
  {
    return this.jdField_int;
  }
  
  public int getTimeOut()
  {
    return this.d;
  }
  
  public boolean isLocationNotify()
  {
    return this.jdField_goto;
  }
  
  public boolean isOpenGps()
  {
    return this.jdField_for;
  }
  
  public void setCoorType(String paramString)
  {
    paramString = paramString.toLowerCase();
    if ((paramString.equals("gcj02")) || (paramString.equals("bd09")) || (paramString.equals("bd09ll"))) {
      this.jdField_do = paramString;
    }
  }
  
  public void setIgnoreKillProcess(boolean paramBoolean)
  {
    this.jdField_char = paramBoolean;
  }
  
  public void setIsNeedAddress(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_else = "all";
      this.h = 1;
    }
  }
  
  public void setLocationMode(LocationMode paramLocationMode)
  {
    switch (1.a[paramLocationMode.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Illegal this mode : " + paramLocationMode);
    case 1: 
      this.jdField_for = true;
    }
    for (;;)
    {
      this.f = paramLocationMode;
      return;
      this.jdField_for = false;
      continue;
      this.h = 3;
      this.jdField_for = true;
    }
  }
  
  public void setLocationNotify(boolean paramBoolean)
  {
    this.jdField_goto = paramBoolean;
  }
  
  public void setNeedDeviceDirect(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setOpenGps(boolean paramBoolean)
  {
    this.jdField_for = paramBoolean;
  }
  
  public void setProdName(String paramString)
  {
    String str = paramString;
    if (paramString.length() > 64) {
      str = paramString.substring(0, 64);
    }
    this.jdField_if = str;
  }
  
  public void setScanSpan(int paramInt)
  {
    this.jdField_int = paramInt;
  }
  
  public void setTimeOut(int paramInt)
  {
    this.d = paramInt;
  }
  
  public static enum LocationMode {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\LocationClientOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */