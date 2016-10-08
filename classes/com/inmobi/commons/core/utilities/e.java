package com.inmobi.commons.core.utilities;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.PowerManager;
import com.inmobi.commons.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class e
{
  private static final String a = e.class.getSimpleName();
  private static HashMap<String, ArrayList<b>> b = new HashMap();
  private static HashMap<String, a> c = new HashMap();
  private static final Object d = new Object();
  private static volatile e e;
  
  public static e a()
  {
    Object localObject1 = e;
    if (localObject1 == null) {
      synchronized (d)
      {
        e locale2 = e;
        localObject1 = locale2;
        if (locale2 == null)
        {
          localObject1 = new e();
          e = (e)localObject1;
        }
        return (e)localObject1;
      }
    }
    return locale1;
  }
  
  private void a(String paramString)
  {
    a locala = new a();
    c.put(paramString, locala);
    a.b().registerReceiver(locala, new IntentFilter(paramString));
  }
  
  private void b(String paramString)
  {
    a.b().unregisterReceiver((BroadcastReceiver)c.get(paramString));
    c.remove(paramString);
  }
  
  private static void b(boolean paramBoolean, String paramString)
  {
    paramString = (ArrayList)b.get(paramString);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        ((b)paramString.next()).b(paramBoolean);
      }
    }
  }
  
  public void a(b paramb, String paramString)
  {
    ArrayList localArrayList = (ArrayList)b.get(paramString);
    if (localArrayList != null)
    {
      localArrayList.remove(paramb);
      if (localArrayList.size() == 0) {
        b(paramString);
      }
    }
  }
  
  public void a(String paramString, b paramb)
  {
    ArrayList localArrayList = (ArrayList)b.get(paramString);
    if (localArrayList != null) {
      localArrayList.add(paramb);
    }
    for (paramb = localArrayList;; paramb = localArrayList)
    {
      b.put(paramString, paramb);
      if (paramb.size() == 1) {
        a(paramString);
      }
      return;
      localArrayList = new ArrayList();
      localArrayList.add(paramb);
    }
  }
  
  static final class a
    extends BroadcastReceiver
  {
    private static final String a = a.class.getSimpleName();
    
    @TargetApi(23)
    private boolean a(Context paramContext)
    {
      paramContext = (PowerManager)paramContext.getSystemService("power");
      return (paramContext != null) && (Build.VERSION.SDK_INT >= 23) && (paramContext.isDeviceIdleMode());
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      boolean bool;
      if ((paramIntent != null) && (paramIntent.getAction() != null))
      {
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction())) {
          break label99;
        }
        paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (paramContext == null) {
          break label120;
        }
        paramContext = paramContext.getActiveNetworkInfo();
        if ((paramContext == null) || (!paramContext.isConnected())) {
          break label120;
        }
        bool = true;
      }
      for (;;)
      {
        e.a(bool, paramIntent.getAction());
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, paramIntent.getAction() + " Availability:" + bool);
        return;
        label99:
        if ("android.os.action.DEVICE_IDLE_MODE_CHANGED".equalsIgnoreCase(paramIntent.getAction())) {
          bool = a(paramContext);
        } else {
          label120:
          bool = false;
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void b(boolean paramBoolean);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\utilities\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */