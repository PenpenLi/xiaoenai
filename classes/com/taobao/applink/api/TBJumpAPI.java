package com.taobao.applink.api;

import android.content.Context;
import com.taobao.applink.jsbridge.adapter.TBBridgeCallBackFunction;

public class TBJumpAPI
  extends TBBaseAPI
{
  public void invodeWithJsBridge(Context paramContext, TBBridgeCallBackFunction paramTBBridgeCallBackFunction)
  {
    this.mFunction = paramTBBridgeCallBackFunction;
  }
  
  public void invokeWithNative(Context paramContext) {}
  
  public void onFailure(Exception paramException)
  {
    if (this.mFunction != null) {
      this.mFunction.onCallBack("{\"result\":false}");
    }
  }
  
  public void onSuccess()
  {
    if (this.mFunction != null) {
      this.mFunction.onCallBack("{\"result\":true}");
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\applink\api\TBJumpAPI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */