package com.xiaoenai.app.common.view.a;

import com.xiaoenai.app.common.view.b.c;

public final class b
  implements dagger.a<a>
{
  private final javax.inject.a<c> b;
  
  static
  {
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public b(javax.inject.a<c> parama)
  {
    if ((!a) && (parama == null)) {
      throw new AssertionError();
    }
    this.b = parama;
  }
  
  public static dagger.a<a> a(javax.inject.a<c> parama)
  {
    return new b(parama);
  }
  
  public static void a(a parama, javax.inject.a<c> parama1)
  {
    parama.e = ((c)parama1.get());
  }
  
  public void a(a parama)
  {
    if (parama == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    parama.e = ((c)this.b.get());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\common\view\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */