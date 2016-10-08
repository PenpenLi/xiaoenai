package com.alimama.mobile.sdk.shell;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import com.alimama.mobile.pluginframework.core.PluginService;
import com.alimama.mobile.pluginframework.core.PluginServiceAgent;
import com.alimama.mobile.pluginframework.core.PluginServiceAgent.ProviderShell;
import com.alimama.mobile.sdk.config.ExchangeConstants;
import com.alimama.mobile.sdk.config.MMUSDKFactory;
import com.alimama.mobile.sdk.config.system.APFSystem;
import com.alimama.mobile.sdk.config.system.AppUtil;
import com.alimama.mobile.sdk.config.system.MMLog;
import com.alimama.mobile.sdk.config.system.MMUSDKImpl;
import com.alimama.mobile.sdk.config.system.ModuleSupport;
import com.alimama.mobile.sdk.config.system.bridge.FrameworkBridge;
import com.alimama.mobile.sdk.hack.Hack.HackedMethod;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DownloadingService
  extends PluginService
{
  public static final String ACTION_UPDATE = "mmusdk_update";
  static final String BASE_URL_TEST = "http://afpssp.alimama.com/";
  static final String CONFIG_API_URL = "http://afpssp.alimama.com/sdk/cf?";
  public static final String JSON_KEY_ACCESS = "net";
  public static final String JSON_KEY_ACCESS_SUBTYPE = "netp";
  public static final String JSON_KEY_APP_PLUGIN_VERSION_CONFIG = "plugv";
  public static final String JSON_KEY_APP_REQ_PACKAGE_NAME = "apnm";
  public static final String JSON_KEY_APP_REQ_VERSION_NAME = "apvn";
  public static final String JSON_KEY_CARRIER = "nop";
  public static final String JSON_KEY_OS = "os";
  public static final String JSON_KEY_OS_VERSION = "osv";
  public static final String JSON_KEY_PROTOCOL_VERSION = "protv";
  public static final String JSON_KEY_SDK_VERSION = "sdkv";
  public static final String JSON_KEY_SLOT_ID = "aid";
  public static final String MODULE_SUPPORT_RESET = "module_support_reset";
  public static final String MODULE_SUPPORT_UPDATE = "module_support_update";
  public static final String REQUEST_OS_NAME = "android";
  static Set<String> hasReqAid = new HashSet();
  
  private void updatePlguins(String paramString)
  {
    if (!hasReqAid.contains(paramString))
    {
      MMLog.i("request plugins", new Object[0]);
      new Thread(new DownloadingService.1(this, paramString)).start();
      hasReqAid.add(paramString);
      return;
    }
    MMLog.i("has requestd plugins", new Object[0]);
  }
  
  public PluginServiceAgent findProvider()
  {
    try
    {
      PluginServiceAgent localPluginServiceAgent = ((MMUSDKImpl)MMUSDKFactory.getMMUSDK()).getApfSystem().findProvider();
      return localPluginServiceAgent;
    }
    catch (Exception localException)
    {
      Log.e("Download", "Find Provider Error", localException);
    }
    return null;
  }
  
  public Map<String, Object> getActionParams(String paramString)
  {
    HashMap localHashMap = new HashMap();
    Context localContext = getApplicationContext();
    localHashMap.put("apnm", localContext.getPackageName());
    localHashMap.put("os", "android");
    localHashMap.put("osv", Build.VERSION.RELEASE);
    try
    {
      localHashMap.put("apvn", AppUtil.optString(localContext.getPackageManager().getPackageInfo(localContext.getPackageName(), 0).versionName));
      localHashMap.put("aid", paramString);
      paramString = AppUtil.getCurrentNetowrk(localContext);
      localHashMap.put("net", paramString[0]);
      localHashMap.put("netp", paramString[1]);
      localHashMap.put("plugv", APFSystem.getVersion());
      localHashMap.put("sdkv", ExchangeConstants.sdk_version);
      localHashMap.put("protv", ExchangeConstants.protocol_version);
      localHashMap.put("nop", AppUtil.getNetworkOperator(localContext));
      return localHashMap;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if ((this.pluginServiceAgent != null) && (this.pluginServiceAgent.provider != null)) {
      return this.pluginServiceAgent.provider.onBind(paramIntent);
    }
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if ((this.pluginServiceAgent != null) && (this.pluginServiceAgent.provider != null))
    {
      this.pluginServiceAgent.provider.onCreate();
      return;
    }
    MMLog.e("PluginServiceAgent is null", new Object[0]);
  }
  
  public void onDestroy()
  {
    if ((this.pluginServiceAgent != null) && (this.pluginServiceAgent.provider != null)) {
      this.pluginServiceAgent.provider.onDestroy();
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent == null) {
      return 1;
    }
    if ("mmusdk_update".equals(paramIntent.getAction()))
    {
      String str = paramIntent.getStringExtra("plugins");
      if (TextUtils.isEmpty(str))
      {
        paramIntent = paramIntent.getStringExtra("slot_id");
        updatePlguins(paramIntent);
        MMLog.i("Do Plugins Update " + paramIntent, new Object[0]);
        return 1;
      }
      updateSDK(str);
      MMLog.i("Do Plugins Update with config.", new Object[0]);
      return 1;
    }
    if ("module_support_update".equals(paramIntent.getAction()))
    {
      paramIntent = paramIntent.getStringExtra("update");
      if (!TextUtils.isEmpty(paramIntent)) {
        ModuleSupport._update(paramIntent);
      }
      return 0;
    }
    if ("module_support_reset".equals(paramIntent.getAction()))
    {
      ModuleSupport._resetAll(paramIntent.getBooleanExtra("reset", false));
      return 0;
    }
    try
    {
      if (this.pluginServiceAgent == null)
      {
        this.pluginServiceAgent = findProvider();
        this.pluginServiceAgent.provider.setHostService(this);
        this.pluginServiceAgent.provider.onCreate();
      }
      if ((this.pluginServiceAgent != null) && (this.pluginServiceAgent.provider != null)) {
        return this.pluginServiceAgent.provider.onStartCommand(paramIntent, paramInt1, paramInt2);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("Download", "", localException);
      }
    }
    return 0;
  }
  
  public final String toActionUrl(String paramString)
  {
    return AppUtil.makeUrl("http://afpssp.alimama.com/sdk/cf?", getActionParams(paramString));
  }
  
  public void updateSDK(String paramString)
  {
    try
    {
      FrameworkBridge.FrameworkLoader_update.invoke(null, new Object[] { paramString });
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      Log.e("E", "com.alimama.mobile.plugin.framework.FrameworkLoader not found");
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\shell\DownloadingService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */