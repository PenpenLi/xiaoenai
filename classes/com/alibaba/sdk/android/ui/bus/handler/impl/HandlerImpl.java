package com.alibaba.sdk.android.ui.bus.handler.impl;

import android.text.TextUtils;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.ui.bus.MatchInfo;
import com.alibaba.sdk.android.ui.bus.handler.Handler;
import com.alibaba.sdk.android.ui.bus.handler.HandlerAction;
import com.alibaba.sdk.android.ui.bus.handler.HandlerContext;
import com.alibaba.sdk.android.ui.bus.handler.HandlerInfo;
import com.alibaba.sdk.android.util.ReflectionUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class HandlerImpl
  implements Handler
{
  private HandlerAction handlerAction;
  private HandlerInfo handlerInfo;
  
  public HandlerImpl(HandlerInfo paramHandlerInfo)
  {
    this.handlerInfo = paramHandlerInfo;
    if (!TextUtils.isEmpty(paramHandlerInfo.action)) {}
    try
    {
      this.handlerAction = ((HandlerAction)ReflectionUtils.newInstance(paramHandlerInfo.action, new String[] { HandlerInfo.class.getName() }, new Object[] { paramHandlerInfo }));
      return;
    }
    catch (Exception paramHandlerInfo)
    {
      AliSDKLogger.e("ui", "Fail to create handler action", paramHandlerInfo);
    }
  }
  
  public boolean doHandle(HandlerContext paramHandlerContext)
  {
    if ((this.handlerInfo.matchInfos == null) || (this.handlerAction == null)) {
      return false;
    }
    Iterator localIterator = this.handlerInfo.matchInfos.values().iterator();
    while (localIterator.hasNext()) {
      if (((MatchInfo)localIterator.next()).isMatch(paramHandlerContext)) {
        return this.handlerAction.execute(paramHandlerContext);
      }
    }
    return false;
  }
  
  public HandlerInfo getHandlerInfo()
  {
    return this.handlerInfo;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\bus\handler\impl\HandlerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */