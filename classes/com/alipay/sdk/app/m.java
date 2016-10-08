package com.alipay.sdk.app;

public enum m
{
  private int g;
  private String h;
  
  private m(int paramInt, String paramString)
  {
    this.g = paramInt;
    this.h = paramString;
  }
  
  public static m a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return b;
    case 9000: 
      return a;
    case 6001: 
      return c;
    case 6002: 
      return d;
    case 4001: 
      return e;
    }
    return f;
  }
  
  private void a(String paramString)
  {
    this.h = paramString;
  }
  
  private void b(int paramInt)
  {
    this.g = paramInt;
  }
  
  public final int a()
  {
    return this.g;
  }
  
  public final String b()
  {
    return this.h;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\app\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */