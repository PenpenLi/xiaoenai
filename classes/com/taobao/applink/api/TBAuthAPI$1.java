package com.taobao.applink.api;

import android.util.Log;
import com.taobao.applink.auth.TBAppLinkAuthListener;
import com.taobao.applink.auth.userinfo.TBAppLinkUserInfo;
import com.taobao.applink.jsbridge.adapter.TBBridgeCallBackFunction;

class TBAuthAPI$1
  implements TBAppLinkAuthListener
{
  TBAuthAPI$1(TBAuthAPI paramTBAuthAPI, TBBridgeCallBackFunction paramTBBridgeCallBackFunction) {}
  
  public void onFailure()
  {
    if (this.val$function == null) {
      return;
    }
    try
    {
      this.val$function.onCallBack("{\"result\":false}");
      return;
    }
    catch (Exception localException)
    {
      Log.d("AppLink", localException.toString());
    }
  }
  
  public void onSuccess(TBAppLinkUserInfo paramTBAppLinkUserInfo)
  {
    if (this.val$function == null) {
      return;
    }
    try
    {
      this.val$function.onCallBack(String.format("{\"result\":true,\"mixedNick\":\"%s\",\"icon\":\"%s\"}", new Object[] { paramTBAppLinkUserInfo.mixedNick, paramTBAppLinkUserInfo.icon }));
      return;
    }
    catch (Exception paramTBAppLinkUserInfo)
    {
      Log.d("AppLink", paramTBAppLinkUserInfo.toString());
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\applink\api\TBAuthAPI$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */