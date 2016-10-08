package com.alibaba.nb.android.trade.service.log.a;

import android.util.Log;
import com.alibaba.nb.android.trade.service.log.AliTradeLogLevel;
import com.alibaba.nb.android.trade.service.log.a;
import com.alibaba.nb.android.trade.service.log.c;
import com.alibaba.nb.android.trade.service.log.d;

public final class b
  implements d
{
  private static volatile b a = null;
  private boolean b;
  private String c = "AliTradeLogServiceImpl.class";
  
  public static b a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new b();
      }
      return a;
    }
    finally {}
  }
  
  private void a(AliTradeLogLevel paramAliTradeLogLevel, String paramString, Object... paramVarArgs)
  {
    if ((a.a().b()) && (paramAliTradeLogLevel.getIndex() > AliTradeLogLevel.W.getIndex()))
    {
      Log.v(this.c, "delete the log because the memory is limited!");
      return;
    }
    c localc = new c();
    localc.a = paramAliTradeLogLevel;
    localc.b = paramString;
    localc.c = "C";
    localc.d = "";
    localc.e = "";
    localc.i = null;
    localc.g = paramVarArgs;
    localc.f = System.currentTimeMillis();
    localc.h = paramVarArgs.length;
    a.a().a(localc);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if (this.b) {
      return;
    }
    a(AliTradeLogLevel.I, paramString1, new Object[] { paramString2 });
  }
  
  public final void b(String paramString1, String paramString2)
  {
    if (this.b) {
      return;
    }
    a(AliTradeLogLevel.W, paramString1, new Object[] { paramString2 });
  }
  
  public final void c(String paramString1, String paramString2)
  {
    if (this.b) {
      return;
    }
    a(AliTradeLogLevel.E, paramString1, new Object[] { paramString2 });
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\service\log\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */