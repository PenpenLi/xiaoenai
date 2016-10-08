package com.xiaoenai.app.download.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.xiaoenai.app.service.j;

public class DownloadService
  extends Service
{
  private a a;
  private j b = new j(this);
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.b;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.a = new a(this);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if ((paramIntent != null) && (paramIntent.getAction() != null) && (paramIntent.getAction().equals("com.xiaoenai.app.download.ACTION_IDownloadService"))) {
      switch (paramIntent.getIntExtra("type", -1))
      {
      }
    }
    for (;;)
    {
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
      if (!this.a.c())
      {
        this.a.a();
      }
      else
      {
        this.a.d();
        continue;
        String str = paramIntent.getStringExtra("url");
        if ((!TextUtils.isEmpty(str)) && (!this.a.b(str)))
        {
          Object localObject = new Intent("com.xiaoenai.app.download.TASK_CHANGE");
          ((Intent)localObject).putExtra("type", 11);
          sendBroadcast((Intent)localObject);
          localObject = paramIntent.getStringExtra("filePath");
          this.a.a(str, (String)localObject);
          continue;
          str = paramIntent.getStringExtra("url");
          if (!TextUtils.isEmpty(str))
          {
            this.a.f(str);
            continue;
            str = paramIntent.getStringExtra("url");
            if (!TextUtils.isEmpty(str))
            {
              this.a.d(str);
              continue;
              str = paramIntent.getStringExtra("url");
              if (!TextUtils.isEmpty(str))
              {
                this.a.c(str);
                continue;
                this.a.b();
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\download\services\DownloadService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */