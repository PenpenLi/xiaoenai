package com.alibaba.nb.android.trade.web.interception.base;

import com.alibaba.nb.android.trade.AliTradeContext;
import com.alibaba.nb.android.trade.service.config.impl.AliTradeConfigServiceImpl;
import com.alibaba.nb.android.trade.web.register.AliTradeServiceRegistry;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
{
  private static Pattern a = Pattern.compile("\\$\\{([\\d\\w\\._\\-]+)\\}");
  
  public static String a(String paramString, Map<String, String> paramMap)
  {
    Matcher localMatcher;
    StringBuffer localStringBuffer;
    Object localObject2;
    Object localObject1;
    for (;;)
    {
      try
      {
        localMatcher = a.matcher(paramString);
        localStringBuffer = new StringBuffer();
        if (!localMatcher.find()) {
          break label211;
        }
        localObject2 = localMatcher.group(1);
        localObject1 = (String)paramMap.get(localObject2);
        if (localObject1 == null) {
          break;
        }
      }
      catch (Exception paramMap)
      {
        com.alibaba.nb.android.trade.utils.d.a.a("AliTradeELResolver", "Fail to parse the " + paramString, paramMap);
        return "";
      }
      localMatcher.appendReplacement(localStringBuffer, (String)localObject2);
    }
    if ("ttid".equals(localObject2))
    {
      localObject1 = AliTradeConfigServiceImpl.getInstance().getWebTTID();
    }
    else if ("appKey".equals(localObject2))
    {
      localObject1 = AliTradeConfigServiceImpl.getInstance().getAppKey();
    }
    else if ("sdkVersion".equals(localObject2))
    {
      localObject1 = AliTradeContext.sdkVersion;
    }
    else if ("timestamp".equals(localObject2))
    {
      localObject1 = String.valueOf(System.currentTimeMillis());
    }
    else if ("utdid".equals(localObject2))
    {
      localObject1 = AliTradeContext.getUtdid();
    }
    else
    {
      localObject1 = (com.alibaba.nb.android.trade.service.config.a)AliTradeContext.serviceRegistry.getService(com.alibaba.nb.android.trade.service.config.a.class, null);
      if (localObject1 == null) {
        break label239;
      }
      localObject1 = (String)((com.alibaba.nb.android.trade.service.config.a)localObject1).getGlobalConfig((String)localObject2);
      break label227;
      label211:
      localMatcher.appendTail(localStringBuffer);
      paramMap = localStringBuffer.toString();
      return paramMap;
    }
    for (;;)
    {
      label227:
      localObject2 = localObject1;
      if (localObject1 != null) {
        break;
      }
      localObject2 = "";
      break;
      label239:
      localObject1 = null;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\web\interception\base\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */