package com.alimama.mobile.sdk.config.system.bridge;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.alimama.mobile.pluginframework.core.PluginFramework;
import com.alimama.mobile.sdk.config.MmuProperties;
import com.alimama.mobile.sdk.config.system.BridgeSystem.GROUP;
import com.alimama.mobile.sdk.config.system.BridgeSystem.GroupType;
import com.alimama.mobile.sdk.config.system.BridgeSystem.HackCollection;
import com.alimama.mobile.sdk.config.system.MMLog;
import com.alimama.mobile.sdk.hack.Hack;
import com.alimama.mobile.sdk.hack.Hack.HackDeclaration.HackAssertionException;
import com.alimama.mobile.sdk.hack.Hack.HackedClass;
import com.alimama.mobile.sdk.hack.Hack.HackedConstructor;
import com.alimama.mobile.sdk.hack.Hack.HackedMethod;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@BridgeSystem.GROUP(TYPE=BridgeSystem.GroupType.COMMON)
public class CMPluginBridge
  implements BridgeSystem.HackCollection
{
  public static Hack.HackedClass<Object> AccountService;
  public static Hack.HackedMethod AccountService_getDefault;
  public static Hack.HackedMethod AccountService_handleResult;
  public static Hack.HackedMethod AccountService_init;
  public static Hack.HackedClass<Object> AlimmContext;
  public static Hack.HackedMethod AlimmContext_getAliContext;
  public static Hack.HackedMethod AlimmContext_getAppContext;
  public static Hack.HackedMethod AlimmContext_getAppUtils;
  public static Hack.HackedMethod AlimmContext_init;
  public static Hack.HackedClass<Object> AppUtils;
  public static Hack.HackedMethod AppUtils_getCurrentNetowrk;
  public static Hack.HackedMethod AppUtils_getDeviceID;
  public static Hack.HackedClass<Object> BaseFragment;
  public static Hack.HackedMethod BaseFragment_dispatchKeyEvent;
  public static Hack.HackedClass<Fragment> BrowserFragment;
  public static Hack.HackedMethod BrowserFragmentOnFragmentResult;
  public static Hack.HackedClass<Object> DownloadProvider;
  public static Hack.HackedMethod DownloadProvider_onBind;
  public static Hack.HackedMethod DownloadProvider_onCreate;
  public static Hack.HackedMethod DownloadProvider_onDestroy;
  public static Hack.HackedMethod DownloadProvider_onStartCommand;
  public static Hack.HackedMethod DownloadProvider_setHostService;
  public static Hack.HackedClass<Object> MMUAdsConfigData;
  public static Hack.HackedMethod MMUAdsConfigData_getPlugins;
  public static Hack.HackedMethod MMUAdsConfigData_getStat;
  public static Hack.HackedClass<Object> MMUConfigManager;
  public static Hack.HackedMethod MMUConfigManager_getConfigData;
  public static Hack.HackedMethod MMUConfigManager_getInstance;
  public static Hack.HackedClass<Object> Router;
  public static Hack.HackedMethod Router_getFragment;
  public static Hack.HackedMethod Router_getService;
  public static Hack.HackedMethod Router_insetView;
  public static Hack.HackedMethod Router_normalView;
  public static Hack.HackedClass<Object> SDKStatistics;
  public static Hack.HackedMethod SDKStatistics_getSDKStatistics;
  public static Hack.HackedMethod SDKStatistics_init;
  public static Hack.HackedClass<Object> ShareUtils;
  public static Hack.HackedMethod ShareUtils_sendPlatformClick;
  
  public static boolean BrowserFragmentHandleResult(int paramInt1, int paramInt2, Intent paramIntent, Fragment paramFragment)
  {
    try
    {
      boolean bool = ((Boolean)BrowserFragmentOnFragmentResult.invoke(paramFragment, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent })).booleanValue();
      return bool;
    }
    catch (Exception paramIntent)
    {
      paramIntent.printStackTrace();
    }
    return false;
  }
  
  public static boolean accountServiceHandleResult(int paramInt1, int paramInt2, Intent paramIntent, Activity paramActivity)
  {
    try
    {
      Object localObject = AccountService_getDefault.invoke(null, new Object[0]);
      boolean bool = ((Boolean)AccountService_handleResult.invoke(localObject, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent, paramActivity })).booleanValue();
      return bool;
    }
    catch (Exception paramIntent)
    {
      paramIntent.printStackTrace();
    }
    return false;
  }
  
  public static void accountServiceInit(Context paramContext)
  {
    try
    {
      Object localObject = AccountService_getDefault.invoke(null, new Object[0]);
      AccountService_init.invoke(localObject, new Object[] { paramContext });
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static Context getAppContext()
  {
    try
    {
      Object localObject = AlimmContext_getAliContext.invoke(null, new Object[0]);
      localObject = (Context)AlimmContext_getAppContext.invoke(localObject, new Object[0]);
      return (Context)localObject;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new RuntimeException("Hack调用失败", localInvocationTargetException);
    }
  }
  
  public static Fragment getBrowserFragment()
  {
    try
    {
      Fragment localFragment = (Fragment)BrowserFragment.constructor(new Class[0]).getInstance(new Object[0]);
      return localFragment;
    }
    catch (Hack.HackDeclaration.HackAssertionException localHackAssertionException)
    {
      MMLog.e(localHackAssertionException, "", new Object[0]);
    }
    return null;
  }
  
  public static ClassLoader getClassLoader()
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
  
  public static String getCurrentNetwork()
  {
    try
    {
      Object localObject = AlimmContext_getAliContext.invoke(null, new Object[0]);
      localObject = AlimmContext_getAppUtils.invoke(localObject, new Object[0]);
      localObject = ((Object[])(Object[])AppUtils_getCurrentNetowrk.invoke(localObject, new Object[0]))[0].toString();
      return (String)localObject;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new RuntimeException("Hack调用失败", localInvocationTargetException);
    }
  }
  
  public static String getDeviceID()
  {
    try
    {
      Object localObject = AlimmContext_getAliContext.invoke(null, new Object[0]);
      localObject = AlimmContext_getAppUtils.invoke(localObject, new Object[0]);
      localObject = AppUtils_getDeviceID.invoke(localObject, new Object[0]).toString();
      return (String)localObject;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new RuntimeException("Hack调用失败", localInvocationTargetException);
    }
  }
  
  public static String getMMUConfigPlugins(MmuProperties paramMmuProperties)
  {
    try
    {
      Object localObject = MMUConfigManager_getInstance.invoke(null, new Object[0]);
      paramMmuProperties = MMUConfigManager_getConfigData.invoke(localObject, new Object[] { paramMmuProperties });
      paramMmuProperties = (String)MMUAdsConfigData_getPlugins.invoke(paramMmuProperties, new Object[0]);
      return paramMmuProperties;
    }
    catch (Exception paramMmuProperties)
    {
      paramMmuProperties.printStackTrace();
    }
    return "";
  }
  
  public static boolean init_statistics(MmuProperties paramMmuProperties)
  {
    try
    {
      Object localObject = MMUConfigManager_getInstance.invoke(null, new Object[0]);
      paramMmuProperties = MMUConfigManager_getConfigData.invoke(localObject, new Object[] { paramMmuProperties });
      paramMmuProperties = (String)MMUAdsConfigData_getStat.invoke(paramMmuProperties, new Object[0]);
      if (!TextUtils.isEmpty(paramMmuProperties))
      {
        localObject = SDKStatistics_getSDKStatistics.invoke(null, new Object[0]);
        boolean bool = ((Boolean)SDKStatistics_init.invoke(localObject, new Object[] { paramMmuProperties })).booleanValue();
        return bool;
      }
    }
    catch (Exception paramMmuProperties)
    {
      paramMmuProperties.printStackTrace();
    }
    return false;
  }
  
  public void allClasses()
  {
    AlimmContext = Hack.into(getClassLoader(), "com.taobao.newxp.common.AlimmContext");
    AppUtils = Hack.into(getClassLoader(), "com.taobao.munion.base.AppUtils");
    Router = Hack.into(getClassLoader(), "com.alimama.mobile.plugin.common.Router");
    DownloadProvider = Hack.into(getClassLoader(), "com.taobao.munion.base.download.DownloadProvider");
    BaseFragment = Hack.into(getClassLoader(), "com.taobao.newxp.view.BaseFragment");
    AccountService = Hack.into(getClassLoader(), "com.taobao.newxp.controller.AccountService");
    BrowserFragment = Hack.into(getClassLoader(), "com.taobao.newxp.view.common.BrowserFragment");
    ShareUtils = Hack.into(getClassLoader(), "com.alimama.mobile.share.ShareUtils");
    MMUConfigManager = Hack.into(getClassLoader(), "com.taobao.newxp.config.MMUConfigManager");
    MMUAdsConfigData = Hack.into(getClassLoader(), "com.taobao.newxp.config.MMUAdsConfigData");
    SDKStatistics = Hack.into(getClassLoader(), "com.taobao.newxp.net.SDKStatistics");
  }
  
  public void allFields() {}
  
  public void allMethods()
  {
    AlimmContext_getAliContext = AlimmContext.method("getAliContext", new Class[0]);
    AlimmContext_init = AlimmContext.method("init", new Class[] { Context.class });
    AlimmContext_getAppContext = AlimmContext.method("getAppContext", new Class[0]);
    AlimmContext_getAppUtils = AlimmContext.method("getAppUtils", new Class[0]);
    AppUtils_getCurrentNetowrk = AppUtils.method("getCurrentNetowrk", new Class[0]);
    AppUtils_getDeviceID = AppUtils.method("getDeviceID", new Class[0]);
    Router_getFragment = Router.method("getFragment", new Class[] { Map.class });
    Router_getService = Router.method("getService", new Class[] { Map.class });
    Router_insetView = Router.method("insetView", new Class[] { ViewGroup.class, Map.class });
    Router_normalView = Router.method("normalView", new Class[] { Context.class, Map.class });
    DownloadProvider_onBind = DownloadProvider.method("onBind", new Class[] { Intent.class });
    DownloadProvider_onStartCommand = DownloadProvider.method("onStartCommand", new Class[] { Intent.class, Integer.TYPE, Integer.TYPE });
    DownloadProvider_onCreate = DownloadProvider.method("onCreate", new Class[0]);
    DownloadProvider_onDestroy = DownloadProvider.method("onDestroy", new Class[0]);
    DownloadProvider_setHostService = DownloadProvider.method("setHostService", new Class[] { Service.class });
    BaseFragment_dispatchKeyEvent = BaseFragment.method("dispatchKeyEvent", new Class[] { KeyEvent.class });
    AccountService_getDefault = AccountService.staticMethod("getDefault", new Class[0]);
    AccountService_init = AccountService.method("init", new Class[] { Context.class });
    AccountService_handleResult = AccountService.method("handleResult", new Class[] { Integer.TYPE, Integer.TYPE, Intent.class, Activity.class });
    BrowserFragmentOnFragmentResult = BrowserFragment.method("onFragmentResult", new Class[] { Integer.TYPE, Integer.TYPE, Intent.class });
    ShareUtils_sendPlatformClick = ShareUtils.method("sendPlatformClick", new Class[] { String.class, String.class, Integer.TYPE });
    MMUConfigManager_getInstance = MMUConfigManager.staticMethod("getInstance", new Class[0]);
    MMUConfigManager_getConfigData = MMUConfigManager.method("getConfigData", new Class[] { MmuProperties.class });
    MMUAdsConfigData_getPlugins = MMUAdsConfigData.method("getPlugins", new Class[0]);
    MMUAdsConfigData_getStat = MMUAdsConfigData.method("getStat", new Class[0]);
    SDKStatistics_getSDKStatistics = SDKStatistics.staticMethod("getSDKStatistics", new Class[0]);
    SDKStatistics_init = SDKStatistics.method("init", new Class[] { String.class });
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\system\bridge\CMPluginBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */