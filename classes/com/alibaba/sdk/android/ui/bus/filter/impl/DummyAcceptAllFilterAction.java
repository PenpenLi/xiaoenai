package com.alibaba.sdk.android.ui.bus.filter.impl;

import com.alibaba.sdk.android.ui.bus.filter.FilterAction;
import com.alibaba.sdk.android.ui.bus.filter.FilterContext;
import com.alibaba.sdk.android.ui.bus.filter.FilterInfo.ActionInfo;

public class DummyAcceptAllFilterAction
  implements FilterAction
{
  public DummyAcceptAllFilterAction(FilterInfo.ActionInfo paramActionInfo) {}
  
  public boolean execute(FilterContext paramFilterContext)
  {
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\bus\filter\impl\DummyAcceptAllFilterAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */