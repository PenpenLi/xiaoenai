package com.alibaba.sdk.android.webview;

import android.text.TextUtils;

class BridgeCallbackContext$2
  implements Runnable
{
  BridgeCallbackContext$2(BridgeCallbackContext paramBridgeCallbackContext, String paramString) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.val$retString)) {}
    for (String str = String.format("javascript:window.HavanaBridge.onFailure(%s,'');", new Object[] { Integer.valueOf(this.this$0.requestId) });; str = String.format("javascript:window.HavanaBridge.onFailure(%s,'%s');", new Object[] { Integer.valueOf(this.this$0.requestId), BridgeCallbackContext.access$000(this.val$retString) }))
    {
      BridgeCallbackContext.access$100(this.this$0, str);
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\webview\BridgeCallbackContext$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */