package com.xiaoenai.app.utils;

import android.content.Context;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.e.b;
import com.xiaoenai.app.utils.f.a;
import org.json.JSONObject;

class h
  extends m
{
  h(g paramg, Context paramContext1, g.a parama, String paramString, Context paramContext2, int paramInt)
  {
    super(paramContext1);
  }
  
  public void a()
  {
    this.a.a();
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.a.a(paramInt);
  }
  
  public void a(k paramk)
  {
    super.a(paramk);
    this.a.a(paramk);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    String str = Xiaoenai.b(paramJSONObject.getString("url"));
    int i = paramJSONObject.getInt("width");
    int j = paramJSONObject.getInt("height");
    a.c("url = {} {}", new Object[] { str, this.b });
    b.b(str, this.b);
    g.a(this.e, str, i, j, paramJSONObject.getString("key"), this.c, this.a, this.d);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */