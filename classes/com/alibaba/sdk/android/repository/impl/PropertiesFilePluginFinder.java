package com.alibaba.sdk.android.repository.impl;

import android.content.res.AssetManager;
import android.text.TextUtils;
import com.alibaba.sdk.android.plugin.PluginInfo;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.util.IOUtils;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class PropertiesFilePluginFinder
{
  private static final String[] EMPTY_STRING_ARRAY = new String[0];
  private static final String PLUGIN_AFTER_ALL_KEY = ".afterAll";
  private static final String PLUGIN_AFTER_KEY = ".after";
  private static final String PLUGIN_BEFORE_ALL_KEY = ".beforeAll";
  private static final String PLUGIN_BEFORE_KEY = ".before";
  private static final String PLUGIN_DIRECTORY_NAME = "tae_sdk_plugins";
  private static final String PLUGIN_LIFECYCLE_ADAPTER_KEY = ".lifecycleAdapter.class";
  private static final String PLUGIN_NAME_KEY = "plugin.name";
  private static final String PLUGIN_PROPERTIES_KEY = ".properties.";
  private static final String PLUGIN_VERSION_KEY = ".version";
  private static final String TAG = "kernel";
  private AssetManager assetManager;
  
  public PropertiesFilePluginFinder(AssetManager paramAssetManager)
  {
    this.assetManager = paramAssetManager;
  }
  
  protected PluginInfo buildPluginInfo(String paramString, Properties paramProperties)
  {
    String str2 = paramProperties.getProperty("plugin.name");
    if (str2 == null)
    {
      AliSDKLogger.e("kernel", "Unable to find expected plugin property plugin.name in the file " + paramString);
      return null;
    }
    PluginInfo localPluginInfo = new PluginInfo();
    localPluginInfo.name = str2;
    String str1 = str2 + ".properties.";
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramProperties.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str3 = (String)localEntry.getKey();
      if (str3.startsWith(str1)) {
        if (str3.length() == str1.length()) {
          AliSDKLogger.e("kernel", "Invalid property configuration " + str3 + " in the file " + paramString);
        } else {
          localHashMap.put(str3.substring(str1.length()), (String)localEntry.getValue());
        }
      }
    }
    localPluginInfo.properties = Collections.unmodifiableMap(localHashMap);
    str1 = paramProperties.getProperty(str2 + ".lifecycleAdapter.class");
    if ((str1 == null) && (AliSDKLogger.isDebugEnabled())) {
      AliSDKLogger.i("kernel", "No plugin lifecycle adapter is defined for the plugin " + str2 + " in the file " + paramString);
    }
    localPluginInfo.lifecycleAdapterClassName = str1;
    str1 = paramProperties.getProperty(str2 + ".version");
    paramString = str1;
    if (TextUtils.isEmpty(str1)) {
      paramString = "1";
    }
    localPluginInfo.version = paramString;
    paramString = paramProperties.getProperty(str2 + ".before");
    if (TextUtils.isEmpty(paramString))
    {
      localPluginInfo.before = EMPTY_STRING_ARRAY;
      paramString = paramProperties.getProperty(str2 + ".after");
      if (!TextUtils.isEmpty(paramString)) {
        break label559;
      }
    }
    label559:
    for (localPluginInfo.after = EMPTY_STRING_ARRAY;; localPluginInfo.after = paramString.split("[,]"))
    {
      localPluginInfo.beforeAll = Boolean.valueOf(paramProperties.getProperty(str2 + ".beforeAll"));
      localPluginInfo.afterAll = Boolean.valueOf(paramProperties.getProperty(str2 + ".afterAll"));
      if ((!localPluginInfo.beforeAll.booleanValue()) || (!localPluginInfo.afterAll.booleanValue())) {
        break label573;
      }
      throw new RuntimeException("The plugin " + str2 + " config the beforeAll and afterAll at the same time");
      localPluginInfo.before = paramString.split("[,]");
      break;
    }
    label573:
    return localPluginInfo;
  }
  
  public PluginInfo[] findPlugins()
  {
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = this.assetManager.list("tae_sdk_plugins");
    if ((arrayOfString == null) || (arrayOfString.length == 0)) {
      return new PluginInfo[0];
    }
    int j = arrayOfString.length;
    int i = 0;
    String str;
    Object localObject3;
    Object localObject1;
    while (i < j)
    {
      str = arrayOfString[i];
      localObject3 = null;
      localObject1 = null;
      try
      {
        InputStream localInputStream = this.assetManager.open("tae_sdk_plugins" + File.separator + str);
        localObject1 = localInputStream;
        localObject3 = localInputStream;
        Object localObject4 = new Properties();
        localObject1 = localInputStream;
        localObject3 = localInputStream;
        ((Properties)localObject4).load(localInputStream);
        localObject1 = localInputStream;
        localObject3 = localInputStream;
        localObject4 = buildPluginInfo(str, (Properties)localObject4);
        if (localObject4 != null)
        {
          localObject1 = localInputStream;
          localObject3 = localInputStream;
          localArrayList.add(localObject4);
        }
        IOUtils.closeQuietly(localInputStream);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localObject3 = localObject1;
          AliSDKLogger.e("kernel", "Fail to load plugin configuration properties " + str, localException);
          IOUtils.closeQuietly((Closeable)localObject1);
        }
      }
      finally
      {
        IOUtils.closeQuietly((Closeable)localObject3);
      }
      i += 1;
    }
    return (PluginInfo[])localArrayList.toArray(new PluginInfo[localArrayList.size()]);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\repository\impl\PropertiesFilePluginFinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */