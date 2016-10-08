package com.alipay.sdk.util;

public enum g
{
  private int p;
  private String q;
  
  private g(int paramInt, String paramString)
  {
    this.p = paramInt;
    this.q = paramString;
  }
  
  public static g a(int paramInt)
  {
    g[] arrayOfg = values();
    int i2 = arrayOfg.length;
    int i1 = 0;
    while (i1 < i2)
    {
      g localg = arrayOfg[i1];
      if (localg.p == paramInt) {
        return localg;
      }
      i1 += 1;
    }
    return o;
  }
  
  private int b()
  {
    return this.p;
  }
  
  public final String a()
  {
    return this.q;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\util\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */