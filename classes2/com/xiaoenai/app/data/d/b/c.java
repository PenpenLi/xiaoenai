package com.xiaoenai.app.data.d.b;

import android.content.Context;
import com.google.gson.j;
import com.xiaoenai.app.data.entity.album.AlbumCapacityEntity;
import com.xiaoenai.app.data.entity.album.AlbumEntity;
import com.xiaoenai.app.net.http.base.e;
import java.util.ArrayList;
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
    this.a.a(new com.xiaoenai.app.data.c.a(a.a(this.b.c, parame)));
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    if (paramJSONObject != null) {
      com.xiaoenai.app.utils.f.a.c("getAlbum:" + paramJSONObject.toString(), new Object[0]);
    }
    if (paramJSONObject != null)
    {
      if (a.a(this.b.c, paramJSONObject))
      {
        paramJSONObject = (AlbumEntity)new j().a(paramJSONObject.optJSONObject("data").toString(), AlbumEntity.class);
        a.a(this.b.c, paramJSONObject.getCapacityInfo().getUsed());
        a.b(this.b.c, Integer.valueOf(this.b.a).intValue() + paramJSONObject.getTimeLines().size());
        this.a.a(paramJSONObject);
        this.a.a();
      }
      while (!paramJSONObject.has("error")) {
        return;
      }
      this.a.a(new com.xiaoenai.app.data.c.a(a.b(this.b.c, paramJSONObject)));
      return;
    }
    this.a.a(new com.xiaoenai.app.data.c.a());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\d\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */