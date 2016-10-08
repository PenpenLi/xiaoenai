package com.alimama.mobile.pluginframework.core;

import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;
import com.alimama.mobile.sdk.config.system.bridge.RuntimeBridge;
import com.alimama.mobile.sdk.hack.Hack.HackDeclaration.HackAssertionException;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class PluginFramework
{
  public static String FRAMEWORK_PLUGIN_NAME = "FrameworkPlugin";
  private static String FRAMEWORK_PLUGIN_PREFIX = FRAMEWORK_PLUGIN_NAME + "-";
  public static final String KEY_UPDATE_ACCESS = "access";
  public static final String KEY_UPDATE_DEVICEID = "deviceid";
  public static final String KEY_UPDATE_LAYOUTTYPE = "layouttype";
  public static final String KEY_UPDATE_OS = "os";
  public static final String KEY_UPDATE_OSV = "osv";
  public static final String KEY_UPDATE_SDKV = "sdkv";
  public static final String KEY_UPDATE_SLOTID = "slotid";
  public static String OPTIMIZED_DIR;
  public static String PLUGIN_DIR;
  public static String PLUGIN_ROOT;
  private static Class<?> frameworkLoader = null;
  private static AtomicBoolean inited = new AtomicBoolean(false);
  private static Set<String> mLoadedPlugins = new HashSet();
  
  static
  {
    PLUGIN_ROOT = "mmplugins";
    PLUGIN_DIR = "plugins";
    OPTIMIZED_DIR = "opt";
  }
  
  public static boolean compareLessFrameworkPlugin(String paramString1, String paramString2)
  {
    if (paramString1 != null) {}
    label203:
    for (;;)
    {
      try
      {
        if (!"".equals(paramString1))
        {
          Object localObject = paramString1.split("\\/");
          String str2 = localObject[(localObject.length - 1)].split("-")[0];
          localObject = localObject[(localObject.length - 1)].split("-")[1];
          if ((localObject == null) || ("".equals(localObject)) || (!((String)localObject).contains(".apk"))) {
            break label203;
          }
          localObject = ((String)localObject).substring(0, ((String)localObject).lastIndexOf("."));
          if ((paramString2 != null) && (!"".equals(paramString2)))
          {
            String str3 = paramString2.split("-")[0];
            String str1 = paramString2.split("-")[1];
            paramString2 = str1;
            if (str1 != null)
            {
              paramString2 = str1;
              if (!"".equals(str1))
              {
                paramString2 = str1;
                if (str1.contains(".apk")) {
                  paramString2 = str1.substring(0, str1.lastIndexOf("."));
                }
              }
            }
            if ((str3.equals(str2)) && (paramString2.compareTo((String)localObject) > 0))
            {
              paramString1 = new File(paramString1);
              if (paramString1.exists())
              {
                paramString1.delete();
                return true;
              }
            }
          }
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
      return false;
    }
  }
  
  private static void deletePlugins(String paramString)
  {
    paramString = new File(new File(paramString, PLUGIN_ROOT), PLUGIN_DIR);
    if (paramString != null) {
      paramString.delete();
    }
  }
  
  public static AssetManager getPluginAssetManager()
  {
    if (frameworkLoader == null) {
      throw new Exception("plugin framework not init...");
    }
    return (AssetManager)frameworkLoader.getMethod("getPluginAssetManager", new Class[0]).invoke(frameworkLoader, new Object[0]);
  }
  
  public static ClassLoader getPluginClassLoader()
  {
    if (frameworkLoader == null)
    {
      Log.i("wt", "==null");
      throw new Exception("plugin framework not init...");
    }
    return (ClassLoader)frameworkLoader.getMethod("getPluginClassLoader", new Class[0]).invoke(frameworkLoader, new Object[0]);
  }
  
  public static Resources getPluginResources()
  {
    if (frameworkLoader == null) {
      throw new Exception("plugin framework not init...");
    }
    return (Resources)frameworkLoader.getMethod("getPluginResources", new Class[0]).invoke(frameworkLoader, new Object[0]);
  }
  
  public static Set<String> init(ApplicationInfo paramApplicationInfo, AssetManager paramAssetManager, String paramString1, Resources paramResources, String paramString2)
  {
    if (!inited.compareAndSet(false, true)) {
      return mLoadedPlugins;
    }
    File localFile1;
    Object localObject2;
    try
    {
      localFile1 = new File(paramString1, PLUGIN_ROOT);
      localFile2 = new File(localFile1, PLUGIN_DIR);
      localFile1.mkdir();
      localFile2.mkdir();
      localObject1 = localFile2.listFiles();
      j = localObject1.length;
      i = 0;
    }
    catch (Exception paramApplicationInfo)
    {
      File localFile2;
      for (;;)
      {
        int j;
        int i;
        deletePlugins(paramString1);
        throw paramApplicationInfo;
        i += 1;
        continue;
        i += 1;
      }
      localObject3 = paramAssetManager.open(paramString2 + "/" + (String)localObject2);
      localObject1 = new byte[((InputStream)localObject3).available()];
      ((InputStream)localObject3).read((byte[])localObject1);
      ((InputStream)localObject3).close();
      localObject2 = new File(localFile2, (String)localObject2);
      localObject3 = new FileOutputStream((File)localObject2);
      ((FileOutputStream)localObject3).write((byte[])localObject1);
      ((FileOutputStream)localObject3).close();
      localObject3 = ((File)localObject2).getAbsolutePath();
      if (localObject3 != null) {
        break label373;
      }
      throw new Exception("plugin framework init fail. framework apk not found.");
    }
    catch (Hack.HackDeclaration.HackAssertionException paramApplicationInfo)
    {
      Log.e("wl", "加载插件失败。", paramApplicationInfo);
      mLoadedPlugins.add(FRAMEWORK_PLUGIN_NAME);
      deletePlugins(paramString1);
      return mLoadedPlugins;
    }
    if (i < j)
    {
      localObject2 = localObject1[i];
      if (!((File)localObject2).getName().startsWith(FRAMEWORK_PLUGIN_PREFIX)) {}
    }
    for (Object localObject1 = ((File)localObject2).getAbsolutePath();; localObject1 = null)
    {
      Object localObject3 = paramAssetManager.list(paramString2);
      j = localObject3.length;
      i = 0;
      if (i < j)
      {
        localObject2 = localObject3[i];
        Log.i("munion", "path = " + (String)localObject2);
        if (!((String)localObject2).startsWith(FRAMEWORK_PLUGIN_PREFIX)) {}
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          localObject3 = localObject1;
          if (!compareLessFrameworkPlugin((String)localObject1, (String)localObject2)) {}
        }
        else if (localObject2 == null)
        {
          throw new Exception("plugin framework init fail. framework apk not found.");
        }
        label373:
        localObject1 = new File(localFile1, OPTIMIZED_DIR);
        ((File)localObject1).mkdir();
        Log.i("wt", "loadAPK:" + (String)localObject3);
        localObject1 = new DexClassLoader((String)localObject3, ((File)localObject1).getAbsolutePath(), null, PluginFramework.class.getClassLoader());
        frameworkLoader = ((DexClassLoader)localObject1).loadClass("com.alimama.mobile.plugin.framework.FrameworkLoader");
        mLoadedPlugins.add(FRAMEWORK_PLUGIN_NAME);
        paramApplicationInfo = (Set)RuntimeBridge.FrameworkLoader_invoke(frameworkLoader.getClassLoader(), paramApplicationInfo, paramAssetManager, paramString1, paramResources, paramString2, (DexClassLoader)localObject1);
        mLoadedPlugins.addAll(paramApplicationInfo);
        paramApplicationInfo = mLoadedPlugins;
        return paramApplicationInfo;
        localObject2 = null;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\pluginframework\core\PluginFramework.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */