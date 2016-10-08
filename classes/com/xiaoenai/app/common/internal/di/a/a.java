package com.xiaoenai.app.common.internal.di.a;

import com.xiaoenai.app.common.view.activity.BaseActivity;
import com.xiaoenai.app.common.view.activity.TitleBarActivity;
import com.xiaoenai.app.common.view.b.c;
import com.xiaoenai.app.domain.e.e;
import com.xiaoenai.app.domain.internal.di.PerActivity;
import dagger.Component;

@PerActivity
@Component
public abstract interface a
{
  public abstract c a();
  
  public abstract void a(BaseActivity paramBaseActivity);
  
  public abstract void a(TitleBarActivity paramTitleBarActivity);
  
  public abstract e b();
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\common\internal\di\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */