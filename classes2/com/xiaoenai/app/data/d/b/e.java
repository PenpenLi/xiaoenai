package com.xiaoenai.app.data.d.b;

import android.content.Context;
import com.google.gson.j;
import com.xiaoenai.app.data.entity.album.AlbumCapacityEntity;
import com.xiaoenai.app.net.http.base.b.c;
import org.json.JSONObject;
import rx.k;

class e
  extends c
{
  e(d paramd, Context paramContext, k paramk)
  {
    super(paramContext);
  }
  
  public void a(com.xiaoenai.app.net.http.base.e parame)
  {
    super.a(parame);
    this.a.a(new com.xiaoenai.app.data.c.a(a.b(this.b.c, parame)));
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    if (paramJSONObject != null) {
      com.xiaoenai.app.utils.f.a.c("delPhoto:" + paramJSONObject.toString(), new Object[0]);
    }
    paramJSONObject = com.xiaoenai.app.utils.b.a.b(paramJSONObject);
    if (paramJSONObject != null)
    {
      if (a.c(this.b.c, paramJSONObject))
      {
        paramJSONObject = (AlbumCapacityEntity)new j().a(paramJSONObject.optJSONObject("data").toString(), AlbumCapacityEntity.class);
        a.a(this.b.c, paramJSONObject.getUsed());
        this.a.a(paramJSONObject);
        this.a.a();
      }
      while (!paramJSONObject.has("error")) {
        return;
      }
      this.a.a(new com.xiaoenai.app.data.c.a(a.d(this.b.c, paramJSONObject)));
      return;
    }
    this.a.a(new com.xiaoenai.app.data.c.a());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\d\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */