package com.taobao.applink.api;

import android.content.Context;
import com.taobao.applink.auth.TBAppLinkAuthListener;
import com.taobao.applink.auth.TBAppLinkAuthService;
import com.taobao.applink.jsbridge.adapter.TBBridgeCallBackFunction;

public class TBAuthAPI
  extends TBBaseAPI
{
  public TBAppLinkAuthListener mListener;
  
  public TBAuthAPI(TBAppLinkAuthListener paramTBAppLinkAuthListener)
  {
    this.mListener = paramTBAppLinkAuthListener;
  }
  
  public void invodeWithJsBridge(Context paramContext, TBBridgeCallBackFunction paramTBBridgeCallBackFunction)
  {
    if ((paramContext == null) || (paramTBBridgeCallBackFunction == null)) {
      return;
    }
    paramContext = new TBAuthAPI.1(this, paramTBBridgeCallBackFunction);
    this.mFunction = paramTBBridgeCallBackFunction;
    this.mListener = paramContext;
  }
  
  public void invokeWithNative(Context paramContext)
  {
    if (this.mListener == null) {}
  }
  
  public void onFailure(Exception paramException) {}
  
  public void onSuccess()
  {
    if (this.mListener == null) {
      return;
    }
    new TBAppLinkAuthService(this.mListener).bindService();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\applink\api\TBAuthAPI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */