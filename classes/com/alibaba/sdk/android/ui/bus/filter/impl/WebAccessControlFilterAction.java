package com.alibaba.sdk.android.ui.bus.filter.impl;

import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.security.AccessController;
import com.alibaba.sdk.android.ui.UIContext;
import com.alibaba.sdk.android.ui.bus.filter.FilterAction;
import com.alibaba.sdk.android.ui.bus.filter.FilterContext;
import com.alibaba.sdk.android.ui.bus.filter.FilterInfo.ActionInfo;

public class WebAccessControlFilterAction
  implements FilterAction
{
  private FilterInfo.ActionInfo actionInfo;
  
  public WebAccessControlFilterAction(FilterInfo.ActionInfo paramActionInfo)
  {
    this.actionInfo = paramActionInfo;
  }
  
  public boolean execute(FilterContext paramFilterContext)
  {
    String str = paramFilterContext.getSchemelessUri();
    AccessController localAccessController = (AccessController)UIContext.appContext.getService(AccessController.class);
    if (localAccessController == null) {
      return false;
    }
    if (!localAccessController.checkWebPageAccessPermission(str))
    {
      paramFilterContext.setUri(UIContext.noViewRightUrl);
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\bus\filter\impl\WebAccessControlFilterAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */