package com.xiaoenai.app.service;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat.Builder;
import android.widget.RemoteViews;
import com.xiaoenai.app.classes.settings.AboutActivity;
import com.xiaoenai.app.classes.store.DownloadReceiver;
import com.xiaoenai.app.utils.w;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class ApkDownloadService
  extends Service
{
  private int a = 123;
  private RemoteViews b;
  private int c = 0;
  private Intent d = null;
  private DownloadReceiver e;
  private Handler f = new a(this);
  
  private NotificationCompat.Builder a(RemoteViews paramRemoteViews)
  {
    PendingIntent localPendingIntent = PendingIntent.getActivity(this, this.a, new Intent(this, AboutActivity.class), 134217728);
    return w.a(this).setContentIntent(localPendingIntent).setContentTitle(getString(2131099955)).setContentText(getString(2131099955) + getString(2131101076)).setContent(paramRemoteViews).setWhen(System.currentTimeMillis()).setDefaults(4).setSmallIcon(17301633);
  }
  
  private void a()
  {
    this.b = new RemoteViews(getPackageName(), 2130903307);
    w.a(this, this.a, a(this.b));
  }
  
  private void a(File paramFile, Context paramContext)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setFlags(268435456);
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setDataAndType(Uri.fromFile(paramFile), "application/vnd.android.package-archive");
    paramContext.startActivity(localIntent);
  }
  
  private void a(String paramString)
  {
    try
    {
      Object localObject1 = new URL(paramString);
      if (localObject1 != null)
      {
        localObject1 = new File(com.xiaoenai.app.download.c.b.a, new File(((URL)localObject1).getFile()).getName());
        if (((File)localObject1).exists()) {
          ((File)localObject1).delete();
        }
      }
      this.d = new Intent();
      this.d.putExtra("type", 2);
      startService(this.d);
      a();
      localObject1 = new Intent("com.xiaoenai.app.download.ACTION_IDownloadService");
      ((Intent)localObject1).putExtra("type", 6);
      ((Intent)localObject1).putExtra("filePath", com.xiaoenai.app.utils.b.c());
      ((Intent)localObject1).putExtra("url", paramString);
      startService((Intent)localObject1);
      com.f.a.b.b(this, "UpdateApp");
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        localMalformedURLException.printStackTrace();
        Object localObject2 = null;
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    this.e = new DownloadReceiver(this.f);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.xiaoenai.app.download.TASK_CHANGE");
    registerReceiver(this.e, localIntentFilter);
    super.onCreate();
  }
  
  public void onDestroy()
  {
    if (this.e != null) {
      unregisterReceiver(this.e);
    }
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if ((paramIntent != null) && (paramIntent.getAction() != null) && (paramIntent.getAction().equals("downloadApkAction")))
    {
      String str = paramIntent.getStringExtra("url");
      if (str != null) {
        a(str);
      }
    }
    return super.onStartCommand(paramIntent, paramInt1 | 0x2, paramInt2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\service\ApkDownloadService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */