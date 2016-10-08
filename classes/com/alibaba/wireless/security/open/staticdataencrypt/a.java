package com.alibaba.wireless.security.open.staticdataencrypt;

import com.alibaba.wireless.security.open.SecException;
import com.taobao.wireless.security.adapter.JNICLibrary;
import java.io.UnsupportedEncodingException;

public final class a
  implements IStaticDataEncryptComponent
{
  private static String a(int paramInt, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    paramArrayOfByte = JNICLibrary.a().a(1, 1, paramInt, paramArrayOfByte, paramString1.getBytes(), paramString2);
    if (paramArrayOfByte != null) {
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
        return paramArrayOfByte;
      }
      catch (UnsupportedEncodingException paramArrayOfByte) {}
    }
    return null;
  }
  
  private static String b(int paramInt, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    paramArrayOfByte = JNICLibrary.a().a(2, 1, paramInt, paramArrayOfByte, paramString1.getBytes(), paramString2);
    if (paramArrayOfByte != null) {
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
        return paramArrayOfByte;
      }
      catch (UnsupportedEncodingException paramArrayOfByte) {}
    }
    return null;
  }
  
  public final byte[] staticBinarySafeDecrypt(int paramInt, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() > 0) && (paramInt >= 0) && (paramInt < 19) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramString1 = paramString1.getBytes();
      return JNICLibrary.a().a(2, 1, paramInt, paramString1, paramArrayOfByte, paramString2);
    }
    throw new SecException("", 301);
  }
  
  public final byte[] staticBinarySafeDecryptNoB64(int paramInt, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() > 0) && (paramInt >= 0) && (paramInt < 19) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramString1 = paramString1.getBytes();
      return JNICLibrary.a().a(2, 0, paramInt, paramString1, paramArrayOfByte, paramString2);
    }
    throw new SecException("", 301);
  }
  
  public final byte[] staticBinarySafeEncrypt(int paramInt, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() > 0) && (paramInt >= 0) && (paramInt < 19) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramString1 = paramString1.getBytes();
      return JNICLibrary.a().a(1, 1, paramInt, paramString1, paramArrayOfByte, paramString2);
    }
    throw new SecException("", 301);
  }
  
  public final byte[] staticBinarySafeEncryptNoB64(int paramInt, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() > 0) && (paramInt >= 0) && (paramInt < 19) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramString1 = paramString1.getBytes();
      return JNICLibrary.a().a(1, 0, paramInt, paramString1, paramArrayOfByte, paramString2);
    }
    throw new SecException("", 301);
  }
  
  public final String staticSafeDecrypt(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (paramString1.length() > 0) && (paramInt >= 0) && (paramInt < 19) && (paramString2 != null) && (paramString2.length() > 0)) {
      return b(paramInt, paramString1.getBytes(), paramString2, paramString3);
    }
    throw new SecException("", 301);
  }
  
  public final String staticSafeEncrypt(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (paramString1.length() > 0) && (paramInt >= 0) && (paramInt < 19) && (paramString2 != null) && (paramString2.length() > 0)) {
      return a(paramInt, paramString1.getBytes(), paramString2, paramString3);
    }
    throw new SecException("", 301);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\wireless\security\open\staticdataencrypt\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */