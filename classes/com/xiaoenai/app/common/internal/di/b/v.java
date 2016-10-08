package com.xiaoenai.app.common.internal.di.b;

import android.support.v4.app.Fragment;
import com.xiaoenai.app.domain.internal.di.PerFragment;
import dagger.Module;
import dagger.Provides;

@Module
public class v
{
  private final Fragment a;
  
  public v(Fragment paramFragment)
  {
    this.a = paramFragment;
  }
  
  @PerFragment
  @Provides
  Fragment a()
  {
    return this.a;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\common\internal\di\b\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */