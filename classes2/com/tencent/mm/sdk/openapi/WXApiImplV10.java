package com.tencent.mm.sdk.openapi;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Service;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.mm.sdk.a.a.b;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelbiz.AddCardToWXCardPackage.Resp;
import com.tencent.mm.sdk.modelmsg.GetMessageFromWX.Req;
import com.tencent.mm.sdk.modelmsg.LaunchFromWX.Req;
import com.tencent.mm.sdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX.Resp;
import com.tencent.mm.sdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.sdk.modelpay.PayResp;
import com.tencent.wxop.stat.c;
import com.tencent.wxop.stat.d;
import com.tencent.wxop.stat.e;

final class WXApiImplV10
  implements IWXAPI
{
  private static final String TAG = "MicroMsg.SDK.WXApiImplV10";
  private static ActivityLifecycleCb activityCb = null;
  private static String wxappPayEntryClassname = null;
  private String appId;
  private boolean checkSignature = false;
  private Context context;
  private boolean detached = false;
  
  WXApiImplV10(Context paramContext, String paramString, boolean paramBoolean)
  {
    com.tencent.mm.sdk.b.a.d("MicroMsg.SDK.WXApiImplV10", "<init>, appId = " + paramString + ", checkSignature = " + paramBoolean);
    this.context = paramContext;
    this.appId = paramString;
    this.checkSignature = paramBoolean;
  }
  
  private boolean checkSumConsistent(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0) || (paramArrayOfByte2 == null) || (paramArrayOfByte2.length == 0))
    {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "checkSumConsistent fail, invalid arguments");
      return false;
    }
    if (paramArrayOfByte1.length != paramArrayOfByte2.length)
    {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "checkSumConsistent fail, length is different");
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte1.length) {
        break label67;
      }
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
        break;
      }
      i += 1;
    }
    label67:
    return true;
  }
  
  private void initMta(Context paramContext, String paramString)
  {
    paramString = "AWXOP" + paramString;
    c.b(paramContext, paramString);
    c.w();
    c.a(d.aG);
    c.t();
    c.c(paramContext, "Wechat_Sdk");
    try
    {
      e.a(paramContext, paramString, "2.0.3");
      return;
    }
    catch (com.tencent.wxop.stat.a paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private boolean sendAddCardToWX(Context paramContext, Bundle paramBundle)
  {
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/addCardToWX"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_add_card_to_wx_card_list"), paramBundle.getString("_wxapi_basereq_transaction") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendJumpToBizProfileReq(Context paramContext, Bundle paramBundle)
  {
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_jump_to_biz_profile_req_to_user_name"), paramBundle.getString("_wxapi_jump_to_biz_profile_req_ext_msg"), paramBundle.getInt("_wxapi_jump_to_biz_profile_req_scene"), paramBundle.getInt("_wxapi_jump_to_biz_profile_req_profile_type") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendJumpToBizWebviewReq(Context paramContext, Bundle paramBundle)
  {
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_jump_to_biz_webview_req_to_user_name"), paramBundle.getString("_wxapi_jump_to_biz_webview_req_ext_msg"), paramBundle.getInt("_wxapi_jump_to_biz_webview_req_scene") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendPayReq(Context paramContext, Bundle paramBundle)
  {
    if (wxappPayEntryClassname == null)
    {
      wxappPayEntryClassname = new MMSharedPreferences(paramContext).getString("_wxapp_pay_entry_classname_", null);
      com.tencent.mm.sdk.b.a.d("MicroMsg.SDK.WXApiImplV10", "pay, set wxappPayEntryClassname = " + wxappPayEntryClassname);
      if (wxappPayEntryClassname == null)
      {
        com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "pay fail, wxappPayEntryClassname is null");
        return false;
      }
    }
    com.tencent.mm.sdk.a.a.a locala = new com.tencent.mm.sdk.a.a.a();
    locala.n = paramBundle;
    locala.k = "com.tencent.mm";
    locala.l = wxappPayEntryClassname;
    return com.tencent.mm.sdk.a.a.a(paramContext, locala);
  }
  
  public final void detach()
  {
    com.tencent.mm.sdk.b.a.d("MicroMsg.SDK.WXApiImplV10", "detach");
    this.detached = true;
    if ((activityCb != null) && (Build.VERSION.SDK_INT >= 14))
    {
      if (!(this.context instanceof Activity)) {
        break label64;
      }
      ((Activity)this.context).getApplication().unregisterActivityLifecycleCallbacks(activityCb);
    }
    for (;;)
    {
      activityCb.detach();
      this.context = null;
      return;
      label64:
      if ((this.context instanceof Service)) {
        ((Service)this.context).getApplication().unregisterActivityLifecycleCallbacks(activityCb);
      }
    }
  }
  
  public final int getWXAppSupportAPI()
  {
    if (this.detached) {
      throw new IllegalStateException("getWXAppSupportAPI fail, WXMsgImpl has been detached");
    }
    if (!isWXAppInstalled())
    {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "open wx app failed, not installed or signature check failed");
      return 0;
    }
    return new MMSharedPreferences(this.context).getInt("_build_info_sdk_int_", 0);
  }
  
  public final boolean handleIntent(Intent paramIntent, IWXAPIEventHandler paramIWXAPIEventHandler)
  {
    if (!WXApiImplComm.isIntentFromWx(paramIntent, "com.tencent.mm.openapi.token"))
    {
      com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.WXApiImplV10", "handleIntent fail, intent not from weixin msg");
      return false;
    }
    if (this.detached) {
      throw new IllegalStateException("handleIntent fail, WXMsgImpl has been detached");
    }
    String str1 = paramIntent.getStringExtra("_mmessage_content");
    int i = paramIntent.getIntExtra("_mmessage_sdkVersion", 0);
    String str2 = paramIntent.getStringExtra("_mmessage_appPackage");
    if ((str2 == null) || (str2.length() == 0))
    {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "invalid argument");
      return false;
    }
    if (!checkSumConsistent(paramIntent.getByteArrayExtra("_mmessage_checksum"), b.a(str1, i, str2)))
    {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "checksum fail");
      return false;
    }
    i = paramIntent.getIntExtra("_wxapi_command_type", 0);
    switch (i)
    {
    case 7: 
    case 8: 
    default: 
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "unknown cmd = " + i);
      return false;
    case 1: 
      paramIWXAPIEventHandler.onResp(new SendAuth.Resp(paramIntent.getExtras()));
      return true;
    case 2: 
      paramIWXAPIEventHandler.onResp(new SendMessageToWX.Resp(paramIntent.getExtras()));
      return true;
    case 3: 
      paramIWXAPIEventHandler.onReq(new GetMessageFromWX.Req(paramIntent.getExtras()));
      return true;
    case 4: 
      paramIWXAPIEventHandler.onReq(new ShowMessageFromWX.Req(paramIntent.getExtras()));
      return true;
    case 5: 
      paramIWXAPIEventHandler.onResp(new PayResp(paramIntent.getExtras()));
      return true;
    case 6: 
      paramIWXAPIEventHandler.onReq(new LaunchFromWX.Req(paramIntent.getExtras()));
      return true;
    }
    paramIWXAPIEventHandler.onResp(new AddCardToWXCardPackage.Resp(paramIntent.getExtras()));
    return true;
  }
  
  public final boolean isWXAppInstalled()
  {
    if (this.detached) {
      throw new IllegalStateException("isWXAppInstalled fail, WXMsgImpl has been detached");
    }
    try
    {
      PackageInfo localPackageInfo = this.context.getPackageManager().getPackageInfo("com.tencent.mm", 64);
      if (localPackageInfo == null) {
        return false;
      }
      boolean bool = WXApiImplComm.validateAppSignature(this.context, localPackageInfo.signatures, this.checkSignature);
      return bool;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return false;
  }
  
  public final boolean isWXAppSupportAPI()
  {
    if (this.detached) {
      throw new IllegalStateException("isWXAppSupportAPI fail, WXMsgImpl has been detached");
    }
    return getWXAppSupportAPI() >= 570490883;
  }
  
  public final boolean openWXApp()
  {
    if (this.detached) {
      throw new IllegalStateException("openWXApp fail, WXMsgImpl has been detached");
    }
    if (!isWXAppInstalled())
    {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "open wx app failed, not installed or signature check failed");
      return false;
    }
    try
    {
      this.context.startActivity(this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm"));
      return true;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "startActivity fail, exception = " + localException.getMessage());
    }
    return false;
  }
  
  public final boolean registerApp(String paramString)
  {
    if (this.detached) {
      throw new IllegalStateException("registerApp fail, WXMsgImpl has been detached");
    }
    if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature))
    {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "register app failed for wechat app signature check failed");
      return false;
    }
    if ((activityCb == null) && (Build.VERSION.SDK_INT >= 14))
    {
      if (!(this.context instanceof Activity)) {
        break label221;
      }
      initMta(this.context, paramString);
      activityCb = new ActivityLifecycleCb(this.context, null);
      ((Activity)this.context).getApplication().registerActivityLifecycleCallbacks(activityCb);
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.d("MicroMsg.SDK.WXApiImplV10", "registerApp, appId = " + paramString);
      if (paramString != null) {
        this.appId = paramString;
      }
      com.tencent.mm.sdk.b.a.d("MicroMsg.SDK.WXApiImplV10", "register app " + this.context.getPackageName());
      paramString = new com.tencent.mm.sdk.a.a.a.a();
      paramString.o = "com.tencent.mm";
      paramString.p = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_REGISTER";
      paramString.m = ("weixin://registerapp?appid=" + this.appId);
      return com.tencent.mm.sdk.a.a.a.a(this.context, paramString);
      label221:
      if ((this.context instanceof Service))
      {
        initMta(this.context, paramString);
        activityCb = new ActivityLifecycleCb(this.context, null);
        ((Service)this.context).getApplication().registerActivityLifecycleCallbacks(activityCb);
      }
      else
      {
        com.tencent.mm.sdk.b.a.b("MicroMsg.SDK.WXApiImplV10", "context is not instanceof Activity or Service, disable WXStat");
      }
    }
  }
  
  public final boolean sendReq(BaseReq paramBaseReq)
  {
    if (this.detached) {
      throw new IllegalStateException("sendReq fail, WXMsgImpl has been detached");
    }
    if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature))
    {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "sendReq failed for wechat app signature check failed");
      return false;
    }
    if (!paramBaseReq.checkArgs())
    {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "sendReq checkArgs fail");
      return false;
    }
    com.tencent.mm.sdk.b.a.d("MicroMsg.SDK.WXApiImplV10", "sendReq, req type = " + paramBaseReq.getType());
    Bundle localBundle = new Bundle();
    paramBaseReq.toBundle(localBundle);
    if (paramBaseReq.getType() == 5) {
      return sendPayReq(this.context, localBundle);
    }
    if (paramBaseReq.getType() == 7) {
      return sendJumpToBizProfileReq(this.context, localBundle);
    }
    if (paramBaseReq.getType() == 8) {
      return sendJumpToBizWebviewReq(this.context, localBundle);
    }
    if (paramBaseReq.getType() == 9) {
      return sendAddCardToWX(this.context, localBundle);
    }
    paramBaseReq = new com.tencent.mm.sdk.a.a.a();
    paramBaseReq.n = localBundle;
    paramBaseReq.m = ("weixin://sendreq?appid=" + this.appId);
    paramBaseReq.k = "com.tencent.mm";
    paramBaseReq.l = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
    return com.tencent.mm.sdk.a.a.a(this.context, paramBaseReq);
  }
  
  public final boolean sendResp(BaseResp paramBaseResp)
  {
    if (this.detached) {
      throw new IllegalStateException("sendResp fail, WXMsgImpl has been detached");
    }
    if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature))
    {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "sendResp failed for wechat app signature check failed");
      return false;
    }
    if (!paramBaseResp.checkArgs())
    {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "sendResp checkArgs fail");
      return false;
    }
    Bundle localBundle = new Bundle();
    paramBaseResp.toBundle(localBundle);
    paramBaseResp = new com.tencent.mm.sdk.a.a.a();
    paramBaseResp.n = localBundle;
    paramBaseResp.m = ("weixin://sendresp?appid=" + this.appId);
    paramBaseResp.k = "com.tencent.mm";
    paramBaseResp.l = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
    return com.tencent.mm.sdk.a.a.a(this.context, paramBaseResp);
  }
  
  public final void unregisterApp()
  {
    if (this.detached) {
      throw new IllegalStateException("unregisterApp fail, WXMsgImpl has been detached");
    }
    if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature))
    {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "unregister app failed for wechat app signature check failed");
      return;
    }
    com.tencent.mm.sdk.b.a.d("MicroMsg.SDK.WXApiImplV10", "unregisterApp, appId = " + this.appId);
    if ((this.appId == null) || (this.appId.length() == 0))
    {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "unregisterApp fail, appId is empty");
      return;
    }
    com.tencent.mm.sdk.b.a.d("MicroMsg.SDK.WXApiImplV10", "unregister app " + this.context.getPackageName());
    com.tencent.mm.sdk.a.a.a.a locala = new com.tencent.mm.sdk.a.a.a.a();
    locala.o = "com.tencent.mm";
    locala.p = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_UNREGISTER";
    locala.m = ("weixin://unregisterapp?appid=" + this.appId);
    com.tencent.mm.sdk.a.a.a.a(this.context, locala);
  }
  
  private static final class ActivityLifecycleCb
    implements Application.ActivityLifecycleCallbacks
  {
    private static final int DELAYED = 800;
    private static final String TAG = "MicroMsg.SDK.WXApiImplV10.ActivityLifecycleCb";
    private Context context;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean isForeground = false;
    private Runnable onPausedRunnable = new WXApiImplV10.ActivityLifecycleCb.1(this);
    private Runnable onResumedRunnable = new WXApiImplV10.ActivityLifecycleCb.2(this);
    
    private ActivityLifecycleCb(Context paramContext)
    {
      this.context = paramContext;
    }
    
    public final void detach()
    {
      this.handler.removeCallbacks(this.onResumedRunnable);
      this.handler.removeCallbacks(this.onPausedRunnable);
      this.context = null;
    }
    
    public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
    
    public final void onActivityDestroyed(Activity paramActivity) {}
    
    public final void onActivityPaused(Activity paramActivity)
    {
      Log.v("MicroMsg.SDK.WXApiImplV10.ActivityLifecycleCb", paramActivity.getComponentName().getClassName() + "  onActivityPaused");
      this.handler.removeCallbacks(this.onResumedRunnable);
      this.handler.postDelayed(this.onPausedRunnable, 800L);
    }
    
    public final void onActivityResumed(Activity paramActivity)
    {
      Log.v("MicroMsg.SDK.WXApiImplV10.ActivityLifecycleCb", paramActivity.getComponentName().getClassName() + "  onActivityResumed");
      this.handler.removeCallbacks(this.onPausedRunnable);
      this.handler.postDelayed(this.onResumedRunnable, 800L);
    }
    
    public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public final void onActivityStarted(Activity paramActivity) {}
    
    public final void onActivityStopped(Activity paramActivity) {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\tencent\mm\sdk\openapi\WXApiImplV10.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */