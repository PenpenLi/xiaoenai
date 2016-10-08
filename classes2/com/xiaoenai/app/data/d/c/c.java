package com.xiaoenai.app.data.d.c;

import android.content.Context;
import com.xiaoenai.app.net.http.base.e;
import org.json.JSONObject;
import rx.k;

class c
  extends com.xiaoenai.app.net.http.base.b.c
{
  c(b paramb, Context paramContext, k paramk)
  {
    super(paramContext);
  }
  
  public void a(e parame)
  {
    super.a(parame);
    this.a.a(new com.xiaoenai.app.data.c.a(a.a(this.b.b, parame)));
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    if (paramJSONObject != null)
    {
      com.xiaoenai.app.utils.f.a.c("LogUpload{}", new Object[] { paramJSONObject.toString() });
      this.a.a(paramJSONObject.optString("result"));
    }
    this.a.a();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\d\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */