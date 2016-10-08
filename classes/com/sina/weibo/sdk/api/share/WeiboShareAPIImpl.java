package com.sina.weibo.sdk.api.share;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.ApiUtils;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.WeiboAppManager.WeiboInfo;
import com.sina.weibo.sdk.api.WeiboMessage;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.cmd.WbAppActivator;
import com.sina.weibo.sdk.component.ShareRequestParam;
import com.sina.weibo.sdk.component.WeiboSdkBrowser;
import com.sina.weibo.sdk.exception.WeiboShareException;
import com.sina.weibo.sdk.statistic.WBAgent;
import com.sina.weibo.sdk.utils.AidTask;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;
import java.util.HashMap;

class WeiboShareAPIImpl
  implements IWeiboShareAPI
{
  private static final String TAG = WeiboShareAPIImpl.class.getName();
  private String mAppKey;
  private Context mContext;
  private Dialog mDownloadConfirmDialog = null;
  private IWeiboDownloadListener mDownloadListener;
  private boolean mNeedDownloadWeibo = true;
  private WeiboAppManager.WeiboInfo mWeiboInfo = null;
  
  public WeiboShareAPIImpl(Context paramContext, String paramString, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.mAppKey = paramString;
    this.mNeedDownloadWeibo = paramBoolean;
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
  
  private WeiboMessage adapterMultiMessage2SingleMessage(WeiboMultiMessage paramWeiboMultiMessage)
  {
    if (paramWeiboMultiMessage == null) {
      return new WeiboMessage();
    }
    Bundle localBundle = new Bundle();
    paramWeiboMultiMessage.toBundle(localBundle);
    return new WeiboMessage(localBundle);
  }
  
  private boolean checkEnvironment(boolean paramBoolean)
  {
    if (!isWeiboAppInstalled())
    {
      if (paramBoolean)
      {
        if (this.mDownloadConfirmDialog == null)
        {
          this.mDownloadConfirmDialog = WeiboDownloader.createDownloadConfirmDialog(this.mContext, this.mDownloadListener);
          this.mDownloadConfirmDialog.show();
        }
        for (;;)
        {
          return false;
          if (!this.mDownloadConfirmDialog.isShowing()) {
            this.mDownloadConfirmDialog.show();
          }
        }
      }
      throw new WeiboShareException("Weibo is not installed!");
    }
    if (!isWeiboAppSupportAPI()) {
      throw new WeiboShareException("Weibo do not support share api!");
    }
    if (!ApiUtils.validateWeiboSign(this.mContext, this.mWeiboInfo.getPackageName())) {
      throw new WeiboShareException("Weibo signature is incorrect!");
    }
    return true;
  }
  
  private boolean launchWeiboActivity(Activity paramActivity, String paramString1, String paramString2, String paramString3, Bundle paramBundle, String paramString4)
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
    paramString1 = String.valueOf(System.currentTimeMillis());
    localIntent.putExtra("_weibo_transaction", paramString1);
    addEventLog(paramActivity, paramString1, paramString4);
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
  
  private void registerWeiboDownloadListener(IWeiboDownloadListener paramIWeiboDownloadListener)
  {
    this.mDownloadListener = paramIWeiboDownloadListener;
  }
  
  private void sendBroadcast(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    paramString1 = new Intent(paramString1);
    String str = paramContext.getPackageName();
    paramString1.putExtra("_weibo_sdkVersion", "0031405000");
    paramString1.putExtra("_weibo_appPackage", str);
    paramString1.putExtra("_weibo_appKey", paramString2);
    paramString1.putExtra("_weibo_flag", 538116905);
    paramString1.putExtra("_weibo_sign", MD5.hexdigest(Utility.getSign(paramContext, str)));
    if (!TextUtils.isEmpty(paramString3)) {
      paramString1.setPackage(paramString3);
    }
    if (paramBundle != null) {
      paramString1.putExtras(paramBundle);
    }
    LogUtil.d(TAG, "intent=" + paramString1 + ", extra=" + paramString1.getExtras());
    paramContext.sendBroadcast(paramString1, "com.sina.weibo.permission.WEIBO_SDK_PERMISSION");
  }
  
  private boolean startShareWeiboActivity(Activity paramActivity, String paramString, BaseRequest paramBaseRequest, WeiboAuthListener paramWeiboAuthListener)
  {
    try
    {
      WbAppActivator.getInstance(this.mContext, this.mAppKey).activateApp();
      new Bundle();
      String str = paramActivity.getPackageName();
      ShareRequestParam localShareRequestParam = new ShareRequestParam(paramActivity);
      localShareRequestParam.setToken(paramString);
      localShareRequestParam.setAppKey(this.mAppKey);
      localShareRequestParam.setAppPackage(str);
      localShareRequestParam.setBaseRequest(paramBaseRequest);
      localShareRequestParam.setSpecifyTitle("微博分享");
      localShareRequestParam.setAuthListener(paramWeiboAuthListener);
      paramString = new Intent(paramActivity, WeiboSdkBrowser.class);
      paramString.putExtras(localShareRequestParam.createRequestParamBundle());
      paramActivity.startActivity(paramString);
      return true;
    }
    catch (ActivityNotFoundException paramActivity) {}
    return false;
  }
  
  public void addEventLog(Context paramContext, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("other_app_action_start_time", paramString1);
    try
    {
      WBAgent.onEvent(paramContext, paramString2, localHashMap);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public int getWeiboAppSupportAPI()
  {
    if ((this.mWeiboInfo == null) || (!this.mWeiboInfo.isLegal())) {
      return -1;
    }
    return this.mWeiboInfo.getSupportApi();
  }
  
  public boolean handleWeiboRequest(Intent paramIntent, IWeiboHandler.Request paramRequest)
  {
    if ((paramIntent == null) || (paramRequest == null)) {
      return false;
    }
    String str1 = paramIntent.getStringExtra("_weibo_appPackage");
    String str2 = paramIntent.getStringExtra("_weibo_transaction");
    if (TextUtils.isEmpty(str1))
    {
      LogUtil.e(TAG, "handleWeiboRequest faild appPackage validateSign faild");
      paramRequest.onRequest(null);
      return false;
    }
    if (TextUtils.isEmpty(str2))
    {
      LogUtil.e(TAG, "handleWeiboRequest faild intent _weibo_transaction is null");
      paramRequest.onRequest(null);
      return false;
    }
    if (!ApiUtils.validateWeiboSign(this.mContext, str1))
    {
      LogUtil.e(TAG, "handleWeiboRequest faild appPackage validateSign faild");
      paramRequest.onRequest(null);
      return false;
    }
    paramRequest.onRequest(new ProvideMessageForWeiboRequest(paramIntent.getExtras()));
    return true;
  }
  
  public boolean handleWeiboResponse(Intent paramIntent, IWeiboHandler.Response paramResponse)
  {
    String str1 = paramIntent.getStringExtra("_weibo_appPackage");
    String str2 = paramIntent.getStringExtra("_weibo_transaction");
    if (TextUtils.isEmpty(str1))
    {
      LogUtil.e(TAG, "handleWeiboResponse faild appPackage is null");
      return false;
    }
    if (!(paramResponse instanceof Activity))
    {
      LogUtil.e(TAG, "handleWeiboResponse faild handler is not Activity");
      return false;
    }
    Activity localActivity = (Activity)paramResponse;
    String str3 = localActivity.getCallingPackage();
    LogUtil.d(TAG, "handleWeiboResponse getCallingPackage : " + str3);
    if (TextUtils.isEmpty(str2))
    {
      LogUtil.e(TAG, "handleWeiboResponse faild intent _weibo_transaction is null");
      return false;
    }
    if ((!ApiUtils.validateWeiboSign(this.mContext, str1)) && (!str1.equals(localActivity.getPackageName())))
    {
      LogUtil.e(TAG, "handleWeiboResponse faild appPackage validateSign faild");
      return false;
    }
    paramResponse.onResponse(new SendMessageToWeiboResponse(paramIntent.getExtras()));
    return true;
  }
  
  public boolean isSupportWeiboPay()
  {
    return getWeiboAppSupportAPI() >= 10353;
  }
  
  public boolean isWeiboAppInstalled()
  {
    return (this.mWeiboInfo != null) && (this.mWeiboInfo.isLegal());
  }
  
  public boolean isWeiboAppSupportAPI()
  {
    return getWeiboAppSupportAPI() >= 10350;
  }
  
  public boolean launchWeibo(Activity paramActivity)
  {
    if (!isWeiboAppInstalled())
    {
      LogUtil.e(TAG, "launchWeibo faild WeiboInfo is null");
      return false;
    }
    try
    {
      paramActivity.startActivity(paramActivity.getPackageManager().getLaunchIntentForPackage(this.mWeiboInfo.getPackageName()));
      return true;
    }
    catch (Exception paramActivity)
    {
      LogUtil.e(TAG, paramActivity.getMessage());
    }
    return false;
  }
  
  public boolean launchWeiboPay(Activity paramActivity, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("rawdata", paramString);
    localBundle.putInt("_weibo_command_type", 4);
    localBundle.putString("_weibo_transaction", String.valueOf(System.currentTimeMillis()));
    return launchWeiboActivity(paramActivity, "com.sina.weibo.sdk.action.ACTION_WEIBO_PAY_ACTIVITY", this.mWeiboInfo.getPackageName(), this.mAppKey, localBundle, "pay");
  }
  
  public boolean launchWeiboPayLogin(Activity paramActivity, String paramString)
  {
    if (!Utility.isWeiBoVersionSupportNewPay(paramActivity).booleanValue()) {
      return launchWeiboPay(paramActivity, paramString);
    }
    if (paramActivity == null)
    {
      LogUtil.e(TAG, "launchWeiboActivity fail, invalid arguments");
      return false;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("rawdata", paramString);
    localBundle.putInt("_weibo_command_type", 4);
    paramString = String.valueOf(System.currentTimeMillis());
    localBundle.putString("_weibo_transaction", paramString);
    Intent localIntent = new Intent();
    localIntent.setPackage(this.mWeiboInfo.getPackageName());
    localIntent.setData(Uri.parse("sinaweibo://sdkdeliver"));
    String str = paramActivity.getPackageName();
    localIntent.putExtra("_weibo_sdkVersion", "0031405000");
    localIntent.putExtra("_weibo_appPackage", str);
    localIntent.putExtra("_weibo_appKey", this.mAppKey);
    localIntent.putExtra("_weibo_flag", 538116905);
    localIntent.putExtra("_weibo_sign", MD5.hexdigest(Utility.getSign(paramActivity, str)));
    localIntent.putExtra("sdk_real_action", "com.sina.weibo.sdk.action.ACTION_WEIBO_PAY_ACTIVITY");
    localIntent.putExtra("sdk_is_scheme", false);
    localIntent.putExtra("sdk_requestcode", 765);
    localIntent.putExtra("_weibo_transaction", paramString);
    addEventLog(paramActivity, paramString, "pay");
    localIntent.putExtras(localBundle);
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
  
  public boolean registerApp()
  {
    sendBroadcast(this.mContext, "com.sina.weibo.sdk.Intent.ACTION_WEIBO_REGISTER", this.mAppKey, null, null);
    return true;
  }
  
  public boolean sendRequest(Activity paramActivity, BaseRequest paramBaseRequest)
  {
    if (paramBaseRequest == null) {
      LogUtil.e(TAG, "sendRequest faild request is null");
    }
    for (;;)
    {
      return false;
      try
      {
        boolean bool = checkEnvironment(this.mNeedDownloadWeibo);
        if (bool) {
          if (!paramBaseRequest.check(this.mContext, this.mWeiboInfo, new VersionCheckHandler()))
          {
            LogUtil.e(TAG, "sendRequest faild request check faild");
            return false;
          }
        }
      }
      catch (Exception paramActivity)
      {
        LogUtil.e(TAG, paramActivity.getMessage());
        return false;
      }
    }
    WbAppActivator.getInstance(this.mContext, this.mAppKey).activateApp();
    Bundle localBundle = new Bundle();
    paramBaseRequest.toBundle(localBundle);
    return launchWeiboActivity(paramActivity, "com.sina.weibo.sdk.action.ACTION_WEIBO_ACTIVITY", this.mWeiboInfo.getPackageName(), this.mAppKey, localBundle, "share");
  }
  
  public boolean sendRequest(Activity paramActivity, BaseRequest paramBaseRequest, AuthInfo paramAuthInfo, String paramString, WeiboAuthListener paramWeiboAuthListener)
  {
    if (paramBaseRequest == null)
    {
      LogUtil.e(TAG, "sendRequest faild request is null !");
      return false;
    }
    if ((isWeiboAppInstalled()) && (isWeiboAppSupportAPI()))
    {
      if (getWeiboAppSupportAPI() >= 10351) {
        return sendRequest(paramActivity, paramBaseRequest);
      }
      if ((paramBaseRequest instanceof SendMultiMessageToWeiboRequest))
      {
        paramBaseRequest = (SendMultiMessageToWeiboRequest)paramBaseRequest;
        paramAuthInfo = new SendMessageToWeiboRequest();
        paramAuthInfo.packageName = paramBaseRequest.packageName;
        paramAuthInfo.transaction = paramBaseRequest.transaction;
        paramAuthInfo.message = adapterMultiMessage2SingleMessage(paramBaseRequest.multiMessage);
        return sendRequest(paramActivity, paramAuthInfo);
      }
      return sendRequest(paramActivity, paramBaseRequest);
    }
    return startShareWeiboActivity(paramActivity, paramString, paramBaseRequest, paramWeiboAuthListener);
  }
  
  public boolean sendResponse(BaseResponse paramBaseResponse)
  {
    if (paramBaseResponse == null)
    {
      LogUtil.e(TAG, "sendResponse failed response null");
      return false;
    }
    if (!paramBaseResponse.check(this.mContext, new VersionCheckHandler()))
    {
      LogUtil.e(TAG, "sendResponse check fail");
      return false;
    }
    Bundle localBundle = new Bundle();
    paramBaseResponse.toBundle(localBundle);
    sendBroadcast(this.mContext, "com.sina.weibo.sdk.Intent.ACTION_WEIBO_RESPONSE", this.mAppKey, paramBaseResponse.reqPackageName, localBundle);
    return true;
  }
  
  public void shareMessageToWeiyou(Context paramContext, Bundle paramBundle)
  {
    Utility.shareMessagetoWeibo(paramContext, "sinaweibo://extendthirdshare", paramBundle);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\api\share\WeiboShareAPIImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */