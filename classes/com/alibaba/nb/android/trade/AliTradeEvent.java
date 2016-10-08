package com.alibaba.nb.android.trade;

import android.app.Activity;
import android.webkit.WebView;
import com.alibaba.nb.android.trade.utils.h;
import com.alibaba.sdk.android.callback.CallbackContext;

public class AliTradeEvent
{
  public static final int ACTIVITY_BACKPRESS = 4099;
  public static final int ACTIVTY_RESULT = 4097;
  public static final int EVENT_HANDLE = 4101;
  public static final int EVENT_START = 4096;
  public static final int EVENT_SUCCESS = 4098;
  public static final int EVENT_UNHANDLE = 4100;
  public static final int PARAM_ERROR = 4102;
  
  public static int postEvent(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return 4102;
      } while (paramVarArgs.length != 3);
      paramInt = h.b(paramVarArgs[0]);
      int i = h.b(paramVarArgs[1]);
      paramVarArgs = h.c(paramVarArgs[2]);
      if ((paramInt != Integer.MIN_VALUE) && (i != Integer.MIN_VALUE)) {
        CallbackContext.onActivityResult(paramInt, i, paramVarArgs);
      }
      for (;;)
      {
        return 4098;
        com.alibaba.nb.android.trade.utils.d.a.d("AliTradeSDK", "activity for result error");
      }
    } while ((paramVarArgs.length != 2) || (!(paramVarArgs[0] instanceof WebView)) || (!(paramVarArgs[1] instanceof Activity)));
    WebView localWebView = (WebView)paramVarArgs[0];
    paramVarArgs = (Activity)paramVarArgs[1];
    if ((com.alibaba.nb.android.trade.utils.g.a.a(localWebView.getUrl())) || (com.alibaba.nb.android.trade.utils.g.a.b(localWebView.getUrl())) || (com.alibaba.nb.android.trade.utils.g.a.c(localWebView.getUrl())) || (com.alibaba.nb.android.trade.utils.g.a.d(localWebView.getUrl())))
    {
      if (com.alibaba.nb.android.trade.utils.g.a.a(localWebView)) {
        com.alibaba.nb.android.trade.utils.g.a.b(localWebView);
      }
      for (;;)
      {
        return 4101;
        paramVarArgs.finish();
      }
    }
    return 4100;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\AliTradeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */