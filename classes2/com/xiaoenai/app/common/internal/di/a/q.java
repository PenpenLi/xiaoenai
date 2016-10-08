package com.xiaoenai.app.common.internal.di.a;

import com.xiaoenai.app.common.application.BaseApplication;
import dagger.internal.d;

class q
  implements dagger.internal.b<BaseApplication>
{
  private final b c = c.a.a(this.a);
  
  q(c paramc, c.a parama) {}
  
  public BaseApplication a()
  {
    return (BaseApplication)d.a(this.c.b(), "Cannot return null from a non-@Nullable component method");
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\common\internal\di\a\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */