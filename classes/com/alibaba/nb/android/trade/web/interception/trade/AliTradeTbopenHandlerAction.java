package com.alibaba.nb.android.trade.web.interception.trade;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.alibaba.nb.android.trade.AliTradeContext;
import com.alibaba.nb.android.trade.bridge.a.a;
import com.alibaba.nb.android.trade.web.interception.base.handler.AliTradeHandlerAction;
import com.alibaba.nb.android.trade.web.interception.base.handler.AliTradeHandlerContext;
import com.alibaba.nb.android.trade.web.interception.base.handler.AliTradeHandlerInfo;
import com.alibaba.nb.android.trade.web.register.AliTradeServiceRegistry;

public class AliTradeTbopenHandlerAction
  implements AliTradeHandlerAction
{
  private AliTradeHandlerInfo mHandlerInfo;
  
  public AliTradeTbopenHandlerAction(AliTradeHandlerInfo paramAliTradeHandlerInfo)
  {
    this.mHandlerInfo = paramAliTradeHandlerInfo;
  }
  
  public boolean execute(AliTradeHandlerContext paramAliTradeHandlerContext)
  {
    paramAliTradeHandlerContext = paramAliTradeHandlerContext.getUri();
    Object localObject = (a)AliTradeContext.serviceRegistry.getService(a.class, null);
    if ((paramAliTradeHandlerContext == null) || (localObject == null)) {
      return false;
    }
    if (((a)localObject).a())
    {
      localObject = new Intent();
      ((Intent)localObject).setFlags(268435456);
      ((Intent)localObject).setData(Uri.parse(paramAliTradeHandlerContext));
      AliTradeContext.context.startActivity((Intent)localObject);
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\web\interception\trade\AliTradeTbopenHandlerAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */