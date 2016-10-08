package com.xiaoenai.app.g.a.a.a;

import android.content.Context;
import dagger.internal.d;

class j
  implements dagger.internal.b<Context>
{
  private final com.xiaoenai.app.common.internal.di.a.b c = b.a.a(this.a);
  
  j(b paramb, b.a parama) {}
  
  public Context a()
  {
    return (Context)d.a(this.c.a(), "Cannot return null from a non-@Nullable component method");
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\g\a\a\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */