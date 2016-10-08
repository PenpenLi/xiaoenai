package com.alibaba.nb.android.trade.bridge.login.a;

import android.app.Activity;
import com.alibaba.nb.android.trade.bridge.login.AliTradeLoginService;
import com.alibaba.nb.android.trade.bridge.login.callback.AliTradeLoginCallback;
import com.alibaba.sdk.android.impl.KernelContext;
import com.alibaba.sdk.android.login.LoginService;
import com.alibaba.sdk.android.login.callback.LoginCallback;
import com.alibaba.sdk.android.login.callback.LogoutCallback;
import com.alibaba.sdk.android.registry.ServiceRegistry;
import com.alibaba.sdk.android.session.SessionListener;
import com.alibaba.sdk.android.session.model.Session;
import java.util.Map;

public class a
  implements AliTradeLoginService
{
  public static final AliTradeLoginService a = new a();
  private static final String b = a.class.getSimpleName();
  private LoginService c = (LoginService)KernelContext.serviceRegistry.getService(LoginService.class, null);
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 45	com/alibaba/nb/android/trade/bridge/login/a/a:c	Lcom/alibaba/sdk/android/login/LoginService;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getstatic 35	com/alibaba/sdk/android/impl/KernelContext:serviceRegistry	Lcom/alibaba/sdk/android/registry/ServiceRegistry;
    //   18: ldc 37
    //   20: aconst_null
    //   21: invokeinterface 43 3 0
    //   26: checkcast 37	com/alibaba/sdk/android/login/LoginService
    //   29: putfield 45	com/alibaba/nb/android/trade/bridge/login/a/a:c	Lcom/alibaba/sdk/android/login/LoginService;
    //   32: goto -21 -> 11
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	a
    //   6	2	1	localLoginService	LoginService
    //   35	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	35	finally
    //   14	32	35	finally
  }
  
  public Session getSession()
  {
    a();
    if (this.c == null) {
      return null;
    }
    return this.c.getSession();
  }
  
  public SessionListener getSessionListener()
  {
    a();
    if (this.c == null) {
      return null;
    }
    return this.c.getSessionListener();
  }
  
  public boolean isServiceAvliable()
  {
    return true;
  }
  
  public void logout(Activity paramActivity, LogoutCallback paramLogoutCallback)
  {
    a();
    if (this.c == null) {
      paramLogoutCallback.onFailure(0, "login服务为null");
    }
    while (this.c == null) {
      return;
    }
    this.c.logout(paramActivity, paramLogoutCallback);
  }
  
  public void setSessionListener(SessionListener paramSessionListener)
  {
    a();
    if (this.c == null) {
      return;
    }
    this.c.setSessionListener(paramSessionListener);
  }
  
  public void showLogin(Activity paramActivity, AliTradeLoginCallback paramAliTradeLoginCallback)
  {
    a();
    if (this.c == null)
    {
      paramAliTradeLoginCallback.onFailure(0, "login服务为null");
      return;
    }
    this.c.showLogin(paramActivity, new b(this, paramAliTradeLoginCallback));
  }
  
  public void showQrCodeLogin(Activity paramActivity, Map<String, String> paramMap, LoginCallback paramLoginCallback)
  {
    a();
    if (this.c == null)
    {
      paramLoginCallback.onFailure(0, "login服务为null");
      return;
    }
    this.c.showQrCodeLogin(paramActivity, paramMap, paramLoginCallback);
  }
  
  public void showQrLoginConfirm(Activity paramActivity, Map<String, String> paramMap, LoginCallback paramLoginCallback)
  {
    a();
    if (this.c == null)
    {
      paramLoginCallback.onFailure(0, "login服务为null");
      return;
    }
    this.c.showQrLoginConfirm(paramActivity, paramMap, paramLoginCallback);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\bridge\login\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */