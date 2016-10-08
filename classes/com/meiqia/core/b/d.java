package com.meiqia.core.b;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class d
{
  private static final String[] a = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };
  
  private static String a(byte paramByte)
  {
    int i = paramByte;
    if (paramByte < 0) {
      i = paramByte + 256;
    }
    paramByte = i / 16;
    return a[paramByte] + a[(i % 16)];
  }
  
  public static String a(String paramString)
  {
    try
    {
      String str = a(MessageDigest.getInstance("MD5").digest(paramString.getBytes()));
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
    }
    return paramString;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuffer.append(a(paramArrayOfByte[i]));
      i += 1;
    }
    return localStringBuffer.toString();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */