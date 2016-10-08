package com.alibaba.nb.android.trade.bridge.alipay.handler.impl;

import android.app.Activity;
import android.text.TextUtils;
import com.alibaba.sdk.android.message.Message;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

final class a
  implements Runnable
{
  a(AliTradeWebViewProxyPayTaskHandler paramAliTradeWebViewProxyPayTaskHandler, Activity paramActivity, String paramString) {}
  
  public final void run()
  {
    String str = "";
    Object localObject2 = str;
    Object localObject3;
    Object localObject4;
    Object localObject1;
    int i;
    try
    {
      localObject3 = Class.forName("com.alipay.sdk.app.PayTask");
      localObject2 = str;
      localObject4 = ((Class)localObject3).getDeclaredConstructor(new Class[] { Activity.class }).newInstance(new Object[] { this.a });
      localObject2 = str;
      localObject4 = (String)((Class)localObject3).getMethod("pay", new Class[] { String.class, Boolean.TYPE }).invoke(localObject4, new Object[] { this.b, Boolean.valueOf(true) });
      if (localObject4 == null) {
        return;
      }
      localObject2 = str;
      localObject3 = ((String)localObject4).replace("{", "").replace("}", "");
      localObject2 = str;
      str = AliTradeWebViewProxyPayTaskHandler.access$000(this.c, (String)localObject3, "resultStatus=", ";memo");
      localObject2 = str;
      if (TextUtils.equals("9000", str))
      {
        localObject2 = str;
        com.alibaba.nb.android.trade.utils.d.a.a("BaichuanTLOG", "AliTradeWebViewProxyPayTaskHandler.handle()--pay success");
        return;
      }
    }
    catch (Exception localException)
    {
      localObject1 = localObject2;
      AliSDKLogger.e("WebViewProxyPayTaskHandler", "fail to parse the response code " + (String)localObject1);
      i = 808;
    }
    for (;;)
    {
      this.a.setResult(i);
      AliSDKLogger.log("WebViewProxyPayTaskHandler", Message.create(i, new Object[] { localObject1 }));
      return;
      localObject2 = localObject1;
      StringBuilder localStringBuilder = new StringBuilder("AliTradeWebViewProxyPayTaskHandler.handle()--pay failure： result: ");
      localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = null;
      }
      localObject2 = localObject1;
      com.alibaba.nb.android.trade.utils.d.a.a("BaichuanTLOG", (String)localObject3);
      localObject2 = localObject1;
      i = Integer.parseInt((String)localObject1);
      switch (i)
      {
      default: 
        i = 808;
        break;
      case 8000: 
        i = 804;
        break;
      case 4000: 
        i = 805;
        break;
      case 6001: 
        i = 806;
        break;
      case 6002: 
        i = 807;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\bridge\alipay\handler\impl\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */