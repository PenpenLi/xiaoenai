package com.xiaoenai.app.common.internal.di.a;

import android.os.Handler;
import dagger.internal.d;

class s
  implements dagger.internal.b<Handler>
{
  private final b c = c.a.a(this.a);
  
  s(c paramc, c.a parama) {}
  
  public Handler a()
  {
    return (Handler)d.a(this.c.h(), "Cannot return null from a non-@Nullable component method");
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\common\internal\di\a\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */