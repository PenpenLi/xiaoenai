package com.alibaba.sdk.android.ui.bus.filter.impl;

import com.alibaba.sdk.android.el.ELResolver;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.ui.bus.filter.FilterAction;
import com.alibaba.sdk.android.ui.bus.filter.FilterContext;
import com.alibaba.sdk.android.ui.bus.filter.FilterInfo.ActionInfo;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UpdateParameterFilterAction
  implements FilterAction
{
  public static final String ADD_IF_ABSENT = "addIfAbsent";
  public static final String APPEND = "append";
  public static final String CACHEABLE = "cacheable";
  public static final String DELETE = "delete";
  public static final String MODE = "mode";
  public static final String REGEXP = "regexp";
  public static final String REPLACE = "replace";
  public static final String UPDATE = "update";
  private FilterInfo.ActionInfo actionInfo;
  private boolean cacheable;
  private String cachedValue;
  private String key;
  private String mode;
  private Pattern pattern;
  private String value;
  
  public UpdateParameterFilterAction(FilterInfo.ActionInfo paramActionInfo)
  {
    String str = (String)paramActionInfo.parameters.get("regexp");
    if (str != null) {
      this.pattern = Pattern.compile(str);
    }
    this.key = ((String)paramActionInfo.parameters.get("key"));
    this.value = ((String)paramActionInfo.parameters.get("value"));
    this.mode = ((String)paramActionInfo.parameters.get("mode"));
    this.cacheable = "true".equals(paramActionInfo.parameters.get("cacheable"));
    this.actionInfo = paramActionInfo;
  }
  
  private Map<String, String> createResolveParameters(FilterContext paramFilterContext)
  {
    HashMap localHashMap = new HashMap();
    if (this.actionInfo.parameters != null) {
      localHashMap.putAll(this.actionInfo.parameters);
    }
    localHashMap.putAll(paramFilterContext.getContextParameters());
    return localHashMap;
  }
  
  public boolean execute(FilterContext paramFilterContext)
  {
    boolean bool = true;
    if (this.key == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      Object localObject1 = paramFilterContext.getQueryParameter(this.key);
      Object localObject2;
      if (((!"addIfAbsent".equals(this.mode)) && (!"update".equals(this.mode))) || ((localObject1 == null) || ("append".equals(this.mode))))
      {
        if ((this.cacheable) && (this.cachedValue != null)) {
          localObject1 = this.cachedValue;
        }
        while (localObject1 != null)
        {
          paramFilterContext.appendQueryParameter(this.key, (String)localObject1);
          return true;
          localObject1 = createResolveParameters(paramFilterContext);
          localObject2 = ELResolver.resolve(this.value, (Map)localObject1);
          localObject1 = localObject2;
          if (this.cacheable)
          {
            this.cachedValue = ((String)localObject2);
            localObject1 = localObject2;
          }
        }
      }
      else
      {
        if (((!"replace".equals(this.mode)) && (!"update".equals(this.mode))) || (localObject1 == null)) {
          break;
        }
        if ((this.cacheable) && (this.cachedValue != null)) {
          localObject1 = this.cachedValue;
        }
        while (localObject1 != null)
        {
          paramFilterContext.updateQueryParameter(this.key, (String)localObject1);
          return true;
          localObject2 = createResolveParameters(paramFilterContext);
          if (this.pattern != null)
          {
            Matcher localMatcher = this.pattern.matcher((CharSequence)localObject1);
            if (localMatcher.matches())
            {
              int j = localMatcher.groupCount();
              int i = 1;
              while (i <= j)
              {
                ((Map)localObject2).put("group_" + i, localMatcher.group(i));
                i += 1;
              }
            }
            ((Map)localObject2).put("group_0", localObject1);
          }
          localObject2 = ELResolver.resolve(this.value, (Map)localObject2);
          localObject1 = localObject2;
          if (this.cacheable)
          {
            this.cachedValue = ((String)localObject2);
            localObject1 = localObject2;
          }
        }
      }
    }
    if ("delete".equals(this.mode))
    {
      paramFilterContext.removeQueryParameters(this.key);
      return true;
    }
    AliSDKLogger.i("ui", "ignore the action " + this.mode + " key " + this.key);
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\bus\filter\impl\UpdateParameterFilterAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */