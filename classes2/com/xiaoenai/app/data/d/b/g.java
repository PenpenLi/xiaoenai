package com.xiaoenai.app.data.d.b;

import android.content.Context;
import com.google.gson.j;
import com.xiaoenai.app.data.entity.album.AlbumGroupEntity;
import com.xiaoenai.app.net.http.base.b.c;
import com.xiaoenai.app.net.http.base.e;
import java.util.ArrayList;
import org.json.JSONObject;
import rx.k;

class g
  extends c
{
  g(f paramf, Context paramContext, k paramk)
  {
    super(paramContext);
  }
  
  public void a(e parame)
  {
    super.a(parame);
    this.a.a(new com.xiaoenai.app.data.c.a(a.c(this.b.c, parame)));
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    if (paramJSONObject != null) {
      com.xiaoenai.app.utils.f.a.c("addPhoto:" + paramJSONObject.toString(), new Object[0]);
    }
    paramJSONObject = com.xiaoenai.app.utils.b.a.b(paramJSONObject);
    if (paramJSONObject != null)
    {
      if (a.e(this.b.c, paramJSONObject))
      {
        paramJSONObject = (AlbumGroupEntity)new j().a(paramJSONObject.optJSONObject("data").toString(), AlbumGroupEntity.class);
        a.a(this.b.c, a.j(this.b.c) + paramJSONObject.getAlbumImageEntity().size());
        this.a.a(paramJSONObject);
        this.a.a();
      }
      while (!paramJSONObject.has("error")) {
        return;
      }
      this.a.a(new com.xiaoenai.app.data.c.a(a.f(this.b.c, paramJSONObject)));
      return;
    }
    this.a.a(new com.xiaoenai.app.data.c.a());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\d\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */