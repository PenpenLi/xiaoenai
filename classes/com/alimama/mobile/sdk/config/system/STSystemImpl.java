package com.alimama.mobile.sdk.config.system;

import android.app.Activity;
import android.content.res.AssetManager;
import com.alimama.mobile.pluginframework.core.PluginFramework;
import com.alimama.mobile.sdk.MMUSDK;
import com.alimama.mobile.sdk.MMUSDK.PLUGIN_LOAD_STATUS;
import com.alimama.mobile.sdk.config.MMUSDKFactory;
import com.alimama.mobile.sdk.config.MmuProperties;
import com.alimama.mobile.sdk.config.MmuProperties.ACCT;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class STSystemImpl
  implements STSystem
{
  private boolean stPlugin_containsHookActivity(Activity paramActivity)
  {
    return HookManager.containsHookActivity(paramActivity);
  }
  
  private boolean stPlugin_featureploginLoad(MmuProperties paramMmuProperties)
  {
    String[] arrayOfString = paramMmuProperties.getPluginNames();
    if ((arrayOfString == null) || (arrayOfString.length == 0))
    {
      MMLog.i("MmuProperties[%s] 没有设置必要的Feature插件检查.", new Object[] { paramMmuProperties.getClass().getCanonicalName() });
      return true;
    }
    paramMmuProperties = (MMUSDKImpl)MMUSDKFactory.getMMUSDK();
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (!paramMmuProperties.loadplugin(arrayOfString[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private boolean stPlugin_loadComplete()
  {
    return MMUSDKFactory.getMMUSDK().getStatus() == MMUSDK.PLUGIN_LOAD_STATUS.COMPLETED;
  }
  
  public boolean stAssetPlugin(AssetManager paramAssetManager)
  {
    try
    {
      paramAssetManager = paramAssetManager.list("mu");
      int j = paramAssetManager.length;
      int i = 0;
      while (i < j)
      {
        boolean bool = paramAssetManager[i].startsWith("FrameworkPlugin");
        if (bool) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (IOException paramAssetManager)
    {
      MMLog.e("", new Object[] { paramAssetManager });
    }
  }
  
  public boolean stLoadedCommonPlugin()
  {
    return ((MMUSDKImpl)MMUSDKFactory.getMMUSDK()).loadplugin("CommonPlugin");
  }
  
  public boolean stLoadedFrameWorkPlugin()
  {
    return ((MMUSDKImpl)MMUSDKFactory.getMMUSDK()).loadplugin(PluginFramework.FRAMEWORK_PLUGIN_NAME);
  }
  
  public boolean stManifest()
  {
    return true;
  }
  
  public <T extends MmuProperties> boolean stPlugin(T paramT)
  {
    MMLog.MarkerLog localMarkerLog = null;
    Object localObject4 = "";
    Object localObject2 = "";
    if (MMLog.DEBUG) {
      localMarkerLog = new MMLog.MarkerLog();
    }
    boolean bool2 = stPlugin_featureploginLoad(paramT);
    if (localMarkerLog != null)
    {
      localObject2 = String.format("[%s]检查必要的Feature插件是否加载成功,{ContainerProperties=%s}", new Object[] { Boolean.valueOf(bool2), Arrays.toString(paramT.getPluginNames()) });
      localMarkerLog.add((String)localObject2, Thread.currentThread().getId());
    }
    Object localObject1 = localObject2;
    Object localObject3 = localObject4;
    boolean bool1 = bool2;
    if (bool2)
    {
      bool2 = stPlugin_loadComplete();
      localObject1 = localObject2;
      localObject3 = localObject4;
      bool1 = bool2;
      if (localMarkerLog != null)
      {
        localObject3 = "Container check";
        localObject1 = String.format("[%s]检查必要插件[CommonPlugin,FrameworkPlugin]是否加载成功", new Object[] { Boolean.valueOf(bool2), Arrays.toString(paramT.getPluginNames()) });
        localMarkerLog.add((String)localObject1, Thread.currentThread().getId());
        bool1 = bool2;
      }
    }
    bool2 = bool1;
    localObject2 = localObject1;
    bool1 = bool2;
    if (bool2)
    {
      localObject2 = localObject1;
      bool1 = bool2;
      if (paramT.getAcct() == MmuProperties.ACCT.VIEW)
      {
        localObject4 = paramT.getActivity();
        bool2 = stPlugin_containsHookActivity((Activity)localObject4);
        localObject2 = localObject1;
        bool1 = bool2;
        if (localMarkerLog != null)
        {
          localObject2 = String.format("[%s]检查是否完成宿主Activity初始化,[activity=%s]", new Object[] { Boolean.valueOf(bool2), localObject4.getClass().getCanonicalName() });
          localMarkerLog.add((String)localObject2, Thread.currentThread().getId());
          bool1 = bool2;
        }
      }
    }
    if (localMarkerLog != null) {
      localMarkerLog.finish((String)localObject3);
    }
    if (!bool1)
    {
      localObject1 = new HashMap();
      ((Map)localObject1).put("msg_fail", localObject2);
      ((Map)localObject1).put("style", paramT.getClass().toString());
      PluginStatistics.sendEvent(paramT.getActivity().getApplicationContext(), 503, (Map)localObject1);
    }
    return bool1;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\system\STSystemImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */