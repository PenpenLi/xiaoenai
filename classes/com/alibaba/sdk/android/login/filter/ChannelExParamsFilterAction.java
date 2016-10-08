package com.alibaba.sdk.android.login.filter;

import android.text.TextUtils;
import com.alibaba.sdk.android.el.ELResolver;
import com.alibaba.sdk.android.login.LoginConfigs;
import com.alibaba.sdk.android.login.impl.LoginContext;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.ui.bus.filter.FilterAction;
import com.alibaba.sdk.android.ui.bus.filter.FilterContext;
import com.alibaba.sdk.android.ui.bus.filter.FilterInfo.ActionInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class ChannelExParamsFilterAction
  implements FilterAction
{
  private static final String DEFAULT_LOGIN_CHANNEL = "loginChannel";
  private FilterInfo.ActionInfo actionInfo;
  
  public ChannelExParamsFilterAction(FilterInfo.ActionInfo paramActionInfo)
  {
    this.actionInfo = paramActionInfo;
  }
  
  public boolean execute(FilterContext paramFilterContext)
  {
    Object localObject1 = paramFilterContext.getQueryParameter("exParams");
    JSONObject localJSONObject;
    if (localObject1 == null) {
      try
      {
        localJSONObject = new JSONObject();
        Iterator localIterator = this.actionInfo.parameters.entrySet().iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject1 = (Map.Entry)localIterator.next();
            String str = (String)((Map.Entry)localObject1).getKey();
            localObject1 = (String)((Map.Entry)localObject1).getValue();
            if (!localJSONObject.has(str)) {
              if ("loginChannel".equals(localObject1))
              {
                localObject1 = LoginContext.loginChannel;
                label102:
                if (localObject1 == null) {
                  continue;
                }
                localJSONObject.put(str, localObject1);
                continue;
                return true;
              }
            }
          }
        }
      }
      catch (Exception paramFilterContext)
      {
        AliSDKLogger.e("ui", "fail to update trade channel exparams", paramFilterContext);
      }
    }
    for (;;)
    {
      localJSONObject = new JSONObject((String)localObject1);
      break;
      if ("isv_code".equals(localObject1))
      {
        localObject2 = paramFilterContext.getContextParameter("isv_code");
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label102;
        }
        localObject1 = localObject2;
        if (LoginConfigs.defaultISVCode == null) {
          break label102;
        }
        localObject1 = LoginConfigs.defaultISVCode;
        break label102;
      }
      Object localObject2 = new HashMap();
      ((Map)localObject2).putAll(paramFilterContext.getContextParameters());
      ((Map)localObject2).putAll(this.actionInfo.parameters);
      localObject1 = ELResolver.resolve((String)localObject1, (Map)localObject2);
      break label102;
      paramFilterContext.updateQueryParameter("exParams", localJSONObject.toString());
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\filter\ChannelExParamsFilterAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */