package com.alibaba.mtl.appmonitor.a;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.mtl.appmonitor.c.e;
import com.alibaba.mtl.appmonitor.f.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a
  extends d
{
  public Map<String, String> d;
  public Map<String, Integer> e;
  public int f = 0;
  public int g = 0;
  
  public JSONObject a()
  {
    try
    {
      JSONObject localJSONObject1 = super.a();
      localJSONObject1.put("successCount", Integer.valueOf(this.f));
      localJSONObject1.put("failCount", Integer.valueOf(this.g));
      if (this.e != null)
      {
        JSONArray localJSONArray = (JSONArray)com.alibaba.mtl.appmonitor.c.a.a().a(com.alibaba.mtl.appmonitor.c.d.class, new Object[0]);
        Iterator localIterator = this.e.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          JSONObject localJSONObject3 = (JSONObject)com.alibaba.mtl.appmonitor.c.a.a().a(e.class, new Object[0]);
          String str = (String)localEntry.getKey();
          localJSONObject3.put("errorCode", str);
          localJSONObject3.put("errorCount", localEntry.getValue());
          if (this.d.containsKey(str)) {
            localJSONObject3.put("errorMsg", this.d.get(str));
          }
          localJSONArray.add(localJSONObject3);
        }
        localJSONObject2.put("errors", localJSONArray);
      }
    }
    finally {}
    return localJSONObject2;
  }
  
  public void a(String paramString1, String paramString2)
  {
    int i = 100;
    for (;;)
    {
      try
      {
        boolean bool = b.isBlank(paramString1);
        if (bool) {
          return;
        }
        if (this.d == null) {
          this.d = new HashMap();
        }
        if (this.e == null) {
          this.e = new HashMap();
        }
        if (b.d(paramString2))
        {
          if (paramString2.length() > 100)
          {
            paramString2 = paramString2.substring(0, i);
            this.d.put(paramString1, paramString2);
          }
        }
        else
        {
          if (this.e.containsKey(paramString1)) {
            break label134;
          }
          this.e.put(paramString1, Integer.valueOf(1));
          continue;
        }
        i = paramString2.length();
      }
      finally {}
      continue;
      label134:
      this.e.put(paramString1, Integer.valueOf(((Integer)this.e.get(paramString1)).intValue() + 1));
    }
  }
  
  public void clean()
  {
    try
    {
      super.clean();
      this.f = 0;
      this.g = 0;
      if (this.d != null) {
        this.d.clear();
      }
      if (this.e != null) {
        this.e.clear();
      }
      return;
    }
    finally {}
  }
  
  public void f()
  {
    try
    {
      this.f += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void g()
  {
    try
    {
      this.g += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */