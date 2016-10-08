package com.xiaoenai.app.common.view.b;

import android.content.Intent;
import android.os.Bundle;
import com.xiaoenai.app.common.view.activity.BaseActivity;
import dagger.internal.d;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class a
  implements com.xiaoenai.app.common.view.b.a.a
{
  private final com.xiaoenai.app.common.view.b.a.a a;
  
  @Inject
  public a(com.xiaoenai.app.common.view.b.a.a parama)
  {
    this.a = parama;
    d.a(parama);
    com.xiaoenai.app.utils.f.a.c("ActivityProxy Inject {}", new Object[] { this });
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    this.a.a(paramBaseActivity);
  }
  
  public void a(BaseActivity paramBaseActivity, Intent paramIntent)
  {
    this.a.a(paramBaseActivity, paramIntent);
  }
  
  public void a(BaseActivity paramBaseActivity, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    this.a.a(paramBaseActivity, paramIntent, paramInt, paramBundle);
  }
  
  public void a(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    this.a.a(paramBaseActivity, paramBundle);
  }
  
  public void b(BaseActivity paramBaseActivity)
  {
    this.a.b(paramBaseActivity);
  }
  
  public void c(BaseActivity paramBaseActivity)
  {
    this.a.c(paramBaseActivity);
  }
  
  public void d(BaseActivity paramBaseActivity)
  {
    this.a.d(paramBaseActivity);
  }
  
  public void e(BaseActivity paramBaseActivity)
  {
    this.a.e(paramBaseActivity);
  }
  
  public void f(BaseActivity paramBaseActivity)
  {
    this.a.f(paramBaseActivity);
  }
  
  public void g(BaseActivity paramBaseActivity)
  {
    this.a.g(paramBaseActivity);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\common\view\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */