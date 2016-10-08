package com.xiaoenai.app.data.e;

import android.content.Context;
import dagger.internal.b;
import javax.inject.a;

public final class d
  implements b<c>
{
  private final a<Context> b;
  
  static
  {
    if (!d.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public d(a<Context> parama)
  {
    if ((!a) && (parama == null)) {
      throw new AssertionError();
    }
    this.b = parama;
  }
  
  public static b<c> a(a<Context> parama)
  {
    return new d(parama);
  }
  
  public c a()
  {
    return new c((Context)this.b.get());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\e\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */