package com.adhoc;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.util.DisplayMetrics;
import java.util.Locale;
import org.json.JSONObject;

public class ac
{
  public static String a()
  {
    String str1 = Build.MANUFACTURER;
    String str2 = Build.MODEL;
    if (str2.startsWith(str1)) {
      return a(str2);
    }
    return a(str1) + " " + str2;
  }
  
  public static String a(String paramString)
  {
    String str;
    if ((paramString == null) || (paramString.length() == 0)) {
      str = "";
    }
    char c;
    do
    {
      return str;
      c = paramString.charAt(0);
      str = paramString;
    } while (Character.isUpperCase(c));
    return Character.toUpperCase(c) + paramString.substring(1);
  }
  
  public static JSONObject a(Context paramContext)
  {
    Object localObject = paramContext.getResources();
    Configuration localConfiguration = ((Resources)localObject).getConfiguration();
    localObject = ((Resources)localObject).getDisplayMetrics();
    WifiInfo localWifiInfo = c(paramContext);
    JSONObject localJSONObject = new JSONObject();
    a(localJSONObject);
    String str = a();
    localJSONObject.put("device_name", str);
    a(localJSONObject, str);
    e(localJSONObject);
    a(localConfiguration, localJSONObject);
    b(localConfiguration, localJSONObject);
    c(localConfiguration, localJSONObject);
    d(localConfiguration, localJSONObject);
    a((DisplayMetrics)localObject, localJSONObject);
    b((DisplayMetrics)localObject, localJSONObject);
    e(paramContext, localJSONObject);
    a(localWifiInfo, localJSONObject);
    a(paramContext, localJSONObject);
    b(paramContext, localJSONObject);
    d(localJSONObject);
    b(localJSONObject);
    c(paramContext, localJSONObject);
    d(paramContext, localJSONObject);
    c(localJSONObject);
    return localJSONObject;
  }
  
  public static void a(Context paramContext, JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("network_state", b(paramContext));
      return;
    }
    catch (Throwable paramContext)
    {
      fl.a(paramContext);
      paramJSONObject.put("network_state", "");
    }
  }
  
  private static void a(Configuration paramConfiguration, JSONObject paramJSONObject)
  {
    paramJSONObject.put("screen_size", paramConfiguration.screenLayout & 0xF);
  }
  
  private static void a(WifiInfo paramWifiInfo, JSONObject paramJSONObject)
  {
    if (paramWifiInfo == null) {}
    for (paramWifiInfo = "";; paramWifiInfo = paramWifiInfo.getMacAddress())
    {
      paramJSONObject.put("wifi_mac", paramWifiInfo);
      return;
    }
  }
  
  private static void a(DisplayMetrics paramDisplayMetrics, JSONObject paramJSONObject)
  {
    paramJSONObject.put("display_width", paramDisplayMetrics.widthPixels);
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    paramJSONObject.put("OS", "google_android");
  }
  
  private static void a(JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject.put("device_model", paramString);
  }
  
  private static boolean a(Context paramContext, String paramString)
  {
    return paramContext.checkCallingOrSelfPermission(paramString) == 0;
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      if (!a(paramContext, "android.permission.ACCESS_NETWORK_STATE")) {
        return "NETWORK_STATE_UNKNOWN";
      }
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      NetworkInfo localNetworkInfo = paramContext.getNetworkInfo(1);
      if ((localNetworkInfo != null) && (localNetworkInfo.isConnected())) {
        return "WIFI_CONNECTED";
      }
      paramContext = paramContext.getNetworkInfo(0);
      if ((paramContext != null) && (paramContext.isConnected())) {
        return "MOBILE_CONNECTED";
      }
      return "NETWORK_UNCONNECTED";
    }
    catch (Throwable paramContext)
    {
      fl.a(paramContext);
    }
    return "NETWORK_STATE_UNKNOWN";
  }
  
  private static String b(String paramString)
  {
    Object localObject = null;
    if (paramString != null)
    {
      localObject = paramString.split("\\.");
      if (localObject.length >= 2) {
        localObject = localObject[0] + "." + localObject[1];
      }
    }
    else
    {
      paramString = (String)localObject;
    }
    return paramString;
  }
  
  private static void b(Context paramContext, JSONObject paramJSONObject)
  {
    paramJSONObject.put("os_version_name", fm.a());
  }
  
  private static void b(Configuration paramConfiguration, JSONObject paramJSONObject)
  {
    paramJSONObject.put("language", paramConfiguration.locale.getLanguage());
  }
  
  private static void b(DisplayMetrics paramDisplayMetrics, JSONObject paramJSONObject)
  {
    paramJSONObject.put("display_height", paramDisplayMetrics.heightPixels);
  }
  
  private static void b(JSONObject paramJSONObject)
  {
    paramJSONObject.put("sdk_api_version", "2.0");
  }
  
  private static WifiInfo c(Context paramContext)
  {
    try
    {
      if (!a(paramContext, "android.permission.ACCESS_WIFI_STATE")) {
        return null;
      }
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      fl.a(paramContext);
    }
    return null;
  }
  
  private static void c(Context paramContext, JSONObject paramJSONObject)
  {
    paramJSONObject.put("package_name", paramContext.getPackageName());
  }
  
  private static void c(Configuration paramConfiguration, JSONObject paramJSONObject)
  {
    paramJSONObject.put("country", paramConfiguration.locale.getCountry());
  }
  
  private static void c(JSONObject paramJSONObject)
  {
    paramJSONObject.put("sdk_version", "2.2.18");
  }
  
  private static void d(Context paramContext, JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("app_version", paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName);
      return;
    }
    catch (Throwable paramContext)
    {
      fl.a(paramContext);
    }
  }
  
  private static void d(Configuration paramConfiguration, JSONObject paramJSONObject)
  {
    if ((paramConfiguration != null) && (paramConfiguration.locale != null)) {
      paramJSONObject.put("locale", paramConfiguration.locale.toString());
    }
  }
  
  private static void d(JSONObject paramJSONObject)
  {
    paramJSONObject.put("os_version", b(fm.a()));
  }
  
  private static void e(Context paramContext, JSONObject paramJSONObject)
  {
    paramJSONObject.put("device_id", Settings.Secure.getString(paramContext.getContentResolver(), "android_id"));
  }
  
  private static void e(JSONObject paramJSONObject)
  {
    paramJSONObject.put("sdk_version", Build.VERSION.SDK_INT);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */