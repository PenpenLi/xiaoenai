package com.xiaoenai.app.utils.d;

import com.xiaoenai.app.utils.f.a;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class n
{
  public static byte[] a(String paramString1, String paramString2)
  {
    try
    {
      Mac localMac = Mac.getInstance("HmacSHA1");
      localMac.init(new SecretKeySpec(paramString2.getBytes(), "HmacSHA1"));
      paramString1 = localMac.doFinal(paramString1.getBytes());
      return paramString1;
    }
    catch (NoSuchAlgorithmException paramString1)
    {
      a.c("no algorithm called HmacSHA1!", new Object[0]);
      paramString1.printStackTrace();
    }
    return new byte[0];
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\d\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */