package com.alimama.mobile.sdk.config.system;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import com.alimama.mobile.sdk.config.ExchangeConstants;
import java.util.HashMap;
import java.util.Map;

public class PluginStatistics
{
  static final String API_URL = "http://gm.mmstat.com/wapebs.5.1?";
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
  public static final String REQUEST_OS_NAME = "android";
  
  private static final Map<String, Object> getActionParams(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("apnm", paramContext.getPackageName());
    localHashMap.put("os", "android");
    localHashMap.put("osv", Build.VERSION.RELEASE);
    try
    {
      localHashMap.put("apvn", AppUtil.optString(paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName));
      String[] arrayOfString = AppUtil.getCurrentNetowrk(paramContext);
      localHashMap.put("net", arrayOfString[0]);
      localHashMap.put("netp", arrayOfString[1]);
      localHashMap.put("plugv", APFSystem.getVersion());
      localHashMap.put("sdkv", ExchangeConstants.sdk_version);
      localHashMap.put("protv", ExchangeConstants.protocol_version);
      localHashMap.put("nop", AppUtil.getNetworkOperator(paramContext));
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
  
  public static final void sendEvent(Context paramContext, int paramInt, Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() > 0)) {}
    try
    {
      paramMap.put("evt", Integer.valueOf(paramInt));
      paramContext = getActionParams(paramContext);
      paramContext.putAll(paramMap);
      new Thread(new PluginStatistics.1(AppUtil.makeUrl("http://gm.mmstat.com/wapebs.5.1?", paramContext))).start();
      return;
    }
    catch (Exception paramContext)
    {
      MMLog.e(paramContext, "", new Object[0]);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\system\PluginStatistics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */