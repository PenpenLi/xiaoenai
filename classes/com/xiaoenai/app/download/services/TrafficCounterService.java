package com.xiaoenai.app.download.services;

import android.app.Service;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import com.xiaoenai.app.download.c.a;
import java.util.Timer;
import java.util.TimerTask;

public class TrafficCounterService
  extends Service
{
  private Timer a;
  private TimerTask b;
  private ConnectivityManager c;
  private TelephonyManager d;
  private int e;
  private String f;
  private long g;
  private long h;
  private long i;
  private long j;
  private NetworkInfo k;
  
  private void a()
  {
    if (Build.VERSION.SDK_INT >= 8)
    {
      this.g = TrafficStats.getUidTxBytes(this.e);
      this.h = TrafficStats.getUidRxBytes(this.e);
    }
    this.k = this.c.getActiveNetworkInfo();
    if (this.k != null)
    {
      if (!this.k.getTypeName().equalsIgnoreCase("MOBILE")) {
        break label132;
      }
      if (this.g != -1L)
      {
        a.b(this, "tx_mobile", this.g - this.i);
        this.i = this.g;
      }
      if (this.h != -1L)
      {
        a.b(this, "tx_mobile", this.h - this.j);
        this.j = this.h;
      }
    }
    label132:
    do
    {
      return;
      if (this.g != -1L)
      {
        a.b(this, "tx_wifi", this.g - this.i);
        this.i = this.g;
      }
    } while (this.h == -1L);
    a.b(this, "rx_wifi", this.h - this.j);
    this.j = this.h;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    this.c = ((ConnectivityManager)getSystemService("connectivity"));
    this.d = ((TelephonyManager)getSystemService("phone"));
    PackageManager localPackageManager = getPackageManager();
    try
    {
      this.e = localPackageManager.getApplicationInfo(getPackageName(), 128).uid;
      this.a = new Timer();
      this.b = new e(this);
      if ((this.a != null) && (this.b != null))
      {
        if (Build.VERSION.SDK_INT >= 8)
        {
          this.g = TrafficStats.getUidTxBytes(this.e);
          this.h = TrafficStats.getUidRxBytes(this.e);
        }
        this.a.schedule(this.b, 0L, 1000L);
        this.f = this.d.getNetworkOperatorName();
        if (!a.a(this, "operator_name").equals(this.f))
        {
          a.a(this, "operator_name", this.f);
          a.a(this, "tx_mobile", 0L);
          a.a(this, "tx_mobile", 0L);
        }
      }
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
      }
    }
  }
  
  public void onDestroy()
  {
    a();
    if (this.b != null) {
      this.b.cancel();
    }
    if (this.a != null)
    {
      this.a.cancel();
      this.a.purge();
    }
  }
  
  public void onStart(Intent paramIntent, int paramInt) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\download\services\TrafficCounterService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */