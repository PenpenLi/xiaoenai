package com.alibaba.sdk.android.httpdns;

import android.util.Log;

public class DpaLog
{
  private static final String TAG = "Dpa_";
  private static boolean enableLog;
  
  public static void disableLog()
  {
    enableLog = false;
  }
  
  public static void enableLog()
  {
    enableLog = true;
  }
  
  public static boolean isEnableLog()
  {
    return enableLog;
  }
  
  protected static void logD(String paramString1, String paramString2)
  {
    if (enableLog) {
      Log.d("Dpa_" + paramString1, paramString2);
    }
  }
  
  protected static void logE(String paramString1, String paramString2)
  {
    if (enableLog) {
      Log.e("Dpa_" + paramString1, paramString2);
    }
  }
  
  protected static void logI(String paramString1, String paramString2)
  {
    if (enableLog) {
      Log.i("Dpa_" + paramString1, paramString2);
    }
  }
  
  protected static void logV(String paramString1, String paramString2)
  {
    if (enableLog) {
      Log.v("Dpa_" + paramString1, paramString2);
    }
  }
  
  protected static void logW(String paramString1, String paramString2)
  {
    if (enableLog) {
      Log.w("Dpa_" + paramString1, paramString2);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\httpdns\DpaLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */