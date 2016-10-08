package com.taobao.applink.jsbridge;

import com.taobao.applink.jsbridge.adapter.TBBridgeCallBackFunction;
import com.taobao.applink.jsbridge.adapter.TBBridgeHandler;

public class TBBridgeDefaultHandler
  implements TBBridgeHandler
{
  public void handler(String paramString, TBBridgeCallBackFunction paramTBBridgeCallBackFunction)
  {
    if (paramTBBridgeCallBackFunction != null) {
      paramTBBridgeCallBackFunction.onCallBack("DefaultHandler response data");
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\applink\jsbridge\TBBridgeDefaultHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */