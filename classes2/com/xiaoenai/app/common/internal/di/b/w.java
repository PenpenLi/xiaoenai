package com.xiaoenai.app.common.internal.di.b;

import android.support.v4.app.Fragment;
import dagger.internal.b;
import dagger.internal.d;

public final class w
  implements b<Fragment>
{
  private final v b;
  
  static
  {
    if (!w.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public w(v paramv)
  {
    if ((!a) && (paramv == null)) {
      throw new AssertionError();
    }
    this.b = paramv;
  }
  
  public static b<Fragment> a(v paramv)
  {
    return new w(paramv);
  }
  
  public Fragment a()
  {
    return (Fragment)d.a(this.b.a(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\common\internal\di\b\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */