package com.taobao.applink.jsbridge;

import com.taobao.applink.jsbridge.adapter.TBBridgeCallBackFunction;

class TBBridgeHelper$1$1
  implements TBBridgeCallBackFunction
{
  TBBridgeHelper$1$1(TBBridgeHelper.1 param1, String paramString) {}
  
  public void onCallBack(String paramString)
  {
    TBBridgeMessage localTBBridgeMessage = new TBBridgeMessage();
    localTBBridgeMessage.setResponseId(this.val$callbackId);
    localTBBridgeMessage.setResponseData(paramString);
    TBBridgeHelper.access$100(this.this$1.this$0, this.this$1.val$webView, localTBBridgeMessage);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\applink\jsbridge\TBBridgeHelper$1$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */