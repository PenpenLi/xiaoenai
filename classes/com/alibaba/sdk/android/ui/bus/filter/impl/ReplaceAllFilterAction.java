package com.alibaba.sdk.android.ui.bus.filter.impl;

import com.alibaba.sdk.android.el.ELResolver;
import com.alibaba.sdk.android.ui.bus.filter.FilterAction;
import com.alibaba.sdk.android.ui.bus.filter.FilterContext;
import com.alibaba.sdk.android.ui.bus.filter.FilterInfo.ActionInfo;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceAllFilterAction
  implements FilterAction
{
  public static final String REGEXP = "regexp";
  public static final String REPLACEMENT = "replacement";
  public static final String TARGET = "target";
  private FilterInfo.ActionInfo actionInfo;
  private String replace;
  private Pattern replaceRegexp;
  private String target;
  
  public ReplaceAllFilterAction(FilterInfo.ActionInfo paramActionInfo)
  {
    this.actionInfo = paramActionInfo;
    paramActionInfo = (String)this.actionInfo.parameters.get("regexp");
    if (paramActionInfo != null) {
      this.replaceRegexp = Pattern.compile(paramActionInfo);
    }
    this.replace = ((String)this.actionInfo.parameters.get("replacement"));
    this.target = ((String)this.actionInfo.parameters.get("target"));
  }
  
  public boolean execute(FilterContext paramFilterContext)
  {
    Object localObject = null;
    paramFilterContext.commit();
    if (this.target != null)
    {
      localObject = new HashMap(this.actionInfo.parameters);
      ((Map)localObject).putAll(paramFilterContext.getContextParameters());
      ((Map)localObject).put("group_0", this.target);
      localObject = paramFilterContext.getUri().replace(this.target, ELResolver.resolve(this.replace, (Map)localObject));
    }
    for (;;)
    {
      if ((localObject != null) && (!((String)localObject).equals(paramFilterContext.getUri()))) {
        paramFilterContext.setUri((String)localObject);
      }
      return true;
      if (this.replaceRegexp != null)
      {
        localObject = this.replaceRegexp.matcher(paramFilterContext.getUri());
        StringBuffer localStringBuffer = new StringBuffer();
        while (((Matcher)localObject).find())
        {
          HashMap localHashMap = new HashMap(this.actionInfo.parameters);
          localHashMap.putAll(paramFilterContext.getContextParameters());
          int i = 0;
          int j = ((Matcher)localObject).groupCount();
          while (i <= j)
          {
            localHashMap.put("group_" + i, ((Matcher)localObject).group(i));
            i += 1;
          }
          ((Matcher)localObject).appendReplacement(localStringBuffer, ELResolver.resolve(this.replace, localHashMap));
        }
        ((Matcher)localObject).appendTail(localStringBuffer);
        localObject = localStringBuffer.toString();
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\bus\filter\impl\ReplaceAllFilterAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */