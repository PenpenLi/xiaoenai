package com.alibaba.mtl.appmonitor.a;

import com.alibaba.mtl.log.e.i;

public enum f
{
  static String TAG = "EventType";
  private int e;
  private int h;
  private int i = 25;
  private int j = 180;
  private int k;
  private boolean m;
  private String t;
  
  static
  {
    jdField_a_of_type_ComAlibabaMtlAppmonitorAF = new f("ALARM", 0, 65501, 30, "alarmData", 5000);
    b = new f("COUNTER", 1, 65502, 30, "counterData", 5000);
    c = new f("OFFLINE_COUNTER", 2, 65133, 30, "counterData", 5000);
    d = new f("STAT", 3, 65503, 30, "statData", 5000);
    jdField_a_of_type_ArrayOfComAlibabaMtlAppmonitorAF = new f[] { jdField_a_of_type_ComAlibabaMtlAppmonitorAF, b, c, d };
  }
  
  private f(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    this.e = paramInt1;
    this.h = paramInt2;
    this.m = true;
    this.t = paramString;
    this.k = paramInt3;
  }
  
  public static f a(int paramInt)
  {
    f[] arrayOff = a();
    int n = 0;
    while (n < arrayOff.length)
    {
      f localf = arrayOff[n];
      if ((localf != null) && (localf.a() == paramInt)) {
        return localf;
      }
      n += 1;
    }
    return null;
  }
  
  public static f[] a()
  {
    return (f[])jdField_a_of_type_ArrayOfComAlibabaMtlAppmonitorAF.clone();
  }
  
  public int a()
  {
    return this.e;
  }
  
  public String a()
  {
    return this.t;
  }
  
  public int b()
  {
    return this.h;
  }
  
  public void b(int paramInt)
  {
    i.a(TAG, new Object[] { "[setTriggerCount]", this.t, paramInt + "" });
    this.h = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public int c()
  {
    return this.i;
  }
  
  public void c(int paramInt)
  {
    this.k = paramInt;
  }
  
  public int d()
  {
    return this.j;
  }
  
  public int e()
  {
    return this.k;
  }
  
  public boolean isOpen()
  {
    return this.m;
  }
  
  public void setStatisticsInterval(int paramInt)
  {
    this.i = paramInt;
    this.j = paramInt;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */