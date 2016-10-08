package com.taobao.dp.a;

import java.io.PrintStream;
import java.security.MessageDigest;

public final class b
{
  private static b a = null;
  
  public static b a()
  {
    if (a == null) {
      a = new b();
    }
    return a;
  }
  
  public static String a(String paramString)
  {
    int i = 0;
    if (paramString != null) {
      try
      {
        if (paramString.length() == 0) {
          return null;
        }
        Object localObject = MessageDigest.getInstance("SHA-1");
        ((MessageDigest)localObject).update(paramString.getBytes("UTF-8"));
        paramString = ((MessageDigest)localObject).digest();
        localObject = new StringBuilder();
        while (i < paramString.length)
        {
          ((StringBuilder)localObject).append(String.format("%02x", new Object[] { Byte.valueOf(paramString[i]) }));
          i += 1;
        }
        paramString = ((StringBuilder)localObject).toString();
        return paramString;
      }
      catch (Exception paramString) {}
    }
    return null;
  }
  
  public static byte[] a(String paramString1, String paramString2)
  {
    try
    {
      if ("MD2、MD5、SHA1、SHA256、SHA384、SHA512".contains(paramString2))
      {
        paramString2 = MessageDigest.getInstance(paramString2);
        paramString2.reset();
        paramString2.update(paramString1.getBytes("UTF-8"));
        return paramString2.digest();
      }
      System.out.println("not support " + paramString2);
      return null;
    }
    catch (Exception paramString1) {}
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\dp\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */