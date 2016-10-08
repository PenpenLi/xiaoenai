package com.alibaba.wireless.security.open.dynamicdataencrypt;

import android.content.ContextWrapper;
import com.alibaba.wireless.security.open.SecException;
import com.taobao.wireless.security.adapter.JNICLibrary;
import com.taobao.wireless.security.adapter.common.f;

public final class a
  implements IDynamicDataEncryptComponent
{
  private ContextWrapper a = null;
  
  public a(ContextWrapper paramContextWrapper)
  {
    this.a = paramContextWrapper;
  }
  
  private String a(String paramString, boolean paramBoolean)
  {
    JNICLibrary localJNICLibrary = null;
    Object localObject = localJNICLibrary;
    if (paramString != null)
    {
      localObject = localJNICLibrary;
      if (paramString.length() > 0) {
        localObject = f.a(this.a);
      }
    }
    for (;;)
    {
      try
      {
        localJNICLibrary = JNICLibrary.a();
        int i;
        if (paramBoolean)
        {
          i = 1;
          paramString = localJNICLibrary.a(303, paramString, (String[])localObject, i);
          if (paramString != null)
          {
            paramString = new String(paramString, "UTF-8");
            localObject = paramString;
            return (String)localObject;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        paramString = null;
      }
      catch (Exception paramString)
      {
        a(paramString);
        return null;
      }
    }
  }
  
  private static void a(Exception paramException)
  {
    if ((paramException instanceof SecException))
    {
      int i = ((SecException)paramException).getErrorCode();
      if ((i > 0) && (i <= 99)) {
        throw new SecException(paramException.getMessage(), paramException.getCause(), i + 400);
      }
    }
  }
  
  private String b(String paramString, boolean paramBoolean)
  {
    JNICLibrary localJNICLibrary = null;
    Object localObject = localJNICLibrary;
    if (paramString != null)
    {
      localObject = localJNICLibrary;
      if (paramString.length() > 0) {
        localObject = f.a(this.a);
      }
    }
    for (;;)
    {
      try
      {
        localJNICLibrary = JNICLibrary.a();
        int i;
        if (paramBoolean)
        {
          i = 1;
          paramString = localJNICLibrary.a(302, paramString, (String[])localObject, i);
          if (paramString != null)
          {
            paramString = new String(paramString, "UTF-8");
            localObject = paramString;
            return (String)localObject;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        paramString = null;
      }
      catch (Exception paramString)
      {
        a(paramString);
        return null;
      }
    }
  }
  
  public final String dynamicDecrypt(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      return b(paramString, false);
    }
    throw new SecException("Input cipherText string is empty", 401);
  }
  
  public final byte[] dynamicDecryptByteArray(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramArrayOfByte = dynamicDecrypt(new String(paramArrayOfByte));
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length() > 0)) {
        return com.alibaba.wireless.security.open.a.a.a(paramArrayOfByte);
      }
    }
    else
    {
      throw new SecException("Input cipherText byte array is empty", 401);
    }
    return null;
  }
  
  public final byte[] dynamicDecryptByteArrayDDp(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramArrayOfByte = dynamicDecryptDDp(new String(paramArrayOfByte));
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length() > 0)) {
        return com.alibaba.wireless.security.open.a.a.a(paramArrayOfByte);
      }
    }
    else
    {
      throw new SecException("Input cipherText byte array is empty", 401);
    }
    return null;
  }
  
  public final String dynamicDecryptDDp(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      return b(paramString, true);
    }
    throw new SecException("Input cipherText string is empty", 401);
  }
  
  public final String dynamicEncrypt(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      return a(paramString, false);
    }
    throw new SecException("Input plainText string is empty", 401);
  }
  
  public final byte[] dynamicEncryptByteArray(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramArrayOfByte = com.alibaba.wireless.security.open.a.a.a(paramArrayOfByte);
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length() > 0))
      {
        paramArrayOfByte = dynamicEncrypt(paramArrayOfByte);
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length() > 0)) {
          return paramArrayOfByte.getBytes();
        }
      }
    }
    else
    {
      throw new SecException("Input plainText byte array is empty", 401);
    }
    return null;
  }
  
  public final byte[] dynamicEncryptByteArrayDDp(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramArrayOfByte = com.alibaba.wireless.security.open.a.a.a(paramArrayOfByte);
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length() > 0))
      {
        paramArrayOfByte = dynamicEncryptDDp(paramArrayOfByte);
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length() > 0)) {
          return paramArrayOfByte.getBytes();
        }
      }
    }
    else
    {
      throw new SecException("Input plainText byte array is empty", 401);
    }
    return null;
  }
  
  public final String dynamicEncryptDDp(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      return a(paramString, true);
    }
    throw new SecException("Input plainText string is empty", 401);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\wireless\security\open\dynamicdataencrypt\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */