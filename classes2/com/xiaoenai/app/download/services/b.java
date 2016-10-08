package com.xiaoenai.app.download.services;

import android.content.Context;
import android.content.Intent;
import java.util.List;

class b
  implements d
{
  b(a parama) {}
  
  public void a(c paramc)
  {
    Intent localIntent = new Intent("com.xiaoenai.app.download.TASK_CHANGE");
    localIntent.putExtra("type", 0);
    localIntent.putExtra("process_speed", paramc.f() + "kbps | " + paramc.d() + " / " + paramc.e());
    localIntent.putExtra("process_progress", paramc.c());
    localIntent.putExtra("totalSize", paramc.e());
    localIntent.putExtra("url", paramc.a());
    localIntent.putExtra("downloadSize", paramc.d());
    a.a(this.a).sendBroadcast(localIntent);
  }
  
  public void a(c paramc, Throwable paramThrowable)
  {
    Intent localIntent;
    if (paramThrowable != null)
    {
      localIntent = new Intent("com.xiaoenai.app.download.TASK_CHANGE");
      if (!(paramThrowable instanceof com.xiaoenai.app.download.a.b)) {
        break label75;
      }
      localIntent.putExtra("filePath", paramc.g());
      localIntent.putExtra("url", paramc.a());
      localIntent.putExtra("type", 10);
      a.a(this.a).sendBroadcast(localIntent);
    }
    for (;;)
    {
      this.a.e(paramc.a());
      return;
      label75:
      localIntent.putExtra("type", 9);
      localIntent.putExtra("url", paramc.a());
      localIntent.putExtra("filePath", paramc.g());
      localIntent.putExtra("error_info", paramThrowable.getMessage());
      a.a(this.a).sendBroadcast(localIntent);
    }
  }
  
  public void b(c paramc)
  {
    com.xiaoenai.app.download.c.a.a(a.a(this.a), a.b(this.a).indexOf(paramc), paramc.a());
  }
  
  public void c(c paramc)
  {
    this.a.c(paramc);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\download\services\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */