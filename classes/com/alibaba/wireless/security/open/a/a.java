package com.alibaba.wireless.security.open.a;

public final class a
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    int j = paramArrayOfByte.length;
    StringBuilder localStringBuilder = new StringBuilder(j * 2);
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(a[(paramArrayOfByte[i] >> 4 & 0xF)]);
      localStringBuilder.append(a[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static byte[] a(String paramString)
  {
    Object localObject;
    if ((paramString == null) || ("".equals(paramString)))
    {
      localObject = null;
      return (byte[])localObject;
    }
    int j = paramString.length();
    byte[] arrayOfByte = new byte[j / 2];
    int i = 0;
    for (;;)
    {
      localObject = arrayOfByte;
      if (i >= j) {
        break;
      }
      arrayOfByte[(i / 2)] = ((byte)((Character.digit(paramString.charAt(i), 16) << 4) + Character.digit(paramString.charAt(i + 1), 16)));
      i += 2;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\wireless\security\open\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */