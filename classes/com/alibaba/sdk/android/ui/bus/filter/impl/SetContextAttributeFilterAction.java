package com.alibaba.sdk.android.ui.bus.filter.impl;

import com.alibaba.sdk.android.ui.bus.filter.FilterAction;
import com.alibaba.sdk.android.ui.bus.filter.FilterContext;
import com.alibaba.sdk.android.ui.bus.filter.FilterInfo.ActionInfo;
import java.util.Map;

public class SetContextAttributeFilterAction
  implements FilterAction
{
  public static final String KEY = "key";
  public static final String VALUE = "value";
  private FilterInfo.ActionInfo actionInfo;
  
  public SetContextAttributeFilterAction(FilterInfo.ActionInfo paramActionInfo)
  {
    this.actionInfo = paramActionInfo;
  }
  
  public boolean execute(FilterContext paramFilterContext)
  {
    Object localObject = this.actionInfo.parameters;
    String str = (String)((Map)localObject).get("key");
    localObject = (String)((Map)localObject).get("value");
    if ((str == null) || (localObject == null)) {
      return true;
    }
    paramFilterContext.setContextParameter(str, (String)localObject);
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\bus\filter\impl\SetContextAttributeFilterAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */