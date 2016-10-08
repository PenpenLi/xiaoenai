package com.inmobi.signals.a;

import java.util.Locale;

public class a
{
  private int a = -1;
  private int b = -1;
  private int c = -1;
  private int d = -1;
  private String e;
  
  public String a()
  {
    if ((this.a == -1) && (this.b == -1)) {
      return null;
    }
    return this.a + "_" + this.b;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(String paramString)
  {
    this.e = paramString.toLowerCase(Locale.ENGLISH);
  }
  
  public String b()
  {
    if ((this.c == -1) && (this.d == -1)) {
      return null;
    }
    return this.c + "_" + this.d;
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public String c()
  {
    return this.e;
  }
  
  public void c(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void d(int paramInt)
  {
    this.d = paramInt;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\signals\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */