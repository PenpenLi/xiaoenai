package com.xiaoenai.tool.log;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;

public class d
{
  private static a a;
  private static ServiceConnection b;
  private static Handler c;
  
  public static void a(Context paramContext)
  {
    if (c == null) {
      c = new Handler(paramContext.getMainLooper());
    }
    Intent localIntent = new Intent(paramContext, SuspendWindowService.class);
    paramContext.startService(localIntent);
    if (b == null) {
      b = new e();
    }
    paramContext.bindService(localIntent, b, 1);
  }
  
  public static void b(Context paramContext)
  {
    if (b != null) {
      paramContext.unbindService(b);
    }
    paramContext.stopService(new Intent(paramContext, SuspendWindowService.class));
  }
  
  public static boolean c(Context paramContext)
  {
    return b.a(paramContext, SuspendWindowService.class.getName());
  }
  
  public static void d(Context paramContext)
  {
    if (!c(paramContext))
    {
      a(paramContext);
      return;
    }
    b(paramContext);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\tool\log\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */