package com.alibaba.nb.android.trade.web.interception.base.filter.a;

import com.alibaba.nb.android.trade.web.interception.base.a;
import com.alibaba.nb.android.trade.web.interception.base.filter.AliTradeFilterInfo.ActionInfo;
import com.alibaba.nb.android.trade.web.interception.base.filter.b;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c
  implements b
{
  private AliTradeFilterInfo.ActionInfo a;
  private Pattern b;
  private String c;
  private String d;
  
  public c(AliTradeFilterInfo.ActionInfo paramActionInfo)
  {
    this.a = paramActionInfo;
    paramActionInfo = (String)this.a.parameters.get("regexp");
    if (paramActionInfo != null) {
      this.b = Pattern.compile(paramActionInfo);
    }
    this.d = ((String)this.a.parameters.get("replacement"));
    this.c = ((String)this.a.parameters.get("target"));
  }
  
  public final boolean a(com.alibaba.nb.android.trade.web.interception.base.filter.c paramc)
  {
    Object localObject = null;
    paramc.a();
    if (this.c != null)
    {
      localObject = new HashMap(this.a.parameters);
      ((Map)localObject).putAll(paramc.getContextParameters());
      ((Map)localObject).put("group_0", this.c);
      localObject = paramc.getUri().replace(this.c, a.a(this.d, (Map)localObject));
    }
    for (;;)
    {
      if ((localObject != null) && (!((String)localObject).equals(paramc.getUri()))) {
        paramc.setUri((String)localObject);
      }
      return true;
      if (this.b != null)
      {
        localObject = this.b.matcher(paramc.getUri());
        StringBuffer localStringBuffer = new StringBuffer();
        while (((Matcher)localObject).find())
        {
          HashMap localHashMap = new HashMap(this.a.parameters);
          localHashMap.putAll(paramc.getContextParameters());
          int i = 0;
          int j = ((Matcher)localObject).groupCount();
          while (i <= j)
          {
            localHashMap.put("group_" + i, ((Matcher)localObject).group(i));
            i += 1;
          }
          ((Matcher)localObject).appendReplacement(localStringBuffer, a.a(this.d, localHashMap));
        }
        ((Matcher)localObject).appendTail(localStringBuffer);
        localObject = localStringBuffer.toString();
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\web\interception\base\filter\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */