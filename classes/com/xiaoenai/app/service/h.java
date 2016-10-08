package com.xiaoenai.app.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

public class h
{
  private Context a;
  private a b;
  private boolean c = false;
  private ServiceConnection d = new i(this);
  
  public h(Context paramContext, a parama)
  {
    this.a = paramContext;
    this.b = parama;
  }
  
  public void a()
  {
    try
    {
      if (this.c)
      {
        this.a.unbindService(this.d);
        this.c = false;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(Class<?> paramClass)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setClass(this.a, paramClass);
      localIntent.setPackage("com.xiaoenai.app");
      this.a.bindService(localIntent, this.d, 1);
      this.c = true;
      return;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  public static class a
  {
    public void a() {}
    
    public void a(Service paramService) {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\service\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */