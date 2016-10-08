package com.alibaba.nb.android.trade.a;

import android.text.TextUtils;
import com.alibaba.nb.android.trade.AliTradeContext;
import com.alibaba.nb.android.trade.bridge.login.AliTradeLoginService;
import com.alibaba.nb.android.trade.callback.AliTradeFailureCallback;
import com.alibaba.nb.android.trade.callback.AliTradeTaokeTraceCallback;
import com.alibaba.nb.android.trade.model.AliTradeTaokeParams;
import com.alibaba.nb.android.trade.service.config.impl.AliTradeConfigServiceImpl;
import com.alibaba.nb.android.trade.web.register.AliTradeServiceRegistry;
import com.alibaba.sdk.android.impl.KernelContext;
import com.alibaba.sdk.android.registry.ServiceRegistry;
import com.alibaba.sdk.android.rpc.RpcService;
import com.alibaba.sdk.android.rpc.model.RpcRequest;
import com.alibaba.sdk.android.session.model.Session;
import java.util.HashMap;
import java.util.Map;

public final class d
{
  public static final d a = new d();
  
  public static com.alibaba.nb.android.trade.model.inner.a<String> a(Map<String, Object> paramMap, AliTradeTaokeParams paramAliTradeTaokeParams)
  {
    Object localObject = null;
    if (paramAliTradeTaokeParams == null) {
      return null;
    }
    RpcRequest localRpcRequest = new RpcRequest();
    localRpcRequest.target = "sdktaoketrace";
    HashMap localHashMap = new HashMap();
    if ((paramAliTradeTaokeParams.pid == null) || (!paramAliTradeTaokeParams.pid.startsWith("mm_")))
    {
      paramAliTradeTaokeParams = com.alibaba.nb.android.trade.utils.a.a.a(802, new Object[] { paramAliTradeTaokeParams.pid });
      if (paramAliTradeTaokeParams == null) {
        break label156;
      }
    }
    for (;;)
    {
      com.alibaba.nb.android.trade.utils.d.a.a("taoke", paramAliTradeTaokeParams);
      localHashMap.put("taokeTrace", paramMap);
      localRpcRequest.params = localHashMap;
      paramAliTradeTaokeParams = (RpcService)KernelContext.serviceRegistry.getService(RpcService.class, null);
      paramMap = (Map<String, Object>)localObject;
      if (paramAliTradeTaokeParams != null) {}
      try
      {
        paramMap = paramAliTradeTaokeParams.invoke(localRpcRequest);
        if (com.alibaba.nb.android.trade.utils.d.a.a()) {
          com.alibaba.nb.android.trade.utils.d.a.b("taoke", "tktrace result json: " + paramMap);
        }
        return com.alibaba.nb.android.trade.utils.c.a.a(paramMap);
        label156:
        paramAliTradeTaokeParams = null;
      }
      catch (Throwable paramMap)
      {
        for (;;)
        {
          paramMap.printStackTrace();
          com.alibaba.nb.android.trade.utils.d.a.b("taoke", "rpc调用错误,errormsg=" + paramMap.getMessage());
          paramMap = (Map<String, Object>)localObject;
        }
      }
    }
  }
  
  private static com.alibaba.nb.android.trade.model.inner.a<String> b(Map<String, Object> paramMap)
  {
    Object localObject2 = null;
    Object localObject3 = new StringBuilder("开始淘客同步换url，参数为taokeInfo:");
    Object localObject1;
    if (paramMap != null) {
      localObject1 = paramMap.toString();
    }
    for (;;)
    {
      com.alibaba.nb.android.trade.utils.d.a.b("taoke", (String)localObject1);
      localObject1 = new RpcRequest();
      ((RpcRequest)localObject1).target = "thirdpartlogintk";
      localObject3 = new HashMap();
      ((Map)localObject3).put("taokeInfo", paramMap);
      ((RpcRequest)localObject1).params = ((Map)localObject3);
      localObject3 = (RpcService)KernelContext.serviceRegistry.getService(RpcService.class, null);
      paramMap = (Map<String, Object>)localObject2;
      if (localObject3 != null) {}
      try
      {
        paramMap = ((RpcService)localObject3).invoke((RpcRequest)localObject1);
        return com.alibaba.nb.android.trade.utils.c.a.a(paramMap);
        localObject1 = null;
      }
      catch (Throwable paramMap)
      {
        for (;;)
        {
          paramMap.printStackTrace();
          com.alibaba.nb.android.trade.utils.d.a.d("taoke", "rpc调用异常,error msg =" + paramMap.getMessage());
          paramMap = (Map<String, Object>)localObject2;
        }
      }
    }
  }
  
  public final com.alibaba.nb.android.trade.model.inner.a<String> a(Map<String, Object> paramMap, String paramString1, AliTradeTaokeParams paramAliTradeTaokeParams, String paramString2, AliTradeFailureCallback paramAliTradeFailureCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder("taoke异步打点开始，参数为：");
    if (paramMap != null) {}
    for (String str = paramMap.toString();; str = null)
    {
      com.alibaba.nb.android.trade.utils.d.a.b("taoke", str + "url=" + paramString1 + "rpcReferer=" + paramString2);
      AliTradeContext.executorService.a(new f(this, paramMap, paramString1, paramAliTradeTaokeParams, paramString2, paramAliTradeFailureCallback));
      return null;
    }
  }
  
  public final void a(Map<String, Object> paramMap, String paramString1, boolean paramBoolean, AliTradeTaokeParams paramAliTradeTaokeParams, String paramString2, AliTradeTaokeTraceCallback paramAliTradeTaokeTraceCallback, AliTradeFailureCallback paramAliTradeFailureCallback)
  {
    if (!com.alibaba.nb.android.trade.utils.e.a.a(AliTradeContext.context))
    {
      com.alibaba.nb.android.trade.utils.d.a.d("taoke", "网络无连接，请连接网络后再试");
      paramAliTradeTaokeTraceCallback.genTaokeUrl(null);
      return;
    }
    if ((paramMap == null) || (paramAliTradeTaokeParams == null))
    {
      com.alibaba.nb.android.trade.utils.d.a.d("taoke", "淘客参数不存在");
      return;
    }
    com.alibaba.nb.android.trade.utils.d.a.b("taoke", "添加淘客参数");
    paramMap.put("url", paramString1);
    paramMap.put("appKey", AliTradeConfigServiceImpl.getInstance().getAppKey());
    paramMap.put("utdid", AliTradeContext.getUtdid());
    label136:
    StringBuilder localStringBuilder;
    if (!TextUtils.isEmpty(paramAliTradeTaokeParams.subPid))
    {
      paramMap.put("subPid", paramAliTradeTaokeParams.subPid);
      if (TextUtils.isEmpty(paramAliTradeTaokeParams.unionId)) {
        break label286;
      }
      paramMap.put("unionId", paramAliTradeTaokeParams.unionId);
      paramMap.put("pid", paramAliTradeTaokeParams.pid);
      localObject = (AliTradeLoginService)AliTradeContext.serviceRegistry.getService(AliTradeLoginService.class, null);
      if (localObject != null)
      {
        localObject = ((AliTradeLoginService)localObject).getSession();
        if ((localObject != null) && (((Session)localObject).getUserId() != null)) {
          paramMap.put("userId", ((Session)localObject).getUserId());
        }
      }
      localStringBuilder = new StringBuilder("淘客参数:");
      if (paramMap == null) {
        break label299;
      }
    }
    label286:
    label299:
    for (Object localObject = paramMap.toString();; localObject = null)
    {
      com.alibaba.nb.android.trade.utils.d.a.b("taoke", (String)localObject);
      if (paramBoolean) {
        break label305;
      }
      a(paramMap, paramString1, paramAliTradeTaokeParams, paramString2, paramAliTradeFailureCallback);
      paramAliTradeTaokeTraceCallback.genTaokeUrl(null);
      return;
      paramMap.put("subPid", null);
      break;
      paramMap.put("unionId", null);
      break label136;
    }
    label305:
    paramMap = new e(this, paramMap, paramAliTradeTaokeTraceCallback, paramString1, paramAliTradeTaokeParams, paramString2, paramAliTradeFailureCallback);
    AliTradeContext.executorService.a(paramMap);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */