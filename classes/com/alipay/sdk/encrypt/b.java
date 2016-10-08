package com.alipay.sdk.encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class b
{
  public static String a(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString2.getBytes(), "DES");
      paramString2 = Cipher.getInstance("DES");
      paramString2.init(paramInt, localSecretKeySpec);
      if (paramInt == 2) {}
      for (paramString1 = a.a(paramString1);; paramString1 = paramString1.getBytes("UTF-8"))
      {
        paramString1 = paramString2.doFinal(paramString1);
        if (paramInt != 2) {
          break;
        }
        return new String(paramString1);
      }
      paramString1 = a.a(paramString1);
      return paramString1;
    }
    catch (Exception paramString1) {}
    return null;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    return a(1, paramString1, paramString2);
  }
  
  private static String b(String paramString1, String paramString2)
  {
    return a(2, paramString1, paramString2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\encrypt\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */