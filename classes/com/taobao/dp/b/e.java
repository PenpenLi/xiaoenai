package com.taobao.dp.b;

import org.json.JSONException;
import org.json.JSONObject;

final class e
  implements i
{
  e(c paramc, String paramString) {}
  
  public final void a(com.taobao.dp.bean.c paramc)
  {
    if (paramc.a() == 200)
    {
      c.d(this.b).b(this.a, c.a(this.b), c.b(this.b));
      paramc = paramc.b();
    }
    try
    {
      paramc = new JSONObject(paramc);
      String str1 = paramc.getString("uuid");
      String str2 = paramc.getString("exactid");
      if ((str1 != null) && (str1.length() > 0) && (str2 != null) && (str2.length() > 0))
      {
        c.a(this.b, com.taobao.dp.http.c.c, str1, str2);
        c.d(this.b).a(str1, c.a(this.b), c.b(this.b), c.c(this.b));
        c.d(this.b).a(str2, c.c(this.b));
      }
      return;
    }
    catch (Exception paramc)
    {
      try
      {
        str1 = paramc.getString("appListVer");
        paramc = paramc.getString("appList");
        if ((str1 != null) && (str1.length() > 0) && (paramc != null) && (paramc.length() > 0))
        {
          paramc = new b.a(str1, paramc);
          c.d(this.b);
          b.a(paramc, c.a(this.b), c.b(this.b), c.e(this.b), c.c(this.b));
        }
        return;
      }
      catch (JSONException paramc) {}
      paramc = paramc;
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\dp\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */