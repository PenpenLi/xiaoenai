package com.xiaoenai.app.g.a.a.a;

import android.location.LocationManager;
import android.os.Handler;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.common.internal.di.a.b;
import com.xiaoenai.app.k;
import dagger.internal.d;

public final class p
  implements v
{
  private javax.inject.a<Handler> b;
  private javax.inject.a<LocationManager> c;
  private javax.inject.a<com.xiaoenai.app.common.application.a.c> d;
  private javax.inject.a<com.xiaoenai.app.common.a.a> e;
  private javax.inject.a<com.xiaoenai.app.domain.e.c> f;
  private dagger.a<Xiaoenai> g;
  
  static
  {
    if (!p.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  private p(a parama)
  {
    if ((!a) && (parama == null)) {
      throw new AssertionError();
    }
    a(parama);
  }
  
  public static a a()
  {
    return new a(null);
  }
  
  private void a(a parama)
  {
    this.b = new q(this, parama);
    this.c = new r(this, parama);
    this.d = new s(this, parama);
    this.e = new t(this, parama);
    this.f = new u(this, parama);
    this.g = k.a(this.b, this.c, this.d, this.e, this.f);
  }
  
  public void a(Xiaoenai paramXiaoenai)
  {
    this.g.a(paramXiaoenai);
  }
  
  public static final class a
  {
    private b a;
    
    public a a(b paramb)
    {
      this.a = ((b)d.a(paramb));
      return this;
    }
    
    @Deprecated
    public a a(com.xiaoenai.app.g.a.a.b.a parama)
    {
      d.a(parama);
      return this;
    }
    
    public v a()
    {
      if (this.a == null) {
        throw new IllegalStateException(b.class.getCanonicalName() + " must be set");
      }
      return new p(this, null);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\g\a\a\a\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */