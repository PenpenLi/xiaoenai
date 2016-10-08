package com.taobao.dp.b;

import org.json.JSONException;
import org.json.JSONObject;

final class f
  implements i
{
  f(c paramc, String paramString) {}
  
  public final void a(com.taobao.dp.bean.c paramc)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramc.a() == 200) {
      localObject2 = paramc.b();
    }
    try
    {
      localObject2 = new JSONObject((String)localObject2).getString("uuid");
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
    localObject2 = localObject1;
    if (localObject1 != null)
    {
      c.a(this.b, com.taobao.dp.http.c.b, (String)localObject1, this.a);
      c.d(this.b).a((String)localObject1, c.a(this.b), c.b(this.b), c.c(this.b));
      c.f(this.b).onInitFinished(this.b, paramc.a());
      localObject2 = localObject1;
    }
    if (localObject2 == null) {
      c.a(this.b, this.a);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\dp\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */