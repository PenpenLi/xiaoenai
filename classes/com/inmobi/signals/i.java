package com.inmobi.signals;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.inmobi.commons.core.c.e;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.d;
import com.inmobi.signals.b.c;
import java.util.ArrayList;
import java.util.List;

class i
{
  private static final String a = i.class.getSimpleName();
  private HandlerThread b = new HandlerThread("DataCollectionHandler");
  private a c;
  
  public i()
  {
    this.b.start();
    this.c = new a(this.b.getLooper());
  }
  
  public void a()
  {
    for (;;)
    {
      try
      {
        if ((Build.VERSION.SDK_INT < 14) && (!b()))
        {
          Logger.a(Logger.InternalLogLevel.INTERNAL, a, "User data collection can not be started as the data collector is not properly initialized.");
          return;
        }
        if (!this.c.hasMessages(3))
        {
          this.c.removeMessages(2);
          this.c.sendEmptyMessage(1);
        }
        else
        {
          Logger.a(Logger.InternalLogLevel.INTERNAL, a, "User data collection already running.");
        }
      }
      finally {}
    }
  }
  
  public boolean b()
  {
    return d.a("signals", "android.permission.GET_TASKS");
  }
  
  public void c()
  {
    this.c.sendEmptyMessageDelayed(2, o.a().e().c() * 1000);
  }
  
  static class a
    extends Handler
  {
    private List<m> a = new ArrayList();
    
    a(Looper paramLooper)
    {
      super();
    }
    
    private void a(l paraml)
    {
      p.b localb = o.a().e();
      new j(new k(localb.e(), localb.f(), localb.g(), o.a().d(), paraml)).a();
    }
    
    private void a(m paramm)
    {
      if ((this.a != null) && (paramm.a()))
      {
        this.a.add(paramm);
        if (this.a.size() > o.a().e().d())
        {
          com.inmobi.commons.core.c.a.a().a(new e("signals", "SampleSizeExceeded"));
          while (this.a.size() > o.a().e().d()) {
            this.a.remove(0);
          }
        }
      }
    }
    
    public static boolean a()
    {
      ActivityManager localActivityManager = (ActivityManager)com.inmobi.commons.a.a.b().getSystemService("activity");
      if (localActivityManager != null) {
        try
        {
          if (((ActivityManager.RunningTaskInfo)localActivityManager.getRunningTasks(1).get(0)).topActivity.getPackageName().equalsIgnoreCase(com.inmobi.commons.a.a.b().getPackageName()))
          {
            Logger.a(Logger.InternalLogLevel.INTERNAL, i.d(), "Is app in foreground check for below ICS: true");
            return true;
          }
        }
        catch (NullPointerException localNullPointerException)
        {
          Logger.a(Logger.InternalLogLevel.INTERNAL, i.d(), "NPE while determining if app is in foreground for below ICS devices.", localNullPointerException);
        }
      }
      return false;
    }
    
    private void b()
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, i.d(), "User data collection started.");
      sendEmptyMessage(3);
    }
    
    private void c()
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, i.d(), "Stopping user data collection.");
      com.inmobi.signals.activityrecognition.b.a().c();
      removeMessages(3);
      sendEmptyMessage(4);
    }
    
    private void d()
    {
      m localm = new m();
      localm.a(com.inmobi.signals.b.b.a());
      localm.a(LocationInfo.a().f());
      if ((o.a().e().k()) && (com.inmobi.signals.b.b.c()))
      {
        if (!c.a(new i.a.1(this, localm))) {
          a(localm);
        }
        return;
      }
      a(localm);
    }
    
    private l e()
    {
      l locall = new l();
      locall.a(LocationInfo.a().e());
      locall.a(this.a);
      locall.a(n.a().d());
      locall.b(com.inmobi.signals.activityrecognition.b.a().d());
      return locall;
    }
    
    private void f()
    {
      com.inmobi.signals.activityrecognition.b.a().e();
      this.a = new ArrayList();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1: 
        b();
        return;
      case 2: 
        c();
        return;
      case 3: 
        Logger.a(Logger.InternalLogLevel.INTERNAL, i.d(), "Polling for samples.");
        if ((Build.VERSION.SDK_INT < 14) && (!a()))
        {
          sendEmptyMessage(2);
          return;
        }
        if (o.a().e().q()) {
          com.inmobi.signals.activityrecognition.b.a().b();
        }
        for (;;)
        {
          d();
          sendEmptyMessageDelayed(3, o.a().e().b() * 1000);
          return;
          com.inmobi.signals.activityrecognition.b.a().c();
        }
      }
      a(e());
      f();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\signals\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */