package com.alibaba.mtl.appmonitor.d;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class c
  extends a<JSONObject>
{
  private Map<String, b> n = new HashMap();
  
  public c(int paramInt)
  {
    super(paramInt);
  }
  
  public Boolean a(int paramInt, Map<String, String> paramMap)
  {
    if ((paramMap == null) || (this.n == null)) {
      return null;
    }
    Iterator localIterator = this.n.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!((b)this.n.get(str)).b((String)paramMap.get(str))) {
        return null;
      }
    }
    return Boolean.valueOf(a(paramInt));
  }
  
  public void b(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
    paramJSONObject = paramJSONObject.getJSONArray("dimensions");
    if (paramJSONObject != null)
    {
      int i = 0;
      while (i < paramJSONObject.size())
      {
        Iterator localIterator = paramJSONObject.getJSONObject(i).entrySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject3 = (Map.Entry)localIterator.next();
          Object localObject1 = (JSONObject)((Map.Entry)localObject3).getValue();
          Object localObject2 = ((JSONObject)localObject1).getString("values");
          if (com.alibaba.mtl.appmonitor.f.b.d((String)localObject2))
          {
            localObject2 = (HashSet)JSON.parseObject((String)localObject2, HashSet.class);
            localObject3 = (String)((Map.Entry)localObject3).getKey();
            localObject1 = ((JSONObject)localObject1).getInteger("include");
            if ((com.alibaba.mtl.appmonitor.f.b.d((String)localObject3)) && (!((HashSet)localObject2).isEmpty()) && (localObject1 != null))
            {
              localObject1 = new b((String)localObject3, (Set)localObject2, ((Integer)localObject1).intValue());
              this.n.put(((b)localObject1).getName(), localObject1);
            }
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */