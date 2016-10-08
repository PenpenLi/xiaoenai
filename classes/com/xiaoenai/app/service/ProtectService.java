package com.xiaoenai.app.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import android.os.RemoteException;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.model.AppModel;

public class ProtectService
  extends Service
{
  private Handler a;
  private a b;
  
  public void a(Context paramContext)
  {
    if (AppModel.getInstance().isLogined())
    {
      Intent localIntent = new Intent();
      localIntent.setClass(paramContext, MessageService.class);
      paramContext.startService(localIntent);
    }
  }
  
  public boolean a(IBinder paramIBinder)
  {
    b localb = new b(paramIBinder);
    try
    {
      paramIBinder.linkToDeath(localb, 0);
      return true;
    }
    catch (RemoteException paramIBinder)
    {
      for (;;)
      {
        paramIBinder.printStackTrace();
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    a(new Binder());
    this.a = new g(this);
    this.b = new a();
    this.b.start();
    super.onCreate();
  }
  
  public void onDestroy()
  {
    if (!Xiaoenai.F) {
      a(this);
    }
    if (Xiaoenai.F)
    {
      this.b.a();
      if (this.a.hasMessages(1)) {
        this.a.removeMessages(1);
      }
      this.a = null;
    }
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    a(this);
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("adjustTime", false))) {
      sendBroadcast(new Intent("com.xiaoenai.mall.service.TIME_UPDATE"), getString(2131101650));
    }
    return super.onStartCommand(paramIntent, 1, paramInt2);
  }
  
  class a
    extends Thread
  {
    private boolean b = true;
    
    a() {}
    
    public void a()
    {
      this.b = false;
      interrupt();
    }
    
    public void b()
    {
      try
      {
        wait();
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
      finally {}
    }
    
    public void c()
    {
      try
      {
        notify();
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public void run()
    {
      while (this.b)
      {
        Message localMessage = ProtectService.b(ProtectService.this).obtainMessage();
        localMessage.what = 1;
        ProtectService.b(ProtectService.this).sendMessageDelayed(localMessage, 120000L);
        b();
      }
    }
  }
  
  private class b
    implements IBinder.DeathRecipient
  {
    private IBinder b;
    
    public b(IBinder paramIBinder)
    {
      this.b = paramIBinder;
    }
    
    public void binderDied() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\service\ProtectService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */