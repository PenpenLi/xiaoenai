package com.xiaoenai.app.common.application;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.location.LocationManager;
import android.os.Handler;
import com.xiaoenai.app.common.application.a.c;
import com.xiaoenai.app.common.internal.di.a.t;
import com.xiaoenai.app.common.internal.di.a.t.a;
import com.xiaoenai.app.common.internal.di.b.c.a;
import com.xiaoenai.app.common.view.b.a.d;
import com.xiaoenai.app.data.d.a.e;
import javax.inject.Inject;

public abstract class BaseApplication
  extends Application
{
  @Inject
  protected Handler H;
  @Inject
  protected LocationManager I;
  @Inject
  protected c J;
  @Inject
  protected com.xiaoenai.app.common.a.a K;
  private com.xiaoenai.app.common.internal.di.a.b a;
  
  private void a()
  {
    if (p())
    {
      com.xiaoenai.app.a.a(this, p());
      com.e.a.a.a(this);
    }
  }
  
  public void A()
  {
    this.K.b();
  }
  
  public void B()
  {
    this.K.c();
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    android.support.multidex.a.a(this);
  }
  
  public String getPackageName()
  {
    return super.getPackageName();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    com.xiaoenai.app.utils.f.a.c("onConfigurationChanged", new Object[0]);
    this.J.a(paramConfiguration);
  }
  
  public void onCreate()
  {
    super.onCreate();
    com.xiaoenai.app.utils.f.a.c("onCreate", new Object[0]);
    w();
    a();
    this.J.a(z().s().i());
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    com.xiaoenai.app.utils.f.a.c("onLowMemory", new Object[0]);
    this.J.a();
  }
  
  public void onTerminate()
  {
    super.onTerminate();
    com.xiaoenai.app.utils.f.a.c("onTerminate", new Object[0]);
    this.J.b();
  }
  
  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    com.xiaoenai.app.utils.f.a.c("onTrimMemory {}", new Object[] { Integer.valueOf(paramInt) });
    this.J.a(paramInt);
  }
  
  protected abstract boolean p();
  
  protected abstract com.xiaoenai.app.common.view.b.a.a r();
  
  protected abstract d s();
  
  protected abstract com.xiaoenai.app.domain.d.a.b t();
  
  protected abstract e u();
  
  protected abstract com.xiaoenai.app.data.d.a v();
  
  protected void w()
  {
    this.a = t.y().a(new c.a().a(this).a(y()).a(r()).a(s()).a(x()).a(t()).a(u()).a(v()).a()).a();
    this.a.a(this);
  }
  
  protected abstract com.xiaoenai.app.common.application.a.a.a x();
  
  protected abstract com.xiaoenai.app.common.application.a.a.b y();
  
  public com.xiaoenai.app.common.internal.di.a.b z()
  {
    return this.a;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\common\application\BaseApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */