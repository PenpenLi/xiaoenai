package com.xiaoenai.app.feature.photoalbum.e;

import com.xiaoenai.app.domain.e.d;
import dagger.internal.b;
import javax.inject.a;

public final class j
  implements b<c>
{
  private final a<d> b;
  
  static
  {
    if (!j.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public j(a<d> parama)
  {
    if ((!a) && (parama == null)) {
      throw new AssertionError();
    }
    this.b = parama;
  }
  
  public static b<c> a(a<d> parama)
  {
    return new j(parama);
  }
  
  public c a()
  {
    return new c((d)this.b.get());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\e\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */