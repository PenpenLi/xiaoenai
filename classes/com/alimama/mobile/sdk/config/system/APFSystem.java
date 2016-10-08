package com.alimama.mobile.sdk.config.system;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.ViewGroup;
import com.alimama.mobile.pluginframework.core.PluginFramework;
import com.alimama.mobile.pluginframework.core.PluginServiceAgent;
import com.alimama.mobile.pluginframework.core.PluginServiceAgent.ProviderShell;
import com.alimama.mobile.sdk.config.MMUFeedProperties;
import com.alimama.mobile.sdk.config.system.bridge.CMPluginBridge;
import com.alimama.mobile.sdk.config.system.bridge.FeedPluginBridge2;
import com.alimama.mobile.sdk.config.system.bridge.FrameworkBridge;
import com.alimama.mobile.sdk.hack.Hack.HackedMethod;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class APFSystem
{
  public static String getVersion()
  {
    String str = null;
    try
    {
      Object localObject = FrameworkBridge.FrameworkLoader_getVersion.invoke(null, null);
      if (localObject != null) {
        str = localObject.toString();
      }
      return str;
    }
    catch (Exception localException)
    {
      MMLog.e(localException, "com.alimama.mobile.plugin.framework.FrameworkLoader not found", new Object[0]);
    }
    return null;
  }
  
  public void addFeedMaterial(MMUFeedProperties paramMMUFeedProperties)
  {
    FeedPluginBridge2.getInstance().invoke_addMaterial(paramMMUFeedProperties);
  }
  
  public Fragment findFragment(Map<String, Object> paramMap)
  {
    return (Fragment)CMPluginBridge.Router_getFragment.invoke(null, new Object[] { paramMap });
  }
  
  public PluginServiceAgent findProvider()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("Download", "com.taobao.munion.base.download.DownloadProvider");
    return new PluginServiceAgent(new PluginServiceAgent.ProviderShell(CMPluginBridge.Router_getService.invoke(null, new Object[] { localHashMap })));
  }
  
  public Set<String> init(Context paramContext)
  {
    try
    {
      paramContext = PluginFramework.init(paramContext.getApplicationInfo(), paramContext.getAssets(), paramContext.getFilesDir().getAbsolutePath(), paramContext.getResources(), "mu");
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.e("E", "", paramContext);
    }
    return null;
  }
  
  public void inset(ViewGroup paramViewGroup, Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (paramMap.containsKey("slotid")) && (paramMap.containsKey("layouttype")))
    {
      CMPluginBridge.Router_insetView.invoke(null, new Object[] { paramViewGroup, paramMap });
      return;
    }
    throw new RuntimeException("AFPSystem无法获取slot_id.");
  }
  
  public void normalView(Context paramContext, Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (paramMap.containsKey("slotid")) && (paramMap.containsKey("layouttype")))
    {
      CMPluginBridge.Router_normalView.invoke(null, new Object[] { paramContext, paramMap });
      return;
    }
    throw new RuntimeException("AFPSystem无法获取slot_id.");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\system\APFSystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */