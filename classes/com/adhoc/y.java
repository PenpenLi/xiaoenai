package com.adhoc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;

class y
  extends BroadcastReceiver
{
  y(w paramw) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      if ("android.net.wifi.STATE_CHANGE".equals(paramIntent.getAction()))
      {
        paramIntent = paramIntent.getParcelableExtra("networkInfo");
        if (paramIntent != null) {
          if (((NetworkInfo)paramIntent).getState() != NetworkInfo.State.CONNECTED) {
            break label50;
          }
        }
      }
      label50:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          w.a().b(paramContext);
        }
        return;
      }
      return;
    }
    catch (Throwable paramContext)
    {
      fl.b("reg receiver wrong");
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */