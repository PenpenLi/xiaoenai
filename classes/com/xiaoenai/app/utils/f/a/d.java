package com.xiaoenai.app.utils.f.a;

import com.orhanobut.logger.AndroidLogTool;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.Settings;

public class d
  extends e
{
  public d(c paramc)
  {
    super(paramc);
    if (paramc.g) {
      Logger.init(paramc.d).logLevel(LogLevel.FULL).logTool(new a()).methodCount(5).methodOffset(6);
    }
  }
  
  protected void a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      Logger.v(paramString, new Object[0]);
      return;
    case 3: 
      Logger.d(paramString, new Object[0]);
      return;
    case 4: 
      Logger.i(paramString, new Object[0]);
      return;
    case 5: 
      Logger.w(paramString, new Object[0]);
      return;
    case 6: 
      Logger.e(paramString, new Object[0]);
      return;
    }
    Logger.wtf(paramString, new Object[0]);
  }
  
  class a
    extends AndroidLogTool
  {
    a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\f\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */