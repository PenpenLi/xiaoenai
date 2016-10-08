package com.inmobi.signals.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;

final class c$2
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = c.b();
    paramIntent = (WifiManager)c.d().getSystemService("wifi");
    c.c();
    if (paramContext != null)
    {
      c.a(b.a(paramIntent.getScanResults()));
      paramContext.a(c.e());
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\signals\b\c$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */