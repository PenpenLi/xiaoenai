package com.xiaoenai.app.utils.f.a;

import timber.log.Timber;
import timber.log.Timber.DebugTree;
import timber.log.Timber.Tree;

class g
  extends e
{
  g(c paramc)
  {
    super(paramc);
    if (paramc.g) {
      Timber.plant(new Timber.DebugTree());
    }
  }
  
  protected void a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      Timber.tag(this.a.d).v(paramString, new Object[0]);
      return;
    case 3: 
      Timber.tag(this.a.d).d(paramString, new Object[0]);
      return;
    case 4: 
      Timber.tag(this.a.d).i(paramString, new Object[0]);
      return;
    case 5: 
      Timber.tag(this.a.d).w(paramString, new Object[0]);
      return;
    case 6: 
      Timber.tag(this.a.d).e(paramString, new Object[0]);
      return;
    }
    Timber.tag(this.a.d).wtf(paramString, new Object[0]);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\f\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */