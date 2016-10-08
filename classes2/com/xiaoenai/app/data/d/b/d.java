package com.xiaoenai.app.data.d.b;

import com.xiaoenai.app.data.entity.album.AlbumCapacityEntity;
import com.xiaoenai.app.net.http.base.a.c;
import com.xiaoenai.app.net.http.base.a.c.a;
import java.util.HashMap;
import java.util.Map;
import rx.a.a;
import rx.k;

class d
  implements a.a<AlbumCapacityEntity>
{
  d(a parama, String paramString1, String paramString2) {}
  
  public void a(k<? super AlbumCapacityEntity> paramk)
  {
    paramk.b();
    paramk = new e(this, a.e(this.c), paramk);
    HashMap localHashMap = new HashMap();
    localHashMap.put("ids", this.a);
    localHashMap.put("group_ids", this.b);
    com.xiaoenai.app.utils.f.a.c("Params ids:" + this.a + " group_ids:" + this.b, new Object[0]);
    a.g(this.c).a(a.f(this.c)).a(paramk).b("POST").c("application/json; charset=utf-8").a(localHashMap).c().a(a.h(this.c));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\d\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */