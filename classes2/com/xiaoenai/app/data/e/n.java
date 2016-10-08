package com.xiaoenai.app.data.e;

import com.xiaoenai.app.data.e.a.c.l;
import dagger.internal.b;
import javax.inject.a;

public final class n
  implements b<g>
{
  private final a<l> b;
  
  static
  {
    if (!n.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public n(a<l> parama)
  {
    if ((!a) && (parama == null)) {
      throw new AssertionError();
    }
    this.b = parama;
  }
  
  public static b<g> a(a<l> parama)
  {
    return new n(parama);
  }
  
  public g a()
  {
    return new g((l)this.b.get());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\e\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */