package com.xiaoenai.app.data.d.b;

import com.xiaoenai.app.data.entity.album.AlbumGroupEntity;
import com.xiaoenai.app.net.http.base.a.c;
import com.xiaoenai.app.net.http.base.a.c.a;
import java.util.HashMap;
import java.util.Map;
import rx.a.a;
import rx.k;

class f
  implements a.a<AlbumGroupEntity>
{
  f(a parama, String paramString1, String paramString2) {}
  
  public void a(k<? super AlbumGroupEntity> paramk)
  {
    paramk.b();
    paramk = new g(this, a.i(this.c), paramk);
    HashMap localHashMap = new HashMap();
    localHashMap.put("feeling", this.a);
    localHashMap.put("image_groups", this.b);
    a.l(this.c).a(a.k(this.c)).a(paramk).b("POST").c("application/json; charset=utf-8").a(localHashMap).c().a(a.m(this.c));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\d\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */