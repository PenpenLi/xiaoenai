package com.alibaba.sdk.android.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.alibaba.sdk.android.AlibabaSDK;
import com.alibaba.sdk.android.trace.AliSDKLogger;

public final class TraceHelper
{
  private static final String DEFAULT_CHANNEL = "0";
  private static final String TAG = TraceHelper.class.getSimpleName();
  public static String channel = "0";
  public static String clientTTID;
  public static int ttidVersion = 2;
  public static String webTTID;
  
  static
  {
    clientTTID = "2014@taobao_h5_3.0.0";
    webTTID = clientTTID;
  }
  
  private static boolean checkChannel(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramString.length()) {
        break label72;
      }
      int j = paramString.charAt(i);
      if (((j < 48) || (j > 57)) && ((j < 97) || (j > 122)) && ((j < 65) || (j > 90))) {
        break;
      }
      i += 1;
    }
    label72:
    return true;
  }
  
  private static String getChannel(Context paramContext)
  {
    try
    {
      String str1 = AlibabaSDK.getProperty("kernel", "channel");
      if ((str1 != null) && (str1.length() > 0))
      {
        String str2 = AlibabaSDK.getProperty("kernel", "channelType");
        paramContext = str1;
        if (str2 != null)
        {
          paramContext = str1;
          if (str2.length() > 0)
          {
            if (str2.equals("umeng")) {
              return "u" + str1;
            }
            if (str2.equals("baidu")) {
              return "b" + str1;
            }
            return "0" + str1;
          }
        }
      }
      else
      {
        str1 = getMetaConfig(paramContext, "ALISDK_CHANNEL");
        if ((str1 != null) && (str1.length() > 0)) {
          return "0" + str1;
        }
        paramContext = getMetaConfig(paramContext, "UMENG_CHANNEL");
        if ((paramContext != null) && (paramContext.length() > 0))
        {
          paramContext = "u" + paramContext;
          return paramContext;
        }
      }
    }
    catch (RuntimeException paramContext)
    {
      AliSDKLogger.e(TAG, "getChannel error: " + paramContext.getMessage(), paramContext);
      paramContext = "0";
    }
    return paramContext;
  }
  
  private static String getMetaConfig(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 16512).applicationInfo;
      if (paramContext.metaData != null)
      {
        paramContext = paramContext.metaData.get(paramString);
        if (paramContext != null)
        {
          paramContext = paramContext.toString();
          return paramContext;
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AliSDKLogger.d("Meta config not found: " + paramString);
    }
    return "";
  }
  
  public static void init(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (paramString2 != null) {}
    for (;;)
    {
      try
      {
        if (paramString2.length() != 0) {
          break label195;
        }
        paramContext = getChannel(paramContext);
        paramString2 = paramContext;
        if (!checkChannel(paramContext))
        {
          AliSDKLogger.e(7, "kernel", "initChannel", "Channel chars must in [0-9][a-z][A-Z], now : " + paramContext);
          paramString2 = "0";
        }
        channel = paramString2;
        int i = ttidVersion;
        switch (i)
        {
        }
      }
      catch (RuntimeException paramContext)
      {
        AliSDKLogger.e(TAG, "init trace info error: " + paramContext.getMessage(), paramContext);
        continue;
      }
      finally {}
      return;
      clientTTID = String.format("2014@taobao_h5_3.0.0$%s", new Object[] { paramString1 });
      webTTID = clientTTID;
      continue;
      clientTTID = String.format("2014_%s_%s@baichuan_android_%s", new Object[] { channel, paramString1, paramString3 });
      webTTID = clientTTID;
      continue;
      label195:
      paramContext = paramString2;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\util\TraceHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */