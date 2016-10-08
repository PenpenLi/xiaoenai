package com.alibaba.sdk.android.plugin.config.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.alibaba.sdk.android.ConfigManager;
import com.alibaba.sdk.android.config.PropertyChangeListener;
import com.alibaba.sdk.android.executor.ExecutorService;
import com.alibaba.sdk.android.impl.KernelContext;
import com.alibaba.sdk.android.plugin.PluginInfo;
import com.alibaba.sdk.android.plugin.config.PluginSystemConfigurations;
import com.alibaba.sdk.android.registry.ServiceRegistry;
import com.alibaba.sdk.android.repository.PluginRepository;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.util.CommonUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.json.JSONObject;

public class MemoryBasedConfigurations
  implements PluginSystemConfigurations
{
  private static final String CONFIG = "config";
  private static final String GLOBAL_PROPERTY_OWNER = "$global$";
  private static final String TAG = "kernel";
  private Context context;
  private Map<String, String> globalProperties = new ConcurrentHashMap();
  private ConcurrentMap<String, Map<String, String>> pluginProperties = new ConcurrentHashMap();
  private SharedPreferences sp;
  private final Set<String> startRequiredPluginNames = new LinkedHashSet();
  
  public MemoryBasedConfigurations(Context paramContext, PluginRepository paramPluginRepository)
  {
    this.context = paramContext;
    initialize(paramPluginRepository);
  }
  
  private void addPropertyChangeEvent(List<InternalPropertyChangeEvent> paramList, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    InternalPropertyChangeEvent localInternalPropertyChangeEvent = new InternalPropertyChangeEvent(null);
    localInternalPropertyChangeEvent.owner = paramString1;
    localInternalPropertyChangeEvent.key = paramString2;
    localInternalPropertyChangeEvent.newValue = paramString4;
    localInternalPropertyChangeEvent.oldValue = paramString3;
    paramList.add(localInternalPropertyChangeEvent);
  }
  
  private Map<String, String> getDynamicConfigs()
  {
    localHashMap = new HashMap();
    try
    {
      this.sp = this.context.getSharedPreferences("ALIBABA_SDK_DYNAMIC_CONFIG", 0);
      Object localObject = this.sp.getString("config", null);
      if (localObject != null)
      {
        localObject = new JSONObject((String)localObject);
        Iterator localIterator = ((JSONObject)localObject).keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localHashMap.put(str, ((JSONObject)localObject).optString(str));
        }
      }
      return localHashMap;
    }
    catch (Throwable localThrowable)
    {
      AliSDKLogger.e("kernel", localThrowable);
    }
  }
  
  private void initialize(PluginRepository paramPluginRepository)
  {
    paramPluginRepository = paramPluginRepository.getPluginInfos();
    if (paramPluginRepository.length == 0) {}
    do
    {
      return;
      int j = paramPluginRepository.length;
      int i = 0;
      if (i < j)
      {
        Object localObject1 = paramPluginRepository[i];
        Object localObject2 = ((PluginInfo)localObject1).name;
        this.startRequiredPluginNames.add(localObject2);
        if (((PluginInfo)localObject1).properties.size() == 0) {}
        for (;;)
        {
          i += 1;
          break;
          localObject2 = new HashMap(((PluginInfo)localObject1).properties);
          this.pluginProperties.put(((PluginInfo)localObject1).name, localObject2);
        }
      }
      overrideProperties(getDynamicConfigs(), false);
      overrideProperties(ConfigManager.userProperties, false);
    } while (!AliSDKLogger.isDebugEnabled());
    AliSDKLogger.d("kernel", "Initialize plugin system persistent configurations successfully");
  }
  
  private void overrideProperties(Map<String, String> paramMap, boolean paramBoolean)
  {
    ArrayList localArrayList = null;
    if (paramBoolean) {
      localArrayList = new ArrayList();
    }
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramMap = (Map.Entry)localIterator.next();
      if ((paramMap.getKey() != null) && (paramMap.getValue() != null))
      {
        int i = ((String)paramMap.getKey()).indexOf('.');
        Object localObject;
        if (i == -1)
        {
          localObject = (String)this.globalProperties.put(((String)paramMap.getKey()).trim(), ((String)paramMap.getValue()).trim());
          if ((paramBoolean) && (!CommonUtils.isEqual(localObject, paramMap.getValue()))) {
            addPropertyChangeEvent(localArrayList, "$global$", (String)paramMap.getKey(), (String)localObject, (String)paramMap.getValue());
          }
        }
        else if ((i != -1) && (i != ((String)paramMap.getKey()).length() - 1))
        {
          String str3 = ((String)paramMap.getKey()).substring(0, i).trim();
          String str1 = ((String)paramMap.getKey()).substring(i + 1).trim();
          String str2 = ((String)paramMap.getValue()).trim();
          if ("$global$".equals(str3))
          {
            localObject = (String)this.globalProperties.put(str1, str2);
            if ((paramBoolean) && (!CommonUtils.isEqual(localObject, paramMap.getValue()))) {
              addPropertyChangeEvent(localArrayList, "$global$", str1, (String)localObject, str2);
            }
          }
          else
          {
            localObject = (Map)this.pluginProperties.get(str3);
            paramMap = (Map<String, String>)localObject;
            if (localObject == null)
            {
              paramMap = new HashMap();
              this.pluginProperties.put(str3, paramMap);
            }
            paramMap = (String)paramMap.put(str1, str2);
            if ((paramBoolean) && (!CommonUtils.isEqual(paramMap, str2))) {
              addPropertyChangeEvent(localArrayList, str3, str1, paramMap, str2);
            }
          }
        }
        else
        {
          AliSDKLogger.w("kernel", "Invalid property name " + (String)paramMap.getKey());
        }
      }
    }
    if (paramBoolean) {
      postPropertyChangeEvents(localArrayList);
    }
  }
  
  private void postPropertyChangeEvent(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ("$global$".equals(paramString1)) {}
    HashMap localHashMap;
    for (paramString1 = Collections.singletonMap("property.scope", "global");; paramString1 = localHashMap)
    {
      paramString1 = (PropertyChangeListener[])KernelContext.serviceRegistry.getServices(PropertyChangeListener.class, paramString1);
      if ((paramString1 != null) && (paramString1.length > 0)) {
        KernelContext.executorService.postTask(new MemoryBasedConfigurations.2(this, paramString1, paramString2, paramString3, paramString4));
      }
      return;
      localHashMap = new HashMap();
      localHashMap.put("property.scope", "plugin");
      localHashMap.put("plugin.vendor", paramString1);
    }
  }
  
  private void postPropertyChangeEvents(List<InternalPropertyChangeEvent> paramList)
  {
    if (paramList.size() == 0) {
      return;
    }
    KernelContext.executorService.postTask(new MemoryBasedConfigurations.1(this, paramList));
  }
  
  public void addStartRequiredPlugin(String paramString)
  {
    synchronized (this.startRequiredPluginNames)
    {
      this.startRequiredPluginNames.add(paramString);
      return;
    }
  }
  
  public String getGlobalProperty(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (String)this.globalProperties.get(paramString);
  }
  
  public String getPluginProperty(String paramString1, String paramString2)
  {
    paramString1 = (Map)this.pluginProperties.get(paramString1);
    if (paramString1 == null) {
      return null;
    }
    return (String)paramString1.get(paramString2);
  }
  
  public String[] getStartedPluginNames()
  {
    synchronized (this.startRequiredPluginNames)
    {
      String[] arrayOfString = (String[])this.startRequiredPluginNames.toArray(new String[this.startRequiredPluginNames.size()]);
      return arrayOfString;
    }
  }
  
  public void removeStartRequiredPlugin(String paramString)
  {
    synchronized (this.startRequiredPluginNames)
    {
      this.startRequiredPluginNames.remove(paramString);
      return;
    }
  }
  
  public void setDynamicProperties(String paramString)
  {
    try
    {
      this.sp.edit().putString("config", paramString).commit();
      overrideProperties(getDynamicConfigs(), true);
      return;
    }
    catch (Throwable paramString)
    {
      for (;;) {}
    }
  }
  
  public void setGlobalProperty(String paramString1, String paramString2)
  {
    if (paramString1 == null) {}
    String str;
    do
    {
      return;
      str = (String)this.globalProperties.put(paramString1, paramString2);
    } while (!CommonUtils.isEqual(paramString2, str));
    postPropertyChangeEvent("$global$", paramString1, str, paramString2);
  }
  
  public void setPluginProperty(String paramString1, String paramString2, String paramString3)
  {
    Map localMap = (Map)this.pluginProperties.get(paramString1);
    Object localObject = localMap;
    if (localMap == null)
    {
      this.pluginProperties.putIfAbsent(paramString1, new ConcurrentHashMap());
      localObject = (Map)this.pluginProperties.get(paramString1);
    }
    localObject = (String)((Map)localObject).put(paramString2, paramString3);
    if (CommonUtils.isEqual(paramString3, localObject)) {
      postPropertyChangeEvent(paramString1, paramString2, (String)localObject, paramString3);
    }
  }
  
  public void unsetGlobalProperty(String paramString)
  {
    String str = (String)this.globalProperties.remove(paramString);
    if (str != null) {
      postPropertyChangeEvent(null, paramString, str, null);
    }
  }
  
  public void unsetPluginProperty(String paramString1, String paramString2)
  {
    Map localMap = (Map)this.pluginProperties.get(paramString1);
    if (localMap == null) {}
    do
    {
      return;
      paramString2 = (String)localMap.remove(paramString2);
    } while (paramString2 == null);
    postPropertyChangeEvent(null, paramString1, paramString2, null);
  }
  
  private static class InternalPropertyChangeEvent
  {
    public String key;
    public String newValue;
    public String oldValue;
    public String owner;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\plugin\config\impl\MemoryBasedConfigurations.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */