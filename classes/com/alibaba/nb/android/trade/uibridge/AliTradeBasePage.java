package com.alibaba.nb.android.trade.uibridge;

import android.app.Activity;
import android.text.TextUtils;
import com.alibaba.nb.android.trade.AliTradeContext;
import com.alibaba.nb.android.trade.callback.AliTradeCallbackContext;
import com.alibaba.nb.android.trade.callback.AliTradeTaokeTraceCallback;
import com.alibaba.nb.android.trade.constants.AliTradeUTConstants;
import com.alibaba.nb.android.trade.model.AliTradeShowParams;
import com.alibaba.nb.android.trade.model.AliTradeTaokeParams;
import com.alibaba.nb.android.trade.service.config.impl.AliTradeConfigServiceImpl;
import com.alibaba.nb.android.trade.utils.b;
import com.alibaba.nb.android.trade.web.interception.base.d;
import com.alibaba.nb.android.trade.web.register.AliTradeServiceRegistry;
import java.util.HashMap;
import java.util.Map;

public class AliTradeBasePage
{
  public static final int NOT_REQUIRE = 0;
  public static final int REQUIRE_H5 = 1;
  public static final int REQUIRE_NATIVE = 2;
  private static final String b = AliTradeBasePage.class.getSimpleName();
  protected String a;
  
  protected boolean a(AliTradeTaokeParams paramAliTradeTaokeParams, AliTradeShowParams paramAliTradeShowParams, Map<String, String> paramMap, Activity paramActivity)
  {
    com.alibaba.nb.android.trade.bridge.a.a locala = (com.alibaba.nb.android.trade.bridge.a.a)AliTradeContext.serviceRegistry.getService(com.alibaba.nb.android.trade.bridge.a.a.class, null);
    if (locala != null) {
      try
      {
        HashMap localHashMap1 = new HashMap();
        localHashMap1.put("url", genOpenUrl());
        HashMap localHashMap2 = new HashMap();
        if (paramAliTradeTaokeParams != null) {
          localHashMap2.put("pid", paramAliTradeTaokeParams.pid);
        }
        if (paramAliTradeShowParams.getBackUrl() != null) {
          localHashMap2.put("backURL", paramAliTradeShowParams.getBackUrl());
        }
        for (;;)
        {
          localHashMap2.put("tag", AliTradeConfigServiceImpl.getInstance().getIsvCode());
          localHashMap2.put("TTID", AliTradeConfigServiceImpl.getInstance().getWebTTID());
          localHashMap2.put("source", "bc");
          localHashMap2.put("utdid", AliTradeContext.getUtdid());
          locala.a(localHashMap2);
          localHashMap1.put("addParams", paramMap);
          locala.c(paramActivity, localHashMap1);
          break;
          localHashMap2.put("backURL", "alisdk://");
        }
        com.alibaba.nb.android.trade.utils.d.a.d("AliTradePage", "请依赖1Applink或升级手机淘宝，并拉起手淘");
      }
      catch (Exception paramAliTradeTaokeParams)
      {
        com.alibaba.nb.android.trade.utils.d.a.d("AliTradePage", "请依赖Applink，并拉起手淘" + paramAliTradeTaokeParams.getMessage());
      }
    }
    if (AliTradeCallbackContext.tradeProcessCallback != null) {
      b.a(AliTradeCallbackContext.tradeProcessCallback, com.alibaba.nb.android.trade.utils.a.a.a(14, new Object[] { "Applink" }));
    }
    return false;
    return true;
  }
  
  protected boolean checkParams()
  {
    return true;
  }
  
  protected String genOpenUrl()
  {
    if (!TextUtils.isEmpty(this.a)) {
      return this.a;
    }
    return null;
  }
  
  public String getAddParamsUrl(String paramString, Map<String, String> paramMap)
  {
    com.alibaba.nb.android.trade.utils.d.a.b(b, "首次进入加参，参数： urlParams = " + paramMap + "  url=" + paramString);
    if (paramMap != null)
    {
      com.alibaba.nb.android.trade.web.interception.base.a.a locala = new com.alibaba.nb.android.trade.web.interception.base.a.a();
      locala.e = 1;
      String str = paramString;
      if (paramString == null) {
        str = genOpenUrl();
      }
      locala.d = str;
      locala.i = new HashMap();
      locala.i.put("ui_contextParams", paramMap);
      paramMap = d.a().a(locala);
      com.alibaba.nb.android.trade.utils.d.a.b(b, "首次加参后结果为 url=" + paramMap);
      paramString = paramMap;
      if (paramMap == null) {
        paramString = genOpenUrl();
      }
      return paramString;
    }
    return genOpenUrl();
  }
  
  public String getAddParamsUrl(Map<String, String> paramMap)
  {
    return getAddParamsUrl(null, paramMap);
  }
  
  public String getApi()
  {
    return AliTradeUTConstants.E_SHOW;
  }
  
  public boolean isBackWhenLoginFail()
  {
    return false;
  }
  
  public boolean needTaoke(AliTradeTaokeParams paramAliTradeTaokeParams)
  {
    return paramAliTradeTaokeParams != null;
  }
  
  public int requireOpenType()
  {
    return 0;
  }
  
  public void taokeTraceAndGenUrl(AliTradeTaokeParams paramAliTradeTaokeParams, AliTradeTaokeTraceCallback paramAliTradeTaokeTraceCallback) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\uibridge\AliTradeBasePage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */