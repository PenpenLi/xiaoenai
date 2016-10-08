package com.alibaba.sdk.android.ui.bus.filter.impl;

import com.alibaba.sdk.android.ui.bus.MatchInfo;
import com.alibaba.sdk.android.ui.bus.filter.Filter;
import com.alibaba.sdk.android.ui.bus.filter.FilterAction;
import com.alibaba.sdk.android.ui.bus.filter.FilterContext;
import com.alibaba.sdk.android.ui.bus.filter.FilterInfo;
import com.alibaba.sdk.android.ui.bus.filter.FilterInfo.ActionInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class FilterImpl
  implements Filter
{
  private List<FilterAction> filterActions;
  private FilterInfo filterInfo;
  
  public FilterImpl(FilterInfo paramFilterInfo)
  {
    this.filterInfo = paramFilterInfo;
    if ((paramFilterInfo.actionInfos == null) || (paramFilterInfo.actionInfos.size() == 0)) {
      this.filterActions = Collections.emptyList();
    }
    for (;;)
    {
      return;
      this.filterActions = new ArrayList(paramFilterInfo.actionInfos.size());
      paramFilterInfo = paramFilterInfo.actionInfos.values().iterator();
      while (paramFilterInfo.hasNext())
      {
        FilterAction localFilterAction = ((FilterInfo.ActionInfo)paramFilterInfo.next()).createAction();
        if (localFilterAction != null) {
          this.filterActions.add(localFilterAction);
        }
      }
    }
  }
  
  public boolean doFilter(FilterContext paramFilterContext)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (this.filterInfo.matchInfos != null)
    {
      if (this.filterActions.size() != 0) {
        break label36;
      }
      bool2 = bool1;
    }
    label36:
    Iterator localIterator;
    do
    {
      return bool2;
      localIterator = this.filterInfo.matchInfos.values().iterator();
      do
      {
        bool2 = bool1;
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!((MatchInfo)localIterator.next()).isMatch(paramFilterContext));
      localIterator = this.filterActions.iterator();
      bool1 = bool3;
      bool2 = bool1;
    } while (!localIterator.hasNext());
    if (((FilterAction)localIterator.next()).execute(paramFilterContext)) {
      bool1 = true;
    }
    for (;;)
    {
      break;
    }
  }
  
  public FilterInfo getFilterInfo()
  {
    return this.filterInfo;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\bus\filter\impl\FilterImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */