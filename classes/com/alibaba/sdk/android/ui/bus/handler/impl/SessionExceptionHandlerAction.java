package com.alibaba.sdk.android.ui.bus.handler.impl;

import android.net.Uri;
import android.webkit.WebView;
import com.alibaba.sdk.android.session.task.SidExpireTask;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.ui.bus.handler.HandlerAction;
import com.alibaba.sdk.android.ui.bus.handler.HandlerContext;
import com.alibaba.sdk.android.ui.bus.handler.HandlerInfo;

public class SessionExceptionHandlerAction
  implements HandlerAction
{
  private HandlerInfo handlerInfo;
  
  public SessionExceptionHandlerAction(HandlerInfo paramHandlerInfo)
  {
    this.handlerInfo = paramHandlerInfo;
  }
  
  public boolean execute(HandlerContext paramHandlerContext)
  {
    if (paramHandlerContext.getScenario() != 2) {
      return false;
    }
    if (AliSDKLogger.isDebugEnabled()) {
      AliSDKLogger.d("ui", "session exception url: " + paramHandlerContext.getUri());
    }
    try
    {
      int i = Integer.parseInt(Uri.parse(paramHandlerContext.getUri()).getQueryParameter("code"));
      if (i == 1) {
        new SidExpireTask(paramHandlerContext.webView).execute(new Void[0]);
      } else if (i == 2) {
        paramHandlerContext.webView.reload();
      }
    }
    catch (Throwable paramHandlerContext)
    {
      AliSDKLogger.e("ui", paramHandlerContext.getMessage(), paramHandlerContext);
    }
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\bus\handler\impl\SessionExceptionHandlerAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */