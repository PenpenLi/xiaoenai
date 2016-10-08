package com.alibaba.sdk.android.login.impl;

import com.alibaba.sdk.android.AlibabaSDK;
import com.alibaba.sdk.android.event.Event;
import com.alibaba.sdk.android.event.EventListener;
import com.alibaba.sdk.android.ut.UserTrackerService;
import java.util.HashMap;
import java.util.Map;

class LoginLifecycleAdapter$2
  implements EventListener
{
  LoginLifecycleAdapter$2(LoginLifecycleAdapter paramLoginLifecycleAdapter) {}
  
  public int getThreadModel()
  {
    return 2;
  }
  
  public void onEvent(Event paramEvent)
  {
    AlibabaSDK.setGlobalProperty("AUTO_DEGRADE_NOT_LOGIN", "T");
    HashMap localHashMap;
    if (LoginContext.userTrackerService != null)
    {
      localHashMap = new HashMap();
      if (!"rpc-degrade".equals(paramEvent.name)) {
        break label57;
      }
      localHashMap.put("type", "forRpcFailed");
    }
    for (;;)
    {
      LoginContext.userTrackerService.sendCustomHit("degarade", null, localHashMap);
      return;
      label57:
      if ("init-degrade".equals(paramEvent.name)) {
        localHashMap.put("type", "forRpcFailed");
      } else {
        localHashMap.put("type", "unknown");
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\impl\LoginLifecycleAdapter$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */