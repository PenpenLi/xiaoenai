package com.adhoc;

import android.content.Context;
import android.os.Build.VERSION;
import com.adhoc.adhocsdk.AdhocTracker;

public final class f
  implements Runnable
{
  public f(String paramString, Context paramContext) {}
  
  public void run()
  {
    try
    {
      if (this.a == null)
      {
        fl.a(new Exception("AppKey不能为空!"));
        return;
      }
      if (this.b == null) {
        return;
      }
      AdhocTracker.APPKEY = this.a.trim();
      if (!ad.a(this.b.getApplicationContext()).b())
      {
        fl.a("设备没有sdcard,将不进入实验!");
        return;
      }
    }
    catch (Throwable localThrowable1)
    {
      fl.a(localThrowable1);
      return;
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      q.a().a(this.b.getApplicationContext());
      q.a().c();
      o.a().a(this.b.getApplicationContext());
      s.a(this.b.getApplicationContext()).a();
      w.a().a(this.b.getApplicationContext());
      fm.a locala = fm.b(this.b.getApplicationContext());
      if ("2.0".equals("2.0")) {
        AdhocTracker.access$000(this.b);
      }
      int i = j.a[locala.ordinal()];
      switch (i)
      {
      default: 
        return;
      }
      try
      {
        w.a().b(this.b.getApplicationContext());
        return;
      }
      catch (Throwable localThrowable2)
      {
        fl.a(localThrowable2);
        return;
      }
    }
    fl.b("ADHOC_SDK仅支持 Android SDK API level 9及以上,level 8及以下版本client将不加入试验");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */