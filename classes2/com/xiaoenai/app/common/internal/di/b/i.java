package com.xiaoenai.app.common.internal.di.b;

import com.xiaoenai.app.common.application.BaseApplication;
import dagger.internal.b;
import dagger.internal.d;

public final class i
  implements b<BaseApplication>
{
  private final c b;
  
  static
  {
    if (!i.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public i(c paramc)
  {
    if ((!a) && (paramc == null)) {
      throw new AssertionError();
    }
    this.b = paramc;
  }
  
  public static b<BaseApplication> a(c paramc)
  {
    return new i(paramc);
  }
  
  public BaseApplication a()
  {
    return (BaseApplication)d.a(this.b.b(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\common\internal\di\b\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */