package com.xiaoenai.app.utils.d;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class e
{
  public static String a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2.getBytes());
  }
  
  private static String a(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      paramString = new DESKeySpec(paramString.getBytes());
      paramString = SecretKeyFactory.getInstance("DES").generateSecret(paramString);
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      localCipher.init(1, paramString, new IvParameterSpec("12345678".getBytes()));
      paramString = new String(c.a(localCipher.doFinal(paramArrayOfByte)));
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new Exception(paramString);
    }
  }
  
  public static String b(String paramString1, String paramString2)
  {
    try
    {
      if ((System.getProperty("os.name") != null) && ((System.getProperty("os.name").equalsIgnoreCase("sunos")) || (System.getProperty("os.name").equalsIgnoreCase("linux")))) {}
      for (paramString1 = b(paramString1, c.b(paramString2));; paramString1 = b(paramString1, c.b(paramString2))) {
        return new String(paramString1);
      }
      return "";
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private static byte[] b(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      paramString = new DESKeySpec(paramString.getBytes());
      paramString = SecretKeyFactory.getInstance("DES").generateSecret(paramString);
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      localCipher.init(2, paramString, new IvParameterSpec("12345678".getBytes()));
      paramString = localCipher.doFinal(paramArrayOfByte);
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new Exception(paramString);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\d\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */