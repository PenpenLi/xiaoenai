package com.xiaoenai.app.data.d.d;

import android.content.Context;
import com.xiaoenai.app.net.http.base.e;
import org.json.JSONObject;
import rx.k;

class d
  extends com.xiaoenai.app.net.http.base.b.c
{
  d(c paramc, Context paramContext, k paramk)
  {
    super(paramContext);
  }
  
  public void a(e parame)
  {
    super.a(parame);
    this.a.a(new com.xiaoenai.app.data.c.a(a.a(this.b.a, parame)));
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    if (paramJSONObject != null)
    {
      if (paramJSONObject.has("upload_token"))
      {
        this.a.a(paramJSONObject.optString("upload_token"));
        this.a.a();
        com.xiaoenai.app.utils.f.a.c("upload_token:" + paramJSONObject.optString("upload_token"), new Object[0]);
        return;
      }
      this.a.a(new com.xiaoenai.app.data.c.a(paramJSONObject.toString()));
      return;
    }
    this.a.a(new com.xiaoenai.app.data.c.a());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\d\d\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */