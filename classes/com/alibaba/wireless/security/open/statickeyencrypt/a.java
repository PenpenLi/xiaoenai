package com.alibaba.wireless.security.open.statickeyencrypt;

import android.util.Base64;
import com.alibaba.wireless.security.open.SecException;
import com.taobao.wireless.security.adapter.JNICLibrary;
import com.taobao.wireless.security.adapter.common.SPUtility2;

public final class a
  implements IStaticKeyEncryptComponent
{
  public static String a(String paramString)
  {
    byte[] arrayOfByte = null;
    Object localObject = arrayOfByte;
    if (paramString != null)
    {
      localObject = arrayOfByte;
      if (paramString.length() > 0)
      {
        paramString = SPUtility2.readFromSPUnified("StaticKey", paramString, null);
        if ((paramString == null) || (paramString.length() <= 0)) {
          return paramString;
        }
        localObject = JNICLibrary.a();
        arrayOfByte = paramString.getBytes();
        localObject = (byte[])((JNICLibrary)localObject).doCommandNative(700, new int[] { 705 }, null, new byte[][] { arrayOfByte }, null);
        if ((localObject == null) || (localObject.length <= 0)) {
          return paramString;
        }
        localObject = Base64.encodeToString((byte[])localObject, 2);
      }
    }
    return (String)localObject;
    return paramString;
  }
  
  private static byte[] a(int paramInt, String paramString1, String paramString2)
  {
    paramString1 = SPUtility2.readFromSPUnified("StaticKey", paramString1, null);
    paramString2 = SPUtility2.readFromSPUnified("StaticKey", paramString2, null);
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      throw new SecException(703);
    }
    if ((paramString2 == null) || (paramString2.length() == 0)) {
      throw new SecException(703);
    }
    paramString1 = JNICLibrary.a().a(703, paramInt, paramString1.getBytes(), paramString2.getBytes());
    if ((paramString1 != null) && (paramString1.length > 0)) {
      try
      {
        paramString1 = Base64.decode(paramString1, 0);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        return null;
      }
    }
    return paramString1;
  }
  
  public final byte[] decrypt(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    if ((paramString != null) && (paramString.length() > 0) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0) && (paramInt >= 16) && (paramInt <= 18))
    {
      paramString = SPUtility2.readFromSPUnified("StaticKey", paramString, null);
      if ((paramString != null) && (paramString.length() > 0))
      {
        paramArrayOfByte = Base64.encode(paramArrayOfByte, 2);
        return JNICLibrary.a().a(702, paramInt, paramString.getBytes(), paramArrayOfByte);
      }
      throw new SecException(703);
    }
    throw new SecException(701);
  }
  
  public final byte[] encrypt(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    if ((paramString != null) && (paramString.length() > 0) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0) && (paramInt >= 16) && (paramInt <= 18))
    {
      paramString = SPUtility2.readFromSPUnified("StaticKey", paramString, null);
      if ((paramString != null) && (paramString.length() > 0))
      {
        paramArrayOfByte = JNICLibrary.a().a(701, paramInt, paramString.getBytes(), paramArrayOfByte);
        paramString = paramArrayOfByte;
        if (paramArrayOfByte != null)
        {
          paramString = paramArrayOfByte;
          if (paramArrayOfByte.length > 0) {
            paramString = Base64.decode(paramArrayOfByte, 0);
          }
        }
        return paramString;
      }
      throw new SecException(703);
    }
    throw new SecException(701);
  }
  
  public final byte[] encryptSecretData(int paramInt, String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() > 0) && (paramString2 != null) && (paramString2.length() > 0) && (paramInt >= 16) && (paramInt <= 18)) {
      return a(paramInt, paramString1, paramString2);
    }
    throw new SecException(701);
  }
  
  public final boolean isSecretExist(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      paramString = SPUtility2.readFromSPUnified("StaticKey", paramString, null);
      return (paramString != null) && (paramString.length() > 0);
    }
    throw new SecException(701);
  }
  
  public final int removeSecret(String paramString)
  {
    int i = 1;
    if ((paramString != null) && (paramString.length() > 0))
    {
      if (SPUtility2.readFromSPUnified("StaticKey", paramString, null) == null) {
        i = 2;
      }
      while (SPUtility2.removeFromSPUnified("StaticKey", paramString, true)) {
        return i;
      }
      return 0;
    }
    throw new SecException(701);
  }
  
  public final int saveSecret(String paramString, byte[] paramArrayOfByte)
  {
    if ((paramString != null) && (paramString.length() > 0) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      if ((paramString != null) && (paramString.length() > 0) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
      {
        Object localObject = JNICLibrary.a();
        byte[] arrayOfByte = paramString.getBytes();
        paramArrayOfByte = (byte[])((JNICLibrary)localObject).doCommandNative(700, new int[] { 704 }, null, new byte[][] { arrayOfByte, paramArrayOfByte }, null);
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
        {
          localObject = SPUtility2.readFromSPUnified("StaticKey", paramString, null);
          if (SPUtility2.saveToSPUnified("StaticKey", paramString, new String(paramArrayOfByte), true))
          {
            if ((localObject != null) && (((String)localObject).length() > 0)) {
              return 2;
            }
            return 1;
          }
        }
      }
      else
      {
        throw new SecException(701);
      }
    }
    else {
      throw new SecException(701);
    }
    return 0;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\wireless\security\open\statickeyencrypt\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */