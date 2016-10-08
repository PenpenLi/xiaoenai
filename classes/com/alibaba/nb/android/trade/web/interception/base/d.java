package com.alibaba.nb.android.trade.web.interception.base;

import android.os.Looper;
import com.alibaba.nb.android.trade.AliTradeContext;
import com.alibaba.nb.android.trade.utils.AliTradeSortUtils;
import com.alibaba.nb.android.trade.utils.AliTradeSortUtils.SortInfo;
import com.alibaba.nb.android.trade.web.interception.base.filter.AliTradeFilterInfo;
import com.alibaba.nb.android.trade.web.interception.base.filter.c;
import com.alibaba.nb.android.trade.web.interception.base.handler.AliTradeHandler;
import com.alibaba.nb.android.trade.web.interception.base.handler.AliTradeHandlerContext;
import com.alibaba.nb.android.trade.web.interception.base.handler.AliTradeHandlerInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class d
  implements f
{
  private static final d a = new d();
  private volatile Map<String, AliTradeHandler> b = new LinkedHashMap();
  private volatile Map<String, com.alibaba.nb.android.trade.web.interception.base.filter.a> c = new LinkedHashMap();
  private AliTradeInterceptionInfo d;
  private volatile boolean e;
  private LinkedHashMap<String, AliTradeHandlerInfo> f = new LinkedHashMap();
  private LinkedHashMap<String, AliTradeFilterInfo> g = new LinkedHashMap();
  
  public static d a()
  {
    return a;
  }
  
  private void a(c paramc)
  {
    Iterator localIterator = this.c.entrySet().iterator();
    StringBuilder localStringBuilder;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject = (com.alibaba.nb.android.trade.web.interception.base.filter.a)((Map.Entry)localIterator.next()).getValue();
        if ((!a(paramc.getScenario(), ((com.alibaba.nb.android.trade.web.interception.base.filter.a)localObject).a().scenarios)) || ("true".equals(paramc.getContextParameter("skip_" + ((com.alibaba.nb.android.trade.web.interception.base.filter.a)localObject).a().name))) || (!a(paramc.getScope(), ((com.alibaba.nb.android.trade.web.interception.base.filter.a)localObject).a().scopes))) {}
      }
      else
      {
        try
        {
          if (((com.alibaba.nb.android.trade.web.interception.base.filter.a)localObject).a(paramc))
          {
            paramc.a();
            boolean bool = ((com.alibaba.nb.android.trade.web.interception.base.filter.a)localObject).a().procceed;
            if (!bool) {
              return;
            }
          }
        }
        catch (Exception localException)
        {
          localStringBuilder = new StringBuilder("Fail to execute the AliTradeFilter ");
          if (localObject == null) {
            break label202;
          }
        }
      }
    }
    if (((com.alibaba.nb.android.trade.web.interception.base.filter.a)localObject).a() != null) {}
    label202:
    for (Object localObject = ((com.alibaba.nb.android.trade.web.interception.base.filter.a)localObject).a().name;; localObject = null)
    {
      com.alibaba.nb.android.trade.utils.d.a.a("ui", (String)localObject, localException);
      break;
    }
  }
  
  private static boolean a(int paramInt, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      return true;
    }
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label30;
      }
      if (paramInt == paramArrayOfInt[i]) {
        break;
      }
      i += 1;
    }
    label30:
    return false;
  }
  
  private boolean a(AliTradeHandler paramAliTradeHandler, AliTradeHandlerContext paramAliTradeHandlerContext, boolean paramBoolean)
  {
    CountDownLatch localCountDownLatch;
    Object localObject;
    if ((paramAliTradeHandler.getHandlerInfo().uiThread) && (!paramBoolean))
    {
      localCountDownLatch = new CountDownLatch(1);
      localObject = new a((byte)0);
      AliTradeContext.executorService.b(new e(this, (a)localObject, paramAliTradeHandler, paramAliTradeHandlerContext, localCountDownLatch));
    }
    try
    {
      localCountDownLatch.await(3L, TimeUnit.SECONDS);
      if (((a)localObject).a == null) {
        return false;
      }
      return ((a)localObject).a.booleanValue();
      try
      {
        paramBoolean = paramAliTradeHandler.doHandle(paramAliTradeHandlerContext);
        return paramBoolean;
      }
      catch (Throwable paramAliTradeHandlerContext)
      {
        localObject = new StringBuilder("fail to execute the AliTradeHandler ");
        if ((paramAliTradeHandler != null) && (paramAliTradeHandler.getHandlerInfo() != null)) {}
        for (paramAliTradeHandler = paramAliTradeHandler.getHandlerInfo().name;; paramAliTradeHandler = null)
        {
          com.alibaba.nb.android.trade.utils.d.a.a("ui", paramAliTradeHandler, paramAliTradeHandlerContext);
          return false;
        }
      }
    }
    catch (Exception paramAliTradeHandler)
    {
      for (;;) {}
    }
  }
  
  private boolean a(AliTradeHandlerContext paramAliTradeHandlerContext)
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      Iterator localIterator = this.b.entrySet().iterator();
      AliTradeHandler localAliTradeHandler;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localAliTradeHandler = (AliTradeHandler)((Map.Entry)localIterator.next()).getValue();
      } while ((!a(paramAliTradeHandlerContext.getScenario(), localAliTradeHandler.getHandlerInfo().scenarios)) || ("true".equals(paramAliTradeHandlerContext.getContextParameter("skip_" + localAliTradeHandler.getHandlerInfo().name))) || (!a(paramAliTradeHandlerContext.getScope(), localAliTradeHandler.getHandlerInfo().scopes)) || (!a(localAliTradeHandler, paramAliTradeHandlerContext, bool)));
      return true;
    }
    return false;
  }
  
  private static boolean a(String paramString, String[] paramArrayOfString)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      bool1 = true;
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (paramString == null);
    int j = paramArrayOfString.length;
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      if (paramString.equals(paramArrayOfString[i])) {
        return true;
      }
      i += 1;
    }
  }
  
  private void c()
  {
    Map.Entry localEntry;
    try
    {
      LinkedHashMap localLinkedHashMap1 = new LinkedHashMap();
      localIterator = this.d.filterInfos.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        localLinkedHashMap1.put(localEntry.getKey(), ((AliTradeFilterInfo)localEntry.getValue()).createFilter());
      }
      this.c = localException;
    }
    catch (Exception localException)
    {
      com.alibaba.nb.android.trade.utils.d.a.a("ui", "fail to initialize filter/handler", localException);
      return;
    }
    LinkedHashMap localLinkedHashMap2 = new LinkedHashMap();
    Iterator localIterator = this.d.handlerInfos.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      localLinkedHashMap2.put(localEntry.getKey(), ((AliTradeHandlerInfo)localEntry.getValue()).createHandler());
    }
    this.b = localLinkedHashMap2;
  }
  
  public final String a(com.alibaba.nb.android.trade.web.interception.base.a.a parama)
  {
    if (parama.d == null) {
      return null;
    }
    c localc = new c(parama.e, parama.d, parama.i);
    localc.setScope(parama.f);
    if (parama.j != null)
    {
      parama = parama.j;
      int j = parama.length;
      int i = 0;
      while (i < j)
      {
        String str = parama[i];
        localc.setContextParameter("skip_" + str, "true");
        i += 1;
      }
    }
    a(localc);
    return localc.getUri();
  }
  
  public final void a(AliTradeFilterInfo paramAliTradeFilterInfo)
  {
    this.g.put(paramAliTradeFilterInfo.name, paramAliTradeFilterInfo);
  }
  
  public final void a(AliTradeHandlerInfo paramAliTradeHandlerInfo)
  {
    this.f.put(paramAliTradeHandlerInfo.name, paramAliTradeHandlerInfo);
  }
  
  public final b b(com.alibaba.nb.android.trade.web.interception.base.a.a parama)
  {
    if (parama.d == null) {
      return new b(false, parama.d);
    }
    if (!this.e) {
      b();
    }
    Object localObject = new c(parama.e, parama.d, parama.i);
    ((c)localObject).setScope(parama.f);
    a((c)localObject);
    AliTradeHandlerContext localAliTradeHandlerContext = new AliTradeHandlerContext(parama.e, ((c)localObject).getUri(), parama.i);
    localAliTradeHandlerContext.setScope(parama.f);
    boolean bool;
    label164:
    int j;
    int i;
    if ((parama.e == 1) || (parama.e == 2))
    {
      localAliTradeHandlerContext.webView = parama.a;
      localAliTradeHandlerContext.webViewWrapper = parama.b;
      localAliTradeHandlerContext.activity = parama.g;
      localAliTradeHandlerContext.queryParameters.putAll(((c)localObject).queryParameters);
      if (parama.h == null) {
        break label351;
      }
      if (Looper.getMainLooper() != Looper.myLooper()) {
        break label306;
      }
      bool = true;
      parama = parama.h;
      j = parama.length;
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        break label351;
      }
      localObject = parama[i];
      localObject = (AliTradeHandler)this.b.get(localObject);
      if (localObject != null)
      {
        if ((a(localAliTradeHandlerContext.getScope(), ((AliTradeHandler)localObject).getHandlerInfo().scopes)) && (a(localAliTradeHandlerContext.getScenario(), ((AliTradeHandler)localObject).getHandlerInfo().scenarios)) && (a((AliTradeHandler)localObject, localAliTradeHandlerContext, bool)))
        {
          return new b(true, localAliTradeHandlerContext.getUri());
          if (parama.e == 3)
          {
            localAliTradeHandlerContext.activity = parama.g;
            break;
          }
          if (parama.e != 4) {
            break;
          }
          localAliTradeHandlerContext.NBTWebViewProxy = parama.c;
          break;
          label306:
          bool = false;
          break label164;
        }
        localAliTradeHandlerContext.setContextParameter("skip_" + ((AliTradeHandler)localObject).getHandlerInfo().name, "true");
      }
      i += 1;
    }
    label351:
    return new b(a(localAliTradeHandlerContext), localAliTradeHandlerContext.getUri());
  }
  
  public final void b()
  {
    if (this.e) {
      return;
    }
    try
    {
      if (this.e) {
        return;
      }
    }
    finally {}
    com.alibaba.nb.android.trade.utils.d.a.b("AliTradeInterceptionManager", "AliTradeInterceptionManager info is not found in disk, use default");
    Object localObject2 = (AliTradeFilterInfo[])this.g.values().toArray(new AliTradeFilterInfo[0]);
    AliTradeSortUtils.a((AliTradeSortUtils.SortInfo[])localObject2);
    AliTradeHandlerInfo[] arrayOfAliTradeHandlerInfo = (AliTradeHandlerInfo[])this.f.values().toArray(new AliTradeHandlerInfo[0]);
    AliTradeSortUtils.a(arrayOfAliTradeHandlerInfo);
    AliTradeInterceptionInfo localAliTradeInterceptionInfo = new AliTradeInterceptionInfo();
    localAliTradeInterceptionInfo.version = 0;
    localAliTradeInterceptionInfo.filterInfos = new LinkedHashMap();
    localAliTradeInterceptionInfo.handlerInfos = new LinkedHashMap();
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      Object localObject3 = localObject2[i];
      localAliTradeInterceptionInfo.filterInfos.put(((AliTradeFilterInfo)localObject3).name, localObject3);
      i += 1;
    }
    j = arrayOfAliTradeHandlerInfo.length;
    i = 0;
    while (i < j)
    {
      localObject2 = arrayOfAliTradeHandlerInfo[i];
      localAliTradeInterceptionInfo.handlerInfos.put(((AliTradeHandlerInfo)localObject2).name, localObject2);
      i += 1;
    }
    this.d = localAliTradeInterceptionInfo;
    c();
    this.e = true;
  }
  
  private static final class a
  {
    public Boolean a;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\web\interception\base\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */