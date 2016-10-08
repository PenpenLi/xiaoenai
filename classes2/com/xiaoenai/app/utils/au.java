package com.xiaoenai.app.utils;

import com.xiaoenai.app.h.a.a.a;
import com.xiaoenai.app.model.AppSettings;
import com.xiaoenai.app.model.ConfigCenter;
import com.xiaoenai.app.utils.f.a;

final class au
  implements a.a
{
  public boolean a()
  {
    return !ConfigCenter.getAdhocSwitch();
  }
  
  public boolean b()
  {
    boolean bool = AppSettings.getBoolean("https_toggle", Boolean.valueOf(false)).booleanValue();
    a.c("enable_https = {}", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */