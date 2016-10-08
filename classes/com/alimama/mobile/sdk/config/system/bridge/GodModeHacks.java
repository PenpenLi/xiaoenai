package com.alimama.mobile.sdk.config.system.bridge;

import android.app.Instrumentation;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.ContextThemeWrapper;
import com.alimama.mobile.sdk.config.ExchangeConstants;
import com.alimama.mobile.sdk.config.system.BridgeSystem.GROUP;
import com.alimama.mobile.sdk.config.system.BridgeSystem.GroupType;
import com.alimama.mobile.sdk.config.system.BridgeSystem.HackCollection;
import com.alimama.mobile.sdk.hack.AssertionArrayException;
import com.alimama.mobile.sdk.hack.Hack;
import com.alimama.mobile.sdk.hack.Hack.HackedClass;
import com.alimama.mobile.sdk.hack.Hack.HackedField;
import com.alimama.mobile.sdk.hack.Hack.HackedMethod;
import com.alimama.mobile.sdk.lab.InstrumentationHook;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@BridgeSystem.GROUP(TYPE=BridgeSystem.GroupType.OS)
public class GodModeHacks
  implements BridgeSystem.HackCollection
{
  public static Hack.HackedClass<Object> ActivityThread;
  public static Hack.HackedMethod ActivityThread_currentActivityThread;
  public static Hack.HackedField<Object, Instrumentation> ActivityThread_mInstrumentation;
  public static Hack.HackedField<Object, Map> ActivityThread_mPackages;
  public static Hack.HackedClass<Object> ContextImpl;
  public static Hack.HackedField<Object, Resources> ContextImpl_mResources;
  public static Hack.HackedField<Object, Resources.Theme> ContextImpl_mTheme;
  public static Hack.HackedClass<ContextThemeWrapper> ContextThemeWrapper;
  public static Hack.HackedField<ContextThemeWrapper, Resources> ContextThemeWrapper_mResources;
  public static Hack.HackedClass<Object> LoadedApk;
  public static Hack.HackedField<Object, ClassLoader> LoadedApk_mClassLoader;
  public static Hack.HackedField<Object, Resources> LoadedApk_mResources;
  public static Hack.HackedClass<Resources> Resources;
  public static Hack.HackedField<Resources, Configuration> Resources_mConfiguration;
  private AssertionArrayException mExceptionArray = null;
  
  public static void inject(Context paramContext)
  {
    Object localObject1;
    try
    {
      Resources localResources = (Resources)FrameworkBridge.FrameworkLoader_getPluginResources.invoke(null, new Object[0]);
      ClassLoader localClassLoader = (ClassLoader)FrameworkBridge.FrameworkLoader_getPluginClassLoader.invoke(null, new Object[0]);
      if (Resources_mConfiguration != null)
      {
        localObject1 = paramContext.getApplicationContext().getResources().getConfiguration();
        Resources_mConfiguration.on(localResources).set(localObject1);
      }
      localObject1 = ActivityThread_currentActivityThread.invoke(null, new Object[0]);
      Map localMap = (Map)ActivityThread_mPackages.on(localObject1).get();
      Iterator localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = ((WeakReference)localMap.get(localIterator.next())).get();
        if (localObject2 != null)
        {
          LoadedApk_mResources.on(localObject2).set(localResources);
          LoadedApk_mClassLoader.on(localObject2).set(localClassLoader);
        }
      }
      ContextImpl_mResources.on(paramContext).set(localResources);
    }
    catch (InvocationTargetException paramContext)
    {
      Log.e(ExchangeConstants.LOG_TAG, "插件环境初始化失败", paramContext);
      return;
    }
    ContextImpl_mTheme.on(paramContext).set(null);
    paramContext = new InstrumentationHook((Instrumentation)ActivityThread_mInstrumentation.on(localObject1).get(), paramContext);
    ActivityThread_mInstrumentation.on(localObject1).set(paramContext);
  }
  
  public void allClasses()
  {
    if (Build.VERSION.SDK_INT <= 8) {}
    for (LoadedApk = Hack.into("android.app.ActivityThread$PackageInfo");; LoadedApk = Hack.into("android.app.LoadedApk"))
    {
      ActivityThread = Hack.into("android.app.ActivityThread");
      ContextImpl = Hack.into("android.app.ContextImpl");
      ContextThemeWrapper = Hack.into(ContextThemeWrapper.class);
      Resources = Hack.into(Resources.class);
      return;
    }
  }
  
  public void allFields()
  {
    ActivityThread_mPackages = ActivityThread.field("mPackages").ofType(Map.class);
    ActivityThread_mInstrumentation = ActivityThread.field("mInstrumentation").ofType(Instrumentation.class);
    LoadedApk_mResources = LoadedApk.field("mResources").ofType(Resources.class);
    LoadedApk_mClassLoader = LoadedApk.field("mClassLoader").ofType(ClassLoader.class);
    ContextImpl_mResources = ContextImpl.field("mResources").ofType(Resources.class);
    ContextImpl_mTheme = ContextImpl.field("mTheme").ofType(Resources.Theme.class);
    try
    {
      if (Build.VERSION.SDK_INT < 24) {
        Resources_mConfiguration = Resources.field("mConfiguration").ofType(Configuration.class);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          if ((Build.VERSION.SDK_INT >= 17) && (ContextThemeWrapper.getmClass().getDeclaredField("mResources") != null)) {
            ContextThemeWrapper_mResources = ContextThemeWrapper.field("mResources").ofType(Resources.class);
          }
          return;
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          Log.w("Hack", "Not found ContextThemeWrapper.mResources on VERSION " + Build.VERSION.SDK_INT);
        }
        localException = localException;
        Log.w("Hack", "Not found Resources_mConfiguration on VERSION " + Build.VERSION.SDK_INT);
      }
    }
  }
  
  public void allMethods()
  {
    ActivityThread_currentActivityThread = ActivityThread.method("currentActivityThread", new Class[0]);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\system\bridge\GodModeHacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */