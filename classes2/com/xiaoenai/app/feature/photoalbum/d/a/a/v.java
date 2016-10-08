package com.xiaoenai.app.feature.photoalbum.d.a.a;

import android.support.v4.app.Fragment;
import com.xiaoenai.app.common.view.a.b;
import com.xiaoenai.app.domain.e.e;

public final class v
  implements z
{
  private javax.inject.a<com.xiaoenai.app.common.view.b.c> b;
  private dagger.a<com.xiaoenai.app.common.view.a.a> c;
  private javax.inject.a<Fragment> d;
  private javax.inject.a<e> e;
  private dagger.a<com.xiaoenai.app.feature.photoalbum.view.b.c> f;
  
  static
  {
    if (!v.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  private v(a parama)
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
    this.b = new w(this, parama);
    this.c = b.a(this.b);
    this.d = dagger.internal.a.a(com.xiaoenai.app.common.internal.di.b.w.a(a.b(parama)));
    this.e = new x(this, parama);
    this.f = com.xiaoenai.app.feature.photoalbum.view.b.d.a(this.b, this.e);
  }
  
  public void a(com.xiaoenai.app.common.view.a.a parama)
  {
    this.c.a(parama);
  }
  
  public void a(com.xiaoenai.app.feature.photoalbum.view.b.c paramc)
  {
    this.f.a(paramc);
  }
  
  public static final class a
  {
    private com.xiaoenai.app.common.internal.di.b.v a;
    private com.xiaoenai.app.common.internal.di.a.a b;
    
    public a a(com.xiaoenai.app.common.internal.di.a.a parama)
    {
      this.b = ((com.xiaoenai.app.common.internal.di.a.a)dagger.internal.d.a(parama));
      return this;
    }
    
    public a a(com.xiaoenai.app.common.internal.di.b.v paramv)
    {
      this.a = ((com.xiaoenai.app.common.internal.di.b.v)dagger.internal.d.a(paramv));
      return this;
    }
    
    public z a()
    {
      if (this.a == null) {
        throw new IllegalStateException(com.xiaoenai.app.common.internal.di.b.v.class.getCanonicalName() + " must be set");
      }
      if (this.b == null) {
        throw new IllegalStateException(com.xiaoenai.app.common.internal.di.a.a.class.getCanonicalName() + " must be set");
      }
      return new v(this, null);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\d\a\a\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */