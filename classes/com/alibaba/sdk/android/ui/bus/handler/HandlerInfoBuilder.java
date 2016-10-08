package com.alibaba.sdk.android.ui.bus.handler;

import com.alibaba.sdk.android.ui.bus.MatchInfo;
import java.util.LinkedHashMap;
import java.util.Map;

public class HandlerInfoBuilder
{
  private HandlerInfo handlerInfo = new HandlerInfo();
  
  public static HandlerInfoBuilder newHandlerInfo(String paramString)
  {
    HandlerInfoBuilder localHandlerInfoBuilder = new HandlerInfoBuilder();
    localHandlerInfoBuilder.handlerInfo.name = paramString;
    return localHandlerInfoBuilder;
  }
  
  public HandlerInfoBuilder addHandlerActionParameter(String paramString1, String paramString2)
  {
    this.handlerInfo.actionParameters.put(paramString1, paramString2);
    return this;
  }
  
  public HandlerInfoBuilder addMatchInfo(String paramString1, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    MatchInfo localMatchInfo = new MatchInfo();
    localMatchInfo.name = paramString1;
    localMatchInfo.type = paramString2;
    localMatchInfo.schemes = paramArrayOfString1;
    localMatchInfo.values = paramArrayOfString2;
    this.handlerInfo.matchInfos.put(paramString1, localMatchInfo);
    return this;
  }
  
  public HandlerInfo getHandlerInfo()
  {
    return this.handlerInfo;
  }
  
  public HandlerInfoBuilder setHandlerAction(String paramString)
  {
    this.handlerInfo.action = paramString;
    return this;
  }
  
  public HandlerInfoBuilder setHandlerOrder(Boolean paramBoolean1, Boolean paramBoolean2, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    this.handlerInfo.beforeAll = paramBoolean1;
    this.handlerInfo.afterAll = paramBoolean2;
    this.handlerInfo.before = paramArrayOfString1;
    this.handlerInfo.after = paramArrayOfString2;
    return this;
  }
  
  public HandlerInfoBuilder setHandlerScopes(String[] paramArrayOfString)
  {
    this.handlerInfo.scopes = paramArrayOfString;
    return this;
  }
  
  public HandlerInfoBuilder setHandlerType(String paramString)
  {
    this.handlerInfo.type = paramString;
    return this;
  }
  
  public HandlerInfoBuilder setHanlderScenarios(int[] paramArrayOfInt)
  {
    this.handlerInfo.scenarios = paramArrayOfInt;
    return this;
  }
  
  public HandlerInfoBuilder setUIThread(boolean paramBoolean)
  {
    this.handlerInfo.uiThread = paramBoolean;
    return this;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\bus\handler\HandlerInfoBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */