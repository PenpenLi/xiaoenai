package com.tencent.bugly.proguard;

public final class e
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i];
      arrayOfChar[(i * 2 + 1)] = a[(j & 0xF)];
      j = (byte)(j >>> 4);
      arrayOfChar[(i * 2)] = a[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\tencent\bugly\proguard\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */