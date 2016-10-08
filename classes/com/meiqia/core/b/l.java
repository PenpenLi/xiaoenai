package com.meiqia.core.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.meiqia.core.a;
import com.meiqia.core.c.b;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public class l
{
  public static b a(String paramString, j paramj)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      String str1 = paramj.r();
      paramj.l(paramString);
      String str2 = paramj.e();
      String str3 = paramj.j();
      String str4 = paramj.g();
      String str5 = paramj.h();
      String str6 = paramj.f();
      String str7 = paramj.o();
      if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str4)) && (!TextUtils.isEmpty(str5)) && (!TextUtils.isEmpty(str6)) && (!TextUtils.isEmpty(str7))) {}
      for (int i = 1; i != 0; i = 0)
      {
        b localb = new b();
        localb.f(str4);
        localb.g(str6);
        localb.b(str2);
        localb.d(str3);
        localb.c(str7);
        localb.e(str5);
        localb.a(paramString);
        paramj.l(str1);
        return localb;
      }
    }
  }
  
  public static String a(Context paramContext)
  {
    paramContext = paramContext.getExternalFilesDir(null);
    if (!paramContext.exists()) {
      paramContext.mkdir();
    }
    paramContext = new File(paramContext.getAbsolutePath() + "/mq");
    if (!paramContext.exists()) {
      paramContext.mkdir();
    }
    return paramContext.getAbsolutePath();
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    paramIntent.setPackage(paramContext.getPackageName());
    paramIntent.putExtra("packageName", paramContext.getPackageName());
    LocalBroadcastManager.getInstance(paramContext).sendBroadcast(paramIntent);
  }
  
  public static void a(b paramb, j paramj)
  {
    String str1 = paramb.b();
    String str2 = paramb.e();
    String str3 = paramb.d();
    String str4 = paramb.g();
    String str5 = paramb.f();
    String str6 = paramb.c();
    a(paramb.a(), paramj, str6, str1, str3, str2, str5, str4);
  }
  
  public static void a(String paramString1, j paramj, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    String str = paramj.r();
    paramj.l(paramString1);
    paramj.i(paramString2);
    paramj.b(paramString3);
    paramj.g(paramString4);
    paramj.e(paramString5);
    paramj.d(paramString6);
    paramj.c(paramString7);
    paramj.l(str);
  }
  
  public static boolean a()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static String c(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (paramContext != null)
    {
      int i = paramContext.getType();
      if (i == 0) {
        return h.a(paramContext.getSubtype());
      }
      if (i == 1) {
        return "WIFI";
      }
      return "unknown";
    }
    return "";
  }
  
  public static String d(Context paramContext)
  {
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      paramContext = (String)localPackageManager.getApplicationLabel(localPackageManager.getApplicationInfo(paramContext.getPackageName(), 0));
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  public static Map<String, Object> e(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    try
    {
      localHashMap.put("device_brand", Build.BRAND);
      localHashMap.put("device_model", Build.MODEL + " " + Build.DEVICE);
      localHashMap.put("os_family", "Android");
      localHashMap.put("os_version", Build.VERSION.RELEASE);
      localHashMap.put("resolution", g(paramContext));
      localHashMap.put("net_type", c(paramContext));
      localHashMap.put("app_version", b(paramContext));
      localHashMap.put("sdk_version", a.d());
      localHashMap.put("os_language", Locale.getDefault().getLanguage());
      localHashMap.put("os_timezone", TimeZone.getDefault().getID());
      localHashMap.put("app_name", d(paramContext));
      return localHashMap;
    }
    catch (Exception paramContext) {}
    return localHashMap;
  }
  
  public static boolean f(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if ((paramContext != null) && (paramContext.isAvailable()) && (paramContext.isConnected())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static String g(Context paramContext)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    return paramContext.heightPixels + "x" + paramContext.widthPixels;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\b\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */