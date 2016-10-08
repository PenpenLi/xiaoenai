package com.alibaba.sdk.android.ui.bus;

import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.sdk.android.ConfigManager;
import com.alibaba.sdk.android.Environment;
import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.executor.ExecutorService;
import com.alibaba.sdk.android.plugin.config.PluginConfigurations;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.ui.UIContext;
import com.alibaba.sdk.android.ui.bus.filter.Filter;
import com.alibaba.sdk.android.ui.bus.filter.FilterContext;
import com.alibaba.sdk.android.ui.bus.filter.FilterInfo;
import com.alibaba.sdk.android.ui.bus.filter.FilterInfoBuilder;
import com.alibaba.sdk.android.ui.bus.handler.Handler;
import com.alibaba.sdk.android.ui.bus.handler.HandlerContext;
import com.alibaba.sdk.android.ui.bus.handler.HandlerInfo;
import com.alibaba.sdk.android.ui.bus.handler.HandlerInfoBuilder;
import com.alibaba.sdk.android.util.PersistentUtils.ObjectStore;
import com.alibaba.sdk.android.util.SortUtils;
import com.alibaba.sdk.android.util.SortUtils.SortInfo;
import com.taobao.tae.sdk.log.SdkCoreLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class UIBus
  implements UIBusInfoRegistry
{
  private static final UIBus INSTANCE = new UIBus();
  private static final String TAG = "UIBus";
  private volatile Map<String, Filter> filters = new LinkedHashMap();
  private volatile Map<String, Handler> handlers = new LinkedHashMap();
  private PersistentUtils.ObjectStore<UIBusInfo> infoStore = new PersistentUtils.ObjectStore("alisdk_uibus_config", ".ubconf");
  private volatile boolean initialized;
  private LinkedHashMap<String, FilterInfo> registeredFilterInfos = new LinkedHashMap();
  private LinkedHashMap<String, HandlerInfo> registeredHandlerInfos = new LinkedHashMap();
  private UIBusInfo uiBusInfo;
  
  private void doFilters(FilterContext paramFilterContext)
  {
    Iterator localIterator = this.filters.entrySet().iterator();
    for (;;)
    {
      Filter localFilter;
      if (localIterator.hasNext())
      {
        localFilter = (Filter)((Map.Entry)localIterator.next()).getValue();
        if (ConfigManager.DEBUG) {
          SdkCoreLog.startTimeRecord(localFilter.getFilterInfo().name);
        }
        if ((!isScenarioSupported(paramFilterContext.getScenario(), localFilter.getFilterInfo().scenarios)) || ("true".equals(paramFilterContext.getContextParameter("skip_" + localFilter.getFilterInfo().name))) || (!isScopeSupported(paramFilterContext.getScope(), localFilter.getFilterInfo().scopes))) {}
      }
      else
      {
        try
        {
          if (localFilter.doFilter(paramFilterContext))
          {
            paramFilterContext.commit();
            boolean bool = localFilter.getFilterInfo().procceed;
            if (!bool) {
              return;
            }
          }
        }
        catch (Exception localException)
        {
          AliSDKLogger.e("ui", "Fail to execute the filter " + localFilter.getFilterInfo().name, localException);
        }
      }
      if (ConfigManager.DEBUG) {
        SdkCoreLog.d(localFilter.getFilterInfo().name, SdkCoreLog.content("uiperf", SdkCoreLog.getTimeUsed(localFilter.getFilterInfo().name), new String[] { "success" }));
      }
    }
  }
  
  private boolean doHandlers(HandlerContext paramHandlerContext)
  {
    boolean bool;
    Iterator localIterator;
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      bool = true;
      localIterator = this.handlers.entrySet().iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label261;
      }
      Handler localHandler = (Handler)((Map.Entry)localIterator.next()).getValue();
      if (ConfigManager.DEBUG) {
        SdkCoreLog.startTimeRecord(localHandler.getHandlerInfo().name);
      }
      if ((isScenarioSupported(paramHandlerContext.getScenario(), localHandler.getHandlerInfo().scenarios)) && (!"true".equals(paramHandlerContext.getContextParameter("skip_" + localHandler.getHandlerInfo().name))) && (isScopeSupported(paramHandlerContext.getScope(), localHandler.getHandlerInfo().scopes)) && (executeHandler(localHandler, paramHandlerContext, bool)))
      {
        if (ConfigManager.DEBUG) {
          SdkCoreLog.d(localHandler.getHandlerInfo().name, SdkCoreLog.content("uiperf", SdkCoreLog.getTimeUsed(localHandler.getHandlerInfo().name), new String[] { "success" }));
        }
        return true;
        bool = false;
        break;
      }
      if (ConfigManager.DEBUG) {
        SdkCoreLog.d(localHandler.getHandlerInfo().name, SdkCoreLog.content("uiperf", SdkCoreLog.getTimeUsed(localHandler.getHandlerInfo().name), new String[] { "skip" }));
      }
    }
    label261:
    return false;
  }
  
  private boolean executeHandler(Handler paramHandler, HandlerContext paramHandlerContext, boolean paramBoolean)
  {
    CountDownLatch localCountDownLatch;
    BooleanHolder localBooleanHolder;
    if ((paramHandler.getHandlerInfo().uiThread) && (!paramBoolean))
    {
      localCountDownLatch = new CountDownLatch(1);
      localBooleanHolder = new BooleanHolder(null);
      UIContext.executorService.postUITask(new UIBus.1(this, localBooleanHolder, paramHandler, paramHandlerContext, localCountDownLatch));
    }
    try
    {
      localCountDownLatch.await(3L, TimeUnit.SECONDS);
      if (localBooleanHolder.returnValue == null) {
        return false;
      }
      return localBooleanHolder.returnValue.booleanValue();
      try
      {
        paramBoolean = paramHandler.doHandle(paramHandlerContext);
        return paramBoolean;
      }
      catch (Throwable paramHandlerContext)
      {
        AliSDKLogger.e("ui", "fail to execute the handler " + paramHandler.getHandlerInfo().name, paramHandlerContext);
        return false;
      }
    }
    catch (Exception paramHandler)
    {
      for (;;) {}
    }
  }
  
  private UIBusInfo generateDefaultUIBusInfo(boolean paramBoolean)
  {
    FilterInfo[] arrayOfFilterInfo = (FilterInfo[])this.registeredFilterInfos.values().toArray(new FilterInfo[0]);
    if (paramBoolean) {
      SortUtils.sorts(arrayOfFilterInfo);
    }
    HandlerInfo[] arrayOfHandlerInfo = (HandlerInfo[])this.registeredHandlerInfos.values().toArray(new HandlerInfo[0]);
    if (paramBoolean) {
      SortUtils.sorts(arrayOfHandlerInfo);
    }
    UIBusInfo localUIBusInfo = new UIBusInfo();
    localUIBusInfo.version = 0;
    localUIBusInfo.filterInfos = new LinkedHashMap();
    localUIBusInfo.handlerInfos = new LinkedHashMap();
    int j = arrayOfFilterInfo.length;
    int i = 0;
    while (i < j)
    {
      FilterInfo localFilterInfo = arrayOfFilterInfo[i];
      localUIBusInfo.filterInfos.put(localFilterInfo.name, localFilterInfo);
      i += 1;
    }
    j = arrayOfHandlerInfo.length;
    i = 0;
    while (i < j)
    {
      arrayOfFilterInfo = arrayOfHandlerInfo[i];
      localUIBusInfo.handlerInfos.put(arrayOfFilterInfo.name, arrayOfFilterInfo);
      i += 1;
    }
    localUIBusInfo.environment = UIContext.appContext.getEnvironment().ordinal();
    return localUIBusInfo;
  }
  
  public static UIBus getDefault()
  {
    return INSTANCE;
  }
  
  private void initializeRuntimeComponents()
  {
    Map.Entry localEntry;
    try
    {
      LinkedHashMap localLinkedHashMap1 = new LinkedHashMap();
      localIterator = this.uiBusInfo.filterInfos.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        localLinkedHashMap1.put(localEntry.getKey(), ((FilterInfo)localEntry.getValue()).createFilter());
      }
      this.filters = localException;
    }
    catch (Exception localException)
    {
      AliSDKLogger.e("ui", "fail to initialize filter/handler", localException);
      return;
    }
    LinkedHashMap localLinkedHashMap2 = new LinkedHashMap();
    Iterator localIterator = this.uiBusInfo.handlerInfos.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      localLinkedHashMap2.put(localEntry.getKey(), ((HandlerInfo)localEntry.getValue()).createHandler());
    }
    this.handlers = localLinkedHashMap2;
  }
  
  private boolean isScenarioSupported(int paramInt, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      return true;
    }
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label32;
      }
      if (paramInt == paramArrayOfInt[i]) {
        break;
      }
      i += 1;
    }
    label32:
    return false;
  }
  
  private boolean isScopeSupported(String paramString, String[] paramArrayOfString)
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
  
  private void loadLocalConfig()
  {
    try
    {
      UIBusInfo localUIBusInfo = (UIBusInfo)this.infoStore.readItem();
      if (localUIBusInfo == null)
      {
        AliSDKLogger.d("UIBus", "UIBus info is not found in disk, use default");
        localObject2 = generateDefaultUIBusInfo(true);
        this.uiBusInfo = ((UIBusInfo)localObject2);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        AliSDKLogger.e("ui", "fail to load persistent uibus config", localThrowable);
        Object localObject1 = null;
        continue;
        Object localObject2 = localObject1;
        if (((UIBusInfo)localObject1).environment != UIContext.appContext.getEnvironment().ordinal())
        {
          AliSDKLogger.d("UIBus", "UIBus environment index not match, reset to the default BusInfo");
          localObject2 = generateDefaultUIBusInfo(true);
        }
      }
    }
  }
  
  public String doFilters(UIBusRequest paramUIBusRequest)
  {
    if (paramUIBusRequest.url == null) {
      return null;
    }
    FilterContext localFilterContext = new FilterContext(paramUIBusRequest.scenario, paramUIBusRequest.url, paramUIBusRequest.extraParams);
    localFilterContext.setScope(paramUIBusRequest.scope);
    if (paramUIBusRequest.ignoreList != null)
    {
      paramUIBusRequest = paramUIBusRequest.ignoreList;
      int j = paramUIBusRequest.length;
      int i = 0;
      while (i < j)
      {
        String str = paramUIBusRequest[i];
        localFilterContext.setContextParameter("skip_" + str, "true");
        i += 1;
      }
    }
    doFilters(localFilterContext);
    return localFilterContext.getUri();
  }
  
  public ExecutionResult execute(UIBusRequest paramUIBusRequest)
  {
    if (paramUIBusRequest.url == null) {
      return new ExecutionResult(false, paramUIBusRequest.url);
    }
    if (!this.initialized) {
      initialize();
    }
    Object localObject = new FilterContext(paramUIBusRequest.scenario, paramUIBusRequest.url, paramUIBusRequest.extraParams);
    ((FilterContext)localObject).setScope(paramUIBusRequest.scope);
    doFilters((FilterContext)localObject);
    HandlerContext localHandlerContext = new HandlerContext(paramUIBusRequest.scenario, ((FilterContext)localObject).getUri(), paramUIBusRequest.extraParams);
    localHandlerContext.setScope(paramUIBusRequest.scope);
    boolean bool;
    label148:
    int j;
    int i;
    if ((paramUIBusRequest.scenario == 1) || (paramUIBusRequest.scenario == 2))
    {
      localHandlerContext.webView = paramUIBusRequest.webView;
      localHandlerContext.queryParameters.putAll(((FilterContext)localObject).queryParameters);
      if (paramUIBusRequest.preferredHandlers == null) {
        break label340;
      }
      if (Looper.getMainLooper() != Looper.myLooper()) {
        break label292;
      }
      bool = true;
      paramUIBusRequest = paramUIBusRequest.preferredHandlers;
      j = paramUIBusRequest.length;
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        break label340;
      }
      localObject = paramUIBusRequest[i];
      localObject = (Handler)this.handlers.get(localObject);
      if (localObject != null)
      {
        if ((isScopeSupported(localHandlerContext.getScope(), ((Handler)localObject).getHandlerInfo().scopes)) && (isScenarioSupported(localHandlerContext.getScenario(), ((Handler)localObject).getHandlerInfo().scenarios)) && (executeHandler((Handler)localObject, localHandlerContext, bool)))
        {
          return new ExecutionResult(true, localHandlerContext.getUri());
          if (paramUIBusRequest.scenario == 3)
          {
            localHandlerContext.activity = paramUIBusRequest.activity;
            break;
          }
          if (paramUIBusRequest.scenario != 4) {
            break;
          }
          localHandlerContext.webViewProxy = paramUIBusRequest.webViewProxy;
          break;
          label292:
          bool = false;
          break label148;
        }
        localHandlerContext.setContextParameter("skip_" + ((Handler)localObject).getHandlerInfo().name, "true");
      }
      i += 1;
    }
    label340:
    return new ExecutionResult(doHandlers(localHandlerContext), localHandlerContext.getUri());
  }
  
  public void initialize()
  {
    if (this.initialized) {
      return;
    }
    try
    {
      if (this.initialized) {
        return;
      }
    }
    finally {}
    loadLocalConfig();
    String str = UIContext.pluginConfigurations.getStringValue("uibus-configs");
    if (!TextUtils.isEmpty(str)) {
      updateUIBusInfo(str);
    }
    if (UIContext.pluginConfigurations.getBooleanValue("enableDebug", false)) {
      AliSDKLogger.d("ui", this.uiBusInfo.toJSONObject().toString());
    }
    initializeRuntimeComponents();
    this.initialized = true;
  }
  
  /* Error */
  public void refresh()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 466	com/alibaba/sdk/android/ui/UIContext:pluginConfigurations	Lcom/alibaba/sdk/android/plugin/config/PluginConfigurations;
    //   5: ldc_w 468
    //   8: invokeinterface 473 2 0
    //   13: astore_1
    //   14: aload_1
    //   15: invokestatic 479	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: istore_2
    //   19: iload_2
    //   20: ifeq +6 -> 26
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: aload_1
    //   28: invokevirtual 483	com/alibaba/sdk/android/ui/bus/UIBus:updateUIBusInfo	(Ljava/lang/String;)Z
    //   31: ifeq -8 -> 23
    //   34: aload_0
    //   35: invokespecial 498	com/alibaba/sdk/android/ui/bus/UIBus:initializeRuntimeComponents	()V
    //   38: goto -15 -> 23
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	UIBus
    //   13	15	1	str	String
    //   41	4	1	localObject	Object
    //   18	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	19	41	finally
    //   26	38	41	finally
  }
  
  public void registerFilterInfo(FilterInfo paramFilterInfo)
  {
    this.registeredFilterInfos.put(paramFilterInfo.name, paramFilterInfo);
  }
  
  public void registerHandlerInfo(HandlerInfo paramHandlerInfo)
  {
    this.registeredHandlerInfos.put(paramHandlerInfo.name, paramHandlerInfo);
  }
  
  public boolean updateUIBusInfo(String paramString)
  {
    int j;
    boolean bool;
    Object localObject2;
    int k;
    int i;
    label115:
    Object localObject3;
    Object localObject4;
    FilterInfo localFilterInfo;
    try
    {
      localObject1 = new JSONObject(paramString);
      j = ((JSONObject)localObject1).getInt("version");
      if (this.uiBusInfo == null) {
        throw new Exception("must load local UIBus before update");
      }
    }
    catch (Exception paramString)
    {
      AliSDKLogger.e("ui", "fail to update uibus, the error message is " + paramString.getMessage(), paramString);
      do
      {
        bool = false;
        return bool;
      } while (j <= this.uiBusInfo.version);
      paramString = generateDefaultUIBusInfo(false);
      localObject2 = ((JSONObject)localObject1).optJSONArray("filters");
      if (localObject2 == null) {
        break label243;
      }
      k = ((JSONArray)localObject2).length();
      i = 0;
      if (i >= k) {
        break label243;
      }
      localObject3 = ((JSONArray)localObject2).getJSONObject(i);
      localObject4 = ((JSONObject)localObject3).getString("name");
      if (((JSONObject)localObject3).optBoolean("disabled", false))
      {
        paramString.filterInfos.remove(localObject4);
      }
      else
      {
        localFilterInfo = (FilterInfo)this.registeredFilterInfos.get(localObject4);
        if ((((JSONObject)localObject3).optBoolean("metadata-complete", false)) || (localFilterInfo == null))
        {
          localFilterInfo = FilterInfoBuilder.newFilterInfo((String)localObject4).getFilterInfo();
          localFilterInfo.merge((JSONObject)localObject3);
          paramString.filterInfos.put(localObject4, localFilterInfo);
        }
      }
    }
    finally {}
    localFilterInfo.merge((JSONObject)localObject3);
    break label554;
    label243:
    Object localObject1 = ((JSONObject)localObject1).optJSONArray("handlers");
    if (localObject1 != null)
    {
      k = ((JSONArray)localObject1).length();
      i = 0;
    }
    for (;;)
    {
      if (i < k)
      {
        localObject2 = ((JSONArray)localObject1).getJSONObject(i);
        localObject3 = ((JSONObject)localObject2).getString("name");
        if (((JSONObject)localObject2).optBoolean("disabled", false))
        {
          paramString.handlerInfos.remove(localObject3);
        }
        else
        {
          localObject4 = (HandlerInfo)paramString.handlerInfos.get(localObject3);
          if ((((JSONObject)localObject2).optBoolean("metadata-complete", false)) || (localObject4 == null))
          {
            localObject4 = HandlerInfoBuilder.newHandlerInfo((String)localObject3).getHandlerInfo();
            ((HandlerInfo)localObject4).merge((JSONObject)localObject2);
            paramString.handlerInfos.put(localObject3, localObject4);
          }
          else
          {
            ((HandlerInfo)localObject4).merge((JSONObject)localObject2);
          }
        }
      }
      else
      {
        paramString.version = j;
        localObject1 = (FilterInfo[])paramString.filterInfos.values().toArray(new FilterInfo[0]);
        SortUtils.sorts((SortUtils.SortInfo[])localObject1);
        localObject2 = paramString.filterInfos;
        ((LinkedHashMap)localObject2).clear();
        j = localObject1.length;
        i = 0;
        while (i < j)
        {
          localObject3 = localObject1[i];
          ((LinkedHashMap)localObject2).put(((FilterInfo)localObject3).name, localObject3);
          i += 1;
        }
        localObject1 = (HandlerInfo[])paramString.handlerInfos.values().toArray(new HandlerInfo[0]);
        SortUtils.sorts((SortUtils.SortInfo[])localObject1);
        localObject2 = paramString.handlerInfos;
        ((LinkedHashMap)localObject2).clear();
        j = localObject1.length;
        i = 0;
        while (i < j)
        {
          localObject3 = localObject1[i];
          ((LinkedHashMap)localObject2).put(((HandlerInfo)localObject3).name, localObject3);
          i += 1;
        }
        this.uiBusInfo = paramString;
        this.infoStore.writeItem(paramString);
        bool = true;
        break;
        label554:
        i += 1;
        break label115;
      }
      i += 1;
    }
  }
  
  private static class BooleanHolder
  {
    public Boolean returnValue;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\bus\UIBus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */