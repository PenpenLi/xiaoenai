package com.xiaoenai.app.service;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.NotificationCompat.Builder;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.xiaoenai.app.classes.settings.AboutActivity;
import com.xiaoenai.app.utils.w;
import java.io.File;

public class DownloadService
  extends Service
{
  private File a = null;
  private boolean b = false;
  private a c;
  private int d = 0;
  private RemoteViews e;
  private int f = 1234;
  
  private NotificationCompat.Builder a(RemoteViews paramRemoteViews)
  {
    PendingIntent localPendingIntent = PendingIntent.getActivity(this, this.f, new Intent(this, AboutActivity.class), 134217728);
    return w.a(this).setContentIntent(localPendingIntent).setContentTitle(getString(2131099955)).setContentText(getString(2131099955) + getString(2131101076)).setContent(paramRemoteViews).setWhen(System.currentTimeMillis()).setDefaults(4).setSmallIcon(17301633);
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
    new b(this, paramString).start();
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent != null)
    {
      this.e = new RemoteViews(getPackageName(), 2130903307);
      w.a(this, a(this.e), this.f);
      this.c = new a(Looper.myLooper(), this);
      Message localMessage = this.c.obtainMessage(3, Integer.valueOf(0));
      this.c.sendMessage(localMessage);
      a(paramIntent.getStringExtra("url"));
    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  class a
    extends Handler
  {
    private Context b;
    
    public a(Looper paramLooper, Context paramContext)
    {
      super();
      this.b = paramContext;
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      if (paramMessage != null) {}
      switch (paramMessage.what)
      {
      case 1: 
      default: 
        return;
      case 0: 
        Toast.makeText(this.b, paramMessage.obj.toString(), 0).show();
        return;
      case 2: 
        DownloadService.a(DownloadService.this, 0);
        w.a(this.b, DownloadService.e(DownloadService.this));
        DownloadService.a(DownloadService.this, (File)paramMessage.obj, this.b);
        DownloadService.this.stopSelf();
        return;
      case 3: 
        DownloadService.f(DownloadService.this).setTextViewText(2131559690, DownloadService.this.getString(2131101075) + DownloadService.c(DownloadService.this) + "%");
        DownloadService.f(DownloadService.this).setProgressBar(2131559689, 100, DownloadService.c(DownloadService.this), false);
        w.a(this.b, DownloadService.e(DownloadService.this), DownloadService.a(DownloadService.this, DownloadService.f(DownloadService.this)));
        return;
      }
      w.a(this.b, DownloadService.e(DownloadService.this));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\service\DownloadService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */