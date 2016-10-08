package com.xiaoenai.app.classes.common;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.model.AppSettings;

public class a
{
  private static a a = null;
  
  public static a a()
  {
    if (a == null) {}
    try
    {
      a = new a();
      return a;
    }
    finally {}
  }
  
  public void a(Activity paramActivity)
  {
    Xiaoenai.j().z().c().c(paramActivity);
  }
  
  public void a(Context paramContext)
  {
    try
    {
      AppSettings.setInt("app_id", Integer.valueOf(0));
      AppSettings.setInt("daemon_id", Integer.valueOf(0));
      d();
      com.f.a.b.c(paramContext);
      Xiaoenai.j().k().post(new b(this, paramContext));
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void a(Class<?> paramClass)
  {
    Xiaoenai.j().z().c().d(paramClass);
  }
  
  public int b()
  {
    return Xiaoenai.j().z().c().c();
  }
  
  public Activity b(Class<?> paramClass)
  {
    return Xiaoenai.j().z().c().b(paramClass);
  }
  
  public Activity c()
  {
    return Xiaoenai.j().z().c().a();
  }
  
  public boolean c(Class<?> paramClass)
  {
    return Xiaoenai.j().z().c().c(paramClass);
  }
  
  public void d()
  {
    Xiaoenai.j().z().c().b();
  }
  
  public void d(Class<?> paramClass)
  {
    Xiaoenai.j().z().c().a(paramClass);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */