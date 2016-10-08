package com.alibaba.nb.android.trade.uibridge;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.alibaba.nb.android.trade.AliTradeContext;
import com.alibaba.nb.android.trade.callback.AliTradeProcessCallback;
import com.alibaba.nb.android.trade.model.AliTradeShowParams;
import com.alibaba.nb.android.trade.model.AliTradeTaokeParams;
import com.alibaba.nb.android.trade.service.config.impl.AliTradeConfigServiceImpl;
import com.alibaba.nb.android.trade.web.register.AliTradeServiceRegistry;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AliTradeService
  implements IAliTradeService
{
  private AliTradeShowParams a;
  private AliTradeTaokeParams b;
  private Map<String, String> c;
  private Map<String, String> d;
  
  private static String a(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {
      return null;
    }
    Object localObject = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramMap.get(str1);
      if (i != 0) {
        ((StringBuilder)localObject).append("&");
      }
      try
      {
        ((StringBuilder)localObject).append(str1 + "=" + URLEncoder.encode(new String(str2), "utf-8"));
        i += 1;
      }
      catch (Exception paramMap)
      {
        com.alibaba.nb.android.trade.utils.d.a.d("AliTradeService", "构建Ybhpss参数错误：" + paramMap.getMessage());
        return null;
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramMap = Base64.encodeToString(new String((StringBuilder)localObject).getBytes(), 0);
      localObject = (com.alibaba.nb.android.trade.service.a.a)AliTradeContext.serviceRegistry.getService(com.alibaba.nb.android.trade.service.a.a.class, null);
      if (localObject != null) {
        ((com.alibaba.nb.android.trade.service.a.a)localObject).a("trade", "ybhpss", paramMap);
      }
      return paramMap;
    }
    return new String((StringBuilder)localObject);
  }
  
  private Map<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ttid", AliTradeConfigServiceImpl.getInstance().getWebTTID());
    localHashMap.put("umpChannel", "1-" + AliTradeConfigServiceImpl.getInstance().getAppKey());
    localHashMap.put("u_channel", "1-" + AliTradeConfigServiceImpl.getInstance().getAppKey());
    if ((this.c == null) || (this.c.size() == 0)) {
      return localHashMap;
    }
    if ((this.c.get("isv_code") == null) && (AliTradeConfigServiceImpl.getInstance().getIsvCode() != null)) {
      localHashMap.put("isv_code", AliTradeConfigServiceImpl.getInstance().getIsvCode());
    }
    Object localObject = new HashMap();
    Iterator localIterator = this.c.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)this.c.get(str1);
      if ((str2 != null) && (!TextUtils.isEmpty(str2))) {
        if (AliTradeContext.firstLevelKeys.contains(str1)) {
          localHashMap.put(str1, str2);
        } else {
          ((Map)localObject).put(str1, str2);
        }
      }
    }
    ((Map)localObject).put("ttid", AliTradeConfigServiceImpl.getInstance().getWebTTID());
    localObject = a((Map)localObject);
    if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject))) {
      localHashMap.put("ybhpss", localObject);
    }
    return localHashMap;
  }
  
  private void a(Activity paramActivity, WebView paramWebView, WebViewClient paramWebViewClient, String paramString, AliTradeBasePage paramAliTradeBasePage)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("trade_taokeParam", this.b);
    localHashMap.put("ui_contextParams", this.d);
    if (!a(paramAliTradeBasePage)) {}
    for (boolean bool = true;; bool = false)
    {
      localHashMap.put("show_by_h5", String.valueOf(bool));
      localHashMap.put("backLoginFail", String.valueOf(paramAliTradeBasePage.isBackWhenLoginFail()));
      com.alibaba.nb.android.trade.utils.d.a.b("AliTradeService", "h5打开，上下文参数为params=" + localHashMap);
      if ((paramWebView == null) || (AliTradeContext.executorService == null)) {
        break;
      }
      com.alibaba.nb.android.trade.utils.d.a.a("AliTradeService", "使用第三方webview打开");
      com.alibaba.nb.android.trade.a.a.a.a(paramString, paramWebView, paramWebViewClient, localHashMap);
      return;
    }
    com.alibaba.nb.android.trade.utils.d.a.a("AliTradeService", "使用Trade的webview打开");
    paramWebView = com.alibaba.nb.android.trade.a.a.a;
    com.alibaba.nb.android.trade.a.a.a(paramActivity, paramString, (Serializable)localHashMap);
  }
  
  private void a(AliTradeBasePage paramAliTradeBasePage, Map<String, String> paramMap)
  {
    com.alibaba.nb.android.trade.service.b.b localb = (com.alibaba.nb.android.trade.service.b.b)AliTradeContext.serviceRegistry.getService(com.alibaba.nb.android.trade.service.b.b.class, null);
    HashMap localHashMap;
    if ((paramAliTradeBasePage.getApi() != null) && (localb != null))
    {
      localHashMap = new HashMap();
      localHashMap.putAll(paramMap);
      if (!TextUtils.isEmpty(AliTradeConfigServiceImpl.getInstance().getAppKey())) {
        localHashMap.put("appkey", AliTradeConfigServiceImpl.getInstance().getAppKey());
      }
      if (this.b != null) {
        break label109;
      }
    }
    label109:
    for (paramMap = "{}";; paramMap = this.b.toString())
    {
      localHashMap.put("taokeParam", paramMap);
      localb.a(paramAliTradeBasePage.getApi(), "", localHashMap);
      return;
    }
  }
  
  private boolean a(AliTradeBasePage paramAliTradeBasePage)
  {
    int i = 0;
    boolean bool = false;
    if (paramAliTradeBasePage.requireOpenType() != 0)
    {
      if (2 == paramAliTradeBasePage.requireOpenType()) {
        bool = true;
      }
      return bool;
    }
    String[] arrayOfString;
    int j;
    switch (1.a[this.a.getOpenType().ordinal()])
    {
    default: 
      paramAliTradeBasePage = paramAliTradeBasePage.genOpenUrl();
      if (paramAliTradeBasePage != null)
      {
        arrayOfString = AliTradeContext.nativeOpenPatterns;
        j = arrayOfString.length;
      }
      break;
    case 1: 
    case 2: 
      while (i < j)
      {
        if ((paramAliTradeBasePage.matches(arrayOfString[i])) && (!AliTradeConfigServiceImpl.getInstance().isForceH5()))
        {
          return Boolean.TRUE.booleanValue();
          return Boolean.FALSE.booleanValue();
          return Boolean.TRUE.booleanValue();
        }
        i += 1;
      }
    }
    return Boolean.FALSE.booleanValue();
  }
  
  public int show(Activity paramActivity, WebView paramWebView, WebViewClient paramWebViewClient, AliTradeBasePage paramAliTradeBasePage, AliTradeShowParams paramAliTradeShowParams, AliTradeTaokeParams paramAliTradeTaokeParams, Map<String, String> paramMap, AliTradeProcessCallback paramAliTradeProcessCallback)
  {
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder("AliTradeService.show(): AliTradePage: ");
        if (paramAliTradeBasePage == null)
        {
          str = "null";
          localStringBuilder = localStringBuilder.append(str).append(" taoke.pid: ");
          if (paramAliTradeTaokeParams == null)
          {
            str = "null";
            localStringBuilder = localStringBuilder.append(str).append(" activity:");
            if (paramActivity != null) {
              continue;
            }
            str = "null";
            com.alibaba.nb.android.trade.utils.d.a.a("AliTradeService", str);
            if (AliTradeContext.checkInitStatus().booleanValue()) {
              continue;
            }
            Toast.makeText(paramActivity, "初始化未完成,请稍后!", 0).show();
            return -1;
          }
        }
        else
        {
          str = paramAliTradeBasePage.toString();
          continue;
        }
        String str = paramAliTradeTaokeParams.pid;
        continue;
        str = paramActivity.toString();
        continue;
        if (paramAliTradeProcessCallback == null)
        {
          com.alibaba.nb.android.trade.utils.b.a(paramAliTradeProcessCallback, com.alibaba.nb.android.trade.utils.a.a.a(14, new Object[] { "tradeProcessCallback" }));
          i = 0;
          if ((i == 0) || (!paramAliTradeBasePage.checkParams()))
          {
            com.alibaba.nb.android.trade.utils.d.a.d("AliTradeService", "page检测参数出错，流程中止");
            return -1;
          }
        }
        else
        {
          if (paramActivity == null)
          {
            com.alibaba.nb.android.trade.utils.b.a(paramAliTradeProcessCallback, com.alibaba.nb.android.trade.utils.a.a.a(14, new Object[] { "Activity" }));
            i = 0;
            continue;
          }
          if (paramAliTradeBasePage != null) {
            break label666;
          }
          com.alibaba.nb.android.trade.utils.b.a(paramAliTradeProcessCallback, com.alibaba.nb.android.trade.utils.a.a.a(14, new Object[] { "AliTradePage" }));
          i = 0;
          continue;
        }
        if ((paramMap != null) && (paramMap.get("isv_code") != null))
        {
          AliTradeContext.isvCode = (String)paramMap.get("isv_code");
          this.c = paramMap;
          this.d = a();
          com.alibaba.nb.android.trade.utils.d.a.b("AliTradeService", "url 参数为 mUrlParams=" + this.d);
          com.alibaba.nb.android.trade.callback.AliTradeCallbackContext.tradeProcessCallback = paramAliTradeProcessCallback;
          this.a = paramAliTradeShowParams;
          if (this.a == null) {
            this.a = new AliTradeShowParams();
          }
          AliTradeContext.title = this.a.getTitle();
          this.b = paramAliTradeTaokeParams;
          if ((this.b == null) && (AliTradeConfigServiceImpl.getInstance().getNBTTradeTaokeParams() != null))
          {
            this.b = AliTradeConfigServiceImpl.getInstance().getTaokeParams();
            com.alibaba.nb.android.trade.utils.d.a.b("AliTradeService", "使用全局淘客参数,taokeParams=" + paramAliTradeTaokeParams);
          }
          boolean bool = a(paramAliTradeBasePage);
          if ((com.alibaba.nb.android.trade.bridge.a.a)AliTradeContext.serviceRegistry.getService(com.alibaba.nb.android.trade.bridge.a.a.class, null) != null) {
            break label663;
          }
          com.alibaba.nb.android.trade.utils.d.a.a("AliTradeService", "没有依赖applink，所以通过H5打开");
          bool = Boolean.FALSE.booleanValue();
          if (bool)
          {
            com.alibaba.nb.android.trade.utils.d.a.b("AliTradeService", "通过native打开，打开参数为taokeparamers=" + this.b + " showparamers=" + this.a + " urlParamers=" + this.d);
            if (paramAliTradeBasePage.a(this.b, this.a, this.d, paramActivity))
            {
              com.alibaba.nb.android.trade.utils.d.a.a("AliTradeService", "通过applink打开手淘成功");
              a(paramAliTradeBasePage, this.d);
              return 0;
            }
          }
        }
        else
        {
          AliTradeContext.isvCode = null;
          continue;
        }
        if (!paramAliTradeBasePage.needTaoke(this.b)) {
          break label642;
        }
      }
      catch (Throwable paramActivity)
      {
        com.alibaba.nb.android.trade.utils.d.a.d("AliTradeService", paramActivity.getMessage());
        if (paramAliTradeProcessCallback != null) {
          paramAliTradeProcessCallback.onFailure(0, "Trade SDK运行出错");
        }
        return -1;
      }
      com.alibaba.nb.android.trade.utils.d.a.a("AliTradeService", "进行淘客打点");
      paramAliTradeBasePage.taokeTraceAndGenUrl(this.b, new a(this, paramAliTradeBasePage, paramActivity, paramWebView, paramWebViewClient));
      for (;;)
      {
        a(paramAliTradeBasePage, this.d);
        return 1;
        label642:
        a(paramActivity, paramWebView, paramWebViewClient, paramAliTradeBasePage.getAddParamsUrl(this.d), paramAliTradeBasePage);
      }
      label663:
      continue;
      label666:
      int i = 1;
    }
  }
  
  public int show(Activity paramActivity, AliTradeBasePage paramAliTradeBasePage, AliTradeShowParams paramAliTradeShowParams, AliTradeTaokeParams paramAliTradeTaokeParams, Map<String, String> paramMap, AliTradeProcessCallback paramAliTradeProcessCallback)
  {
    return show(paramActivity, null, null, paramAliTradeBasePage, paramAliTradeShowParams, paramAliTradeTaokeParams, paramMap, paramAliTradeProcessCallback);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\uibridge\AliTradeService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */