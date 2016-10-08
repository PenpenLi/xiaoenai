package com.alibaba.mtl.appmonitor.d;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.alibaba.mtl.appmonitor.b.b;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.r;
import com.alibaba.mtl.log.sign.IRequestAuth;
import com.taobao.wswitch.business.ConfigContainer;

@SuppressLint({"NewApi"})
public class g
{
  static void a(Context paramContext)
  {
    l.a(paramContext);
  }
  
  static void init(Context paramContext)
  {
    paramContext = new b(paramContext);
    r.a().a(7, paramContext, 200L);
  }
  
  private static class a
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      try
      {
        com.alibaba.mtl.log.a.a.l((String)ConfigContainer.getInstance().getConfig("motu_appmonitor_new", "motu_appmonitor_config", null));
        g.a(paramContext);
        return;
      }
      catch (Throwable paramContext)
      {
        b.a(paramContext);
      }
    }
  }
  
  private static class b
    implements Runnable
  {
    private static final String TAG = null;
    private Context a;
    
    public b(Context paramContext)
    {
      this.a = paramContext;
    }
    
    public void run()
    {
      String str = "";
      try
      {
        if (com.alibaba.mtl.log.a.a() != null) {
          str = com.alibaba.mtl.log.a.a().getAppkey();
        }
        if (str != null)
        {
          ConfigContainer.getInstance().init(null, null, null, this.a, true, new String[] { "motu_appmonitor_new" });
          ConfigContainer.getInstance().addIntentActionNameMapping(new String[] { "motu_appmonitor_new" });
          str = ConfigContainer.getInstance().getIntentActionName("motu_appmonitor_new");
          IntentFilter localIntentFilter = new IntentFilter();
          localIntentFilter.addAction(str);
          this.a.registerReceiver(new g.a(null), localIntentFilter);
          return;
        }
        r.a().a(7, this, 200L);
        return;
      }
      catch (Throwable localThrowable)
      {
        i.a(TAG, "register config center error", localThrowable);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\d\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */