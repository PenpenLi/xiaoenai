package com.alibaba.nb.android.trade.a;

import android.content.Context;
import com.alibaba.nb.android.trade.AliTradeContext;
import com.alibaba.nb.android.trade.bridge.a.a;
import com.alibaba.nb.android.trade.model.inner.AliTradeApplinkOpenType;
import com.alibaba.nb.android.trade.service.config.impl.AliTradeConfigServiceImpl;
import com.alibaba.nb.android.trade.web.register.AliTradeServiceRegistry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  private static final String a = c.class.getSimpleName();
  
  public static boolean a(Context paramContext, AliTradeApplinkOpenType paramAliTradeApplinkOpenType, String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap)
  {
    Object localObject1 = paramMap;
    if (paramMap == null) {
      localObject1 = new HashMap();
    }
    for (;;)
    {
      try
      {
        Iterator localIterator = ((Map)localObject1).entrySet().iterator();
        paramMap = new JSONObject();
        try
        {
          if (!localIterator.hasNext()) {
            continue;
          }
          localObject2 = (Map.Entry)localIterator.next();
          paramMap.put((String)((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
          continue;
          localJSONException1.printStackTrace();
        }
        catch (JSONException localJSONException1) {}
      }
      catch (JSONException localJSONException2)
      {
        Object localObject2;
        a locala;
        paramMap = null;
        continue;
      }
      locala = (a)AliTradeContext.serviceRegistry.getService(a.class, null);
      if (locala != null)
      {
        localObject2 = new HashMap();
        ((Map)localObject2).put("backURL", paramString4);
        ((Map)localObject2).put("pid", paramString3);
        ((Map)localObject2).put("tag", paramString2);
        ((Map)localObject2).put("TTID", AliTradeConfigServiceImpl.getInstance().getWebTTID());
        ((Map)localObject2).put("source", "bc");
        ((Map)localObject2).put("utdid", AliTradeContext.getUtdid());
        locala.a((Map)localObject2);
        paramString2 = new HashMap();
        paramString2.put("backURL", paramString4);
        paramString2.put("addParams", localObject1);
        paramString2.put("jsonParams", paramMap);
      }
      switch (1.a[paramAliTradeApplinkOpenType.ordinal()])
      {
      default: 
        return Boolean.FALSE.booleanValue();
        new JSONObject().put("params", paramMap.toString());
      }
    }
    if (paramString1 != null) {
      paramString2.put("itemId", paramString1);
    }
    return locala.b(paramContext, paramString2);
    if (paramString1 != null) {
      paramString2.put("shopId", paramString1);
    }
    return locala.a(paramContext, paramString2);
    return locala.c(paramContext, paramString2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */