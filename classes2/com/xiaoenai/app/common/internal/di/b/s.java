package com.xiaoenai.app.common.internal.di.b;

import com.xiaoenai.app.data.d.a.e;
import dagger.internal.b;
import dagger.internal.d;

public final class s
  implements b<e>
{
  private final c b;
  
  static
  {
    if (!s.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public s(c paramc)
  {
    if ((!a) && (paramc == null)) {
      throw new AssertionError();
    }
    this.b = paramc;
  }
  
  public static b<e> a(c paramc)
  {
    return new s(paramc);
  }
  
  public e a()
  {
    return (e)d.a(this.b.j(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\common\internal\di\b\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */