package com.alimama.mobile.pluginframework.core;

import android.app.Service;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.util.Log;
import com.alimama.mobile.sdk.config.system.bridge.AndroidBridgeHacks;
import com.alimama.mobile.sdk.config.system.bridge.FrameworkBridge;
import com.alimama.mobile.sdk.hack.Hack.HackedField;
import com.alimama.mobile.sdk.hack.Hack.HackedMethod;

public abstract class PluginService
  extends Service
{
  protected PluginServiceAgent pluginServiceAgent = null;
  
  public abstract PluginServiceAgent findProvider();
  
  public AssetManager getAssets()
  {
    if (this.pluginServiceAgent != null) {
      try
      {
        AssetManager localAssetManager = (AssetManager)FrameworkBridge.FrameworkLoader_getPluginAssetManager.invoke(null, new Object[0]);
        return localAssetManager;
      }
      catch (Exception localException)
      {
        return super.getAssets();
      }
    }
    return super.getAssets();
  }
  
  public ClassLoader getClassLoader()
  {
    if (this.pluginServiceAgent != null) {
      try
      {
        ClassLoader localClassLoader = (ClassLoader)FrameworkBridge.FrameworkLoader_getPluginClassLoader.invoke(null, new Object[0]);
        return localClassLoader;
      }
      catch (Exception localException)
      {
        return super.getClassLoader();
      }
    }
    return super.getClassLoader();
  }
  
  public Resources getResources()
  {
    if (this.pluginServiceAgent != null) {
      try
      {
        Resources localResources = (Resources)FrameworkBridge.FrameworkLoader_getPluginResources.invoke(null, new Object[0]);
        return localResources;
      }
      catch (Exception localException)
      {
        return super.getResources();
      }
    }
    return super.getResources();
  }
  
  public Resources.Theme getTheme()
  {
    Resources.Theme localTheme = super.getTheme();
    try
    {
      AndroidBridgeHacks.THeme_mAssets.on(localTheme).set(getAssets());
      return localTheme;
    }
    catch (Exception localException)
    {
      Log.e("wt", "", localException);
    }
    return localTheme;
  }
  
  public void onCreate()
  {
    try
    {
      this.pluginServiceAgent = findProvider();
      this.pluginServiceAgent.provider.setHostService(this);
      super.onCreate();
      return;
    }
    catch (Exception localException)
    {
      Log.e("Download", "", localException);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\pluginframework\core\PluginService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */