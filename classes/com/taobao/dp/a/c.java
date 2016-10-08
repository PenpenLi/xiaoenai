package com.taobao.dp.a;

import android.content.Context;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

public final class c
{
  public static String a(String paramString1, String paramString2, String paramString3, Context paramContext)
  {
    String str = "";
    try
    {
      Object localObject1 = Class.forName("com.alibaba.wireless.security.open.SecurityGuardManager");
      Object localObject2 = ((Class)localObject1).getMethod("getInstance", new Class[] { Context.class }).invoke(null, new Object[] { paramContext });
      paramContext = str;
      if (localObject2 != null)
      {
        localObject1 = ((Class)localObject1).getMethod("getStaticDataEncryptComp", new Class[0]).invoke(localObject2, new Object[0]);
        paramContext = str;
        if (localObject1 != null) {
          paramContext = (String)localObject1.getClass().getMethod("staticSafeEncrypt", new Class[] { Integer.TYPE, String.class, String.class, String.class }).invoke(localObject1, new Object[] { Integer.valueOf(localObject1.getClass().getField("OPEN_ENUM_CIPHER_AES128").getInt(null)), paramString2, paramString1, paramString3 });
        }
      }
      return paramContext;
    }
    catch (Exception paramString1) {}
    return "";
  }
  
  public static byte[] a(byte[] paramArrayOfByte, String paramString1, String paramString2, Context paramContext)
  {
    try
    {
      Class localClass = Class.forName("com.alibaba.wireless.security.open.SecurityGuardManager");
      paramContext = localClass.getMethod("getInstance", new Class[] { Context.class }).invoke(null, new Object[] { paramContext });
      if (paramContext != null)
      {
        paramContext = localClass.getMethod("getStaticDataEncryptComp", new Class[0]).invoke(paramContext, new Object[0]);
        if (paramContext != null)
        {
          paramArrayOfByte = (byte[])paramContext.getClass().getMethod("staticBinarySafeEncrypt", new Class[] { Integer.TYPE, String.class, byte[].class, String.class }).invoke(paramContext, new Object[] { Integer.valueOf(paramContext.getClass().getField("OPEN_ENUM_CIPHER_AES128").getInt(null)), paramString1, paramArrayOfByte, paramString2 });
          return paramArrayOfByte;
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      return null;
    }
    return null;
  }
  
  public static String b(String paramString1, String paramString2, String paramString3, Context paramContext)
  {
    String str = "";
    try
    {
      Object localObject1 = Class.forName("com.alibaba.wireless.security.open.SecurityGuardManager");
      Object localObject2 = ((Class)localObject1).getMethod("getInstance", new Class[] { Context.class }).invoke(null, new Object[] { paramContext });
      paramContext = str;
      if (localObject2 != null)
      {
        localObject1 = ((Class)localObject1).getMethod("getStaticDataEncryptComp", new Class[0]).invoke(localObject2, new Object[0]);
        paramContext = str;
        if (localObject1 != null) {
          paramContext = (String)localObject1.getClass().getMethod("staticSafeDecrypt", new Class[] { Integer.TYPE, String.class, String.class, String.class }).invoke(localObject1, new Object[] { Integer.valueOf(localObject1.getClass().getField("OPEN_ENUM_CIPHER_AES128").getInt(null)), paramString2, paramString1, paramString3 });
        }
      }
      return paramContext;
    }
    catch (Exception paramString1) {}
    return "";
  }
  
  public static byte[] b(byte[] paramArrayOfByte, String paramString1, String paramString2, Context paramContext)
  {
    try
    {
      Class localClass = Class.forName("com.alibaba.wireless.security.open.SecurityGuardManager");
      paramContext = localClass.getMethod("getInstance", new Class[] { Context.class }).invoke(null, new Object[] { paramContext });
      if (paramContext != null)
      {
        paramContext = localClass.getMethod("getStaticDataEncryptComp", new Class[0]).invoke(paramContext, new Object[0]);
        if (paramContext != null)
        {
          paramArrayOfByte = (byte[])paramContext.getClass().getMethod("staticBinarySafeDecrypt", new Class[] { Integer.TYPE, String.class, byte[].class, String.class }).invoke(paramContext, new Object[] { Integer.valueOf(paramContext.getClass().getField("OPEN_ENUM_CIPHER_AES128").getInt(null)), paramString1, paramArrayOfByte, paramString2 });
          return paramArrayOfByte;
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      return null;
    }
    return null;
  }
  
  public static String c(String paramString1, String paramString2, String paramString3, Context paramContext)
  {
    Object localObject1 = "";
    try
    {
      Object localObject2 = Class.forName("com.alibaba.wireless.security.open.SecurityGuardManager");
      Object localObject3 = ((Class)localObject2).getMethod("getInstance", new Class[] { Context.class }).invoke(null, new Object[] { paramContext });
      paramContext = (Context)localObject1;
      if (localObject3 != null)
      {
        localObject2 = ((Class)localObject2).getMethod("getSecureSignatureComp", new Class[0]).invoke(localObject3, new Object[0]);
        paramContext = (Context)localObject1;
        if (localObject2 != null)
        {
          paramContext = new HashMap();
          localObject1 = Class.forName("com.alibaba.wireless.security.open.securesignature.SecureSignatureDefine");
          paramContext.put((String)((Class)localObject1).getField("OPEN_KEY_SIGN_INPUT").get(null), paramString1);
          int i = ((Class)localObject1).getField("OPEN_ENUM_SIGN_UMID").getInt(null);
          paramString1 = Class.forName("com.alibaba.wireless.security.open.SecurityGuardParamContext");
          localObject1 = paramString1.getConstructor(new Class[0]).newInstance(new Object[0]);
          paramString1.getField("appKey").set(localObject1, paramString2);
          paramString1.getField("requestType").setInt(localObject1, i);
          paramString1.getField("paramMap").set(localObject1, paramContext);
          paramContext = (String)localObject2.getClass().getMethod("signRequest", new Class[] { paramString1, String.class }).invoke(localObject2, new Object[] { localObject1, paramString3 });
        }
      }
      return paramContext;
    }
    catch (Exception paramString1) {}
    return "";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\dp\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */