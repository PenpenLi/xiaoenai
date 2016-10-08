package com.alibaba.nb.android.trade.utils.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class a
{
  public static boolean a(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.isAvailable()) && (paramContext.isConnected());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\utils\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */