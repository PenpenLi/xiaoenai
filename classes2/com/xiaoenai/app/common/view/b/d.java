package com.xiaoenai.app.common.view.b;

import dagger.internal.b;
import javax.inject.a;

public final class d
  implements b<c>
{
  private final a<com.xiaoenai.app.common.view.b.a.d> b;
  
  static
  {
    if (!d.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public d(a<com.xiaoenai.app.common.view.b.a.d> parama)
  {
    if ((!a) && (parama == null)) {
      throw new AssertionError();
    }
    this.b = parama;
  }
  
  public static b<c> a(a<com.xiaoenai.app.common.view.b.a.d> parama)
  {
    return new d(parama);
  }
  
  public c a()
  {
    return new c((com.xiaoenai.app.common.view.b.a.d)this.b.get());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\common\view\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */