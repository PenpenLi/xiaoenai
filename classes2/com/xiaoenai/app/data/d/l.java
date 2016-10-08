package com.xiaoenai.app.data.d;

import javax.inject.a;

public final class l
  implements dagger.internal.b<k>
{
  private final a<com.xiaoenai.app.data.d.a.b> b;
  
  static
  {
    if (!l.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public l(a<com.xiaoenai.app.data.d.a.b> parama)
  {
    if ((!a) && (parama == null)) {
      throw new AssertionError();
    }
    this.b = parama;
  }
  
  public static dagger.internal.b<k> a(a<com.xiaoenai.app.data.d.a.b> parama)
  {
    return new l(parama);
  }
  
  public k a()
  {
    return new k((com.xiaoenai.app.data.d.a.b)this.b.get());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\d\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */