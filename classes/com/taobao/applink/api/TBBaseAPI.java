package com.taobao.applink.api;

import android.content.Context;
import com.taobao.applink.jsbridge.adapter.TBBridgeCallBackFunction;

public abstract class TBBaseAPI
{
  public TBBridgeCallBackFunction mFunction;
  
  public void execute(Context paramContext, TBBridgeCallBackFunction paramTBBridgeCallBackFunction)
  {
    if (paramTBBridgeCallBackFunction != null)
    {
      invodeWithJsBridge(paramContext, paramTBBridgeCallBackFunction);
      return;
    }
    invokeWithNative(paramContext);
  }
  
  public abstract void invodeWithJsBridge(Context paramContext, TBBridgeCallBackFunction paramTBBridgeCallBackFunction);
  
  public abstract void invokeWithNative(Context paramContext);
  
  public abstract void onFailure(Exception paramException);
  
  public abstract void onSuccess();
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\applink\api\TBBaseAPI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */