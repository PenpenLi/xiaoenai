package com.alibaba.nb.android.trade.web.interception.base.filter.a;

import android.text.TextUtils;
import com.alibaba.nb.android.trade.web.interception.base.filter.AliTradeFilterInfo.ActionInfo;
import com.alibaba.nb.android.trade.web.interception.base.filter.b;
import com.alibaba.nb.android.trade.web.interception.base.filter.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class e
  implements b
{
  private AliTradeFilterInfo.ActionInfo a;
  private Pattern b;
  private String c;
  private String d;
  private boolean e;
  private String f;
  private String g;
  
  public e(AliTradeFilterInfo.ActionInfo paramActionInfo)
  {
    String str = (String)paramActionInfo.parameters.get("regexp");
    if (str != null) {
      this.b = Pattern.compile(str);
    }
    this.c = ((String)paramActionInfo.parameters.get("key"));
    this.d = ((String)paramActionInfo.parameters.get("value"));
    this.g = ((String)paramActionInfo.parameters.get("mode"));
    this.e = "true".equals(paramActionInfo.parameters.get("cacheable"));
    this.a = paramActionInfo;
  }
  
  private Map<String, String> b(c paramc)
  {
    HashMap localHashMap = new HashMap();
    if (this.a.parameters != null) {
      localHashMap.putAll(this.a.parameters);
    }
    localHashMap.putAll(paramc.getContextParameters());
    return localHashMap;
  }
  
  public final boolean a(c paramc)
  {
    if (this.c == null) {
      return false;
    }
    Object localObject1 = paramc.getQueryParameter(this.c);
    Object localObject2;
    if (((!"addIfAbsent".equals(this.g)) && (!"update".equals(this.g))) || ((localObject1 == null) || ("append".equals(this.g)))) {
      if ("addAllParams".equals(this.c))
      {
        if (paramc.getContextParameters() != null)
        {
          localObject1 = paramc.getContextParameters().keySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            if (!TextUtils.isEmpty((CharSequence)paramc.getContextParameters().get(localObject2))) {
              paramc.b((String)localObject2, (String)paramc.getContextParameters().get(localObject2));
            }
          }
        }
      }
      else
      {
        if ((!this.e) || (this.f == null) || (TextUtils.isEmpty(this.f))) {
          break label195;
        }
        localObject1 = this.f;
        if (localObject1 != null) {
          paramc.b(this.c, (String)localObject1);
        }
      }
    }
    for (;;)
    {
      return true;
      label195:
      localObject1 = b(paramc);
      localObject2 = com.alibaba.nb.android.trade.web.interception.base.a.a(this.d, (Map)localObject1);
      localObject1 = localObject2;
      if (!this.e) {
        break;
      }
      this.f = ((String)localObject2);
      localObject1 = localObject2;
      break;
      if ((("replace".equals(this.g)) || ("update".equals(this.g))) && (localObject1 != null))
      {
        if ((this.e) && (this.f != null)) {
          localObject1 = this.f;
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label417;
          }
          paramc.a(this.c, (String)localObject1);
          break;
          localObject2 = b(paramc);
          if (this.b != null)
          {
            Matcher localMatcher = this.b.matcher((CharSequence)localObject1);
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
          localObject2 = com.alibaba.nb.android.trade.web.interception.base.a.a(this.d, (Map)localObject2);
          localObject1 = localObject2;
          if (this.e)
          {
            this.f = ((String)localObject2);
            localObject1 = localObject2;
          }
        }
      }
      else
      {
        label417:
        if ("delete".equals(this.g)) {
          paramc.a(this.c);
        } else {
          com.alibaba.nb.android.trade.utils.d.a.a("ui", "ignore the action " + this.g + " key " + this.c);
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\web\interception\base\filter\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */