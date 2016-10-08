package com.alimama.mobile.sdk.config.system.bridge;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.alimama.mobile.sdk.hack.Hack;
import com.alimama.mobile.sdk.hack.Hack.HackedClass;
import com.alimama.mobile.sdk.hack.Hack.HackedMethod;
import dalvik.system.DexClassLoader;

public class RuntimeBridge
{
  private static final String AlimamaJSdkController = "com.taobao.munion.view.webview.windvane.jsdk.AlimamaJSdkController";
  private static final String FrameworkLoader = "com.alimama.mobile.plugin.framework.FrameworkLoader";
  private static final String WVCamera = "com.taobao.munion.view.webview.windvane.jsdk.WVCamera";
  
  public static Object FrameworkLoader_invoke(ClassLoader paramClassLoader, ApplicationInfo paramApplicationInfo, AssetManager paramAssetManager, String paramString1, Resources paramResources, String paramString2, DexClassLoader paramDexClassLoader)
  {
    return Hack.into(paramClassLoader, "com.alimama.mobile.plugin.framework.FrameworkLoader").method("init", new Class[] { ApplicationInfo.class, AssetManager.class, String.class, Resources.class, String.class, ClassLoader.class }).invoke(null, new Object[] { paramApplicationInfo, paramAssetManager, paramString1, paramResources, paramString2, paramDexClassLoader });
  }
  
  public static void alimamaJSdkController_onActivityResult(ClassLoader paramClassLoader, int paramInt1, int paramInt2, Intent paramIntent)
  {
    paramClassLoader = Hack.into(paramClassLoader, "com.taobao.munion.view.webview.windvane.jsdk.WVCamera");
    Object localObject = paramClassLoader.method("getInstance", new Class[0]).invoke(null, new Object[0]);
    paramClassLoader.method("onActivityResult", new Class[] { Integer.TYPE, Integer.TYPE, Intent.class }).invoke(localObject, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
  }
  
  public static void alimamaJSdkController_onDestroy(ClassLoader paramClassLoader)
  {
    paramClassLoader = Hack.into(paramClassLoader, "com.taobao.munion.view.webview.windvane.jsdk.AlimamaJSdkController");
    Object localObject = paramClassLoader.method("getInstance", new Class[0]).invoke(null, new Object[0]);
    paramClassLoader.method("onDestroy", new Class[0]).invoke(localObject, new Object[0]);
  }
  
  public static void alimamaJSdkController_onPause(ClassLoader paramClassLoader)
  {
    paramClassLoader = Hack.into(paramClassLoader, "com.taobao.munion.view.webview.windvane.jsdk.AlimamaJSdkController");
    Object localObject = paramClassLoader.method("getInstance", new Class[0]).invoke(null, new Object[0]);
    paramClassLoader.method("onPause", new Class[0]).invoke(localObject, new Object[0]);
  }
  
  public static void alimamaJSdkController_onResume(ClassLoader paramClassLoader)
  {
    paramClassLoader = Hack.into(paramClassLoader, "com.taobao.munion.view.webview.windvane.jsdk.AlimamaJSdkController");
    Object localObject = paramClassLoader.method("getInstance", new Class[0]).invoke(null, new Object[0]);
    paramClassLoader.method("onResume", new Class[0]).invoke(localObject, new Object[0]);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\system\bridge\RuntimeBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */