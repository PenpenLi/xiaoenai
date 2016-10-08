package com.unionpay.mobile.android.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class PreferenceUtils
{
  public static String a(Context paramContext)
  {
    return d(paramContext, paramContext.getSharedPreferences("UnionPayPluginEx.pref", 3).getString("uid", ""));
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramString = e(paramContext, paramString);
    paramContext = paramContext.getSharedPreferences("UnionPayPluginEx.pref", 3).edit();
    paramContext.putString("uid", paramString);
    paramContext.commit();
  }
  
  public static String b(Context paramContext)
  {
    return d(paramContext, paramContext.getSharedPreferences("UnionPayPluginEx.pref", 3).getString("last_pay_method", ""));
  }
  
  public static void b(Context paramContext, String paramString)
  {
    paramString = e(paramContext, paramString);
    paramContext = paramContext.getSharedPreferences("UnionPayPluginEx.pref", 3).edit();
    paramContext.putString("last_pay_method", paramString);
    paramContext.commit();
  }
  
  public static String c(Context paramContext)
  {
    return d(paramContext, paramContext.getSharedPreferences("UnionPayPluginEx.pref", 3).getString("last_user", ""));
  }
  
  public static void c(Context paramContext, String paramString)
  {
    paramString = e(paramContext, paramString);
    paramContext = paramContext.getSharedPreferences("UnionPayPluginEx.pref", 3).edit();
    paramContext.putString("last_user", paramString);
    paramContext.commit();
  }
  
  private static String d(Context paramContext, String paramString)
  {
    paramContext = c.b(paramContext);
    paramString = decPrefData(paramString, (paramContext + "23456789abcdef12123456786789abcd").substring(0, 32));
    if (paramString == null) {
      return "";
    }
    if (!paramString.endsWith(paramContext)) {
      return "";
    }
    return paramString.substring(0, paramString.length() - paramContext.length());
  }
  
  public static native String decPrefData(String paramString1, String paramString2);
  
  private static String e(Context paramContext, String paramString)
  {
    paramContext = c.b(paramContext);
    String str = (paramContext + "23456789abcdef12123456786789abcd").substring(0, 32);
    paramString = encPrefData(paramString + paramContext, str);
    paramContext = paramString;
    if (paramString == null) {
      paramContext = "";
    }
    return paramContext;
  }
  
  public static native String encPrefData(String paramString1, String paramString2);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\unionpay\mobile\android\utils\PreferenceUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */