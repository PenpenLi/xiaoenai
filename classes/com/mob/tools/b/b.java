package com.mob.tools.b;

import android.text.TextUtils;
import android.util.Base64;
import com.mob.tools.e;
import com.mob.tools.log.d;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class b
{
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramArrayOfByte == null) {
      return localStringBuffer.toString();
    }
    while (paramInt1 < paramInt2)
    {
      localStringBuffer.append(String.format("%02x", new Object[] { Byte.valueOf(paramArrayOfByte[paramInt1]) }));
      paramInt1 += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static byte[] a(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      return null;
    }
    try
    {
      byte[] arrayOfByte = new byte['Ѐ'];
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      for (int i = paramInputStream.read(arrayOfByte); i != -1; i = paramInputStream.read(arrayOfByte)) {
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      paramInputStream = localMessageDigest.digest();
      return paramInputStream;
    }
    catch (Throwable paramInputStream)
    {
      e.a().w(paramInputStream);
    }
    return null;
  }
  
  public static byte[] a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return a(paramString.getBytes("utf-8"));
  }
  
  public static byte[] a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return null;
    }
    paramString1 = paramString1.getBytes("UTF-8");
    Object localObject = new byte[16];
    System.arraycopy(paramString1, 0, localObject, 0, Math.min(paramString1.length, 16));
    paramString1 = paramString2.getBytes("UTF-8");
    localObject = new SecretKeySpec((byte[])localObject, "AES");
    paramString2 = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
    paramString2.init(1, (Key)localObject);
    localObject = new byte[paramString2.getOutputSize(paramString1.length)];
    paramString2.doFinal((byte[])localObject, paramString2.update(paramString1, 0, paramString1.length, (byte[])localObject, 0));
    return (byte[])localObject;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
    localMessageDigest.update(paramArrayOfByte);
    return localMessageDigest.digest();
  }
  
  public static byte[] a(byte[] paramArrayOfByte, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramString == null)) {
      return null;
    }
    return a(paramArrayOfByte, paramString.getBytes("UTF-8"));
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Object localObject = new SecretKeySpec(paramArrayOfByte1, "AES");
    paramArrayOfByte1 = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
    paramArrayOfByte1.init(1, (Key)localObject);
    localObject = new byte[paramArrayOfByte1.getOutputSize(paramArrayOfByte2.length)];
    paramArrayOfByte1.doFinal((byte[])localObject, paramArrayOfByte1.update(paramArrayOfByte2, 0, paramArrayOfByte2.length, (byte[])localObject, 0));
    return (byte[])localObject;
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = c(paramString);
    } while (paramString == null);
    return e(paramString);
  }
  
  public static String b(String paramString1, String paramString2)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString1 != null)
    {
      if (paramString2 != null) {
        break label19;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      return (String)localObject1;
      label19:
      localObject2 = localObject3;
      try
      {
        paramString1 = Base64.encodeToString(a(paramString2, paramString1), 0);
        localObject1 = paramString1;
        localObject2 = paramString1;
        if (!TextUtils.isEmpty(paramString1))
        {
          localObject1 = paramString1;
          localObject2 = paramString1;
          if (paramString1.contains("\n"))
          {
            localObject2 = paramString1;
            paramString1 = paramString1.replace("\n", "");
            return paramString1;
          }
        }
      }
      catch (Throwable paramString1)
      {
        e.a().w(paramString1);
      }
    }
    return (String)localObject2;
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {
      return null;
    }
    Object localObject = new byte[16];
    System.arraycopy(paramArrayOfByte1, 0, localObject, 0, Math.min(paramArrayOfByte1.length, 16));
    localObject = new SecretKeySpec((byte[])localObject, "AES");
    paramArrayOfByte1 = Cipher.getInstance("AES/ECB/NoPadding", "BC");
    paramArrayOfByte1.init(2, (Key)localObject);
    localObject = new byte[paramArrayOfByte1.getOutputSize(paramArrayOfByte2.length)];
    int i = paramArrayOfByte1.update(paramArrayOfByte2, 0, paramArrayOfByte2.length, (byte[])localObject, 0);
    paramArrayOfByte1.doFinal((byte[])localObject, i);
    return (byte[])localObject;
  }
  
  public static String c(String paramString1, String paramString2)
  {
    paramString1 = URLEncoder.encode(paramString1, paramString2);
    if (TextUtils.isEmpty(paramString1)) {
      return paramString1;
    }
    return paramString1.replace("+", "%20");
  }
  
  public static String c(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      return null;
      paramArrayOfByte = d(paramArrayOfByte);
    } while (paramArrayOfByte == null);
    return e(paramArrayOfByte);
  }
  
  public static byte[] c(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = d(paramString.getBytes("utf-8"));
      return paramString;
    }
    catch (Throwable paramString)
    {
      e.a().w(paramString);
    }
    return null;
  }
  
  public static String d(String paramString)
  {
    try
    {
      paramString = c(paramString, "utf-8");
      return paramString;
    }
    catch (Throwable paramString)
    {
      e.a().w(paramString);
    }
    return null;
  }
  
  public static byte[] d(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
      paramArrayOfByte = a(localByteArrayInputStream);
      localByteArrayInputStream.close();
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      for (;;)
      {
        e.a().w(paramArrayOfByte);
        paramArrayOfByte = null;
      }
    }
  }
  
  private static String e(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuffer.append(String.format("%02x", new Object[] { Byte.valueOf(paramArrayOfByte[i]) }));
      i += 1;
    }
    return localStringBuffer.toString();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */