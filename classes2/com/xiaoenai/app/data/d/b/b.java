package com.xiaoenai.app.data.d.b;

import com.xiaoenai.app.data.entity.album.AlbumEntity;
import com.xiaoenai.app.net.http.base.a.c.a;
import java.util.HashMap;
import java.util.Map;
import rx.a.a;
import rx.k;

class b
  implements a.a<AlbumEntity>
{
  b(a parama, String paramString1, String paramString2) {}
  
  public void a(k<? super AlbumEntity> paramk)
  {
    paramk.b();
    paramk = new c(this, a.a(this.c), paramk);
    HashMap localHashMap = new HashMap();
    localHashMap.put("offset", this.a);
    localHashMap.put("limit", this.b);
    a.c(this.c).a(a.b(this.c)).a(paramk).b("GET").c("application/json; charset=utf-8").a(localHashMap).c().a(a.d(this.c));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\d\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */