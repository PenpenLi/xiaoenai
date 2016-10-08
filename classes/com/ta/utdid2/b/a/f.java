package com.ta.utdid2.b.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class f
{
  private static ConnectivityManager a = null;
  private static final int[] d = { 4, 7, 2, 1 };
  
  public static ConnectivityManager a(Context paramContext)
  {
    if (paramContext == null)
    {
      Log.e("NetworkUtils", "context is null!");
      return null;
    }
    if (a == null) {
      a = (ConnectivityManager)paramContext.getSystemService("connectivity");
    }
    return a;
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = a(paramContext);
    if (paramContext != null) {
      try
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if (paramContext != null)
        {
          boolean bool = paramContext.isConnected();
          return bool;
        }
      }
      catch (Exception paramContext)
      {
        Log.e("NetworkUtils", paramContext.toString());
      }
    }
    for (;;)
    {
      return false;
      Log.e("NetworkUtils", "connManager is null!");
    }
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool2 = false;
    paramContext = a(paramContext);
    int j;
    int k;
    int i;
    if (paramContext != null) {
      try
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if (paramContext != null)
        {
          j = paramContext.getSubtype();
          if (d.e) {
            Log.d("NetworkUtils", "subType:" + j + ": name:" + paramContext.getSubtypeName());
          }
          paramContext = d;
          k = paramContext.length;
          i = 0;
          break label114;
        }
        Log.e("NetworkUtils", "networkInfo is null!");
        return false;
      }
      catch (Exception paramContext)
      {
        Log.e("NetworkUtils", paramContext.toString());
        return false;
      }
    }
    Log.e("NetworkUtils", "connManager is null!");
    return false;
    for (;;)
    {
      label114:
      boolean bool1 = bool2;
      if (i < k)
      {
        if (paramContext[i] == j) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\ta\utdid2\b\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */