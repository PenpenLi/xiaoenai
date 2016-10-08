package com.alibaba.sdk.android.ui;

import com.alibaba.sdk.android.event.Event;
import com.alibaba.sdk.android.event.EventListener;
import com.alibaba.sdk.android.web.impl.CookieManagerWrapper;
import java.util.Map;

class UIComponent$2
  implements EventListener
{
  UIComponent$2(UIComponent paramUIComponent) {}
  
  public int getThreadModel()
  {
    return 2;
  }
  
  public void onEvent(Event paramEvent)
  {
    if (paramEvent.params != null) {}
    for (paramEvent = paramEvent.params.get("cookies");; paramEvent = null)
    {
      paramEvent = (Map)paramEvent;
      if (paramEvent != null) {
        break;
      }
      return;
    }
    CookieManagerWrapper.INSTANCE.setCookiesWithIncludeCookieNames(paramEvent, UIContext.cookieNamesWithApplicationLifecycle, true);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\UIComponent$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */