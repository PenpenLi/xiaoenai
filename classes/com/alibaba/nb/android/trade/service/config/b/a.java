package com.alibaba.nb.android.trade.service.config.b;

import android.content.Context;
import com.alibaba.nb.android.trade.AliTradeContext;
import com.alibaba.nb.android.trade.constants.AliTradeConfigConstant;
import com.alibaba.nb.android.trade.service.config.a.d;
import com.alibaba.nb.android.trade.utils.e;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class a
{
  private String a = AliTradeConfigConstant.getConfigUrl();
  private Context b;
  private a c;
  private final long d = 5000000L;
  
  public a(Context paramContext, a parama)
  {
    this.b = paramContext;
    this.c = parama;
    this.a = AliTradeConfigConstant.getConfigUrl();
  }
  
  private static String b(d paramd)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator1 = paramd.a.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      localStringBuilder.append((String)localObject);
      localObject = (Map)paramd.a.get(localObject);
      Iterator localIterator2 = ((Map)localObject).keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        localStringBuilder.append(str).append((String)((Map)localObject).get(str));
      }
    }
    try
    {
      localStringBuilder.append("ALITRADE20160628");
      paramd = localStringBuilder.toString().toCharArray();
      Arrays.sort(paramd);
      paramd = com.alibaba.nb.android.trade.utils.b.a.a(new String(paramd).getBytes("UTF-8"));
      return paramd;
    }
    catch (UnsupportedEncodingException paramd)
    {
      com.alibaba.nb.android.trade.utils.d.a.d("AliTradeConfigPullProcessor", "生成摘要错误" + paramd.getMessage());
    }
    return null;
  }
  
  public final void a()
  {
    com.alibaba.nb.android.trade.utils.d.a.b("AliTradeConfigPullProcessor", "开启拉取网络配置");
    if (com.alibaba.nb.android.trade.utils.e.a.a(this.b))
    {
      AliTradeContext.executorService.c(new b(this));
      return;
    }
    a locala = this.c;
    com.alibaba.nb.android.trade.utils.d.a.a("AliTradeConfigPullProcessor", "没有网络，无法拉取config配置");
  }
  
  public static abstract interface a
  {
    public abstract void a(d paramd);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\service\config\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */