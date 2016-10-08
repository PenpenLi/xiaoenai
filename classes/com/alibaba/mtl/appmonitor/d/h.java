package com.alibaba.mtl.appmonitor.d;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.f.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class h
  extends a<JSONObject>
{
  private f e;
  protected Map<String, i> o;
  protected int q = -1;
  
  public h(f paramf, int paramInt)
  {
    super(paramInt);
    this.e = paramf;
    this.o = Collections.synchronizedMap(new HashMap());
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    if (this.o != null)
    {
      paramString1 = (i)this.o.get(paramString1);
      if (paramString1 != null) {
        return paramString1.a(paramInt, paramString2, paramMap);
      }
    }
    return paramInt < this.n;
  }
  
  public void b(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
    c(paramJSONObject);
    this.o.clear();
    JSONArray localJSONArray = paramJSONObject.getJSONArray("metrics");
    if (localJSONArray != null)
    {
      int i = 0;
      while (i < localJSONArray.size())
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        String str = localJSONObject.getString("module");
        if (b.d(str))
        {
          i locali = (i)this.o.get(str);
          paramJSONObject = locali;
          if (locali == null)
          {
            paramJSONObject = new i(str, this.n);
            this.o.put(str, paramJSONObject);
          }
          paramJSONObject.b(localJSONObject);
        }
        i += 1;
      }
    }
  }
  
  protected void c(JSONObject paramJSONObject)
  {
    com.alibaba.mtl.log.e.i.a("EventTypeSampling", new Object[] { "[updateEventTypeTriggerCount]", this, paramJSONObject });
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      try
      {
        int i = paramJSONObject.getIntValue("cacheCount");
        if ((i > 0) && (this.e != null))
        {
          this.e.b(i);
          return;
        }
      }
      catch (Throwable paramJSONObject)
      {
        com.alibaba.mtl.log.e.i.a("EventTypeSampling", "updateTriggerCount", paramJSONObject);
      }
    }
  }
  
  public void setSampling(int paramInt)
  {
    this.n = paramInt;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\d\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */