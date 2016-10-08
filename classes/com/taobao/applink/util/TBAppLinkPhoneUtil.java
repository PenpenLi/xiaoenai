package com.taobao.applink.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import java.util.Random;

@TargetApi(9)
public class TBAppLinkPhoneUtil
{
  public static final String IMEI = "imei";
  public static final String IMSI = "imsi";
  public static final String MACADDRESS = "mac_address";
  private static String phone_imei = "";
  private static String phone_imsi = "";
  private static String phone_wifiaddr = "";
  
  private static String generateImei()
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
  
  public static String getImei(Context paramContext)
  {
    if (!TextUtils.isEmpty(phone_imei)) {
      return phone_imei;
    }
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("imei", 0);
    Object localObject1 = localSharedPreferences.getString("imei", null);
    if ((localObject1 == null) || (((String)localObject1).length() == 0)) {}
    for (;;)
    {
      Object localObject2;
      try
      {
        String str = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
        if (str != null)
        {
          paramContext = str;
          localObject1 = str;
          if (str.length() != 0) {}
        }
        else
        {
          localObject1 = str;
          paramContext = generateImei();
        }
        localObject1 = paramContext;
        paramContext = paramContext.replaceAll(" ", "").trim();
        try
        {
          if (paramContext.length() < 15)
          {
            localObject1 = "0" + paramContext;
            paramContext = (Context)localObject1;
            continue;
          }
          localObject1 = localSharedPreferences.edit();
          ((SharedPreferences.Editor)localObject1).putString("imei", paramContext);
          if (Build.VERSION.SDK_INT >= 9)
          {
            ((SharedPreferences.Editor)localObject1).apply();
            phone_imei = paramContext.trim();
            return phone_imei;
          }
          ((SharedPreferences.Editor)localObject1).commit();
          continue;
          Log.d("AppLink", localThrowable1.toString());
        }
        catch (Throwable localThrowable1) {}
      }
      catch (Throwable localThrowable2)
      {
        paramContext = localThrowable1;
        localObject2 = localThrowable2;
        continue;
      }
      continue;
      paramContext = (Context)localObject2;
    }
  }
  
  public static String getImsi(Context paramContext)
  {
    if (!TextUtils.isEmpty(phone_imsi)) {
      return phone_imsi;
    }
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("imei", 0);
    Object localObject1 = localSharedPreferences.getString("imsi", null);
    if ((localObject1 == null) || (((String)localObject1).length() == 0)) {}
    for (;;)
    {
      Object localObject2;
      try
      {
        String str = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
        if (str != null)
        {
          paramContext = str;
          localObject1 = str;
          if (str.length() != 0) {}
        }
        else
        {
          localObject1 = str;
          paramContext = generateImei();
        }
        localObject1 = paramContext;
        paramContext = paramContext.replaceAll(" ", "").trim();
        try
        {
          if (paramContext.length() < 15)
          {
            localObject1 = "0" + paramContext;
            paramContext = (Context)localObject1;
            continue;
          }
          localObject1 = localSharedPreferences.edit();
          ((SharedPreferences.Editor)localObject1).putString("imsi", paramContext);
          if (Build.VERSION.SDK_INT >= 9)
          {
            ((SharedPreferences.Editor)localObject1).apply();
            phone_imsi = paramContext;
            return phone_imsi;
          }
          ((SharedPreferences.Editor)localObject1).commit();
          continue;
          Log.d("AppLink", localThrowable1.toString());
        }
        catch (Throwable localThrowable1) {}
      }
      catch (Throwable localThrowable2)
      {
        paramContext = localThrowable1;
        localObject2 = localThrowable2;
        continue;
      }
      continue;
      paramContext = (Context)localObject2;
    }
  }
  
  public static String getOriginalImei(Context paramContext)
  {
    try
    {
      String str = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      paramContext = str;
      if (str != null) {
        paramContext = str.trim();
      }
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      Log.d("AppLink", paramContext.toString());
    }
    return null;
  }
  
  public static String getOriginalImsi(Context paramContext)
  {
    try
    {
      String str = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
      paramContext = str;
      if (str != null) {
        paramContext = str.trim();
      }
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      Log.d("AppLink", paramContext.toString());
    }
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\applink\util\TBAppLinkPhoneUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */