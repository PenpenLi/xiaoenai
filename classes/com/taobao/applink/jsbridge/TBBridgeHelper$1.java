package com.taobao.applink.jsbridge;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.taobao.applink.jsbridge.adapter.TBBridgeCallBackFunction;
import com.taobao.applink.jsbridge.adapter.TBBridgeHandler;
import java.util.List;
import java.util.Map;

class TBBridgeHelper$1
  implements TBBridgeCallBackFunction
{
  TBBridgeHelper$1(TBBridgeHelper paramTBBridgeHelper, WebView paramWebView) {}
  
  public void onCallBack(String paramString)
  {
    List localList;
    try
    {
      localList = TBBridgeMessage.toArrayList(paramString);
      if ((localList == null) || (localList.size() == 0)) {
        return;
      }
    }
    catch (Exception paramString)
    {
      Log.d("AppLink", paramString.toString());
      return;
    }
    int i = 0;
    TBBridgeMessage localTBBridgeMessage;
    while (i < localList.size())
    {
      localTBBridgeMessage = (TBBridgeMessage)localList.get(i);
      paramString = localTBBridgeMessage.getResponseId();
      if (TextUtils.isEmpty(paramString)) {
        break label120;
      }
      ((TBBridgeCallBackFunction)TBBridgeHelper.access$000(this.this$0).get(paramString)).onCallBack(localTBBridgeMessage.getResponseData());
      TBBridgeHelper.access$000(this.this$0).remove(paramString);
      i += 1;
    }
    label120:
    paramString = localTBBridgeMessage.getCallbackId();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new TBBridgeHelper.1.1(this, paramString);
      label143:
      if (TextUtils.isEmpty(localTBBridgeMessage.getHandlerName())) {
        break label202;
      }
    }
    label202:
    for (TBBridgeHandler localTBBridgeHandler = (TBBridgeHandler)TBBridgeHelper.access$200(this.this$0).get(localTBBridgeMessage.getHandlerName());; localTBBridgeHandler = TBBridgeHelper.access$300(this.this$0))
    {
      localTBBridgeHandler.handler(localTBBridgeMessage.getData(), paramString);
      break;
      paramString = new TBBridgeHelper.1.2(this);
      break label143;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\applink\jsbridge\TBBridgeHelper$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */