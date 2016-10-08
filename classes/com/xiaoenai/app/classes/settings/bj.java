package com.xiaoenai.app.classes.settings;

import android.app.Activity;
import com.alibaba.nb.android.trade.AliTradeSDK;
import com.alibaba.nb.android.trade.bridge.login.AliTradeLoginService;
import com.alibaba.nb.android.trade.bridge.login.callback.AliTradeLoginCallback;
import com.alibaba.sdk.android.login.callback.LogoutCallback;
import com.alibaba.sdk.android.session.model.Session;

public class bj
{
  private static bj c;
  AliTradeLoginService a = (AliTradeLoginService)AliTradeSDK.getService(AliTradeLoginService.class);
  Session b;
  
  private bj()
  {
    if (this.a != null) {
      this.b = this.a.getSession();
    }
  }
  
  /* Error */
  public static bj a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 34	com/xiaoenai/app/classes/settings/bj:c	Lcom/xiaoenai/app/classes/settings/bj;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 34	com/xiaoenai/app/classes/settings/bj:c	Lcom/xiaoenai/app/classes/settings/bj;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	com/xiaoenai/app/classes/settings/bj
    //   21: dup
    //   22: invokespecial 35	com/xiaoenai/app/classes/settings/bj:<init>	()V
    //   25: putstatic 34	com/xiaoenai/app/classes/settings/bj:c	Lcom/xiaoenai/app/classes/settings/bj;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 34	com/xiaoenai/app/classes/settings/bj:c	Lcom/xiaoenai/app/classes/settings/bj;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	5	0	localbj	bj
    //   40	5	0	localObject1	Object
    //   46	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   41	44	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   44	46	46	finally
  }
  
  public void a(Activity paramActivity, AliTradeLoginCallback paramAliTradeLoginCallback)
  {
    if (this.a != null) {
      this.a.showLogin(paramActivity, paramAliTradeLoginCallback);
    }
  }
  
  public void a(Activity paramActivity, LogoutCallback paramLogoutCallback)
  {
    if ((this.a != null) && (this.b != null) && (this.b.isLogin().booleanValue())) {
      this.a.logout(paramActivity, paramLogoutCallback);
    }
  }
  
  public boolean b()
  {
    if (this.b != null) {
      return this.b.isLogin().booleanValue();
    }
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */