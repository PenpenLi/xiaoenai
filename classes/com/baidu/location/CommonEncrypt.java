package com.baidu.location;

import com.baidu.location.b.b.b;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class CommonEncrypt
{
  public static boolean a;
  
  static
  {
    try
    {
      System.loadLibrary("locSDK4d");
      a = true;
      a = true;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a = false;
      }
    }
  }
  
  public static String a(String paramString)
  {
    if (!a) {
      return null;
    }
    paramString = a(encrypt(paramString.getBytes()));
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = b.a(paramArrayOfByte, "UTF-8");
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte) {}
    return "";
  }
  
  public static native byte[] encrypt(byte[] paramArrayOfByte);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\CommonEncrypt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */