package com.inmobi.signals.activityrecognition;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.d;
import com.inmobi.signals.o;
import com.inmobi.signals.p.b;
import java.util.ArrayList;
import java.util.List;

public class b
{
  private static final String a = b.class.getSimpleName();
  private static final Object b = new Object();
  private static volatile b c;
  private static List<a> d;
  private HandlerThread e;
  private Handler f;
  
  private b()
  {
    d = new ArrayList();
    this.e = new HandlerThread("ActivityRecognitionSampler");
    this.e.start();
    this.f = new a(this.e.getLooper());
  }
  
  public static b a()
  {
    Object localObject1 = c;
    if (localObject1 == null) {
      synchronized (b)
      {
        b localb2 = c;
        localObject1 = localb2;
        if (localb2 == null)
        {
          localObject1 = new b();
          c = (b)localObject1;
        }
        return (b)localObject1;
      }
    }
    return localb1;
  }
  
  private static boolean h()
  {
    if (!d.a("signals", "com.google.android.gms.permission.ACTIVITY_RECOGNITION"))
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Activity recognition sampling did not work due to missing permission.");
      return false;
    }
    return true;
  }
  
  private static boolean i()
  {
    if (com.inmobi.commons.a.a.b().getPackageManager().queryIntentServices(new Intent(com.inmobi.commons.a.a.b(), ActivityRecognitionManager.class), 65536).size() > 0) {
      return true;
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Activity recognition sampling did not work due to missing service in manifest.");
    return false;
  }
  
  public void b()
  {
    if ((!h()) || (!i())) {}
    while (this.f.hasMessages(0)) {
      return;
    }
    ActivityRecognitionManager.a();
    this.f.sendEmptyMessage(0);
  }
  
  public void c()
  {
    if ((!h()) || (!i())) {}
    while (!this.f.hasMessages(0)) {
      return;
    }
    ActivityRecognitionManager.b();
    this.f.removeMessages(0);
  }
  
  public List<a> d()
  {
    return d;
  }
  
  public void e()
  {
    d = new ArrayList();
  }
  
  static class a
    extends Handler
  {
    a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        return;
        int i = ActivityRecognitionManager.c();
        Logger.a(Logger.InternalLogLevel.INTERNAL, b.f(), "Polling for ActivityRecognition. Detected activity:" + i);
        if (i != -1) {
          b.g().add(new a(i, System.currentTimeMillis()));
        }
      } while (b.g().size() >= o.a().e().s());
      sendEmptyMessageDelayed(0, o.a().e().r() * 1000);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\signals\activityrecognition\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */