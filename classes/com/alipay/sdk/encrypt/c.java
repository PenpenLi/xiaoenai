package com.alipay.sdk.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class c
{
  private static String a(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes());
      paramString = b(localMessageDigest.digest());
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString) {}
    return "";
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = b(localMessageDigest.digest());
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte) {}
    return "";
  }
  
  private static String b(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuffer.append(Character.forDigit((paramArrayOfByte[i] & 0xF0) >> 4, 16));
      localStringBuffer.append(Character.forDigit(paramArrayOfByte[i] & 0xF, 16));
      i += 1;
    }
    return localStringBuffer.toString();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\encrypt\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */