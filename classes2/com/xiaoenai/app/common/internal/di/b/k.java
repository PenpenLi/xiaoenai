package com.xiaoenai.app.common.internal.di.b;

import android.content.Context;
import dagger.internal.b;
import dagger.internal.d;

public final class k
  implements b<Context>
{
  private final c b;
  
  static
  {
    if (!k.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public k(c paramc)
  {
    if ((!a) && (paramc == null)) {
      throw new AssertionError();
    }
    this.b = paramc;
  }
  
  public static b<Context> a(c paramc)
  {
    return new k(paramc);
  }
  
  public Context a()
  {
    return (Context)d.a(this.b.a(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\common\internal\di\b\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */