package com.alibaba.nb.android.trade.bridge.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.nb.android.trade.AliTradeContext;
import com.alibaba.nb.android.trade.constants.AliTradeUTConstants;
import com.alibaba.nb.android.trade.service.b.b;
import com.alibaba.nb.android.trade.service.config.impl.AliTradeConfigServiceImpl;
import com.alibaba.nb.android.trade.web.register.AliTradeServiceRegistry;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class a
  implements com.alibaba.nb.android.trade.bridge.a.a
{
  private static final String a = a.class.getSimpleName();
  private static volatile a d = null;
  private Object b = com.alibaba.nb.android.trade.utils.f.a.a("com.taobao.applink.TBAppLinkSDK", "getInstance", null, null, null);
  private boolean c;
  
  private a()
  {
    if (this.b == null) {
      com.alibaba.nb.android.trade.utils.d.a.b("AliTradeApplinkServiceImp", "ApplinkSDK沒有被依賴");
    }
  }
  
  private static Object a(Map<String, Object> paramMap, String paramString)
  {
    int i = 0;
    if ((paramMap == null) || (paramMap.size() == 0)) {
      return null;
    }
    Object localObject1;
    try
    {
      switch (paramString.hashCode())
      {
      case 2544374: 
        if (!paramString.equals("SHOP")) {
          break label789;
        }
      }
    }
    catch (Exception paramMap)
    {
      com.alibaba.nb.android.trade.utils.d.a.d("AliTradeApplinkServiceImp", "弱依赖Applink参数错误" + paramMap.getMessage());
      return null;
    }
    if (paramString.equals("DETAIL"))
    {
      i = 1;
      break label792;
      if (paramString.equals("TBURI"))
      {
        i = 2;
        break label792;
        if (paramString.equals("TBAuth"))
        {
          i = 3;
          break label792;
          if ((paramMap.get("shopId") != null) && ((paramMap.get("shopId") instanceof String)) && (!TextUtils.isEmpty((String)paramMap.get("shopId"))))
          {
            localObject1 = paramMap.get("shopId");
            localObject1 = com.alibaba.nb.android.trade.utils.f.a.a("com.taobao.applink.param.TBShopParam", new String[] { "java.lang.String" }, new Object[] { localObject1 });
          }
          for (;;)
          {
            Object localObject2 = paramMap.get("backURL");
            if ((localObject2 != null) && ((localObject2 instanceof String)) && (!TextUtils.isEmpty((String)localObject2))) {
              com.alibaba.nb.android.trade.utils.f.a.a("com.taobao.applink.param.TBBaseParam", "setBackUrl", new String[] { "java.lang.String" }, localObject1, new Object[] { localObject2 });
            }
            localObject2 = paramMap.get("e");
            if ((localObject2 != null) && ((localObject2 instanceof String)) && (!TextUtils.isEmpty((String)localObject2))) {
              com.alibaba.nb.android.trade.utils.f.a.a("com.taobao.applink.param.TBBaseParam", "setE", new String[] { "java.lang.String" }, localObject1, new Object[] { localObject2 });
            }
            localObject2 = paramMap.get("sign");
            if ((localObject2 != null) && ((localObject2 instanceof String)) && (!TextUtils.isEmpty((String)localObject2))) {
              com.alibaba.nb.android.trade.utils.f.a.a("com.taobao.applink.param.TBBaseParam", "setSign", new String[] { "java.lang.String" }, localObject1, new Object[] { localObject2 });
            }
            localObject2 = paramMap.get("type");
            if ((localObject2 != null) && ((localObject2 instanceof String)) && (!TextUtils.isEmpty((String)localObject2))) {
              com.alibaba.nb.android.trade.utils.f.a.a("com.taobao.applink.param.TBBaseParam", "setType", new String[] { "java.lang.String" }, localObject1, new Object[] { localObject2 });
            }
            localObject2 = paramMap.get("addParams");
            if ((localObject2 != null) && ((localObject2 instanceof HashMap)) && (((HashMap)localObject2).size() > 0)) {
              com.alibaba.nb.android.trade.utils.f.a.a("com.taobao.applink.param.TBBaseParam", "addExtraParams", new String[] { "java.util.HashMap" }, localObject1, new Object[] { localObject2 });
            }
            if (paramString.equals("TBAuth")) {
              break;
            }
            paramMap = paramMap.get("jsonParams");
            if ((paramMap == null) || (!(paramMap instanceof JSONObject)) || (((JSONObject)paramMap).length() <= 0)) {
              break;
            }
            com.alibaba.nb.android.trade.utils.f.a.a("com.taobao.applink.param.TBNavParam", "setParams", new String[] { "org.json.JSONObject" }, localObject1, new Object[] { paramMap });
            break;
            if ((paramMap.get("itemId") != null) && ((paramMap.get("itemId") instanceof String)) && (!TextUtils.isEmpty((String)paramMap.get("itemId"))))
            {
              localObject1 = paramMap.get("itemId");
              localObject1 = com.alibaba.nb.android.trade.utils.f.a.a("com.taobao.applink.param.TBDetailParam", new String[] { "java.lang.String" }, new Object[] { localObject1 });
              continue;
              if ((paramMap.get("url") != null) && ((paramMap.get("url") instanceof String)) && (!TextUtils.isEmpty((String)paramMap.get("url"))))
              {
                localObject1 = paramMap.get("url");
                localObject1 = com.alibaba.nb.android.trade.utils.f.a.a("com.taobao.applink.param.TBURIParam", new String[] { "java.lang.String" }, new Object[] { localObject1 });
                continue;
                if ((paramMap.get("requestCode") != null) && ((paramMap.get("requestCode") instanceof Integer)))
                {
                  localObject1 = paramMap.get("requestCode");
                  localObject1 = com.alibaba.nb.android.trade.utils.f.a.a("com.taobao.applink.param.TBAuthParam", new String[] { "java.lang.Integer" }, new Object[] { localObject1 });
                  continue;
                }
              }
            }
            localObject1 = null;
          }
        }
      }
    }
    label789:
    i = -1;
    label792:
    switch (i)
    {
    }
    return null;
    return localObject1;
  }
  
  private static void a(Object paramObject, boolean paramBoolean)
  {
    b localb = (b)AliTradeContext.serviceRegistry.getService(b.class, null);
    HashMap localHashMap;
    com.alibaba.nb.android.trade.service.a.a locala;
    if (localb != null)
    {
      localHashMap = new HashMap();
      if (!TextUtils.isEmpty(AliTradeConfigServiceImpl.getInstance().getAppKey())) {
        localHashMap.put("appkey", AliTradeConfigServiceImpl.getInstance().getAppKey());
      }
      locala = (com.alibaba.nb.android.trade.service.a.a)AliTradeContext.serviceRegistry.getService(com.alibaba.nb.android.trade.service.a.a.class, null);
      if (locala == null) {}
    }
    try
    {
      localHashMap.put("ybhpss", (String)locala.a("trade", "ybhpss"));
      localHashMap.put("param", com.alibaba.nb.android.trade.utils.c.a.a("param", paramObject));
      localHashMap.put("from", "nbsdk");
      if (paramBoolean)
      {
        paramObject = "1";
        localHashMap.put("isSuccess", paramObject);
        localb.a(AliTradeUTConstants.E_SHOW_APPLINK, "", localHashMap);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        paramObject = "0";
      }
    }
  }
  
  public static boolean b()
  {
    try
    {
      Class.forName("com.taobao.applink.TBAppLinkSDK");
      Context localContext = AliTradeContext.context;
      if (!((Boolean)com.alibaba.nb.android.trade.utils.f.a.a("com.taobao.applink.util.TBAppLinkUtil", "isSupportAppLinkSDK", new String[] { "android.content.Context" }, null, new Object[] { localContext })).booleanValue())
      {
        com.alibaba.nb.android.trade.utils.d.a.b("AliTradeApplinkServiceImp", "对不起，请使用最新版的手机淘宝");
        return Boolean.FALSE.booleanValue();
      }
      boolean bool = Boolean.TRUE.booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
      com.alibaba.nb.android.trade.utils.d.a.b("AliTradeApplinkServiceImp", "ApplinkSDK沒有被依賴");
    }
    return Boolean.FALSE.booleanValue();
  }
  
  public static a c()
  {
    if (d == null) {}
    try
    {
      if (d == null) {
        d = new a();
      }
      return d;
    }
    finally {}
  }
  
  private void d()
  {
    if (!this.c) {}
    try
    {
      Object localObject1 = AliTradeConfigServiceImpl.getInstance().getAppKey();
      localObject1 = com.alibaba.nb.android.trade.utils.f.a.a("com.taobao.applink.TBAppLinkParam", new String[] { "java.lang.String", "java.lang.String", "java.lang.String", "java.lang.String" }, new Object[] { localObject1, null, "backurl", "" });
      Object localObject2 = AliTradeContext.getUtdid();
      com.alibaba.nb.android.trade.utils.f.a.a("com.taobao.applink.TBAppLinkParam", "setUtdid", new String[] { "java.lang.String" }, localObject1, new Object[] { localObject2 });
      localObject2 = AliTradeConfigServiceImpl.getInstance().getWebTTID();
      com.alibaba.nb.android.trade.utils.f.a.a("com.taobao.applink.TBAppLinkParam", "setTTID", new String[] { "java.lang.String" }, localObject1, new Object[] { localObject2 });
      localObject2 = AliTradeConfigServiceImpl.getInstance().taobaoNativeSource;
      com.alibaba.nb.android.trade.utils.f.a.a("com.taobao.applink.TBAppLinkParam", "setSource", new String[] { "java.lang.String" }, localObject1, new Object[] { localObject2 });
      if (this.b != null)
      {
        localObject2 = this.b;
        com.alibaba.nb.android.trade.utils.f.a.a("com.taobao.applink.TBAppLinkSDK", "init", new String[] { "com.taobao.applink.TBAppLinkParam" }, localObject2, new Object[] { localObject1 });
        this.c = Boolean.TRUE.booleanValue();
      }
      return;
    }
    catch (Exception localException)
    {
      com.alibaba.nb.android.trade.utils.d.a.d("AliTradeApplinkServiceImp", "弱依赖Applink初始化失败");
    }
  }
  
  public final void a(Map<String, String> paramMap)
  {
    d();
    try
    {
      if ((this.b != null) && (paramMap != null))
      {
        Object localObject = com.alibaba.nb.android.trade.utils.f.a.a(this.b, "sOpenParam");
        if (localObject != null)
        {
          String str = (String)paramMap.get("backURL");
          if (!TextUtils.isEmpty(str)) {
            com.alibaba.nb.android.trade.utils.f.a.a(localObject, "mBackUrl", str);
          }
          str = (String)paramMap.get("pid");
          if (!TextUtils.isEmpty(str)) {
            com.alibaba.nb.android.trade.utils.f.a.a(localObject, "mPid", str);
          }
          str = (String)paramMap.get("tag");
          if (!TextUtils.isEmpty(str)) {
            com.alibaba.nb.android.trade.utils.f.a.a(localObject, "mTag", str);
          }
          str = (String)paramMap.get("TTID");
          if (!TextUtils.isEmpty(str)) {
            com.alibaba.nb.android.trade.utils.f.a.a(localObject, "mTtid", str);
          }
          str = (String)paramMap.get("source");
          if (!TextUtils.isEmpty(str)) {
            com.alibaba.nb.android.trade.utils.f.a.a(localObject, "mSource", str);
          }
          paramMap = (String)paramMap.get("utdid");
          if (!TextUtils.isEmpty(paramMap)) {
            com.alibaba.nb.android.trade.utils.f.a.a(localObject, "mUtdid", paramMap);
          }
        }
      }
      return;
    }
    catch (Exception paramMap)
    {
      paramMap.printStackTrace();
    }
  }
  
  public final boolean a()
  {
    Object localObject = AliTradeContext.context;
    localObject = (Boolean)com.alibaba.nb.android.trade.utils.f.a.a("com.taobao.applink.util.TBAppLinkUtil", "isSupportAppLinkSDK", new String[] { "android.content.Context" }, null, new Object[] { localObject });
    if (localObject == null) {
      return false;
    }
    return ((Boolean)localObject).booleanValue();
  }
  
  public final boolean a(Context paramContext, Map<String, Object> paramMap)
  {
    com.alibaba.nb.android.trade.utils.d.a.b(a, "调用applink jumpshop方法,传入参数为:params=" + paramMap);
    Object localObject1 = null;
    d();
    try
    {
      if (this.b != null)
      {
        Object localObject2 = a(paramMap, "SHOP");
        if (localObject2 != null)
        {
          localObject1 = this.b;
          localObject1 = com.alibaba.nb.android.trade.utils.f.a.a("com.taobao.applink.TBAppLinkSDK", "jumpShop", new String[] { "android.content.Context", "com.taobao.applink.param.TBShopParam" }, localObject1, new Object[] { paramContext, localObject2 });
        }
        if ((localObject1 != null) && ((localObject1 instanceof Boolean)))
        {
          boolean bool = ((Boolean)localObject1).booleanValue();
          a(paramMap, bool);
          paramMap = new StringBuilder("Applink調用jumpShop");
          if (bool) {}
          for (paramContext = "成功";; paramContext = "失败")
          {
            com.alibaba.nb.android.trade.utils.d.a.b("AliTradeApplinkServiceImp", paramContext);
            return bool;
          }
        }
      }
      return Boolean.FALSE.booleanValue();
    }
    catch (Exception paramContext)
    {
      com.alibaba.nb.android.trade.utils.d.a.d("AliTradeApplinkServiceImp", "Applink調用jumpShop失败：" + paramContext.getMessage());
    }
  }
  
  public final boolean b(Context paramContext, Map<String, Object> paramMap)
  {
    com.alibaba.nb.android.trade.utils.d.a.b(a, "调用applink jumpdetail方法,传入参数为:params=" + paramMap);
    Object localObject1 = null;
    d();
    try
    {
      Object localObject2 = a(paramMap, "DETAIL");
      if (localObject2 != null)
      {
        localObject1 = this.b;
        localObject1 = com.alibaba.nb.android.trade.utils.f.a.a("com.taobao.applink.TBAppLinkSDK", "jumpDetail", new String[] { "android.content.Context", "com.taobao.applink.param.TBDetailParam" }, localObject1, new Object[] { paramContext, localObject2 });
      }
      if ((localObject1 != null) && ((localObject1 instanceof Boolean)))
      {
        boolean bool = ((Boolean)localObject1).booleanValue();
        a(paramMap, bool);
        paramMap = new StringBuilder("Applink調用jumpDetail");
        if (bool) {}
        for (paramContext = "成功";; paramContext = "失败")
        {
          com.alibaba.nb.android.trade.utils.d.a.b("AliTradeApplinkServiceImp", paramContext);
          return bool;
        }
      }
      return Boolean.FALSE.booleanValue();
    }
    catch (Exception paramContext)
    {
      com.alibaba.nb.android.trade.utils.d.a.d("AliTradeApplinkServiceImp", "Applink調用jumpDetail失败：" + paramContext.getMessage());
    }
  }
  
  public final boolean c(Context paramContext, Map<String, Object> paramMap)
  {
    com.alibaba.nb.android.trade.utils.d.a.b(a, "调用applink jumpuri方法,传入参数为:params=" + paramMap);
    Object localObject1 = null;
    d();
    try
    {
      Object localObject2 = a(paramMap, "TBURI");
      if (localObject2 != null)
      {
        localObject1 = this.b;
        localObject1 = com.alibaba.nb.android.trade.utils.f.a.a("com.taobao.applink.TBAppLinkSDK", "jumpTBURI", new String[] { "android.content.Context", "com.taobao.applink.param.TBURIParam" }, localObject1, new Object[] { paramContext, localObject2 });
      }
      if ((localObject1 != null) && ((localObject1 instanceof Boolean)))
      {
        boolean bool = ((Boolean)localObject1).booleanValue();
        a(paramMap, bool);
        paramMap = new StringBuilder("Applink調用jumpTBURI");
        if (bool) {}
        for (paramContext = "成功";; paramContext = "失败")
        {
          com.alibaba.nb.android.trade.utils.d.a.b("AliTradeApplinkServiceImp", paramContext);
          return bool;
        }
      }
      return Boolean.FALSE.booleanValue();
    }
    catch (Exception paramContext)
    {
      com.alibaba.nb.android.trade.utils.d.a.d("AliTradeApplinkServiceImp", "Applink調用jumpTBURI失败：" + paramContext.getMessage());
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\bridge\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */