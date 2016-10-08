package com.xiaoenai.app.utils;

import android.content.Context;
import android.content.Intent;
import com.xiaoenai.app.model.AppSettings;
import com.xiaoenai.app.model.ConfigCenter;
import com.xiaoenai.app.service.ProtectService;
import com.xiaoenai.app.stat.c;
import com.xiaoenai.app.utils.f.a;

public class ad
{
  public static void a(Context paramContext)
  {
    int i = AppSettings.getInt("last_startup_ts", Integer.valueOf(0)).intValue();
    int j = (int)(System.currentTimeMillis() / 1000L);
    int k = ConfigCenter.getMaxStartupInterval();
    int m = ConfigCenter.getMaxContinueStartupTime();
    int n = AppSettings.getInt("max_continue_startup_times", Integer.valueOf(0)).intValue();
    int i1 = ConfigCenter.getClearTimeTs();
    a.c("cTs:{} ts:{} startupInterval:{}", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k) });
    if (j - i > k)
    {
      a.c("cTs - ts: {}", new Object[] { Integer.valueOf(j - i) });
      a.c("start ProtectService", new Object[0]);
      if ((m == 0) || (n - m > 0))
      {
        Intent localIntent = new Intent();
        localIntent.setClass(paramContext, ProtectService.class);
        paramContext.startService(localIntent);
        AppSettings.setInt("last_startup_ts", Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
        if (m != 0) {
          AppSettings.setInt("max_continue_startup_times", Integer.valueOf(n + 1));
        }
        c.a().a(505, j - i);
      }
    }
    if ((i1 != 0) && (i1 - ak.b() < 0L)) {
      AppSettings.setInt("max_continue_startup_times", Integer.valueOf(0));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */