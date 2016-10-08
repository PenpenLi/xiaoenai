package com.alibaba.nb.android.trade.service.config.a;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class d
  implements a
{
  public static final String b = d.class.getSimpleName();
  public Map<String, Map<String, String>> a = new HashMap();
  private Map<String, String> c;
  
  public final Map<String, Map<String, String>> a()
  {
    return this.a;
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    for (;;)
    {
      HashMap localHashMap;
      String str1;
      try
      {
        Iterator localIterator1 = paramJSONObject.keys();
        if (localIterator1.hasNext())
        {
          localHashMap = new HashMap();
          str1 = (String)localIterator1.next();
          JSONObject localJSONObject = paramJSONObject.getJSONObject(str1);
          Iterator localIterator2 = localJSONObject.keys();
          if (localIterator2.hasNext())
          {
            String str2 = (String)localIterator2.next();
            localHashMap.put(str2, localJSONObject.getString(str2));
            continue;
          }
        }
        else
        {
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        com.alibaba.nb.android.trade.utils.d.a.d(b, "json转换为map失败");
        paramJSONObject.printStackTrace();
      }
      this.a.put(str1, localHashMap);
    }
  }
  
  public final boolean b()
  {
    if (this.a != null)
    {
      this.c = ((Map)this.a.get("group0"));
      if (this.c != null) {
        this.a.remove("group0");
      }
      return true;
    }
    return false;
  }
  
  public final void c()
  {
    if ((this.c != null) && (this.a != null)) {
      this.a.put("group0", this.c);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\service\config\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */