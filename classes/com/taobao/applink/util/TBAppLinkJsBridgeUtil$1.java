package com.taobao.applink.util;

import android.util.Log;
import android.webkit.WebView;
import com.taobao.applink.distribution.TBAppLinkDistribution;
import com.taobao.applink.exception.TBAppLinkException;
import com.taobao.applink.factoty.TBAppLinkFactory;
import com.taobao.applink.jsbridge.adapter.TBBridgeCallBackFunction;
import com.taobao.applink.jsbridge.adapter.TBBridgeHandler;

final class TBAppLinkJsBridgeUtil$1
  implements TBBridgeHandler
{
  TBAppLinkJsBridgeUtil$1(WebView paramWebView) {}
  
  public void handler(String paramString, TBBridgeCallBackFunction paramTBBridgeCallBackFunction)
  {
    try
    {
      TBAppLinkDistribution.invoke(this.val$webView.getContext(), TBAppLinkFactory.createTBBaseParam(paramString), paramTBBridgeCallBackFunction);
      return;
    }
    catch (TBAppLinkException paramString)
    {
      Log.d("AppLink", paramString.toString());
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\applink\util\TBAppLinkJsBridgeUtil$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */