package com.xiaoenai.app.common.internal.di.b;

import android.app.Activity;
import com.xiaoenai.app.domain.internal.di.PerActivity;
import dagger.Module;
import dagger.Provides;

@Module
public class a
{
  private final Activity a;
  
  public a(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  @PerActivity
  @Provides
  Activity a()
  {
    return this.a;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\common\internal\di\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */