package com.alibaba.mtl.appmonitor.d;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class j
  extends a<JSONObject>
{
  protected List<c> e;
  private String p;
  
  public j(String paramString, int paramInt)
  {
    super(paramInt);
    this.p = paramString;
  }
  
  public boolean a(int paramInt, Map<String, String> paramMap)
  {
    if ((this.e != null) && (paramMap != null))
    {
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext())
      {
        Boolean localBoolean = ((c)localIterator.next()).a(paramInt, paramMap);
        if (localBoolean != null) {
          return localBoolean.booleanValue();
        }
      }
    }
    return a(paramInt);
  }
  
  public void b(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
    paramJSONObject = paramJSONObject.getJSONArray("extra");
    if (paramJSONObject != null)
    {
      int i = 0;
      while (i < paramJSONObject.size())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        c localc = new c(this.n);
        if (this.e == null) {
          this.e = new ArrayList();
        }
        this.e.add(localc);
        localc.b(localJSONObject);
        i += 1;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\d\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */