package com.taobao.applink.distribution;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.taobao.applink.TBAppLinkSDK;
import com.taobao.applink.TBAppLinkSDK.JumpFailedMode;
import com.taobao.applink.api.TBAPIType;
import com.taobao.applink.api.TBAuthAPI;
import com.taobao.applink.api.TBBaseAPI;
import com.taobao.applink.api.TBJumpAPI;
import com.taobao.applink.jsbridge.adapter.TBBridgeCallBackFunction;
import com.taobao.applink.param.TBBaseParam;
import com.taobao.applink.service.TBAppLinkServiceProxy;
import com.taobao.applink.usertracker.TBMiniUserTrack;
import com.taobao.applink.util.TBAppLinkStringUtil;
import com.taobao.applink.util.TBAppLinkUtil;

public class TBAppLinkDistribution
{
  private static TBBaseAPI getAPI(TBBaseParam paramTBBaseParam)
  {
    if (paramTBBaseParam == null) {}
    do
    {
      return null;
      if (paramTBBaseParam.mTBAPIType == TBAPIType.AUTH) {
        return new TBAuthAPI(paramTBBaseParam.mListener);
      }
    } while (paramTBBaseParam.mTBAPIType != TBAPIType.JUMP);
    return new TBJumpAPI();
  }
  
  public static boolean invoke(Context paramContext, TBBaseParam paramTBBaseParam, TBBridgeCallBackFunction paramTBBridgeCallBackFunction)
  {
    if ((paramContext == null) || (paramTBBaseParam == null)) {}
    TBBaseAPI localTBBaseAPI;
    do
    {
      return false;
      localTBBaseAPI = getAPI(paramTBBaseParam);
      localTBBaseAPI.execute(paramContext, paramTBBridgeCallBackFunction);
    } while (localTBBaseAPI == null);
    paramTBBridgeCallBackFunction = TBAppLinkSDK.getInstance().mJumpFailedMode;
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(paramTBBaseParam.getJumpUrl(paramContext)));
    localIntent.setAction("com.taobao.open.intent.action.GETWAY");
    localIntent.setFlags(805339136);
    if (TBAppLinkUtil.isSupportAppLinkSDK(paramContext)) {
      return invokeNativeWithTaoPhoneSupport(paramContext, localIntent, localTBBaseAPI);
    }
    return invokeH5WithOutTaoPhoneSupport(paramContext, paramTBBaseParam, localTBBaseAPI, paramTBBridgeCallBackFunction);
  }
  
  private static boolean invokeH5WithOutTaoPhoneSupport(Context paramContext, TBBaseParam paramTBBaseParam, TBBaseAPI paramTBBaseAPI, TBAppLinkSDK.JumpFailedMode paramJumpFailedMode)
  {
    boolean bool = false;
    Intent localIntent = new Intent("android.intent.action.VIEW");
    switch (paramJumpFailedMode)
    {
    default: 
      bool = startActivity(paramContext, localIntent, paramTBBaseAPI);
    }
    do
    {
      do
      {
        return bool;
        localIntent.setData(Uri.parse("http://huodong.m.taobao.com/go/2085.html"));
        if (TBAppLinkServiceProxy.getTBMiniUserTrack() == null) {
          break;
        }
        TBAppLinkServiceProxy.getTBMiniUserTrack().commitEventAndFlush("0");
        break;
        if (TBAppLinkServiceProxy.getTBMiniUserTrack() != null) {
          TBAppLinkServiceProxy.getTBMiniUserTrack().commitEventAndFlush("1");
        }
      } while (TBAppLinkStringUtil.isBlank(paramTBBaseParam.getH5URL()));
      localIntent.setData(Uri.parse(paramTBBaseParam.getH5URL()));
      break;
    } while (TBAppLinkServiceProxy.getTBMiniUserTrack() == null);
    TBAppLinkServiceProxy.getTBMiniUserTrack().commitEventAndFlush("2");
    return false;
  }
  
  private static boolean invokeNativeWithTaoPhoneSupport(Context paramContext, Intent paramIntent, TBBaseAPI paramTBBaseAPI)
  {
    return startActivity(paramContext, paramIntent, paramTBBaseAPI);
  }
  
  private static boolean startActivity(Context paramContext, Intent paramIntent, TBBaseAPI paramTBBaseAPI)
  {
    if ((paramContext == null) || (paramIntent == null) || (paramTBBaseAPI == null)) {
      return false;
    }
    try
    {
      if ((paramContext instanceof Application)) {
        paramIntent.addFlags(268435456);
      }
      paramContext.startActivity(paramIntent);
      paramTBBaseAPI.onSuccess();
      return true;
    }
    catch (Exception paramContext)
    {
      paramTBBaseAPI.onFailure(paramContext);
    }
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\applink\distribution\TBAppLinkDistribution.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */