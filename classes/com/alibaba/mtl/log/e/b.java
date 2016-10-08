package com.alibaba.mtl.log.e;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import com.alibaba.mtl.log.a;
import java.util.Iterator;
import java.util.List;

public class b
{
  private static String af = "";
  private static String b;
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    int i = Process.myPid();
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.pid == i) {
        return localRunningAppProcessInfo.processName;
      }
    }
    return null;
  }
  
  public static boolean b(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      Object localObject = (ActivityManager)paramContext.getSystemService("activity");
      PowerManager localPowerManager = (PowerManager)paramContext.getSystemService("power");
      paramContext = paramContext.getPackageName();
      localObject = ((ActivityManager)localObject).getRunningAppProcesses().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if (localRunningAppProcessInfo.processName.equals(paramContext))
        {
          if (localRunningAppProcessInfo.importance == 400) {
            return false;
          }
          boolean bool = localPowerManager.isScreenOn();
          if (bool) {
            return true;
          }
        }
      }
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  public static String getAppkey()
  {
    return b;
  }
  
  public static String j()
  {
    if (a.getContext() == null) {
      return "";
    }
    try
    {
      String str1 = a.getContext().getSharedPreferences("UTCommon", 0).getString("_lun", "");
      if (!TextUtils.isEmpty(str1))
      {
        str1 = new String(c.decode(str1.getBytes(), 2), "UTF-8");
        return str1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2 = "";
        continue;
        str2 = "";
      }
    }
  }
  
  public static String k()
  {
    if (a.getContext() == null) {
      return "";
    }
    try
    {
      String str = a.getContext().getSharedPreferences("UTCommon", 0).getString("_luid", "");
      if (!TextUtils.isEmpty(str))
      {
        str = new String(c.decode(str.getBytes(), 2), "UTF-8");
        return str;
      }
    }
    catch (Exception localException)
    {
      return "";
    }
    return "";
  }
  
  public static String l()
  {
    return af;
  }
  
  public static String m()
  {
    return "";
  }
  
  public static String n()
  {
    return "";
  }
  
  public static void q(String paramString)
  {
    i.a("AppInfoUtil", new Object[] { "[setChannle]", paramString });
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      i = paramString.indexOf("@");
      if (i == -1) {
        af = paramString;
      }
    }
    else
    {
      return;
    }
    af = paramString.substring(0, i);
  }
  
  public static void r(String paramString)
  {
    i.a("AppInfoUtil", new Object[] { "set Appkey:", paramString });
    b = paramString;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\log\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */