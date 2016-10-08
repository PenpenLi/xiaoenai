package com.alipay.security.mobile.module.a;

import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

public final class a
{
  public static String a(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if (paramMap == null) {}
    do
    {
      return paramString2;
      paramMap = (String)paramMap.get(paramString1);
    } while (paramMap == null);
    return paramMap;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    int j;
    boolean bool1;
    if (paramString != null)
    {
      j = paramString.length();
      if (j != 0) {}
    }
    else
    {
      bool1 = true;
      return bool1;
    }
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label48;
      }
      bool1 = bool2;
      if (!Character.isWhitespace(paramString.charAt(i))) {
        break;
      }
      i += 1;
    }
    label48:
    return true;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2 == null;
    }
    return paramString1.equals(paramString2);
  }
  
  public static String b(String paramString)
  {
    int i = 0;
    try
    {
      if (a(paramString)) {
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
    return null;
  }
  
  public static String c(String paramString)
  {
    try
    {
      byte[] arrayOfByte = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(paramString.length()).array();
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramString.length());
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localGZIPOutputStream.write(paramString.getBytes("UTF-8"));
      localGZIPOutputStream.close();
      localByteArrayOutputStream.close();
      paramString = new byte[localByteArrayOutputStream.toByteArray().length + 4];
      System.arraycopy(arrayOfByte, 0, paramString, 0, 4);
      System.arraycopy(localByteArrayOutputStream.toByteArray(), 0, paramString, 4, localByteArrayOutputStream.toByteArray().length);
      paramString = Base64.encodeToString(paramString, 8);
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\security\mobile\module\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */