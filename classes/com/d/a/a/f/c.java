package com.d.a.a.f;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class c
  implements a, b
{
  private a.a a;
  
  public c(Context paramContext)
  {
    paramContext.getApplicationContext().registerReceiver(new d(this), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
  }
  
  public void a(a.a parama)
  {
    this.a = parama;
  }
  
  public boolean a(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.isConnectedOrConnecting());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\d\a\a\f\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */