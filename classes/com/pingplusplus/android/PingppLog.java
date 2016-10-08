package com.pingplusplus.android;

import android.util.Log;

public class PingppLog
{
  public static boolean DEBUG = false;
  private static String a = "PING++";
  
  public static void d(String paramString)
  {
    if (DEBUG) {
      Log.d(a, paramString);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\pingplusplus\android\PingppLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */