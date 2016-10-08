package com.alibaba.nb.android.trade.service.config.a;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class b
{
  private static final String c = b.class.getSimpleName();
  private Map<String, Map<String, Object>> a = new HashMap();
  private Set<String> b = new HashSet();
  
  public final void a(a parama)
  {
    for (;;)
    {
      try
      {
        localObject1 = parama.a();
        localObject2 = c;
        Object localObject3 = new StringBuilder("config更新，config更新的参数值为:");
        if (localObject1 != null)
        {
          parama = (a)localObject1;
          localObject3 = ((StringBuilder)localObject3).append(parama).append("   configMem当前值=");
          if (this.a == null) {
            break label238;
          }
          parama = this.a;
          localObject3 = ((StringBuilder)localObject3).append(parama).append("   filter名单=");
          if (this.b == null) {
            break label243;
          }
          parama = this.b.toString();
          com.alibaba.nb.android.trade.utils.d.a.b((String)localObject2, parama);
          if (localObject1 == null) {
            break;
          }
          parama = ((Map)localObject1).keySet().iterator();
          if (!parama.hasNext()) {
            break;
          }
          localObject2 = (String)parama.next();
          localObject3 = ((Map)((Map)localObject1).get(localObject2)).entrySet().iterator();
          if (((Iterator)localObject3).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
            if ((this.b.contains(localEntry.getKey())) && (((String)localObject2).equals("albbTradeConfig"))) {
              continue;
            }
            a((String)localObject2, (String)localEntry.getKey(), localEntry.getValue());
            continue;
          }
          continue;
        }
        parama = null;
      }
      finally {}
      continue;
      label238:
      parama = null;
      continue;
      label243:
      parama = null;
    }
    Object localObject1 = c;
    Object localObject2 = new StringBuilder("更新后configMemdo=");
    if (this.a != null) {}
    for (parama = this.a.toString();; parama = null)
    {
      com.alibaba.nb.android.trade.utils.d.a.b((String)localObject1, parama);
      return;
    }
  }
  
  public final void a(String paramString)
  {
    try
    {
      this.b.add(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void a(String paramString1, String paramString2, Object paramObject)
  {
    try
    {
      Map localMap = (Map)this.a.get(paramString1);
      Object localObject = localMap;
      if (localMap == null)
      {
        localObject = new HashMap();
        this.a.put(paramString1, localObject);
      }
      ((Map)localObject).put(paramString2, paramObject);
      return;
    }
    finally {}
  }
  
  public final Object b(String paramString1, String paramString2, Object paramObject)
  {
    try
    {
      Map localMap = (Map)this.a.get(paramString1);
      paramString1 = (String)paramObject;
      if (localMap != null)
      {
        paramString1 = (String)paramObject;
        if (localMap.get(paramString2) != null) {
          paramString1 = localMap.get(paramString2);
        }
      }
      return paramString1;
    }
    finally {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\service\config\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */