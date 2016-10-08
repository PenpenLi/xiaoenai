package com.alibaba.sdk.android.login.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Utils
{
  public static String md5Digest(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = MessageDigest.getInstance("MD5").digest(paramArrayOfByte);
      StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
      int j = paramArrayOfByte.length;
      int i = 0;
      while (i < j)
      {
        int k = paramArrayOfByte[i];
        if ((k & 0xFF) < 16) {
          localStringBuilder.append("0");
        }
        localStringBuilder.append(Integer.toHexString(k & 0xFF));
        i += 1;
      }
      return localStringBuilder.toString();
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\utils\Md5Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */