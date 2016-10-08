package com.xiaoenai.app.common.internal.di.a;

import android.content.Context;
import dagger.internal.d;

class p
  implements dagger.internal.b<Context>
{
  private final b c = c.a.a(this.a);
  
  p(c paramc, c.a parama) {}
  
  public Context a()
  {
    return (Context)d.a(this.c.a(), "Cannot return null from a non-@Nullable component method");
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\common\internal\di\a\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */