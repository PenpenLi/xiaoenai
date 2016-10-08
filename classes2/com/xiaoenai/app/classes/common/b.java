package com.xiaoenai.app.classes.common;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Process;
import com.xiaoenai.app.download.services.DownloadService;
import com.xiaoenai.app.service.MessageService;
import com.xiaoenai.app.service.ProtectService;

class b
  implements Runnable
{
  b(a parama, Context paramContext) {}
  
  public void run()
  {
    this.a.stopService(new Intent(this.a, MessageService.class));
    this.a.stopService(new Intent(this.a, DownloadService.class));
    Process.killProcess(Process.myPid());
    ActivityManager localActivityManager = (ActivityManager)this.a.getSystemService("activity");
    if (Build.VERSION.SDK_INT >= 8)
    {
      this.a.stopService(new Intent(this.a, ProtectService.class));
      localActivityManager.killBackgroundProcesses("com.xiaoenai.app:daemon");
    }
    System.exit(0);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */