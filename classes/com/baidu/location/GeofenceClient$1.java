package com.baidu.location;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Messenger;

class GeofenceClient$1
  implements ServiceConnection
{
  GeofenceClient$1(GeofenceClient paramGeofenceClient) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    GeofenceClient.jdMethod_if(this.a, new Messenger(paramIBinder));
    if (GeofenceClient.jdMethod_if(this.a) == null) {
      return;
    }
    GeofenceClient.jdMethod_if(this.a, true);
    this.a.startGeofenceScann();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    GeofenceClient.jdMethod_if(this.a, null);
    GeofenceClient.jdMethod_if(this.a, false);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\GeofenceClient$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */