package com.alibaba.sdk.android.ui.bus.handler.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.ui.UIContext;
import com.alibaba.sdk.android.ui.bus.handler.HandlerAction;
import com.alibaba.sdk.android.ui.bus.handler.HandlerContext;
import com.alibaba.sdk.android.ui.bus.handler.HandlerInfo;
import java.util.Map;

public class StartActivityHandlerAction
  implements HandlerAction
{
  private String action;
  
  public StartActivityHandlerAction(HandlerInfo paramHandlerInfo)
  {
    this.action = ((String)paramHandlerInfo.actionParameters.get("action"));
    if (TextUtils.isEmpty(this.action)) {
      this.action = "android.intent.action.VIEW";
    }
  }
  
  public boolean execute(HandlerContext paramHandlerContext)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramHandlerContext.getUri()));
    if (paramHandlerContext.activity != null) {
      paramHandlerContext.activity.startActivity(localIntent);
    }
    for (;;)
    {
      return true;
      if (paramHandlerContext.webView != null)
      {
        paramHandlerContext.webView.getContext().startActivity(localIntent);
      }
      else if (UIContext.appContext != null)
      {
        localIntent.addFlags(268435456);
        UIContext.appContext.getAndroidContext().startActivity(localIntent);
      }
      else
      {
        if (paramHandlerContext.webViewProxy == null) {
          break;
        }
        ((View)paramHandlerContext.webViewProxy).getContext().startActivity(localIntent);
      }
    }
    AliSDKLogger.e("ui", "fail to handler the url " + paramHandlerContext.getUri() + " as no activity/webview/global application context is set");
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\bus\handler\impl\StartActivityHandlerAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */