package com.alibaba.nb.android.trade.web.interception.base.handler;

import java.util.LinkedHashMap;
import java.util.Map;

public class AliTradeHandlerInfoBuilder
{
  private AliTradeHandlerInfo handlerInfo = new AliTradeHandlerInfo();
  
  public static AliTradeHandlerInfoBuilder newHandlerInfo(String paramString)
  {
    AliTradeHandlerInfoBuilder localAliTradeHandlerInfoBuilder = new AliTradeHandlerInfoBuilder();
    localAliTradeHandlerInfoBuilder.handlerInfo.name = paramString;
    return localAliTradeHandlerInfoBuilder;
  }
  
  public AliTradeHandlerInfoBuilder addHandlerActionParameter(String paramString1, String paramString2)
  {
    this.handlerInfo.actionParameters.put(paramString1, paramString2);
    return this;
  }
  
  public AliTradeHandlerInfoBuilder addMatchInfo(String paramString1, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AliTradeMatchInfo localAliTradeMatchInfo = new AliTradeMatchInfo();
    localAliTradeMatchInfo.name = paramString1;
    localAliTradeMatchInfo.type = paramString2;
    localAliTradeMatchInfo.schemes = paramArrayOfString1;
    localAliTradeMatchInfo.values = paramArrayOfString2;
    this.handlerInfo.matchInfos.put(paramString1, localAliTradeMatchInfo);
    return this;
  }
  
  public AliTradeHandlerInfo getHandlerInfo()
  {
    return this.handlerInfo;
  }
  
  public AliTradeHandlerInfoBuilder setHandlerAction(String paramString)
  {
    this.handlerInfo.action = paramString;
    return this;
  }
  
  public AliTradeHandlerInfoBuilder setHandlerOrder(Boolean paramBoolean1, Boolean paramBoolean2, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    this.handlerInfo.beforeAll = paramBoolean1;
    this.handlerInfo.afterAll = paramBoolean2;
    this.handlerInfo.before = paramArrayOfString1;
    this.handlerInfo.after = paramArrayOfString2;
    return this;
  }
  
  public AliTradeHandlerInfoBuilder setHandlerScopes(String[] paramArrayOfString)
  {
    this.handlerInfo.scopes = paramArrayOfString;
    return this;
  }
  
  public AliTradeHandlerInfoBuilder setHandlerType(String paramString)
  {
    this.handlerInfo.type = paramString;
    return this;
  }
  
  public AliTradeHandlerInfoBuilder setHanlderScenarios(int[] paramArrayOfInt)
  {
    this.handlerInfo.scenarios = paramArrayOfInt;
    return this;
  }
  
  public AliTradeHandlerInfoBuilder setUIThread(boolean paramBoolean)
  {
    this.handlerInfo.uiThread = paramBoolean;
    return this;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\web\interception\base\handler\AliTradeHandlerInfoBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */