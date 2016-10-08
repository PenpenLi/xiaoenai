package com.xiaoenai.app.utils.f.a;

import android.util.Log;

class a
  extends e
{
  a(c paramc)
  {
    super(paramc);
  }
  
  protected void a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      Log.v(this.a.d, paramString);
      return;
    case 3: 
      Log.d(this.a.d, paramString);
      return;
    case 4: 
      Log.i(this.a.d, paramString);
      return;
    case 5: 
      Log.w(this.a.d, paramString);
      return;
    case 6: 
      Log.e(this.a.d, paramString);
      return;
    }
    Log.wtf(this.a.d, paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\f\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */