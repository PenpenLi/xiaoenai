package com.alimama.mobile.sdk.config.system;

import android.app.Activity;
import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import com.alimama.listener.MMUWelcomeListener;
import com.alimama.mobile.sdk.MMUSDK;
import com.alimama.mobile.sdk.MMUSDK.PLUGIN_LOAD_STATUS;
import com.alimama.mobile.sdk.config.BannerProperties;
import com.alimama.mobile.sdk.config.ExchangeConstants;
import com.alimama.mobile.sdk.config.InsertProperties;
import com.alimama.mobile.sdk.config.LoopImageProperties;
import com.alimama.mobile.sdk.config.MMUFeedProperties;
import com.alimama.mobile.sdk.config.MmuController.InitAsyncComplete;
import com.alimama.mobile.sdk.config.MmuProperties;
import com.alimama.mobile.sdk.config.WelcomeProperties;
import com.alimama.mobile.sdk.config.system.bridge.CMPluginBridge;
import com.alimama.mobile.sdk.config.system.bridge.GodModeHacks;
import com.alimama.mobile.sdk.config.system.bridge.RuntimeBridge;
import com.alimama.mobile.sdk.hack.Hack.HackDeclaration.HackAssertionException;
import com.alimama.mobile.sdk.hack.Hack.HackedMethod;
import com.alimama.mobile.sdk.shell.DownloadingService;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONObject;

public class MMUSDKImpl
  implements MMUSDK
{
  public static final int MSG_CONFIG_INFO_DOWN_FAILED = 101;
  public static final int MSG_CONFIG_INFO_DOWN_SUCESS = 100;
  public static final int MSG_CONFIG_INFO_TO_DOWNLOAD_PLUGIN = 102;
  public static final String PARAMS_KEY = "params_key";
  public static final String PROPERTIED_KEY = "properties";
  private static final Lock initLock = new ReentrantReadWriteLock().writeLock();
  private volatile MMUSDK.PLUGIN_LOAD_STATUS STATUS = MMUSDK.PLUGIN_LOAD_STATUS.INITIAL;
  private APFSystem apfSystem = new APFSystem();
  private Application application;
  private int count = 0;
  private MmuController.InitAsyncComplete initAsyncCompleteListener;
  private boolean isWelcomeTimeOut;
  private Set<String> loadedPlugins;
  private long requestTime;
  private STSystem stSystem = new STSystemImpl();
  private Timer welcomeTimer;
  
  private void initwork(Application paramApplication, boolean paramBoolean)
  {
    String str;
    if (this.STATUS == MMUSDK.PLUGIN_LOAD_STATUS.INITIAL)
    {
      str = "";
      localObject2 = str;
      localObject1 = str;
    }
    label421:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                try
                {
                  if (!this.stSystem.stAssetPlugin(paramApplication.getApplicationContext().getAssets()))
                  {
                    localObject2 = str;
                    localObject1 = str;
                    Log.e(ExchangeConstants.LOG_TAG, "请检查是否添加FrameworkPlugin插件到 asset/mu/ 目录下。");
                    if (this.STATUS != MMUSDK.PLUGIN_LOAD_STATUS.COMPLETED)
                    {
                      localObject1 = new HashMap();
                      ((Map)localObject1).put("load_status", this.STATUS);
                      ((Map)localObject1).put("msg_fail", "asset/mu/目录下未找到FramwworkPlugin.");
                      PluginStatistics.sendEvent(paramApplication.getApplicationContext(), 501, (Map)localObject1);
                    }
                    return;
                  }
                }
                catch (Exception localException)
                {
                  do
                  {
                    Object localObject4;
                    localObject1 = localObject2;
                    Log.e(ExchangeConstants.LOG_TAG, "无法初始化MMSDK", localException);
                    localObject1 = localObject2;
                    localObject2 = localException.toString();
                    localObject1 = localObject2;
                    this.STATUS = MMUSDK.PLUGIN_LOAD_STATUS.INCOMPLETED;
                  } while (this.STATUS == MMUSDK.PLUGIN_LOAD_STATUS.COMPLETED);
                  localObject1 = new HashMap();
                  ((Map)localObject1).put("load_status", this.STATUS);
                  ((Map)localObject1).put("msg_fail", localObject2);
                  PluginStatistics.sendEvent(paramApplication.getApplicationContext(), 501, (Map)localObject1);
                  return;
                }
                finally
                {
                  if (this.STATUS == MMUSDK.PLUGIN_LOAD_STATUS.COMPLETED) {
                    break label916;
                  }
                  HashMap localHashMap = new HashMap();
                  localHashMap.put("load_status", this.STATUS);
                  localHashMap.put("msg_fail", localObject1);
                  PluginStatistics.sendEvent(paramApplication.getApplicationContext(), 501, localHashMap);
                }
                localObject2 = str;
                localObject1 = str;
                if (this.stSystem.stManifest()) {
                  break;
                }
                localObject2 = str;
                localObject1 = str;
                Log.e(ExchangeConstants.LOG_TAG, "Manifest完整性检查失败。");
              } while (this.STATUS == MMUSDK.PLUGIN_LOAD_STATUS.COMPLETED);
              localObject1 = new HashMap();
              ((Map)localObject1).put("load_status", this.STATUS);
              ((Map)localObject1).put("msg_fail", "Manifest完整性检查失败。");
              PluginStatistics.sendEvent(paramApplication.getApplicationContext(), 501, (Map)localObject1);
              return;
              localObject2 = str;
              localObject1 = str;
              BridgeSystem.defineAndVerify(BridgeSystem.GroupType.OS);
              localObject2 = str;
              localObject1 = str;
              BridgeSystem.defineAndVerify(BridgeSystem.GroupType.APP);
              localObject2 = str;
              localObject1 = str;
              this.loadedPlugins = this.apfSystem.init(paramApplication);
              localObject2 = str;
              localObject1 = str;
              if (!this.stSystem.stLoadedFrameWorkPlugin()) {
                break;
              }
              localObject2 = str;
              localObject1 = str;
              if (BridgeSystem.defineAndVerify(BridgeSystem.GroupType.FRAMEWORK)) {
                break label421;
              }
              localObject2 = str;
              localObject1 = str;
              Log.w(ExchangeConstants.LOG_TAG, "Framework已加载，初始化失败。");
            } while (this.STATUS == MMUSDK.PLUGIN_LOAD_STATUS.COMPLETED);
            localObject1 = new HashMap();
            ((Map)localObject1).put("load_status", this.STATUS);
            ((Map)localObject1).put("msg_fail", "Framework已加载，初始化失败。");
            PluginStatistics.sendEvent(paramApplication.getApplicationContext(), 501, (Map)localObject1);
            return;
            localObject2 = str;
            localObject1 = str;
            Log.w(ExchangeConstants.LOG_TAG, "Framework加载失败，无法完成初始化。");
          } while (this.STATUS == MMUSDK.PLUGIN_LOAD_STATUS.COMPLETED);
          localObject1 = new HashMap();
          ((Map)localObject1).put("load_status", this.STATUS);
          ((Map)localObject1).put("msg_fail", "Framework加载失败，无法完成初始化。");
          PluginStatistics.sendEvent(paramApplication.getApplicationContext(), 501, (Map)localObject1);
          return;
          localObject2 = str;
          localObject1 = str;
          if (this.stSystem.stLoadedCommonPlugin()) {
            break;
          }
          localObject2 = str;
          localObject1 = str;
          Log.w(ExchangeConstants.LOG_TAG, "无法完成初始化，CommonPlugin未加载成功。");
          localObject1 = "无法完成初始化，CommonPlugin未加载成功。";
          localObject2 = localObject1;
          this.STATUS = MMUSDK.PLUGIN_LOAD_STATUS.INCOMPLETED;
        } while (this.STATUS == MMUSDK.PLUGIN_LOAD_STATUS.COMPLETED);
        localObject1 = new HashMap();
        ((Map)localObject1).put("load_status", this.STATUS);
        ((Map)localObject1).put("msg_fail", "无法完成初始化，CommonPlugin未加载成功。");
        PluginStatistics.sendEvent(paramApplication.getApplicationContext(), 501, (Map)localObject1);
        return;
        localObject2 = str;
        localObject1 = str;
        if (BridgeSystem.defineAndVerify(BridgeSystem.GroupType.COMMON)) {
          break;
        }
        localObject2 = str;
        localObject1 = str;
        Log.w(ExchangeConstants.LOG_TAG, "CommonPlugin未加载成功，初始化失败。");
        localObject1 = "CommonPlugin未加载成功，初始化失败。";
        localObject2 = localObject1;
        this.STATUS = MMUSDK.PLUGIN_LOAD_STATUS.INCOMPLETED;
      } while (this.STATUS == MMUSDK.PLUGIN_LOAD_STATUS.COMPLETED);
      localObject1 = new HashMap();
      ((Map)localObject1).put("load_status", this.STATUS);
      ((Map)localObject1).put("msg_fail", "CommonPlugin未加载成功，初始化失败。");
      PluginStatistics.sendEvent(paramApplication.getApplicationContext(), 501, (Map)localObject1);
      return;
      if (!paramBoolean)
      {
        localObject2 = str;
        localObject1 = str;
        localObject4 = CMPluginBridge.AlimmContext_getAliContext.invoke(null, new Object[0]);
        localObject2 = str;
        localObject1 = str;
        CMPluginBridge.AlimmContext_init.invoke(localObject4, new Object[] { paramApplication });
        localObject2 = str;
        localObject1 = str;
        GodModeHacks.inject(paramApplication.getBaseContext());
        localObject2 = str;
        localObject1 = str;
        this.STATUS = MMUSDK.PLUGIN_LOAD_STATUS.COMPLETED;
        localObject2 = str;
        localObject1 = str;
        MMLog.i("初始化SDK完成.", new Object[0]);
      }
    } while (this.STATUS == MMUSDK.PLUGIN_LOAD_STATUS.COMPLETED);
    localObject1 = new HashMap();
    ((Map)localObject1).put("load_status", this.STATUS);
    ((Map)localObject1).put("msg_fail", "");
    PluginStatistics.sendEvent(paramApplication.getApplicationContext(), 501, (Map)localObject1);
  }
  
  private <T extends MmuProperties> void startSDKFail(Map<String, Object> paramMap)
  {
    paramMap = (MmuProperties)paramMap.get("properties");
    if ((paramMap instanceof WelcomeProperties))
    {
      paramMap = (WelcomeProperties)paramMap;
      if ((this.count == 0) && (paramMap.getMMUSplashListener() != null))
      {
        paramMap.getMMUSplashListener().onWelcomeError("开屏启动失败.");
        paramMap.getMMUSplashListener().onWelcomeClose();
        this.count += 1;
      }
    }
  }
  
  private <T extends MmuProperties> boolean startSSPAdsSDK(Map<String, Object> paramMap)
  {
    MMLog.i(MMLog.PROCESS_TAG + "Start Request Ads sdk ver is" + ExchangeConstants.sdk_version, new Object[0]);
    if (paramMap == null) {}
    label602:
    label632:
    do
    {
      do
      {
        for (;;)
        {
          return false;
          localObject1 = (MmuProperties)paramMap.get("properties");
          Object localObject2;
          if (!this.stSystem.stPlugin((MmuProperties)localObject1))
          {
            Log.w(ExchangeConstants.LOG_TAG, "MMSDK 插件加载环境检查失败，无法启动样式。");
            startSDKFail(paramMap);
            paramMap = ((MmuProperties)localObject1).getActivity();
            if (paramMap != null)
            {
              localObject2 = new Intent(paramMap, DownloadingService.class);
              ((Intent)localObject2).setAction("mmusdk_update");
              ((Intent)localObject2).putExtra("slot_id", ((MmuProperties)localObject1).getSlot_id());
              paramMap.startService((Intent)localObject2);
              return false;
            }
          }
          else
          {
            if ((localObject1 instanceof BannerProperties))
            {
              localObject1 = (BannerProperties)localObject1;
              paramMap.put("controller", ((BannerProperties)localObject1).getController());
              paramMap.put("isstretch", Boolean.valueOf(((BannerProperties)localObject1).isStretch()));
              try
              {
                this.apfSystem.inset(((BannerProperties)localObject1).getContainer(), paramMap);
                return false;
              }
              catch (Exception paramMap)
              {
                paramMap.printStackTrace();
                return false;
              }
            }
            if ((localObject1 instanceof InsertProperties))
            {
              localObject1 = (InsertProperties)localObject1;
              paramMap.put("isvideo", Boolean.valueOf(((InsertProperties)localObject1).getVideoInsert()));
              paramMap.put("controller", ((InsertProperties)localObject1).getController());
              paramMap.put("isManualRefresh", Boolean.valueOf(((InsertProperties)localObject1).isManualRefresh()));
              paramMap.put("isShowMask", Boolean.valueOf(((InsertProperties)localObject1).isShowMask()));
              paramMap.put("isCanThrough", Boolean.valueOf(((InsertProperties)localObject1).isCanThrough()));
              try
              {
                this.apfSystem.inset(null, paramMap);
                return false;
              }
              catch (Exception paramMap)
              {
                paramMap.printStackTrace();
                return false;
              }
            }
            if ((localObject1 instanceof MMUFeedProperties))
            {
              paramMap = (MMUFeedProperties)localObject1;
              this.apfSystem.addFeedMaterial(paramMap);
              return false;
            }
            if (!(localObject1 instanceof WelcomeProperties)) {
              break label632;
            }
            localObject1 = (WelcomeProperties)localObject1;
            if (this.isWelcomeTimeOut)
            {
              MMLog.e("开屏请求超时...", new Object[0]);
              return false;
            }
            long l2 = ((WelcomeProperties)localObject1).getMinDelay();
            long l1 = ((WelcomeProperties)localObject1).getMaxDelay();
            localObject2 = ((WelcomeProperties)localObject1).getWelcomeContainer();
            if (localObject2 != null) {
              paramMap.put("container", localObject2);
            }
            try
            {
              if (this.welcomeTimer != null)
              {
                this.welcomeTimer.cancel();
                this.welcomeTimer = null;
              }
              long l3 = System.currentTimeMillis() - this.requestTime;
              if (l3 < l1)
              {
                l1 -= l3;
                ((WelcomeProperties)localObject1).setMaxDelay(l1);
                paramMap.put("minDelay", Long.valueOf(l2));
                paramMap.put("maxDelay", Long.valueOf(l1));
                paramMap.put("width", Integer.valueOf(((WelcomeProperties)localObject1).getWidth()));
                paramMap.put("height", Integer.valueOf(((WelcomeProperties)localObject1).getHeight()));
                try
                {
                  if (((WelcomeProperties)localObject1).getActivity() == null) {
                    break label602;
                  }
                  this.apfSystem.normalView(((WelcomeProperties)localObject1).getActivity(), paramMap);
                  return false;
                }
                catch (Exception paramMap) {}
                if (((WelcomeProperties)localObject1).getMMUSplashListener() == null) {
                  continue;
                }
                ((WelcomeProperties)localObject1).getMMUSplashListener().onWelcomeError("插件调用失败.");
                ((WelcomeProperties)localObject1).getMMUSplashListener().onWelcomeClose();
                return false;
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                MMLog.e("welcomeTimer exception e :" + localException.getMessage(), new Object[0]);
                continue;
                l1 = 10L + l2;
              }
            }
          }
        }
      } while (((WelcomeProperties)localObject1).getMMUSplashListener() == null);
      ((WelcomeProperties)localObject1).getMMUSplashListener().onWelcomeError("插件调用失败.");
      ((WelcomeProperties)localObject1).getMMUSplashListener().onWelcomeClose();
      return false;
    } while (!(localObject1 instanceof LoopImageProperties));
    Object localObject1 = (LoopImageProperties)localObject1;
    paramMap.put("controller", ((LoopImageProperties)localObject1).getLoopImageController());
    if (((LoopImageProperties)localObject1).getConfig() != null) {
      paramMap.put("loopImageConfig", ((LoopImageProperties)localObject1).getConfig());
    }
    try
    {
      this.apfSystem.inset(((LoopImageProperties)localObject1).getContainer(), paramMap);
      return false;
    }
    catch (Exception paramMap)
    {
      paramMap.printStackTrace();
    }
    return false;
  }
  
  public boolean accountServiceHandleResult(int paramInt1, int paramInt2, Intent paramIntent, Activity paramActivity)
  {
    return CMPluginBridge.accountServiceHandleResult(paramInt1, paramInt2, paramIntent, paramActivity);
  }
  
  public void alimamaJsSdkOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    try
    {
      RuntimeBridge.alimamaJSdkController_onActivityResult(CMPluginBridge.getClassLoader(), paramInt1, paramInt2, paramIntent);
      return;
    }
    catch (InvocationTargetException paramIntent)
    {
      Log.e("wt", "Hack 调用失败", paramIntent);
      return;
    }
    catch (Hack.HackDeclaration.HackAssertionException paramIntent)
    {
      Log.e("wt", "Hack 调用失败", paramIntent);
    }
  }
  
  public void alimamaJsSdkOnDestroy()
  {
    try
    {
      RuntimeBridge.alimamaJSdkController_onDestroy(CMPluginBridge.getClassLoader());
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Log.e("wt", "Hack 调用失败", localInvocationTargetException);
      return;
    }
    catch (Hack.HackDeclaration.HackAssertionException localHackAssertionException)
    {
      Log.e("wt", "Hack 调用失败", localHackAssertionException);
    }
  }
  
  public void alimamaJsSdkOnPause()
  {
    try
    {
      RuntimeBridge.alimamaJSdkController_onPause(CMPluginBridge.getClassLoader());
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Log.e("wt", "Hack 调用失败", localInvocationTargetException);
      return;
    }
    catch (Hack.HackDeclaration.HackAssertionException localHackAssertionException)
    {
      Log.e("wt", "Hack 调用失败", localHackAssertionException);
    }
  }
  
  public void alimamaJsSdkOnResume()
  {
    try
    {
      RuntimeBridge.alimamaJSdkController_onResume(CMPluginBridge.getClassLoader());
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Log.e("wt", "Hack 调用失败", localInvocationTargetException);
      return;
    }
    catch (Hack.HackDeclaration.HackAssertionException localHackAssertionException)
    {
      Log.e("wt", "Hack 调用失败", localHackAssertionException);
    }
  }
  
  public <T extends MmuProperties> void attach(T paramT)
  {
    if (Build.VERSION.SDK_INT < 9) {}
    label188:
    label199:
    for (;;)
    {
      return;
      Object localObject = new HashMap();
      this.count = 0;
      ((HashMap)localObject).put("slotid", paramT.getSlot_id());
      ((HashMap)localObject).put("properties", paramT);
      ((HashMap)localObject).put("layouttype", Integer.valueOf(paramT.getLayoutType()));
      startSSPAdsSDK((Map)localObject);
      if (this.application != null)
      {
        localObject = CMPluginBridge.getMMUConfigPlugins(paramT);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          Activity localActivity = paramT.getActivity();
          if (localActivity != null)
          {
            Intent localIntent = new Intent(localActivity, DownloadingService.class);
            localIntent.setAction("mmusdk_update");
            localIntent.putExtra("slot_id", paramT.getSlot_id());
            localIntent.putExtra("plugins", (String)localObject);
            localActivity.startService(localIntent);
          }
        }
        if (this.application == null) {
          break label188;
        }
        CMPluginBridge.init_statistics(paramT);
      }
      for (;;)
      {
        if (!ModuleSupport.isSupport(ModuleSupport.MODULE.TAE)) {
          break label199;
        }
        CMPluginBridge.accountServiceInit(this.application.getApplicationContext());
        return;
        MMLog.w("无法更新插件，application is null.", new Object[0]);
        break;
        MMLog.w("无法初始化SDK_Stat，application is null.", new Object[0]);
      }
    }
  }
  
  public void checkApk(String paramString)
  {
    Object localObject1;
    JSONArray localJSONArray;
    try
    {
      long l1 = Long.valueOf(paramString).longValue();
      paramString = this.application.getApplicationContext().getSharedPreferences("mogo_download_list", 0);
      localObject1 = paramString.getString("mogo_download_list", "");
      if ((localObject1 != null) && (!((String)localObject1).equals("")))
      {
        MMLog.d("读取下载列表:" + (String)localObject1, new Object[0]);
        localJSONArray = new JSONArray((String)localObject1);
        localObject1 = new JSONArray();
        NotificationManager localNotificationManager = (NotificationManager)this.application.getApplicationContext().getSystemService("notification");
        PackageManager localPackageManager = this.application.getApplicationContext().getPackageManager();
        int i = 0;
        for (;;)
        {
          if (i >= localJSONArray.length()) {
            break label477;
          }
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          long l2 = localJSONObject.getLong("downloadTime");
          Object localObject3 = localJSONObject.getString("packageName");
          Object localObject2 = localJSONObject.getString("apkPath");
          if (System.currentTimeMillis() - l2 < l1 * 1000L) {
            break label467;
          }
          boolean bool = new File((String)localObject2).exists();
          if (bool) {}
          try
          {
            localPackageManager.getPackageInfo((String)localObject3, 1);
            i += 1;
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException)
          {
            for (;;)
            {
              MMLog.d("未安裝:" + (String)localObject3, new Object[0]);
              try
              {
                localObject3 = localPackageManager.getPackageArchiveInfo((String)localObject2, 1);
                if (localObject3 != null) {
                  try
                  {
                    localObject3 = ((PackageInfo)localObject3).applicationInfo.packageName;
                    Object localObject4 = new Intent("android.intent.action.VIEW");
                    ((Intent)localObject4).addFlags(268435456);
                    ((Intent)localObject4).setDataAndType(Uri.fromFile(new File((String)localObject2)), "application/vnd.android.package-archive");
                    localObject2 = PendingIntent.getActivity(this.application.getApplicationContext(), 0, (Intent)localObject4, 134217728);
                    localObject4 = new Notification(17301634, "下载完成继续安装", System.currentTimeMillis());
                    ((Notification)localObject4).flags |= 0x10;
                    ((Notification)localObject4).setLatestEventInfo(this.application.getApplicationContext(), "下载完成,继续安装", (CharSequence)localObject3, (PendingIntent)localObject2);
                    localNotificationManager.notify(i + 1000, (Notification)localObject4);
                    MMLog.d("推送通知", new Object[0]);
                  }
                  catch (Exception localException1)
                  {
                    Log.e("ApkIconLoader", localNameNotFoundException.toString());
                  }
                }
              }
              catch (Exception localException2)
              {
                localException2.printStackTrace();
                MMLog.e(localNameNotFoundException, "", new Object[0]);
              }
            }
          }
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      MMLog.e(paramString, "", new Object[0]);
    }
    label467:
    label477:
    do
    {
      ((JSONArray)localObject1).put(localNameNotFoundException);
      break;
    } while (localJSONArray.length() == ((JSONArray)localObject1).length());
    paramString = paramString.edit();
    paramString.putString("mogo_download_list", ((JSONArray)localObject1).toString());
    paramString.commit();
  }
  
  public <T extends MmuProperties> Fragment findFragment(T paramT)
  {
    return null;
  }
  
  public APFSystem getApfSystem()
  {
    return this.apfSystem;
  }
  
  public MMUSDK.PLUGIN_LOAD_STATUS getStatus()
  {
    return this.STATUS;
  }
  
  public void init(Application paramApplication)
  {
    if (Build.VERSION.SDK_INT < 9) {
      return;
    }
    initLock.lock();
    this.application = paramApplication;
    initwork(paramApplication, false);
    initLock.unlock();
  }
  
  public void initAsync(Application paramApplication)
  {
    initLock.lock();
    new MMUSDKImpl.1(this, paramApplication).execute(new String[0]);
    initLock.unlock();
  }
  
  public boolean loadplugin(String paramString)
  {
    if (this.loadedPlugins == null) {
      return false;
    }
    return this.loadedPlugins.contains(paramString);
  }
  
  public void setInitAsyncListener(MmuController.InitAsyncComplete paramInitAsyncComplete)
  {
    this.initAsyncCompleteListener = paramInitAsyncComplete;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\system\MMUSDKImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */