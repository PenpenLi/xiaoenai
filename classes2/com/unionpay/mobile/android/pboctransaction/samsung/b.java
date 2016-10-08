package com.unionpay.mobile.android.pboctransaction.samsung;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.unionpay.client3.tsm.ITsmConnection.Stub;
import com.unionpay.mobile.android.utils.h;

final class b
  implements ServiceConnection
{
  b(a parama) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    h.a("plugin-clientV3", "startSamsungService onServiceConnected");
    try
    {
      a.a(this.a, ITsmConnection.Stub.asInterface(paramIBinder));
      a.a(this.a, true);
      return;
    }
    catch (Exception paramComponentName)
    {
      a.a(this.a, false);
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    h.a("plugin-clientV3", "startSamsungService onServiceDisconnected");
    a.a(this.a, null);
    a.a(this.a, false);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\pboctransaction\samsung\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */