package com.alibaba.sdk.android.ui.bus.filter.impl;

import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.ui.UIContext;
import com.alibaba.sdk.android.ui.bus.filter.FilterAction;
import com.alibaba.sdk.android.ui.bus.filter.FilterContext;
import com.alibaba.sdk.android.ui.bus.filter.FilterInfo.ActionInfo;
import com.alibaba.sdk.android.ut.UserTrackerService;

public class LoggerFilterAction
  implements FilterAction
{
  private FilterInfo.ActionInfo actionInfo;
  
  public LoggerFilterAction(FilterInfo.ActionInfo paramActionInfo)
  {
    this.actionInfo = paramActionInfo;
  }
  
  public boolean execute(FilterContext paramFilterContext)
  {
    UserTrackerService localUserTrackerService = (UserTrackerService)UIContext.appContext.getService(UserTrackerService.class);
    if (localUserTrackerService != null) {
      localUserTrackerService.sendCustomHit("uibus", paramFilterContext.getUri(), null);
    }
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\bus\filter\impl\LoggerFilterAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */