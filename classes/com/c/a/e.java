package com.c.a;

public class e
  implements ac
{
  public Object a(float paramFloat, Object paramObject1, Object paramObject2)
  {
    int m = ((Integer)paramObject1).intValue();
    int i = m >> 24;
    int j = m >> 16 & 0xFF;
    int k = m >> 8 & 0xFF;
    m &= 0xFF;
    int n = ((Integer)paramObject2).intValue();
    int i1 = (int)(((n >> 24) - i) * paramFloat);
    int i2 = (int)(((n >> 16 & 0xFF) - j) * paramFloat);
    int i3 = (int)(((n >> 8 & 0xFF) - k) * paramFloat);
    return Integer.valueOf(m + (int)(((n & 0xFF) - m) * paramFloat) | i + i1 << 24 | j + i2 << 16 | i3 + k << 8);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\c\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */