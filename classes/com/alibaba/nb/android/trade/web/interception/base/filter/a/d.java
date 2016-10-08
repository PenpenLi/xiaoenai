package com.alibaba.nb.android.trade.web.interception.base.filter.a;

import com.alibaba.nb.android.trade.web.interception.base.filter.AliTradeFilterInfo.ActionInfo;
import com.alibaba.nb.android.trade.web.interception.base.filter.b;
import com.alibaba.nb.android.trade.web.interception.base.filter.c;
import java.util.Map;

public final class d
  implements b
{
  private AliTradeFilterInfo.ActionInfo a;
  
  public d(AliTradeFilterInfo.ActionInfo paramActionInfo)
  {
    this.a = paramActionInfo;
  }
  
  public final boolean a(c paramc)
  {
    Object localObject = this.a.parameters;
    String str = (String)((Map)localObject).get("key");
    localObject = (String)((Map)localObject).get("value");
    if ((str == null) || (localObject == null)) {
      return true;
    }
    paramc.setContextParameter(str, (String)localObject);
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\web\interception\base\filter\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */