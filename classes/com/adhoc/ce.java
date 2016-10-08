package com.adhoc;

public enum ce
{
  public final int s;
  public final int t;
  public final int u;
  
  private ce(int paramInt1, int paramInt2, int paramInt3)
  {
    this.s = paramInt1;
    this.t = paramInt2;
    this.u = paramInt3;
  }
  
  public static ce a(int paramInt)
  {
    ce[] arrayOfce = values();
    int i2 = arrayOfce.length;
    int i1 = 0;
    while (i1 < i2)
    {
      ce localce = arrayOfce[i1];
      if (localce.t == paramInt) {
        return localce;
      }
      i1 += 1;
    }
    return null;
  }
  
  public static ce b(int paramInt)
  {
    ce[] arrayOfce = values();
    int i2 = arrayOfce.length;
    int i1 = 0;
    while (i1 < i2)
    {
      ce localce = arrayOfce[i1];
      if (localce.s == paramInt) {
        return localce;
      }
      i1 += 1;
    }
    return null;
  }
  
  public static ce c(int paramInt)
  {
    ce[] arrayOfce = values();
    int i2 = arrayOfce.length;
    int i1 = 0;
    while (i1 < i2)
    {
      ce localce = arrayOfce[i1];
      if (localce.u == paramInt) {
        return localce;
      }
      i1 += 1;
    }
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */