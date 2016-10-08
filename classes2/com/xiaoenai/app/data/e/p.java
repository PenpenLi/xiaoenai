package com.xiaoenai.app.data.e;

import android.content.Context;
import javax.inject.a;

public final class p
  implements dagger.internal.b<o>
{
  private final a<Context> b;
  private final a<com.xiaoenai.app.data.e.a.a.b> c;
  
  static
  {
    if (!p.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public p(a<Context> parama, a<com.xiaoenai.app.data.e.a.a.b> parama1)
  {
    if ((!a) && (parama == null)) {
      throw new AssertionError();
    }
    this.b = parama;
    if ((!a) && (parama1 == null)) {
      throw new AssertionError();
    }
    this.c = parama1;
  }
  
  public static dagger.internal.b<o> a(a<Context> parama, a<com.xiaoenai.app.data.e.a.a.b> parama1)
  {
    return new p(parama, parama1);
  }
  
  public o a()
  {
    return new o((Context)this.b.get(), (com.xiaoenai.app.data.e.a.a.b)this.c.get());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\e\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */