package com.sina.weibo.sdk.cmd;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.sina.weibo.sdk.net.NetUtils;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.Utility;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class WbAppActivator
{
  private static final String TAG = WbAppActivator.class.getName();
  private static WbAppActivator mInstance;
  private String mAppkey;
  private Context mContext;
  private AppInstallCmdExecutor mInstallExecutor;
  private AppInvokeCmdExecutor mInvokeExecutor;
  private volatile ReentrantLock mLock = new ReentrantLock(true);
  
  private WbAppActivator(Context paramContext, String paramString)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mInvokeExecutor = new AppInvokeCmdExecutor(this.mContext);
    this.mInstallExecutor = new AppInstallCmdExecutor(this.mContext);
    this.mAppkey = paramString;
  }
  
  public static WbAppActivator getInstance(Context paramContext, String paramString)
  {
    try
    {
      if (mInstance == null) {
        mInstance = new WbAppActivator(paramContext, paramString);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  private void handleInstallCmd(List<AppInstallCmd> paramList)
  {
    if (paramList != null)
    {
      this.mInstallExecutor.start();
      paramList = paramList.iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext())
      {
        this.mInstallExecutor.stop();
        return;
      }
      AppInstallCmd localAppInstallCmd = (AppInstallCmd)paramList.next();
      this.mInstallExecutor.doExecutor(localAppInstallCmd);
    }
  }
  
  private void handleInvokeCmd(List<AppInvokeCmd> paramList)
  {
    if (paramList != null) {
      paramList = paramList.iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        return;
      }
      AppInvokeCmd localAppInvokeCmd = (AppInvokeCmd)paramList.next();
      this.mInvokeExecutor.doExecutor(localAppInvokeCmd);
    }
  }
  
  private static String requestCmdInfo(Context paramContext, String paramString)
  {
    String str1 = paramContext.getPackageName();
    String str2 = Utility.getSign(paramContext, str1);
    WeiboParameters localWeiboParameters = new WeiboParameters(paramString);
    localWeiboParameters.put("appkey", paramString);
    localWeiboParameters.put("packagename", str1);
    localWeiboParameters.put("key_hash", str2);
    localWeiboParameters.put("version", "0031405000");
    return NetUtils.internalHttpRequest(paramContext, "http://api.weibo.cn/2/client/common_config", "GET", localWeiboParameters);
  }
  
  public void activateApp()
  {
    SharedPreferences localSharedPreferences = FrequencyHelper.getWeiboSdkSp(this.mContext);
    long l1 = FrequencyHelper.getFrequency(this.mContext, localSharedPreferences);
    long l2 = FrequencyHelper.getLastTime(this.mContext, localSharedPreferences);
    l2 = System.currentTimeMillis() - l2;
    if (l2 < l1)
    {
      LogUtil.v(TAG, String.format("it's only %d ms from last time get cmd", new Object[] { Long.valueOf(l2) }));
      return;
    }
    new Thread(new WbAppActivator.1(this, localSharedPreferences)).start();
  }
  
  private static class FrequencyHelper
  {
    private static final int DEFAULT_FREQUENCY = 3600000;
    private static final String KEY_FREQUENCY = "frequency_get_cmd";
    private static final String KEY_LAST_TIME_GET_CMD = "last_time_get_cmd";
    private static final String WEIBO_SDK_PREFERENCES_NAME = "com_sina_weibo_sdk";
    
    public static long getFrequency(Context paramContext, SharedPreferences paramSharedPreferences)
    {
      long l = 3600000L;
      if (paramSharedPreferences != null) {
        l = paramSharedPreferences.getLong("frequency_get_cmd", 3600000L);
      }
      return l;
    }
    
    public static long getLastTime(Context paramContext, SharedPreferences paramSharedPreferences)
    {
      long l = 0L;
      if (paramSharedPreferences != null) {
        l = paramSharedPreferences.getLong("last_time_get_cmd", 0L);
      }
      return l;
    }
    
    public static SharedPreferences getWeiboSdkSp(Context paramContext)
    {
      return paramContext.getSharedPreferences("com_sina_weibo_sdk", 0);
    }
    
    public static void saveFrequency(Context paramContext, SharedPreferences paramSharedPreferences, long paramLong)
    {
      if ((paramSharedPreferences != null) && (paramLong > 0L))
      {
        paramContext = paramSharedPreferences.edit();
        paramContext.putLong("frequency_get_cmd", paramLong);
        paramContext.commit();
      }
    }
    
    public static void saveLastTime(Context paramContext, SharedPreferences paramSharedPreferences, long paramLong)
    {
      if (paramSharedPreferences != null)
      {
        paramContext = paramSharedPreferences.edit();
        paramContext.putLong("last_time_get_cmd", paramLong);
        paramContext.commit();
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\cmd\WbAppActivator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */