package com.xiaoenai.app.common.internal.di.b;

import android.app.Activity;
import dagger.internal.d;

public final class b
  implements dagger.internal.b<Activity>
{
  private final a b;
  
  static
  {
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public b(a parama)
  {
    if ((!a) && (parama == null)) {
      throw new AssertionError();
    }
    this.b = parama;
  }
  
  public static dagger.internal.b<Activity> a(a parama)
  {
    return new b(parama);
  }
  
  public Activity a()
  {
    return (Activity)d.a(this.b.a(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\common\internal\di\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */