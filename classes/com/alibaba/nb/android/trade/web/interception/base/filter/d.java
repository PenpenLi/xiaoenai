package com.alibaba.nb.android.trade.web.interception.base.filter;

import com.alibaba.nb.android.trade.web.interception.base.handler.AliTradeMatchInfo;
import java.util.LinkedHashMap;
import java.util.Map;

public final class d
{
  private AliTradeFilterInfo a = new AliTradeFilterInfo();
  
  public static d a(String paramString)
  {
    d locald = new d();
    locald.a.name = paramString;
    return locald;
  }
  
  public final AliTradeFilterInfo a()
  {
    return this.a;
  }
  
  public final d a(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AliTradeFilterInfo.ActionInfo localActionInfo = new AliTradeFilterInfo.ActionInfo();
    localActionInfo.name = paramString1;
    localActionInfo.type = paramString2;
    localActionInfo.parameters = paramMap;
    this.a.actionInfos.put(localActionInfo.name, localActionInfo);
    return this;
  }
  
  public final d a(String paramString1, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AliTradeMatchInfo localAliTradeMatchInfo = new AliTradeMatchInfo();
    localAliTradeMatchInfo.name = paramString1;
    localAliTradeMatchInfo.type = paramString2;
    localAliTradeMatchInfo.schemes = paramArrayOfString1;
    localAliTradeMatchInfo.values = paramArrayOfString2;
    this.a.matchInfos.put(localAliTradeMatchInfo.name, localAliTradeMatchInfo);
    return this;
  }
  
  public final d a(int[] paramArrayOfInt)
  {
    this.a.scenarios = paramArrayOfInt;
    return this;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\web\interception\base\filter\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */