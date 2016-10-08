package com.alibaba.nb.android.trade.web.interception.base.filter.a;

import com.alibaba.nb.android.trade.web.interception.base.filter.AliTradeFilterInfo;
import com.alibaba.nb.android.trade.web.interception.base.filter.AliTradeFilterInfo.ActionInfo;
import com.alibaba.nb.android.trade.web.interception.base.filter.a;
import com.alibaba.nb.android.trade.web.interception.base.filter.b;
import com.alibaba.nb.android.trade.web.interception.base.filter.c;
import com.alibaba.nb.android.trade.web.interception.base.handler.AliTradeMatchInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public final class f
  implements a
{
  private AliTradeFilterInfo a;
  private List<b> b;
  
  public f(AliTradeFilterInfo paramAliTradeFilterInfo)
  {
    this.a = paramAliTradeFilterInfo;
    if ((paramAliTradeFilterInfo.actionInfos == null) || (paramAliTradeFilterInfo.actionInfos.size() == 0)) {
      this.b = Collections.emptyList();
    }
    for (;;)
    {
      return;
      this.b = new ArrayList(paramAliTradeFilterInfo.actionInfos.size());
      paramAliTradeFilterInfo = paramAliTradeFilterInfo.actionInfos.values().iterator();
      while (paramAliTradeFilterInfo.hasNext())
      {
        b localb = ((AliTradeFilterInfo.ActionInfo)paramAliTradeFilterInfo.next()).createAction();
        if (localb != null) {
          this.b.add(localb);
        }
      }
    }
  }
  
  public final AliTradeFilterInfo a()
  {
    return this.a;
  }
  
  public final boolean a(c paramc)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (this.a.matchInfos != null)
    {
      if (this.b.size() != 0) {
        break label36;
      }
      bool2 = bool1;
    }
    label36:
    Iterator localIterator;
    do
    {
      return bool2;
      localIterator = this.a.matchInfos.values().iterator();
      do
      {
        bool2 = bool1;
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!((AliTradeMatchInfo)localIterator.next()).isMatch(paramc));
      localIterator = this.b.iterator();
      bool1 = bool3;
      bool2 = bool1;
    } while (!localIterator.hasNext());
    if (((b)localIterator.next()).a(paramc)) {
      bool1 = true;
    }
    for (;;)
    {
      break;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\web\interception\base\filter\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */