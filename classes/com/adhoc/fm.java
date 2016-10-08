package com.adhoc;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

public class fm
{
  public static String a()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static String a(SharedPreferences paramSharedPreferences, String paramString)
  {
    if (paramSharedPreferences != null) {
      return paramSharedPreferences.getString(paramString, "");
    }
    return "";
  }
  
  public static void a(SharedPreferences paramSharedPreferences, String paramString, int paramInt)
  {
    if (paramSharedPreferences == null)
    {
      fl.b("error share is null");
      return;
    }
    paramSharedPreferences = paramSharedPreferences.edit();
    paramSharedPreferences.putInt(paramString, paramInt);
    paramSharedPreferences.commit();
    fl.a("保存到本地信息：key & value " + paramString + "&" + paramInt);
  }
  
  public static void a(SharedPreferences paramSharedPreferences, String paramString, long paramLong)
  {
    if (paramSharedPreferences == null)
    {
      fl.b("error share is null");
      return;
    }
    paramSharedPreferences = paramSharedPreferences.edit();
    paramSharedPreferences.putLong(paramString, paramLong);
    paramSharedPreferences.commit();
    fl.a("保存到本地信息：key & value " + paramString + "&" + paramLong);
  }
  
  public static void a(SharedPreferences paramSharedPreferences, String paramString1, String paramString2)
  {
    if (paramSharedPreferences == null)
    {
      fl.b("error share is null");
      return;
    }
    paramSharedPreferences = paramSharedPreferences.edit();
    paramSharedPreferences.putString(paramString1, paramString2);
    paramSharedPreferences.commit();
    fl.a("保存到本地信息：key & value " + paramString1 + "&" + paramString2);
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return true;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.isConnectedOrConnecting());
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      if (paramContext == null)
      {
        fl.a(" 没有 tester ");
        return false;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      fl.a("没有tester");
      return false;
    }
    return true;
  }
  
  public static int b(SharedPreferences paramSharedPreferences, String paramString)
  {
    int i = 0;
    if (paramSharedPreferences != null) {
      i = paramSharedPreferences.getInt(paramString, 0);
    }
    return i;
  }
  
  public static a b(Context paramContext)
  {
    Object localObject = a.a;
    if (paramContext == null)
    {
      localObject = a.a;
      return (a)localObject;
    }
    for (;;)
    {
      try
      {
        paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (paramContext == null) {
          return a.a;
        }
        str = paramContext.getTypeName().toLowerCase();
        if (str.equals("wifi"))
        {
          paramContext = a.b;
          if (str != null) {
            localObject = paramContext;
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        String str;
        paramContext = (Context)localObject;
        localObject = localThrowable2;
      }
      try
      {
        if (!str.equals("")) {
          break;
        }
        localObject = a.a;
        return (a)localObject;
      }
      catch (Throwable localThrowable1)
      {
        for (;;) {}
      }
      paramContext = a.c;
    }
    fl.a((Throwable)localObject);
    return paramContext;
  }
  
  public static long c(SharedPreferences paramSharedPreferences, String paramString)
  {
    long l = 0L;
    if (paramSharedPreferences != null) {
      l = paramSharedPreferences.getLong(paramString, 0L);
    }
    return l;
  }
  
  public static SharedPreferences c(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    return paramContext.getSharedPreferences("ADHOC_SHARED_PREFERENCE", 0);
  }
  
  public static boolean d(Context paramContext)
  {
    if (paramContext == null) {
      return true;
    }
    long l = System.currentTimeMillis();
    Object localObject = (ActivityManager)paramContext.getApplicationContext().getSystemService("activity");
    paramContext = paramContext.getApplicationContext().getPackageName();
    localObject = ((ActivityManager)localObject).getRunningAppProcesses();
    if (localObject == null) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if ((localRunningAppProcessInfo.processName.equals(paramContext)) && (localRunningAppProcessInfo.importance == 100)) {
        return true;
      }
    }
    System.out.println(System.currentTimeMillis() - l);
    return false;
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\fm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */