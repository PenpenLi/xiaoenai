package com.alibaba.nb.android.trade.web.interception.base.handler.a;

import android.text.TextUtils;
import com.alibaba.nb.android.trade.web.interception.base.handler.AliTradeHandler;
import com.alibaba.nb.android.trade.web.interception.base.handler.AliTradeHandlerAction;
import com.alibaba.nb.android.trade.web.interception.base.handler.AliTradeHandlerContext;
import com.alibaba.nb.android.trade.web.interception.base.handler.AliTradeHandlerInfo;
import com.alibaba.nb.android.trade.web.interception.base.handler.AliTradeMatchInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class a
  implements AliTradeHandler
{
  private AliTradeHandlerAction handlerAction;
  private AliTradeHandlerInfo handlerInfo;
  
  public a(AliTradeHandlerInfo paramAliTradeHandlerInfo)
  {
    this.handlerInfo = paramAliTradeHandlerInfo;
    if (!TextUtils.isEmpty(paramAliTradeHandlerInfo.action)) {}
    try
    {
      this.handlerAction = ((AliTradeHandlerAction)com.alibaba.nb.android.trade.utils.f.a.a(paramAliTradeHandlerInfo.action, new String[] { AliTradeHandlerInfo.class.getName() }, new Object[] { paramAliTradeHandlerInfo }));
      return;
    }
    catch (Exception paramAliTradeHandlerInfo) {}
  }
  
  public boolean doHandle(AliTradeHandlerContext paramAliTradeHandlerContext)
  {
    if ((this.handlerInfo.matchInfos == null) || (this.handlerAction == null)) {
      return false;
    }
    Iterator localIterator = this.handlerInfo.matchInfos.values().iterator();
    while (localIterator.hasNext()) {
      if (((AliTradeMatchInfo)localIterator.next()).isMatch(paramAliTradeHandlerContext)) {
        return this.handlerAction.execute(paramAliTradeHandlerContext);
      }
    }
    return false;
  }
  
  public AliTradeHandlerInfo getHandlerInfo()
  {
    return this.handlerInfo;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\web\interception\base\handler\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */