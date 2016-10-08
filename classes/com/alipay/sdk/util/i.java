package com.alipay.sdk.util;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.alipay.android.app.IAlixPay.Stub;

final class i
  implements ServiceConnection
{
  i(h paramh) {}
  
  public final void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    synchronized (h.a(this.a))
    {
      h.a(this.a, IAlixPay.Stub.asInterface(paramIBinder));
      h.a(this.a).notify();
      return;
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    h.a(this.a, null);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\util\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */