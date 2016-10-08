package com.xiaoenai.app.common.internal.di.a;

import android.support.v4.app.Fragment;
import com.xiaoenai.app.common.view.a.b;
import com.xiaoenai.app.common.view.b.c;
import dagger.internal.d;

public final class v
  implements x
{
  private javax.inject.a<c> b;
  private dagger.a<com.xiaoenai.app.common.view.a.a> c;
  private javax.inject.a<Fragment> d;
  
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
  }
  
  public void a(com.xiaoenai.app.common.view.a.a parama)
  {
    this.c.a(parama);
  }
  
  public static final class a
  {
    private com.xiaoenai.app.common.internal.di.b.v a;
    private a b;
    
    public a a(a parama)
    {
      this.b = ((a)d.a(parama));
      return this;
    }
    
    public a a(com.xiaoenai.app.common.internal.di.b.v paramv)
    {
      this.a = ((com.xiaoenai.app.common.internal.di.b.v)d.a(paramv));
      return this;
    }
    
    public x a()
    {
      if (this.a == null) {
        throw new IllegalStateException(com.xiaoenai.app.common.internal.di.b.v.class.getCanonicalName() + " must be set");
      }
      if (this.b == null) {
        throw new IllegalStateException(a.class.getCanonicalName() + " must be set");
      }
      return new v(this, null);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\common\internal\di\a\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */