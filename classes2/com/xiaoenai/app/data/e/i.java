package com.xiaoenai.app.data.e;

import com.xiaoenai.app.data.e.a.c.j;
import com.xiaoenai.app.data.e.a.c.l;
import com.xiaoenai.app.domain.PhotoAlbum;
import com.xiaoenai.app.utils.f.a;
import java.util.List;
import rx.k;

class i
  extends k<List<PhotoAlbum>>
{
  i(g paramg, int paramInt, k paramk) {}
  
  public void a() {}
  
  public void a(Throwable paramThrowable)
  {
    this.b.a(paramThrowable);
  }
  
  public void a(List<PhotoAlbum> paramList)
  {
    j localj = g.a(this.c).b();
    if (this.a == 0) {
      localj.b();
    }
    localj.a(paramList);
    this.b.a(paramList);
    this.b.a();
    a.c("subscriber: {} {} ", new Object[] { this.b, paramList });
  }
  
  public void b()
  {
    super.b();
    if (this.a == 0)
    {
      List localList = g.a(this.c).b().a();
      g.a(this.c, localList.size());
      if (g.b(this.c) > 0)
      {
        this.b.a(localList);
        a.c("subscriber: {}", new Object[] { this.b });
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\e\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */