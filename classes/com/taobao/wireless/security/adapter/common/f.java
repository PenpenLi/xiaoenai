package com.taobao.wireless.security.adapter.common;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent;
import java.util.Random;

public final class f
{
  private static final Object a = new Object();
  
  public static String a()
  {
    return "111111111111111";
  }
  
  private static String a(Context paramContext, String paramString)
  {
    Object localObject = null;
    if (paramString.length() == 0) {}
    String str;
    do
    {
      return (String)localObject;
      str = SPUtility2.readFromSPUnified(paramString, paramString, null);
      if (str == null) {
        break;
      }
      localObject = str;
    } while (str.length() > 0);
    localObject = b(paramContext, paramString);
    if ((localObject == null) || (((String)localObject).length() <= 0))
    {
      localObject = c();
      SPUtility2.saveToSPUnified(paramString, paramString, (String)localObject, true);
      a(paramContext, (String)localObject, paramString);
      return (String)localObject;
    }
    SPUtility2.saveToSPUnified(paramString, paramString, (String)localObject, true);
    return (String)localObject;
  }
  
  private static String a(String paramString)
  {
    char[] arrayOfChar = new char[16];
    char[] tmp6_5 = arrayOfChar;
    tmp6_5[0] = 48;
    char[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 49;
    char[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 50;
    char[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 51;
    char[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 52;
    char[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 53;
    char[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 54;
    char[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 55;
    char[] tmp48_42 = tmp42_36;
    tmp48_42[8] = 56;
    char[] tmp54_48 = tmp48_42;
    tmp54_48[9] = 57;
    char[] tmp60_54 = tmp54_48;
    tmp60_54[10] = 97;
    char[] tmp66_60 = tmp60_54;
    tmp66_60[11] = 98;
    char[] tmp72_66 = tmp66_60;
    tmp72_66[12] = 99;
    char[] tmp78_72 = tmp72_66;
    tmp78_72[13] = 100;
    char[] tmp84_78 = tmp78_72;
    tmp84_78[14] = 101;
    char[] tmp90_84 = tmp84_78;
    tmp90_84[15] = 102;
    tmp90_84;
    paramString = paramString.getBytes();
    int j = paramString.length;
    StringBuilder localStringBuilder = new StringBuilder(j * 2);
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(arrayOfChar[(paramString[i] >> 4 & 0xF)]);
      localStringBuilder.append(arrayOfChar[(paramString[i] & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    String str1 = paramContext.getPackageName();
    paramContext.getContentResolver();
    String str2 = a(str1);
    try
    {
      str1 = SecurityGuardManager.getInstance(paramContext).getStaticDataEncryptComp().staticSafeEncrypt(16, "wb_sc_int_res_k1", paramString1, "");
      paramString1 = str1;
    }
    catch (SecException localSecException)
    {
      for (;;)
      {
        localSecException.printStackTrace();
      }
    }
    if ((str2 != null) && (paramContext != null) && (paramString1 != null) && (paramString1.length() > 0))
    {
      SPUtility2.writeSS(paramContext, str2 + paramString2, paramString1);
      return true;
    }
    return false;
  }
  
  public static String[] a(Context paramContext)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    synchronized (a)
    {
      arrayOfString[0] = a(paramContext, "dynamicreid");
      arrayOfString[1] = a(paramContext, "dynamicrsid");
      return arrayOfString;
    }
  }
  
  public static String b()
  {
    return "111111111111111";
  }
  
  private static String b(Context paramContext, String paramString)
  {
    String str = a(paramContext.getPackageName());
    if ((str != null) && (paramContext != null))
    {
      paramString = SPUtility2.readSS(paramContext, str + paramString);
      if ((paramString == null) || (paramString.length() <= 0)) {}
    }
    try
    {
      paramContext = SecurityGuardManager.getInstance(paramContext).getStaticDataEncryptComp().staticSafeDecrypt(16, "wb_sc_int_res_k1", paramString, "");
      if ((paramContext != null) && (paramContext.length() <= 0)) {
        return null;
      }
    }
    catch (SecException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = paramString;
      }
    }
    return paramContext;
  }
  
  public static String[] b(Context paramContext)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    synchronized (a)
    {
      arrayOfString[0] = c(paramContext);
      arrayOfString[1] = d(paramContext);
      return arrayOfString;
    }
  }
  
  private static String c()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    long l = System.currentTimeMillis();
    Object localObject = Long.toString(l);
    localStringBuffer.append(((String)localObject).substring(((String)localObject).length() - 5));
    localObject = new StringBuffer();
    ((StringBuffer)localObject).append(Build.MODEL.replaceAll(" ", ""));
    while (((StringBuffer)localObject).length() < 6) {
      ((StringBuffer)localObject).append('0');
    }
    localStringBuffer.append(((StringBuffer)localObject).substring(0, 6));
    localObject = new Random(l);
    for (l = 0L; l < 4096L; l = ((Random)localObject).nextLong()) {}
    localStringBuffer.append(Long.toHexString(l).substring(0, 4));
    return localStringBuffer.toString();
  }
  
  private static String c(Context paramContext)
  {
    String str = SPUtility2.readFromSPUnified("imei", "imei", null);
    Object localObject;
    if (str != null)
    {
      localObject = str;
      if (str.length() != 0) {}
    }
    else
    {
      try
      {
        paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
        if (paramContext != null)
        {
          localObject = paramContext;
          if (paramContext.length() != 0) {
            break label52;
          }
        }
        label52:
        for (localObject = c(); ((String)localObject).length() < 15; localObject = "0" + (String)localObject) {}
      }
      catch (SecurityException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
          paramContext = null;
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
          paramContext = null;
        }
        SPUtility2.saveToSPUnified("imei", "imei", (String)localObject, true);
      }
    }
    return ((String)localObject).trim();
  }
  
  private static String d(Context paramContext)
  {
    String str = SPUtility2.readFromSPUnified("imsi", "imsi", null);
    Object localObject;
    if (str != null)
    {
      localObject = str;
      if (str.length() != 0) {}
    }
    else
    {
      try
      {
        paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
        if (paramContext != null)
        {
          localObject = paramContext;
          if (paramContext.length() != 0) {
            break label52;
          }
        }
        label52:
        for (localObject = c(); ((String)localObject).length() < 15; localObject = "0" + (String)localObject) {}
      }
      catch (SecurityException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
          paramContext = null;
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
          paramContext = null;
        }
        SPUtility2.saveToSPUnified("imsi", "imsi", (String)localObject, true);
      }
    }
    return (String)localObject;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\wireless\security\adapter\common\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */