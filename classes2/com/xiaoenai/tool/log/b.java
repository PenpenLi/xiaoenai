package com.xiaoenai.tool.log;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.ComponentName;
import android.content.Context;
import java.util.List;

public class b
{
  public static boolean a(Context paramContext, String paramString)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(30);
    if (paramContext.size() <= 0) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < paramContext.size())
      {
        if (((ActivityManager.RunningServiceInfo)paramContext.get(i)).service.getClassName().equals(paramString) == true) {
          return true;
        }
        i += 1;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\tool\log\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */