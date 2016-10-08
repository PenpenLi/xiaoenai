package com.alimama.mobile.sdk.config.system.bridge;

import android.util.Log;
import com.alimama.mobile.pluginframework.core.PluginFramework;
import com.alimama.mobile.sdk.config.system.BridgeSystem.GROUP;
import com.alimama.mobile.sdk.config.system.BridgeSystem.GroupType;
import com.alimama.mobile.sdk.config.system.BridgeSystem.HackCollection;
import com.alimama.mobile.sdk.hack.Hack;
import com.alimama.mobile.sdk.hack.Hack.HackedClass;
import com.alimama.mobile.sdk.hack.Hack.HackedMethod;

@BridgeSystem.GROUP(TYPE=BridgeSystem.GroupType.FRAMEWORK)
public class FrameworkBridge
  implements BridgeSystem.HackCollection
{
  public static Hack.HackedClass<Object> FrameworkLoader;
  public static Hack.HackedMethod FrameworkLoader_getPluginAssetManager;
  public static Hack.HackedMethod FrameworkLoader_getPluginClassLoader;
  public static Hack.HackedMethod FrameworkLoader_getPluginResources;
  public static Hack.HackedMethod FrameworkLoader_getVersion;
  public static Hack.HackedMethod FrameworkLoader_update;
  
  private static ClassLoader getClassLoader()
  {
    try
    {
      ClassLoader localClassLoader = PluginFramework.getPluginClassLoader();
      return localClassLoader;
    }
    catch (Exception localException)
    {
      Log.e("wt", "", localException);
    }
    return null;
  }
  
  public void allClasses()
  {
    FrameworkLoader = Hack.into(getClassLoader(), "com.alimama.mobile.plugin.framework.FrameworkLoader");
  }
  
  public void allFields() {}
  
  public void allMethods()
  {
    FrameworkLoader_getPluginResources = FrameworkLoader.method("getPluginResources", new Class[0]);
    FrameworkLoader_getPluginClassLoader = FrameworkLoader.method("getPluginClassLoader", new Class[0]);
    FrameworkLoader_getPluginAssetManager = FrameworkLoader.method("getPluginAssetManager", new Class[0]);
    FrameworkLoader_update = FrameworkLoader.method("update", new Class[] { String.class });
    FrameworkLoader_getVersion = FrameworkLoader.method("getVersion", new Class[0]);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\system\bridge\FrameworkBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */