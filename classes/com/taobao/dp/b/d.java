package com.taobao.dp.b;

import org.json.JSONException;
import org.json.JSONObject;

final class d
  implements i
{
  d(c paramc) {}
  
  public final void a(com.taobao.dp.bean.c paramc)
  {
    Object localObject;
    if (paramc.a() == 200) {
      localObject = paramc.b();
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        str1 = ((JSONObject)localObject).getString("uuid");
        String str2 = ((JSONObject)localObject).getString("exactid");
        if ((str1 != null) && (str1.length() > 0) && (str2 != null) && (str2.length() > 0))
        {
          c.a(this.a, com.taobao.dp.http.c.a, str1, str2);
          c.d(this.a).a(str1, c.a(this.a), c.b(this.a), c.c(this.a));
          c.d(this.a).a(str2, c.c(this.a));
        }
      }
      catch (JSONException localJSONException1)
      {
        String str1;
        continue;
      }
      try
      {
        str1 = ((JSONObject)localObject).getString("appListVer");
        localObject = ((JSONObject)localObject).getString("appList");
        if ((str1 != null) && (str1.length() > 0) && (localObject != null) && (((String)localObject).length() > 0))
        {
          localObject = new b.a(str1, (String)localObject);
          c.d(this.a);
          b.a((b.a)localObject, c.a(this.a), c.b(this.a), c.e(this.a), c.c(this.a));
        }
      }
      catch (JSONException localJSONException2) {}
    }
    c.f(this.a).onInitFinished(this.a, paramc.a());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\dp\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */