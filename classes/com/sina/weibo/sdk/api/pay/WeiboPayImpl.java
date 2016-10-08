package com.sina.weibo.sdk.api.pay;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.WeiboAppManager.WeiboInfo;
import com.sina.weibo.sdk.api.share.IWeiboDownloadListener;
import com.sina.weibo.sdk.utils.AidTask;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;

public class WeiboPayImpl
{
  private static final String TAG = WeiboPayImpl.class.getName();
  private String mAppKey;
  private Context mContext;
  private Dialog mDownloadConfirmDialog = null;
  private IWeiboDownloadListener mDownloadListener;
  private boolean mNeedDownloadWeibo = true;
  private WeiboAppManager.WeiboInfo mWeiboInfo = null;
  
  public WeiboPayImpl(Context paramContext, String paramString, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.mAppKey = paramString;
    this.mWeiboInfo = WeiboAppManager.getInstance(paramContext).getWeiboInfo();
    if (this.mWeiboInfo != null) {
      LogUtil.d(TAG, this.mWeiboInfo.toString());
    }
    for (;;)
    {
      AidTask.getInstance(paramContext).aidTaskInit(paramString);
      return;
      LogUtil.d(TAG, "WeiboInfo is null");
    }
  }
  
  private boolean checkEnvironment(boolean paramBoolean)
  {
    return true;
  }
  
  private boolean launchWeiboActivity(Activity paramActivity, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      LogUtil.e(TAG, "launchWeiboActivity fail, invalid arguments");
      return false;
    }
    Intent localIntent = new Intent();
    localIntent.setPackage(paramString2);
    localIntent.setAction(paramString1);
    paramString1 = paramActivity.getPackageName();
    localIntent.putExtra("_weibo_sdkVersion", "0031405000");
    localIntent.putExtra("_weibo_appPackage", paramString1);
    localIntent.putExtra("_weibo_appKey", paramString3);
    localIntent.putExtra("_weibo_flag", 538116905);
    localIntent.putExtra("_weibo_sign", MD5.hexdigest(Utility.getSign(paramActivity, paramString1)));
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    try
    {
      LogUtil.d(TAG, "launchWeiboActivity intent=" + localIntent + ", extra=" + localIntent.getExtras());
      paramActivity.startActivityForResult(localIntent, 765);
      return true;
    }
    catch (ActivityNotFoundException paramActivity)
    {
      LogUtil.e(TAG, paramActivity.getMessage());
    }
    return false;
  }
  
  public int getWeiboAppSupportAPI()
  {
    if ((this.mWeiboInfo == null) || (!this.mWeiboInfo.isLegal())) {
      return -1;
    }
    return this.mWeiboInfo.getSupportApi();
  }
  
  public boolean isSupportWeiboPay()
  {
    return getWeiboAppSupportAPI() >= 10353;
  }
  
  public boolean isWeiboAppInstalled()
  {
    return true;
  }
  
  public boolean isWeiboAppSupportAPI()
  {
    return getWeiboAppSupportAPI() >= 10350;
  }
  
  public boolean launchWeiboPay(Activity paramActivity, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("rawdata", paramString);
    localBundle.putInt("_weibo_command_type", 4);
    localBundle.putString("_weibo_transaction", String.valueOf(System.currentTimeMillis()));
    return launchWeiboActivity(paramActivity, "com.sina.weibo.sdk.action.ACTION_WEIBO_PAY_ACTIVITY", this.mWeiboInfo.getPackageName(), this.mAppKey, localBundle);
  }
  
  public void registerWeiboDownloadListener(IWeiboDownloadListener paramIWeiboDownloadListener)
  {
    this.mDownloadListener = paramIWeiboDownloadListener;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\api\pay\WeiboPayImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */