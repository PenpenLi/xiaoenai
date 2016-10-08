package com.xiaoenai.app.utils;

public class y
{
  static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122 };
  
  public static String a(long paramLong, int paramInt)
  {
    int i = 32;
    long l = paramLong;
    if (paramLong < 0L) {
      l = 4294967294L + paramLong + 2L;
    }
    char[] arrayOfChar = new char[32];
    while (l / paramInt > 0L)
    {
      i -= 1;
      arrayOfChar[i] = a[((int)(l % paramInt))];
      l /= paramInt;
    }
    i -= 1;
    arrayOfChar[i] = a[((int)(l % paramInt))];
    return new String(arrayOfChar, i, 32 - i);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */