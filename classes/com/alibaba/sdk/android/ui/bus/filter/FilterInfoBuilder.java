package com.alibaba.sdk.android.ui.bus.filter;

import com.alibaba.sdk.android.ui.bus.MatchInfo;
import java.util.LinkedHashMap;
import java.util.Map;

public class FilterInfoBuilder
{
  private FilterInfo filterInfo = new FilterInfo();
  
  public static FilterInfoBuilder newFilterInfo(String paramString)
  {
    FilterInfoBuilder localFilterInfoBuilder = new FilterInfoBuilder();
    localFilterInfoBuilder.filterInfo.name = paramString;
    return localFilterInfoBuilder;
  }
  
  public FilterInfoBuilder addFilterAction(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    FilterInfo.ActionInfo localActionInfo = new FilterInfo.ActionInfo();
    localActionInfo.name = paramString1;
    localActionInfo.type = paramString2;
    localActionInfo.parameters = paramMap;
    this.filterInfo.actionInfos.put(localActionInfo.name, localActionInfo);
    return this;
  }
  
  public FilterInfoBuilder addMatchInfo(String paramString1, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    MatchInfo localMatchInfo = new MatchInfo();
    localMatchInfo.name = paramString1;
    localMatchInfo.type = paramString2;
    localMatchInfo.schemes = paramArrayOfString1;
    localMatchInfo.values = paramArrayOfString2;
    this.filterInfo.matchInfos.put(localMatchInfo.name, localMatchInfo);
    return this;
  }
  
  public FilterInfo getFilterInfo()
  {
    return this.filterInfo;
  }
  
  public FilterInfoBuilder setFilterOrder(Boolean paramBoolean1, Boolean paramBoolean2, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    this.filterInfo.beforeAll = paramBoolean1;
    this.filterInfo.afterAll = paramBoolean2;
    this.filterInfo.before = paramArrayOfString1;
    this.filterInfo.after = paramArrayOfString2;
    return this;
  }
  
  public FilterInfoBuilder setFilterScenarios(int[] paramArrayOfInt)
  {
    this.filterInfo.scenarios = paramArrayOfInt;
    return this;
  }
  
  public FilterInfoBuilder setFilterScopes(String[] paramArrayOfString)
  {
    this.filterInfo.scopes = paramArrayOfString;
    return this;
  }
  
  public FilterInfoBuilder setFilterType(String paramString)
  {
    this.filterInfo.type = paramString;
    return this;
  }
  
  public FilterInfoBuilder setProcceed(boolean paramBoolean)
  {
    this.filterInfo.procceed = paramBoolean;
    return this;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\bus\filter\FilterInfoBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */